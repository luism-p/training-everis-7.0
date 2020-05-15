package com.luis.impl;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @author luism
 */
public class GenericUtils{

	public static <T> T jsonToBean(String json, Type bean) {
		final Gson gson = new Gson();

		return gson.fromJson(json, bean);

	}


}