package com.demo.programs.collection.set;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeAndEqualContrat {
	private static final String CURRENCY_INR="INR";
	private static final String CURRENCY_USD="USD";
	private static final String CURRENCY_POUND="POAND";
	public static void main(String[] args) {
		compareObjectWithoutEqaulsAndHashcodeMethods();
	}
	
	
	
	/**
	 * Compare the two object without overriding hash code and equals methods 
	 * If you will remove the equals method from WrongMoney class then it will start giving wrong result. 
	 * If two objects are same then there hash code also be same. try it after removing the hash code in Money calss.
	 * **/
	public static void compareObjectWithoutEqaulsAndHashcodeMethods() {
		Money money1 =new Money(100, CURRENCY_INR);
		Money money2 =new Money(100, CURRENCY_USD);
		Money money3 =new Money(100, CURRENCY_POUND);
		boolean compareResult = money1.equals(money2); 
		
		System.out.println("Is money1 and money2 same ? "+compareResult+" It should be same as content is same. ");
		System.out.println("Is money1 "+money1.hashCode()+" hash code ");
		System.out.println("Is money2 "+money2.hashCode()+" hash code ");
		System.out.println("Is money1 and money2 same "+(money1.hashCode()==money2.hashCode()));
		System.out.println("Is money1 refernce "+money1);
		System.out.println("Is money2 refernce "+money2);
		System.out.println("Is money1 and money2 same "+(money1==money2));
		HashMap<Money, String> hashMap=new HashMap<>();
		System.out.println(" Hashmap put "+hashMap.put(money1, CURRENCY_INR));
		System.out.println(" Hashmap put "+hashMap.put(money2, CURRENCY_USD));
		System.out.println(" Hashmap put "+hashMap.put(money3, CURRENCY_POUND));
		System.out.println(hashMap);	
	}

}





class Money{
	int amount;
	String currency;
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Override
	public int hashCode() {
		return 1000;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount && Objects.equals(currency, other.currency);
	}

}