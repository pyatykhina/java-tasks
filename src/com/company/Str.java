package com.company;
import java.util.*;

/**
 * Класс для хранения строки пользователя.
 */
public class Str {

    public String inputStr;

    public  List<String> postfix = new ArrayList<String>();

    /**
     Операторы
     */
    private String operators = "+-*/";

    /**
     Разделители - скобки и операторы; для стека
     */
    private String delimiters = "() " + operators;

    /**
     Если оператор (+ - / *)
     */
    private boolean isOperator(String token)
    {
        if (token.equals("u-")) return true;
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }

    /**
     Если разделитель
     */
    private boolean isDelimiter(String token)
    {
        if (token.length() != 1) return false;
        for (int i = 0; i < delimiters.length(); i++)
        {
            if (token.charAt(0) == delimiters.charAt(i)) return true;
        }
        return false;
    }

    /**
     * Если тригонометрическая функция
     * @param token
     * @return
     */
    private boolean isFunction(String token)
    {
        if (token.equals("sin") || token.equals("cos") || token.equals("tg") || token.equals("ctg")) return true;
        return false;
    }

    /**
     Приоритет операций
     */
    private int priority(String token)
    {
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }

    /**
     * Инициализация строки.
     *
     * @return Строка пользователя.
     */
    public Str Init()
    {
        System.out.println("Введите строку: ");

        Scanner in = new Scanner(System.in);
        inputStr = in.nextLine();

        Validate();

        return this;
    }

    /**
     *  Валидация строки
     */
    public void Validate()
    {
        for(int i=0; i<inputStr.length(); i++)
        {
            if (inputStr.charAt(i) >= 'a' && inputStr.charAt(i) <= 'z')
            {
                System.out.println("В строке не должно быть букв.");
                System.exit(1);
            }
        }
    }

    /**
     * Вывод на экран.
     */
    public void Display()
    {
        System.out.println("--------");
        System.out.print("Ответ:  ");
        System.out.println(calc());
        System.out.println("--------");
    }

    /**
     * Перевод пользовательской строки в обратную польскую запись
     * @return
     */
    public List<String> fromInfixToPostfix( )
    {
        Stack<String> stack = new Stack<String>();
        StringTokenizer tokenizer = new StringTokenizer(inputStr, delimiters, true);
        String prev = "";
        String curr = "";

        // если дальше есть токены
        while (tokenizer.hasMoreTokens())
        {

            curr = tokenizer.nextToken();

            // если последний токен - это оператор
            if (!tokenizer.hasMoreTokens() && isOperator(curr))
            {
                System.out.println("Некорректное выражение.");
                System.exit(1);
            }

            // прокидываем  пробелы
            if (curr.equals(" ")) continue;


            // если функция
            if (isFunction(curr)) stack.push(curr);

            else if (isDelimiter(curr)) {
                if (curr.equals("(")) stack.push(curr);

                // есть ) но нет (
                else if (curr.equals(")"))
                {

                    while (!stack.peek().equals("("))
                    {
                        postfix.add(stack.pop());
                        if (stack.isEmpty())
                        {
                            System.out.println("Скобки не согласованы.");
                            System.exit(1);
                        }
                    }
                    stack.pop();
                    if (!stack.isEmpty() && isFunction(stack.peek()))
                    {
                        postfix.add(stack.pop());
                    }
                }

                else {
                    if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev)  && !prev.equals(")"))))
                    {
                        // унарный минус в обратной польской записи
                        curr = "u-";
                    }
                    else {
                        while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek())))
                        {
                            postfix.add(stack.pop());
                        }

                    }
                    stack.push(curr);
                }
                // ничего не возвращаем
            }

            else
            {
                postfix.add(curr);
            }
            prev = curr;
        }

        // проверка стека
        while (!stack.isEmpty())
        {
            if (isOperator(stack.peek())) postfix.add(stack.pop());
            else
            {
                System.out.println("Скобки не согласованы.");
                System.exit(1);
            }
        }
        return postfix;
    }

    public Double calc()
    {
        Stack<Double> stack = new Stack<Double>();
        for (String x : postfix)
        {
            if (x.equals("sin")) stack.push(Math.sin(Math.toRadians(stack.pop())));
            else if (x.equals("cos")) stack.push(Math.cos(Math.toRadians(stack.pop())));
            else if (x.equals("tg")) stack.push(Math.tan(Math.toRadians(stack.pop())));
            else if (x.equals("ctg")) stack.push(1/Math.tan(Math.toRadians(stack.pop())));

            else if (x.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (x.equals("-"))
            {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a - b);
            }
            else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (x.equals("/"))
            {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a / b);
            }

            else if (x.equals("u-")) stack.push(-stack.pop());
            else stack.push(Double.valueOf(x));
        }
        return stack.pop();
    }
}
