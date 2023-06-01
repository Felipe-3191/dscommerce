package com.devsuperior.services;

import com.devsuperior.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private TaxService taxService;
    @Autowired
    private PensionService pensionService;


    /* Dependencias podem ser injetadas automaticamente via construtor ou via anotação @autowired
    public SalaryService (TaxService taxService, PensionService pensionService) {
        this.taxService = taxService;
        this.pensionService = pensionService;
    }
*/
    public double netSalary(Employee employee) {
        double grossSalary = employee.getGrossSalary();
        return employee.getGrossSalary() - this.pensionService.discount(grossSalary) - this.taxService.tax(grossSalary);
    }
}
