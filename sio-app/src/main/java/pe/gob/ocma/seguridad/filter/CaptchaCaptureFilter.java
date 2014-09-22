/**
 * Copyright © 2013 OCMA.
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

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Filtro aplicado para capturar el CAPTCHA
 * 
 * @author Gino Maquera Coyla 10/12/2013 08:30:13
 */
public class CaptchaCaptureFilter extends OncePerRequestFilter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private HttpServletRequest request;
	private String recaptcha_response;
	
	@Override
	public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, 
			FilterChain chain) throws IOException,	ServletException {
		if (req.getParameter("jcaptcha") != null) {
			request = req;
			recaptcha_response = req.getParameter("jcaptcha");
		}
		logger.debug("userResponse: " + recaptcha_response);
		chain.doFilter(req, res);
	}	

	public String getRecaptcha_response() {
		return recaptcha_response;
	}
	
	public void setRecaptcha_response(String recaptcha_response) {
		this.recaptcha_response = recaptcha_response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}