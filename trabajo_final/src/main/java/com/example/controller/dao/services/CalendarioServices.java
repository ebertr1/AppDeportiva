package com.example.controller.dao.services;

import com.example.controller.dao.CalendarioDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Calendario;   

public class CalendarioServices {
    private CalendarioDao obj;
    
    public CalendarioServices() {
        obj = new CalendarioDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id);
    }

    public LinkedList listAll() {
        return obj.getListAll();
    }

    public Calendario getCalendario() {
        return obj.getCalendario();
    }

    public void setCalendario(Calendario calendario) {
        obj.setCalendario(calendario);
    }

    public Calendario get(Integer id) throws Exception {
        return obj.get(id);
    }   

<<<<<<< HEAD
}
=======
}
>>>>>>> origin/rama_Isauro
