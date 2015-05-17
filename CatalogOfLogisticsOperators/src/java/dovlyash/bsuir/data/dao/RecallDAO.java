
package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Logoperator;
import dovlyash.bsuir.data.entity.Recall;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RecallDAO {
    public void create(Recall recall) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(recall);
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
            recalls = session.createCriteria(Recall.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recalls;
    }
    
    public List readByLogoperatorId(int logoperatorId) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        List<Recall> recalls = new ArrayList();
        try {
            List cr = session.createCriteria(Recall.class).list();
            for (Iterator iterator
                  = cr.iterator(); iterator.hasNext();) {
                Recall rc = (Recall) iterator.next();
                if(rc.getLogoperator().getId() == logoperatorId)
                   recalls.add(rc);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recalls;
    }

   public void update(int idRecall, String text ) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Recall recall = 
                    (Recall)session.get(Recall.class, idRecall); 
         recall.setText(text );
		 session.update(recall); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

    public void delete(int idRecall) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Recall recall
                    = (Recall) session.get(Recall.class, idRecall);
            session.delete(recall);
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
