package br.sc.senai.dao;

import br.sc.senai.model.Company;
import br.sc.senai.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpresaDAOTest {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("UsersDB");
        entityManager = factory.createEntityManager();

        insert();

        entityManager.close();
        factory.close();
    }

    public static void insert()  {
        entityManager.getTransaction().begin();

        Empresa empresa = new Empresa();
        empresa.setNome("Ifood");

        entityManager.persist(empresa);

        entityManager.getTransaction().commit();
    }
}
