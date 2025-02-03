package com.example.controller.dao.implement;

import com.example.controller.tda.list.LinkedList;

public interface InterfazDao <T> {
    public void persist(T object) throws Exception;
    public void merge(T object, Integer index) throws Exception;
    public LinkedList listAll();
<<<<<<<< HEAD:AppDeportiva/trabajo_final/src/main/java/com/example/controller/dao/implement/InterfazDao.java
    public T get(Integer id) throws Exception;
    public void delete(Integer object) throws Exception;
========
    public T get(Integer id) throws Exception;    
>>>>>>>> rama_Eber:trabajo_finalss/src/main/java/com/example/controller/dao/implement/InterfazDao.java
}
