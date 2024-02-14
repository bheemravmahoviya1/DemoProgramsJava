package com.demo.programs.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SerializationDeserializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//writePrimitiveType(); 
		serializationAndDeserializationInObject();
	}

	
	/**
	 * Note: It is very important that, the class we want to serializable should be implement serialization interface.
	 *       It your class having any other object type field then that field class also should implement serialization interface.
	 *       If we have not defined 'serialVersionUID' in class then JVM internally generate 'serialVersionUID' id
	 *       If there is a change in object class then it will give invalidClassException. adding or removing the field.
	 *       If you have defined any custom 'serialVersionUID' id then there will no impact of adding and removing the field while deserialization.  
	 * */
	private static void serializationAndDeserializationInObject() throws IOException, ClassNotFoundException {
			writeObject();
			readObject();
	}
	
	private static void writeObject() throws IOException {
			Address address=new Address();
	        Person writePerson = new Person("Bheemrav",29);
	        writePerson.setAddress(address);
			OutputStream outputStream=getFileOutputStream();
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(writePerson);
			objectOutputStream.flush();
			objectOutputStream.close();
			outputStream.close();
			System.out.println("writePerson  :"+writePerson);	
	}
	
	private static void readObject() throws IOException, ClassNotFoundException {
		InputStream inputStream = getFileInputStream();
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		
		Person readedPerson = (Person) objectInputStream.readObject(); 
		inputStream.close();
		objectInputStream.close();
		System.out.println("readedPerson :"+readedPerson);		
}
	
	@Override
	public String toString() {
		return "ObjectInputOutputStreamTest []";
	}


	private static void writePrimitiveType() throws IOException {
		 int testValue = 100;
			OutputStream outputStream=getFileOutputStream();
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
			objectOutputStream.write(testValue);
			objectOutputStream.flush();
			objectOutputStream.close();
			outputStream.close();
			
			
			InputStream inputStream = getFileInputStream();
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			int readedValue = objectInputStream.read(); 
			inputStream.close();
			objectInputStream.close();
			if(testValue == readedValue) {
				System.out.println("Value is readed and found same.");
			}else {
				System.out.println("Value not found.");				
			}
	}
	
	
	
	/**
	 * @see This method is going to be create a file using OutputStream.
	 * @throws FileNotFoundException 
	 * File Path: F:\2024\learning\git projects\DemoProgramsJava
	 * */
	private static OutputStream getFileOutputStream() throws FileNotFoundException {
		OutputStream  outputStream=new FileOutputStream(getFile());
		return outputStream;
		
	}
	
	/**
	 * @see This method is going to be create a file using OutputStream.
	 * @throws FileNotFoundException 
	 * File Path: F:\2024\learning\git projects\DemoProgramsJava
	 * */
	private static InputStream getFileInputStream() throws FileNotFoundException {
		InputStream  inputStream=new FileInputStream(getFile());
		return inputStream;
		
	}
	
	
	private static File getFile() {
		return new File("F:/2024/learning/git projects/DemoProgramsJava/myTestFile.txt");
	}
	
}



class Person implements Serializable{
    private static final long serialVersionUID = 1L;
   transient Address address;
	String name;
	int age;
	String location;
	public Address getAddress() {
		return address;
	}
	public String getLocation() {
		return location;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return super.toString()+"  Person [address=" + address + ", name=" + name + ", age=" + age + ", location=" + location + "]";
	}
	
	 private void writeObject(ObjectOutputStream oos) 
		      throws IOException {
	       oos.defaultWriteObject();
	        oos.writeObject(address.houseNo);
	 }
	 
	 private void readObject(ObjectInputStream ois) 
		      throws ClassNotFoundException, IOException {
		        ois.defaultReadObject();
		        Integer houseNumber = (Integer) ois.readObject();
		        Address a = new Address();
		        a.houseNo=houseNumber;
		        this.setAddress(a);
		    }
	
}

class Address{
	int houseNo=100;
}