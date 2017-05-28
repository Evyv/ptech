package hu.unideb.inf.ptech.controller;

import hu.unideb.inf.ptech.model.Szerzodes;


import hu.unideb.inf.ptech.model.Ugyfel;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class SqlLekerdezesek 
{
    
    public void ujUgyfel(Ugyfel ugyfel) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(ugyfel);
        session.getTransaction().commit();
        session.close();
    }

    public List<Ugyfel> getUgyfelAll() 
    {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Ugyfel";
        Query query = session.createQuery(hql);
        List<Ugyfel> ugyfelek = query.list();
        session.close();

        return ugyfelek;
    }
    
    public void deleteUgyfelById(Ugyfel ugyfel) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(ugyfel);
        session.flush();
        tx.commit();
        session.close();
    }
    
    public void deleteSzerzodesById(Szerzodes szerzodes) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(szerzodes);
        session.flush();
        tx.commit();
        session.close();
    }
    
    public Szerzodes getSzerzodes(Integer azon) 
    {
        Szerzodes szerzodes;
        Session session = HibernateUtil.getSessionFactory().openSession();
        szerzodes = (Szerzodes) session.get(Szerzodes.class, azon);
        return szerzodes;
    }
    
    public int ertesitesekTomegesKikuldese() 
    {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "update Ugyfel set megkereses = megkereses +1";
        Query query = session.createQuery(hql);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
    }
        
    public void ertesitesKikuldese(Ugyfel ugyfel) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Ugyfel ugy = (Ugyfel) session.load(Ugyfel.class, ugyfel.getAzon());
        ugy.setMegkereses(ugy.getMegkereses()+1);
        session.save(ugy);
        tx.commit();
        session.close();
    }
    
    public void ujSzerzodesKotes(Ugyfel ugyfel, Szerzodes szerzodes) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(szerzodes);
        Ugyfel ugy = (Ugyfel) session.load(Ugyfel.class, ugyfel.getAzon());
        ugy.setSzazon(szerzodes.getAzon());
        session.save(ugy);
        tx.commit();
        session.close();
    }
    
    public void szerzodesFelbontasa(Ugyfel ugyfel, Szerzodes szerzodes) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(szerzodes);
        session.flush();
        Ugyfel ugy = (Ugyfel) session.load(Ugyfel.class, ugyfel.getAzon());
        ugy.setSzazon(0);
        session.save(ugy);
        tx.commit();
        session.close();
    }
}
