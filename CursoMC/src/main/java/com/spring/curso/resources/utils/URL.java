package com.spring.curso.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static String decodeParam(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static List<Integer> decodeIntList(String str){
		String[] vet = str.split(",");
		List<Integer> list = new ArrayList<>();
		for (String valor : vet) {
			list.add(Integer.parseInt(valor));
		}
		//Arrays.asList(str.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		return list;
	}
	
	
}
