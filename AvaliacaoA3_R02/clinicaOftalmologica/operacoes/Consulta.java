package operacoes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Consulta {
    private String pacienteNome;
    private String medicoNome;
    private String data;
    private String horario;
        
    private ArrayList<Consulta> listConsultas = new ArrayList<>();
    
    public Consulta(String pacienteNome, String medicoNome, String data, String horario) {
        this.pacienteNome = pacienteNome;
        this.medicoNome = medicoNome;
        this.data = data;
        this.horario = horario;
    }

    public Consulta() {

    }

    public void agendarConsulta(Scanner sc) {
        System.out.println("Agendamento de consulta: "); 
        System.out.print("Médico: "); 
        String medico = sc.next();
        System.out.print("Paciente: ");
        String paciente = sc.next();
        System.out.print("Data: ");
        String data = sc.next();
        System.out.print("Horário: ");
        String horario = sc.next();

        listConsultas.add(new Consulta(paciente, medico, data, horario));   
        System.out.println("Consulta agendada!");
    }
        
    public void editarConsulta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o nome do Médico responsável: ");
        String procurarConsulta = sc.next();

        for (Consulta consulta : listConsultas) {
            if (consulta.getMedicoNome().equals(procurarConsulta)) {
                while (true) {
                    try {
                        System.out.println("Selecione a atualização: ");
                        System.out.println("1. Atualizar nome do médico");
                        System.out.println("2. Atualizar nome do paciente");
                        System.out.println("3. Atualizar data");
                        System.out.println("4. Atualizar hora");
                        System.out.println("0. Encerrar operação");

                        int selecao = sc.nextInt();

                        switch (selecao) {
                            case 1:
                                System.out.println("Informe o novo nome do médico: ");
                                String novoMedicoNome = sc.next();
                                consulta.setMedicoNome(novoMedicoNome);
                                break;
                            case 2:
                                System.out.println("Informe o novo nome do paciente: ");
                                String novoPacienteNome = sc.next();
                                consulta.setPacienteNome(novoPacienteNome);
                                break;
                            case 3:
                                System.out.println("Informe a nova data: ");
                                String novaData = sc.next();
                                consulta.setData(novaData);
                                break;
                            case 4:
                                System.out.println("Informe o novo horário: ");
                                String novoHorario = sc.next();
                                consulta.setHorario(novoHorario);
                                break;
                            case 0:
                                System.out.println("Operação encerrada.");
                                sc.close(); // Fechar o Scanner
                                return;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número.");
                        sc.next(); // Limpa o buffer do scanner
                    }
                }
            }
        }
        System.out.println("Consulta não encontrada.");
        sc.close(); // Fechar o Scanner
    }

    public void excluirConsulta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o nome do Médico responsável pela consulta a ser excluída:");
        String medicoExcluir = sc.next();

        Iterator<Consulta> it = listConsultas.iterator();
        while (it.hasNext()) {
            Consulta consulta = it.next();
            if (consulta.getMedicoNome().equals(medicoExcluir)) {
                it.remove();
                System.out.println("Consulta excluída com sucesso.");
                sc.close(); // Fechar o Scanner
                return;
            }
        }
        System.out.println("Consulta não encontrada.");
        sc.close(); // Fechar o Scanner
    }

    public void listarConsultas() {
        System.out.println("Lista de consultas:");
        for (Consulta consulta : listConsultas) {
            System.out.println(consulta);
        }
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

    @Override
    public String toString() {
        return "[" + pacienteNome + ", " + medicoNome + ", " + data + ", " + horario + "]";
    }   
}
