package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class EmployeeController {
   private final EmployeeService employeeService;
   private final DepartmentService departmentService;

    @GetMapping("/")
    public String listEmployees(Model model,
                                @RequestParam(name = "page", defaultValue = "1",required = false) int page) {
        Page<Employee> employeePage = employeeService.getAll(PageRequest.of(page-1, 5));
        model.addAttribute("employee", employeePage);
        return "employee";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.findAll());
        return "add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(Model model , @PathVariable Long id) {
        model.addAttribute("employee", employeeService.getById(id));
        model.addAttribute("departments", departmentService.findAll());
        return "add-employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee( @PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/";
    }
}
