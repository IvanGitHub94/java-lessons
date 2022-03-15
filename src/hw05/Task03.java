package hw05;

public class Task03 {
    public static void main(String[] args) {
        String s = "в предложении все слова разной длины";
        String[] words = s.split(" ");
        int len = 0;
        String res = "";
        for (String str : words) {
            if (str.length() > len) {
                len = str.length();
                res = str;
            }
        }
        System.out.println("Самое длинное слово в предложении: " + "\"" + res + "\" .");
    }
}
