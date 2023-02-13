package org.example;

public class TicketIdGenerator {

    private static int start = 0;

    private static String getStringFromInt(int number) {
        return switch (number) {
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            default -> Integer.toString(number);
        };
    }

    public static String generateId() {
        StringBuilder result = new StringBuilder();
        if (start == 0) {
            ++start;
            return result.append("A0").toString();
        }
        int div = start++;
        while (div > 0) {
            int reminder = div % 16;
            result.append(getStringFromInt(reminder));
            div /= 16;
        }
        return result.append("A").reverse().toString();
    }
}
