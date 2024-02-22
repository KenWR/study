package com.gaepo.spring5recipe.sequence;


import java.util.concurrent.atomic.AtomicInteger;

// This class is a simple POJO
public class SequenceGenerator {
	private String prefix;
	private String suffix;
	private int initial;
	private final AtomicInteger counter = new AtomicInteger();

	public SequenceGenerator() {
	}

	public SequenceGenerator(String prefix, String suffix, int initial) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.initial = initial;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public String getSequence() {
		StringBuilder builder = new StringBuilder();
		builder.append(prefix)
			.append(initial)
			.append(counter.getAndIncrement())
			.append(suffix);
		return builder.toString();
	}
}
