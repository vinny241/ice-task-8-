
package task.pkg8;

import java.util.regex.Pattern;

public class EventReservationSystem {

    private static final String BOOKING_CODE_REGEX = "^[^_]*_[^_]{1,11}$";
    private static final int MIN_PASSWORD_LENGTH = 8;

    public boolean checkBookingCode(String code) {
        return code != null && Pattern.matches(BOOKING_CODE_REGEX, code);
    }

    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }
        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecialChar = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));

        return hasUpperCase && hasDigit && hasSpecialChar;
    }

    public String makeReservation(String bookingCode, String password) {
        if (!checkBookingCode(bookingCode)) {
            return "Booking code is incorrectly formatted.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements.";
        }
        return "Reservation successfully made!";
    }

    public static void main(String[] args) {
        EventReservationSystem system = new EventReservationSystem();
        // Example usage
        System.out.println(system.makeReservation("Event_123", "Password1@"));
    }
}
