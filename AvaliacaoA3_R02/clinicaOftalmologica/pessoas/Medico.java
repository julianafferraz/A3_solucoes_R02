package pessoas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public Medico(String nome, String cpf, String rg, Character sexo, String dataNasc, String crm, String subspec) {
        super(nome, cpf, rg, sexo, dataNasc);
        this.crm = crm;
        this.subspec = subspec;
    }
    
    //Objetos pre-cadastrados. 	
    public void medicosPreCadastrados(){  
	listMedicos.add(new Medico("Carlos Silva", "11111111111", "1111111111", 'M', "03/01/2000", "999999999", "catarata"));
	listMedicos.add(new Medico("Daniela Matos", "22222222222", "2222222222", 'F', "28/12/1992", "999999999", "glaucoma"));
    }
    
	// Método de cadastrar médico
    public void cadastrarMedico(Scanner sc) {
        try {
            System.out.println("Informe os dados do novo médico:");
            sc.nextLine();
            System.out.print("NOME: ");
            String nome = sc.nextLine();
            this.nome = nome;
            
            if(nome.isEmpty()) {
            	System.out.println("O NOME não pode estar vazio.");
            	return;
			}
			this.nome = nome;

			System.out.print("CPF: ");
			String cpf = sc.nextLine();
			if(!validarCPF(cpf)) {
				System.out.println("CPF invalido!");
				return;
			}
            this.cpf = cpf;
            
            System.out.print("RG: ");
            String rg = sc.nextLine();
            this.rg = rg;
            
            System.out.print("SEXO(M/F): ");
            Character sexo = sc.nextLine().charAt(0);
			if(sexo != 'M' && sexo != 'F') {
				System.out.println("Sexo inválido! Insira M para masculino ou F para feminino.");
				return;
			}
            this.sexo = sexo;
            
            System.out.print("DATA DE NASCIMENTO(dd/mm/aaaa): ");
            String dataNasc = sc.nextLine();
            if(!validarDataNascimento(dataNasc)) {
            	System.out.println("Data de nascimento inválida. Insira no formato dd/mm/aaaa.");
            	return;
            }
            this.dataNasc = dataNasc;
            
            System.out.print("CRM: ");
            String crm = sc.nextLine();
			if(crm.isEmpty()) {
				System.out.println("O CRM não pode estar vazio.");
				return;
			}
            this.crm = crm;
            
            System.out.print("SUBESPECIALIDADE: ");
            String subspec = sc.nextLine();
            this.subspec = subspec;
            
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
        System.out.println("[0] Voltar para o MENU PRINCIPAL.");
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
 				
            case 0:                              
            	return;

 			default: //caso escolham uma opcao inexistente
 				System.out.println("Opcao invalida, tente novamente.");
 				break;
 			}
 		}    
 	}
 	
	public boolean validarCPF(String cpf) {
		// Remove caracteres especiais do CPF
		cpf = cpf.replaceAll("[^0-9]", "");
	
		// Verifica se o CPF possui 11 dígitos
		if (cpf.length() != 11) {
			return false;
		}
	
		// Verifica se todos os dígitos são iguais (caso contrário, o CPF é inválido)
		boolean digitosIguais = true;
		for (int i = 1; i < 11; i++) {
			if (cpf.charAt(i) != cpf.charAt(0)) {
				digitosIguais = false;
				break;
			}
		}
		if (digitosIguais) {
			return false;
		}
	
		// Calcula e verifica o primeiro dígito verificador
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += (cpf.charAt(i) - '0') * (10 - i);
		}
		int resto = 11 - (soma % 11);
		int digitoVerificador1 = (resto == 10 || resto == 11) ? 0 : resto;
		if (digitoVerificador1 != cpf.charAt(9) - '0') {
			return false;
		}
	
		// Calcula e verifica o segundo dígito verificador
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += (cpf.charAt(i) - '0') * (11 - i);
		}
		resto = 11 - (soma % 11);
		int digitoVerificador2 = (resto == 10 || resto == 11) ? 0 : resto;
		if (digitoVerificador2 != cpf.charAt(10) - '0') {
			return false;
		}
	
		return true;
	}

	public boolean validarDataNascimento(String dataNasc) {
		// Definir o formato esperado da data
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/aaaa");
		formatoData.setLenient(false); // Desativar modo tolerante

		try {
			// Tentar fazer o parsing da data
			@SuppressWarnings("unused")
			Date data = formatoData.parse(dataNasc);
			
			// Verificar se a data é válida (evita datas como 30 de fevereiro, etc.)
			return true;
		} catch (ParseException e) {
			// A data não está no formato esperado
			return false;
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