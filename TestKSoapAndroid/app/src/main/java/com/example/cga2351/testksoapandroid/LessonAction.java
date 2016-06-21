package com.example.cga2351.testksoapandroid;

public class LessonAction {
	public boolean add(String str) {
		String[] list = str.split(",");
		if (list.length > 0) {
			for (int i = 0; i < list.length; i++) {
				System.out.println(list[i]);
			}
		}
		return true;
	}
}
