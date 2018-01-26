/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Persona;
import Interfaces.Operaciones;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Rodrigo
 */
public class PersonaDao implements Operaciones<Persona>{

    @Override
    public int create(Persona p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int x = 0;
        try {
//            String Id = Integer.toString(p.getIdproducto());
//            // begin a transaction  
            session.beginTransaction();
            session.merge(p);
            session.flush();
            session.getTransaction().commit();
            x = 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return x;
    }

    @Override
    public int delete(int id) {
        int x = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Persona p = (Persona) session.get(Persona.class, id);
            session.delete(p);
            session.getTransaction().commit();
            x = 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return x;
    }

    @Override
    public int edit(Persona p) {
        int x = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
            x = 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return x;}

    @Override
    public List<Persona> readAll() {
        List<Persona> lista = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            lista = session.createCriteria(Persona.class).list();
            int count = lista.size();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return lista;
    }

    @Override
    public Persona read(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Persona p = new Persona();
        try {
            session.beginTransaction();
            p = (Persona) session.get(Persona.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return p;
    }
    
}
