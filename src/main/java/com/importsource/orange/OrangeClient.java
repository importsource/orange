package com.importsource.orange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

import com.importsource.ison.Ison;
import com.importsource.orange.common.excpt.MultipleKeyException;

public class OrangeClient {

	public static void insert(String key, Object value) throws IOException {
		Object obj=get(key);
		if(obj!=null){
			throw new MultipleKeyException("The key is existed:"+key);
		}
		String jsonAggregate=generateJson(key,value);
		FileAppender appender=new FileAppender();
		appender.append(jsonAggregate);
	}
	
	public static Object get(String key) throws IOException{
		if(key.indexOf("\"")>=0){
			throw new IllegalArgumentException("The key can't contain quote:"+key);
		}
		FileReader reader= new FileReader(new File("Y:\\orange.db")); 
		BufferedReader bufferedReader=new BufferedReader(reader);
		for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
			if(line.indexOf("\""+key+"\"")==1){
				return line;
			}
			//System.out.println(line);
		}
		return null;
	}
	
	

	private static String generateJson(String key, Object value) {
		Ison ison=new Ison(true);
		return ison.toJson(value, key);
	}
	
	


}
