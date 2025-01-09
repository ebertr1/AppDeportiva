package com.example.controller.dao.implement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.example.controller.tda.list.LinkedList;
import com.google.gson.Gson;

public class AdapterDao <T> implements InterfazDao<T> {
    private Class clazz;
    protected Gson g;
    public static String URL = "src/media/";

    public AdapterDao(Class clazz){
        this.clazz = clazz;
        this.g = new Gson();
    }

    @Override
	public LinkedList listAll() {
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = readFile();
            T[] matrix = (T[]) g.fromJson(data, java.lang.reflect.Array.newInstance(clazz, 0).getClass());
            list.toList(matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
	public T get(Integer id) throws Exception {
        LinkedList<T> list = listAll();
        if (!list.isEmpty()) {
            T[] matriz = list.toArray();
            return matriz[id - 1];
        }
        return null;
    }

    @Override
	public void merge(T object, Integer index) throws Exception {
        LinkedList<T> list = listAll();
        list.update(object, index);
        String info = g.toJson(list.toArray());
        saveFile(info);
    }

    @Override
	public void persist(T object) throws Exception {
        LinkedList<T> list = listAll();
        list.add(object);
        String info = g.toJson(list.toArray());
        saveFile(info);
    }

    private String readFile() throws Exception {
        File file = new File(URL + clazz.getSimpleName() + ".json");

        if (!file.exists()) {
            System.out.println("El archivo no existe, creando uno nuevo: " + file.getAbsolutePath());
            saveFile("[]");
        }

        StringBuilder sb = new StringBuilder();
        try (Scanner in = new Scanner(new FileReader(file))) {
            while (in.hasNextLine()) {
                sb.append(in.nextLine()).append("\n");
            }
        }
        return sb.toString().trim();
    }


    protected void saveFile(String data) throws Exception {
        File file = new File(URL + clazz.getSimpleName() + ".json");
        file.getParentFile().mkdirs();

        if (!file.exists()) {
            System.out.println("Creando el archivo JSON: " + file.getAbsolutePath());
            file.createNewFile();
        }

        try (FileWriter f = new FileWriter(file)) {
            f.write(data);
            f.flush();
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

	@Override
	public void delete(Integer elemnt) throws Exception {
		LinkedList<T> list = listAll();
		list.delete(elemnt);
		String info = g.toJson(list.toArray());
		// 3.
		saveFile(info); //guarda
	}

	public void UpdateFile(LinkedList<T> dataList) throws Exception {
		// 1. Crear un Objeto File o Archivo para almacenar los datos
		File file = new File(URL + clazz.getSimpleName() + ".json");
		String info = g.toJson(dataList.toArray());
		// 2. Objeto como tipo cursor para la escritura
		FileWriter fw = new FileWriter(file);
		try { // Usamos try-with-resources para cerrar automáticamente el FileWriter
			fw.write(info);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}
}
