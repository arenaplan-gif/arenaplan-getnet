package com.arenaplan.pdv.get.api;

import com.arenaplan.pdv.get.api.model.AbreCaixaCard;
import com.arenaplan.pdv.get.api.model.InserePedidoCard;
import com.arenaplan.pdv.get.api.model.InutilizarCupomCard;
import com.arenaplan.pdv.get.api.model.PagamentoCard;
import com.arenaplan.pdv.get.api.model.RepostaMesaCard;
import com.arenaplan.pdv.get.api.model.RepostaProdutoCard;
import com.arenaplan.pdv.get.api.model.RespostaCardLogin;
import com.arenaplan.pdv.get.api.model.RespostaClienteCard;
import com.arenaplan.pdv.get.api.model.RespostaPedidosCard;
import com.arenaplan.pdv.get.api.model.ResumoCaixaCard;
import com.arenaplan.pdv.get.api.model.TransacaoCard;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PDVService {

    @GET("procgeeknfeteste.php?")
    Call<RespostaCardLogin> login(@Query("t_login") String t_login,
                                  @Query("t_passw") String t_passw,
                                  @Query("t_hh_ident") String t_hh_ident,
                                  @Query("t_action") String t_action,
                                  @Query("t_formato") String t_formato
                       );



    @GET("procgeeknfeteste.php?")
    Call<RepostaProdutoCard> getProduto(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_formato") String t_formato
    );

    @GET("procgeeknfeteste.php?")
    Call<PagamentoCard> enviaPagamento(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_carrinho") String t_carrinho,
            @Query("t_total") String t_total,
            @Query("t_desc") String t_desc,
            @Query("t_troco") String t_troco,
            @Query("t_idf") String t_idf,
            @Query("t_idnfe") String t_idnfe,
            @Query("t_cpf") String t_cpf,
            @Query("t_tipot") String t_tipo,
            @Query("t_formato") String t_formato
    );

    @GET("procgeeknfeteste.php?")
    Call<PagamentoCard> enviaPagamentoCartao(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_carrinho") String t_carrinho,
            @Query("t_total") String t_total,
            @Query("t_desc") String t_desc,
            @Query("t_troco") String t_troco,
            @Query("t_idf") String t_idf,
            @Query("t_idnfe") String t_idnfe,
            @Query("t_cpf") String t_cpf,
            @Query("t_tipot") String t_tipo,
            @Query("t_veoper") String t_veoper,
            @Query("t_veseq") String t_veseq,
            @Query("t_veaut") String t_veaut,
            @Query("t_vemod") String t_vemod,
            @Query("t_parcel") String t_parcel,
            @Query("t_formato") String t_formato
    );




    @GET("procgeeknfeteste.php?")
    Call<TransacaoCard> cancelarTransacao(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_tr_id") String t_tr_id,
            @Query("t_formato") String t_formato

    );

    @GET("procgeeknfeteste.php?")
    Call<InutilizarCupomCard> inutilizarCupom(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_nNFIni") String t_nNFIni,
            @Query("t_nNFFin") String t_nNFFin,
            @Query("t_formato") String t_formato
    );

    @GET("procgeeknfeteste.php?")
    Call<AbreCaixaCard> abreCaixa(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_troco") String t_troco,
            @Query("t_formato") String t_formato
    );


    @GET("procgeeknfeteste.php?")
    Call<ResumoCaixaCard> fecharCaixa(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_formato") String t_formato
    );

    @GET("procgeeknfeteste.php?")
    Call<ResumoCaixaCard> statusCaixa(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_formato") String t_formato
    );



    @GET("procgeeknfeteste.php?")
    Call<JsonObject> reimpressaoTransacao(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_formato") String t_formato,
            @Query("t_tr_id") String t_tr_id

    );

    @GET("procgeeknfeteste1.php?")
    Call<RepostaMesaCard> lista_mesas(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_formato") String t_formato
    );
    @GET("procgeeknfeteste1.php?")
    Call<RespostaPedidosCard> lista_consumo(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_menumero") String t_menumero,
            @Query("t_formato") String t_formato
    );
    @GET("procgeeknfeteste1.php?")
    Call<RespostaPedidosCard> fechar_mesa(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_menumero") String t_menumero,
            @Query("t_formato") String t_formato
    );
    @GET("procgeeknfeteste1.php?")
    Call<RespostaClienteCard> detalha_cliente_mesa(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_meclid") String t_meclid,
            @Query("t_formato") String t_formato
    );
    @GET("procgeeknfeteste1.php?")
    Call<InserePedidoCard> process_pedido_mesa(
            @Query("t_login") String t_login,
            @Query("t_passw") String t_passw,
            @Query("t_hh_ident") String t_hh_ident,
            @Query("t_action") String t_action,
            @Query("t_total") float t_total,
            @Query("t_carrinho") String t_carrinho,
            @Query("t_menumero") String t_menumero,
            @Query("t_nome") String t_nome,
            @Query("t_obs") String t_obs,
            @Query("t_formato") String t_formato
    );

}
