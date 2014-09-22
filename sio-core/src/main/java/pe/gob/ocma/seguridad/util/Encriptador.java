/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión de los requerimientos del
 * personal de la OCMA. Constiene las funcionalidades desde
 * que el solicitante realiza una solicitud de un requerimiento 
 * hasta que es atendido por el personal encargado.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.seguridad.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Clase para encriptar y desencriptar.
 * @author César Altamirano Menor
 * 02/09/2013 15:04:07
 */
public final class Encriptador {

	private static String s= "SunJCAES/ECB3";
	private static SecretKey key;
	private static Cipher cipher;
	private static Base64 coder;
	
	static {
		try {
			s+="CS5";
			key = new SecretKeySpec(s.getBytes(), "AES" );
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "SunJCE" ) ;
			coder = new Base64();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public static synchronized String encriptar(String plainText) throws Exception {
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText = cipher.doFinal(plainText.getBytes());
		return new String(coder.encode(cipherText));
	}
	
	public static synchronized String desencriptar(String codedText) throws Exception {
		byte[] encypted = coder.decode(codedText.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decrypted = cipher.doFinal(encypted);
		return new String(decrypted);
	}
}