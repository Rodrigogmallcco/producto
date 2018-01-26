/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Producto;
import Interfaces.Operaciones;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Rodrigo
 */
public class ProductoDao implements Operaciones<Producto>{

    @Override
    public int create(Producto p) {
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
            Producto pro = (Producto) session.get(Producto.class, id);
            session.delete(pro);
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
    public int edit(Producto p) {
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
        return x;
    }

    @Override
    public List<Producto> readAll() {
        List<Producto> lista = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            lista = session.createCriteria(Producto.class).list();
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
    public Producto read(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Producto pro = new Producto();
        try {
            session.beginTransaction();
            pro = (Producto) session.get(Producto.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return pro;
    }
    
}
