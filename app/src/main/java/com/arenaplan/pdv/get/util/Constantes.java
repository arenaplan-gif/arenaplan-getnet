package com.arenaplan.pdv.get.util;

public class Constantes {

     public static final String BASE_URL = "http://www.escolasemfilas.com.br/site/api_hh/";
    public static final String BASE_URL_IMAGE = "http://fiscal.arenaplan.com.br/nfe/files/";
    public static final String CODIGO_SUCESSO = "00";
    public static final String ERRO_GENERICO = "ERRO_GENERICO";
    public static final String CODIGO_ERRO_G1 = "G1";
    public static final String CODIGO_ERRO_G2 = "G2";
    public static final String CODIGO_ERRO_G3 = "G3";
    public static final String CODIGO_ERRO_G4 = "G4";
    public static final String CODIGO_ERRO_G5 = "G5";
    public static final String CODIGO_ERRO_G6 = "G6";
    public static final String CODIGO_ERRO_G7 = "G7";
    public static final String CODIGO_ERRO_G8 = "G8";
    public static final String CODIGO_ERRO_G9 = "G9";
    public static final String CODIGO_ERRO_G10 = "G10";
    public static final String CODIGO_ERRO_G11 = "G11";
    public static final String CODIGO_ERRO_E7 = "E7";
    public static final String CODIGO_ERRO_G1_MENSAGEM = "Falha Desconhecida";
    public static final String CODIGO_ERRO_ERRO_GENERICO_MENSAGEM = "Falha Genérica";
    public static final String CODIGO_ERRO_G2_MENSAGEM = "Falha na criptografia";
    public static final String CODIGO_ERRO_G3_MENSAGEM = "Transação Gerada em Contingência Online";
    public static final String CODIGO_ERRO_G4_MENSAGEM = "Origem de IP não autorizado";
    public static final String CODIGO_ERRO_G5_MENSAGEM = "Cnpj inexistente";
    public static final String CODIGO_ERRO_G6_MENSAGEM = "Sequencial invalido";
    public static final String CODIGO_ERRO_G7_MENSAGEM = "ICMS inválido";
    public static final String CODIGO_ERRO_G8_MENSAGEM = "PIS inválido";
    public static final String CODIGO_ERRO_G9_MENSAGEM = "Cofins Invalido";
    public static final String CODIGO_ERRO_G10_MENSAGEM = "SEFAZ demorando para responder";
    public static final String CODIGO_ERRO_G11_MENSAGEM = "Transação já executada";
    public static final String CODIGO_ERRO_E7_MENSAGEM = "IDFiscal não existe ou existe um registro com este IDFiscal que não pode ser cancelado";
    public static final String ACAO_RECEBE_USUARIO_SENHA = "recebe_usuario_senha";
    public static final String CARREGA_PRODUTOS_POS = "carrega_produtos_pos";
    public static final String REGISTRA_COMPRA_DINHEIRO = "registra_compra_dinheiro";
    public static final String REGISTRA_COMPRA_CREDITO = "registra_compra_credito";
    public static final String REGISTRA_COMPRA_DEBITO = "registra_compra_debito";
    public static final String REGISTRA_COMPRA_VOUCHER = "registra_compra_voucher";
    public static final String REGISTRA_COMPRA_CHEQUE = "registra_compra_cheque";
    public static final String REGISTRA_COMPRA_PIX = "registra_compra_pix";
    public static final String REGISTRA_COMPRA_PRE_PAGA = "registra_compra";
    public static final String REIMPRESSAO_TRANSACAO = "reimpressao_transacao";
    public static final String CANCELA_TRANSACAO = "cancela_transacao";
    public static final String CONSULTA_CAIXA = "consulta_caixa";
    public static final String FECHA_CAIXA = "fecha_caixa";
    public static final String ABRE_CAIXA = "abre_caixa";
    public static final String INUTILIZA_TRANSACAO = "inutiliza_transacao";
    public static final String FORMATO = "json";
    public static final String OFF_LINE = "offline";


    public static  final String LISTA_MESAS = "lista_mesas";

    public static  final String LISTA_CONSUMO = "lista_consumo";

    public static final String BUSCA_CLIENTE_PEDIDO = "detalha_cliente_mesa";
    public static  final String FECHAR_MESA = "fechar_mesa";

    public static  final String PEDIDO_MESA = "pedido_mesa";



    // colunas tabelas setup
    public static final String TABELA_SETUP = "setup";
    public static final String ID_SETUP = "id";
    public static final String T_LOGIN = "t_login";
    public static final String T_PASSW = "t_passw";
    public static final String T_HH_IDENT = "t_hh_ident";
    public static final String T_TIPO_RECIBO = "t_tipo_recibo";
    public static final String T_SENHA = "t_senha";
    public static final String T_RAZAO = "t_razao";
    public static final String T_ENDERECO = "t_endereco";
    public static final String T_NUMERO = "t_numero";
    public static final String T_COMPLEMENTO = "t_complemento";
    public static final String T_BAIRRO = "t_bairro";
    public static final String T_CIDADE = "t_cidade";
    public static final String T_CNPJ = "t_cnpj";
    public static final String T_UF = "t_uf";
    public static final String T_CEP = "t_cep";
    public static final String T_INSCRICAO = "t_inscricao";
    public static final String T_CUF = "t_cuf";
    public static final String T_USAOFF = "t_usaoff";
    public static final String T_SERIE = "t_serie";
    public static final String T_URLPRO = "t_urlpro";
    public static final String T_URLHOMO = "t_urlhomo";
    public static final String T_SEFAZ = "t_sefaz";
    public static final String T_TEF = "t_tef";
    public static final String T_PREPAPO = "t_prepapo";
    public static final String T_MONITOR = "t_monitor";
    public static final String T_CLIENTE = "t_cliente";
    public static final String T_LEITORA = "t_leitora";
    public static final String T_TIMEOUT = "t_timeout";
    public static final String T_CODATIV = "t_codativ";
    public static final String T_ASSINA = "t_assina";
    public static final String T_INSCMUN = "t_inscmun";
    public static final String T_CNPJDES = "t_cnpjdes";
    public static final String T_LAYOUT = "t_layout";
    public static final String T_MENSAGEM = "t_mensagem";
    public static final String T_DUPLACRIPTO = "t_duplacripto";
    public static final String T_teste = "";


    // colunas tabela produto
    public static final String T_NH = "nH";
    public static final String T_IMT = "imt";
    public static final String T_IMP = "imp";



    public static String TABELA_PRODUTO = "produto";
    public static final String ID_PRODUTO = "id";
    public static final String T_COD = "t_cod";
    public static final String T_NOME = "t_nome";
    public static final String T_VALOR = "t_valor";
    public static final String T_CATEGORIA = "t_categoria";
    public static final String T_BARRAS = "t_barras";
    public static final String T_UNIDADE = "t_unidade";
    public static final String T_NCMID = "ncmid";
    public static final String T_GFID = "gfid";

    // colunas tabela pendente
    public static final String TABELA_PENDENTE = "pendentes";
    public static final String ID_PENDENTE = "id";
    public static final String T_ACAO = "t_acao";
    public static final String T_CARRINHO = "t_carrinho";
    public static final String T_TOTAL = "t_total";
    public static final String T_DESC = "t_desc";
    public static final String T_TROCO = "t_troco";
    public static final String T_IDF = "t_idf";
    public static final String T_IDNFE = "t_idnfe";
    public static final String T_CPF = "t_cpf";
    public static final String T_TIPO = "t_tipo";

    public static final String T_NSU = "t_veaut";   //t_nsu
    public static final String T_CV_NUMBER = "t_veseq";
    public static final String T_BAND = "t_veoper";
    public static final String T_MODAL = "t_vemod";
    public static final String T_PARCELAS= "t_parcel";




    // colunas tabela digito verificador
    public static final String TABELA_CONTATADOR = "contador";
    public static final String ID_CONTATOR = "id";
    public static final String T_IDF_CONTADOR = "t_idf";


    // status get NEt

    public static final String ARG_AMOUNT = "amount";
    public static final String ARG_CALLER_ID = "callerId";
    public static final String ARG_NSU = "nsu";
    public static final String ARG_NSU_LAST_SUCESSFUL = "nsuLastSuccesfullMessage";
    public static final String ARG_CV_NUMBER = "cvNumber";
    public static final String ARG_TYPE = "type";
    public static final String ARG_BRAND = "brand";
    public static final String ARG_INPUT_TYPE = "inputType";
    public static final String ARG_INSTALLMENTS = "installments";
    public static final String ARG_GMDATATIME = "gmtDateTime";
    public static final String ARG_NSU_LOCAL = "nsuLocal";
    public static final String ARG_AUTORIZATION_CODE = "authorizationCode";
    public static final String ARG_CARD_BIN = "cardBin";
    public static final String ARG_CARDLAST_DIGITIS = "cardLastDigits";
    public static final String ARG_EXTRASCREENS_RESULT = "extraScreensResult";
    public static final String ARG_CARD_HOLDER_NAME = "cardholderName";
    public static final String ARG_AUTOMATION_SLIP = "automationSlip";


    // INFO GET NET

    public static final String ARG_EC = "ec";
    public static final String ARG_NUM_SERIE = "numserie";
    public static final String ARG_NUM_LOGIC = "numlogic";
    public static final String ARG_VERSION = "version";
    public static final String ARG_CNPJ = "cnpjEC";
    public static  final String ARG_NAME = "nomeEC";
    public static final String ARG_RAZAO_SOCIAL = "razaoSocialEC";
    public static final String ARG_CIDADE = "cidadeEC";

    //IMPRESSORA STATUS INGENICO GETNET
    public static final int OK = 0;
    public static final int finalPRINTING = 1;
    public static final int finalERROR_NOT_INIT = 2;
    public static final int finalERROR_OVERHEAT = 3;
    public static final int finalERROR_BUFOVERFLOW = 4;
    public static final int finalERROR_PARAM = 5;
    public static final int finalERROR_LIFTHEAD = 10;
    public static final int finalERROR_LOWTEMP = 11;
    public static final int finalERROR_LOWVOL = 12;
    public static final int finalERROR_MOTORERR = 13;
    public static final int finalERROR_NO_PAPER = 15;
    public static final int finalERROR_PAPERENDING = 16;
    public static final int finalERROR_PAPERJAM = 17;
    public static final int finalUNKNOW = 1000;



}
