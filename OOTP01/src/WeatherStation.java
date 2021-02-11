import java.util.Scanner;

public class WeatherStation {
    static double[][][] temperatures = new double[10][12][31];
    
    private static double getMean(double[] data){
        double sum = 0;
        for(int i = 0; i < data.length; sum += data[i++]);
        return sum/(data.length);
    }
    
    private static double getMin(double[] data){
        double minValue = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] < minValue) minValue = data[i];
        }
        return minValue;
    }
    
    private static double getMax(double[] data){
        double maxValue = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] > maxValue) maxValue = data[i];
        }
        return maxValue;
    }
    
    public static void addMonthTemperatures(int month, int year, double[] temps){
        int yearIdx = year - 2011;  
        for(int i = 0; i < temperatures.length; i++){
        	temperatures[yearIdx][month][i] = temps[i];
        }
    }
    
    public static void getTemperatureMean(int month, int year){
        int yearIdx = year - 2011;
        double mean = getMean(temperatures[yearIdx][month]);
        
        System.out.printf("Temperature Average (%d/%d): " + mean);
    }

    public static void getTemperatureMin(int month, int year){
        int yearIdx = year - 2011;
        double minValue = getMin(temperatures[yearIdx][month]);
        
        System.out.printf("Minimum Temperature for this month (%d/%d): " + minValue);
    }

    public static void getTemperatureMax(int month, int year){
        int yearIdx = year - 2011;
        double maxValue = getMax(temperatures[yearIdx][month]);
        
        System.out.printf("Maximum Temperature for this month (%d/%d): " + maxValue);
    }
    
    public static void getMonthReport(int month, int year){
        int yearIdx = year - 2011;
        for(int i = 0; i < 30; i++){
            System.out.println("Day " + (i+1) + ": " + temperatures[yearIdx][month][i++]);
        }
        
        getTemperatureMean(year, month);
        getTemperatureMin(year, month);
        getTemperatureMax(year, month);
    }
	public static void main(String[] args) {
		int input = -1, month, year; 
		Scanner scanf = new Scanner(System.in);
		double[] monthData = new double[31];
		do{
			System.out.println("Choose what you want to do: ");
			System.out.println("1 - Add data");
			System.out.println("2 - Get mean");
			System.out.println("3 - Get minimum value");
			System.out.println("4 - Get maximum value");
			System.out.println("5 - Get monthly report");
			System.out.println("0 - Exit");
			
			input = scanf.nextInt();
			switch(input) {
				case '0':
					System.out.println("Finishing the program. Good bye =)");
					break;
				case 1:
					System.out.println("Type the month (1 - Jan, 2 - Feb, ..., 12 - Dec):");
					month = scanf.nextInt();
					System.out.println("Type the year (yyyy - 2004, 2005, ... 2019, 2020):");
					year = scanf.nextInt();
					System.out.println("Type the data (separed by spaces):");

					String inputStr = "";
					for(int i = 0; i < monthData.length && scanf.hasNextDouble(); i++) {
						monthData[i] = scanf.nextDouble();					
						System.out.println("Month Data(" + month + "/" + year + "): " + monthData[i]);
					}
					addMonthTemperatures(month, year, monthData);
					System.out.println("Temperatures successfully added!");
					break;
				case 2:
					System.out.println("Type the month (1 - Jan, 2 - Feb, ..., 12 - Dec):");
					month = scanf.nextInt();
					System.out.println("Type the year (yyyy - 2004, 2005, ... 2019, 2020):");
					year = scanf.nextInt();
					getTemperatureMean(month, year);
					break;
				case 3:
					System.out.println("Type the month (1 - Jan, 2 - Feb, ..., 12 - Dec):");
					month = scanf.nextInt();
					System.out.println("Type the year (yyyy - 2004, 2005, ... 2019, 2020):");
					year = scanf.nextInt();
					getTemperatureMin(month, year);
					break;
				case 4:
					System.out.println("Type the month (1 - Jan, 2 - Feb, ..., 12 - Dec):");
					month = scanf.nextInt();
					System.out.println("Type the year (yyyy - 2004, 2005, ... 2019, 2020):");
					year = scanf.nextInt();
					getTemperatureMax(month, year);
					break;
				case 5:
					System.out.println("Type the month (1 - Jan, 2 - Feb, ..., 12 - Dec):");
					month = scanf.nextInt();
					System.out.println("Type the year (yyyy - 2004, 2005, ... 2019, 2020):");
					year = scanf.nextInt();
					getMonthReport(month, year);
					break;
				default:
					System.out.println("Invalid option, try again.");			
			}
			System.out.println("Return to the main menu");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(input != 0);
			
			

	}

}
