import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true){

            Checker checking = new Checker();
            Operation operation = new Operation();
            String entered_line = sc.nextLine();
            int[] checked_values = checking.Check(entered_line);
            String calculation_result = operation.calculate(checked_values);

            System.out.println("Result = " + calculation_result);
        }
    }
}
