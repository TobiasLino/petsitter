package br.com.fatec.petsitter.model;

public abstract class People {
    private String name;
    private String cpf;
    private Telefone phone;
    // TODO: adicionar método de endereço

    public People() {
        name = "";
        cpf = "";
        phone = new Telefone();
    }
    
    public String getName() {
        return name;
    }
    public String getCPF() {
        return cpf;
    }
    public Telefone getPhone() {
        return phone;
    }
    
    public void setName(String name) {
        if (name == null) {
            System.out.println("Erro: Nome está nulo");
            return;
        }
        this.name = name;
    }
    public void setCPF(String cpf) {
        if (cpf == null) {
            System.out.println("Erro: CPF está nulo");
            return;
        }
        this.cpf = cpf;
    }
    public void setPhone(Telefone phone) {
        if (phone == null) {
            System.out.println("Erro: Telefone está nulo");
            return;
        }
        this.phone = phone;
    }
}