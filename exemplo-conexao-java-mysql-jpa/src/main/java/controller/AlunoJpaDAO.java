package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Alunos;
 
public class AlunoJpaDAO {
 
         private static AlunoJpaDAO instance;
         protected EntityManager entityManager;
         
         public static AlunoJpaDAO getInstance(){
                   if (instance == null){
                            instance = new AlunoJpaDAO();
                   }
                   
                   return instance;
         }
 
         private AlunoJpaDAO() {
                   entityManager = getEntityManager();
         }
 
         private EntityManager getEntityManager() {
                   EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
                   if (entityManager == null) {
                            entityManager = factory.createEntityManager();
                   }
 
                   return entityManager;
         }
 
         public Alunos getById(final int id) {
                   return entityManager.find(Alunos.class, id);
         }
 
         @SuppressWarnings("unchecked")
         public List<Alunos> findAll() {
                   return entityManager.createQuery("FROM " + Alunos.class.getName()).getResultList();
         }
 
         public void persist(Alunos alunos) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.persist(alunos);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void merge(Alunos alunos) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.merge(alunos);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void remove(Alunos alunos) {
                   try {
                            entityManager.getTransaction().begin();
                            alunos = entityManager.find(Alunos.class, alunos.getId_aluno());
                            entityManager.remove(alunos);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void removeById(final int id) {
                   try {
                            Alunos alunos = getById(id);
                            remove(alunos);
                   } catch (Exception ex) {
                            ex.printStackTrace();
                   }
         }
 
}