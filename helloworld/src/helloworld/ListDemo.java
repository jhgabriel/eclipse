package helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {

	
	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList();
//		List<String> list = new ArrayList();
		
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.remove("3");
		list.add("4");
		
		for(String str: list) {
			if(str.equals("4")) {
				list.remove("4");
			}
		}
	}
}
