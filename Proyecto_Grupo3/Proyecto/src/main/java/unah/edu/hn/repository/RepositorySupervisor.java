package unah.edu.hn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.hn.model.Supervisor;

public interface RepositorySupervisor extends JpaRepository<Supervisor,Integer>{
	public Supervisor findById(int id);

}
