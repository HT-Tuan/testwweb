package com.DayDream.model.dao;

public interface IHibernateDao<E> {
    public E insert(E entity);
    public E update(E entity);
    public E delete(E entity);
    public E get(E entity);
}
