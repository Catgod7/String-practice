import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExtractorWithExceptionHandling {
    public static String extractNumber(String str) {
        try {
            // 使用正则表达式匹配数字部分
            Pattern pattern = Pattern.compile("\\d+(\\.\\d{0,2})?");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                String numStr = matcher.group();
                if (!numStr.contains(".")) {
                    numStr += ".00";
                } else {
                    numStr = numStr.substring(0, Math.min(numStr.length(), numStr.indexOf('.') + 3));
                }
                return numStr;
            }
            return "";
        } catch (Exception e) {
            System.out.println("处理字符串时发生异常: " + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        String str1 = "abcd123.456";
        String str2 = "abcd123";
        System.out.println(extractNumber(str1)); 
        System.out.println(extractNumber(str2)); 
    }
}
