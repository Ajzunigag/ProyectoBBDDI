package unah.edu.hn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.hn.model.Mecanico;
public interface RepositoryMecanico extends JpaRepository<Mecanico,Integer>{
	public Mecanico findById(int id);

}
