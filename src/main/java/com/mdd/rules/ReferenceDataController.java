package com.mdd.rules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DependencyParser.ParserClass;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class ReferenceDataController {

    List<RefData> refData = new ArrayList<RefData>();
    List<RefData> wordListData = new ArrayList<RefData>();

    @RequestMapping(value = "/elements", method = RequestMethod.GET)
    public List<ElementDetail> getElements() throws FileNotFoundException {
        List<ElementDetail> elements = new ArrayList<ElementDetail>();
        String file = getClass().getClassLoader().getSystemResource("elements.csv").getFile();
        Scanner scanner = new Scanner(new File(file));
        String line;
        int lineNo = 0;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (lineNo > 0 && !StringUtils.isEmpty(line)) {
                String items[] = line.split(",");
                ElementDetail detail = new ElementDetail();
                detail.setElementId(Integer.parseInt(items[0].trim()));
                detail.setElementName(items[1].trim());
                detail.setDataStoreId(Integer.parseInt(items[2].trim()));
                detail.setDataStoreName(items[3].trim());
                detail.setDataTypeCode(items[4].trim());
                elements.add(detail);
            }
            lineNo++;
        }
        scanner.close();
        return elements;
    }

    @RequestMapping(value = "/nlp/{word}", method = RequestMethod.GET)
    public List<String> PosNLP(@PathVariable String word) throws IOException {
        List<POSClass> POSElement = new ArrayList<POSClass>();
        File fileName = new File("G:\\Works\\Altisource\\Spring Boot\\REST Wrapper\\src\\main\\resources\\en-pos-maxent.bin");
        POSModel sampleModel = new POSModel(fileName);
        POSTaggerME sampleTag = new POSTaggerME(sampleModel);
        String tokenTags[] = WhitespaceTokenizer.INSTANCE.tokenize(word);
        String output[] = sampleTag.tag(tokenTags);

        StringBuilder sb = new StringBuilder();
        POSReference objPosRef = new POSReference();
        List<String> posTag = new ArrayList<>();
        for (int i = 0; i < output.length; i++) {
//			POSClass objPOS = new POSClass(tokenTags[i],output[i]);
//			POSElement.add(objPOS);
            sb.append(tokenTags[i] + "/" + output[i] + " ");
        }
        posTag.add(sb.toString());
        sb = new StringBuilder();
        for (int i = 0; i < output.length; i++) {
            sb.append(tokenTags[i] + "/" + objPosRef.getPOSMeaning(output[i]) + " ");
        }
        posTag.add(sb.toString());
        return posTag;
    }

    @RequestMapping(value = "/nlpParser/{word}", method = RequestMethod.GET)
    public List<String> ParseNLP(@PathVariable String word) throws IOException {

        ParserClass pc =new ParserClass();
        pc.Parse(word);


//        List<POSClass> POSElement = new ArrayList<POSClass>();
//        File fileName = new File("G:\\Works\\Altisource\\Spring Boot\\REST Wrapper\\src\\main\\resources\\en-pos-maxent.bin");
//        POSModel sampleModel = new POSModel(fileName);
//        POSTaggerME sampleTag = new POSTaggerME(sampleModel);
//        String tokenTags[] = WhitespaceTokenizer.INSTANCE.tokenize(word);
//        String output[] = sampleTag.tag(tokenTags);
//
//        StringBuilder sb = new StringBuilder();
//        POSReference objPosRef = new POSReference();
//        List<String> posTag = new ArrayList<>();
//        for (int i = 0; i < output.length; i++) {
////			POSClass objPOS = new POSClass(tokenTags[i],output[i]);
////			POSElement.add(objPOS);
//            sb.append(tokenTags[i] + "/" + output[i] + " ");
//        }
//        posTag.add(sb.toString());
//        sb = new StringBuilder();
//        for (int i = 0; i < output.length; i++) {
//            sb.append(tokenTags[i] + "/" + objPosRef.getPOSMeaning(output[i]) + " ");
//        }
//        posTag.add(sb.toString());
//        return posTag;
        return null;

    }

    @RequestMapping(value = "/refdata/{refType}", method = RequestMethod.GET)
    public List<String> getRefData(@PathVariable String refType) throws FileNotFoundException {
        if (refData == null || refData.size() == 0) {
            refData = new ArrayList<RefData>();
            String file = getClass().getClassLoader().getSystemResource("refdata.csv").getFile();
            Scanner scanner = new Scanner(new File(file));
            String line;
            int lineNo = 0;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String items[] = line.split(",");
                if (lineNo > 0 && !StringUtils.isEmpty(line)) {
                    RefData item = new RefData(items[0].trim(), items[1].trim());
                    refData.add(item);
                }
                lineNo++;
            }
            scanner.close();
        }
        List<String> values = new ArrayList<String>();
        for (RefData item : refData) {
            if (item.getRefType().equalsIgnoreCase(refType))
                values.add(item.getValue());
        }
        return values;
    }

    @RequestMapping(value = "/nextwords/{word}", method = RequestMethod.GET)
    public List<String> getNextWords(@PathVariable String word) throws FileNotFoundException {
        if (wordListData == null || wordListData.size() == 0) {
            wordListData = new ArrayList<RefData>();
            String file = getClass().getClassLoader().getSystemResource("following_words.csv").getFile();
            Scanner scanner = new Scanner(new File(file));
            String line;
            int lineNo = 0;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String items[] = line.split(",");
                if (lineNo > 0 && !StringUtils.isEmpty(line)) {
                    RefData item = new RefData(items[0].trim(), items[1].trim());
                    wordListData.add(item);
                }
                lineNo++;
            }
            scanner.close();
        }
        List<String> values = new ArrayList<String>();
        for (RefData item : wordListData) {
            if (item.getRefType().equalsIgnoreCase(word))
                values.add(item.getValue());
        }
        return values;
    }
}
