package com.poole.csv.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
public @interface CSVWriteComponent {

	CSVType type();
	boolean namedIsOrdered() default false;
	boolean inheritSuper() default false;
}