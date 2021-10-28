package br.com.locadora.helpers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class ToJson {
	public String converter(List<?> objetos) {
		GsonBuilder gBuilder = new GsonBuilder();
		Gson gSon = gBuilder.create();
		
		String jsonObject = gSon.toJson(objetos);
		return jsonObject;
	}

}
