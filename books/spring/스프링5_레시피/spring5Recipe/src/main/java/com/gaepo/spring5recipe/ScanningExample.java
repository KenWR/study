package com.gaepo.spring5recipe;

import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan;

// Include all classes that end with Service or Dao
// Exclude all classes that are annotated with @Controller
@ComponentScan(
		includeFilters = {
				@ComponentScan.Filter(
						// REGEX: Regular Expression
						type = FilterType.REGEX,
						pattern = {"com.gaepo.spring5recipe.*Service",
								"com.gaepo.spring5recipe.*Dao"})
		},
		excludeFilters = {
				@ComponentScan.Filter(
						// ANNOTATION: Annotation
						type = FilterType.ANNOTATION,
						classes = {org.springframework.stereotype.Controller.class})
		}
)
public class ScanningExample {
}

