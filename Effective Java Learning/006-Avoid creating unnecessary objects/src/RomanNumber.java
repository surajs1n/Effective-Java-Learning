import java.util.regex.Pattern;

public class RomanNumber {
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(([MD|D?C{0,3}X[CL]|L?X{0,3})(I[XV]|V?I{0,3}(I[XV]|v?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(([MD|D?C{0,3}X[CL]|L?X{0,3})(I[XV]|V?I{0,3}(I[XV]|v?I{0,3})$");
    }

    static boolean isRomanNumeralVersionTwo(String s) {
            return ROMAN.matcher(s).matches();
    }

    public static void main(String []args) {
        String numberOne = "XXII";
        String numberTwo = "VVVVVV";

        if (isRomanNumeral(numberOne)) {
            System.out.println(numberOne + " is roman number.");
        } else {
            System.out.println(numberOne + " is not roman number.");
        }

        if (isRomanNumeralVersionTwo(numberTwo)) {
            System.out.println(numberTwo + " is roman number.");
        } else {
            System.out.println(numberTwo + " is not roman number.");
        }
    }
}
