
package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Mark;
import java.sql.SQLException;
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
        Transaction tx = null;
        List recalls=null;
        try {
            tx = session.beginTransaction();
            recalls = session.createCriteria(Mark.class).list();
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

   public void update(int idMark, Double value ) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Mark mark = 
                    (Mark)session.get(Mark.class, idMark); 
         mark.setText(value );
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
