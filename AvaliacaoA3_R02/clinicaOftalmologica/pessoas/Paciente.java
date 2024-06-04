package pessoas;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

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
        listPacientes.add(new Paciente("Amos Medeiros", "11111111111", "1111111111", 'M', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Juliana Ferraz", "22222222222", "2222222222", 'F', "28/12/1992", "999999999", "email@email"));
        listPacientes.add(new Paciente("Miguel Reis", "33333333333", "3333333333", 'M', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Nair Rosa", "44444444444", "4444444444", 'F', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Yule Lima", "55555555555", "5555555555", 'M', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Joao Silva", "66666666666", "6666666666", 'M', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Maria Souza", "777777777777", "77777777777", 'F', "03/01/2000", "999999999", "email@email"));
    } 
    
    //REVER	- metodo personalizado para cadastrar novo paciente
    public void cadastrarPaciente(Scanner sc) {
        try {
            System.out.println("Informe os dados do novo paciente: ");
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
            System.out.print("CELULAR: ");
            String celular = sc.nextLine();
            this.celular = celular;		
            System.out.print("EMAIL: ");
            String email = sc.nextLine();
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
                    System.out.println("[0] Voltra para o MENU PRINCIPAL.");
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
                            System.out.print("Informe o novo SEXO:");
                            Character sexo = sc.next().charAt(0);
                            listPacientes.get(i).setSexo(sexo);
                            break;
                        case 5:
                            System.out.print("Informe a nova DATA DE NASCIMENTO:");
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
    
    // Método para buscar específicamente ou listar relação de pacientes
    public void relacaoPacientes() {
        int opcao;
       
        System.out.println("** LISTAR PACIENTE ***");
        System.out.println();
        System.out.println("[1] Buscar Paciente por NOME.");
        System.out.println("[2] Imprimir relação de pacientes cadastrados.");
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
                System.out.print("Insira o NOME de um Paciente: ");
                
                String buscar = sc.next();
                boolean encontrado = false;
                
                for (Paciente p: listPacientes){
                    if (p.getNome().equalsIgnoreCase(buscar)) {
                        encontrado = true;
                        System.out.println("Paciente encontrado:");
                        System.out.println(p);
                        
                    }
                }
                if (!encontrado) {
                    System.out.println("Paciente nao encontrado.");
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
            default: //caso escolham uma opcao inexistente
            System.out.println("Opção inválida, tente novamente.");
                break;
            }
        }    
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