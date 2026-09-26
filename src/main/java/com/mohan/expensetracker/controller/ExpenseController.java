package com.mohan.expensetracker.controller;

import com.mohan.expensetracker.dto.request.AddExpenseReq;
import com.mohan.expensetracker.dto.request.EditExpenseReq;
import com.mohan.expensetracker.dto.response.ExpenseResponse;
import com.mohan.expensetracker.entity.Expenses;
import com.mohan.expensetracker.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @PostMapping("/add")
    public ResponseEntity<Expenses> addExpense(@RequestBody AddExpenseReq addExpenseReq){
        Optional<Expenses> result = expenseService.addExpense(addExpenseReq);
        return ResponseEntity.ok(result.orElse(null));
    }
    @GetMapping("/get")
    public ResponseEntity<ExpenseResponse> getExpense(){
        return ResponseEntity.ok(null);
    }
    @GetMapping("/view")
    public ResponseEntity<ExpenseResponse> viewExpense(){
        return ResponseEntity.ok(null);
    }
    @PostMapping("/edit")
    public ResponseEntity<ExpenseResponse> editExpense(@RequestBody EditExpenseReq editExpenseReq){
        return ResponseEntity.ok(null);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<ExpenseResponse> deleteExpense(@PathVariable Long id){
        return ResponseEntity.ok(null);
    }
}
