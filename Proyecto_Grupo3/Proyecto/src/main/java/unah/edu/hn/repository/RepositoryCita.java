package unah.edu.hn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.hn.model.Cita;
import unah.edu.hn.model.IdCita;


public interface RepositoryCita extends JpaRepository<Cita,IdCita>{
	public Cita getOne(IdCita revisionId);

}
