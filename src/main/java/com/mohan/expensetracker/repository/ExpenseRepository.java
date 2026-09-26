package com.mohan.expensetracker.repository;

import com.mohan.expensetracker.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses,Long> {

}
