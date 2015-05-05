package dovlyash.bsuir.data.dao;

import dovlyash.bsuir.data.entity.Client;
import dovlyash.bsuir.data.entity.Goods;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GoodsDAO {
 public void create(Goods goods) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(goods);
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

    public void read() throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List goodss = session.createCriteria(Goods.class).list();
            for (Iterator iterator
                    = goodss.iterator(); iterator.hasNext();) {
                Goods goods = (Goods) iterator.next();
                System.out.print("ID: " + goods.getId());
                System.out.print("  Name: " + goods.getName());
                System.out.print("  Weight: " + goods.getWeight());
                System.out.println("  Volume: " + goods.getVolume());
                Client cl = goods.getClient();
                System.out.println("Client ");
                System.out.println("\tID: " + cl.getId());
                System.out.println("\tName: " +  cl.getName());
                System.out.println("\tPhone: " + cl.getPhone());
                System.out.println("\tEmail: " + cl.getEmail());
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
    }

   public void update(int idGoods, String name ) throws SQLException{
      Session session = HelperDAO.getFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Goods goods = 
                    (Goods)session.get(Goods.class, idGoods); 
         goods.setName( name );
		 session.update(goods); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

    public void delete(int idGoods) throws SQLException {
        Session session = HelperDAO.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Goods goods
                    = (Goods) session.get(Goods.class, idGoods);
            session.delete(goods);
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
