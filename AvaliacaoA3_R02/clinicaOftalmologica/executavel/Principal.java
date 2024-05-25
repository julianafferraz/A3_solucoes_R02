package executavel;

import operacoes.*;
import pessoas.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Paciente> listPacientes;
		ArrayList<Medico> listMedicos;
		ArrayList<Consulta> listConsultas;

        //Objetos já cadastrados (pelo menos 7)
        Paciente novoPaciente = new Paciente();
        Medico novoMedico = new Medico();
        Consulta novaConsulta = new Consulta();	
		
        Scanner sc = new Scanner (System.in);

        listPacientes.add(new Paciente("Amos", "11111111111", "1111111111", 'M', "03/01/2000", "999999999"));
        listPacientes.add(new Paciente("Juliana", "22222222222", "222222", 'M', "28/12/1992", "999999999"));
        listPacientes.add(new Paciente("Miguel", "33333333333", "222222", 'M', "03/01/2000", "999999999"));
        listPacientes.add(new Paciente("Nair", "44444444444", "222222", 'M', "03/01/2000", "999999999"));
        listPacientes.add(new Paciente("Yule", "55555555555", "222222", 'M', "03/01/2000", "999999999"));
        listPacientes.add(new Paciente("Joao", "66666666666", "222222", 'M', "03/01/2000", "999999999"));
        listPacientes.add(new Paciente("Maria", "777777777777", "222222", 'M', "03/01/2000", "999999999"));

        System.out.println(listPacientes);
		
        while (true) {
        	System.out.println("*** MENU ***");	
        	System.out.println();              
        	System.out.println("[1] Cadastrar novo paciente.");	
        	System.out.println("[2] Editar cadastro de paciente existente.");             
            System.out.println("[3] Ver relação de pacientes.");  
        	System.out.println(); 
        	System.out.println("[4] Cadastrar novo medico.");				
        	System.out.println("[5] Editar cadastro de medico existente.");
            System.out.println("[6] Ver relação de medicos."); 
        	System.out.println();          
        	System.out.println("[7] Agendar nova consulta.");	
        	System.out.println("[8] Editar agendamento existente.");  
            System.out.println("[9] Ver relação de consultas.");  
        	System.out.println(); 
        	System.out.println("[0] Encerrar programa.");	
        	System.out.println();          
        	System.out.print("Digite a opção desejada:");
 
        	//entrada da opção escolhida:
        	int op = sc.nextInt();       
        	System.out.println();         
    
        	switch(op) {
        		case 1: //opção 1-Cadastrar novo paciente
        			novoPaciente = new Paciente();
                	novoPaciente.cadastrarNovo(sc);
                    break;
 
        		case 3: //opção 3-Ver relação de pacientes
        			.relacaoPacientes();
                    break;
                    
                case 4: //Cadastrar novo médico
                    novoMedico = new Medico();
                    novoMedico.cadastrarNovo(sc);
                    break;

                case 7: //Cadastrar nova consulta
                    novaConsulta = new Consulta();
                    novaConsulta.cadastrarNovo(sc);
                    break;
                    
                case 0: //Encerrar programa
                     System.out.println("Encerrando o programa...");
                     sc.close();
                     return;

                default: //caso escolham uma opcao inexistente
                     System.out.println("Opção inválida, tente novamente.");
                     break;
       		}
 
        	
        	
        	
        }
	}
}
