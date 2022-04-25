package unah.edu.hn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.model.Mecanico;
import unah.edu.hn.repository.RepositoryMecanico;

@Service
public class ServiceMecanico {
	@Autowired
	RepositoryMecanico repositoryMecanico;
	
	public void crearMecanico(Mecanico mecanico) {
		this.repositoryMecanico.save(mecanico);
	}
	public List<Mecanico> obtenerTodosMecanicos(){
		return this.repositoryMecanico.findAll();
	}
	public Mecanico buscarMecanico(int id) {
		return this.repositoryMecanico.findById(id);
	}

}
