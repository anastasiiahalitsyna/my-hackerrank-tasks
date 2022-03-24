package com.anastasiia.elmar.loanapp;

import java.math.BigDecimal;
import java.time.LocalDate;

//POJO
public class MonthlySchedule {
    public LocalDate date;
    public BigDecimal interestAmount;
    public BigDecimal mainAmount;
    public BigDecimal shouldPay;

    @Override
    public String toString() {
        return "Date: " + date +
                "| Interest Amount: " + interestAmount + " USD " +
                "| Main Amount: " + mainAmount + " USD " +
                "| Total should pay: " + shouldPay + " USD ";
    }
}
