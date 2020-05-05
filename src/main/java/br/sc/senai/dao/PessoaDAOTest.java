package br.sc.senai.dao;

import br.sc.senai.model.Company;
import br.sc.senai.model.Empresa;
import br.sc.senai.model.Pessoa;
import br.sc.senai.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaDAOTest {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("UsersDB");
        entityManager = factory.createEntityManager();

//        insert();

//        update();

//        delete();

        find();

        entityManager.close();
        factory.close();
    }

    public static void insert()  {
        entityManager.getTransaction().begin();

        Pessoa newPessoa = new Pessoa();
        newPessoa.setNome("Renato");
        newPessoa.setSobrenome("Renatob3din@gmail.com");
        newPessoa.setCpf(10000225930L);

        Empresa empresa = entityManager.find(Empresa.class,1);
        newPessoa.setEmpresa(empresa);

        entityManager.persist(newPessoa);

        entityManager.getTransaction().commit();

    }

    public static void update(){
        entityManager.getTransaction().begin();

        Pessoa updatedPessoa = entityManager.find(Pessoa.class, 1);

        updatedPessoa.setNome("Paulo");
        updatedPessoa.setSobrenome("Bueno");

        entityManager.merge(updatedPessoa);

        entityManager.getTransaction().commit();
    }

    public static void delete(){
        entityManager.getTransaction().begin();

        Pessoa deletedPessoa = entityManager.find(Pessoa.class, 1);

        entityManager.remove(deletedPessoa);

        entityManager.getTransaction().commit();
    }

    public static void find(){
        entityManager.getTransaction().begin();

        Pessoa pessoa = entityManager.find(Pessoa.class, 1);

        System.out.println("Usuário " + pessoa.getNome());
        System.out.println("Empresa " + pessoa.getEmpresa().getNome());

        entityManager.getTransaction().commit();
    }
}
