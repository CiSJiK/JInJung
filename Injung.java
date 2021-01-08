import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileReader;

public class Injung 
{    
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            Shell sh = new Shell();
            sh.run();
        }
        else if(args[0].equals("--help") || args[0].equals("-h"))
        {
            System.out.println("Usage: Injung [INJUNGFILE | --code/-c | --help/h ]\n\t--code | -c\tRun the code after --code or -c\n \t--help | -h\tPrint this help");
        }
        else if(args[0].equals("--code") || args[0].equals("-c"))
        {
            String code = "";
            for(String tmp : args)
            {
                if(tmp.compareTo("--code") == 0);
                else if(tmp.compareTo("-c") == 0);
                else
                 code += tmp;
            }
            Coding.output(code);   
        }
        else if(args[0].endsWith(".ij"))
        {
            Interprete ip = new Interprete();
            ip.run(args[0]);
        }
        else
        {
            System.out.println("Can not find the option or file, " + args[0] + " Type Injung --help or -h for the information.");
        }

    }
}
class Interprete{
    public void run(String file)
    {
        FileReader fr = null;
        Scanner sc = null;
        try
        {
            fr = new FileReader(file);
            sc = new Scanner(fr);
            while(sc.hasNextLine())
            Coding.output(sc.nextLine());
            sc.close();
            fr.close();
        }
        catch(IOException e)
        {
            System.out.println("Error has been occured while reading the code.");
            System.exit(1);
        }
    }
}
class Shell{
    public void run()
    {
        System.out.println("JInJung(Java ㅇㅈ, 진정, ㅈㅈ) Version 1.0\nType \"ㅈ\" only or Ctrl + (D/C) to exit.");
        System.out.println("For the more information, please visit https://www.github.com/InJung");
        try{
        Scanner sc = new Scanner(System.in);
        String command = "";
        while(!command.equals("ㅈ"))
        {
            System.out.print(">>>");
            command = sc.nextLine();
            Coding.output(command);
        }
        sc.close();
        }
        catch(NoSuchElementException e)
        {
            System.exit(0);
        }
    }
}
class Coding{
    public static void output(String command)
    {
       char[] order = command.toCharArray();
       int i = 0;
       boolean ignore = false;
       while( i + 1 <= order.length && order[i] != 'ㅈ' && ignore == false)
       {
            Stack<Character> stack = new Stack<Character>();
            
            switch(order[i++])
            {
                case 'ㅇ': System.out.println("안녕 세계"); break;
                case 'ㅊ': {
                    if(i >= order.length || order[i] != '(' || order[order.length-1] == '(' || order[order.length - 1] != ')')
                    {
                        System.out.println("Interprete Error: Put string type between '(' and ')' after 'ㅊ'");
                        ignore = true;
                        break;
                    }
                    else
                    {
                        stack.push(order[i++]);
                        while(i+1 < order.length && order[i-1] != ')')
                        {
                            System.out.print(order[i++]);
                        }
                        if(order[i] == ')')
                        {
                            stack.pop();
                            i++;
                            System.out.println();
                        }
                        else
                            System.out.println("Interprete Error: String type message must be done with ')'");
                        break;
                    }

                }
                case 'ㅈ': break;
                case '(': {
                    if(i - 2 <= 0 || order[i - 2] != 'ㅊ')
                    {
                       System.out.println("'(' can't use without 'ㅊ'");
                        break;
                    }
                }
                case ')': {
                    if(i - 2 <= 0 || stack.isEmpty())
                    {
                        System.out.println("Interprete Error: must '(' assigned before ')' after 'ㅊ'");
                        break;
                    }
                }
                default:
                {
                    System.out.println("Command not found. Only 'ㅇ', 'ㅈ', 'ㅊ', '(', ')' can be used.");
                }
            }
       }
    }
}
