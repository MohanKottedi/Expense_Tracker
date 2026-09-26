package com.mohan.expensetracker.service;

import com.mohan.expensetracker.dto.request.AddExpenseReq;
import com.mohan.expensetracker.dto.response.ExpenseResponse;
import com.mohan.expensetracker.entity.Expenses;
import com.mohan.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    public Optional<Expenses> addExpense(AddExpenseReq addExpenseReq) {
        Expenses expenses=new Expenses();
        expenses.setAmount(addExpenseReq.getAmount());

        if(addExpenseReq.getCategory()==null)
            expenses.setCategory("");
        else
            expenses.setCategory(addExpenseReq.getCategory());

        if(addExpenseReq.getDescription()==null)
            expenses.setDescription("");
        else
            expenses.setDescription(addExpenseReq.getDescription());

        if(addExpenseReq.getDate()==null)
            expenses.setDate(LocalDateTime.now());
        else
            expenses.setDate(addExpenseReq.getDate());

        expenses=expenseRepository.save(expenses);
        return Optional.of(expenses);
    }
}
