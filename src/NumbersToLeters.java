public class NumbersToLeters {

    public static void main(String[] args) {
        NumbersToLeters g = new NumbersToLeters();
        double number = 999888771.71;//до милиарда
        String[] arr = g.createArrayFromNumber(number);
        String finalStringNumbers = g.convertIntrigerPartNum(arr)+g.currencyDollar(number,0)
                +g.convertDecimalsPartNum(arr)+g.currencyDollar(number,1);

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
                intrigerPartNumbers += g.namePuwer(i) + " ";
            }
            if (count == 0&i==6) {
                intrigerPartNumbers += g.simpleNumbers(arr[i + 2]) + " ";
            }
        }
        return intrigerPartNumbers;
    }
    private String namePuwer (int num) {
        String name = "";
        switch (num) {
            case 0:
                name = "million";
                break;
            case 3:
                name = "thousand";
                break;
        }return name;
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
        switch (num) {
            case "0":
                pNumber = "zero";
                break;
            case "1":
                pNumber = "one";
                break;
            case "2":
                pNumber = "two";
                break;
            case "3":
                pNumber = "three";
                break;
            case "4":
                pNumber = "four";
                break;
            case "5":
                pNumber = "five";
                break;
            case "6":
                pNumber = "six";
                break;
            case "7":
                pNumber = "seven";
                break;
            case "8":
                pNumber = "eight";
                break;
            case "9":
                pNumber = "nine";
                break;
        }
        return pNumber;
    }
    private final String teenNumbers(String num){

        String pNumber = "";
        switch (num) {
            case "10":
                pNumber = "ten";
                break;
            case "11":
                pNumber = "eleven";
                break;
            case "12":
                pNumber = "twelve";
                break;
            case "13":
                pNumber = "thirteen";
                break;
            case "14":
                pNumber = "fourteen";
                break;
            case "15":
                pNumber = "fifteen";
                break;
            case "16":
                pNumber = "sixteen";
                break;
            case "17":
                pNumber = "seventeen";
                break;
            case "18":
                pNumber = "eighteen";
                break;
            case "19":
                pNumber = "nineteen";
                break;
        }
        return pNumber;
    }
    private final  String tyNumbers (String num){

        String pNumber = "";
        switch (num) {
            case "2":
                pNumber = "twenty";
                break;
            case "3":
                pNumber = "thirty";
                break;
            case "4":
                pNumber = "forty";
                break;
            case "5":
                pNumber = "fifty";
                break;
            case "6":
                pNumber = "sixty";
                break;
            case "7":
                pNumber = "seventy";
                break;
            case "8":
                pNumber = "eighty";
                break;
            case "9":
                pNumber = "ninety";
                break;
        }
        return pNumber;
    }
    String currencyDollar (double num, int afterpoint) {
        int partInt=(int)num;
        double partDecimals=(float)Math.round((num-partInt)*100d)/100d;
        //double partDecimals=new BigDecimal(num-partInt).setScale(2, RoundingMode.HALF_UP).doubleValue();
        String name = "";

        if (afterpoint==0){
            if (partInt==1){name = "dollar";}
            else {name = "dollars";}
        }
        if (afterpoint==1){
            if (partDecimals==0.01){name = "cent";}
            else {name = "cents";}
        }
        return name+=" ";
    }
}
