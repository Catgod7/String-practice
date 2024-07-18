public class NumberExtractor {

    public static void main(String[] args) {
        System.out.println(extractAndFormatNumber("abcd123.456")); // 输出: "123.45"
        System.out.println(extractAndFormatNumber("abcd123"));     // 输出: "123.00"
    }

    public static String extractAndFormatNumber(String input) {

        String numberPart = input.replaceAll("[^0-9.]", "");

        if (numberPart.isEmpty()) {
            return "No number found";
        }

        if (numberPart.contains(".")) {
            int dotIndex = numberPart.indexOf(".");
            if (dotIndex < numberPart.length() - 2) {
                return numberPart.substring(0, dotIndex + 3);
            } else {
                return numberPart;
            }
        } else {
            return numberPart + ".00";
        }
    }


}
