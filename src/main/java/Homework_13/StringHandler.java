package Homework_13;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

public class StringHandler extends OptionHandler<String> {
    public StringHandler(CmdLineParser parser, OptionDef option, Setter<? super String> setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        //String inString = params.;
        //Main main = new Main();
        //CmdLineParser parser = new CmdLineParser(main);
        String letterForChange = params.getParameter(0);
        String  letterAfter = params.getParameter(1);
        //Main main = new Main();
        //CmdLineParser parser = new CmdLineParser(main);
        try {
            //parser.
           // String inString = main.firstString;
            //
            // inString.replace(letterForChange, letterAfter);
            //if (main.isReverse){
                //String result = "";
                //for (int i = 0; i < inString.length(); i++) {
                    //result = inString.charAt(i) + result;
                //}

            //}

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }


    @Override
    public String getDefaultMetaVariable() {
        return null;
    }

}
