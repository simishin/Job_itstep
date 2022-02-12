package qwr;

/**
 * Задание 1
 * Выведите на экран надпись «Fall seven times and stand
 * up eight» на разных строках. Пример вывода:
 * Fall seven times
 * and
 * stand up eight.
 *
 * Задание 2
 * Выведите на экран надпись «"Your time is limited, so
 * don’t waste it living someone else’s life" Steve Jobs» на разных
 * строках. Пример вывода:
 * "Your time is limited,
 *  so don’t waste it
 *  living someone else’s life"
 *  Steve Jobs.
 *
 *  Задание 3
 * Пользователь вводит с клавиатуры два числа. Необходимо найти сумму чисел, разницу чисел, произведение
 * числе. Результат вычислений вывести на экран.
 *
 * Задание 4
 * Пользователь вводит с клавиатуры два числа. Первое
 * число — это значение, второе число процент, который
 * необходимо посчитать. Например, мы ввели с клавиатуры
 * 50 и 10. Требуется вывести на экран 10 процентов от 50.
 * Результат: 5.
 *
 * Задание 5
 * Напишите программу, вычисляющую площадь квадрата. Пользователь с клавиатуры вводит размер стороны
 * квадрата.
 */
import static qwr.Main.prnq;
import static qwr.Main.prnt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public  static boolean  prnq(String s){System.out.println(s); return true;}
    public  static boolean  prnt(String s){System.out.print(s); return true;}

    public static void main(String[] args) {
        boolean tstAssert = false;
        assert tstAssert = true;
        if (!tstAssert){ System.err.println("!!!  Assertions are disabled. set (-ea)");}

	    prnq("-------Первое задание");

        Job1 y = new Job1("Fall seven times and stand up eight");
        IntStream intStream = IntStream.of(17,21,867);
        intStream.forEach(i->y.prnv(i));

        prnq("-------Второе задание");
        Job2 z =new Job2();
        for (int i: new int[]{21,20,28,42,23,23,23}) if(Job2.prnv(i)) break;

        prnq("-------Третье задание");
        prnq("Расширенный вариант калькулятора с римскими и арабскими числами" +
                " находится по аддресу https://github.com/simishin/calkul.git");
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in)))
        {
            prnq("-------Четвертое задание");
            Job4.readConsol(br);
            prnq("-------Пятое задание");
            Job5.qwert(br);
        }
        catch(IOException ex){ System.err.println(ex.getMessage()); }
    }
}//class Main ---------------------------------------

class Job1 {
    private String s;
    private int i;
    public Job1(String s) {
        this.s=s;
        this.i=0;
    }

    public void prnv(int j) {
        if (j>s.length()) prnq(s.substring(i));
        else {
            prnq(s.substring(i, j));
            i = j;
        }
    }
}//class job1---------------------------------

class Job2{
    private static String s;
    private static int i=0;
    private static int j=0;
    {
        assert prnq("Инициализация");
        s="Your time is limited, so * don’t waste it living someone else’s life\" Steve Jobs.";
    }
    Job2(){
        assert prnq("старт конструктора");
    }

    public static boolean prnv(int d){
        for (int k=0; k<j; k++)prnt("\t");
        if ((i+d)>s.length()) {
            if (i<s.length()) prnq(s.substring(i));
            assert prnq(" $ "+i+" "+s.length());
            return true;
        }

        prnq(s.substring(i,i+d));
        i+=d;
        j++;
        return false;
    }
}//class Job2 --------------------------------

class Job4{
    public static boolean readConsol(BufferedReader br){
        prnq("Вычисление процента");
        prnq("Для завершения работы введите <q>");
//        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in)))
 //       {
            // чтение построчно
            String strIn=null;
            boolean steepInput=false;//false=значение/ true=процент и вычисление
            int x=0;//значение
            int y=0;
            prnq("Введите число от которого будет взят процент");
            while(true){
                try {
                    if (!!(strIn=br.readLine()).equals("q")) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (strIn.length()<1){ prnq("~"); continue; }
                assert prnq(">"+strIn);
                try {
                    if (steepInput) {
                        y = Integer.valueOf(strIn);
                        prnt("Процент "+y +" от "+x+" = ");
                        if ((y*x/100)<1) prnq("Результат меньше единицы ");
                        else prnq(""+(y*x/100));
                        steepInput=false;
                        prnq("Введите целое число от которого будет взят процент");
                    }else {//значение
                        x = Integer.valueOf(strIn);
                        steepInput=true;
                        prnq("Введите какой процент взять числа (целое число)");
                    }
                } catch (NumberFormatException e){
                    prnq("Извините, но это не число. Повторите ввод");
                    continue;
                }//try
            }//for input string
            prnq("Quit program Job4");
//            br.close();
//            return false;
//        }
//        catch(IOException ex){ prnt("Job4 -> ");System.out.println(ex.getMessage()); }
        return true;
    }//readConsol

}//class Job4 --------------------------------

class Job5{
    public static boolean qwert(BufferedReader brq) {
        prnq("Вычисление площади квадрата");
        prnq("Для завершения работы введите <z>");
//        try(BufferedReader brq = new BufferedReader (new InputStreamReader(System.in)))
//        {
            // чтение построчно
            String strIn=null;
            float y=0;
            prnq("Введите длинну стороны квадрата");
            while(true){
                try {
                    if (!!(strIn=brq.readLine()).equals("z")) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (strIn.length()<1){ prnq("~"); continue; }
                assert prnq(">"+strIn);
                try {
                        y = Float.valueOf(strIn);
                        prnq("Площадь квадрата ="+(y*y));
                        prnq("Введите длинну стороны квадрата");
                } catch (NumberFormatException e){
                    prnq("Извините, но это не число. Повторите ввод");
                    continue;
                }//try
            }//for input string
//            return false;
  //      }
//        catch(IOException ex){ prnt("Job5 -> "); System.out.println(ex.getMessage()); }
        return true;
    }//qwert

}//class Job5 --------------------------------
