package calculator;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        
        int result = calculate(input);
        System.out.println("결과 : " + result);
    }
    
    private static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        
        String delimiter = "[,:]";
        
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            delimiter = "[" + input.substring(2, delimiterEnd) + ",:]"; 
            input = input.substring(delimiterEnd + 2);
        }
        
        String[] numbers = input.split(delimiter);
        int sum = 0;
        
        for (String number : numbers) {
            if (!number.isEmpty()) {
                int num = parseNumber(number);
                if (num < 0) {
                    throw new IllegalArgumentException();
                }
                sum += num;
            }
        }
        
        return sum;
    }
    
    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}