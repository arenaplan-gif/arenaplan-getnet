package com.arenaplan.pdv.get.setup.ui;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.database.CriaBanco;
import com.arenaplan.pdv.get.database.ProdutoBancoController;
import com.arenaplan.pdv.get.database.SetUpBancoController;
import com.arenaplan.pdv.get.login.LoginActivity;
import com.arenaplan.pdv.get.util.DateUtils;


public class SetUpActivity extends AppCompatActivity {

    ArenaplanPdvApplication mApplication;
    private EditText edCodigo;
    private EditText edUsuario;
    private EditText edSenhaOffline;
    private EditText edIdFiscal;
    private LinearLayout viewSenhaOffline;
    private Spinner spinner;
    private RelativeLayout progressSetUp;
    private int tipoRecibo = 4;
    private Button login;
    private Button buttonCancelar;
    private String codigo = "1";
    private String usuario = "";
    private String idFiscal = "";
    private String senhaOffline = "";
    private boolean offline = false;
    private TextView tvDataHora;
    private SQLiteDatabase db;
    private CriaBanco CriaBanco;
    private boolean refazerSetup = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        mApplication = (ArenaplanPdvApplication)getApplicationContext();

        //Checa se veio da tela OPCOES para resetar configuracoes
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            //String codigolocal = bundle.getString("_codigo");
            /*if (codigolocal.equals("x")){
                CriaBanco = new CriaBanco(this);
                CriaBanco.onUpgrade(db,5,5);
                //setUpBancoController = new SetUpBancoController(this);
                //setUpBancoController.on.deletaSetUp(1); //        // produtos
                edCodigo.setText("");
                //edUsuario.setText("");
                codigo="";
                usuario="";
                idFiscal="";
                return;
            }*/


        }
        recuperaComponentesTela();
        cliqueBotoes();
    }

    @Override
    protected void onResume() {
        if (!getIntent().hasExtra("refazerSetup")) {
            verificaSetUp();
        } else {
            if(getIntent().hasExtra("refazerSetup")){
                refazerSetup = getIntent().getBooleanExtra("refazerSetup", false);
                if(refazerSetup) {
                    mApplication.setSetUp(null);
                    ProdutoBancoController produtoBancoController = new ProdutoBancoController(this);
                    SetUpBancoController setUpBancoController = new SetUpBancoController(getBaseContext());
                    setUpBancoController.deletaSetUp();
                    produtoBancoController.deletaTabelaProduto();
                }
            }
        }
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void verificaSetUp() {

        if( mApplication.getSetUp() != null
                && mApplication.getSetUp().getT_login() != null
                &&  mApplication.getSetUp().getT_login().length() > 0) {
            abreTelaLogin(false);
        }
    }

    private void recuperaComponentesTela() {
        edCodigo = findViewById(R.id.edCodigo);
        edUsuario = findViewById(R.id.edUsuario);
        spinner = findViewById(R.id.x_spinner);
        edSenhaOffline = findViewById(R.id.edSenhaOffline);
        viewSenhaOffline = findViewById(R.id.view_senha_offline);
        progressSetUp = findViewById(R.id.progress_setUp);
        edIdFiscal = findViewById(R.id.edIdFiscal);

        buttonCancelar = findViewById(R.id.buttonCancelar);
        login = findViewById(R.id.login);
        tvDataHora = findViewById(R.id.tvDataHora);
        exibidaData();

        spinner.setSelection(3);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 7 || position == 6) {
                    viewSenhaOffline.setVisibility(View.VISIBLE);
                    offline =true;
                } else {
                    viewSenhaOffline.setVisibility(View.GONE);
                    offline = false;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void exibidaData() {

        String data = DateUtils.retornaDiaAtual();
        String hora = DateUtils.retornaHoraAtual();
        //Log.d("DataHora", "Data: " + data + ", Hora: " + hora); // Adicione log para depuração

        if (tvDataHora == null) {
            Log.e("SetUpActivity", "tvDataHora é nulo!");
            return; // Sai da função se o TextView não estiver inicializado
        }

        tvDataHora.setText(data + " " + hora);

        String x = "xxx";
    }

    private void cliqueBotoes() {

        login.setOnClickListener(v -> {

            tipoRecibo = spinner.getSelectedItemPosition() + 1;



            if (edCodigo.getText().toString().trim().isEmpty()) {
                edCodigo.setError("Informe o Código");
                progressSetUp.setVisibility(View.GONE);

                return;
            } else {
                edCodigo.setError(null);
                codigo = edCodigo.getText().toString();

            }

            if (edUsuario.getText().toString().trim().isEmpty()) {
                edUsuario.setError("Informe o Usuário");
                progressSetUp.setVisibility(View.GONE);

                return;
            } else {
                edUsuario.setError(null);
                usuario = edUsuario.getText().toString();
            }


            if(edSenhaOffline.getText().toString().trim().isEmpty() && offline) {
                edUsuario.setError("Informe a Senha Offline");
                progressSetUp.setVisibility(View.GONE);
                return;
            }

            if(offline) {

                senhaOffline = edSenhaOffline.getText().toString();
            }

            idFiscal = edIdFiscal.getText().toString();

            if(idFiscal.equalsIgnoreCase("0")) {
                idFiscal = "1";
            }

            abreTelaLogin(true);


        });


        buttonCancelar.setOnClickListener(v -> {

        });
    }

    private void abreTelaLogin(boolean carregaParametros) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        if(carregaParametros) {
            intent.putExtra("login", usuario);
            intent.putExtra("codigoMaquina", codigo);
            intent.putExtra("senhaOffLine", senhaOffline);
            intent.putExtra("tipoRecibo", tipoRecibo);
            intent.putExtra("idFiscal" , idFiscal);
        }
        startActivity(intent);
        finish();
    }

    public void Encerrar(View view) {
        finish();
        System.exit(0);
    }
}