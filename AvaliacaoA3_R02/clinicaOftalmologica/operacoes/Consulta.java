package operacoes;

import pessoas.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Consulta {
	private String pacienteNome;
	private String medicoNome;
	private String data;
	private String horario;

	public ArrayList<Consulta> listConsultas = new ArrayList<>();//Declaracao da arrayList para armazenar todos os objetos cadastrados
	
	public Consulta() {
		super();
	}


	public Consulta(String pacienteNome, String medicoNome, String data, String horario) {
		super();
		this.pacienteNome = pacienteNome;
		this.medicoNome = medicoNome;
		this.data = data;
		this.horario = horario;
	}


	public String getPacienteNome() {
		return pacienteNome;
	}


	public void setPacienteNome(String pacienteNome) {
		this.pacienteNome = pacienteNome;
	}


	public String getMedicoNome() {
		return medicoNome;
	}


	public void setMedicoNome(String medicoNome) {
		this.medicoNome = medicoNome;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	@Override
	public String toString() {
		return "Consulta [Paciente:" + pacienteNome + ", Medico:" + medicoNome + ", Data:" + data + ", Horario:"
				+ horario + "]";
	}


//REVER	- metodo personalizado para agendar nova consulta
	public void cadastrarNovo(Scanner sc){
    	System.out.println("Informe os dados do novo medico: "); 
    	System.out.print("Medico: "); 
    	String medicoNome = sc.next();
    	this.medicoNome = medicoNome;
	   	System.out.print("Paciente: ");
	   	String pacienteNome = sc.next();
		this.pacienteNome = pacienteNome;	
	   	System.out.print("Data: ");
	   	String data = sc.next();
		this.data = data;
	   	System.out.print("Horario: ");
	   	String horario = sc.next();
		this.horario = horario;

    	listConsultas.add(this);   
    	
	   	System.out.print("Consulta agendada! ");
		System.out.println(this); 
		System.out.println(); 	
    }

//REVER	- metodo personalizado para listar todas as consultas
	public void listarConsultas(){
        for(Consulta c: listConsultas){
        	System.out.println(c.toString());
        }    
    }

	
	
}
