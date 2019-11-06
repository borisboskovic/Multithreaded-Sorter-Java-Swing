package main;

import java.awt.GraphicsEnvironment;

import global.ActiveTheme;

public class MainClass{
	
	public static void main(String[] args) {
		new Prozor();
		System.out.println(ActiveTheme.getInstance().getThemeColor().getRed());
	}

}
