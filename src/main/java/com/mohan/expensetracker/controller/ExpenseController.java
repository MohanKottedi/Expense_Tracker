package com.mohan.expensetracker.controller;

import com.mohan.expensetracker.dto.request.AddExpenseReq;
import com.mohan.expensetracker.dto.request.EditExpenseReq;
import com.mohan.expensetracker.dto.response.ExpenseResponse;
import com.mohan.expensetracker.entity.Expenses;
import com.mohan.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/add")
    public ResponseEntity<Expenses> addExpense(@Valid @RequestBody AddExpenseReq addExpenseReq){
        Expenses result = expenseService.addExpense(addExpenseReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Expenses> getExpense(@PathVariable  Long id){
        Expenses result = expenseService.getExpense(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(result);
    }

    @GetMapping("/")
    public ResponseEntity<List<Expenses>> getAllExpense() {
        List<Expenses> result = expenseService.getAllExpense();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/edit")
    public ResponseEntity<Expenses> editExpense(@Valid @RequestBody EditExpenseReq editExpenseReq){
        Expenses result = expenseService.editExpense(editExpenseReq);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
