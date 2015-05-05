
package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Request;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RequestDAO {
    public void create(Request request) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(request);
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
        List recalls=null;
        try {
            tx = session.beginTransaction();
            recalls = session.createCriteria(Request.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recalls;
    }

   public void update(int idRequest, Date date ) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Request request = 
                    (Request)session.get(Request.class, idRequest); 
         request.setDate(date );
		 session.update(request); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

    public void delete(int idRequest) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Request request
                    = (Request) session.get(Request.class, idRequest);
            session.delete(request);
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

