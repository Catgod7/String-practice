import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ProjectName:    String-practice
 * @Package:        PACKAGE_NAME
 * @ClassName:      Answer
 * @Author:     Vanessa
 * @Description:  
 * @Date:    2024/7/18
 * @Version:    1.0
 */
public class Answer {
    public static String extractAndFormatNumber(String input) {
        String regex = "[0-9]+(?:\\.[0-9]{1,2})?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String numberStr = matcher.group();
            if (numberStr.contains(".")) {
                int dotIndex = numberStr.indexOf(".");
                if (dotIndex + 3 <= numberStr.length()) {
                    return numberStr.substring(0, dotIndex + 3);
                }
            }
            return numberStr + ".00";
        }
        return "0.00";
    }

    public static void main(String[] args) {
        String input1 = "abcd123.456";
        String input2 = "abcd123";
        String input3 = "abcde123.";
        String input4 = "abcdef";

        System.out.println(extractAndFormatNumber(input1)); // 输出：123.45
        System.out.println(extractAndFormatNumber(input2)); // 输出：123.00
        System.out.println(extractAndFormatNumber(input3)); // 输出：123.00
        System.out.println(extractAndFormatNumber(input4)); // 输出：0.00
    }

}
