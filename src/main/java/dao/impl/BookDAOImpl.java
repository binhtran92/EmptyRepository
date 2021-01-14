package dao.impl;

import dao.BookDAO;
import entity.AuthorEntity;
import entity.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import utils.ResponseMessage;

import java.util.*;
import java.util.stream.Stream;

public class BookDAOImpl implements BookDAO {
    @Override
    public Set<BookEntity> getAllBook() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<BookEntity> books = null;
        try {
            transaction = session.beginTransaction();
            books = (List<BookEntity>) session.createQuery("from BookEntity ", BookEntity.class).list();
            books.forEach(book -> {
                book.getAuthors().size();
            });
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return new HashSet<>(books);
    }

    @Override
    public String save(String name, String[] ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(name);
        try {
            transaction = session.beginTransaction();
            for(String id : ids) {
                AuthorEntity authorEntity = session.get(AuthorEntity.class, Integer.parseInt(id));
                bookEntity.addAuthor(authorEntity);
            }
            session.save(bookEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return ResponseMessage.ADD_BOOK_SUCCESS;
        }
    }

    @Override
    public String delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from BookEntity where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return ResponseMessage.DELETE_BOOK_SUCCESS;
        }
    }

    @Override
    public BookEntity findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BookEntity bookEntity = new BookEntity();
        try {
            transaction = session.beginTransaction();
            bookEntity = session.get(BookEntity.class, id);
            bookEntity.getAuthors().size();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bookEntity;
    }

    @Override
    public String update(Integer id, String name, String[] ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<AuthorEntity> isRemove = new ArrayList<AuthorEntity>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            BookEntity bookEntity = session.get(BookEntity.class, id);
            System.out.println(name);
            bookEntity.setName(name);
            Set<AuthorEntity> authors = bookEntity.getAuthors();
            for(String ele : ids) {
                Stream<AuthorEntity> authorEntityStream = authors.stream()
                        .filter(author -> author.getId() == Integer.parseInt(ele));
                if(authorEntityStream.count() == 0) {
                    bookEntity.addAuthor(session.get(AuthorEntity.class, Integer.parseInt(ele)));
                }
            }
            for(AuthorEntity author : authors) {
                boolean isDuplicate = false;
                for(String ele : ids) {
                    if(Integer.parseInt(ele) == author.getId()) {
                        isDuplicate = true;
                        break;
                    }
                }
                if(!isDuplicate) {
                    isRemove.add(author);
                }
            }
            for (AuthorEntity authorEntity : isRemove) {
                bookEntity.removeAuthor(authorEntity);
            }
            transaction.commit();
            System.out.println("-----------------------");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return ResponseMessage.UPDATE_BOOK_SUCCESS;
        }
    }
}
