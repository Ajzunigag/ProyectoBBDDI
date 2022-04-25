package unah.edu.hn.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.model.Auto;
import unah.edu.hn.model.Cita;
import unah.edu.hn.model.Cliente;
import unah.edu.hn.model.IdCita;
import unah.edu.hn.model.Mecanico;
import unah.edu.hn.model.Supervisor;
import unah.edu.hn.service.ServiceAuto;
import unah.edu.hn.service.ServiceCita;
import unah.edu.hn.service.ServiceCliente;
import unah.edu.hn.service.ServiceMecanico;
import unah.edu.hn.service.ServiceSupervisor;

@Controller
public class Controlador {
	@Autowired
	ServiceAuto serviceAuto;
	@Autowired
	ServiceCliente serviceCliente;
	@Autowired
	ServiceMecanico serviceMecanico;
	@Autowired
	ServiceSupervisor serviceSupervisor;
	@Autowired
	ServiceCita serviceCita;
	
	
	
	//========================================================================
	//  Supervisor
	//========================================================================
	@GetMapping("/supervisor/registrarSupervisor")
	public String registrarSupervisor() {
		return "registrarSupervisor";
	}
	
	@RequestMapping (value = "/supervisor/crearSupervisor",method=RequestMethod.POST)
	public String crearSupervisor(@RequestParam(name = "id") int idSupervisor,
			                          @RequestParam(name = "nombre") String nombre,
                                      @RequestParam(name = "apellido") String apellido,
                                      @RequestParam(name = "direccion") String direccion,
                                      @RequestParam(name = "telefono") String telefono) {
		  Supervisor tmpSupervisor=new Supervisor(idSupervisor,nombre,apellido,direccion,telefono);
		  this.serviceSupervisor.CrearSupervisor(tmpSupervisor);
		  return "registrarSupervisor";
		  }
	@RequestMapping(value ="/supervisor/listaSupervisor",method=RequestMethod.GET)
	public String listadoSupervisor(Model model) {
		List<Supervisor> supervisor=this.serviceSupervisor.obtenerTodosSupervisor();
		model.addAttribute("supervisor",supervisor);
		return "listarSupervisor";
	}
	@RequestMapping(value ="/supervisor/buscarSupervisor",method=RequestMethod.GET)
	public Supervisor buscarSupervisor(@RequestParam(name = "id") int idSupervisor) {
		return this.serviceSupervisor.buscarSupervisor(idSupervisor);
	}
	
	//==================================================================
		// Mecanico
		//==================================================================
	@GetMapping("/mecanico/registrarMecanico")
	public String registrarMecanico() {
		return "registrarMecanico";
	}
	
	
		@RequestMapping(value ="/mecanico/crearMecanico",method=RequestMethod.POST)
		public String crearMecanico(@RequestParam(name = "idMecanico") int idMecanico,
			                          @RequestParam(name = "nombre") String nombre,
			                          @RequestParam(name = "apellido") String apellido,
			                          @RequestParam(name = "telefono") String telefono,
			                          @RequestParam(name = "direccion") String direccion,
			                          @RequestParam(name = "idSupervisor") int idSupervisor) {
			
			Supervisor supervisor=this.serviceSupervisor.buscarSupervisor(idSupervisor);
			Mecanico mecanico = new Mecanico(idMecanico, nombre,apellido,telefono,direccion,supervisor);
			this.serviceMecanico.crearMecanico(mecanico);
			return "registrarMecanico";
			
		}
		
		
		@RequestMapping(value ="/mecanico/listaMecanicos",method=RequestMethod.GET)
		public String listadoMecanicos(Model model) {
			List<Mecanico> mecanicos=this.serviceMecanico.obtenerTodosMecanicos();
			model.addAttribute("mecanicos",mecanicos);
			
			return "listadoMecanicos";
		}
		
		@RequestMapping(value ="/mecanico/buscarMecanico",method=RequestMethod.GET)
		public Mecanico buscarMecanico(@RequestParam(name = "id") int idMecanico) {
			return this.serviceMecanico.buscarMecanico( idMecanico);
		}
		
			
	
	//=======================================================================
	//Clientes
	//======================================================================
		@GetMapping("/cliente/registrarCliente")
		public String registrarCliente() {
			return "registrarCliente";
		}
	@RequestMapping (value = "/cliente/crearCliente",method=RequestMethod.POST)
	public String crearCliente(@RequestParam(name = "idCliente") int idCliente,
			                    @RequestParam(name = "nombre") String nombre,
			                    @RequestParam(name = "apellido") String apellido,
			                    @RequestParam(name = "direccion") String direccion,
			                    @RequestParam(name = "telefono") String telefono) {
		
		Cliente tmpCliente = new Cliente(idCliente,nombre,apellido,direccion,telefono);
		this.serviceCliente.crearCliente(tmpCliente);
		return "registrarCliente";
	}
	
	@RequestMapping(value = "/cliente/listarCliente",method=RequestMethod.GET)
	public String listarCliente(Model model){
		List<Cliente> cliente=this.serviceCliente.obtenerTodosClientes();
		model.addAttribute("cliente",cliente);
		
		return "listarCliente";
	}
	
	//=======================================================================
	//Autos
	//======================================================================
	@GetMapping("/auto/registrarAuto")
	public String registrarAuto() {
		return "registrarAuto";
	}
	
	@RequestMapping (value = "/auto/crearAuto",method=RequestMethod.POST)
	public String crearAuto(@RequestParam(name= "placa") int placa,
			                 @RequestParam(name= "numeroMotor") String numeroMotor,
			                 @RequestParam(name= "modelo") String modelo,
			                 @RequestParam(name= "idCliente") int idCliente) {
		
		Cliente c = this.serviceCliente.buscarCliente(idCliente);
		Auto tmpAuto = new Auto(placa,numeroMotor,modelo,c);
		this.serviceAuto.CrearAuto(tmpAuto);
		return "registrarAuto";
	}
	
	@RequestMapping(value = "/auto/listadoAuto",method=RequestMethod.GET)
	public String listarAuto(Model model){
		List<Auto> auto=this.serviceAuto.obtenerTodosAuto();
		model.addAttribute("auto",auto);
		
		return "listadoAuto";
	}
	
	//=======================================================================
	//Revision
	//======================================================================
	@GetMapping("/cita/registrarCita")
	public String registrarCita() {
		return "registrarCita";
	}
	
	@RequestMapping (value = "/cita/crearCita",method=RequestMethod.POST)
	public String crearRevision(@RequestParam(name = "placa") int placa,
			                      @RequestParam(name = "idMecanico") int idMecanico,
			                      @RequestParam(name = "fechaRevision") @DateTimeFormat(iso = ISO.DATE)  LocalDate fechaRevision,
			                      @RequestParam(name = "descripcion") String descripcion,
			                      @RequestParam(name = "estado") String estado,
			                      @RequestParam(name = "fechaDeEntrega") String fechaDeEntrega,
			                      @RequestParam(name = "idCliente") int idCliente) {
		
		
		Auto auto = this.serviceAuto.buscarAuto(placa);
		Mecanico mecanico = this.serviceMecanico.buscarMecanico(idMecanico);
		Cliente cliente=this.serviceCliente.buscarCliente(idCliente);
		cliente.getIdCliente();
		
		
		Cita tmpCita = new Cita(placa, idMecanico, idCliente, fechaRevision,descripcion,  estado, fechaDeEntrega, auto,mecanico);
		
		
		
		this.serviceCita.CrearRevision(tmpCita);
		
	     return "registrarCita";
	}

	@RequestMapping(value = "/Cita/buscar",method=RequestMethod.GET)
	public Cita buscarRevision(@RequestParam(name = "idAuto") int idAuto,
					                @RequestParam(name = "idMecanico") int idMecanico,
					                @RequestParam(name = "fechaRevision") @DateTimeFormat(iso = ISO.DATE)  LocalDate fechaRevision,
					                @RequestParam(name = "idCliente") int idCliente
					                ){
		IdCita idCita = new IdCita(idAuto, idMecanico, idCliente, fechaRevision);
		return this.serviceCita.buscarRevision(idCita);
	}
	
	@RequestMapping(value = "/cita/listarCita",method=RequestMethod.GET)
	public String listarCita(Model model){
		List<Cita> cita=this.serviceCita.obtenerTodaCita();
		model.addAttribute("cita", cita);
		return "listarCita";
	}

	
	



}
