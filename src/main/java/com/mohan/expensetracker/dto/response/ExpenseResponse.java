package com.mohan.expensetracker.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseResponse {
    Long id;
    BigDecimal amount;
    String description;
    String category;
    LocalDateTime date;
}
