package com.anastasiia.elmar.loanapp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanCalculator {

    public static final BigDecimal YEAR_MONTHS = new BigDecimal("12");

    public List<MonthlySchedule> calculate(Loan loan) {
        BigDecimal monthlyInterestRate = loan.interestRate.divide(YEAR_MONTHS, RoundingMode.HALF_DOWN);
        BigDecimal monthlyDebt = loan.debtAmount.divide(new BigDecimal(loan.terms), RoundingMode.HALF_DOWN);
        BigDecimal monthlyInterestDebt = monthlyDebt
                .multiply(monthlyInterestRate)
                .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
        LocalDate today = LocalDate.now();

        List<MonthlySchedule> schedules = new ArrayList<>();
        for (int i = 1; i <= loan.terms; i++) {
            MonthlySchedule monthlySchedule = new MonthlySchedule();
            monthlySchedule.interestAmount = monthlyInterestDebt;
            monthlySchedule.mainAmount = monthlyDebt;
            monthlySchedule.shouldPay = monthlyInterestDebt.add(monthlyDebt);
            monthlySchedule.date = today.plusMonths(i);
            schedules.add(monthlySchedule);
        }
        return schedules;
    }
}
