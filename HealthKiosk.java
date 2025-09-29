import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args){
        //TASK 1
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Ashesi Health Kiosk");
        System.out.println("SERVICES AVAILABLE (P-PHARMACY" +
                "/L-LAB" +
                "/T-TRIAGE" +
                "/C-COUNSELING) ");
        System.out.println("Please choose a service code (P/L/T/C): ");
        String userInput = input.next();
        char service_code = Character.toUpperCase(userInput.charAt(0));
        switch (service_code){
            case 'P':
                System.out.println("Go to : Pharmacy Desk");
                break;
            case 'L':
                System.out.println("Go to : Lab Desk");
                break;
            case 'T':
                System.out.println("Go to : Triage Desk");
                break;
            case 'C':
                System.out.println("Go to : Counselling Desk");
                break;
            default:
                System.out.println("Invalid service code");
                break;
        }

        //TASK 2(MINI HEALTH METRIC)
        System.out.println("Please choose a number to select health metric: (1 - for BMI" +
                "/ 2 - for DOSAGE" +
                "/ 3 - for TRIG HELPER)");
        int health_metric = input.nextInt();
        int final_health_metric = 0;
        double BMI = 0;
        double BMI_round = 0;
        if (health_metric==1){
            System.out.println("Please enter your weight in kg: ");
            double weight = input.nextDouble();
            System.out.println("Please enter your height in kg: ");
            double height = input.nextDouble();

             BMI = weight / (Math.pow(height,2));
             BMI_round = Math.round(BMI * 10)/10.0;

            System.out.print("BMI: "+ BMI_round + " " );
            if (BMI_round < 18.5){
                System.out.println("CATEGORY: Underweight");
            }
            else if (BMI_round < 25.0){
                System.out.println("CATEGORY: Normal");
            }
            else if (BMI_round < 30.0) {
                System.out.println("CATEGORY: Overweight");
            }
            else {
                    System.out.println("CATEGORY: Obese");
            }
            final_health_metric = (int)Math.round(BMI_round);
        }
        else if (health_metric==2){
                System.out.println("Please enter the required dosage in mg: ");
                double required_dosage = input.nextDouble();
                int No_OfTablets = (int)Math.ceil(required_dosage/250.0);
                final_health_metric = No_OfTablets;
        }
        else if (health_metric==3){
                System.out.println("Please enter angle in degrees: ");
                double angle = input.nextDouble();
                double angle_radians = Math.toRadians(angle);
                double angle_radians_sin = Math.round(Math.sin(angle_radians)* 1000)/1000.0;
                double angle_radians_cos = Math.round(Math.cos(angle_radians)* 1000)/1000.0;
                System.out.print("Angle in radians= "+ angle_radians);
                System.out.print("Sin of "+angle_radians+ "="+ angle_radians_sin);
                System.out.print("Cos of "+angle_radians+ "="+ angle_radians_cos);
                final_health_metric = (int)Math.round(Math.sin(angle_radians)* 100);
        }
        else {
            System.out.println("Invalid health metric");
        }
      //TASK 3 ID SANITY CHECK
        System.out.println("ID SANITY CHECK");
        char random_ID_letter = (char)('A' + (int)(Math.random() * 26));
        int random_ID_number1= 3 + (int)(Math.random() * 7);
        int random_ID_number2= 3 + (int)(Math.random() * 7);
        int random_ID_number3= 3 + (int)(Math.random() * 7);
        int random_ID_number4= 3 + (int)(Math.random() * 7);
        String ID = random_ID_letter + ""
                +random_ID_number1
                + random_ID_number2
                + random_ID_number3
                + random_ID_number4;
        System.out.println("ID: "+ ID);

        if (ID.length() == 5
                && Character.isLetter(ID.charAt(0))
                && Character.isDigit(ID.charAt(1))
                && Character.isDigit(ID.charAt(2))
                && Character.isDigit(ID.charAt(3))
                && Character.isDigit(ID.charAt(4))){
            System.out.println("ID OK");
        }
        else {
            System.out.println("INVALID ID");
        }

        //TASK 4 SECURE DISPLAY CODE
        System.out.println("Please enter your first name: ");
        String name = input.next();
        char firstLetter = Character.toUpperCase(name.charAt(0));
        System.out.println(firstLetter);
        char letterShift = (char)('A'+ (firstLetter - 'A'+ 2)%26);
        System.out.println(letterShift);
        String lastLetters = ID.substring(ID.length()-2);
        System.out.println(lastLetters);
        String code = letterShift + lastLetters + " - " + final_health_metric;
        System.out.println("CODE - "+ code);

        //TASK 5 SERVICE SUMMARY
        String summary;
        switch (service_code) {
            case 'P':
                summary = "PHARMACY | ID = " + ID + "| Code = " + code;
                break;
            case 'L':
                summary = "LAB | ID = " + ID + "| Code = " + code;
                break;
            case 'T':
                summary = "TRIAGE | ID = " + ID + "| BMI = " + BMI_round + "| Code = " + code;
                break;
            case 'C':
                summary = "COUNSELING | ID = " + ID + "| Code = " + code;
                break;
            default:
                summary = " NO AVAILABLE SERVICE | ID = " + ID + "| Code = " + code;
        }
        System.out.println("Summary : " + summary);






    }
}
