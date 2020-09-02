package org.denclinic.denclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import yedek.SomeController;

@SpringBootApplication
public class DenClinicApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DenClinicApplication.class, args);

		SomeController someController=(SomeController) ctx.getBean("someController");
		System.out.println(someController.sayHello());
	}

}
