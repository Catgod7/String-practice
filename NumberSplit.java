public class NumberSplit {
	public static String extractNumber(String str) {
		//判断是否空字串
		if (str == null || str.length() == 0) {
			return "";
		}
		//提取字符串中数字的部分
		str = str.replaceAll("[^0-9.]", "");
		//判断是否为空
		if (str.length() == 0) {
			return "";
		}
		//检测是否包含.
		if (str.contains(".")) {
			int indexOf = str.indexOf(".");
			if(indexOf==0){
				return "";
			}
			//如果包含.则截取第一个.
			String integer = str.substring(0, indexOf);
			String decimal = str.substring(indexOf +1);
			//decimal长度小2，则补充两个0
			if (decimal.length()<2){
				decimal = decimal + "00";
			}
			//decimal统一截取2位
			str = integer+"."+decimal.substring(0,2);
		}else{
			str = str +".00";
		}

		return str;
	}
	public static void main(String[] args) {
		System.out.println(extractNumber("abc456"));//输出456.00
		System.out.println(extractNumber("abc456.1234124") );//输出456.12
		System.out.println(extractNumber("abc456.2"));//输出456.20
		System.out.println(extractNumber("abc456."));//输出456.00
		System.out.println(extractNumber("."));//输出“”
		System.out.println(extractNumber("abas"));//输出“”
		System.out.println(extractNumber(" "));//输出“”
	}

}
