package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestDemo {

	public static void main(String[] args){
		String str = "abcd0123456";
		
		System.out.println(TestDemo.testStringPractice(str));
	}
	
	public static String testStringPractice(String str){
		String rest = "";
		if(null != str && !" ".equals(str)){
			// 替换非数字、小数点
			rest = str.replaceAll("[^0-9.]", "");
			
			BigDecimal num =  new BigDecimal(rest);
			//System.out.println(num);
						
			num = num.setScale(2, BigDecimal.ROUND_DOWN);
			
			rest = String.format("%.2f",num);
		}
		return rest;
	}

}
