package com.example.controller.dao;


import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Token;

public class TokenDao extends AdapterDao<Token>{

	private Token tokn;
	private LinkedList listTokns;

	public TokenDao() {
		super(Token.class);
	}

	public Token getToken() {

		if(tokn == null) {
			tokn = new Token();
		}
		return tokn;
	}

	public void setTokn(Token tkn) {
		this.tokn = tkn;
	}

	public LinkedList getListTokns() {
		if(listTokns == null){
            this.listTokns = listAll();
        }
        return listTokns;
	}


	public Boolean save() throws Exception {
        Integer id = getListTokns().getSize()+1;
        tokn.setIdToken(id);


        this.persist(this.tokn);
        this.listTokns = listAll();
        return true;
    }
<<<<<<< HEAD
	
	public void delete(int index) throws Exception{
		this.delete(index);
		actualizar_lista_Ids();
=======

	public void delete() throws Exception{
//		System.out.println("Elemento o indice de token "+index);
//		System.out.println("Lista vacia?: "+getListTokns().isEmpty());
		this.delete(this.tokn.getIdToken());
>>>>>>> origin/rama_Matailo
		this.listTokns = listAll();
	}

	// realizar logica para refresh token
	public Boolean refreshToken() throws Exception{
		return true;
	}

	// Realizar metodo de busqueda por token, para comparar la fecha de expiracion
}
