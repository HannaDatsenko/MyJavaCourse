package Homework_13;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

public class StringHandler extends OptionHandler<Pair> {
    public StringHandler(CmdLineParser parser, OptionDef option, Setter<? super Pair> setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        if(params.size()==2){
        char changeFrom = params.getParameter(0).toCharArray()[0];
        char changeTo = params.getParameter(1).toCharArray()[0];
        setter.addValue(new Pair(changeFrom, changeTo));

        return 2;}
        return 0;
    }

    @Override
    public String getDefaultMetaVariable() {
        return null;
    }

}
