/**
 * @author Leon L D MAI
 */
public class Solution {
    public String extractDecimalAccuratePercentile(String input) {
        String numberPart = input.replaceAll("[^0-9.]", "");

        if (!numberPart.contains(".")) {
            return numberPart + ".00";
        }

        int decimalPointIndex = numberPart.indexOf(".");
        String integerPart = numberPart.substring(0, decimalPointIndex);
        String decimalPart = numberPart.substring(decimalPointIndex + 1);

        if (decimalPart.length() >= 2) {
            decimalPart = decimalPart.substring(0, 2);
        } else {
            decimalPart += "0";
        }

        return integerPart + "." + decimalPart;
    }
}
