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
package pe.gob.ocma.common.util;

/**
 * Clase util que tiene los nombres de las tablas de los diferentes modulos en la base de datos.
 * @author César Altamirano Menor
 * 17/06/2013 12:31:05
 */
public final class Tablas {

	public final static String GETTABLA = "Gettabla";
	
	public final static String GETTABLA_CODTABLA = "codTabla";
	public final static String GETTABLA_NOMTABLA = "nomTabla";
	public final static String GETTABLA_DESCRIPCION = "descripcion";
	
	
	public final static String GETCORRELMAE = "Getcorrelmae";
	public final static String GETCORRELMAE_CODCORREL = "codCorrel";
	public final static String GETCORRELMAE_NOMTABLA = "nomTabla";
	public final static String GETCORRELMAE_CORRELATIVO = "correlativo";
	
	public final static String SETGRUPO = "Setgrupo";
	public final static String SETGRUPO_CODGRUPO = "codGrupo";
	public final static String SETGRUPO_DESCORTA = "desCorta";
	public final static String SETGRUPO_DESCRIPCION = "descripcion";
	public final static String SETGRUPO_CODAUTORIZA = "codAutoriza";
	public final static String SETGRUPO_HABILITADO = "habilitado";
	public final static String SETGRUPO_DES_DISJUD = "Distrito Judicial";
	public final static String SETGRUPO_DES_APP = "Aplicación";
	
	public final static String SETOPCGRUPO = "Setopcgrupo";
	public final static String SETOPCGRUPO_CODGRUPO = "codGrupo";
	public final static String SETOPCGRUPO_CODOPCION = "codOpcion";
	public final static String SETOPCGRUPO_DES_GRUPO = "Grupo";
	public final static String SETOPCGRUPO_DES_OPCION = "Opción";
	
	public final static String SETUSUARIO = "Setusuario";
	public final static String SETUSUARIO_CODUSUARIO = "codUsuario";
	public final static String SETUSUARIO_HABILITADO = "habilitado";
	public final static String SETUSUARIO_DES_CODUSUARIO = "Cod. Usuario";
	public final static String SETUSUARIO_DES_CONSTRASE = "Contraseña";
	public final static String SETUSUARIO_DES_ULTLOGIN = "Ult. Login";
	public final static String SETUSUARIO_DES_ULTRESCLAVE = "Ult. Res. Constraseña";
	public final static String SETUSUARIO_DES_ENVCORREO = "Envío correo";
	public final static String SETUSUARIO_DES_ENVFAX = "Envío Fax";
	public final static String SETUSUARIO_DES_USUARIO = "Usuario";
	public final static String SETUSUARIO_DES_NIVSEG = "Nivel de seguridad";
	public final static String SETUSUARIO_DES_TIPO = "Tipo de usuario";
	
	public final static String SETUSUGRUPO = "Setusugrupo";
	public final static String SETUSUGRUPO_CODUSUARIO = "codUsuario";
	public final static String SETUSUGRUPO_CODGRUPO = "codGrupo";
	public final static String SETUSUGRUPO_HABILITADO = "habilitado";
	public final static String SETUSUGRUPO_DES_CODUSUARIO = "Cod. usuario";
	public final static String SETUSUGRUPO_DES_CODGRUPO = "Cod. grupo";
	public final static String SETUSUGRUPO_DES_USUARIO = "Usuario";
	public final static String SETUSUGRUPO_DES_GRUPO = "Grupo";
	
	public final static String PETTIPO = "Pettipo";
	public final static String PETTIPO_CODCOLUMNA_PERNATURAL = "N";
	
	public final static String PETGENERO = "Petgenero";
	
	public final static String PETPERSONA = "Petpersona";
	public final static String PETPERSONA_CODPERSONA = "codPersona";
	public final static String PETPERSONA_CODTABMAE = "codTabMae";
	public final static String PETPERSONA_CODTIPDOC = "codTipDoc";
	public final static String PETPERSONA_DES_NOMBRE = "Nombre";	
	public final static String PETPERSONA_DES_NUMERODOCUMENTO = "Numero Documento";
	public final static String PETPERSONA_DES_DIRECCION = "Direccion";
	public final static String PETPERSONA_DES_TELEFONO = "Telefono";
	public final static String PETPERSONA_DES_CORREO = "Correo";
	public final static String PETPERSONA_DES_NOTA = "Nota";	
	
	public final static String PETPERNATU = "Petpernatu";
	public final static String PETPERNATU_CODPERNATU = "codPerNatu";
	public final static String PETPERNATU_CODPERSONA = "codPersona";
	public final static String PETPERNATU_CODTABMAE = "codTabMae";
	public final static String PETPERNATU_DES_NOMBRE = "Nombre";
	public final static String PETPERNATU_DES_APELLIDO = "Apellido";
	public final static String PETPERNATU_DES_FECHANACIMIENTO = "Fecha de nacimiento";
	public final static String PETPERNATU_DES_TELEFONOMOVIL = "Telefono movil";	
	
	public final static String TATSOLICITAN = "Tatsolicitan";
	public final static String TATSOLICITAN_CODUSUSOLIC = "codUsuSolic";
	public final static String TATSOLICITAN_HABILITADO = "habilitado";
	public final static String TATSOLICITAN_DES_SOLIC = "Solicitante";
	
	public final static String TATEJECUTOR = "Tatejecutor";
	public final static String TATEJECUTOR_CODUSUEJEC = "codUsuEjec";
	public final static String TATEJECUTOR_HABILITADO = "habilitado";
	public final static String TATEJECUTOR_DES_EJEC = "Responsable de tarea";	
	
	public final static String TATGRUPO = "Tatgrupo";
	public final static String TATGRUPO_CODGRUPO = "codGrupo";
	public final static String TATGRUPO_DESCRIPCION = "descripcion";
	public final static String TATGRUPO_HABILITADO = "habilitado";
	public final static String TATGRUPO_DES_SOLICITANTE = "Solicitante";
	
	
	public final static String TATGRUEJESOL = "Tatgruejesol";
	public final static String TATGRUEJESOL_CODGRUEJESOL = "codGruEjeSol";
	public final static String TATGRUEJESOL_DES_GRUPO = "Grupo";
	public final static String TATGRUEJESOL_DES_EJECUTOR = "Responsable de tarea";
	
	public final static String TATTAREA = "Tattarea";
	public final static String TATTAREA_CODTAREA = "codTarea";
	public final static String TATTAREA_DES_TAREA = "Descripción";
	public final static String TATTAREA_DES_FECCREACION = "Fecha creación";
	public final static String TATTAREA_DES_FECINICIO = "Fecha inicio";
	public final static String TATTAREA_DES_FECFIN = "Fecha fin";
	public final static String TATTAREA_DES_ORIGEN = "Origen";
	public final static String TATTAREA_DES_PRIORIDAD = "Prioridad";
	public final static String TATTAREA_DES_TIPO = "Tipo";
	public final static String TATTAREA_DES_ESTADO = "Estado";
	
	public final static String TATTARDIS = "Tattardis";
	public final static String TATTARDIS_CODTARDIS = "codTarDis";
	public final static String TATTARDIS_DES_TAREA = "Tarea";
	public final static String TATTARDIS_DES_FECCREACION = "Fecha creación";
	public final static String TATTARDIS_DES_RESPONSABLE = "Responsable";
	public final static String TATTARDIS_DES_DISJUD = "Distrito judicial";
	
	public final static String TARTARDIS = "Tartardis";
	public final static String TARTARDIS_CODTARDISDET = "codTarDisDet";
	public final static String TARTARDIS_DES_FECHA = "Fecha";
	public final static String TARTARDIS_DES_TAREA = "Tarea";
	public final static String TARTARDIS_DES_SOLICITAN = "Solicitante";
	public final static String TARTARDIS_DES_RESPON = "Responsable";
	public final static String TARTARDIS_DES_NOTRES = "Notas responsable";
	public final static String TARTARDIS_DES_NOTSOL = "Notas solicitante";
	public final static String TARTARDIS_DES_ESTADO = "Estado";
	public final static String TPRENSA2 = "TPrensa2";
	
	public final static String QVTQUEJA = "Qvtqueja";
	public final static String QVTQUEJA_CODQUEJA = "codQueja";
	public final static String QVTQUEJA_CODDISJUD = "codDisJud";
	public final static String QVTQUEJA_CODTIPO = "codTipo";
	public final static String QVTQUEJA_CODMOTIVO = "codMotivo";
	public final static String QVTQUEJA_CODUSUARIO = "codUsuario";
	public final static String QVTQUEJA_CODTIPOMOV = "codTipMovEst";
	public final static String QVTQUEJA_CODESTADO = "codEstado";
	public final static String QVTQUEJA_CODENCARGADO = "codusuencar";
	public final static String QVTQUEJA_DES_ANIO = "Año Queja";
	public final static String QVTQUEJA_DES_NUMERO = "Numero Queja";
	public final static String QVTQUEJA_DES_FECHA = "Fecha";	
	
	public final static String QVTPRESENCIA = "Qvtpresencia";
	public final static String QVTPRESENCIA_CODPRESENCIA = "codPresencia";
	public final static String QVTPRESENCIA_CODQUEJA = "codQueja";
	public final static String QVTPRESENCIA_CODDEPENDEN = "codDependen";
	public final static String QVTPRESENCIA_CODPROJUD = "codProJud";
	public final static String QVTPRESENCIA_CODAREA = "codArea";
	public final static String QVTPRESENCIA_DES_HORAINICIO = "Hora de inicio";
	public final static String QVTPRESENCIA_DES_HORAFIN = "Hora de fin";
	public final static String QVTPRESENCIA_DES_OBSERVACION = "Observacion";
	public final static String QVTPRESENCIA_DES_TIPOORGANO = "Tipo de organo";
	public final static String QVTPRESENCIA_DES_NOTA = "Nota";
	public final static String QVTPRESENCIA_DES_TELEFONO = "Telefono";
	
	public final static String QVRQUEJA = "Qvrqueja";
	public final static String QVRQUEJA_CODMOVQUEJA = "codMovQueja";
	public final static String QVRQUEJA_CODQUEJA = "codQueja";
	public final static String QVRQUEJA_CODTIPMOVEST = "codTipMovEst";
	public final static String QVRQUEJA_DES_FECHA = "Fecha";	
	public final static String QVRQUEJA_DES_DESCRIPCION = "Descripcion";
	public final static String QVRQUEJA_HABILITADO = "Habilitado";
	
	public final static String QVRDETALLE = "Qvrdetalle";
	public final static String QVRDETALLE_CODDETALLE = "codDetalle";
	public final static String QVRDETALLE_CODQUEJA = "codQueja";	
	public final static String QVRDETALLE_DES_FECHA = "Fecha";	
	public final static String QVRDETALLE_DES_DESCRIPCION = "Descripcion";
	public final static String QVRDETALLE_HABILITADO = "Habilitado";	
	
	public final static String QVRQUEJOSO = "Qvrquejoso";
	public final static String QVRQUEJOSO_CODQUEJOSO = "codQuejoso";
	public final static String QVRQUEJOSO_CODPERSONA = "codPersona";
	public final static String QVRQUEJOSO_DES_DIRECCION = "Direccion";
	public final static String QVRQUEJOSO_DES_CORREO = "Correo";	
	public final static String QVRQUEJOSO_DES_NOTA = "Descripcion";
	public final static String QVRQUEJOSO_HABILITADO = "Habilitado";
	
	public final static String QVRDOCREF = "Qvrdocref";
	public final static String QVRDOCREF_CODDOCREF = "codDocRef";
	public final static String QVRDOCREF_CODQUEJA = "codQueja";
	public final static String QVRDOCREF_CODDEPENDEN = "codDependen";
	public final static String QVRDOCREF_CODTIPDOC = "codTipoDoc";
	public final static String QVRDOCREF_DES_NUMERODOCUMENTO = "Numero Documento";
	public final static String QVRDOCREF_DES_ANIO = "Año";
	public final static String QVRDOCREF_HABILITADO = "Habilitado";
	
	public final static String QVRPROEXP = "Qvrproexp";
	public final static String QVRPROEXP_CODCOMEXP = "codComExp";
	public final static String QVRPROEXP_CODQUEJA = "codQueja";
	public final static String QVRPROEXP_CODTIPPARPRO = "codTipParPro";
	public final static String QVRPROEXP_CODPERSONA = "codPersona";
	public final static String QVRPROEXP_DES_PROCESO = "Descripcion proceso";
	public final static String QVRPROEXP_DES_PARTE = "Parte";	
	public final static String QVRPROEXP_HABILITADO = "Habilitado";	
	
	public final static String QVRQUEJADO = "Qvrquejado";
	public final static String QVRQUEJADO_CODQUEJADO = "codQuejado";
	public final static String QVRQUEJADO_CODQUEJA = "codQueja";
	public final static String QVRQUEJADO_CODPERSONA = "codPersona";
	public final static String QVRQUEJADO_HABILITADO = "Habilitado";	
	
	public final static String AURTRAZA = "Aurtraza";
}