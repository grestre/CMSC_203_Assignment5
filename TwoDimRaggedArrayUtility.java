
import java.io.*;
import java.util.*; 
public final class TwoDimRaggedArrayUtility {
	//Constructor
	public TwoDimRaggedArrayUtility(){
		
	}
	//Methods
	public static double getAverage(double[][] data) {
		double total = 0; 
		double elementNum = 0; 
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				total += data[row][col];							//Sums up all the elements in the arrays
				elementNum+=1; 										//Number of elements goes up by 1
			}
		}
		return total / elementNum; 									//Returns the average
	}
	public static double getColumnTotal(double[][] data, int col) {
		double columnTotal = 0; 
		for(int row = 0; row < data.length; row++) {
			if(data[row].length > col)							    //Goes through each column until the number of rows and columns are equals then it stops
				columnTotal += data[row][col]; 						//Total of the column
		}
		return columnTotal; 
	}
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0]; 								//Creates new 2 dimensional array		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] > highest)						//Finds the highest value in the array
					highest = data[row][col]; 						
			}
		}
		return highest; 
	}
	public static double getHighestInColumn(double[][] data, int col) {
		double maxCol = Double.MIN_VALUE; 							//maxCol equals MIN_VALUE from numeric wrapper class
		double maxRow = 0; 
		for(int row = 0; row < data.length; row++)					//Goes through each column until the number of rows and columns are equals then it stops				
			if(col < data[row].length && data[row][col] > maxCol)	//when the column is less than the rows length and when the maxCol is less than the value of the 2-dim array
				maxCol = data[row][col]; 
		return maxCol; 
	}
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int maxColIndex = 0; 
		for(int a = 0; a < data.length; a++) {						//'a' acts as the row. Loop goes through all the rows
			if(data[a].length > col)								//Goes through each column until the number of rows and columns are equals then it stops
				if(data[a][col] > data[maxColIndex][col])			//Finds the largest value for a column then finds the index. 
					maxColIndex = a; 								//Basically finds the row with the max column index. 
		}
		return maxColIndex; 
	}
	public static double getHighestInRow(double[][] data, int row) {
		double rowHighest = data[row][0];
		for(int col = 0; col < data[row].length; col++)				//Goes through the whole 2-Dim array 
			if(data[row][col] > rowHighest)							//Loops goes through if the 2-dim array is greater than rowHighest
				rowHighest = data[row][col]; 						
		return rowHighest; 
	}
	public static int getHighestInRowIndex(double[][] data, int row) {
		int maxRowIndex = 0; 
		for(int a = 0; a < data[row].length; a++)					//Opposite to getHighestInColumnIndex. 'a' acts as the column
			if(data[row][a] > data[row][maxRowIndex])
				maxRowIndex = a; 									//Finds the column with the max row index
		return maxRowIndex; 
	}
	public static double getLowestInArray(double[][] data) {
		double min = data[0][0]; 
		for(int row = 0; row < data.length; row++)
			for(int col = 0; col < data[row].length; col++)
				if(min > data[row][col])							//If min is greater than the lowest value in the array
					min  = data[row][col]; 							//min equals whatever that value is
		return min; 
	}
	public static double getLowestInColumn(double[][] data, int col) {
		double minCol = Double.MAX_VALUE; 							//MAX_VALUE from numeric wrapper class
		for(int row = 0; row < data.length; row++)					
			if(col < data[row].length && minCol > data[row][col])	//when the index of the column is less than the rows and when the minCol is greater than the value of the 2-dim array
				minCol = data[row][col];													 						
		return minCol; 
	}
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int minColIndex = 0;
		for(int row = 0; row < data.length; row++)
			if(col < data[row].length)
				if(data[minColIndex][col] > data[row][col])			//When the data array to find the minColIndex is greater than the 2-dim array
					minColIndex = row; 								//Finds the row with the smallest column index
		return minColIndex; 
	}
	public static double getLowestInRow(double[][] data, int row) {
		double minRow = data[row][0]; 								//minRow only goes through the row of the 2 dimensional array
		for(int col = 0; col < data[row].length; col++)
			if(minRow > data[row][col])								//If the minRow is greater than the row of the data array  
				minRow = data[row][col]; 							//then minRow equals that value of the row of the data array
		return minRow; 
	}
	public static int getLowestInRowIndex(double[][] data, int row) {
		int minRowIndex = 0; 
		for(int col = 0; col < data[row].length; col++)
			if(data[row][minRowIndex] > data[row][col])				//When the data array to find the minRowIndex is greater than the 2-dim array
				minRowIndex = col;  								//Finds the column with the smallest row index
		return minRowIndex; 
	}
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0; 
		for(int col = 0; col < data[row].length; col++)
			rowTotal += data[row][col]; 							//Total of the row
		return rowTotal; 
	}
	public static double getTotal(double[][] data) {
		double total = 0; 
		for(int row = 0; row < data.length; row++)
			for(int col = 0; col < data[row].length; col++)
				total += data[row][col]; 							//Total of the array
		return total; 
	}
	public static double[][] readFile(File file) throws FileNotFoundException{
		double[][] data = new double[7][0]; 
		String str; 
		int a = 0; 
		try {
			FileWriter fw = new FileWriter(file, true);
			Scanner inputFile = new Scanner(file); 
			PrintWriter outputFile = new PrintWriter(fw);
			while((str = inputFile.nextLine()) != null) {			//Read the first line from the file
				String[] s = str.split(" ");						//Tokenizing the string
				data[a] = new double[s.length];						//data array equals the length of the string
				for(int b = 0; b < s.length; b++) {					//int b goes until it reaches the last value of the string
					data[a][b] = Double.parseDouble(s[b]); 			//Turns the string to a double
				}
				a++; 
			}
			fw.close(); 											//closes the file
		} catch (Exception e) {
			
		} 
		return data; 
	}
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
			   PrintWriter outputFile1 = new PrintWriter(outputFile); 
			   for(int row = 0; row < data.length; row++) {
				   String str = ""; 
				   for(int col = 0; col < data[row].length; col++) { 
					   str += data[row][col] + " "; 
				   }
				   str += "\n"; 
				   outputFile1.print(str); 				  
			   }
			   outputFile1.close(); 			   		   
	}
}
