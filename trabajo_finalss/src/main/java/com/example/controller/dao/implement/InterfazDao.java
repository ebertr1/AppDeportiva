package com.example.controller.dao.implement;

import com.example.controller.tda.list.LinkedList;

public interface InterfazDao <T> {
    public void persist(T object) throws Exception;
    public void merge(T object, Integer index) throws Exception;
    public LinkedList listAll();
    public T get(Integer id) throws Exception;    
}
