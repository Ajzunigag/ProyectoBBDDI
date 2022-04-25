package unah.edu.hn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.model.Cliente;
import unah.edu.hn.repository.RepositoryCliente;

@Service
public class ServiceCliente {
	@Autowired
	RepositoryCliente repositoryCliente;
	
	public void crearCliente(Cliente cliente) {
		this.repositoryCliente.save(cliente);
	}
	
	public List<Cliente> obtenerTodosClientes(){
		return this.repositoryCliente.findAll();
	}
	
	public Cliente buscarCliente(int id) {
		return this.repositoryCliente.findById(id);
	}

}
