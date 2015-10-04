package com.db.repositories.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class HibernateDAOImpl<Entity, ID extends Serializable> implements GenericDao<Entity, ID> {

    protected Class clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    public HibernateDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clazz = (Class) pt.getActualTypeArguments()[0];
    }


    public void setEntityClass(final Class clazz) {
        this.clazz = clazz;
    }

    public Entity findById(ID id) {
        return (Entity) getCurrentSession().get(clazz, id);
    }

    public List findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public List search(Map<String, Object> parameterMap) {
        Criteria criteria = getCurrentSession().createCriteria(clazz);
        Set<String> fieldName = parameterMap.keySet();
        for (String field : fieldName) {
            criteria.add(Restrictions.ilike(field, parameterMap.get(field)));
        }
        return criteria.list();
    }

    public ID insert(Entity entity) {
        return (ID)getCurrentSession().save(entity);
    }
    
    public void savaOrUpdate(Entity entity){
    	getCurrentSession().saveOrUpdate(entity);
    }

    public void update(Entity entity) {
        getCurrentSession().update(entity);
    }

    public void delete(Entity entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(ID id) {
        delete(findById(id));
    }
    
    protected DetachedCriteria createDetachedCriteria() {
        return DetachedCriteria.forClass(clazz);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}