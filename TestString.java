import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jase M J Tian
 * @date 2024/07/17
 */
public class TestString {
    public static void main(String[] args) {
        String input = "abcd123.456";
        String numberString = extractNumber(input);
        System.out.println(numberString);
        // Output: 123.45

        String input2 = "abcd123";
        String numberString2 = extractNumber(input2);
        System.out.println(numberString2);
        // Output: 123.00
    }

    public static String extractNumber(String str) {
        // 定义正则表达式匹配字母和数字
        Pattern pattern = Pattern.compile("[a-zA-Z]+(\\d+(\\.\\d{1,2})?)?");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String numberPart = matcher.group(1);
            // 获取匹配的第一个组
            if (numberPart != null) {
                // 判断是否包含小数点
                if (numberPart.contains(".")) {
                    // 截取小数点后两位，不四舍五入
                    int index = numberPart.indexOf(".");
                    if (index + 3 <= numberPart.length()) {
                        return numberPart.substring(0, index + 3);
                    } else {
                        return numberPart;
                    }
                } else {
                    // 如果没有小数点，则补充 ".00"
                    return numberPart + ".00";
                }
            }
        }

        // 默认情况，返回 "0.00" （理论上不会发生）
        return "0.00";
    }
}
