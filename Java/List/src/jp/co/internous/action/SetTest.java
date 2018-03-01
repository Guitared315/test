package jp.co.internous.action;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args){
		Set<String> set = new HashSet<String>();


		//値のセットはaddメソッドを利用
		set.add("value1");
		set.add("value2");
		set.add("value3");
		set.add("value4");
		set.add("value5");


	

	//拡張For文を利用
	for(String s : set){
		System.out.println(s);
		}
	}
}
