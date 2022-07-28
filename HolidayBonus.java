
public class HolidayBonus {
	
	//Constructor
	HolidayBonus(){
		
	}
	//Methods
	/**
	 * 
	 * @param data: 2-Dim array of store sales
	 * @param high: Bonus for store with the highest sales 
	 * @param low: Bonus for store with the lowest sales
	 * @param other: Bonus for the other stores
	 * @return array of doubles which represent holiday bonus for each store in the district
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) { 		//Calculates the holiday bonus for each store
		double[] holidayBonus = new double[data.length]; 		
		double max; 
		double min;  
		try {
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {													//Loop goes through the rows and columns
				max = TwoDimRaggedArrayUtility.getHighestInColumn(data, col); 									//Assign max to the max value in the column
				min = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);									//Assign min to the min value in the column
				if(data[row][col] > 0) {																		//Makes sure the array has values
				if(data[row][col] == max)																		//if the array equals max
					holidayBonus[row] = holidayBonus[row] + high; 												//Then it adds the bonus of high
				else if(data[row][col] == min)
					holidayBonus[row] = holidayBonus[row] + low;												//Adds the bonus of low
				else
					holidayBonus[row] = holidayBonus[row] + other; 												//Adds the bonus of other
				}
			}
		}
		}catch(Exception e) {
			
		}
		return holidayBonus; 
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {   //Calculates the total holiday bonuses
	double total = 0; 
	double[] holidayBonus = new double[data.length];
	double[][] bonus = new double[7][0];
	double totalBonus = 0;
	double max; 
	double min;  
	try {
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {													//Loop goes through the rows and columns
				max = TwoDimRaggedArrayUtility.getHighestInColumn(data, col); 									//Assign max to the max value in the column
				min = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);									//Assign min to the min value in the column
				if(data[row][col] > 0) {																		//Makes sure the array has values
				if(data[row][col] == max)																		//if the array equals max
					holidayBonus[row] = holidayBonus[row] + high; 												//Then it adds the bonus of high
				else if(data[row][col] == min)
					holidayBonus[row] = holidayBonus[row] + low;												//Adds the bonus of low
				else
					holidayBonus[row] = holidayBonus[row] + other; 												//Adds the bonus of other
				}
			}
		}
		}catch(Exception e) {
	}
	for(int col = 0; col < bonus.length; col++) {
		total = 0; 
		for(int row = 0; row < bonus[col].length; row++) {														//Loop goes through the rows and columns
			total += bonus[row][col]; 																		
		}
		totalBonus += holidayBonus[col]; 																		//Adds the bonus of the total column
	}
	return totalBonus;
	}	
}