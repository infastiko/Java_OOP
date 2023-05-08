package Task_7.Calculator;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Calculator {
        private static final Scanner SCANNER = new Scanner(System.in);

        public static void main(String[] args) {
            System.out.println("Hello! Welcome to our calculator.");
            String kindOperation = getKindOperation();

            while (true) {
                String input = getInput();
                Object result = calc(input, kindOperation);
                output(result);
                Log.logWrite(input, result);
            }
        }

        private static String getKindOperation() {
            while (true) {
                System.out.print("For complex numbers input 1, for usual numbers input 2: ");
                String kindOperation = SCANNER.nextLine();

                switch (kindOperation) {
                    case "1":
                        return "COMPLEX";
                    case "2":
                        return "NUM";
                    default:
                        System.out.println("Your input is incorrect. Try again, please.");
                }
            }
        }

        private static String getInput() {
            while (true) {
                System.out.print("Input your operation. Please separate numbers from the sign of operation with space: ");
                String input = SCANNER.nextLine();
                String[] data = input.split(" ");

                if (data.length == 3) {
                    if (data[1].equals("+") || data[1].equals("-") || data[1].equals("*") || data[1].equals("/")) {
                        System.out.println("Thank you!");
                        return input;
                    }
                }

                System.out.println("Your input is incorrect. Try again, please.");
            }
        }

        private static Object calc(String action, String kind) {
            String[] data = action.split(" ");
            String sign = data[1];
            Object answer;

            if (kind.equals("NUM")) {
                double firstNum = Double.parseDouble(data[0]);
                double secondNum = Double.parseDouble(data[2]);

                if (sign.equals("+")) {
                    answer = firstNum + secondNum;
                } else if (sign.equals("-")) {
                    answer = firstNum - secondNum;
                } else if (sign.equals("*")) {
                    answer = firstNum * secondNum;
                } else if (sign.equals("/")) {
                    if (secondNum == 0) {
                        answer = "division for zero";
                    } else {
                        answer = firstNum / secondNum;
                    }
                } else {
                    answer = "Something unexpected happened";
                }
            } else {
                Complex firstNum = new Complex(Double.parseDouble(data[0].replace("j", "i")));
                Complex secondNum = new Complex(Double.parseDouble(data[2].replace("j", "i")));

                if (sign.equals("+")) {
                    answer = firstNum.add(secondNum);
                } else if (sign.equals("-")) {
                    answer = firstNum.subtract(secondNum);
                } else if (sign.equals("*")) {
                    answer = firstNum.multiply(secondNum);
                } else if (sign.equals("/")) {
                    answer = firstNum.divide(secondNum);
                } else {
                    answer = "Something unexpected happened";
                }
            }

            return answer;
        }

        private static void output(Object result) {
            try {
                if (result instanceof Integer) {
                    System.out.println("Your result is: " + (Integer) result);
                } else if (result instanceof Double) {
                    System.out.println("Your result is: " + (Double) result);
                } else {
                    System.out.println(result.toString());
                }
            } catch (Exception e) {
                System.out.println(result.toString());
            }
        }
    }
