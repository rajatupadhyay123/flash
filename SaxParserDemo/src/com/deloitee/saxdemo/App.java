package com.deloitee.saxdemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class App {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = parserFactory.newSAXParser();
		EmployeeHandler employeeHandler = new EmployeeHandler();
		saxParser.parse(new File("employee.xml"), employeeHandler);
		ArrayList<Employee> arrayList = employeeHandler.getEmpoyee();
		arrayList.forEach(emmployee -> System.out.println("eno:"+emmployee.getEno()+"name"+emmployee.getName()+"salary"+emmployee.getSalary()));

	}

}
