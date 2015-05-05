package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Client;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDAO {
    public void create(Client client) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /* Method to  READ all the employees */

    public List read() throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        List clients=null;
        try {
            tx = session.beginTransaction();
            clients = session.createCriteria(Client.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clients;
    }

   public void update(int idClient, String name ) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Client client = 
                    (Client)session.get(Client.class, idClient); 
         client.setName( name );
		 session.update(client); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

    public void delete(int idClient) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client client
                    = (Client) session.get(Client.class, idClient);
            session.delete(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
