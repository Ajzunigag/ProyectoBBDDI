package unah.edu.hn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.model.Auto;
import unah.edu.hn.repository.RepositoryAuto;

@Service
public class ServiceAuto {
	@Autowired
	RepositoryAuto repositoryAuto;
	
	public void CrearAuto(Auto auto) {
		this.repositoryAuto.save(auto);
	}
	
	public List<Auto> obtenerTodosAuto(){
		return this.repositoryAuto.findAll();
	}
	
	public Auto buscarAuto(int placa) {
		return this.repositoryAuto.findById(placa);
	}

}
