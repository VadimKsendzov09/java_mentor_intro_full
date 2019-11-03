import java.util.HashMap;
import java.util.Map;


public class RomeResult {
    public String convertToRomeValue(int value){

        String result = "";

        Map<Integer, String> arabRome = new HashMap<Integer, String>();
        arabRome.put(1, new String("I"));
        arabRome.put(4, new String("IV"));
        arabRome.put(5, new String("V"));
        arabRome.put(9, new String("IX"));
        arabRome.put(10, new String("X"));
        arabRome.put(40, new String("XL"));
        arabRome.put(50, new String("L"));
        arabRome.put(90, new String("XC"));
        arabRome.put(100, new String("C"));

        if (value < 10){
            result = from_0_to_9(value, arabRome);
        } else if(value >=10 && value < 40){
            result = from_10_to_39(value, arabRome);
        } else if(value >=40 && value < 50){
            result = from_40_to_49(value, arabRome);
        } else if(value >=50 && value < 90){
            result = from_50_to_89(value, arabRome);
        } else if(value >=90 && value < 100){
            result = from_90_to_99(value, arabRome);
        } else if(value == 100){
            result = "C";
        }

        return result;
    }

    private String from_0_to_9(int r, Map<Integer, String> arabRome){

        String r_result = "";

        if (r >= 1 && r < 4){
            for (Map.Entry<Integer, String> entry : arabRome.entrySet()){
                if (entry.getKey() == r){
                    r_result = entry.getValue();
                } else {

                    String str = "";
                    for(int o = 0; o < r; o++){
                        str += "I";
                    }
                    r_result = str;
                }
            }
        } else if(r == 4){
            for (Map.Entry<Integer, String> entry : arabRome.entrySet()) {
                if (entry.getKey() == r) {
                    r_result = entry.getValue();
                }
            }
        } else if (r >= 5 && r < 9) {
            for (Map.Entry<Integer, String> entry : arabRome.entrySet()) {
                if (entry.getKey() == r) {
                    r_result = entry.getValue();
                } else {
                    String str = "";
                    String strV = "V";
                    for (int o = 0; o < r - 5; o++) {
                        str += "I";
                    }
                    r_result = strV + str;
                }
            }
        } else if(r == 9) {
            for (Map.Entry<Integer, String> entry : arabRome.entrySet()) {
                if (entry.getKey() == r) {
                    r_result = entry.getValue();
                }
            }
        }
        return r_result;
    }

    private String from_10_to_39(int r, Map<Integer, String> arabRome){

        String r_result = "";

        int num = r % 10;
        int d = (r - num)/10;
        String romeD = "";

        for(int o = 0; o < d; o++){
            romeD += "X";
        }

        String romeNum = from_0_to_9(num, arabRome);
        r_result = romeD + romeNum;

        return r_result;
    }

    private String from_40_to_49(int r, Map<Integer, String> arabRome){

        String r_result = "";
        int num = r % 10;
        String romeNum = from_0_to_9(num, arabRome);
        r_result = "XL" + romeNum;

        return r_result;
    }

    private String from_50_to_89(int r, Map<Integer, String> arabRome){

        String r_result = "";
        int num = r % 10;
        int d = r - num;
        String romeD = "L" + from_10_to_39(d - 50, arabRome);
        String romeNum = from_0_to_9(num, arabRome);
        r_result = romeD + romeNum;

        return r_result;
    }

    private String from_90_to_99(int r, Map<Integer, String> arabRome){

        String r_result = "";
        int num = r % 10;
        String romeNum = from_0_to_9(num, arabRome);
        r_result = "XC" + romeNum;

        return r_result;
    }
}
