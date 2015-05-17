
package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Mark;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MarkDAO {
    public void create(Mark mark) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(mark);
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
            recalls = session.createCriteria(Mark.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recalls;
    }

     public List readByLogoperatorId(int logoperatorId) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        List<Mark> marks = new ArrayList();
        try {
            List cr = session.createCriteria(Mark.class).list();
            for (Iterator iterator
                  = cr.iterator(); iterator.hasNext();) {
                Mark m = (Mark) iterator.next();
                if(m.getLogoperator().getId() == logoperatorId)
                   marks.add(m);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return marks;
    }
     
   public void update(int idMark, int value ) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Mark mark = 
                    (Mark)session.get(Mark.class, idMark); 
         mark.setValue(value );
		 session.update(mark); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

    public void delete(int idMark) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Mark mark
                    = (Mark) session.get(Mark.class, idMark);
            session.delete(mark);
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
