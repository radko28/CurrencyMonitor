package sk.cyklosoft.currencymonitor.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import sk.cyklosoft.currencymonitor.dao.AuthorityDao;
import sk.cyklosoft.currencymonitor.domain.Authority;

@Repository("authorityDao")
public class AuthorityDaoImpl implements AuthorityDao{
    
    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


    @Override
    public void remove(final Authority authority) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.delete(authority);
                return null;
            }
        });
    }


    @Override
    public void save(final Authority authority) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(authority);
                return null;
            }
        });
        
    }


    @Override
    public void update(final Authority authority) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.update(authority);
                return null;
            }
        });
    }

}
