/**
 * 
 */
package com.org.carvalho.webstore.api.share;

import com.org.carvalho.webstore.api.share.util.enums.SimNao;

/**
 * @author Alex de Carvalho
 *
 */
public final class ConfiguracaoSistema {
	
	public static String confgiVersao = "0.0.1.alpha";
	public static String configNomeSistema = "WebStore Carvalho";
	public static String configRamoAtividade = "Loja Virtual Produtos Eletrônicos";
	public static SimNao configSistemaEmManutencao = SimNao.NAO;
	public static String configSistemaEmManutencaoMensagem = "*Atenção, o sistema esta passando por manutenção, volte mais tarde, "
			+ "em caso de duvídas contate nosso atendimento pelos canais de comunicação.";
	public static SimNao configSistemaAtualizando = SimNao.NAO;
	public static String configSistemaAtualizandoMensagem = "*Atenção, o sistema esta atualizando, alguns serviços podem apresetarem "
			+ " falhas eo sistema ficar lento por alguns minutos, em caso de duvídas contate nosso atendimento pelos canais de comunicação.";
	public static String configSistemaDesenvolvidoPor = "Alex de Carvalho";
	public static String configSistemaDesenvolvidoPorContato = "(46) 9.9999-9999";

}
