
package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.LogoperatorService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LogoperatorServiceDAO {
  public void create(LogoperatorService logserv) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(logserv);
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
        List logserv=null;
        try {
            tx = session.beginTransaction();
            logserv = session.createCriteria(LogoperatorService.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return logserv;
    }
    
    public List readByServiceName(String serviceName) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        List services = new ArrayList<LogoperatorService>();
        Transaction tx = null;
        try {
            List serv;
            tx = session.beginTransaction();
            serv = session.createCriteria(LogoperatorService.class).list();
            for (Iterator iterator
                  = serv.iterator(); iterator.hasNext();) {
                LogoperatorService ls = (LogoperatorService) iterator.next();
                if(ls.getService().getName().equals(serviceName))
                   services.add(ls);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return services;
    }
    
//   public void update(int idClient, String name ) throws SQLException{
//      Session session = HelperDAO.getFactory().openSession();
//      Transaction tx = null;
//      try{
//         tx = session.beginTransaction();
//         Client client = 
//                    (Client)session.get(Client.class, idClient); 
//         client.setName( name );
//		 session.update(client); 
//         tx.commit();
//      }catch (HibernateException e) {
//         if (tx!=null) tx.rollback();
//         e.printStackTrace(); 
//      }finally {
//         session.close(); 
//      }
//   }

    public void delete(int id) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            LogoperatorService logserv
                    = (LogoperatorService) session.get(LogoperatorService.class, id);
            session.delete(logserv);
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
