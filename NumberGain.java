package com.example.demo.acontest;

public class NumberGain {

	public static String getNumber(String input) {
		String num=input.replaceAll("[a-z|A-Z]", "");
		if(num.length()<1)return "";
		String[] parts=num.split("\\.");
//		System.out.println(parts[0]+":"+parts.length);
		num=parts[0];
		if(parts.length>1) {
//			System.out.println(parts[1]);
			if(parts[1].length()==0) {
				num+=".00";
			}else if(parts[1].length()==1) {
				num+="."+parts[1]+"0";
				
			}else {
				num+="."+(parts[1].substring(0,2));
			}
		}else {
			num+=".00";
		}
		return num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("abv"+" is "+getNumber("abc"));
		System.out.println("abv12"+" is "+getNumber("abv12"));
		System.out.println("abv12."+" is "+getNumber("abv12."));
		System.out.println("abv12.1"+" is "+getNumber("abv12.1"));
		System.out.println("abv12.12"+" is "+getNumber("abv12.12"));
		System.out.println("abv12.123"+" is "+getNumber("abv12.123"));

		System.out.println("abv.123"+" is "+getNumber("abv.123"));
		System.out.println("abv.188"+" is "+getNumber("abv.188"));
	}

}
