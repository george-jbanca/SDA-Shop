package ro.sda.repository;

import java.util.List;

public interface Repository<T> {

    public T find(Long id);

    public List<T> findAll();

    public void save(T t);

    public void saveAll(List<T> ts);

    public void delete(Long id);
}
