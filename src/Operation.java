public class Operation extends RomeResult {

    public String calculate(int[] values){

        RomeResult rm = new RomeResult();
        String result = "";
        int res = 0;
        int operation = values[3];

        if (operation == 0){
            res = values[0] + values[1];
        } else if (operation == 1){
            res = values[0] - values[1];
        } else if (operation == 2){
            res = values[0] * values[1];
        } else if (operation == 3){
            res = values[0] / values[1];
        }



        if (values[2] == 1){
            result = rm.convertToRomeValue(res);
        } else{
            result = Integer.toString(res);
        }


        return result;
    }

}
