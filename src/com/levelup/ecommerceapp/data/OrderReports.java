package com.levelup.ecommerceapp.data;

import java.util.ArrayList;
import java.util.List;

public class OrderReports {
	
	private static List<String[]> list = new ArrayList<>();
	
	public static void putInOrderReportsList(String[] stringArray) {
		list.add(stringArray);
	}

	public static List<String[]> getList() {
		return list;
	}

}
