/**                                                                                                                                                                                                            * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión integrada de los procesos de
 * la OCMA.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.seguridad.filter;

/**
 * Valida los datos ingresados en el CAPTCHA
 * @author Gino Maquera Coyla
 * 11/12/2013 09:53:09
 */
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

/**
 * Filter for verifying if the submitted Captcha fields are valid.
 * <p>
 * This filter also allows you to set a proxy if needed
 */
public class CaptchaVerifierFilter extends OncePerRequestFilter {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	private String failureUrl;
	private CaptchaCaptureFilter captchaCaptureFilter;
	private String privateKey;

	private SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

	@Override
	public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		if (captchaCaptureFilter.getRecaptcha_response() != null) {
			if (captchaCaptureFilter.getRecaptcha_response() != "") {
				boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(captchaCaptureFilter.getRequest(), captchaCaptureFilter.getRecaptcha_response());
				if (!captchaPassed) {
					logger.debug("Captcha is invalid!");
					failureHandler.setDefaultFailureUrl(failureUrl);
					failureHandler.onAuthenticationFailure(req, res, new BadCredentialsException("CAPTCHA_INVALID"));
				} else {
					logger.debug("Captcha is valid!");
				}
			} else {
				failureHandler.setDefaultFailureUrl(failureUrl);
				failureHandler.onAuthenticationFailure(req, res, new BadCredentialsException("CAPTCHA_INVALID"));
			}
			resetCaptchaFields();
		}
		chain.doFilter(req, res);
	}

	/**
	 * Reset CAPTCHA fields
	 */
	public void resetCaptchaFields() {
		captchaCaptureFilter.setRecaptcha_response(null);
	}

	public String getFailureUrl() {
		return failureUrl;
	}

	public void setFailureUrl(String failureUrl) {
		this.failureUrl = failureUrl;
	}

	public CaptchaCaptureFilter getCaptchaCaptureFilter() {
		return captchaCaptureFilter;
	}

	public void setCaptchaCaptureFilter(
			CaptchaCaptureFilter captchaCaptureFilter) {
		this.captchaCaptureFilter = captchaCaptureFilter;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
}