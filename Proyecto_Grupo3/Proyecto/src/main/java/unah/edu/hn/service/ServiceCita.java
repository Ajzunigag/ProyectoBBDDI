package unah.edu.hn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.model.Cita;
import unah.edu.hn.model.IdCita;
import unah.edu.hn.repository.RepositoryCita;


@Service
public class ServiceCita {
	@Autowired
	RepositoryCita repositoryCita;

	public void CrearRevision(Cita cita) {
		this.repositoryCita.save(cita);
	}
	
	public Cita buscarRevision(IdCita citaId) {
		return this.repositoryCita.getOne(citaId);
	}
	
	public List<Cita> obtenerTodaCita(){
		return this.repositoryCita.findAll();
	}
	
	

}
