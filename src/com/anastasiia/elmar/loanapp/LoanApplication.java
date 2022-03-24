package com.anastasiia.elmar.loanapp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class LoanApplication {


    public static void main(String[] args) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What amount do you what to take?(in USD)");
                Loan loan = new Loan();
                loan.debtAmount = scanner.nextBigDecimal();
                System.out.println("What period do you to loan money(in months)");
                loan.terms = scanner.nextInt();
                loan.interestRate = new BigDecimal("24");
                LoanCalculator calculator = new LoanCalculator();
                List<MonthlySchedule> schedules = calculator.calculate(loan);
                for (int j = 0; j < schedules.size(); j++) {
                    System.out.printf("#%d | %s\n", j + 1, schedules.get(j));
                }
                break;
            } catch (Exception exception) {
                System.out.println("Wrong input! Try again!");
            }
        }
    }
}
// 1. Create a class that represent a Loan (such classes we usually call
// POJO -> they don't contain smart methods). They are used in order to hold data
// 2. Create a class that represent Loan payment schedule (for a month simply) (also a POJO class)
// 3. Create a class that is responsible to do all the calculation