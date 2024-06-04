package operacoes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import pessoas.Medico;
import pessoas.Paciente;

public class Consulta {
    private String pacienteNome;
    private String medicoNome;
    private String data;
    private String horario;
    private Integer id=0;
        
    private ArrayList<Consulta> listConsultas = new ArrayList<>();        
    
    public Consulta() {

    }
    
    public Consulta(String pacienteNome, String medicoNome, String data, String horario, Integer id) {
        this.pacienteNome = pacienteNome;
        this.medicoNome = medicoNome;
        this.data = data;
        this.horario = horario;
        this.id = id;
    }
    
    //Objetos pre-cadastrados.
    public void consultasPreCadastradas(){        
    	id++;
    	listConsultas.add(new Consulta("Joao", "Felipe", "24/08/24", "09:30",id));
    	id++;
        listConsultas.add(new Consulta("Maria", "Aline", "21/06/24", "11:00",id));
    }
    
    public void agendarConsulta(Scanner sc) {
        System.out.println("Informe os dados da nova consulta: ");
        System.out.println();
        System.out.print("MEDICO: "); 
        String medico = sc.next();
        System.out.print("PACIENTE: ");
        String paciente = sc.next();
        System.out.print("DATA: ");
        String data = sc.next();
        System.out.print("HORARIO: ");
        String horario = sc.next();
        id++;
        
        listConsultas.add(new Consulta(paciente, medico, data, horario, id));   
        System.out.println();
        System.out.println("Consulta agendada! ID-" + id);
        System.out.println();
    }
        
    public void editarConsulta() { //-------------REVER!
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o ID da consulta: ");
        Integer idProcurado = sc.nextInt();

        for (Consulta consulta : listConsultas) {			
        	boolean encontrado = false;
			
            if (consulta.getId()==idProcurado) {				
            	encontrado = true;
				
                while (true) {
                    try {
    					System.out.println();
                        System.out.println("*** ATUALIZAR CONSULTA ***");
    					System.out.println();
                        System.out.println("[1] Atualizar MEDICO.");
                        System.out.println("[2] Atualizar PACIENTE.");
                        System.out.println("[3] Atualizar DATA.");
                        System.out.println("[4] Atualizar HORARIO.");
						System.out.println();	
                        System.out.println("[0] Voltar para o MENU PRINCIPAL.");
						System.out.println();							
						System.out.print("Informe a opcao desejada:");
	                       
                        int selecao = sc.nextInt();
                        System.out.println();
                        
                        switch (selecao) {
                            case 1:
                                System.out.println("Informe o novo nome do MEDICO: ");
                                String novoMedicoNome = sc.next();
                                consulta.setMedicoNome(novoMedicoNome);
                                break;
                            case 2:
                                System.out.println("Informe o novo nome do PACIENTE: ");
                                String novoPacienteNome = sc.next();
                                consulta.setPacienteNome(novoPacienteNome);
                                break;
                            case 3:
                                System.out.println("Informe a nova DATA: ");
                                String novaData = sc.next();
                                consulta.setData(novaData);
                                break;
                            case 4:
                                System.out.println("Informe o novo HORARIO: ");
                                String novoHorario = sc.next();
                                consulta.setHorario(novoHorario);
                                break;
                            case 0:
                                System.out.println("Operação encerrada.");
                                sc.close();
                                return;
                            default:
                                System.out.println("Opcao invalida, tente novamente.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida. Por favor, insira um número.");
                        sc.next();
                    }
                }
            }
			
            if (!encontrado) {
				continue;
			}
            
            System.out.println("Consulta nao encontrada.");
            sc.close();
            
        }
    }

    public void excluirConsulta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o ID da consulta a ser excluida:");
        Integer idExcluir = sc.nextInt();

        Iterator<Consulta> it = listConsultas.iterator();
        while (it.hasNext()) {
            Consulta consulta = it.next();
            if (consulta.getId().equals(idExcluir)) {
                it.remove();
                System.out.println("Consulta excluida com sucesso.");
                sc.close();
                return;
            }
        }
        System.out.println("Consulta nao encontrada.");
        sc.close();
    }

    public void relacaoConsultas() {
       	System.out.println("---------------- RELACAO DE CONSULTAS ----------------");
	    System.out.println();
	    
        for(Consulta c: listConsultas) {
            System.out.println(c);
        }  
        
	    System.out.println();
	    System.out.println("------------------------------------------------------");
	    System.out.println();
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

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
    public String toString() {
        return "[" + "ID-" + id + ", Paciente: " + pacienteNome + ", Medico: " + medicoNome + ", " + data + ", " + horario + "]";
    }   
}
