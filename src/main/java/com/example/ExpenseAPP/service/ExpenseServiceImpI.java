package com.example.ExpenseAPP.service;

import com.example.ExpenseAPP.model.Expense;
import com.example.ExpenseAPP.repository.InMemoryExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpI implements ExpenseService {

    @Autowired
    private InMemoryExpenseRepository repository;

    @Override
    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public Optional<Expense> getExpenseById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        return repository.update(id, expense);
    }

    @Override
    public boolean deleteExpense(Long id) {
        return repository.delete(id);
    }

    @Override
    public List<Expense> getExpensesByCategory(String category) {
        return repository.findByCategory(category);
    }
}
