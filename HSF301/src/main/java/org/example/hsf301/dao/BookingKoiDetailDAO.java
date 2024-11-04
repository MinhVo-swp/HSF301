package org.example.hsf301.dao;

import org.example.hsf301.pojo.BookingKoiDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BookingKoiDetailDAO implements IBookingKoiDetailDAO {
    private SessionFactory sessionFactory;
    private Configuration configuration;

    public BookingKoiDetailDAO(String name) {
        configuration = new Configuration();
        configuration = configuration.configure(name);
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public List<BookingKoiDetail> getAll() {
        List<BookingKoiDetail> students = null;
        Session session = sessionFactory.openSession();
        try {
            students = session.createQuery("from BookingKoiDetail", BookingKoiDetail.class).list();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error" + e.getMessage());
        } finally {
            //sessionFactory.close();
            session.close();
        }
        return students;
    }

    @Override
    public void save(BookingKoiDetail student) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(student);
            t.commit();
            System.out.println("Successfully saved");
        } catch (Exception e) {
            // TODO: handle exception
            t.rollback();
            System.out.println("Error" + e.getMessage());
        } finally {
            //	sessionFactory.close();
            session.close();
        }
    }

    @Override
    public void delete(Long studentID) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            BookingKoiDetail student = (BookingKoiDetail) session.get(BookingKoiDetail.class,studentID);
            session.delete(student);
            t.commit();
            System.out.println("Delete saved");
        } catch (Exception e) {
            // TODO: handle exception
            t.rollback();
            throw e;
        } finally {
//			sessionFactory.close();
            session.close();
        }
    }

    @Override
    public BookingKoiDetail findById(Long studentID) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        try {
            return (BookingKoiDetail) session.get(BookingKoiDetail.class,studentID);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(BookingKoiDetail student) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(student);
            t.commit();
            System.out.println("Update successfully");
        } catch (Exception e) {
            // TODO: handle exception
            t.rollback();
            System.out.println("Error "+e.getMessage());
        } finally {
            //sessionFactory.close();
            session.close();
        }
    }
}