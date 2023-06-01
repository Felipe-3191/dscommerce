package com.devsuperior.aula;

import com.devsuperior.entities.Employee;
import com.devsuperior.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.devsuperior"}) /*
	necessário utilizar pois foi definido que pacote base seria aula e criamos os outros pacotes
	fora do pacote base, portanto o Spring se perde onde fazer o scan para gerar os beans
*/



public class AulaApplication implements CommandLineRunner {


	private SalaryService salaryService;

	public AulaApplication(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setName("Maria");
		employee.setGrossSalary(4000.00);
		System.out.println(salaryService.netSalary(employee));

	}


}
