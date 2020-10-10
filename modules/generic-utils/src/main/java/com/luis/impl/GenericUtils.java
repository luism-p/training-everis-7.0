package com.luis.impl;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @author luism
 */
public interface GenericUtils{

	default <T> T jsonToBean(String json, Type bean) {
		final Gson gson = new Gson();

		return gson.fromJson(json, bean);
	}
	default<T> void print(T t){
		System.out.println(t);
	}

	default String prueba(String str){
		str = str.toUpperCase();

		return str;
	}

	static String pruebaStatic(String str){
		str = str.toUpperCase();

		return str;
	}


}