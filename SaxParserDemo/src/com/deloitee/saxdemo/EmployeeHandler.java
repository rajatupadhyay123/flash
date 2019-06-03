package com.deloitee.saxdemo;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeHandler extends DefaultHandler{
	private Employee employee;
	private StringBuffer data;
	private ArrayList<Employee> list;
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		 data = new StringBuffer();
		data.append(ch, start, length);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	if (qName.equals("employee")) {
		 employee = new Employee();
	}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("eno")) {
			employee.setEno(Integer.parseInt(data.toString()));
			
		}
		if (qName.equals("name")) {
			employee.setName(data.toString());
		}
		if (qName.equals("salary")) {
			employee.setSalary(Double.parseDouble(data.toString()));
		}
		if (qName.equals("employee")) {
			list.add(employee);
		}
	}
	
	@Override
	public void startDocument() throws SAXException {
		 list = new ArrayList<Employee>();
	}
	public ArrayList<Employee> getEmpoyee(){
		return list;
	}
}





