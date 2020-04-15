package br.sc.senai.model;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullname;

    private String email;

    private String password;

    public void setId(Integer id){
        this.id = id;
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Integer getId(){
        return id;
    }

    public String getFullname(){
        return fullname;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
