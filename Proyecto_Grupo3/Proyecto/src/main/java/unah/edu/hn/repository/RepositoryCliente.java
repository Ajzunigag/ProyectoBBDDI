package unah.edu.hn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.hn.model.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente,Integer>{
	public Cliente findById(int id);

}
