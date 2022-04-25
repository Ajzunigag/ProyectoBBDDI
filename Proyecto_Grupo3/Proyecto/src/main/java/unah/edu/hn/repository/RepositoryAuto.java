package unah.edu.hn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.hn.model.Auto;

public interface RepositoryAuto extends JpaRepository<Auto,Integer>{
	public Auto findById(int placa);

}
