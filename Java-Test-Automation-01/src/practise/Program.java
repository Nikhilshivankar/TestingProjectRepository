package practise;

import libraries.Browser;

import org.openqa.selenium.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

    public static void main(String args[]) {

//        sortingString_1("nikhil");
//    //  reversingString_2("nikhil");
//        reversingString_3("nikhil");
//        reversingString_4("nikhil");
//        reversingString_5("nikhil");

        Program program = new Program();
        program.reverse();


    }

    public void test_tables(){

    	Browser browser = new Browser();
    
        WebDriver driver = browser.getBrowserDriver("chrome");
        driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");

        WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']"));
        List<WebElement> rows = table.findElements(By.xpath("//tr[td]"));
        List<WebElement> columns = table.findElements(By.tagName("th"));

        System.out.println("Table Testing - Rows = " + rows.size());  //  derived col no. = 5

        int i = 1, j = 5;
        String strSearch = "ABC";
        //tr[td[1][text()='ABC']]/td[5]
        String xpathCheck = "//tr[td[" + i + "][text()=" + strSearch + "][" + j + "]";
        table.findElement(By.xpath(xpathCheck)).getText();

        System.out.println("Table Testing - Columns = " + columns.size());

        System.out.println("Table Testing - Rows 1 , Column 1 = " + table.findElement(By.xpath("//tr[td[2]")).getText());

        System.out.println("Table Testing - Rows 1 , Column 1 = " + table.findElement(By.xpath("//tr[1]/td[2]")).getText());
    }

    public static void sortingString_1(String abc) {

        char[] ch = abc.toCharArray();
        Arrays.sort(ch);
        System.out.println("1st Result for alphabetical sorting:");
        System.out.print(ch);
        System.out.println();

    }

    public static void reversingString_2(String abc) {   //////////////  NOT working

        char[] ch = abc.toCharArray();
        int l = ch.length;

        TreeSet<Character> treeSet = null;
        for (int i=0; i<l;i++) {
            treeSet = new TreeSet<Character>();
            String a= "";
            treeSet.add(ch[i]);
        }
        Iterator itr = treeSet.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.hasNext());
        }

    }

    public static void reversingString_3(String abc) {

        char[] ch = abc.toCharArray();

        StringBuilder str_buil = new StringBuilder();
        str_buil = str_buil.append(abc);
        str_buil.reverse();

        System.out.println("3rd result :"+str_buil);

    }
    public void reverse(){
        String strOrg = "a@b#c$";
        char[] arrOrg = strOrg.toCharArray();

        List<Character> list = new ArrayList<Character>();
        for (char ch : arrOrg){
            list.add(ch);
        }
        List<Character> temp1= null;
        List<Character> temp2 = null;
        for(int i = 0; i<list.size();i++) {

            if (Character.isAlphabetic(arrOrg[i])==true) {
                temp1 = new ArrayList<Character>();
                temp1.add(arrOrg[i]);
            }else
                temp2 = new ArrayList<Character>();
                temp2.add(arrOrg[i]);
        }
        Collections.reverse(temp1);

        System.out.println(temp1);

    }

    public static void reversingString_4(String abc) {

        char[] ch = abc.toCharArray();
        int l = ch.length;
/*
        System.out.println(l);
        System.out.println();
*/
        String reverse = "";
        for (int i = l - 1; i >= 0; i--) {

            reverse = reverse + String.valueOf(ch[i]);
        }
        System.out.println("4th Result:"+reverse);

    }

    public static void reversingString_5(String abc){

        char[] ch = abc.toCharArray();
        List<Character> trial1 = new ArrayList<Character>();
        String str_new = "";
        for (char c: ch) {
            trial1.add(c);
        }
        Collections.reverse(trial1);
        ListIterator li = trial1.listIterator();
        while (li.hasNext()) {
            //System.out.print(li.next());
            str_new.concat(String.valueOf(li));
        }
        System.out.println("5th Result:" + str_new);
    }

    public void reverseAlpha(){

        String strLookUp = "a#b$c%d*";
        int myLen = strLookUp.length();

        String strPattern = "[a-zA-Z0-9]";
        Pattern p = Pattern.compile(strPattern, Pattern.CASE_INSENSITIVE);

        char[] res = strLookUp.toCharArray();

        System.out.println("Size : " + res.length);

        for(int index = 0; index < myLen; index++ ){

            char letter = res[index];
            Matcher m = p.matcher(String.valueOf(letter)); // ;
            if ( m.find()) {
                int intFirstMatch = index;

                for(int indexR = myLen -1; indexR > index; indexR-- ){

                    char letterL = res[indexR];
                    Matcher mL = p.matcher(String.valueOf(letterL)); // String.valueOf(letter));

                    if ( mL.find()){
                        int intLastMatch = indexR;

                        System.out.println( intFirstMatch + "/" + intLastMatch);
                        char temp =  res[intFirstMatch];  // a
                        res[intFirstMatch] =  res[intLastMatch];  // c = a
                        res[intLastMatch] =  temp; // a = a

                        System.out.println("My output = " + String.valueOf(res));

                        break;
                    }
                }
            }

        }

        System.out.println("My FINAL output = " + String.valueOf(res));
//
//        System.out.println("My output = " + String.valueOf(res));
    }

}
