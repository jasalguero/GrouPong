package de.groupon.hcktn.groupong.model.dao;

import java.util.List;

public interface DAO <T> {

    public T create(final T t);

    public T retrieve(final Integer id);

    public List<T> retrieveAll();

    public T update(final T t);

    public void delete(final Integer id);

}
