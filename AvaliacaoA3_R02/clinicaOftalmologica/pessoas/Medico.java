package pessoas;

import java.util.ArrayList;
import java.util.Scanner;

public class Medico extends Pessoa {

	private String crm;
	public ArrayList<Medico> listMedicos = new ArrayList<>(); //Declaracao da arrayList para armazenar todos os objetos cadastrados

	public Medico() {
		super();
	}

	public Medico(String nome, String cpf, String rg, Character sexo, String dataNasc, String crm) {
		super(nome, cpf, rg, sexo, dataNasc);
		this.crm = crm;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public ArrayList<Medico> getListMedicos() {
		return listMedicos;
	}

	public void setListMedicos(ArrayList<Medico> listMedicos) {
		this.listMedicos = listMedicos;
	}

	@Override
	public String toString() {
		 return "Medico{" + super.toString() + ", " + crm + '}';
	}	

//REVER	- metodo personalizado para cadastrar novo medico
    public void cadastrarNovo(Scanner sc){   	
    	System.out.println("Informe os dados do novo medico: "); 
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
	   	System.out.print("CRM: ");
	   	String crm = sc.next();
		this.crm = crm;		

    	listMedicos.add(this);   
    	
	   	System.out.print("Medico cadastrado! ");
		System.out.println(this); 
		System.out.println(); 		      
    }

//REVER	- metodo personalizado para listar todos os medicos
    public void listarMedico(){
        for(Medico m: listMedicos){
        	System.out.println(m.toString());
        }
    }
	
}
