package unah.edu.hn.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name="cita")
@IdClass(IdCita.class)
public class Cita implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int placa;
	@Id
	private int idCliente;
	@Id
	private int idMecanico;
	@Id
	private LocalDate fechaRevision;
	
	private String descripcion;
	private String estado;
	private String fechaDeEntrega;
	
	
	@ManyToOne
	@JoinColumn(name="idAuto",referencedColumnName="placa",insertable=false,updatable=false)
	@JsonBackReference
	private Auto auto;
	
	@ManyToOne
	@JoinColumn(name="idMecanico",referencedColumnName="idMecanico",insertable=false,updatable=false)
	@JsonBackReference
	private Mecanico mecanico;
	
	public Cita() {}

	

	



	public Cita(int placa, int idCliente, int idMecanico, LocalDate fechaRevision, String descripcion, String estado,
			String fechaDeEntrega, Auto auto, Mecanico mecanico) {
		super();
		this.placa = placa;
		this.idCliente = idCliente;
		this.idMecanico = idMecanico;
		this.fechaRevision = fechaRevision;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaDeEntrega = fechaDeEntrega;
		this.auto = auto;
		this.mecanico = mecanico;
	}







	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getFechaDeEntrega() {
		return fechaDeEntrega;
	}



	public void setFechaDeEntrega(String fechaDeEntrega) {
		this.fechaDeEntrega = fechaDeEntrega;
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

	public LocalDate getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(LocalDate fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	

	
	
	

}
