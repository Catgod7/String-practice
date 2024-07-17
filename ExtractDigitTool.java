import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDigitTool {
	public static void main(String[] args) {
		String[] testCases = new String[] {"aaa123", "aaa123.4", "aaa123.45", "aaa123.456"};
		for (int i = 0; i < testCases.length; i++) {
			String testCase = testCases[i];
			System.out.println(getDigit(testCase));
		}
	}
	
	public static String getDigit(String s) {
		Pattern pattern = Pattern.compile("\\d+[.\\d]*");
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			String digitStr = matcher.group();
			return new BigDecimal(digitStr).setScale(2, BigDecimal.ROUND_FLOOR).toString();
		}
		return "no digits found";
	}
}
