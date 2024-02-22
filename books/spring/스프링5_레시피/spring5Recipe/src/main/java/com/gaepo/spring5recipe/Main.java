package com.gaepo.spring5recipe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.gaepo.spring5recipe.sequence.SequenceGenerator;
import com.gaepo.spring5recipe.sequence.config.SequenceGeneratorConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

public class Main {

	public static void main(String[] args) {
		// excute squence generator
//		// ApplicationContext is an interface need to be implemented
//		// AnnotationConfigApplicationContext is a class that implements ApplicationContext
//		ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
//
//		// SequenceGenerator is a bean
//		SequenceGenerator generator = context.getBean(SequenceGenerator.class);
//
//		// getSequence() is a method of SequenceGenerator
//		System.out.println(generator.getSequence());
//		System.out.println(generator.getSequence());

		ApplicationContext context =
				new AnnotationConfigApplicationContext(
						"com.gaepo.spring5recipe");

		SequenceDao sequenceDao = context.getBean(SequenceDao.class);

		System.out.println(sequenceDao.getNextValue("IT"));
		System.out.println(sequenceDao.getNextValue("IT"));
	}
}
