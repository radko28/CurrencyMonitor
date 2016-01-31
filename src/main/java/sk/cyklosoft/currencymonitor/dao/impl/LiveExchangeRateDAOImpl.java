package sk.cyklosoft.currencymonitor.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import sk.cyklosoft.currencymonitor.dao.LiveExchangeRateDAO;
import sk.cyklosoft.currencymonitor.domain.LiveExchangeRate;

@Repository("liveExchangeRateDAO")
public class LiveExchangeRateDAOImpl implements LiveExchangeRateDAO {

    private HibernateTemplate hibernateTemplate = null;
	

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	public List<LiveExchangeRate> getLiveExhangeRateByDate(final String currDate) {
		List<LiveExchangeRate> result = hibernateTemplate.execute(new HibernateCallback<List<LiveExchangeRate>>() {

            @SuppressWarnings("unchecked")
			@Override
            public List<LiveExchangeRate> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(LiveExchangeRate.class);
                criteria.add(Restrictions.eq("created", currDate));
                return (List<LiveExchangeRate>)criteria.list();
            }
        });

        return result;
	}
     

	@Override
	public void save(final LiveExchangeRate liveExchangeRate) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(liveExchangeRate);
                return null;
            }
        });
		
	}

	@Override
	public void delete(final String currDate) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(LiveExchangeRate.class);
                criteria.add(Restrictions.lt("created", currDate));
                @SuppressWarnings("unchecked")
				List<LiveExchangeRate> liveExchangeRateList = (List<LiveExchangeRate>)criteria.list();
    			for(LiveExchangeRate liveExhangeRate : liveExchangeRateList) {
    				session.delete(liveExhangeRate);					
    			}                
                return null;
            }
        });

		
	}

}
