package com.mohan.expensetracker.dto.request;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AddExpenseReq {
    BigDecimal amount;
    String description;
    String category;
    LocalDateTime date;
}
