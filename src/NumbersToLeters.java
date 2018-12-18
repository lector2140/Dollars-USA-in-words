import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumbersToLeters {

    public static void main(String[] args) {
        NumbersToLeters g = new NumbersToLeters();
        System.out.println("Введите число до миллиарда(разделитель \",\" ):");
        Scanner in = new Scanner(System.in);
        double y = in.nextDouble();
        double number = y;//до милиарда
        String[] arr = g.createArrayFromNumber(number);
        String finalStringNumbers = g.convertIntrigerPartNum(arr)+g.currencyDollar(number,false)
                +g.convertDecimalsPartNum(arr)+g.currencyDollar(number,true);

        System.out.print(finalStringNumbers);
    }
    public String convertIntrigerPartNum(String arr[]) {
        NumbersToLeters g = new NumbersToLeters();
        String intrigerPartNumbers = "";
        for (int i = 0; i <= arr.length-3; i += 3) {
            int count = 0;
            if (!arr[i].equals("0")) {
                intrigerPartNumbers += g.simpleNumbers(arr[i]) + " hundred" + " ";
                count++;
            }
            if (arr[i + 1].equals("1")) {
                intrigerPartNumbers += g.teenNumbers(arr[i + 1] + arr[i + 2]) + " ";
                count++;
            } else {
                if (!arr[i + 1].equals("1") & !arr[i + 1].equals("0")) {
                    intrigerPartNumbers += g.tyNumbers(arr[i + 1]) + " ";
                    count++;
                }
                if (!arr[i + 2].equals("0")) {
                    intrigerPartNumbers += g.simpleNumbers(arr[i + 2]) + " ";
                    count++;
                }
            }
            if (count > 0) {
                intrigerPartNumbers += g.namePower(i) + " ";
            }
            if (count == 0&i==6) {
                intrigerPartNumbers += g.simpleNumbers(arr[i + 2]) + " ";
            }
        }
        return intrigerPartNumbers;
    }
    private String namePower (int num) {
        String name = "";
        Map<Integer, String> namePowerMap = new HashMap<Integer, String>()
        { {
            put(0, "million");
            put(3,"thousand");
            put(6,"");
                   }};
        return name=namePowerMap.get(num);
    }
    public String convertDecimalsPartNum(String arr[]) {
        NumbersToLeters g = new NumbersToLeters();
        String decimalsPartNumbers = "";
        int i = 9;
        int count = 0;
        if (arr[i ].equals("1")) {
            decimalsPartNumbers += g.teenNumbers(arr[i] + arr[i + 1]) + " ";
            count++;
        } else {
            if (!arr[i].equals("1") & !arr[i].equals("0")) {
                decimalsPartNumbers += g.tyNumbers(arr[i]) + " ";
                count++;
            }
            if (!arr[i + 1].equals("0")) {
                decimalsPartNumbers += g.simpleNumbers(arr[i + 1]) + " ";
                count++;
            }
        }
        if (count == 0) {
            decimalsPartNumbers += g.simpleNumbers(arr[i]) + " ";
        }
        return decimalsPartNumbers;
    }

    public String[] createArrayFromNumber ( double number){
        long temp = (long) (number * 100);
        String[] arr = new String[11];

        for (int i = 10; i >= 0; i--) {
            arr[i] = String.valueOf(temp % 10);
            temp /= 10;
        }
        return arr;
    }
    private final String simpleNumbers (String num){
        String pNumber = "";
        Map<String, String> simpleNumbersMap = new HashMap<String, String>()
        { {
            put("0","zero");
            put("1","one");
            put("2","two");
            put("3", "three");
            put("4", "four");
            put("5", "five");
            put("6", "six");
            put("7", "seven");
            put("8", "eight");
            put("9", "nine");
                    }};
        return pNumber=simpleNumbersMap.get(num);
                   }
    private final String teenNumbers(String num){
        String pNumber = "";
        Map<String, String> teenNumbersMap = new HashMap<String, String>()
        {{
                put("10", "ten");
                put("11", "eleven");
                put("12", "twelve");
                put("13", "thirteen");
                put("14", "fourteen");
                put("15", "fifteen");
                put("16", "sixteen");
                put("17", "seventeen");
                put("18", "eighteen");
                put("19", "nineteen");
            }};
        return pNumber=teenNumbersMap.get(num);
    }
    private final  String tyNumbers (String num){
        String pNumber = "";
        Map<String, String> tyNumbersMap = new HashMap<String, String>()
        {{
                put("2", "twenty");
                put("3", "thirty");
                put("4", "forty");
                put("5", "fifty");
                put("6", "sixty");
                put("7", "seventy");
                put("8", "eighty");
                put("9", "ninety");
            }};
        return pNumber=tyNumbersMap.get(num);
    }
    String currencyDollar (double num, boolean afterpoint) {
        int partInt=(int)num;
        double partDecimals=(float)Math.round((num-partInt)*100d)/100d;
        //double partDecimals=new BigDecimal(num-partInt).setScale(2, RoundingMode.HALF_UP).doubleValue();
        String name = "";

        if (afterpoint==false){
            if (partInt==1){name = "dollar";}
            else {name = "dollars";}
        }
        if (afterpoint){
            if (partDecimals==0.01){name = "cent";}
            else {name = "cents";}
        }
        return name+=" ";
    }
}
