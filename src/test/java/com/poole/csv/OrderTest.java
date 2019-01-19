package com.poole.csv;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.poole.csv.annotation.CSVColumn;
import com.poole.csv.annotation.CSVComponent;
import com.poole.csv.annotation.CSVReaderType;
import com.poole.csv.exception.UninstantiableException;
import com.poole.csv.processor.CSVProcessor;

public class OrderTest {
	// Test when a record goes out of bounds
	// Test when a non-nullable is null
	// Test to make sure a nullable can be nulled
	// Test when two fields hold the same order
	// Test when two methods hold the same order
	// Test when a field and a method hold the same order
	// Test when a complex datatype is used instead of primitives and their
	// wrappers
	//
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test()
	public void outOfBoundsNumberFormatExTest() throws IOException {

		CSVProcessor p = new CSVProcessor();
		List<O1> o1s = p.parse(new StringReader("a,j"), O1.class);
		System.out.println(errContent.toString());
		O1 o1 = new O1();
		o1.s = "a";
		o1.j = 0;
		assertTrue(o1.equals(o1s.get(0)));
	}

	@Test(expected = UninstantiableException.class)
	public void UninstantiableExTest() throws IOException {

		CSVProcessor p = new CSVProcessor();
		List<O2> o1 = p.parse(new StringReader("a,j"), O2.class);

	}

	@CSVComponent(type = CSVReaderType.ORDER)
	public static class O1 {

		@CSVColumn(order = 0)
		String s;
		@CSVColumn(order = 3)
		int i;
		int j;

		@CSVColumn(order = 1)
		public void setJ(int j) {
			this.j = j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			result = prime * result + ((s == null) ? 0 : s.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			O1 other = (O1) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			if (s == null) {
				if (other.s != null)
					return false;
			} else if (!s.equals(other.s))
				return false;
			return true;
		}

	}

	@CSVComponent(type = CSVReaderType.ORDER)
	private static class O2 {
		@CSVColumn(order = 0)
		String s;
		@CSVColumn(order = 1, isNullable = false)
		Integer i;
	}

	@CSVComponent(type = CSVReaderType.ORDER)
	private static class O3 {
		@CSVColumn(order = 0)
		String s;
		@CSVColumn(order = 1, isNullable = false)
		Integer i;
	}
}
