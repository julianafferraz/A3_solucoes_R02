package pessoas;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

public class Paciente extends Pessoa {

	private String celular;   
	private String email;

	//Classe Scanner	
    Scanner sc = new Scanner (System.in);
        
    //Construtor Vazio
	public Paciente() {
		super();
	}
        
        
    //Construtor
	public Paciente(String nome, String cpf, String rg, Character sexo, String dataNasc, String celular, String email) {
		super(nome, cpf, rg, sexo, dataNasc);
		this.celular = celular;
		this.email = email;
	}
        
        
    //Declaracao da arrayList para armazenar todos os objetos cadastrados  
    public ArrayList<Paciente> listPacientes = new ArrayList<>();
       
        
    //REVER	- metodo personalizado para cadastrar novo paciente
    public void cadastrarPaciente(Scanner sc) {
        try {
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
            System.out.print("Email: ");
            String email = sc.next();
            this.email = email;	

                  
                    
            listPacientes.add(new Paciente(this.nome,this.cpf,this.rg,this.sexo,this.dataNasc,this.celular,this.email)); 


            System.out.println("Paciente cadastrado: ");
            System.out.println(this); 
            System.out.println(); 

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida.");
        }              
    }   
        
    public void editarCadastroDePaciente(){
            
        System.out.println("Informe o nome do paciente: ");
        String procurarPaciente =sc.next();
        
        int count=0;
              
        for (int i = 0; i < listPacientes.size(); i++) {
            if (listPacientes.get(i).getNome().equals(procurarPaciente)) {  
                count++;
                while(true){
                    System.out.println("Selecione a atualização: "); 
                    System.out.println("[1] Atualizar nome.");
                    System.out.println("[2] Atualizar CPF.");
                    System.out.println("[3] Atualizar RG.");
                    System.out.println("[4] Atualizar sexo.");
                    System.out.println("[5] Atualizar Data de Nascimento.");
                    System.out.println("[6] Atualizar celular.");
                    System.out.println("[7] Atualizar email.");
                    System.out.println("[0] Encerrar operação.");

                    int selecao=sc.nextInt();

                        switch (selecao) {

                            case 1:
                                System.out.println("Informe o novo dado cadastral");
                                System.out.print("Nome: ");
                                String nome = sc.next();
                                listPacientes.get(i).setNome(nome);
                                break;
                            case 2:
                                System.out.println("Informe o novo dado cadastral");
                                System.out.print("CPF: ");
                                String cpf = sc.next();
                                listPacientes.get(i).setCpf(cpf);
                                break;
                            case 3:
                                System.out.println("Informe o novo dado cadastral");
                                System.out.print("RG: ");
                                String rg = sc.next();
                                listPacientes.get(i).setRg(rg);
                                break;
                            case 4:
                                System.out.println("Informe o novo dado cadastral");
                                System.out.print("Sexo: ");
                                Character sexo = sc.next().charAt(0);
                                listPacientes.get(i).setSexo(sexo);
                                break;
                            case 5:
                                System.out.println("Informe o novo dado cadastral");
                                System.out.print("Data de Nascimento: ");
                                String dataNasc = sc.next();
                                listPacientes.get(i).setDataNasc(dataNasc);
                                break;
                            case 6:
                                System.out.println("Informe o novo dado cadastral");
                                System.out.print("Celular: ");
                                String celular = sc.next();
                                listPacientes.get(i).setCelular(celular);
                                break;
                            case 7:
                                System.out.println("Informe o novo dado cadastral");
                                System.out.print("Email: ");
                                String email = sc.next();
                                listPacientes.get(i).setEmail(email);
                                break;
                            case 0:
                                System.out.println("Operação encerrada.");
                                
                                return;

                            default:
                                break;

                        }
                            System.out.println("Paciente atualizado com sucesso!");
                        }

            
            } 
            if (count==0){
                System.out.println("Paciente não encontrado.");
            }
                                        
        }  
    }
            
    public void excluirPaciente(){
        System.out.println("Informe o CPF:"); 
        String excluirPaciente=sc.next();

        for (int i = 0; i < listPacientes.size(); i++) {
            if (listPacientes.get(i).getCpf().equals(excluirPaciente)) {
                listPacientes.remove(i);
            }
        } 
    }   
    
    // Método para buscar específicamente ou listar relação de pacientes
    public void relacaoPacientes() {
        int opcao;
       
        System.out.println("Escolha uma das opções:");
        System.out.println();
        System.out.println("[1] Buscar Paciente.");
        System.out.println("[2] Imprimir relação de pacientes.");
        System.out.println();
        System.out.print("Selecione: ");
        opcao =sc.nextInt();

        if (listPacientes.isEmpty()) {
            System.out.println("Lista de pacientes vazia.");
            return;
        } else {
            switch(opcao) {
                
            case 1:
                System.out.println("Insira o nome de um Paciente: ");
                
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
                    System.out.println("Paciente não encontrado.");
                }
                break;
            case 2: 
                System.out.println("Lista de Pacientes:");
            
                for (int i = 0; i < listPacientes.size(); i++) {
                    System.out.println(listPacientes.get(i));		
                    System.out.println();
                }
                break;
            default: //caso escolham uma opcao inexistente
            System.out.println("Opção inválida, tente novamente.");
                break;
            }
        }    
    }

    //Objetos cadastrados atomaticamnete.
    public void teste(){
             
        System.out.println("Cadastramento automático para teste: ");
        System.out.println("-----------------------------------------------------------------");
        listPacientes.add(new Paciente("Amos", "11111111111", "1111111111", 'M', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Juliana", "22222222222", "2222222222", 'F', "28/12/1992", "999999999", "email@email"));
        listPacientes.add(new Paciente("Miguel", "33333333333", "3333333333", 'M', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Nair", "44444444444", "4444444444", 'F', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Yule", "55555555555", "5555555555", 'M', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Joao", "66666666666", "6666666666", 'M', "03/01/2000", "999999999", "email@email"));
        listPacientes.add(new Paciente("Maria", "777777777777", "77777777777", 'F', "03/01/2000", "999999999", "email@email"));

        for(Paciente p: listPacientes) {
            System.out.println(p);
        }

        System.out.println("-----------------------------------------------------------------");
        System.out.println();
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