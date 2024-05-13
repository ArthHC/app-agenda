package br.com.projeto_aula03_04;

import java.util.Date;

public class ContactEntity {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private Date birthDate;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contato: " + id + '\n' +
                "Nome: " + name + '\n' +
                "Telefone: " + phone + '\n' +
                "Data de Nascimento: " + birthDate;
    }

}

