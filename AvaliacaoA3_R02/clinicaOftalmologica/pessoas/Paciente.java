package pessoas;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Paciente extends Pessoa {

	private String celular;   
	private String email;
	
  
    public ArrayList<Paciente> listPacientes = new ArrayList<>();
	
    Scanner sc = new Scanner (System.in);
        
    //Construtor Vazio
	public Paciente() {
		super();
	}
        
        
    //Construtor completo
	public Paciente(String nome, String cpf, String rg, Character sexo, String dataNasc, String celular, String email) {
		super(nome, cpf, rg, sexo, dataNasc);
		this.celular = celular;
		this.email = email;
	}
         
    //Objetos pre-cadastrados.
    public void pacientesPreCadastrados(){            
        listPacientes.add(new Paciente("Amos Medeiros", "11111111111", "1111111111", 'M', "03/01/2000", "71999999999", "email@email"));
        listPacientes.add(new Paciente("Juliana Ferraz", "22222222222", "2222222222", 'F', "28/12/1992", "71999999999", "email@email"));
        listPacientes.add(new Paciente("Miguel Reis", "33333333333", "3333333333", 'M', "03/01/2000", "71999999999", "email@email"));
        listPacientes.add(new Paciente("Nair Rosa", "44444444444", "4444444444", 'F', "03/01/2000", "71999999999", "email@email"));
        listPacientes.add(new Paciente("Yule Lima", "55555555555", "5555555555", 'M', "03/01/2000", "71999999999", "email@email"));
        listPacientes.add(new Paciente("Joao Silva", "66666666666", "6666666666", 'M', "03/01/2000", "71999999999", "email@email"));
        listPacientes.add(new Paciente("Maria Souza", "777777777777", "77777777777", 'F', "03/01/2000", "71999999999", "email@email"));
    } 
    
    //REVER	- metodo personalizado para cadastrar novo paciente
    public void cadastrarPaciente(Scanner sc) {
        try {
            System.out.println("Informe os dados do novo paciente: ");
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
            	System.out.println("CPF inválido.");
            	return;
			}
            
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

            System.out.print("CELULAR: ");
            String celular = sc.nextLine();
            if (validarNumeroCelular(celular)) {
                System.out.println(celular + " é um número de celular válido.");
            } else {
            	System.out.println(celular + " não é um número de celular válido.");
            	return;
            }
            this.celular = celular;

            System.out.print("EMAIL: ");
            String email = sc.nextLine();
            if(!validarEmail(email)) {
            	System.out.println("Email invalido: " + email);
            	return;
			}

            this.email = email;		
                   
            listPacientes.add(new Paciente(this.nome,this.cpf,this.rg,this.sexo,this.dataNasc,this.celular,this.email)); 

            System.out.println(); 
            System.out.println("Paciente cadastrado: ");
            System.out.println(this); 
            System.out.println(); 

        } catch (InputMismatchException e) {
            System.out.println("ERRO: Entrada invalida.");
        }              
    }   
        
    public void editarPaciente(){
		boolean encontrado = false;           
        System.out.print("Informe o nome do paciente: ");
        String procurarPaciente =sc.next();
        

              
        for (int i = 0; i < listPacientes.size(); i++) {
            if (listPacientes.get(i).getNome().equals(procurarPaciente)) {  

            	encontrado = true;

				while(true){
                    System.out.println();
                    System.out.println("*** ATUALIZAR PACIENTE ***"); 
                    System.out.println(); 
                    System.out.println("[1] Atualizar NOME.");
                    System.out.println("[2] Atualizar CPF.");
                    System.out.println("[3] Atualizar RG.");
                    System.out.println("[4] Atualizar SEXO.");
                    System.out.println("[5] Atualizar DATA NASCIMENTO.");
                    System.out.println("[6] Atualizar CELULAR.");
                    System.out.println("[7] Atualizar EMAIL.");
                    System.out.println();                     
                    System.out.println("[0] Voltar para o MENU PRINCIPAL.");
                    System.out.println(); 

                    System.out.print("Informe a opcao desejada:");                     
                    int selecao=sc.nextInt();
                    System.out.println(); 
                    
                    switch (selecao) {

                    	case 1:
                            System.out.print("Informe o novo NOME:");
                            String nome = sc.next();
                            listPacientes.get(i).setNome(nome);
                            break;
                    	case 2:
                            System.out.print("Informe o novo CPF:");
                            String cpf = sc.next();
                            listPacientes.get(i).setCpf(cpf);
                            break;
                        case 3:
                            System.out.print("Informe o novo RG:");
                            String rg = sc.next();
                            listPacientes.get(i).setRg(rg);
                            break;
                        case 4:
                            System.out.print("Informe o novo SEXO(M/F):");
                            Character sexo = sc.next().charAt(0);
                            listPacientes.get(i).setSexo(sexo);
                            break;
                        case 5:
                            System.out.print("Informe a nova DATA DE NASCIMENTO(dd/mm/aaaa):");
                            String dataNasc = sc.next();
                            listPacientes.get(i).setDataNasc(dataNasc);
                            break;
                        case 6:
                            System.out.print("Informe o novo CELULAR:");
                            String celular = sc.next();
                            listPacientes.get(i).setCelular(celular);
                            break;
                        case 7:
                            System.out.print("Informe o novo EMAIL:");
                            String email = sc.next();
                            listPacientes.get(i).setEmail(email);
                        	break;
                        case 0:                              
                        	return;

                        default:
                        	System.out.println("Opcao invalida, tente novamente.");
                            break;

                    }
                            System.out.println("Paciente atualizado com sucesso!");
                            System.out.println();
				}

            
            } 
            else if(!encontrado) {
            	continue;
            }
            
            System.out.println("Paciente nao encontrado.");
            System.out.println();                                     
        }  
    }
            
    public void excluirPaciente(){
        System.out.print("Informe o CPF do Paciente a ser excluido:"); 
        String excluirPaciente=sc.next();

        for (int i = 0; i < listPacientes.size(); i++) {
            if (listPacientes.get(i).getCpf().equals(excluirPaciente)) {
                listPacientes.remove(i);
            }
        }
        System.out.println("Paciente excluido com sucesso."); 
        System.out.println();
    }   
    
    // Método para buscar paciente espefífico ou listar relação de pacientes
    public void relacaoPacientes() {
        int opcao;
       
        System.out.println("** LISTA PACIENTES ***");
        System.out.println();
        System.out.println("[1] Buscar Paciente por NOME.");
        System.out.println("[2] Relação de pacientes cadastrados.");
        System.out.println();       
        System.out.println("[0] Voltar para o MENU PRINCIPAL.");
        System.out.println();
        System.out.print("Informe a opcao desejada: ");
        opcao =sc.nextInt();
        System.out.println();
        
        if (listPacientes.isEmpty()) {
            System.out.println("Nao ha pacientes cadastrados.");
            return;
        } else {
            switch(opcao) {
                
            	case 1:
            		sc.nextLine();
            		System.out.print("Insira o NOME de um Paciente: ");                
            		String buscar = sc.nextLine();
                
            		boolean encontrado = false;
                
            		for (Paciente p: listPacientes){
            			if (p.getNome().equalsIgnoreCase(buscar)) {
                      
            				encontrado = true;
            				
            				System.out.println();
            				System.out.print("Paciente encontrado:");
            				System.out.println(p); 
            				break;
            			}                   
            		}
            		
            		if (!encontrado) {
            			System.out.println();
            			System.out.println("Paciente nao encontrado!");
            		}
            		break;
            		
            	case 2: 
            		System.out.println("---------- RELACAO DE PACIENTES CADASTRADOS ----------");
            		System.out.println();
                
            		for (int i = 0; i < listPacientes.size(); i++) {
            			System.out.println(listPacientes.get(i));		
            			System.out.println();
            		}
            		System.out.println("-----------------------------------------------------");
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


	public boolean validarRG(String rg) {
		// Remover caracteres especiais do RG
		rg = rg.replaceAll("[^0-9]", "");
		
		// Verificar se o RG possui entre 9 e 10 dígitos
		if (rg.length() != 9 && rg.length() != 10) {
			return false;
		}
		
		// Extrair os dígitos e o dígito verificador
		String digitos = rg.substring(0, rg.length() - 1);
		char digitoVerificador = rg.charAt(rg.length() - 1);
		
		// Calcular o dígito verificador esperado
		int soma = 0;
		int peso = 2; // O peso começa em 2 para RGs com 9 dígitos
		if (rg.length() == 10) {
			peso = 3; // Se o RG tiver 10 dígitos, o peso começa em 3
		}
		for (int i = digitos.length() - 1; i >= 0; i--) {
			soma += (digitos.charAt(i) - '0') * peso;
			peso++;
		}
		int resto = soma % 11;
		char esperado;
		if (resto == 10) {
			esperado = 'X';
		} else {
			esperado = (char) (resto + '0');
		}
		
		// Verificar se o dígito verificador é válido
		return esperado == digitoVerificador;
	}


	public boolean validarDataNascimento(String dataNasc) {
		// Definir o formato esperado da data
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
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

    // validar email
    public boolean validarEmail(String email) {
        // Expressão regular simples para verificar o formato do e-mail
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    private boolean validarNumeroCelular(String celular) {
        Pattern pattern = Pattern.compile("\\d{9,11}"); // Celular deve ter de 9 a 11 dígitos
        Matcher matcher = pattern.matcher(celular);
        return matcher.matches();
    }
    
    //Métodos Get e Set
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    //To String
	@Override
	public String toString() {
		return "[" + nome + ", " + cpf + ", " + celular + "]" ;
	}
    
}