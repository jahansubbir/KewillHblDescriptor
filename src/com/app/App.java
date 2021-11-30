package com.app;

import com.dal.ExcelReader;
import com.dal.IExcelReader;
import com.ui.MainWindow;

public class App {
public static void main(String[] args) {

	IExcelReader excelReader=new ExcelReader();
	MainWindow mainWindow=new MainWindow(excelReader);
	
}
}
