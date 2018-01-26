/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Usuario;
import Interfaces.Operaciones;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Rodrigo
 */
public class UsuarioDao implements Operaciones<Usuario>{

    
    
    
    
    @Override
    public int create(Usuario p) {
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
            Usuario u = (Usuario) session.get(Usuario.class, id);
            session.delete(u);
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
    public int edit(Usuario p) {
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
    public List<Usuario> readAll() {
        List<Usuario> lista = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            lista = session.createCriteria(Usuario.class).list();
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
    public Usuario read(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario u = new Usuario();
        try {
            session.beginTransaction();
            u = (Usuario) session.get(Usuario.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return u;
    }
    
}
