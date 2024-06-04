package pessoas;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String rg;
    protected Character sexo;  //ver se é tipado assim mesmo, ou seria Character
    protected String dataNasc;
        
    
    //Construtor Vazio
	public Pessoa() {
		super();
	}  
	
	//Construtor
	public Pessoa(String nome, String cpf, String rg, Character sexo, String dataNasc) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
	}
        
    //Métodos Get e Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
        
        
        
    //To String
	@Override
	public String toString() {
		return "[" + nome + ", " + cpf + ", " + rg + ", " + sexo + ", " + dataNasc  + "]" ;
	}
	
	
}