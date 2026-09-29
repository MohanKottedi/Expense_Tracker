package com.mohan.expensetracker.dto.request;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AddExpenseReq {
    @DecimalMin(value="0.01",message = "Amount should be greater than 0")
    BigDecimal amount;
    String description;
    String category;
    LocalDateTime date;
    @PrePersist
    public void currentDate() {
        if (date == null) {
            date = LocalDateTime.now();
        }
    }
}
