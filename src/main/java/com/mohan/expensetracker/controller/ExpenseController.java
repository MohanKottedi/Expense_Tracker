package com.mohan.expensetracker.controller;

import com.mohan.expensetracker.dto.request.AddExpenseReq;
import com.mohan.expensetracker.dto.request.EditExpenseReq;
import com.mohan.expensetracker.dto.response.ExpenseResponse;
import com.mohan.expensetracker.entity.Expenses;
import com.mohan.expensetracker.service.ExpenseService;
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
    public ResponseEntity<Expenses> addExpense(@RequestBody AddExpenseReq addExpenseReq){
        Optional<Expenses> result = expenseService.addExpense(addExpenseReq);
        return ResponseEntity.ok(result.orElse(null));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Expenses> getExpense(@PathVariable  Long id) throws Exception {
        Optional<Expenses> result = expenseService.getExpense(id);
        return ResponseEntity.ok(result.get());
    }
    @GetMapping("/")
    public ResponseEntity<List<Expenses>> getAllExpense() throws Exception {
        List<Expenses> result = expenseService.getAllExpense();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/edit")
    public ResponseEntity<Expenses> editExpense(@RequestBody EditExpenseReq editExpenseReq) throws Exception {
        Optional<Expenses> result = expenseService.editExpense(editExpenseReq);

        return ResponseEntity.ok(result.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) throws Exception {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok(null);
    }
}
