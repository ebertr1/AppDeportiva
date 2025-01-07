package com.example.controller.dao.services;

import com.example.controller.dao.ReglamentoDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Campeonato;
import com.example.models.Equipo;
import com.example.models.Reglamento;
import com.example.models.enumerador.Formato;
import com.example.models.enumerador.TipoCategoria;

public class ReglamentoServices {
<<<<<<< HEAD
    private ReglamentoDao obj;

    public ReglamentoServices() {
        obj = new ReglamentoDao();
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
    public Formato getFormato(String tipo) {
        return obj.getFormato(tipo);
    }

    public Formato[] getTipos() {
        return obj.getTipos();
    }

    public Reglamento get(Integer id) throws Exception {
        return obj.get(id);
    }

    public Reglamento getReglamento() {
        return obj.getReglamento();
    }

    public void setReglamento(Reglamento reglamento){
        obj.setReglamento(reglamento);
    }
=======
     private ReglamentoDao obj;
    
     public ReglamentoServices() {
          obj = new ReglamentoDao();
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
    
     public Reglamento getReglamento() {
          return obj.getReglamento();
     }
    
     public void setReglamento(Reglamento reglamento) {
          obj.setReglamento(reglamento);
     }
    
     public Reglamento get(Integer id) throws Exception {
          return obj.get(id);
     }
    
     public Formato getTipoFormato(String formato) {
          return obj.getTipoFormato(formato);
     }    
        public Formato[] getFormato() {
            return obj.getTipoFormato();
        }
<<<<<<< HEAD
>>>>>>> rama_Isauro
}
=======
}
>>>>>>> origin/rama_Isauro
