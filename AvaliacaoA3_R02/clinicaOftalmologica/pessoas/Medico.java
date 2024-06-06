package pessoas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

//import operacoes.Consulta;

public class Medico extends Pessoa {

	private String crm;
	private String subspec;
	
    private ArrayList<Medico> listMedicos = new ArrayList<>();
    
    private Scanner sc = new Scanner(System.in);

    // Construtor vazio
    public Medico() {
        super();
    }

    // Construtor completo
    public Medico(String nome, String cpf, String rg, char sexo, String dataNasc, String crm, String subspec) {
        super(nome, cpf, rg, sexo, dataNasc);
        this.crm = crm;
        this.subspec = subspec;
    }
    
    //Objetos pre-cadastrados. 	
    public void medicosPreCadastrados(){  
	listMedicos.add(new Medico("Medico Joao", "11111111111", "1111111111", 'M', "03/01/2000", "999999999", "catarata"));
	listMedicos.add(new Medico("Medica Maria", "22222222222", "2222222222", 'F', "28/12/1992", "999999999", "glaucoma"));
    }
    
	// Método de cadastrar médico
    public void cadastrarMedico(Scanner sc) {
        try {
            System.out.println("Informe os dados do novo médico:");
            sc.nextLine();
            System.out.print("NOME: ");
            String nome = sc.nextLine();
            this.nome = nome;
            System.out.print("CPF: ");
            String cpf = sc.nextLine();
            this.cpf = cpf;
            System.out.print("RG: ");
            String rg = sc.nextLine();
            this.rg = rg;
            System.out.print("SEXO: ");
            Character sexo = sc.nextLine().charAt(0);
            this.sexo = sexo;
            System.out.print("DATA DE NASCIMENTO: ");
            String dataNasc = sc.nextLine();
            this.dataNasc = dataNasc;
            System.out.print("CRM: ");
            String crm = sc.nextLine();
            System.out.print("SUBESPECIALIDADE: ");
            String subspec = sc.nextLine();

            listMedicos.add(new Medico(nome, cpf, rg, sexo, dataNasc, crm, subspec)); 

            System.out.println("Médico cadastrado!");
            System.out.println();
            
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir o tipo correto de dados.");
            sc.nextLine();
        }
    }
	//Método de editar cadastro de médicos
    public void editarMedico() {
			System.out.print("Informe o nome do médico:");
			String procurarMedico = sc.next();
			
			boolean encontrado = false;
	
			for (int i = 0; i < listMedicos.size(); i++) {
				if (listMedicos.get(i).getNome().equalsIgnoreCase(procurarMedico)) {
					encontrado = true;
					while (true) {
						try {
							System.out.println();
							System.out.println("*** ATUALIZAR MEDICO EXISTENTE ***");
					 		System.out.println();
							System.out.println("[1] Atualizar NOME.");
							System.out.println("[2] Atualizar CPF.");
							System.out.println("[3] Atualizar RG.");
							System.out.println("[4] Atualizar SEXO.");
							System.out.println("[5] Atualizar DATA NASCIMENTO.");
							System.out.println("[6] Atualizar CRM.");
							System.out.println("[7] Atualizar ESPECIALIZACAO.");
							System.out.println();	
							System.out.println("[0] Voltar para o MENU PRINCIPAL.");
							System.out.println();							
							System.out.print("Informe a opcao desejada:");

							
							int selecao = sc.nextInt();
							System.out.println();	
							
							switch (selecao) {
								case 1:
								System.out.print("Informe o novo NOME:");
								String nome = sc.next();
								listMedicos.get(i).setNome(nome);
								break;
							case 2:
								System.out.print("Informe o novo CPF:");
								String cpf = sc.next();
								listMedicos.get(i).setCpf(cpf);
								break;
							case 3:
								System.out.print("Informe o novo RG:");
								String rg = sc.next();
								listMedicos.get(i).setRg(rg);
								break;
							case 4:
								System.out.print("Informe o novo SEXO:");
								Character sexo = sc.next().charAt(0);
								listMedicos.get(i).setSexo(sexo);
								break;
							case 5:
								System.out.print("Informe a nova DATA DE NASCIMENTO:");
								String dataNasc = sc.next();
								listMedicos.get(i).setDataNasc(dataNasc);
								break;
							case 6:
								System.out.print("Informe o novo CRM:");
								String crm = sc.next();
								listMedicos.get(i).setCrm(crm);
								break;
							case 7:
								System.out.print("Informe a nova SUBESPECIALIDADE:");
								String subspec = sc.next();
								listMedicos.get(i).setCrm(subspec);
								break;
							case 0:
								System.out.println("Operacao encerrada.");
								return;
	  
							default:
                                System.out.println("Opcao invalida, tente novamente.");
								break;
							}
						} catch (InputMismatchException e) {
							System.out.println("Entrada invalida. Por favor, insira um número.");
							sc.nextLine();
						}
					}
				}
				
				if (!encontrado) {
					continue;
				}

				System.out.println("Medico nao encontrado.");
				System.out.println();
			}
    }

    public void excluirMedico() {
        System.out.print("Informe o NOME do Medico a ser excluido:");
        String medicoExcluir = sc.next();

        Iterator<Medico> it = listMedicos.iterator();
        while (it.hasNext()) {
            Medico medico = it.next();
            if (medico.getNome().equals(medicoExcluir)) {
                it.remove();
                System.out.println("Medico excluido com sucesso.");
                System.out.println();
                return;
            }
        }
        System.out.println("Medico nao encontrado.");
    }

 // Método para buscar Medico especifico ou listar relação de Medicos
 	public void relacaoMedicos() {
 		int opcao;
 	
 		System.out.println("*** LISTA MEDICOS ***");
 		System.out.println();
 		System.out.println("[1] Buscar Médico por NOME.");
 		System.out.println("[2] Imprimir relação de Medicos cadastrados.");
 		System.out.println();
 		System.out.print("Informe a opcao desejada: ");
 		opcao =sc.nextInt();
 		System.out.println();
 		
 		if (listMedicos.isEmpty()) {
 			System.out.println("Nao ha Medicos cadastrados!");
 			System.out.println();
 			return;
 		} else {
 			switch(opcao) {
 				
 			case 1:
        		sc.nextLine();
 				System.out.print("Insira o NOME do Medico: ");
 				
 				String buscar = sc.nextLine();
 		        
 				boolean encontrado = false;
 				
 				for (Medico medico: listMedicos){
 					if (medico.getNome().equalsIgnoreCase(buscar)) {
 						
 						encontrado = true;
 						
 						System.out.println();
 						System.out.print("Medico encontrado:");
 						System.out.println(medico);
 					}	 							
 				}
	 			if (!encontrado) {
	 				System.out.println();
 	 				System.out.println("Medico nao encontrado!");	
 	 			}
 				break; 
 			
 			case 2: 
				System.out.println("---------- RELACAO DE MEDICOS ----------");
 			
			    for(Medico m: listMedicos) {
			    	System.out.println(m);
			    }
			    
				System.out.println("------------------------------------------------------");
				System.out.println();
 				break;

 			default: //caso escolham uma opcao inexistente
 				System.out.println("Opcao invalida, tente novamente.");
 				break;
 			}
 		}    
 	}
    
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspec() {
        return subspec;
    }

    public void setEspec(String subspec) {
        this.subspec = subspec;
    }

    @Override
    public String toString() {
        return "[" + nome + ", " + cpf + ", " + crm + "]";
    }
}