package com.example.demo.examples;

import org.springframework.stereotype.Service;

//@Component
@Service
//@Repository
public class EmployeeService {

    public void save() {
        System.out.println("Saving employee...");
    }

    public void delete() {
        System.out.println("Deleting employee...");
    }
}
