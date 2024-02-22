package com.gaepo.spring5recipe.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gaepo.spring5recipe.sequence.SequenceGenerator;

@Configuration	// This annotation tells Spring that this class is a configuration class
public class SequenceGeneratorConfiguration {

	@Bean	// This annotation make same name method as a bean
			// If you want to change the name of the bean, you can use @Bean("name")
	public SequenceGenerator sequenceGenerator() { // This method is a bean definition method
		SequenceGenerator seqgen = new SequenceGenerator();
		seqgen.setPrefix("30");
		seqgen.setSuffix("A");
		seqgen.setInitial(100000);
		return seqgen;
	}
}
