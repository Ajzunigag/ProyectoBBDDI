create database TallerMecanico;

use TallerMecanico;

Create table Supervisor(idSupervisor int primary key,nombre varchar(50),apellido varchar(50),
                      telefono varchar(50),direccion varchar(50));
				
Create table Mecanico(idMecanico int primary key,nombre varchar(50),apellido varchar(50),telefono varchar(50),
      direccion varchar(50),idSupervisor int,foreign key(idSupervisor)references Supervisor(idSupervisor));

drop database tallermecanico; 
    
Create table Cliente(idCliente int primary key,nombre varchar(50),apellido varchar(50),
                      telefono varchar(50),direccion varchar(50));

insert into Cliente values(100,"Carlos","Duran","9990445","Jutiapa");

Create table Auto(placa int primary key,modelo varchar(50),numeroMotor varchar(50),idCliente int,
                    foreign key(idCliente) references Cliente(idCliente));  
insert into Auto values(43,"Harbori","h2233",450);
select *from Auto;
				
Create table Cita(fechaRevision Date primary key,descripcion varchar(50),estado varchar(50),fechaEntrega varchar(50),
			placa int,foreign key(placa)references Auto(placa),idMecanico int,
            foreign key(idMecanico)references Mecanico(idMecanico),idCliente int,foreign key(idCliente) references Cliente(idCliente));



insert into Cita values("2022-04-24","Mantenimineto","Ingresado","5 dias",267,200,100);

select*from Cita;


insert into Cliente (id,nombre,apellido,telefono,direccion,idVehiculo)
value("07655","Alejandra","Barahona",948230,"Danli","LaFriaBonitaAlejandraConHilux@gmail.com","PAD5151");

Select * from Auto;

select*from Mecanico;
select*from Cliente;

