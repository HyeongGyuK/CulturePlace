package com.culture.controller.Member;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

public class ValidationGroups {
	 public interface NotEmptyGroup {};
    public interface PatternCheckGroup {};


@GroupSequence({Default.class, NotEmptyGroup.class, PatternCheckGroup.class })
public interface ValidationSequence {
}
}