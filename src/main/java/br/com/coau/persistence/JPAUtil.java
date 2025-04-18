
package br.com.coau.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPAUtil {
    private static final String PERSISTENCE_UTIL = "coau";
    private static EntityManagerFactory emf;
    
    public static EntityManager getEntityManager(){
        if(emf == null || emf.isOpen()){
            
            emf =  Persistence.createEntityManagerFactory(PERSISTENCE_UTIL);
        }
        return emf.createEntityManager();
    }
    
    public static void closeEntityManagerFactory(){
        if(emf != null && emf.isOpen()){
            
            emf.close();
        }
    }
}
