package pessoas;

import java.util.ArrayList;
import java.util.Scanner;

public class Paciente extends Pessoa {

	private String celular;    
	public ArrayList<Paciente> listPacientes = new ArrayList<>();//Declaracao da arrayList para armazenar todos os objetos cadastrados

	public Paciente() {
		super();
	}

	public Paciente(String nome, String cpf, String rg, Character sexo, String dataNasc, String celular) {
		super(nome, cpf, rg, sexo, dataNasc);
		this.celular = celular;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public ArrayList<Paciente> getListPacientes() {
		return listPacientes;
	}

	public void setListPacientes(ArrayList<Paciente> listPacientes) {
		this.listPacientes = listPacientes;
	}
	
//REVER	- metodo personalizado para cadastrar novo paciente
    public void cadastrarNovo(Scanner sc) {   	
    	System.out.println("Informe os dados do novo paciente: "); 
    	System.out.print("Nome: "); 
    	String nome = sc.next();
    	this.nome = nome;
       	System.out.print("CPF: ");
       	String cpf = sc.next();
		this.cpf = cpf;
	   	System.out.print("RG: ");
	   	String rg = sc.next();
		this.rg = rg;
	   	System.out.print("Sexo: ");
		Character sexo = sc.next().charAt(0);
		this.sexo = sexo;
	   	System.out.print("Data de Nascimento: ");
		String dataNasc = sc.next();
		this.dataNasc = dataNasc;
	   	System.out.print("Celular: ");
	   	String celular = sc.next();
		this.celular = celular;		

    	listPacientes.add(this);   
    	
	   	System.out.print("Paciente cadastrado! ");
		System.out.println(this); 
		System.out.println(); 		      
    }

//REVER	- imprimir relacao de pacientes	
    public void relacaoPacientes() {
        System.out.println("Lista de Pacientes:");
		for (int i = 0; i < listPacientes.size(); i++) {
			System.out.println(listPacientes.get(i));		
            System.out.println();
        }
    }

	@Override
	public String toString() {
		return "[" + super.toString() + celular + "]";
	}
	

    
}
