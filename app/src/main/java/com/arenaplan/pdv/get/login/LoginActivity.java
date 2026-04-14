package com.arenaplan.pdv.get.login;

import static com.arenaplan.pdv.get.util.Constantes.ACAO_RECEBE_USUARIO_SENHA;
import static com.arenaplan.pdv.get.util.Constantes.CARREGA_PRODUTOS_POS;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_SUCESSO;
import static com.arenaplan.pdv.get.util.Constantes.ERRO_GENERICO;
import static com.arenaplan.pdv.get.util.Constantes.FORMATO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.RetrofitConfig;
import com.arenaplan.pdv.get.api.model.Produto;
import com.arenaplan.pdv.get.api.model.RepostaProdutoCard;
import com.arenaplan.pdv.get.api.model.RespostaCardLogin;
import com.arenaplan.pdv.get.database.ContadorController;
import com.arenaplan.pdv.get.database.ProdutoBancoController;
import com.arenaplan.pdv.get.database.SetUpBancoController;
import com.arenaplan.pdv.get.database.entidades.ContadorEntidade;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.arenaplan.pdv.get.database.entidades.SetUp;
import com.arenaplan.pdv.get.principal.ui.MainActivity;
import com.arenaplan.pdv.get.setup.ui.SetUpActivity;
import com.arenaplan.pdv.get.util.dialog.PopSetup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private SetUpBancoController setUpBancoController;

    ArenaplanPdvApplication mApplication;
    private boolean setUpCarregado = false;

    private EditText edSenhaAcesso;
    private EditText edUsuarioLogin;
    private Button btnLogin;
    private Button btnCancelar;
    private Button btnSetup;


    private int timeOut = 35;


    private int tipoRecibo;
    private String codigo;
    private String usuario;
    private String senha;
    private String senhaOffline;
    private String idFiscal;
    //public String ultteste;
    private RelativeLayout progressSetUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mApplication = (ArenaplanPdvApplication) getApplicationContext();

         if (getIntent().hasExtra("login")) {
            setUpCarregado = false;
            usuario = getIntent().getStringExtra("login");
            codigo = getIntent().getStringExtra("codigoMaquina");
            senhaOffline = getIntent().getStringExtra("senhaOffLine");
            tipoRecibo = getIntent().getIntExtra("tipoRecibo", 4);
            idFiscal = getIntent().getStringExtra("idFiscal");
            //ultteste="";
        }
    }

    @Override
    protected void onResume() {
        validaSetUpCarregado();
        pegaIdTela();
        informacaoLogin();
        super.onResume();
    }

    private void pegaIdTela() {

        edSenhaAcesso = findViewById(R.id.edSenhaAcesso);
        edUsuarioLogin = findViewById(R.id.edUsuarioLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancelar = findViewById(R.id.buttonCancelar);
        progressSetUp = findViewById(R.id.progress_login);
        btnSetup = findViewById(R.id.btnSetupLogin);
        //ultteste="x";


        btnLogin.setOnClickListener(v -> {

            progressSetUp.setVisibility(View.VISIBLE);

            if (edSenhaAcesso.getText().toString().isEmpty()) {

                progressSetUp.setVisibility(View.GONE);
                edSenhaAcesso.setError("Informe a Senha");
                return;
            } else {
                edSenhaAcesso.setError(null);
                senha = edSenhaAcesso.getText().toString();
            }

            executaConsultaLogin();

        });

        btnCancelar.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

        btnSetup.setOnClickListener(v ->
                popSetUp()
        );

    }

    private void executaConsultaLogin() {


        Call<RespostaCardLogin> call = new RetrofitConfig(timeOut).getPDVService().login(
                usuario,
                senha,
                codigo,
                ACAO_RECEBE_USUARIO_SENHA,
                FORMATO
        );
        /*
        call.enqueue(new Callback<RespostaCardLogin>() {
            @Override
            public void onResponse(Call<RespostaCardLogin> call, Response<RespostaCardLogin> response) {
                RespostaCardLogin login = response.body();

                validarSituacaoLogin(login.getCardLogin().getError_code());


            }

            @Override
            public void onFailure(Call<RespostaCardLogin> call, Throwable t) {
                Log.e("PDVService   ", "Erro ao buscar o login:" + t.getMessage());
                progressSetUp.setVisibility(View.GONE);
                alerta("Verifique os dados para realizar o acesso");
            }
        });*/

        call.enqueue(new Callback<RespostaCardLogin>() {
            @Override
            public void onResponse(Call<RespostaCardLogin> call, Response<RespostaCardLogin> response) {
                progressSetUp.setVisibility(View.GONE);

                if (!response.isSuccessful()) {
                    // resposta HTTP não 2xx
                    Log.e("Login", "Resposta não bem sucedida. Code: " + response.code());
                    try {
                        if (response.errorBody() != null) {
                            Log.e("Login", "Error body: " + response.errorBody().string());
                        }
                    } catch (Exception e) { /* ignorar leitura do errorBody */ }
                    alerta("Erro na autenticação. Tente novamente.");
                    return;
                }

                RespostaCardLogin login = response.body();

                if (login == null) {
                    Log.e("Login", "Response body is null");
                    alerta("Erro na resposta do servidor. Tente novamente.");
                    return;
                }

                if (login.getCardLogin() == null) {
                    Log.e("Login", "cardLogin is null in response");
                    alerta("Dados de login inválidos. Contate o suporte.");
                    return;
                }

                String codigoErro = login.getCardLogin().getError_code();
                validarSituacaoLogin(codigoErro);
            }

            @Override
            public void onFailure(Call<RespostaCardLogin> call, Throwable t) {
                Log.e("PDVService   ", "Erro ao buscar o login:" + t.getMessage());
                progressSetUp.setVisibility(View.GONE);
                alerta("Verifique os dados para realizar o acesso");
            }
        });

    }


    private void validarSituacaoLogin(String codigoErro) {

        if (CODIGO_SUCESSO.equalsIgnoreCase(codigoErro)) {

            if (!setUpCarregado) {

                Call<RepostaProdutoCard> call = new RetrofitConfig(timeOut).getPDVService().getProduto(
                        usuario,
                        senha,
                        codigo,
                        CARREGA_PRODUTOS_POS,
                        FORMATO
                );

                call.enqueue(new Callback<RepostaProdutoCard>() {
                    @Override
                    public void onResponse(Call<RepostaProdutoCard> call, Response<RepostaProdutoCard> response) {

                        RepostaProdutoCard produto = response.body();
                        registrarInformacaoTabelaSetUp(produto);
                    }

                    @Override
                    public void onFailure(Call<RepostaProdutoCard> call, Throwable t) {
                        progressSetUp.setVisibility(View.GONE);
                        Log.e("PDVService   ", "Erro ao buscar o produto:" + t.getMessage());
                        alerta(ERRO_GENERICO);
                    }
                });
            } else {
                //cRIA VARIAVEL GLOBAL
        //        ((MyApplication) this.getApplication()).setSomeVariable("modooffline");

                abreTelaPrincipal();
            }
        } else {
            progressSetUp.setVisibility(View.GONE);
            alerta("Usuário ou senha inválido");
        }

    }

    private void informacaoLogin() {


        runOnUiThread(new Thread(new Runnable() {

            @Override
            public void run() {
                if (setUpCarregado) {
                    edUsuarioLogin.setText(mApplication.getSetUp().getT_login());
                    usuario = mApplication.getSetUp().getT_login();
                    codigo = String.valueOf(mApplication.getSetUp().getT_hh_ident());
                } else {
                    edUsuarioLogin.setText(usuario);
                }

                edUsuarioLogin.setEnabled(true);
            }
        }));


    }

    private void validaSetUpCarregado() {

        if (mApplication.getSetUp() == null
                || mApplication.getSetUp().getT_login() == null
        ) {

            setUpCarregado = false;
        } else {

            try {
                timeOut = Integer.valueOf(mApplication.getSetUp().getT_timeout());
            } catch (Exception e) {
                timeOut = 35;
            }
            setUpCarregado = true;
        }
    }

    private void registrarInformacaoTabelaSetUp(RepostaProdutoCard produto) {


        SetUp setUp = new SetUp();

        int off;
        if (senhaOffline != null || !senhaOffline.isEmpty()) {
            off = 1;
        } else {
            off = 0;
        }

        setUp.setT_login(usuario);
        setUp.setT_passw(senha);
        setUp.setT_hh_ident(Integer.valueOf(codigo));
        setUp.setT_tipo_recibo(String.valueOf(tipoRecibo));
        setUp.setT_senha(senhaOffline);
        setUp.setT_razao(produto.getProdutoCard().getQm());
        setUp.setT_endereco(produto.getProdutoCard().getQe());
        setUp.setT_numero(produto.getProdutoCard().getQn());
        setUp.setT_complemento(produto.getProdutoCard().getQp());
        setUp.setT_bairro(produto.getProdutoCard().getQb());
        setUp.setT_cidade(produto.getProdutoCard().getQc());
        setUp.setT_cnpj(produto.getProdutoCard().getQj());
        setUp.setT_cep(produto.getProdutoCard().getQz());
        setUp.setT_inscricao(produto.getProdutoCard().getQi());
        setUp.setT_cuf(produto.getProdutoCard().getCuf());
        setUp.setT_uf(produto.getProdutoCard().getQu());
        setUp.setT_serie(produto.getProdutoCard().getHh());
        setUp.setT_sefaz(produto.getProdutoCard().getQsStatusSefazNfce());
        setUp.setT_tef(produto.getProdutoCard().getTef().toString());

        mApplication.getSetUp().setT_tef(produto.getProdutoCard().getTef().toString());
        setUp.setT_prepapo(produto.getProdutoCard().getUo());
        setUp.setT_monitor(produto.getProdutoCard().getMo());
        setUp.setT_cliente(produto.getProdutoCard().getCc());
        setUp.setT_leitora(produto.getProdutoCard().getLe());
        setUp.setT_timeout(produto.getProdutoCard().getTo());
        setUp.setT_codativ(produto.getProdutoCard().getCdat());
        setUp.setT_assina(produto.getProdutoCard().getAsst());
        setUp.setT_inscmun(produto.getProdutoCard().getInscm());
        setUp.setT_cnpjdes(produto.getProdutoCard().getCnpjd());
        setUp.setT_layout(produto.getProdutoCard().getLayout());
        setUp.setT_mensagem(produto.getProdutoCard().getMr());
        setUp.setT_duplacripto(produto.getProdutoCard().getCrd());
        setUp.setT_usaoff(produto.getProdutoCard().getUo().toString()); //String.valueOf(off));
        mApplication.getSetUp().setT_tef(produto.getProdutoCard().getUo().toString());

        setUp.setT_urlhomo(produto.getProdutoCard().getUfUrlSefazHomolog());
        setUp.setT_urlpro(produto.getProdutoCard().getUfUrlSefazProd());


        setUpBancoController = new SetUpBancoController(this);
        boolean resultado = setUpBancoController.insereDado(setUp);

        // produtos
        ProdutoBancoController produtoBancoController = new ProdutoBancoController(this);

        for (Produto item : produto.getProdutoCard().getPd().getProdutoList()) {

            ProdutoEntidade produtoEntidade = new ProdutoEntidade();

            produtoEntidade.setCodigo(item.getPi());
            produtoEntidade.setNome(item.getNr());
            produtoEntidade.setValor(Float.valueOf(item.getVr()));
            produtoEntidade.setCategoria(item.getTd());
            produtoEntidade.setBarras(item.getCb());
            produtoEntidade.setUnidade(item.getUn());
            produtoEntidade.setNcmid(item.getNcmid());
            produtoEntidade.setGfid(item.getGfid());
            produtoEntidade.setTipoProduto(item.getnH());
            produtoEntidade.setImageTipoProduto(item.getImt());
            produtoEntidade.setImageItem(item.getImp());

            produtoBancoController.insereDado(produtoEntidade);

        }

        // registra informacao tabela contador

        ContadorEntidade contadorEntidade = new ContadorEntidade();

        contadorEntidade.setT_idf(Long.parseLong(idFiscal));

        ContadorController contadorController = new ContadorController(this);
        contadorController.insereDado(contadorEntidade);

        if (resultado) {
            mApplication.setSetUp(setUp);
            abreTelaPrincipal();

        } else {
            progressSetUp.setVisibility(View.GONE);

            alerta("Erro ao salvar o SetUp");
        }
    }


    private void abreTelaPrincipal() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("ConsultaPendente" , true);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void alerta(String mensagem) {

        new AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage(mensagem)
                .setPositiveButton("ok", null)
                .show();

    }


    private void popSetUp() {

        PopSetup popSetup = new PopSetup();

        popSetup.setSetUp(new com.arenaplan.pdv.get.util.dialog.SetUp() {
            @Override
            public void onCancelar() {

            }

            @Override
            public void onConfirma() {

                abriTelaSetUp();

            }
        });

        popSetup.show(getSupportFragmentManager(), "Pop Setup");
    }

    private void abriTelaSetUp() {

        Intent intent = new Intent(this, SetUpActivity.class);
        intent.putExtra("refazerSetup", true);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
