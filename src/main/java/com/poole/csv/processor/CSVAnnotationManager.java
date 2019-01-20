package com.poole.csv.processor;

import com.poole.csv.wrappers.Wrapper;

/**
 * This is a Manager class that holds the references of CSVColumn annotated
 * fields and methods. Validation further validation is handled elsewhere such
 * as CSVOrderProcessor and CSVNamedProcessor
 *
 */
@SuppressWarnings("rawtypes")
public class CSVAnnotationManager {
	private int order;
	private String header;
	private Holder holder;
	private Class parsedClazz;

	public CSVAnnotationManager(int order, String header, Holder holder, Class parsedClazz) {
		super();
		this.order = order;
		this.header = header;
		this.holder = holder;
		this.parsedClazz = parsedClazz;
	}

	public int getOrder() {
		return order;
	}

	public String getHeader() {
		return header;
	}

	public Holder getHolder() {
		return holder;
	}

	public Class getParsedClazz() {
		return parsedClazz;
	}

}