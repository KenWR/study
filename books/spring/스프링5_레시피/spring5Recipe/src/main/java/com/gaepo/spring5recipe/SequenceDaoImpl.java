package com.gaepo.spring5recipe;

import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

// Create POJO class
// Component annotation tells Spring that this class is a bean
// If you want to change the name of the bean, you can use @Component("name")
// So bean name is "sequenceDao"
// Using @Repository, @Service, @Controller ... is better than using @Component
// ex) @Repository("sequenceDao") is throwing more specific exception than @Component("sequenceDao")
// so it has profit to debug
@Component("sequenceDao")
public class SequenceDaoImpl implements SequenceDao {

	private final Map<String, Sequence> sequences = new HashMap<>();
	private final Map<String, AtomicInteger> values = new HashMap<>();

	// Actually, data access logic should be implemented here
	// But for simplicity, I just put some data here with hard coding with hash map
	public SequenceDaoImpl() {
		sequences.put("IT", new Sequence("IT", "30", "A"));
		values.put("IT", new AtomicInteger(10000));
	}

	@Override
	public Sequence getSequence(String sequenceId) {
		return sequences.get(sequenceId);
	}

	@Override
	public int getNextValue(String sequenceId) {
		AtomicInteger value = values.get(sequenceId);
		return value.getAndIncrement();
	}
}
