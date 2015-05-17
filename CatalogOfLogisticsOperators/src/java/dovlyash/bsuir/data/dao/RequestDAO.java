
package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Request;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
        List recalls=null;
        try {
            recalls = session.createCriteria(Request.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recalls;
    }
    
    public List readByLogoperatorId(int logoperatorId) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        List<Request> requests = new ArrayList();
        try {
            List cr = session.createCriteria(Request.class).list();
            for (Iterator iterator
                  = cr.iterator(); iterator.hasNext();) {
                Request rq = (Request) iterator.next();
                if(rq.getLogoperator().getId() == logoperatorId)
                   requests.add(rq);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return requests;
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

