package unah.edu.hn.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Embeddable
public class IdCita implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int placa;
	private int idMecanico;
	private int idCliente;
	private LocalDate fechaRevision;
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdCita) {
			IdCita tmpid=(IdCita)obj;
			if(this.placa== tmpid.getPlaca()
					&& this.idMecanico==tmpid.getIdMecanico()
					&&this.idCliente==tmpid.getIdCliente()
					&&this.fechaRevision.compareTo(tmpid.getFechaRevision())==0) {
				return true;
			}else
				return false;
		}else
			return false;
	}
	
	public int hashCode() {
		return (int) this.fechaRevision.hashCode()+this.placa+this.idMecanico+this.idCliente;
	}
	
	public IdCita() {}

	public IdCita(int placa, int idMecanico, int idCliente, LocalDate fechaRevision) {
		super();
		this.placa = placa;
		this.idMecanico = idMecanico;
		this.idCliente = idCliente;
		this.fechaRevision = fechaRevision;
	}

	public int getPlaca() {
		return placa;
	}

	public void setPlaca(int placa) {
		this.placa = placa;
	}

	public int getIdMecanico() {
		return idMecanico;
	}

	public void setIdMecanico(int idMecanico) {
		this.idMecanico = idMecanico;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDate getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(LocalDate fechaRevision) {
		this.fechaRevision = fechaRevision;
	}
	
	
	

	

	
}
