package unah.edu.hn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.model.Supervisor;
import unah.edu.hn.repository.RepositorySupervisor;

@Service
public class ServiceSupervisor {
	@Autowired
	RepositorySupervisor repositorySupervisor;
	
	public void CrearSupervisor(Supervisor supervisor) {
		this.repositorySupervisor.save(supervisor);
	}
	
	public List<Supervisor> obtenerTodosSupervisor(){
		return this.repositorySupervisor.findAll();
	}
	
	public Supervisor buscarSupervisor(int id) {
		return this.repositorySupervisor.findById(id);
	}

}
