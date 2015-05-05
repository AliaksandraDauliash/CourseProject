package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Logoperator;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class LogoperatorDAO {
     public void create(Logoperator logoperator) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(logoperator);
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
        List logoperators=null;
        try {
            tx = session.beginTransaction();
            logoperators = session.createCriteria(Logoperator.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return logoperators;
    }
    public List readByName(String logoperatorName) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        List logoperators = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Logoperator.class);
            cr.add(Restrictions.ilike("name", "%"+logoperatorName+"%"));
            logoperators = cr.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return logoperators;
    }

   public void update(int idLogoperator, String name ) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Logoperator logoperator = 
                    (Logoperator)session.get(Logoperator.class, idLogoperator); 
         logoperator.setName( name );
		 session.update(logoperator); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

    public void delete(int idLogoperator) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Logoperator logoperator
                    = (Logoperator) session.get(Logoperator.class, idLogoperator);
            session.delete(logoperator);
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
