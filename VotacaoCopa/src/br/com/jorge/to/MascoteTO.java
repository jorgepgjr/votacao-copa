package br.com.jorge.to;

/**
 *To utilizado para operações com a entidade Mascote
 * @author Jorge
 * @since 27/11/2012
 */
public class MascoteTO {
	private String nome;
	private String captcha;
	private Long percVotos;
	private Long votos;	
	
	public MascoteTO(String nome, Long votos, Long percVotos) {
		this.nome = nome;
		this.votos = votos;
		this.setPercVotos(percVotos);
	}
	
	public MascoteTO() {
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public Long getVotos() {
		return votos;
	}
	public void setVotos(Long votos) {
		this.votos = votos;
	}
	public Long getPercVotos() {
		return percVotos;
	}
	public void setPercVotos(Long percVotos) {
		this.percVotos = percVotos;
	}

}
