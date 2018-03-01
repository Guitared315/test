package jp.co.internous.action;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();

		// 値の記憶はaddメソッドを利用
		for(int i = 0; i <= 100; i++){
			String str = String.valueOf(i);
			list.add(str);
		}

		for(String s : list){
			System.out.println(s);
		}
	}
}
