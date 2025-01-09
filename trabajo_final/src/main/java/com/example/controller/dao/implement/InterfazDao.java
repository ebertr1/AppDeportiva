package com.example.controller.dao.implement;

import com.example.controller.tda.list.LinkedList;

public interface InterfazDao <T> {
    public void persist(T object) throws Exception;
    public void merge(T object, Integer index) throws Exception;
    public LinkedList listAll();
<<<<<<< HEAD
    public T get(Integer id) throws Exception;    
=======
    public T get(Integer id) throws Exception;
    public void delete(Integer object) throws Exception;
>>>>>>> origin/rama_Matailo
}
