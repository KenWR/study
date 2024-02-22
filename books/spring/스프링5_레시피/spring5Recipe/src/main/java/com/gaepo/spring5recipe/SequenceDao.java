package com.gaepo.spring5recipe;

import com.gaepo.spring5recipe.Sequence;

// This is a DAO interface
public interface SequenceDao {
	// getSequence() is a method that find DB by sequenceId and return Sequence object
	public Sequence getSequence(String sequenceId);
	// getNextValue() is a method that find DB by sequenceId and return next Sequence value
	public int getNextValue(String sequenceId);
}
