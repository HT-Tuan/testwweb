package com.DayDream.model.dao;

public interface IHibernateDao<E> {
    public boolean insert(E entity);
    public boolean update(E entity);
    public boolean delete(E entity);
}
