package Homework_13;

import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Main {

    @Option(name = "-ch", aliases = "-change", handler = StringHandler.class)
     Pair forChange;

    @Option(name = "-s", aliases = "-string", required = true)
    String firstString;

    @Option(name = "-r", aliases = "-reverse")
    boolean isReverse;


    public static void main(String[] args) {
        Main main = new Main();
        CmdLineParser parser = new CmdLineParser(main);
        try {
            parser.parseArgument(args);
           String result = main.transform(main.firstString, main.forChange, main.isReverse);
           System.out.println(result);
        } catch (CmdLineException e) {
            e.printStackTrace();
        }

    }
    public String transform(String inString, Pair changer, boolean reverser){
      if (inString.length() != 0){
          if(changer!=null){
          inString = inString.replace(changer.changeFrom, changer.changeTo);}
       if(reverser){
           String result = "";
           for (int i = 0; i < inString.length(); i++) {
           result = inString.charAt(i) + result;
           }
           return result;
       }
       return inString;
       }
      return "Your string is empty";
    }
}



