package com.arenaplan.pdv.get.pedidos;

import static com.arenaplan.pdv.get.util.Constantes.FORMATO;
import static com.arenaplan.pdv.get.util.Constantes.LISTA_MESAS;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.RetrofitConfig;
import com.arenaplan.pdv.get.api.model.Mesa;
import com.arenaplan.pdv.get.api.model.RepostaMesaCard;
import com.arenaplan.pdv.get.pedidos.dialog.MostraInformacoesPedido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PedidosActivity extends AppCompatActivity {

    //private List<Mesa> mesas;

    //private MesaAdapter mesaAdapter;
    ArenaplanPdvApplication mApplication;
    private List<Mesa> mesas;
    Map<String,String> clientids = new HashMap<String,String>();
//    private clientids = new String[150]; //array para armazenar o clid de cada cliente
    TextView x;
    private Button buttonPagar1;
    private Button buttonPagar2;
    private Button buttonPagar3;
    private Button buttonPagar4;
    private Button buttonPagar5;
    private Button buttonPagar6;
    private Button buttonPagar7;
    private Button buttonPagar8;
    private Button buttonPagar9;
    private Button buttonPagar10;
    private Button buttonPagar11;
    private Button buttonPagar12;
    private Button buttonPagar13;
    private Button buttonPagar14;
    private Button buttonPagar15;
    private Button buttonPagar16;
    private Button buttonPagar17;
    private Button buttonPagar18;
    private Button buttonPagar19;
    private Button buttonPagar20;
    private Button buttonPagar21;
    private Button buttonPagar22;
    private Button buttonPagar23;
    private Button buttonPagar24;
    private Button buttonPagar25;
    private Button buttonPagar26;
    private Button buttonPagar27;
    private Button buttonPagar28;
    private Button buttonPagar29;
    private Button buttonPagar30;
    private Button buttonPagar31;
    private Button buttonPagar32;
    private Button buttonPagar33;
    private Button buttonPagar34;
    private Button buttonPagar35;
    private Button buttonPagar36;
    private Button buttonPagar37;
    private Button buttonPagar38;
    private Button buttonPagar39;
    private Button buttonPagar40;
    private Button buttonPagar41;
    private Button buttonPagar42;
    private Button buttonPagar43;
    private Button buttonPagar44;
    private Button buttonPagar45;
   private Button buttonPagar46;
    private Button buttonPagar47;
    private Button buttonPagar48;
    private Button buttonPagar49;
    private Button buttonPagar50;
    private Button buttonPagar51;
    private Button buttonPagar52;
    private Button buttonPagar53;
    private Button buttonPagar54;
    private Button buttonPagar55;
    private Button buttonPagar56;
    private Button buttonPagar57;
    private Button buttonPagar58;
    private Button buttonPagar59;
    private Button buttonPagar60;
    private Button buttonPagar61;
    private Button buttonPagar62;
    private Button buttonPagar63;
    private Button buttonPagar64;
    private Button buttonPagar65;
    private Button buttonPagar66;
    private Button buttonPagar67;
    private Button buttonPagar68;
    private Button buttonPagar69;
    private Button buttonPagar70;
    private Button buttonPagar71;
    private Button buttonPagar72;
    private Button buttonPagar73;
    private Button buttonPagar74;
    private Button buttonPagar75;
    private Button buttonPagar76;
    private Button buttonPagar77;
    private Button buttonPagar78;
    private Button buttonPagar79;
    private Button buttonPagar80;
    private Button buttonPagar81;
    private Button buttonPagar82;
    private Button buttonPagar83;
    private Button buttonPagar84;
    private Button buttonPagar85;
    private Button buttonPagar86;
    private Button buttonPagar87;
    private Button buttonPagar88;
    private Button buttonPagar89;
    private Button buttonPagar90;
    private Button buttonPagar91;
    private Button buttonPagar92;
    private Button buttonPagar93;
    private Button buttonPagar94;
    private Button buttonPagar95;
    private Button buttonPagar96;
    private Button buttonPagar97;
    private Button buttonPagar98;
    private Button buttonPagar99;
    private Button buttonPagar100;
    private Button buttonPagar101;
    private Button buttonPagar102;
    private Button buttonPagar103;
    private Button buttonPagar104;
    private Button buttonPagar105;
    private Button buttonPagar106;
    private Button buttonPagar107;
    private Button buttonPagar108;
    private Button buttonPagar109;
    private Button buttonPagar110;
    private Button buttonPagar111;
    private Button buttonPagar112;
    private Button buttonPagar113;
    private Button buttonPagar114;
    private Button buttonPagar115;
    private Button buttonPagar116;
    private Button buttonPagar117;
    private Button buttonPagar118;
    private Button buttonPagar119;
    private Button buttonPagar120;
    private Button buttonPagar121;
    private Button buttonPagar122;
    private Button buttonPagar123;
    private Button buttonPagar124;
    private Button buttonPagar125;
    private Button buttonPagar126;
    private Button buttonPagar127;
    private Button buttonPagar128;
    private Button buttonPagar129;
    private Button buttonPagar130;
    private Button buttonPagar131;
    private Button buttonPagar132;
    private Button buttonPagar133;
    private Button buttonPagar134;
    private Button buttonPagar135;
    private Button buttonPagar136;
    private Button buttonPagar137;
    private Button buttonPagar138;
    private Button buttonPagar139;
    private Button buttonPagar140;
    private Button buttonPagar141;
    private Button buttonPagar142;
    private Button buttonPagar143;
    private Button buttonPagar144;
    private Button buttonPagar145;
    private Button buttonPagar146;
    private Button buttonPagar147;
    private Button buttonPagar148;
    private Button buttonPagar149;
    private Button buttonPagar150;
    private Button buttonPagar151;
    private Button buttonPagar152;
    private Button buttonPagar153;
    private Button buttonPagar154;
    private Button buttonPagar155;
    private Button buttonPagar156;
    private Button buttonPagar157;
    private Button buttonPagar158;
    private Button buttonPagar159;
    private Button buttonPagar160;
    private Button buttonPagar161;
    private Button buttonPagar162;
    private Button buttonPagar163;
    private Button buttonPagar164;
    private Button buttonPagar165;
    private Button buttonPagar166;
    private Button buttonPagar167;
    private Button buttonPagar168;
    private Button buttonPagar169;
    private Button buttonPagar170;
    private Button buttonPagar171;
    private Button buttonPagar172;
    private Button buttonPagar173;
    private Button buttonPagar174;
    private Button buttonPagar175;
    private Button buttonPagar176;
    private Button buttonPagar177;
    private Button buttonPagar178;
    private Button buttonPagar179;
    private Button buttonPagar180;
    private Button buttonPagar181;
    private Button buttonPagar182;
    private Button buttonPagar183;
    private Button buttonPagar184;
    private Button buttonPagar185;
    private Button buttonPagar186;
    private Button buttonPagar187;
    private Button buttonPagar188;
    private Button buttonPagar189;
    private Button buttonPagar190;
    private Button buttonPagar191;
    private Button buttonPagar192;
    private Button buttonPagar193;
    private Button buttonPagar194;
    private Button buttonPagar195;
    private Button buttonPagar196;
    private Button buttonPagar197;
    private Button buttonPagar198;
    private Button buttonPagar199;
    private Button buttonPagar200;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;
    private TextView textView16;
    private TextView textView17;
    private TextView textView18;
    private TextView textView19;
    private TextView textView20;
    private TextView textView21;
    private TextView textView22;
    private TextView textView23;
    private TextView textView24;
    private TextView textView25;
    private TextView textView26;
    private TextView textView27;
    private TextView textView28;
    private TextView textView29;
    private TextView textView30;
    private TextView textView31;
    private TextView textView32;
    private TextView textView33;
    private TextView textView34;
    private TextView textView35;
    private TextView textView36;
    private TextView textView37;
    private TextView textView38;
    private TextView textView39;
    private TextView textView40;  ;
    private TextView textView41;
    private TextView textView42;
    private TextView textView43;
    private TextView textView44;
    private TextView textView45;
    private TextView textView46;
    private TextView textView47;
    private TextView textView48;
    private TextView textView49;
    private TextView textView50;
    private TextView textView51;
    private TextView textView52;
    private TextView textView53;
    private TextView textView54;
    private TextView textView55;
    private TextView textView56;
    private TextView textView57;
    private TextView textView58;
    private TextView textView59;
    private TextView textView60;
    private TextView textView61;
    private TextView textView62;
    private TextView textView63;
    private TextView textView64;
    private TextView textView65;
    private TextView textView66;
    private TextView textView67;
    private TextView textView68;
    private TextView textView69;
    private TextView textView70;
    private TextView textView71;
    private TextView textView72;
    private TextView textView73;
    private TextView textView74;
    private TextView textView75;
    private TextView textView76;
    private TextView textView77;
    private TextView textView78;
    private TextView textView79;
    private TextView textView80;
    private TextView textView81;
    private TextView textView82;
    private TextView textView83;
    private TextView textView84;
    private TextView textView85;
    private TextView textView86;
    private TextView textView87;
    private TextView textView88;
    private TextView textView89;
    private TextView textView90;
    private TextView textView91;
    private TextView textView92;
    private TextView textView93;
    private TextView textView94;
    private TextView textView95;
    private TextView textView96;
    private TextView textView97;
    private TextView textView98;
    private TextView textView99;
    private TextView textView100;
    private TextView textView101;
    private TextView textView102;
    private TextView textView103;
    private TextView textView104;
    private TextView textView105;
    private TextView textView106;
    private TextView textView107;
    private TextView textView108;
    private TextView textView109;
    private TextView textView110;
    private TextView textView111;
    private TextView textView112;
    private TextView textView113;
    private TextView textView114;
    private TextView textView115;
    private TextView textView116;
    private TextView textView117;
    private TextView textView118;
    private TextView textView119;
    private TextView textView120;
    private TextView textView121;
    private TextView textView122;
    private TextView textView123;
    private TextView textView124;
    private TextView textView125;
    private TextView textView126;
    private TextView textView127;
    private TextView textView128;
    private TextView textView129;
    private TextView textView130;
    private TextView textView131;
    private TextView textView132;
    private TextView textView133;
    private TextView textView134;
    private TextView textView135;
    private TextView textView136;
    private TextView textView137;
    private TextView textView138;
    private TextView textView139;
    private TextView textView140;
    private TextView textView141;
    private TextView textView142;
    private TextView textView143;
    private TextView textView144;
    private TextView textView145;
    private TextView textView146;
    private TextView textView147;
    private TextView textView148;
    private TextView textView149;
    private TextView textView150;
/*    private TextView textView151;
    private TextView textView152;
    private TextView textView153;
    private TextView textView154;
    private TextView textView155;
    private TextView textView156;
    private TextView textView157;
    private TextView textView158;
    private TextView textView159;
    private TextView textView160;
    private TextView textView161;
    private TextView textView162;
    private TextView textView163;
    private TextView textView164;
    private TextView textView165;
    private TextView textView166;
    private TextView textView167;
    private TextView textView168;
    private TextView textView169;
    private TextView textView170;
    private TextView textView171;
    private TextView textView172;
    private TextView textView173;
    private TextView textView174;
    private TextView textView175;
    private TextView textView176;
    private TextView textView177;
    private TextView textView178;
    private TextView textView179;
    private TextView textView180;
    private TextView textView181;
    private TextView textView182;
    private TextView textView183;
    private TextView textView184;
    private TextView textView185;
    private TextView textView186;
    private TextView textView187;
    private TextView textView188;
    private TextView textView189;
    private TextView textView190;
    private TextView textView191;
    private TextView textView192;
    private TextView textView193;
    private TextView textView194;
    private TextView textView195;
    private TextView textView196;
    private TextView textView197;
    private TextView textView198;
    private TextView textView199;
    private TextView textView200;*/

    private int timeOut = 35;
    //private IGEDI iGedi = null;
    //private ConfigPrint configPrint = new ConfigPrint();
    private String codigo;
    private String usuario;
    private String senha;
    private String nomeformatado;
    private ItemMesa itemMesa;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidos);

        //carrega API que busca as mesas disponíveis
        //PendenteController pendenteController = new PendenteController(this);
        ArenaplanPdvApplication mApplication = (ArenaplanPdvApplication) getApplicationContext();
        usuario = mApplication.getSetUp().getT_login();
        codigo = String.valueOf(mApplication.getSetUp().getT_hh_ident());
        senha = mApplication.getSetUp().getT_passw();
        listarmesas();
        /*GEDI.init(Pedidos.this);
        try {
            timeOut = Integer.parseInt(mApplication.getSetUp().getT_timeout());
        } catch (Exception e) {
            timeOut = 35;
        }*/
        String usuario = mApplication.getSetUp().getT_login();
        codigo = String.valueOf(mApplication.getSetUp().getT_hh_ident());
        senha = mApplication.getSetUp().getT_passw();
        pegaIdTela();
        //Alerta("teste");
        cliqueBotao(); // Mostra os botoes
    }
    @Override
    protected void onResume() {
        super.onResume();
        ArenaplanPdvApplication mApplication = (ArenaplanPdvApplication) getApplicationContext();
        if (mApplication.ModoFechaMesa=="1") {  //apresenta o tototal dos produtos vindos do fechamento da mesa
            finish();
        }
    }


    private void pegaIdTela() {
        buttonPagar1 = findViewById(R.id.buttonPagar1);
        buttonPagar2 = findViewById(R.id.buttonPagar2);
        buttonPagar3 = findViewById(R.id.buttonPagar3);
        buttonPagar4 = findViewById(R.id.buttonPagar4);
        buttonPagar5 = findViewById(R.id.buttonPagar5);
        buttonPagar6 = findViewById(R.id.buttonPagar6);
        buttonPagar7 = findViewById(R.id.buttonPagar7);
        buttonPagar8 = findViewById(R.id.buttonPagar8);
        buttonPagar9 = findViewById(R.id.buttonPagar9);
        buttonPagar10 = findViewById(R.id.buttonPagar10);
        buttonPagar11 = findViewById(R.id.buttonPagar11);
        buttonPagar12 = findViewById(R.id.buttonPagar12);
        buttonPagar13 = findViewById(R.id.buttonPagar13);
        buttonPagar14 = findViewById(R.id.buttonPagar14);
        buttonPagar15 = findViewById(R.id.buttonPagar15);
        buttonPagar16 = findViewById(R.id.buttonPagar16);
        buttonPagar17 = findViewById(R.id.buttonPagar17);
        buttonPagar18 = findViewById(R.id.buttonPagar18);
        buttonPagar19 = findViewById(R.id.buttonPagar19);
        buttonPagar20 = findViewById(R.id.buttonPagar20);
        buttonPagar21 = findViewById(R.id.buttonPagar21);
        buttonPagar22 = findViewById(R.id.buttonPagar22);
        buttonPagar23 = findViewById(R.id.buttonPagar23);
        buttonPagar24 = findViewById(R.id.buttonPagar24);
        buttonPagar25 = findViewById(R.id.buttonPagar25);
        buttonPagar26 = findViewById(R.id.buttonPagar26);
        buttonPagar27 = findViewById(R.id.buttonPagar27);
        buttonPagar28 = findViewById(R.id.buttonPagar28);
        buttonPagar29 = findViewById(R.id.buttonPagar29);
        buttonPagar30 = findViewById(R.id.buttonPagar30);
        buttonPagar31 = findViewById(R.id.buttonPagar31);
        buttonPagar32 = findViewById(R.id.buttonPagar32);
        buttonPagar33 = findViewById(R.id.buttonPagar33);
        buttonPagar34 = findViewById(R.id.buttonPagar34);
        buttonPagar35 = findViewById(R.id.buttonPagar35);
        buttonPagar36 = findViewById(R.id.buttonPagar36);
        buttonPagar37 = findViewById(R.id.buttonPagar37);
        buttonPagar38 = findViewById(R.id.buttonPagar38);
        buttonPagar39 = findViewById(R.id.buttonPagar39);
        buttonPagar40 = findViewById(R.id.buttonPagar40);
        buttonPagar41 = findViewById(R.id.buttonPagar41);
        buttonPagar42 = findViewById(R.id.buttonPagar42);
        buttonPagar43 = findViewById(R.id.buttonPagar43);
        buttonPagar44 = findViewById(R.id.buttonPagar44);
        buttonPagar45 = findViewById(R.id.buttonPagar45);

        buttonPagar46 = findViewById(R.id.buttonPagar46);
        buttonPagar47 = findViewById(R.id.buttonPagar47);
        buttonPagar48 = findViewById(R.id.buttonPagar48);
        buttonPagar49 = findViewById(R.id.buttonPagar49);
        buttonPagar50 = findViewById(R.id.buttonPagar50);
        buttonPagar51 = findViewById(R.id.buttonPagar51);
        buttonPagar52 = findViewById(R.id.buttonPagar52);
        buttonPagar53 = findViewById(R.id.buttonPagar53);
        buttonPagar54 = findViewById(R.id.buttonPagar54);
        buttonPagar55 = findViewById(R.id.buttonPagar55);
        buttonPagar56 = findViewById(R.id.buttonPagar56);
        buttonPagar57 = findViewById(R.id.buttonPagar57);
        buttonPagar58 = findViewById(R.id.buttonPagar58);
        buttonPagar59 = findViewById(R.id.buttonPagar59);
        buttonPagar60 = findViewById(R.id.buttonPagar60);
        buttonPagar61 = findViewById(R.id.buttonPagar61);
        buttonPagar62 = findViewById(R.id.buttonPagar62);
        buttonPagar63 = findViewById(R.id.buttonPagar63);
        buttonPagar64 = findViewById(R.id.buttonPagar64);
        buttonPagar65 = findViewById(R.id.buttonPagar65);
        buttonPagar66 = findViewById(R.id.buttonPagar66);
        buttonPagar67 = findViewById(R.id.buttonPagar67);
        buttonPagar68 = findViewById(R.id.buttonPagar68);
        buttonPagar69 = findViewById(R.id.buttonPagar69);
        buttonPagar70 = findViewById(R.id.buttonPagar70);
        buttonPagar71 = findViewById(R.id.buttonPagar71);
        buttonPagar72 = findViewById(R.id.buttonPagar72);
        buttonPagar73 = findViewById(R.id.buttonPagar73);
        buttonPagar74 = findViewById(R.id.buttonPagar74);
        buttonPagar75 = findViewById(R.id.buttonPagar75);
        buttonPagar76 = findViewById(R.id.buttonPagar76);
        buttonPagar77 = findViewById(R.id.buttonPagar77);
        buttonPagar78 = findViewById(R.id.buttonPagar78);
        buttonPagar79 = findViewById(R.id.buttonPagar79);
        buttonPagar80 = findViewById(R.id.buttonPagar80);
        buttonPagar81 = findViewById(R.id.buttonPagar81);
        buttonPagar82 = findViewById(R.id.buttonPagar82);
        buttonPagar83 = findViewById(R.id.buttonPagar83);
        buttonPagar84 = findViewById(R.id.buttonPagar84);
        buttonPagar85 = findViewById(R.id.buttonPagar85);
        buttonPagar86 = findViewById(R.id.buttonPagar86);
        buttonPagar87 = findViewById(R.id.buttonPagar87);
        buttonPagar88 = findViewById(R.id.buttonPagar88);
        buttonPagar89 = findViewById(R.id.buttonPagar89);
        buttonPagar90 = findViewById(R.id.buttonPagar90);
        buttonPagar91 = findViewById(R.id.buttonPagar91);
        buttonPagar92 = findViewById(R.id.buttonPagar92);
        buttonPagar93 = findViewById(R.id.buttonPagar93);
        buttonPagar94 = findViewById(R.id.buttonPagar94);
        buttonPagar95 = findViewById(R.id.buttonPagar95);
        buttonPagar96 = findViewById(R.id.buttonPagar96);
        buttonPagar97 = findViewById(R.id.buttonPagar97);
        buttonPagar98 = findViewById(R.id.buttonPagar98);
        buttonPagar99 = findViewById(R.id.buttonPagar99);
        buttonPagar100 = findViewById(R.id.buttonPagar100);
        buttonPagar101 = findViewById(R.id.buttonPagar101);
        buttonPagar102 = findViewById(R.id.buttonPagar102);
        buttonPagar103 = findViewById(R.id.buttonPagar103);
        buttonPagar104 = findViewById(R.id.buttonPagar104);
        buttonPagar105 = findViewById(R.id.buttonPagar105);
        buttonPagar106 = findViewById(R.id.buttonPagar106);
        buttonPagar107 = findViewById(R.id.buttonPagar107);
        buttonPagar108 = findViewById(R.id.buttonPagar108);
        buttonPagar109 = findViewById(R.id.buttonPagar109);
        buttonPagar110 = findViewById(R.id.buttonPagar110);
        buttonPagar111 = findViewById(R.id.buttonPagar111);
        buttonPagar112 = findViewById(R.id.buttonPagar112);
        buttonPagar113 = findViewById(R.id.buttonPagar113);
        buttonPagar114 = findViewById(R.id.buttonPagar114);
        buttonPagar115 = findViewById(R.id.buttonPagar115);
        buttonPagar116 = findViewById(R.id.buttonPagar116);
        buttonPagar117 = findViewById(R.id.buttonPagar117);
        buttonPagar118 = findViewById(R.id.buttonPagar118);
        buttonPagar119 = findViewById(R.id.buttonPagar119);
        buttonPagar120 = findViewById(R.id.buttonPagar120);
        buttonPagar121 = findViewById(R.id.buttonPagar121);
        buttonPagar122 = findViewById(R.id.buttonPagar122);
        buttonPagar123 = findViewById(R.id.buttonPagar123);
        buttonPagar124 = findViewById(R.id.buttonPagar124);
        buttonPagar125 = findViewById(R.id.buttonPagar125);
        buttonPagar126 = findViewById(R.id.buttonPagar126);
        buttonPagar127 = findViewById(R.id.buttonPagar127);
        buttonPagar128 = findViewById(R.id.buttonPagar128);
        buttonPagar129 = findViewById(R.id.buttonPagar129);
        buttonPagar130 = findViewById(R.id.buttonPagar130);
        buttonPagar131 = findViewById(R.id.buttonPagar131);
        buttonPagar132 = findViewById(R.id.buttonPagar132);
        buttonPagar133 = findViewById(R.id.buttonPagar133);
        buttonPagar134 = findViewById(R.id.buttonPagar134);
        buttonPagar135 = findViewById(R.id.buttonPagar135);
        buttonPagar136 = findViewById(R.id.buttonPagar136);
        buttonPagar137 = findViewById(R.id.buttonPagar137);
        buttonPagar138 = findViewById(R.id.buttonPagar138);
        buttonPagar139 = findViewById(R.id.buttonPagar139);
        buttonPagar140 = findViewById(R.id.buttonPagar140);
        buttonPagar141 = findViewById(R.id.buttonPagar141);
        buttonPagar142 = findViewById(R.id.buttonPagar142);
        buttonPagar143 = findViewById(R.id.buttonPagar143);
        buttonPagar144 = findViewById(R.id.buttonPagar144);
        buttonPagar145 = findViewById(R.id.buttonPagar145);
        buttonPagar146 = findViewById(R.id.buttonPagar146);
        buttonPagar147 = findViewById(R.id.buttonPagar147);
        buttonPagar148 = findViewById(R.id.buttonPagar148);
        buttonPagar149 = findViewById(R.id.buttonPagar149);
        buttonPagar150 = findViewById(R.id.buttonPagar150);
/*        buttonPagar151 = findViewById(R.id.buttonPagar151);
        buttonPagar152 = findViewById(R.id.buttonPagar152);
        buttonPagar153 = findViewById(R.id.buttonPagar153);
        buttonPagar154 = findViewById(R.id.buttonPagar154);
        buttonPagar155 = findViewById(R.id.buttonPagar155);
        buttonPagar156 = findViewById(R.id.buttonPagar156);
        buttonPagar157 = findViewById(R.id.buttonPagar157);
        buttonPagar158 = findViewById(R.id.buttonPagar158);
        buttonPagar159 = findViewById(R.id.buttonPagar159);
        buttonPagar160 = findViewById(R.id.buttonPagar160);
        buttonPagar161 = findViewById(R.id.buttonPagar161);
        buttonPagar162 = findViewById(R.id.buttonPagar162);
        buttonPagar163 = findViewById(R.id.buttonPagar163);
        buttonPagar164 = findViewById(R.id.buttonPagar164);
        buttonPagar165 = findViewById(R.id.buttonPagar165);
        buttonPagar166 = findViewById(R.id.buttonPagar166);
        buttonPagar167 = findViewById(R.id.buttonPagar167);
        buttonPagar168 = findViewById(R.id.buttonPagar168);
        buttonPagar169 = findViewById(R.id.buttonPagar169);
        buttonPagar170 = findViewById(R.id.buttonPagar170);
        buttonPagar171 = findViewById(R.id.buttonPagar171);
        buttonPagar172 = findViewById(R.id.buttonPagar172);
        buttonPagar173 = findViewById(R.id.buttonPagar173);
        buttonPagar174 = findViewById(R.id.buttonPagar174);
        buttonPagar175 = findViewById(R.id.buttonPagar175);
        buttonPagar176 = findViewById(R.id.buttonPagar176);
        buttonPagar177 = findViewById(R.id.buttonPagar177);
        buttonPagar178 = findViewById(R.id.buttonPagar178);
        buttonPagar179 = findViewById(R.id.buttonPagar179);
        buttonPagar180 = findViewById(R.id.buttonPagar180);
        buttonPagar181 = findViewById(R.id.buttonPagar181);
        buttonPagar182 = findViewById(R.id.buttonPagar182);
        buttonPagar183 = findViewById(R.id.buttonPagar183);
        buttonPagar184 = findViewById(R.id.buttonPagar184);
        buttonPagar185 = findViewById(R.id.buttonPagar185);
        buttonPagar186 = findViewById(R.id.buttonPagar186);
        buttonPagar187 = findViewById(R.id.buttonPagar187);
        buttonPagar188 = findViewById(R.id.buttonPagar188);
        buttonPagar189 = findViewById(R.id.buttonPagar189);
        buttonPagar190 = findViewById(R.id.buttonPagar190);
        buttonPagar191 = findViewById(R.id.buttonPagar191);
        buttonPagar192 = findViewById(R.id.buttonPagar192);
        buttonPagar193 = findViewById(R.id.buttonPagar193);
        buttonPagar194 = findViewById(R.id.buttonPagar194);
        buttonPagar195 = findViewById(R.id.buttonPagar195);
        buttonPagar196 = findViewById(R.id.buttonPagar196);
        buttonPagar197 = findViewById(R.id.buttonPagar197);
        buttonPagar198 = findViewById(R.id.buttonPagar198);
        buttonPagar199 = findViewById(R.id.buttonPagar199);
        buttonPagar200 = findViewById(R.id.buttonPagar200);*/
}
    private void cliqueBotao() {
        buttonPagar1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView1);                AbreTelaResumoPedidoMesa("1",String.valueOf(x.getText())); }});
        buttonPagar2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView2);                AbreTelaResumoPedidoMesa("2",String.valueOf(x.getText())); }});
        buttonPagar3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView3);                AbreTelaResumoPedidoMesa("3",String.valueOf(x.getText())); }});
        buttonPagar4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView4);                AbreTelaResumoPedidoMesa("4",String.valueOf(x.getText())); }});
        buttonPagar5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView5);                AbreTelaResumoPedidoMesa("5",String.valueOf(x.getText())); }});
        buttonPagar6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView6);                AbreTelaResumoPedidoMesa("6",String.valueOf(x.getText())); }});
        buttonPagar7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView7);                AbreTelaResumoPedidoMesa("7",String.valueOf(x.getText())); }});
        buttonPagar8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView8);                AbreTelaResumoPedidoMesa("8",String.valueOf(x.getText())); }});
        buttonPagar9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView9);                AbreTelaResumoPedidoMesa("9",String.valueOf(x.getText())); }});
        buttonPagar10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView10);             AbreTelaResumoPedidoMesa("10",String.valueOf(x.getText())); }});
        buttonPagar11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView11);                AbreTelaResumoPedidoMesa("11",String.valueOf(x.getText())); }});
        buttonPagar12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView12);                AbreTelaResumoPedidoMesa("12",String.valueOf(x.getText())); }});
        buttonPagar13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView13);                AbreTelaResumoPedidoMesa("13",String.valueOf(x.getText())); }});
        buttonPagar14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView14);                AbreTelaResumoPedidoMesa("14",String.valueOf(x.getText())); }});
        buttonPagar15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView15);                AbreTelaResumoPedidoMesa("15",String.valueOf(x.getText())); }});
        buttonPagar16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView16);                AbreTelaResumoPedidoMesa("16",String.valueOf(x.getText())); }});
        buttonPagar17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView17);                AbreTelaResumoPedidoMesa("17",String.valueOf(x.getText())); }});
        buttonPagar18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView18);                AbreTelaResumoPedidoMesa("18",String.valueOf(x.getText())); }});
        buttonPagar19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView19);            AbreTelaResumoPedidoMesa("19",String.valueOf(x.getText())); }});
        buttonPagar20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView20);                AbreTelaResumoPedidoMesa("20",String.valueOf(x.getText())); }});
        buttonPagar21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView21);                AbreTelaResumoPedidoMesa("21",String.valueOf(x.getText())); }});
        buttonPagar22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView22);                AbreTelaResumoPedidoMesa("22",String.valueOf(x.getText())); }});
        buttonPagar23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView23);                AbreTelaResumoPedidoMesa("23",String.valueOf(x.getText())); }});
        buttonPagar24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView24);                AbreTelaResumoPedidoMesa("24",String.valueOf(x.getText())); }});
        buttonPagar25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView25);                AbreTelaResumoPedidoMesa("25",String.valueOf(x.getText())); }});
        buttonPagar26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView26);                AbreTelaResumoPedidoMesa("26",String.valueOf(x.getText())); }});
        buttonPagar27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView27);                AbreTelaResumoPedidoMesa("27",String.valueOf(x.getText())); }});
        buttonPagar28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView28);                AbreTelaResumoPedidoMesa("28",String.valueOf(x.getText())); }});
        buttonPagar29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView29);                AbreTelaResumoPedidoMesa("29",String.valueOf(x.getText())); }});
        buttonPagar30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView30);                AbreTelaResumoPedidoMesa("30",String.valueOf(x.getText())); }});
        buttonPagar31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView31);                AbreTelaResumoPedidoMesa("31",String.valueOf(x.getText())); }});
        buttonPagar32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView32);                AbreTelaResumoPedidoMesa("32",String.valueOf(x.getText())); }});
        buttonPagar33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView33);                AbreTelaResumoPedidoMesa("33",String.valueOf(x.getText())); }});
        buttonPagar34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView34);                AbreTelaResumoPedidoMesa("34",String.valueOf(x.getText())); }});
        buttonPagar35.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView35);                AbreTelaResumoPedidoMesa("35",String.valueOf(x.getText())); }});
        buttonPagar36.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView36);                AbreTelaResumoPedidoMesa("36",String.valueOf(x.getText())); }});
        buttonPagar37.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView37);                AbreTelaResumoPedidoMesa("37",String.valueOf(x.getText())); }});
        buttonPagar38.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView38);                AbreTelaResumoPedidoMesa("38",String.valueOf(x.getText())); }});
        buttonPagar39.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView39);                AbreTelaResumoPedidoMesa("39",String.valueOf(x.getText())); }});
        buttonPagar40.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                x = findViewById(R.id.textView40);            AbreTelaResumoPedidoMesa("40",String.valueOf(x.getText())); }});
        buttonPagar41.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView41);            AbreTelaResumoPedidoMesa("41",String.valueOf(x.getText())); }});
        buttonPagar42.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView42);            AbreTelaResumoPedidoMesa("42",String.valueOf(x.getText())); }});
        buttonPagar43.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView43);            AbreTelaResumoPedidoMesa("43",String.valueOf(x.getText())); }});
        buttonPagar44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView44);            AbreTelaResumoPedidoMesa("44",String.valueOf(x.getText())); }});
        buttonPagar45.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView45);            AbreTelaResumoPedidoMesa("45",String.valueOf(x.getText())); }});
        buttonPagar46.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView46);            AbreTelaResumoPedidoMesa("46",String.valueOf(x.getText())); }});
        buttonPagar47.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView47);            AbreTelaResumoPedidoMesa("47",String.valueOf(x.getText())); }});
        buttonPagar48.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView48);            AbreTelaResumoPedidoMesa("48",String.valueOf(x.getText())); }});
        buttonPagar49.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView49);            AbreTelaResumoPedidoMesa("49",String.valueOf(x.getText())); }});
        buttonPagar50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView50);            AbreTelaResumoPedidoMesa("50",String.valueOf(x.getText())); }});
        buttonPagar51.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView51);            AbreTelaResumoPedidoMesa("51",String.valueOf(x.getText())); }});
        buttonPagar52.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView52);            AbreTelaResumoPedidoMesa("52",String.valueOf(x.getText())); }});
        buttonPagar53.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView53);            AbreTelaResumoPedidoMesa("53",String.valueOf(x.getText())); }});
        buttonPagar54.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView54);            AbreTelaResumoPedidoMesa("54",String.valueOf(x.getText())); }});
        buttonPagar55.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView55);            AbreTelaResumoPedidoMesa("55",String.valueOf(x.getText())); }});
        buttonPagar56.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView56);            AbreTelaResumoPedidoMesa("56",String.valueOf(x.getText())); }});
        buttonPagar57.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView57);            AbreTelaResumoPedidoMesa("57",String.valueOf(x.getText())); }});
        buttonPagar58.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView58);            AbreTelaResumoPedidoMesa("58",String.valueOf(x.getText())); }});
        buttonPagar59.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView59);            AbreTelaResumoPedidoMesa("59",String.valueOf(x.getText())); }});
        buttonPagar60.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView60);            AbreTelaResumoPedidoMesa("60",String.valueOf(x.getText())); }});
        buttonPagar61.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView61);            AbreTelaResumoPedidoMesa("61",String.valueOf(x.getText())); }});
        buttonPagar62.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView62);            AbreTelaResumoPedidoMesa("62",String.valueOf(x.getText())); }});
        buttonPagar63.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView63);            AbreTelaResumoPedidoMesa("63",String.valueOf(x.getText())); }});
        buttonPagar64.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView64);            AbreTelaResumoPedidoMesa("64",String.valueOf(x.getText())); }});
        buttonPagar65.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView65);                AbreTelaResumoPedidoMesa("65",String.valueOf(x.getText())); }});
        buttonPagar66.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView66);                AbreTelaResumoPedidoMesa("66",String.valueOf(x.getText())); }});
        buttonPagar67.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView67);                AbreTelaResumoPedidoMesa("67",String.valueOf(x.getText())); }});
        buttonPagar68.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView68);                AbreTelaResumoPedidoMesa("68",String.valueOf(x.getText())); }});
        buttonPagar69.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView69);                AbreTelaResumoPedidoMesa("69",String.valueOf(x.getText())); }});
        buttonPagar70.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView70);AbreTelaResumoPedidoMesa("70",String.valueOf(x.getText())); }});
        buttonPagar71.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView71);AbreTelaResumoPedidoMesa("71",String.valueOf(x.getText())); }});
        buttonPagar72.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView72);AbreTelaResumoPedidoMesa("72",String.valueOf(x.getText())); }});
        buttonPagar73.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView73);AbreTelaResumoPedidoMesa("73",String.valueOf(x.getText())); }});
        buttonPagar74.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView74);AbreTelaResumoPedidoMesa("74",String.valueOf(x.getText())); }});
        buttonPagar75.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView75);AbreTelaResumoPedidoMesa("75",String.valueOf(x.getText())); }});
        buttonPagar76.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView76);AbreTelaResumoPedidoMesa("76",String.valueOf(x.getText())); }});
        buttonPagar77.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView77);AbreTelaResumoPedidoMesa("77",String.valueOf(x.getText())); }});
        buttonPagar78.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView78);AbreTelaResumoPedidoMesa("78",String.valueOf(x.getText())); }});
        buttonPagar79.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView79);AbreTelaResumoPedidoMesa("79",String.valueOf(x.getText())); }});
        buttonPagar80.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView80);AbreTelaResumoPedidoMesa("80",String.valueOf(x.getText())); }});
        buttonPagar81.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView81);AbreTelaResumoPedidoMesa("81",String.valueOf(x.getText())); }});
        buttonPagar82.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView82);AbreTelaResumoPedidoMesa("82",String.valueOf(x.getText())); }});
        buttonPagar83.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView83);AbreTelaResumoPedidoMesa("83",String.valueOf(x.getText())); }});
        buttonPagar84.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView84);AbreTelaResumoPedidoMesa("84",String.valueOf(x.getText())); }});
        buttonPagar85.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView85);AbreTelaResumoPedidoMesa("85",String.valueOf(x.getText())); }});
        buttonPagar86.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView86);AbreTelaResumoPedidoMesa("86",String.valueOf(x.getText())); }});
        buttonPagar87.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView87);AbreTelaResumoPedidoMesa("87",String.valueOf(x.getText())); }});
        buttonPagar88.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView88);AbreTelaResumoPedidoMesa("88",String.valueOf(x.getText())); }});
        buttonPagar89.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView89);AbreTelaResumoPedidoMesa("89",String.valueOf(x.getText())); }});
        buttonPagar90.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView90);AbreTelaResumoPedidoMesa("90",String.valueOf(x.getText())); }});
        buttonPagar91.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView91);AbreTelaResumoPedidoMesa("91",String.valueOf(x.getText())); }});
        buttonPagar92.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView92);AbreTelaResumoPedidoMesa("92",String.valueOf(x.getText())); }});
        buttonPagar93.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView93);AbreTelaResumoPedidoMesa("93",String.valueOf(x.getText())); }});
        buttonPagar94.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView94);AbreTelaResumoPedidoMesa("94",String.valueOf(x.getText())); }});
        buttonPagar95.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView95);AbreTelaResumoPedidoMesa("95",String.valueOf(x.getText())); }});
        buttonPagar96.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView96);AbreTelaResumoPedidoMesa("96",String.valueOf(x.getText())); }});
        buttonPagar97.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView97);AbreTelaResumoPedidoMesa("97",String.valueOf(x.getText())); }});
        buttonPagar98.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView98);AbreTelaResumoPedidoMesa("98",String.valueOf(x.getText())); }});
        buttonPagar99.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView99);AbreTelaResumoPedidoMesa("99",String.valueOf(x.getText())); }});
        buttonPagar100.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView100);AbreTelaResumoPedidoMesa("100",String.valueOf(x.getText())); }});
        buttonPagar101.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView101);AbreTelaResumoPedidoMesa("101",String.valueOf(x.getText())); }});
        buttonPagar102.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView102);AbreTelaResumoPedidoMesa("102",String.valueOf(x.getText())); }});
        buttonPagar103.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView103);AbreTelaResumoPedidoMesa("103",String.valueOf(x.getText())); }});
        buttonPagar104.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView104);AbreTelaResumoPedidoMesa("104",String.valueOf(x.getText())); }});
        buttonPagar105.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView105);AbreTelaResumoPedidoMesa("105",String.valueOf(x.getText())); }});
        buttonPagar106.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView106);AbreTelaResumoPedidoMesa("106",String.valueOf(x.getText())); }});
        buttonPagar107.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView107);AbreTelaResumoPedidoMesa("107",String.valueOf(x.getText())); }});
        buttonPagar108.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView108);AbreTelaResumoPedidoMesa("108",String.valueOf(x.getText())); }});
        buttonPagar109.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView109);AbreTelaResumoPedidoMesa("109",String.valueOf(x.getText())); }});
        buttonPagar110.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView110);AbreTelaResumoPedidoMesa("110",String.valueOf(x.getText())); }});
        buttonPagar111.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView111);AbreTelaResumoPedidoMesa("111",String.valueOf(x.getText())); }});
        buttonPagar112.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView112);AbreTelaResumoPedidoMesa("112",String.valueOf(x.getText())); }});
        buttonPagar113.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView113);AbreTelaResumoPedidoMesa("113",String.valueOf(x.getText())); }});
        buttonPagar114.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView114);AbreTelaResumoPedidoMesa("114",String.valueOf(x.getText())); }});
        buttonPagar115.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView115);AbreTelaResumoPedidoMesa("115",String.valueOf(x.getText())); }});
        buttonPagar116.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView116);AbreTelaResumoPedidoMesa("116",String.valueOf(x.getText())); }});
        buttonPagar117.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView117);AbreTelaResumoPedidoMesa("117",String.valueOf(x.getText())); }});
        buttonPagar118.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView118);AbreTelaResumoPedidoMesa("118",String.valueOf(x.getText())); }});
        buttonPagar119.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView119);AbreTelaResumoPedidoMesa("119",String.valueOf(x.getText())); }});
        buttonPagar120.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView120);AbreTelaResumoPedidoMesa("120",String.valueOf(x.getText())); }});
        buttonPagar121.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView121);AbreTelaResumoPedidoMesa("121",String.valueOf(x.getText())); }});
        buttonPagar122.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView122);AbreTelaResumoPedidoMesa("122",String.valueOf(x.getText())); }});
        buttonPagar123.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView123);AbreTelaResumoPedidoMesa("123",String.valueOf(x.getText())); }});
        buttonPagar124.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView124);AbreTelaResumoPedidoMesa("124",String.valueOf(x.getText())); }});
        buttonPagar125.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView125);AbreTelaResumoPedidoMesa("125",String.valueOf(x.getText())); }});
        buttonPagar126.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView126);AbreTelaResumoPedidoMesa("126",String.valueOf(x.getText())); }});
        buttonPagar127.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView127);AbreTelaResumoPedidoMesa("127",String.valueOf(x.getText())); }});
        buttonPagar128.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView128);AbreTelaResumoPedidoMesa("128",String.valueOf(x.getText())); }});
        buttonPagar129.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView129);AbreTelaResumoPedidoMesa("129",String.valueOf(x.getText())); }});
        buttonPagar130.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView130);AbreTelaResumoPedidoMesa("130",String.valueOf(x.getText())); }});
        buttonPagar131.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView131);AbreTelaResumoPedidoMesa("131",String.valueOf(x.getText())); }});
        buttonPagar132.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView132);AbreTelaResumoPedidoMesa("132",String.valueOf(x.getText())); }});
        buttonPagar133.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView133);AbreTelaResumoPedidoMesa("133",String.valueOf(x.getText())); }});
        buttonPagar134.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView134);AbreTelaResumoPedidoMesa("134",String.valueOf(x.getText())); }});
        buttonPagar135.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView135);AbreTelaResumoPedidoMesa("135",String.valueOf(x.getText())); }});
        buttonPagar136.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView136);AbreTelaResumoPedidoMesa("136",String.valueOf(x.getText())); }});
        buttonPagar137.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView137);AbreTelaResumoPedidoMesa("137",String.valueOf(x.getText())); }});
        buttonPagar138.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView138);AbreTelaResumoPedidoMesa("138",String.valueOf(x.getText())); }});
        buttonPagar139.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView139);AbreTelaResumoPedidoMesa("139",String.valueOf(x.getText())); }});
        buttonPagar140.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView140);AbreTelaResumoPedidoMesa("140",String.valueOf(x.getText())); }});
        buttonPagar141.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView141);AbreTelaResumoPedidoMesa("141",String.valueOf(x.getText())); }});
        buttonPagar142.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView142);AbreTelaResumoPedidoMesa("142",String.valueOf(x.getText())); }});
        buttonPagar143.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView143);AbreTelaResumoPedidoMesa("143",String.valueOf(x.getText())); }});
        buttonPagar144.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView144);AbreTelaResumoPedidoMesa("144",String.valueOf(x.getText())); }});
        buttonPagar145.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView145);AbreTelaResumoPedidoMesa("145",String.valueOf(x.getText())); }});
        buttonPagar146.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView146);AbreTelaResumoPedidoMesa("146",String.valueOf(x.getText())); }});
        buttonPagar147.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView147);AbreTelaResumoPedidoMesa("147",String.valueOf(x.getText())); }});
        buttonPagar148.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView148);AbreTelaResumoPedidoMesa("148",String.valueOf(x.getText())); }});
        buttonPagar149.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView149);AbreTelaResumoPedidoMesa("149",String.valueOf(x.getText())); }});
        buttonPagar150.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = findViewById(R.id.textView150);AbreTelaResumoPedidoMesa("150",String.valueOf(x.getText())); }});


/*        buttonPagar151.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("151");  }});
        buttonPagar152.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("152");  }});
        buttonPagar153.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("153");  }});
        buttonPagar154.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("154");  }});
        buttonPagar155.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("155");  }});
        buttonPagar156.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("156");  }});
        buttonPagar157.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("157");  }});
        buttonPagar158.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("158");  }});
        buttonPagar159.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("159");  }});
        buttonPagar160.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("160");  }});
        buttonPagar161.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("161");  }});
        buttonPagar162.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("162");  }});
        buttonPagar163.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("163");  }});
        buttonPagar164.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("164");  }});
        buttonPagar165.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("165");  }});
        buttonPagar166.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("166");  }});
        buttonPagar167.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("167");  }});
        buttonPagar168.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("168");  }});
        buttonPagar169.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("169");  }});
        buttonPagar170.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("170");  }});
        buttonPagar171.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("171");  }});
        buttonPagar172.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("172");  }});
        buttonPagar173.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("173");  }});
        buttonPagar174.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("174");  }});
        buttonPagar175.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("175");  }});
        buttonPagar176.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("176");  }});
        buttonPagar177.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("177");  }});
        buttonPagar178.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("178");  }});
        buttonPagar179.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("179");  }});
        buttonPagar180.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("180");  }});
        buttonPagar181.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("181");  }});
        buttonPagar182.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("182");  }});
        buttonPagar183.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("183");  }});
        buttonPagar184.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("184");  }});
        buttonPagar185.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("185");  }});
        buttonPagar186.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("186");  }});
        buttonPagar187.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("187");  }});
        buttonPagar188.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("188");  }});
        buttonPagar189.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("189");  }});
        buttonPagar190.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("190");  }});
        buttonPagar191.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("191");  }});
        buttonPagar192.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("192");  }});
        buttonPagar193.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("193");  }});
        buttonPagar194.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("194");  }});
        buttonPagar195.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("195");  }});
        buttonPagar196.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("196");  }});
        buttonPagar197.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("197");  }});
        buttonPagar198.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("198");  }});
        buttonPagar199.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("199");  }});
        buttonPagar200.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {AbreTelaResumoPedidoMesa("200");  }});*/
    }

    private void AbreTelaResumoPedidoMesa(String numeromesa,String Apelido){
        Intent intent = new Intent(this, MostraInformacoesPedido.class);
        Bundle b = new Bundle();
        b.putString("numeromesa",numeromesa); //Meramente exemplar
        if (clientids.get(numeromesa)==null) {
            b.putString("clienteid", "-");
            b.putString("apelido", "-");
        }
        else {
            b.putString("clienteid", clientids.get(numeromesa));
            if (!Apelido.equals("")) {
                if(!Apelido.equals("-")){
                    nomeformatado = Apelido.substring(0, Apelido.indexOf("\nR"));
                    b.putString("apelido", nomeformatado);
                 }else b.putString("apelido", "-");
            }else{
                b.putString("apelido", "-");
            }

        }
        intent.putExtras(b);
        startActivity(intent);
    }

    private void alerta(String mensagem) {
        new AlertDialog.Builder(this)
                .setTitle("botao: ")
                .setMessage(mensagem)
                .setPositiveButton("ok", null)
                .show();
    }



    private void listarmesas() {
        Call<RepostaMesaCard> call = new RetrofitConfig(timeOut).getPDVService().lista_mesas(
                usuario,
                senha,
                codigo,
                LISTA_MESAS,
                FORMATO
        );
        //alerta("chegou");
        call.enqueue(new Callback<RepostaMesaCard>() {
            @Override
            public void onResponse(Call<RepostaMesaCard> call, Response<RepostaMesaCard> response) {
                RepostaMesaCard mesa = response.body();
                if (response.body().getMesaCard().getPdMesa().getMesaList()==null){
                    alerta("Não há mesas/comandas registradas");
                }else
                    adicionarItemMesa(mesa);
                    //alerta("atualizou mesas");
            }
            @Override
            public void onFailure(Call<RepostaMesaCard> call, Throwable t) {
                alerta("Não existem comandas ou mesas configuradas");
                finish();
            }
        });
  }


    private void adicionarItemMesa(RepostaMesaCard mesa) {
        //mApplication.adicionaitemMesa(itemMesa);
        //RepostaMesaCard mesa = response.body();

        float valorTotalMesa = 0;
        int contador=0;
        for (Mesa item : mesa.getMesaCard().getPdMesa().getMesaList()) {
            ItemMesa mesaCard = new ItemMesa();
            if (item.getMeclid().toString()!="")
                clientids.put(item.getMenumero().toString(),item.getMeclid().toString()); //clientids.get(i)
            //clientids[Integer.parseInt(item.getMenumero().toString())]=item.getMeclid();
            //if (contador<8)
              //  alerta(contador+" "+item.getMestatus().toString());
            if (item.getMenumero().equals("1")){
                x = findViewById(R.id.textView1);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar1);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if (item.getMenumero().equals("2")){
                x = findViewById(R.id.textView2);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar2);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if (item.getMenumero().equals("3")){
                x = findViewById(R.id.textView3);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar3);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("4")){
                x = findViewById(R.id.textView4);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar4);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("5")) {
                x = findViewById(R.id.textView5);
                x.setText(item.getMeapelido().toString() + "\nR$" + item.getMetotal().toString());
                x = findViewById(R.id.buttonPagar5);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("6")){
                x = findViewById(R.id.textView6);
                x.setText(item.getMeapelido().toString() + "\nR$" + item.getMetotal().toString());
                x = findViewById(R.id.buttonPagar6);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("7")) {
                x = findViewById(R.id.textView7);
                x.setText(item.getMeapelido().toString() + "\nR$" + item.getMetotal().toString());
                x = findViewById(R.id.buttonPagar7);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("8")){
                x = findViewById(R.id.textView8);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar8);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("9")){
                x = findViewById(R.id.textView9);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar9);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("10")){
                x = findViewById(R.id.textView10);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar10);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("11")){
                x = findViewById(R.id.textView11);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar11);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("12")){
                x = findViewById(R.id.textView12);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar12);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("13")){
                x = findViewById(R.id.textView13);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar13);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("14")){
                x = findViewById(R.id.textView14);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar14);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("15")){
                x = findViewById(R.id.textView15);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar15);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("16")){
                x = findViewById(R.id.textView16);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar16);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("17")){
                x = findViewById(R.id.textView17);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar17);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("18")){
                x = findViewById(R.id.textView18);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar18);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("19")){
                x = findViewById(R.id.textView19);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar19);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("20")){
                x = findViewById(R.id.textView20);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar20);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("21")){
                x = findViewById(R.id.textView21);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar21);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("22")){
                x = findViewById(R.id.textView22);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar22);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("23")){
                x = findViewById(R.id.textView23);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar23);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("24")){
                x = findViewById(R.id.textView24);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar24);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("25")){
                x = findViewById(R.id.textView25);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar25);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("26")){
                x = findViewById(R.id.textView26);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar26);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("27")){
                x = findViewById(R.id.textView27);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar27);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("28")){
                x = findViewById(R.id.textView28);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar28);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("29")){
                x = findViewById(R.id.textView29);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar29);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("30")){
                x = findViewById(R.id.textView30);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar30);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("31")){
                x = findViewById(R.id.textView31);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar31);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("32")){
                x = findViewById(R.id.textView32);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar32);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("33")){
                x = findViewById(R.id.textView33);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar33);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("34")){
                x = findViewById(R.id.textView34);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar34);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("35")){
                x = findViewById(R.id.textView35);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar35);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("36")){
                x = findViewById(R.id.textView36);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar36);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("37")){
                x = findViewById(R.id.textView37);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar37);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("38")){
                x = findViewById(R.id.textView38);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar38);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("39")){
                x = findViewById(R.id.textView39);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar39);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("40")){
                x = findViewById(R.id.textView40);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar40);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("41")){
                x = findViewById(R.id.textView41);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar41);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("42")){
                x = findViewById(R.id.textView42);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar42);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("43")){
                x = findViewById(R.id.textView43);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar43);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("44")){
                x = findViewById(R.id.textView44);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar44);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("45")){
                x = findViewById(R.id.textView45);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar45);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("46")){
                x = findViewById(R.id.textView46);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar46);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("47")){
                x = findViewById(R.id.textView47);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar47);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("48")){
                x = findViewById(R.id.textView48);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar48);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("49")){
                x = findViewById(R.id.textView49);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar49);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("50")){
                x = findViewById(R.id.textView50);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar50);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("51")){
                x = findViewById(R.id.textView51);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar51);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("52")){
                x = findViewById(R.id.textView52);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar52);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("53")){
                x = findViewById(R.id.textView53);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar53);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("54")){
                x = findViewById(R.id.textView54);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar54);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("55")){
                x = findViewById(R.id.textView55);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar55);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("56")){
                x = findViewById(R.id.textView56);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar56);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("57")){
                x = findViewById(R.id.textView57);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar57);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("58")){
                x = findViewById(R.id.textView58);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar58);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("59")){
                x = findViewById(R.id.textView59);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar59);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("60")){
                x = findViewById(R.id.textView60);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar60);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("61")){
                x = findViewById(R.id.textView61);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar61);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("62")){
                x = findViewById(R.id.textView62);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar62);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("63")){
                x = findViewById(R.id.textView63);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar63);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("64")){
                x = findViewById(R.id.textView64);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar64);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("65")){
                x = findViewById(R.id.textView65);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar65);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("66")){
                x = findViewById(R.id.textView66);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar66);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("67")){
                x = findViewById(R.id.textView67);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar67);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("68")){
                x = findViewById(R.id.textView68);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar68);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("69")){
                x = findViewById(R.id.textView69);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar69);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("70")){
                x = findViewById(R.id.textView70);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar70);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("71")){
                x = findViewById(R.id.textView71);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar71);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("72")){
                x = findViewById(R.id.textView72);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar72);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("73")){
                x = findViewById(R.id.textView73);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar73);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("74")){
                x = findViewById(R.id.textView74);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar74);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("75")){
                x = findViewById(R.id.textView75);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar75);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("76")){
                x = findViewById(R.id.textView76);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar76);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("77")){
                x = findViewById(R.id.textView77);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar77);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("78")){
                x = findViewById(R.id.textView78);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar78);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("79")){
                x = findViewById(R.id.textView79);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar79);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("80")){
                x = findViewById(R.id.textView80);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar80);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("81")){
                x = findViewById(R.id.textView81);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar81);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("82")){
                x = findViewById(R.id.textView82);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar82);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("83")){
                x = findViewById(R.id.textView83);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar83);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("84")){
                x = findViewById(R.id.textView84);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar84);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("85")){
                x = findViewById(R.id.textView85);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar85);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("86")){
                x = findViewById(R.id.textView86);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar86);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("87")){
                x = findViewById(R.id.textView87);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar87);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("88")){
                x = findViewById(R.id.textView88);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar88);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("89")){
                x = findViewById(R.id.textView89);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar89);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("90")){
                x = findViewById(R.id.textView90);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar90);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("91")){
                x = findViewById(R.id.textView91);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar91);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("92")){
                x = findViewById(R.id.textView92);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar92);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("93")){
                x = findViewById(R.id.textView93);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar93);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("94")){
                x = findViewById(R.id.textView94);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar94);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("95")){
                x = findViewById(R.id.textView95);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar95);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("96")){
                x = findViewById(R.id.textView96);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar96);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("97")){
                x = findViewById(R.id.textView97);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar97);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("98")){
                x = findViewById(R.id.textView98);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar98);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("99")){
                x = findViewById(R.id.textView99);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar99);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("100")){
                x = findViewById(R.id.textView100);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar100);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("101")){
                x = findViewById(R.id.textView101);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar101);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("102")){
                x = findViewById(R.id.textView102);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar102);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("103")){
                x = findViewById(R.id.textView103);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar103);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("104")){
                x = findViewById(R.id.textView104);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar104);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("105")){
                x = findViewById(R.id.textView105);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar105);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("106")){
                x = findViewById(R.id.textView106);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar106);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("107")){
                x = findViewById(R.id.textView107);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar107);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("108")){
                x = findViewById(R.id.textView108);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar108);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("109")){
                x = findViewById(R.id.textView109);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar109);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("110")){
                x = findViewById(R.id.textView110);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar110);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("111")){
                x = findViewById(R.id.textView111);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar111);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("112")){
                x = findViewById(R.id.textView112);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar112);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("113")){
                x = findViewById(R.id.textView113);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar113);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("114")){
                x = findViewById(R.id.textView114);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar114);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("115")){
                x = findViewById(R.id.textView115);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar115);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("116")){
                x = findViewById(R.id.textView116);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar116);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("117")){
                x = findViewById(R.id.textView117);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar117);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("118")){
                x = findViewById(R.id.textView118);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar118);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("119")){
                x = findViewById(R.id.textView119);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar119);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("120")){
                x = findViewById(R.id.textView120);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar120);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("121")){
                x = findViewById(R.id.textView121);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar121);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("122")){
                x = findViewById(R.id.textView122);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar122);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("123")){
                x = findViewById(R.id.textView123);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar123);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("124")){
                x = findViewById(R.id.textView124);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar124);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("125")){
                x = findViewById(R.id.textView125);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar125);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("126")){
                x = findViewById(R.id.textView126);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar126);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("127")){
                x = findViewById(R.id.textView127);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar127);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("128")){
                x = findViewById(R.id.textView128);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar128);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("129")){
                x = findViewById(R.id.textView129);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar129);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("130")){
                x = findViewById(R.id.textView130);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar130);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }

            if ( item.getMenumero().equals("131")){
                x = findViewById(R.id.textView131);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar131);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("132")){
                x = findViewById(R.id.textView132);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar132);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("133")){
                x = findViewById(R.id.textView133);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar133);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("134")){
                x = findViewById(R.id.textView134);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar134);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("135")){
                x = findViewById(R.id.textView135);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar135);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("136")){
                x = findViewById(R.id.textView136);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar136);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("137")){
                x = findViewById(R.id.textView137);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar137);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("138")){
                x = findViewById(R.id.textView138);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar138);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("139")){
                x = findViewById(R.id.textView139);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar139);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("140")){
                x = findViewById(R.id.textView140);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar140);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("141")){
                x = findViewById(R.id.textView141);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar141);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("142")){
                x = findViewById(R.id.textView142);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar142);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("143")){
                x = findViewById(R.id.textView143);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar143);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("144")){
                x = findViewById(R.id.textView144);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar144);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("145")){
                x = findViewById(R.id.textView145);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar145);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("146")){
                x = findViewById(R.id.textView146);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar146);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("147")){
                x = findViewById(R.id.textView147);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar147);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("148")){
                x = findViewById(R.id.textView148);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar148);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("149")){
                x = findViewById(R.id.textView149);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar149);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            if ( item.getMenumero().equals("150")){
                x = findViewById(R.id.textView150);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar150);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else {if (item.getMerevenda().toString().equals("uber")) x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_border)); else if (item.getMerevenda().toString().equals("rappi")) x.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA500"))); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));}
            }
            /*
            if ( item.getMenumero().equals("151")){
                x = findViewById(R.id.textView151);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar151);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("152")){
                x = findViewById(R.id.textView152);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar152);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("153")){
                x = findViewById(R.id.textView153);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar153);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            */
            /*if ( item.getMenumero().equals("154")){
                x = findViewById(R.id.textView154);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar154);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("155")){
                x = findViewById(R.id.textView155);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar155);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("156")){
                x = findViewById(R.id.textView156);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar156);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("157")){
                x = findViewById(R.id.textView157);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar157);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("158")){
                x = findViewById(R.id.textView158);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar158);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("159")){
                x = findViewById(R.id.textView159);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar159);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("160")){
                x = findViewById(R.id.textView160);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar160);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("161")){
                x = findViewById(R.id.textView161);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar161);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("162")){
                x = findViewById(R.id.textView162);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar162);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("163")){
                x = findViewById(R.id.textView163);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar163);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("164")){
                x = findViewById(R.id.textView164);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar164);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("165")){
                x = findViewById(R.id.textView165);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar165);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("166")){
                x = findViewById(R.id.textView166);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar166);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("167")){
                x = findViewById(R.id.textView167);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar167);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("168")){
                x = findViewById(R.id.textView168);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar168);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("169")){
                x = findViewById(R.id.textView169);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar169);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("170")){
                x = findViewById(R.id.textView170);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar170);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("171")){
                x = findViewById(R.id.textView171);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar171);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("172")){
                x = findViewById(R.id.textView172);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar172);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("173")){
                x = findViewById(R.id.textView173);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar173);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("174")){
                x = findViewById(R.id.textView174);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar174);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("175")){
                x = findViewById(R.id.textView175);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar175);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("176")){
                x = findViewById(R.id.textView176);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar176);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("177")){
                x = findViewById(R.id.textView177);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar177);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("178")){
                x = findViewById(R.id.textView178);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar178);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("179")){
                x = findViewById(R.id.textView179);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar179);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("180")){
                x = findViewById(R.id.textView180);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar180);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("181")){
                x = findViewById(R.id.textView181);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar181);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("182")){
                x = findViewById(R.id.textView182);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar182);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("183")){
                x = findViewById(R.id.textView183);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar183);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("184")){
                x = findViewById(R.id.textView184);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar184);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("185")){
                x = findViewById(R.id.textView185);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar185);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("186")){
                x = findViewById(R.id.textView186);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar186);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("187")){
                x = findViewById(R.id.textView187);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar187);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("188")){
                x = findViewById(R.id.textView188);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar188);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("189")){
                x = findViewById(R.id.textView189);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar189);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("190")){
                x = findViewById(R.id.textView190);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar190);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("191")){
                x = findViewById(R.id.textView191);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar191);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("192")){
                x = findViewById(R.id.textView192);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar192);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("193")){
                x = findViewById(R.id.textView193);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar193);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("194")){
                x = findViewById(R.id.textView194);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar194);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("195")){
                x = findViewById(R.id.textView195);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar195);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("196")){
                x = findViewById(R.id.textView196);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar196);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("197")){
                x = findViewById(R.id.textView197);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar197);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("198")){
                x = findViewById(R.id.textView198);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar198);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("199")){
                x = findViewById(R.id.textView199);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar199);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }
            if ( item.getMenumero().equals("200")){
                x = findViewById(R.id.textView200);
                x.setText(item.getMeapelido().toString()+"\nR$"+item.getMetotal().toString());
                x= findViewById(R.id.buttonPagar200);
                if (item.getMestatus().toString().equals("A")) if (item.getMerevenda().toString().equals("ifood"))  x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.viewfinder_laser)); else x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            }

             */





            contador++;
        }

        //textViewValorTotalCarrinho.setText(Monetario.converteValorFloatParaReal(valorTotalCarrinho));
        //produtoSelecionado = null;

        /*codigoProduto.setText("");
        qtdeProduto.setText("");
        precoUnitario.setText("");
        edValorTotal.setText("");
        textViewNomeProduto.setText("");

        InputMethodManager imm = (InputMethodManager) qtdeProduto.getContext().getSystemService(Context
                .INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(qtdeProduto.getWindowToken(), 0);
        */

    }



    private void registrarInformacaoMesas(RepostaMesaCard mesa) {

        int NMesas=0;
        //String NPROD="";
        //com.arenaplan.pdv.database.entidades.SetUp setUp = new com.arenaplan.pdv.database.entidades.SetUp();
/*
        setUp.setT_login(usuario);
        setUp.setT_passw(senha);
        setUp.setT_hh_ident(Integer.valueOf(codigo));
        setUp.setT_tipo_recibo(String.valueOf(mApplication.getSetUp().getT_tipo_recibo()));
        setUp.setT_senha(mApplication.getSetUp().getT_senha());
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
        setUp.setT_tef(produto.getProdutoCard().getTef());
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
        setUp.setT_usaoff(String.valueOf(mApplication.getSetUp().getT_usaoff()));
        setUp.setT_urlhomo(produto.getProdutoCard().getUfUrlSefazHomolog());
        setUp.setT_urlpro(produto.getProdutoCard().getUfUrlSefazProd());


        SetUpBancoController setUpBancoController = new SetUpBancoController(this);
        setUpBancoController.deletaSetUp();
        boolean resultado = setUpBancoController.insereDado(setUp);

        // produtos
        ProdutoBancoController produtoBancoController = new ProdutoBancoController(this);
        produtoBancoController.deletaTabelaProduto();

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
            produtoBancoController.insereDado(produtoEntidade);
            NProdutos++;

        }
        String nprodutos = Integer.toString(NProdutos); //
        alertaSucessoOpcao(" Produtos Carregados: "+nprodutos);


        progressOpcoes.setVisibility(View.GONE);
*/
    }



    }
