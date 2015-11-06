package com.DependencyParser;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Harishankar on 9/23/2015.
 */
public class ParserEvaluatorClass {
    public static void EvaluateParsedTokenMethod(String ParsedToken) throws IOException {

        ManupulateInputParsedToken(ParsedToken);

        ParserTree<String> parentNode = new ParserTree<String>("Parent");
        ParserTree<String> childNode1 = new ParserTree<String>("Child 1");
        ParserTree<String> childNode2 = new ParserTree<String>("Child 2");
        parentNode.addChild(childNode1);
        childNode1.addChild(childNode2);

        List<ParserTree<String>> childrenNodes = parentNode.getChildren();

    }
public static  void ManupulateInputParsedToken(String ParsedToken)
{


}



}