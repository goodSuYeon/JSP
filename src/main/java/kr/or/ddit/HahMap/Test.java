package kr.or.ddit.HahMap;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Test {
	public static void main(String[] args) {
		for(Locale locae : SimpleDateFormat.getAvailableLocales()) {
			System.out.println(locae);
		}
	}
}
