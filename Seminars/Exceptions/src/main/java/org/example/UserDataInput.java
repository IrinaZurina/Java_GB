package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class UserDataInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел данные: Фамилия, Имя, Отчество, дата рождения (дд.мм.гггг), номер телефона, пол (f или m)");
        String input = scanner.nextLine().trim();  // дополнительно убирает лишние пробелы в начале и конце строки
        scanner.close();

        String[] parts = input.split("\\s+"); //разделяет строку по любому количеству пробелов

        if (parts.length != 6) {
            System.err.println("Ошибка: Необходимо ввести 6 параметров.");
            return;
        }

        try {
            String lastName = parseFIO(parts[0]);
            String firstName = parseFIO(parts[1]);
            String middleName = parseFIO(parts[2]);
            String birthDate = parseBirthDate(parts[3]);
            long phoneNumber = parsePhoneNumber(parts[4]);
            char gender = parseGender(parts[5]);

            String fileName = lastName + ".txt";
            String userData = lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(userData + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            System.out.println("Данные успешно записаны в файл: " + fileName);

        } catch (UserDataFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static String parseFIO(String input) throws UserDataFormatException {
        if (input.matches("[а-яА-Я]+")) {
            return input;
        } else {
            throw new UserDataFormatException("Неверный формат ФИО (содержит не только буквы).");
        }
    }
    private static String parseBirthDate(String input) throws UserDataFormatException {
        if (input.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            int day = Integer.parseInt(input.substring(0, 2));
            int month = Integer.parseInt(input.substring(3, 5));
            int year = Integer.parseInt(input.substring(6));
            if (day < 1 || day > 31 || (day > 29 && month==2) ||
                    (day==31 && (month==4 || month==6 || month==9 || month==11)))
                throw new UserDataFormatException("Неверный день рождения");
            if (month < 1 || month > 12) throw new UserDataFormatException("Неверный месяц рождения");
            if (year < 1 || year > 2023) throw new UserDataFormatException("Неверный год рождения");
            return input;
        } else {
            throw new UserDataFormatException("Неверный формат даты рождения.");
        }
    }

    private static long parsePhoneNumber(String input) throws UserDataFormatException {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new UserDataFormatException("Неверный формат номера телефона.");
        }
    }

    private static char parseGender(String input) throws UserDataFormatException {
        if (input.equalsIgnoreCase("f") || input.equalsIgnoreCase("m")) {
            return input.charAt(0);
        } else {
            throw new UserDataFormatException("Неверный формат пола.");
        }
    }

    static class UserDataFormatException extends Exception {
        public UserDataFormatException(String message) {
            super(message);
        }
    }
}
