package br.sc.senai.dao;

import br.sc.senai.model.Company;
import br.sc.senai.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAOTest {
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

        User newUser = new User();
        newUser.setFullname("Renato Bedin");
        newUser.setEmail("Renatob3din@gmail.com");
        newUser.setPassword("millena");

        Company company = entityManager.find(Company.class,1);
        newUser.setCompany(company);

        entityManager.persist(newUser);

        entityManager.getTransaction().commit();

    }

    public static void update(){
        entityManager.getTransaction().begin();

        User updatedUser = entityManager.find(User.class, 1);

        updatedUser.setFullname("Teste 01");
        updatedUser.setEmail("email@hotmail.com");

        entityManager.merge(updatedUser);

        entityManager.getTransaction().commit();
    }

    public static void delete(){
        entityManager.getTransaction().begin();

        User deletedUser = entityManager.find(User.class, 1);

        entityManager.remove(deletedUser);

        entityManager.getTransaction().commit();
    }

    public static void find(){
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, 1);

        System.out.println("Usuário " + user.getFullname());
        System.out.println("Empresa " + user.getCompany().getNome());

        entityManager.getTransaction().commit();
    }
}
