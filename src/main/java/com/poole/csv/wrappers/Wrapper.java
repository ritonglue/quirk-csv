package com.poole.csv.wrappers;

/**
 * Interface used to handle datatype transformations. You can find how this is
 * being used by looking at com.poole.csv.wrappers.defaults.DefaultWrappers to
 * see how the primitives are being handled.
 *
 *
 */
public interface Wrapper {
	/**
	 * Be sure to handle all exceptions. An java.lang.IllegalArgumentException
	 * can be thrown that will allow the process to continue.
	 *
	 * @param str
	 * @return an object after transforming
	 */
	Object apply(String str);
}
