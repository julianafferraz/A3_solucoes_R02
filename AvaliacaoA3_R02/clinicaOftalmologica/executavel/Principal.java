package executavel;

import pessoas.Paciente;
import pessoas.Medico;
import operacoes.Consulta;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
      
       // Classes instanciadas
       Paciente novoPaciente = new Paciente();
       Medico novoMedico = new Medico();
       Consulta novaConsulta = new Consulta();	
       

       
       // Classe Scanner	
       try (Scanner sc = new Scanner(System.in)) {
    	   novoPaciente.pacientesPreCadastrados();
    	   novoMedico.medicosPreCadastrados();
    	   novaConsulta.consultasPreCadastradas();
           
           while (true) {
        	   System.out.println();  
               System.out.println("***** MENU PRINCIPAL *****");	
               System.out.println();              
               System.out.println("[1] Cadastrar novo paciente.");	
               System.out.println("[2] Editar cadastro de paciente existente.");
               System.out.println("[3] Excluir paciente");
               System.out.println("[4] Ver relação de pacientes.");
           
               System.out.println(); 
               System.out.println("[5] Cadastrar novo médico.");				
               System.out.println("[6] Editar cadastro de médico existente.");
               System.out.println("[7] Excluir cadastro de médico");
               System.out.println("[8] Ver relação de médicos.");
           
               System.out.println();          
               System.out.println("[9] Agendar nova consulta.");	
               System.out.println("[10] Editar agendamento existente.");  
               System.out.println("[11] Excluir consulta");
               System.out.println("[12] Ver relação de consultas.");
           
               System.out.println(); 
               System.out.println("[0] Encerrar programa.");	
               System.out.println();          
               System.out.print("Digite a opção desejada:");
               
               // Entrada da opção escolhida:
               int op = sc.nextInt();       
               System.out.println();
               
               switch(op) {
                   
                   case 1: // Cadastrar novo paciente
                       novoPaciente.cadastrarPaciente(sc);
                       break;
                   
                   case 2: // Editar cadastro de paciente
                       novoPaciente.editarPaciente();
                       break;
                   
                   case 3: // Excluir paciente
                       novoPaciente.excluirPaciente();
                       break;
                   
                   case 4: // Ver relação de pacientes
                       novoPaciente.relacaoPacientes();
                       break;
                   
                   case 5: // Cadastrar novo médico
                       novoMedico.cadastrarMedico(sc);
                       break;
                   
                   case 6: // Editar cadastro de médico
                       novoMedico.editarMedico();
                       break;
                   
                   case 7: // Excluir médico
                       novoMedico.excluirMedico();
                       break;
                   
                   case 8: // Ver relação de médicos
                       novoMedico.relacaoMedicos();
                       break;
                   
                   case 9: // Cadastrar nova consulta
                       novaConsulta.agendarConsulta(sc);
                       break;
                   
                   case 10: // Editar consulta existente
                       novaConsulta.editarConsulta();
                       break;
                   
                   case 11: // Excluir consulta
                       novaConsulta.excluirConsulta();
                       break;
                   
                   case 12: // Ver relação de consultas
                       novaConsulta.relacaoConsultas();
                       break;
                   
                   case 0: // Encerrar programa
                       System.out.println("Encerrando o programa...");
                       return;
                   
                   default: // Caso escolham uma opção inexistente
                       System.out.println("Opção inválida, tente novamente.");
                       break;
                }
            }
        } catch (Exception e) {
           System.err.println("Ocorreu um erro: " + e.getMessage());
           e.printStackTrace();
        }
    }
}