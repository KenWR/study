package com.gaepo.spring5recipe;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;
import java.util.Map;

// This class is domain class
// For apply DAO pattern to SequenceGenerator,
// you need to create a new class that has a method to access the database
public class Sequence {

	private final String id;
	private final String prefix;
	private final String suffix;

	public Sequence(String id, String prefix, String suffix) {
		this.id = id;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public String getId() {
		return id;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

}
