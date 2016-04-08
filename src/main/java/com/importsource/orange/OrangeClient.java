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
	
	/**
	 * 字符表
	 */
	private static final char[] Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9' };

	/**
	 * 按照指定宽度生成随机字符串
	 * 
	 * @param _width
	 *            字符串的宽度
	 * @return 随机字符串
	 */
	static protected String randomString(int _width) {
		int width = _width <= 0 ? 6 : _width;
		char[] ret = new char[width];
		Random ran = new Random();
		for (int i = 0; i < width; i++) {
			int intValue = ran.nextInt(62) % 62;
			ret[i] = Chars[intValue];
		}

		return new String(ret);
	}

	private static String generateJson(String key, Object value) {
		Ison ison=new Ison(true);
		return ison.toJson(value, key);
	}
	
	


}
