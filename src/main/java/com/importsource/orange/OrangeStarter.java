package com.importsource.orange;

import java.io.IOException;


/**
 * a nosql key value database
 * 
 * why call orange?because today's office desk color is orange.
 * 
 * tommorrow i will meetup about bigdata spark.
 * @author Hezf
 *
 */
public class OrangeStarter {

	public static void main(String[] args) throws IOException {
		//for(int i=30000;i<100000000;i++){
			//String key =String.valueOf(i);
			String key="11saaa6sdfsdf767sdfsdf";
			/*List<Map<String, String>> list=new ArrayList<Map<String, String>>();
			Map<String, String> map1=new HashMap<String, String>();
			map1.put("sdfsdf", "asd2323sdfsdf");
			list.add(map1);
			Map<String, String> map2=new HashMap<String, String>();
			map2.put("sdfsdf", "sdf2323sdf");
			list.add(map2);
			Map<String, String> map3=new HashMap<String, String>();
			map3.put("sdfsdf", "sdfs232323df");
			list.add(map3);
			Map<String, String> map4=new HashMap<String, String>();
			map4.put("sdfsdf", "sdfsdf233");
			list.add(map4);
			OrangeClient.insert(key,list);*/
			System.out.println(OrangeClient.get(key).toString());
		//}
		

	}

}
