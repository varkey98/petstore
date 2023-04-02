package repositories;

import graphql.com.google.common.base.Preconditions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDao<T extends  Serializable> {
    private Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    public final void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }

    // API
    public T findOne(final long id) {
        Transaction transaction = getCurrentSession().beginTransaction();
        T entity =  (T) getCurrentSession().get(clazz, id);
        transaction.commit();
        return entity;
    }

    public List<T> findAll() {
        Transaction transaction = getCurrentSession().beginTransaction();
        List<T> ret =  getCurrentSession().createQuery("from " + clazz.getName()).list();
        transaction.commit();
        return ret;
    }

    public void create(final T entity) {
        Preconditions.checkNotNull(entity);
        Transaction transaction = getCurrentSession().beginTransaction();
        getCurrentSession().merge(entity);
//        sessionFactory.openSession().saveOrUpdate(entity);
        transaction.commit(); //either transaction or a new session every time
    }

    public void update(final T entity) {
        Preconditions.checkNotNull(entity);
        Transaction transaction = getCurrentSession().beginTransaction();
        getCurrentSession().merge(entity);
        transaction.commit();
    }

    public void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        Transaction transaction = getCurrentSession().beginTransaction();
        getCurrentSession().remove(entity);
        transaction.commit();
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
