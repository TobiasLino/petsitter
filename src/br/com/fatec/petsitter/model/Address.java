package br.com.fatec.petsitter.model;

public class Address {
    private String zip;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String uf;

    public static Address create() {
        Address addr = new Address();
        addr.zip = "";
        addr.street = "";
        addr.number = "";
        addr.complement = "";
        addr.neighborhood = "";
        addr.city = "";
        addr.uf = "";
        return addr;
    }

    public String data() {
        return "Endereço:\n"
            + "\t" + zip + "\n"
            + "\t" + street + "\n"
            + "\t" + number + "\n"
            + "\t" + complement + "\n"
            + "\t" + neighborhood + "\n"
            + "\t" + city + "\n"
            + "\t" + uf + "\n";
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setUF(String uf) {
        this.uf = uf;
    }
}