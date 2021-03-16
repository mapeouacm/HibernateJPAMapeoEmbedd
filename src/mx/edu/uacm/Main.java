package mx.edu.uacm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mx.edu.uacm.dominio.Direccion;
import mx.edu.uacm.dominio.Usuario;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateJPAMapeoEmbedd");
		EntityManager em = factory.createEntityManager();
		
		//iniciar una transaccion
		em.getTransaction().begin();
		
		//Construir un objeto
		Usuario usr1 = new Usuario();
		//usr1.setId(1L);
		usr1.setNombreUsuario("Usr1");
		usr1.setMensajeUsuario("Hola");
		usr1.setDireccionCasa(new Direccion("Avenida", "1200", "10,000,000", "CDMX"));
		usr1.setDireccionTrabajo(new Direccion("Avenida", "1200", "10,000,000", "CDMX"));

		
		em.persist(usr1);
		
		//Commit de la transaccion
		em.getTransaction().commit();
		
		//abrio
		em.getTransaction().begin();
		
		Usuario usuarioRecuperado = em.find(Usuario.class, 1L);
		usuarioRecuperado.setMensajeUsuario("Otro mensaje");
		Usuario usr2 = new Usuario();
		//usr1.setId(1L);
		usr2.setNombreUsuario("Usr2");
		usr2.setMensajeUsuario("Otro mensaje");
		usr2.setDireccionCasa(new Direccion("Calle", "160A", "12,000,000", "EDOMEX"));
		usr2.setDireccionTrabajo(new Direccion("Calle", "160A", "12,000,000", "EDOMEX"));
		em.persist(usr2);
		
		em.getTransaction().commit();
		
		
		//Cerrar el entitymanager
		em.close();
		
		
	}
	
}
