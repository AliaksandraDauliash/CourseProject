
package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Service;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiceDAO {
    private final String selectByName = "SELECT * FROM Service WHERE serviceName = :serviceName";
    public void create(Service service) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(service);
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
        List services=null;
        try {
            services = session.createCriteria(Service.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return services;
    }
    
    public Service readByName(String serviceName) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Service service = null;
        try {
            List serv;
            SQLQuery query = session.createSQLQuery(selectByName);
            query.addEntity(Service.class);
            query.setParameter("serviceName", serviceName);
            serv = query.list();
            service = (Service) serv.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return service;
    }
   public void update(int idService, String name ) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Service service = 
                    (Service)session.get(Service.class, idService); 
         service.setName( name );
		 session.update(service); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

    public void delete(int idService) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Service service
                    = (Service) session.get(Service.class, idService);
            session.delete(service);
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