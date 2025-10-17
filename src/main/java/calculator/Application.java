package calculator;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.*;
public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        String[] inputArray = input.split("");

        Integer result = 0;

        String operator;


        if(inputArray[0].equals("/") && inputArray[1].equals("/")
                && inputArray[3].equals("\\")&& inputArray[4].equals("n")){
            operator = inputArray[2];
            System.arraycopy(inputArray, 5, inputArray, 0, inputArray.length - 5);
            inputArray = input.split("["+operator+",:]");

            for(var o = 0; o <inputArray.length; o++){
               System.out.println(inputArray[o]);
               result += stringToInteger(inputArray[o]);

            }
        }else{
            for(var o = 0; o <inputArray.length; o++){
                inputArray = input.split("[,:]");
                result += stringToInteger(inputArray[o]);
            }
        }

        System.out.println("결과 : "+result);
    }

    public static Integer stringToInteger(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
