package unah.edu.hn.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Auto")
public class Auto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int placa;
	private String numeroMotor;
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name="idcliente")
	@JsonBackReference
	private Cliente cliente;
	
	public Auto() {}
	
	public Auto(int placa, String numeroMotor, String modelo, Cliente cliente) {
		super();
		this.placa = placa;
		this.numeroMotor = numeroMotor;
		this.modelo = modelo;
		this.cliente = cliente;
	}

	public int getPlaca() {
		return placa;
	}

	public void setPlaca(int placa) {
		this.placa = placa;
	}

	public String getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
