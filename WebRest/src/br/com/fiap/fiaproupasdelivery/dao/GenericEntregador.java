package br.com.fiap.fiaproupasdelivery.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericEntregador<T, type extends Serializable> {
	
	boolean create(T t);
	
	boolean update(T t);
	
	boolean delete(T t);
	
	List<T> findAll();
	
	T findById(Long id);
	
	T findBylogin(String user, String pass); 

}