package br.com.fatec.petsitter.model;

public abstract class People {
    private String name;
    private String cpf;
    private Telefone phone;
    private Address address;

    public People() {
        name = "";
        cpf = "";
        phone = Telefone.create();
        address = Address.create();
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
    public Address getAddress() {
        return address;
    }
    
    public void setName(String name) {
        if (name == null) {
            System.out.println("Erro: Nome esta nulo");
            return;
        }
        this.name = name;
    }
    public void setCPF(String cpf) {
        if (cpf == null) {
            System.out.println("Erro: CPF esta nulo");
            return;
        }
        this.cpf = cpf;
    }
    public void setPhone(Telefone phone) {
        if (phone == null) {
            System.out.println("Erro: Telefone esta nulo");
            return;
        }
        this.phone = phone;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}