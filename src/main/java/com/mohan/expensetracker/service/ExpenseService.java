package com.mohan.expensetracker.service;

import com.mohan.expensetracker.dto.request.AddExpenseReq;
import com.mohan.expensetracker.dto.request.EditExpenseReq;
import com.mohan.expensetracker.dto.response.ExpenseResponse;
import com.mohan.expensetracker.entity.Expenses;
import com.mohan.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
    public Optional<Expenses> editExpense(EditExpenseReq editExpenseReq) throws Exception {
        Expenses expenses = expenseRepository.findById(editExpenseReq.getId()).orElseThrow();
        if(editExpenseReq.getAmount() == null) throw new Exception("Invalid amount");
        expenses.setAmount(editExpenseReq.getAmount());

        expenses.setDescription(editExpenseReq.getDescription());
        expenses.setCategory(editExpenseReq.getCategory());
        expenses.setDate(editExpenseReq.getDate());
        expenseRepository.save(expenses);
        return Optional.of(expenses);
    }
    public Optional<Expenses> getExpense(Long id) throws Exception{
        Expenses expenses = expenseRepository.findById(id).orElseThrow();
        return Optional.of(expenses);
    }
    public void deleteExpense(Long id) throws Exception{
        if(!expenseRepository.existsById(id)) throw new Exception("Invalid Id");
        expenseRepository.deleteById(id);
    }
    public List<Expenses> getAllExpense(){
        return expenseRepository.findAll();
    }
}
