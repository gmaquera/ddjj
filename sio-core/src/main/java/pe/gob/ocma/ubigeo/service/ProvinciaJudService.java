package pe.gob.ocma.ubigeo.service;

import java.util.List;

import pe.gob.ocma.entities.ubigeojud.Ujtprojud;

public interface ProvinciaJudService {
	
	public abstract List<Ujtprojud> listarProvinciaJud();
	
	public abstract List<Ujtprojud> buscarGruposDisJudicial(short codDisJud);
}
