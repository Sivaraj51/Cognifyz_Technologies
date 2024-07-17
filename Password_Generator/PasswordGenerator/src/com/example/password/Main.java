package com.example.password;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLowercase = scanner.nextBoolean();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecial = scanner.nextBoolean();

        PasswordGenerator generator = new PasswordGenerator(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial);
        String password = generator.generate();

        System.out.println("Generated Password: " + password);
    }
}
