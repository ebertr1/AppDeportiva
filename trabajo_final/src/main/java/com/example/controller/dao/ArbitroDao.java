package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Arbitro;

<<<<<<< HEAD
public class ArbitroDao extends AdapterDao<Arbitro> {
    private Arbitro arbitro;
    private LinkedList<Arbitro> listAll;

    public ArbitroDao() {
=======


public class ArbitroDao extends AdapterDao<Arbitro> {
   
    private Arbitro arbitro;
    private LinkedList listAll;    
     
   public ArbitroDao() {
>>>>>>> main
        super(Arbitro.class);
    }

    public Arbitro getArbitro() {
        if (arbitro == null) {
            arbitro = new Arbitro();
        }
        return arbitro;
    }

<<<<<<< HEAD
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public String getTipoIdentificacion() {
        return arbitro.getIdentificacion();
    }

    public String getGenero() {
        return arbitro.getGenero().toString();
    }

    public LinkedList<Arbitro> getListAll() {
        if (listAll == null) {
=======
    public void setArbitro(Arbitro Arbitro) {
        this.arbitro = arbitro;
    }

    public LinkedList<Arbitro> getlistAll() {
        if (listAll.isEmpty()) {
>>>>>>> main
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
<<<<<<< HEAD
        Integer id = getListAll().getSize() + 1;
        arbitro.setId(id);
        this.persist(this.arbitro);
        this.listAll = listAll();
=======
        Integer id = getlistAll().getSize() + 1;
        arbitro.setId(id);
        this.persist(this.arbitro);
        this.listAll = getlistAll();
>>>>>>> main
        return true;
    }

    public Boolean update() throws Exception {
<<<<<<< HEAD
        this.merge(getArbitro(), getArbitro().getId() - 1);
        this.listAll = listAll();
        return true;
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Arbitro> list = getListAll();
=======
        try {
            this.merge(getArbitro(), getArbitro().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Arbitro> list = getlistAll();
>>>>>>> main
        Arbitro arbitro = get(id);
        if (arbitro != null) {
            list.remove(arbitro);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
<<<<<<< HEAD
            System.out.println("Arbitro con id " + id + " no encontrado.");
=======
            System.out.println("Persona con id " + id + " no encontrada.");
>>>>>>> main
            return false;
        }
    }

<<<<<<< HEAD
    public LinkedList<Arbitro> ordenarPorNombre(boolean ascendente) throws Exception {
        LinkedList<Arbitro> arbitros = getListAll();
        arbitros.quicksort("nombre", ascendente ? 1 : -1);
        return arbitros;
    }

    public LinkedList<Arbitro> ordenarPorApellido(boolean ascendente) throws Exception {
        LinkedList<Arbitro> arbitros = getListAll();
        arbitros.quicksort("apellido", ascendente ? 1 : -1);
        return arbitros;
    }

    public LinkedList<Arbitro> ordenarPorIdentificacion(boolean ascendente) throws Exception {
        LinkedList<Arbitro> arbitros = getListAll();
        arbitros.quicksort("identificacion", ascendente ? 1 : -1);
        return arbitros;
    }

    public LinkedList<Arbitro> ordenarPorFechaNacimiento(boolean ascendente) throws Exception {
        LinkedList<Arbitro> arbitros = getListAll();
        arbitros.quicksort("fechaNacimiento", ascendente ? 1 : -1);
        return arbitros;
    }

    public LinkedList<Arbitro> ordenarPorAsociacion(boolean ascendente) throws Exception {
        LinkedList<Arbitro> arbitros = getListAll();
        arbitros.quicksort("asociacion", ascendente ? 1 : -1);
        return arbitros;
    }

    public LinkedList<Arbitro> buscarPorNombre(String nombre) {
        LinkedList<Arbitro> resultados = new LinkedList<>();
        for (Arbitro arbitro : getListAll().toArray()) {
            if (arbitro.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(arbitro);
            }
        }
        return resultados;
    }

    public LinkedList<Arbitro> buscarPorApellido(String apellido) {
        LinkedList<Arbitro> resultados = new LinkedList<>();
        for (Arbitro arbitro : getListAll().toArray()) {
            if (arbitro.getApellido().equalsIgnoreCase(apellido)) {
                resultados.add(arbitro);
            }
        }
        return resultados;
    }

    public LinkedList<Arbitro> buscarPorIdentificacion(String identificacion) {
        LinkedList<Arbitro> resultados = new LinkedList<>();
        for (Arbitro arbitro : getListAll().toArray()) {
            if (arbitro.getIdentificacion().equalsIgnoreCase(identificacion)) {
                resultados.add(arbitro);
            }
        }
        return resultados;
    }

    public LinkedList<Arbitro> buscarPorAsociacion(String asociacion) {
        LinkedList<Arbitro> resultados = new LinkedList<>();
        for (Arbitro arbitro : getListAll().toArray()) {
            if (arbitro.getAsociacion().equalsIgnoreCase(asociacion)) {
                resultados.add(arbitro);
            }
        }
        return resultados;
    }

    public LinkedList<Arbitro> buscarPorGenero(String genero) {
        LinkedList<Arbitro> resultados = new LinkedList<>();
        for (Arbitro arbitro : getListAll().toArray()) {
            if (arbitro.getGenero().toString().equalsIgnoreCase(genero)) {
                resultados.add(arbitro);
            }
        }
        return resultados;
    }



}
=======
}
>>>>>>> main
