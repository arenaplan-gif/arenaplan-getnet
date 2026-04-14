package com.arenaplan.pdv.get;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

import com.arenaplan.pdv.get.database.SetUpBancoController;
import com.arenaplan.pdv.get.database.entidades.SetUp;
import com.arenaplan.pdv.get.principal.modelo.ItemCarrinho;

import java.util.ArrayList;

public class ArenaplanPdvApplication extends Application {

    private SetUp setUp;
    private SetUpBancoController setUpBancoController;
    private ArrayList<ItemCarrinho> listaItemCarrinho = new ArrayList<>();

    public String ModoFechaMesa="0";
    public String ModoOffline="0";
    public String Contingencia="0";
    public String Chave="";  //Utilizados para impressao offline
    public String Idfiscal="";//Utilizados para impressao offline
    //public String Serie="";//Utilizados para impressao offline
    public String ultimocallid="";

    public String planCode = "";

    @Override
    public void onCreate() {
        super.onCreate();
        setUpBancoController = new SetUpBancoController(getBaseContext());
        carregaSetUp();
        //pegaPlanCode();
    }

    public void carregaSetUp() {

       setUp = setUpBancoController.carregaDados();
    }

    public SetUp getSetUp() {
        return this.setUp;
    }

    public void setSetUp(SetUp setUp) {
        this.setUp = setUp;
    }

    public void adicionaitemCarrinho(ItemCarrinho itemCarrinho) {

        listaItemCarrinho.add(itemCarrinho);
    }

    public void removeItemCarrinho(ItemCarrinho itemCarrinho) {
        if (listaItemCarrinho.contains(itemCarrinho)) {
            listaItemCarrinho.remove(itemCarrinho);

        }
    }

    public void limpaCarrinhoSessao() {
        listaItemCarrinho.clear();
    }

    public ArrayList<ItemCarrinho> getListaItemCarrinho() {
        return listaItemCarrinho;
    }

    private void pegaPlanCode() {
        try {
            String authority = "br.com.getnet.getstore.provider";
            String getInfosTable = "TerminalPlanCode";
            Uri getstoreGetInfosUri = Uri.parse("content://" + authority + "/" +
                    getInfosTable);
            Cursor cursor = getContentResolver().query(getstoreGetInfosUri, null, null, null,
                    null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    planCode = cursor.getString(cursor.getColumnIndex("planCode"));
                }
            }
        } catch (Exception e) {

        }

    }

    public void configurePinpadSkin(Context context) {
        // Configura layout customizado do PINPAD
        Intent configureSkin = new
                Intent("com.landicorp.pinpad.pinentry.server.SET_SKIN");
        configureSkin.putExtra("disorder", false);
        // Força texto de entrada (os ‘*’) a ser apresentada
        configureSkin.putExtra("show_input", true);
        // Define o nome da Skin
        configureSkin.putExtra("skin_name", "GETNET4");
        // Totalmente transparente
        configureSkin.putExtra("dim_amount", 0);

        configureSkin.putExtra("skb_height", 580);
        // Comunica a configuração ao serviço pinentry
        context.sendBroadcast(configureSkin);

    }


}
