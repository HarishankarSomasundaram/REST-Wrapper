package com.DependencyParser;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.formats.ParseSampleStreamFactory;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Harishankar on 9/20/2015.
 */
public class ParserClass {

    public static void Parse(String word) throws IOException {
        // http://sourceforge.net/apps/mediawiki/opennlp/index.php?title=Parser#Training_Tool
        // File fileName = new File("G:\\Works\\Altisource\\Spring Boot\\REST Wrapper\\src\\main\\resources\\en-parser-chunking.bin");
        File fileName = new File("G:\\Works\\\\Altisource\\\\Spring Boot\\REST Wrapper\\src\\en-parser-chunking.bin");
        //InputStream is = new FileInputStream(fileName);
// is);
        ParserModel model = new ParserModel(fileName);

        Parser parser = ParserFactory.create(model);

        String sentence = word;
        Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);
        StringBuffer sb = new StringBuffer();
        for (Parse p : topParses)
            p.show(sb);
        System.out.println(sb.toString());
        //is.close();
        ParserEvaluatorClass.EvaluateParsedTokenMethod(sb.toString());

        //System.console().writer().println(sb.toString());
    /*
	 * (TOP (S (NP (NN Programcreek) ) (VP (VBZ is) (NP (DT a) (ADJP (RB
	 * very) (JJ huge) (CC and) (JJ useful) ) ) ) (. website.) ) )
	 */
    }
}
