package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Logoperator;
import java.sql.SQLException;
import java.util.Iterator;
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
        List logoperators=null;
        try {
            logoperators = session.createCriteria(Logoperator.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return logoperators;
    }
    public List readByName(String logoperatorName) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        List logoperators = null;
        try {
            Criteria cr = session.createCriteria(Logoperator.class);
            cr.add(Restrictions.ilike("name", "%"+logoperatorName+"%"));
            logoperators = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return logoperators;
    }
    
    public Logoperator readById(int logoperatorId) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Logoperator logoperator = new Logoperator();
        try {
            List cr = session.createCriteria(Logoperator.class).list();
            for (Iterator iterator
                  = cr.iterator(); iterator.hasNext();) {
                Logoperator lg = (Logoperator) iterator.next();
                if(lg.getId()==logoperatorId)
                   logoperator = lg;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return logoperator;
    }
    
    public int readByLogin(String clientLogin, String clientPassword) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        int logoperatorId = 0;
        try {
            List cr = session.createCriteria(Logoperator.class).list();
            for (Iterator iterator
                  = cr.iterator(); iterator.hasNext();) {
                Logoperator lg = (Logoperator) iterator.next();
                if(lg.getLogin().equals(clientLogin) && lg.getPassword().equals(clientPassword))
                   logoperatorId=lg.getId();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return logoperatorId;
    }

   public void update(Logoperator logoperator) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
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
