package com.example.ExpenseAPP.service;

import com.example.ExpenseAPP.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    Expense createExpense(Expense expense);

    List<Expense> getAllExpenses();

    Optional<Expense> getExpenseById(Long id);

    Expense updateExpense(Long id, Expense expense);

    boolean deleteExpense(Long id);

    List<Expense> getExpensesByCategory(String category);
}
