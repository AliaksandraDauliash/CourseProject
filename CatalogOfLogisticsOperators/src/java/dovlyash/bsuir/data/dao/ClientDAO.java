package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Client;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List clients=null;
        try {
            clients = session.createCriteria(Client.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clients;
    }
    public int readByLogin(String clientLogin, String clientPassword) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        int clientId = 0;
        try {
            List cr = session.createCriteria(Client.class).list();
            for (Iterator iterator
                  = cr.iterator(); iterator.hasNext();) {
                Client cl = (Client) iterator.next();
                if(cl.getLogin().equals(clientLogin) && cl.getPassword().equals(clientPassword))
                   clientId=cl.getId();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clientId;
    }

    public Client readById(int clientId) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Client client = new Client();
        try {
            List cr = session.createCriteria(Client.class).list();
            for (Iterator iterator
                  = cr.iterator(); iterator.hasNext();) {
                Client cl = (Client) iterator.next();
                if(cl.getId()==clientId)
                   client = cl;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return client;
    }
    
    
   public void update(Client client ) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
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
