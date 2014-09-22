function guardarUsuarioComplete(xhr, status, args) {
	if(args.save) {
		dlgVarNuevoEditUsuario.hide();
	}
}

function actualizarUsuarioComplete(xhr, status, args, dlg) {
	if(args.save) {
		dlgVarEditarUsuario.hide();
	}
}