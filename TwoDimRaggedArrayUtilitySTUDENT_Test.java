

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSet1 = {{2,3,4},{5,6},{7,8,9}};
	private double[][] dataSetSTUDENT = null;
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	
	@Test
	public void testGetTotal() {
		assertEquals(44.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);

	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(5.5,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(10.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(14.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,0),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet1, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}	
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(2, array[0][0],.001);
		assertEquals(3, array[0][1],.001);
		assertEquals(4, array[0][2],.001);
		assertEquals(5, array[1][0],.001);
		assertEquals(6, array[1][1],.001);
		assertEquals(7, array[2][0],.001);
		assertEquals(8, array[2][1],.001);
		assertEquals(9, array[2][2],.001);
		
	}

}
