public class myPractice {
    public static void main(String[] args) {
        String input1 = "abcd123.456";
        String input2 = "abcd123";

        String result1 = extractAndFormatNumber(input1);
        String result2 = extractAndFormatNumber(input2);

        System.out.println(result1); // 输出 "123.45"
        System.out.println(result2); // 输出 "123.00"
    }

    public static String extractAndFormatNumber(String input) {
        // 找到字符串中的数字部分
        String numberPart = input.replaceAll("[^0-9.]", "");

        // 如果字符串末尾是小数点，补充两位小数
        if (numberPart.endsWith(".")) {
            numberPart += "00";
        }

        // 如果字符串中包含小数点
        if (numberPart.contains(".")) {
            int dotIndex = numberPart.indexOf(".");
            String integerPart = numberPart.substring(0, dotIndex);
            String decimalPart = numberPart.substring(dotIndex + 1, numberPart.length());

            // 截取小数点后两位，不四舍五入
            if (decimalPart.length() > 2) {
                decimalPart = decimalPart.substring(0, 2);
            } else if (decimalPart.length() < 2) {
                decimalPart = decimalPart + "0";
            }

            return integerPart + "." + decimalPart;
        } else {
            // 如果字符串中不包含小数点，补充两位小数
            return numberPart + ".00";
        }
    }
}
