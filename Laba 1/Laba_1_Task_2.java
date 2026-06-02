public class Laba_1_Task_2 {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"шалаш", "Шалаш", "потоп", "дерево", "радар", "код"};
        }

        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " — является палиндромом.");
            } else {
                System.out.println(s + " — не является палиндромом.");
            }
        }
    }

    public static String reverseString(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome(String s) {
        String lowerCaseS = s.toLowerCase();
        String reversed = reverseString(lowerCaseS);
        return lowerCaseS.equals(reversed);
    }
}