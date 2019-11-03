import java.util.Arrays;
import java.util.List;


public class Checker {

    String[][] src_template = new String[][]{
            {"1", "I"},
            {"2", "II"},
            {"3", "III"},
            {"4", "IV"},
            {"5", "V"},
            {"6", "VI"},
            {"7", "VII"},
            {"8", "VIII"},
            {"9", "IX"},
            {"10", "X"}
    };

    List<String> operations = Arrays.asList("+", "-", "*", "/");


    int num_1 = 0;
    int num_2 = 0;

    public int[] Check(String entered_line) {

        String[] items = entered_line.split(" ");

        String item_0 = items[0];
        String item_1 = items[1];
        String item_2 = items[2];
        int index_of_item_0 = 0;
        int index_of_item_2 = 0;
        int operation_number = 0;

        Boolean flag_0 = false;
        Boolean flag_1 = false;

        int[] result = new int[4];

        if (items.length != 3) {
            throw new ArithmeticException("Invalid format of request. x + y Expects!");

        } else {

            for (int i = 0; i < src_template.length; i++) {

                List digits_complect = Arrays.asList(src_template[i]);

                if (digits_complect.contains(item_0)) {
                    flag_0 = true;

                    index_of_item_0 = digits_complect.indexOf(item_0);

                    if (index_of_item_0 == 0) {
                        num_1 = Integer.parseInt(items[0]);
                    } else if (index_of_item_0 == 1) {
                        num_1 = i + 1;
                    }

                }

                if (digits_complect.contains(item_2)) {
                    flag_1 = true;

                    index_of_item_2 = digits_complect.indexOf(item_2);

                    if (index_of_item_2 == 0) {
                        num_2 = Integer.parseInt(items[2]);
                    } else if (index_of_item_2 == 1) {
                        num_2 = i + 1;
                    }
                }

                if (operations.contains(item_1)){
                    operation_number = operations.indexOf(item_1);
                } else {
                    throw new ArithmeticException("Invalid type of Operation. Enter +,-,* or / !");
                }
            }

            if (!flag_0 || !flag_1){
                throw new ArithmeticException("Invalid type of Digits. Enter Arabic or Roman digits !");
            }

        }

        if (index_of_item_0 == 0 && index_of_item_2 == 0) {
            result[0] = num_1;
            result[1] = num_2;
            result[2] = 0;
            result[3] = operation_number;

        } else if (index_of_item_0 == 1 && index_of_item_2 == 1){
            result[0] = num_1;
            result[1] = num_2;
            result[2] = 1;
            result[3] = operation_number;
        } else {
            throw new ArithmeticException("Invalid type of Digits. Enter Arabic or Roman digits in both positions!");
        }

        return result;
    }
}