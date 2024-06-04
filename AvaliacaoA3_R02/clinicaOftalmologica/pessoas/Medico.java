package pessoas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

//import operacoes.Consulta;

public class Medico extends Pessoa {

	private String crm;
	private String espec;
	
    private ArrayList<Medico> listMedicos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Construtor vazio
    public Medico() {
        super();
    }

    // Construtor com parâmetros
    public Medico(String nome, String cpf, String rg, char sexo, String dataNasc, String crm, String espec) {
        super(nome, cpf, rg, sexo, dataNasc);
        this.crm = crm;
        this.espec = espec;
    }
	
	// Método de cadastrar médico
    public void cadastrarMedico(Scanner sc) {
        try {
            System.out.println("Informe os dados do novo médico:");
            System.out.print("Nome: ");
            String nome = sc.next();
            sc.next();
            System.out.print("CPF: ");
            String cpf = sc.next();
            sc.next();
            System.out.print("RG: ");
            String rg = sc.next();
            sc.next();
            System.out.print("Sexo: ");
            char sexo = sc.next().charAt(0);
            sc.next();
            System.out.print("Data de Nascimento: ");
            String dataNasc = sc.next();
            sc.next();
            System.out.print("CRM: ");
            String crm = sc.next();
            sc.next();
            System.out.print("Especializacao: ");
            String espec = sc.next();
            sc.next();

            listMedicos.add(new Medico(nome, cpf, rg, sexo, dataNasc, crm, espec)); 

            System.out.println("Médico cadastrado!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir o tipo correto de dados.");
            sc.nextLine();
        }
    }
	//Método de editar cadastro de médicos
    public void editarCadastroDeMedico() {
			System.out.println("Informe o nome do médico:");
			String procurarMedico = sc.next();
			boolean encontrado = false;
	
			for (int i = 0; i < listMedicos.size(); i++) {
				if (listMedicos.get(i).getNome().equalsIgnoreCase(procurarMedico)) {
					encontrado = true;
					while (true) {
						try {
							// Tentativa de atualizar os dados do médico
							System.out.println("Selecione a atualização:");
							System.out.println("[1] Atualizar nome.");
							System.out.println("[2] Atualizar CPF.");
							System.out.println("[3] Atualizar RG.");
							System.out.println("[4] Atualizar sexo.");
							System.out.println("[5] Atualizar Data de Nascimento.");
							System.out.println("[6] Atualizar CRM.");
							System.out.println("[7] Atualizar especializacao.");
							System.out.println("[0] Encerrar operação.");
	
							int selecao = sc.nextInt();
	
							
							switch (selecao) {
								case 1:
								System.out.println("Informe o novo dado cadastral");
	  
								System.out.print("Nome: ");
								String nome = sc.next();
								listMedicos.get(i).setNome(nome);
								break;
							case 2:
								System.out.println("Informe o novo dado cadastral");
								System.out.print("CPF: ");
								String cpf = sc.next();
								listMedicos.get(i).setCpf(cpf);
								break;
							case 3:
								System.out.println("Informe o novo dado cadastral");
								System.out.print("RG: ");
								String rg = sc.next();
								listMedicos.get(i).setRg(rg);
								break;
							case 4:
								System.out.println("Informe o novo dado cadastral");
								System.out.print("Sexo: ");
								Character sexo = sc.next().charAt(0);
								listMedicos.get(i).setSexo(sexo);
								break;
							case 5:
								System.out.println("Informe o novo dado cadastral");
								System.out.print("Data de Nascimento: ");
								String dataNasc = sc.next();
								listMedicos.get(i).setDataNasc(dataNasc);
								break;
							case 6:
								System.out.println("Informe o novo dado cadastral");
								System.out.print("CRM: ");
								String crm = sc.next();
								listMedicos.get(i).setCrm(crm);
								break;
							case 7:
								System.out.println("Informe o novo dado cadastral");
								System.out.print("Especializacao: ");
								String espec = sc.next();
								listMedicos.get(i).setCrm(espec);
								break;
							case 0:
								System.out.println("Operação encerrada.");
								return;
	  
							default:
								break;
							}
						} catch (InputMismatchException e) {
							// Se o usuário inserir uma opção inválida, exibe uma mensagem de erro
							System.out.println("Opção inválida. Insira um número.");
							sc.nextLine(); // Limpa o buffer do scanner
						}
					}
				}
			}
			if (!encontrado) {
				// Se o médico não for encontrado, exibe uma mensagem
				System.out.println("Médico não encontrado.");
			}
		
    }

    public void excluirMedico() {
        System.out.println("Informe o nome do Médico a ser excluído:");
        String medicoExcluir = sc.next();

        Iterator<Medico> it = listMedicos.iterator();
        while (it.hasNext()) {
            Medico medico = it.next();
            if (medico.getNome().equals(medicoExcluir)) {
                it.remove();
                System.out.println("Médico excluído com sucesso.");
                return;
            }
        }
        System.out.println("Médico não encontrado.");
    }

    public void listarMedico() {
        System.out.println("Lista de Médicos:");
        for (Medico medico : listMedicos) {
            System.out.println(medico);
        }
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspec() {
        return espec;
    }

    public void setEspec(String espec) {
        this.espec = espec;
    }

    @Override
    public String toString() {
        return "[" + nome + ", " + cpf + ", " + crm + "]";
    }
}