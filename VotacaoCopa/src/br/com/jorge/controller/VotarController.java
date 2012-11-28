package br.com.jorge.controller;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.octo.captcha.CaptchaException;

import nl.captcha.Captcha;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.jorge.bo.MascoteBo;
import br.com.jorge.exceptions.BussinessException;
import br.com.jorge.to.MascoteTO;


@Resource
public class VotarController {
	private final MascoteBo mascoteBO;
	private final Validator validator;
	private final Result result;
	private final ServletContext servletContext;
	private final HttpServletRequest request;
	
	/**
	 * Construtor simples.
	 * @param bo bo
	 * @param validator validator
	 * @param result result
	 * @param servletContext servletContext
	 * @param request request
	 */
	public VotarController(MascoteBo bo, Validator validator, Result result, ServletContext servletContext, HttpServletRequest request) {
		this.servletContext = servletContext;
		this.mascoteBO = bo;
		this.validator = validator;
		this.result = result;
		this.request = request;
	}

	/**
	 * Exibe tela de votação.
	 */
	@Path("/votacao")
	public void votacao() {
	}

	/**
	 * Exibe tela de resultados.
	 * @return lista de mascoteTO para ser usado na tela
	 */
	@Path("/resultados")
	public List<MascoteTO> resultados() {
		if (!isMostraResultados()) {
			validator.add(new ValidationMessage("Resultados ainda não divulgados!", "Ops..."));
		}
		validator.onErrorUsePageOf(IndexController.class).index();
		return mascoteBO.listaTudo();
	}


	/**
	 * Responsavel por cadastrar o voto.
	 * @param mascoteTO
	 */
	public void votar(MascoteTO mascoteTO){
		try {
			this.checkCaptcha(mascoteTO.getCaptcha());		
			mascoteBO.vota(mascoteTO.getNome());
		} catch (CaptchaException e) {
			validator.add(new ValidationMessage(e.getMessage(), ""));
		} catch (BussinessException e) {
			validator.add(new ValidationMessage("Erro ao gravar o seu voto", "Tente novamente mais tarde"));
			//TODO:logar e.getmessage
		}

		validator.onErrorUsePageOf(this).votacao();
		result.include("mensagem", "Seu voto foi computado com sucesso!");
		result.redirectTo("/votacao");
	}

	/**
	 * Verifica parametro de conf para retornar se pode ou não mostrar a tela de resultados.
	 * @return true se for para mostrar a tela de resultados
	 */
	private Boolean isMostraResultados() {
		return new Boolean(servletContext.getInitParameter("isMostraResultados"));
	}

	/**
	 * Valida o captcha.
	 * TODO mover par uma classe de validação de captcha
	 * @param captchaIn
	 * @throws CaptchaException
	 */
	private void checkCaptcha(String captchaIn) throws CaptchaException {
		if (StringUtils.isEmpty(captchaIn)) {
			throw new CaptchaException("Captcha não preenchido");
		} else {
			final Captcha captcha = (Captcha) request.getSession().getAttribute(Captcha.NAME);
			if (!captcha.isCorrect(captchaIn)) {
				throw new CaptchaException("Captcha invalido!");
			}
		}
	}
}
