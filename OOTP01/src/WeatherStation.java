import java.util.Scanner;
import java.util.Arrays;

public class WeatherStation {
    static double[][][] temperatures = new double[10][12][31];
    static boolean[][] check = new boolean[10][12];
    
    private static boolean validDate(int year, int month) {
    	if(year < 2011 || year > 2020) {
    		System.out.println("Invalid year. Try a year between 2011 and 2020");
    		return false;
    	}
    	if(month < 1 || month > 12) {
    		System.out.println("Invalid month. Try one value between 1 (January) and 12 (December)");
    		return false;
    	}
    	return true;
    }
    	
    
    private static int getMaxDay(int year, int month) {
    	int days = 0;

        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10|| month == 12) {
           days = 31;
    	}else if (month == 4 || month == 6 || month == 9 || month == 11) {
                days = 30;
    	} else if (month == 2) {
			if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
		        days = 29;
		    }else { 
		    	days = 28;
		    }
        }
        return days;
    }
    
    private static double getMean(double[] data){
        double sum = 0;
        for(int i = 0; i < data.length; sum += data[i++]);
        return sum/(data.length);
    }
    
    private static double getMin(double[] data){
        double minValue = data[0];
        for(int i = 0; i < data.length; i++){
            if(data[i] < minValue) minValue = data[i];
        }
        return minValue;
    }
    
    private static double getMax(double[] data){
        double maxValue = data[0];
        for(int i = 0; i < data.length; i++){
            if(data[i] > maxValue) maxValue = data[i];
        }
        return maxValue;
    }
    
    public static void addMonthTemperatures(int month, int year, double[] temps){
        int yearIdx = year - 2011;  
        month--;
        int maxDays = getMaxDay(year, month);

        for(int i = 0; i < temps.length; i++){
        	temperatures[yearIdx][month][i] = temps[i];
        }
        check[yearIdx][month] = true;
    }
    
    public static void getTemperatureMean(int month, int year){
        double[] data = new double[getMaxDay(year, month)];
        int yearIdx = year - 2011;
        month--;
		for(int i = 0; i < data.length; i++){
			data[i] = temperatures[yearIdx][month][i];
		}
		double meanValue = getMean(data);
        
        System.out.printf("Temperature Average  (%d/%d): %.2f\n", month+1, year, meanValue);
    }

    public static void getTemperatureMin(int month, int year){
        double[] data = new double[getMaxDay(year, month)];
        int yearIdx = year - 2011;
        month--;
		for(int i = 0; i < data.length; i++){
			data[i] = temperatures[yearIdx][month][i];
		}
		double minValue = getMin(data);
        
        System.out.printf("Minimum Temperature for this month (%d/%d): %.2f\n", month+1, year, minValue);
    }

    public static void getTemperatureMax(int month, int year){
        double[] data = new double[getMaxDay(year, month)];
        int yearIdx = year - 2011;
        month--;
		for(int i = 0; i < data.length; i++){
			data[i] = temperatures[yearIdx][month][i];
		}

        double maxValue = getMax(data);
        System.out.printf("Maximum Temperature for this month (%d/%d): %.2f\n", month, year, maxValue);
    }
    
    public static void getMonthReport(int month, int year){
        int yearIdx = year - 2011;
        for(int i = 0; i < getMaxDay(year, month); i++){
            System.out.println("Day " + (i+1) + ": " + temperatures[yearIdx][month - 1][i]);
        }

        getTemperatureMean(month, year);
        getTemperatureMin(month, year);
        getTemperatureMax(month, year);
    }
	public static void main(String[] args) {
		int input = -1, month, year; 
		double[] monthData = new double[31];
		double[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		int maxDay = 0;
		Scanner scanf = new Scanner(System.in).useDelimiter("\n");
		String[] inputStr;
		
		addMonthTemperatures(1, 2020, Arrays.stream(test).toArray()) ;
		getMonthReport(1, 2020);
		do{
			System.out.println("Choose what you want to do: ");
			System.out.println("1 - Add data");
			System.out.println("2 - Get mean");
			System.out.println("3 - Get minimum value");
			System.out.println("4 - Get maximum value");
			System.out.println("5 - Get monthly report");
			System.out.println("0 - Exit");
			
			try{
				input = scanf.nextInt();
			}catch(java.util.InputMismatchException ex) {
				System.out.println("You should have typed something. Rebooting...");
				continue;
			}
			
			if(input > 0 && input <= 5) {
				System.out.println("Type the month (1 - Jan, 2 - Feb, ..., 12 - Dec):");
				try {
					month = scanf.nextInt();
				}catch(java.util.InputMismatchException ex) {
					System.out.println("You should have typed something. Rebooting...");
					System.out.println("You should have typed something. Rebooting...");
					continue;
				}
				
				System.out.println("Type the year (yyyy - 2004, 2005, ... 2019, 2020):");
				try{
					year = scanf.nextInt();
				}catch(java.util.InputMismatchException ex) {
					System.out.println("You should have typed something. Rebooting...");
					continue;
				}
				validDate(year, month);

				switch(input) {
					case 1:
						maxDay = getMaxDay(year, month);
						
						System.out.println("Number of days in this month:" + maxDay);
						System.out.println("Type the data (separed by spaces):");
						try {
							inputStr = scanf.next().split(" "); 
						}catch(java.util.InputMismatchException ex) {
							System.out.println("You should have typed something. Rebooting...");
							continue;
						}
						if(inputStr.length != maxDay){
							System.out.println("Wrong number of days. Try again with the temperature for each day of this month.");
							break;
						}
						
						for(int i = 0; i < inputStr.length; i++) {
							monthData[i] = Double.parseDouble(inputStr[i]);
							System.out.println("Month Data(" + month + "/" + year + "): " + monthData[i]);
						}
						addMonthTemperatures(month, year, monthData);
						System.out.println("Temperatures successfully added!");
						break;
					case 2:
						if(!check[year - 2011][month - 1]) {
							System.out.println("There is nothing for this month.");
							continue;
						}
						getTemperatureMean(month, year);
						break;
					case 3:
						if(!check[year - 2011][month - 1]) {
							System.out.println("There is nothing for this month.");
							continue;
						}
						getTemperatureMin(month, year);
						break;
					case 4:
						if(!check[year - 2011][month - 1]) {
							System.out.println("There is nothing for this month.");
							continue;
						}
						getTemperatureMax(month, year);
						break;
					case 5:
						if(!check[year - 2011][month - 1]) {
							System.out.println("There is nothing for this month.");
							continue;
						}
						getMonthReport(month, year);
						break;
				}
				System.out.println("Return to the main menu");
			}else if(input == 0) {
				System.out.println("Finishing the program. Good bye =)");
				break;
			}
			else {
				System.out.println("Invalid option, try again.");
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(input != 0);
		scanf.close();
			

	}

}
