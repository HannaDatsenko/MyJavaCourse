package Homework_13;

import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;



public class Main {

    @Option(name = "-ch", aliases = "-change", handler = StringHandler.class)
     String result;

    @Option(name = "-s", aliases = "-string", required = true)
    String firstString;

    @Option(name = "-r", aliases = "-reverse")
    boolean isReverse;


    public static void main(String[] args) {
        Main main = new Main();
        CmdLineParser parser = new CmdLineParser(main);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            e.printStackTrace();
        }

    }
}

