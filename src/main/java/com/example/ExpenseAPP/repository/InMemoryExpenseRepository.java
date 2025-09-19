package com.example.ExpenseAPP.repository;

import com.example.ExpenseAPP.model.Expense;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryExpenseRepository {

    private Map<Long, Expense> expenseMap = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();

    // Save a new expense
    public Expense save(Expense expense) {
        Long id = idCounter.incrementAndGet();
        expense.setId(id);
        expenseMap.put(id, expense);
        return expense;
    }

    // Find all expenses
    public List<Expense> findAll() {
        return new ArrayList<>(expenseMap.values());
    }

    // Find expense by ID
    public Optional<Expense> findById(Long id) {
        return Optional.ofNullable(expenseMap.get(id));
    }

    // Update expense
    public Expense update(Long id, Expense expense) {
        if(expenseMap.containsKey(id)) {
            expense.setId(id);
            expenseMap.put(id, expense);
            return expense;
        }
        return null; // Not found
    }

    // Delete expense
    public boolean delete(Long id) {
        return expenseMap.remove(id) != null;
    }

    // Find expenses by category
    public List<Expense> findByCategory(String category) {
        List<Expense> result = new ArrayList<>();
        for (Expense expense : expenseMap.values()) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                result.add(expense);
            }
        }
        return result;
    }
}
