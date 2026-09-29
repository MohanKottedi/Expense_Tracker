package com.mohan.expensetracker.service;

import com.mohan.expensetracker.Exception.IdNotFoundException;
import com.mohan.expensetracker.Exception.InvalidAmountException;
import com.mohan.expensetracker.dto.request.AddExpenseReq;
import com.mohan.expensetracker.dto.request.EditExpenseReq;
import com.mohan.expensetracker.entity.Expenses;
import com.mohan.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expenses addExpense(AddExpenseReq addExpenseReq) {
        Expenses expenses=new Expenses();
        if(addExpenseReq.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new InvalidAmountException("Invalid amount. Negative amount is not allowed");

        expenses.setAmount(addExpenseReq.getAmount());
        expenses.setCategory(addExpenseReq.getCategory());
        expenses.setDescription(addExpenseReq.getDescription());

        if(addExpenseReq.getDate()!=null)
            expenses.setDate(addExpenseReq.getDate());

        expenses=expenseRepository.save(expenses);
        return expenses;
    }
    public Expenses editExpense(EditExpenseReq editExpenseReq){
        Expenses expenses = expenseRepository.findById(editExpenseReq.getId()).orElseThrow(() -> new IdNotFoundException("Id not found"));
        if(editExpenseReq.getAmount().compareTo(BigDecimal.ZERO) < 0) throw new InvalidAmountException("Invalid amount. Amount cannot be null");
        expenses.setAmount(editExpenseReq.getAmount());
        expenses.setDescription(editExpenseReq.getDescription());
        //expenses.setCategory(editExpenseReq.getCategory());
        expenses.setDate(editExpenseReq.getDate());
        expenseRepository.save(expenses);
        return expenses;
    }

    public Expenses getExpense(Long id){
        Expenses expenses = expenseRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Id not found"));
        return expenses;
    }

    public void deleteExpense(Long id) {
        if(!expenseRepository.existsById(id)) throw new IdNotFoundException("Id not found");
        expenseRepository.deleteById(id);
    }

    public List<Expenses> getAllExpense(){
        return expenseRepository.findAll();
    }
}
