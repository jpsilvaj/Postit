package br.edu.ifce.postit.dao.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
  
public class DatabaseFactory {  
  
   private EntityManagerFactory entity;
   
   protected DatabaseFactory(){
	   entity = Persistence.createEntityManagerFactory("postit");
   }
   
   protected void close(){
	   if (entity.isOpen()){
		   entity.close();
	   }
   }
   
   protected EntityManager getEntityManager(){
	   return entity.createEntityManager();
   }
}  