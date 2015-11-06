package com.mdd.rules;

import java.util.Arrays;

public class POSReference {


	private String[] PosTag = {"CC","CD","DT","EX","FW","IN","JJ","JJR","JJS","LS","MD","NN","NNS","NNP","NNPS","PDT","POS","PRP","PRP$","RB","RBR","RBS","RP","SYM","TO","UH","VB","VBD","VBG","VBN","VBP","VBZ","WDT","WP","WP$","WRB"};
	private String[] Meaning = {"CoordinatingConjunction","CardinalNumber","Determiner","ExistentialThere","ForeignWord","PrepositionorSubordinatingConjunction","Adjective","Adjective, comparative","Adjective, superlative","ListItemMarker","Modal","Noun,singularOrMass","Noun,plural","ProperNoun,Singular","ProperNoun,Plural","Predeterminer","PossessiveEnding","PersonalPronoun","PossessivePronoun","Adverb","Adverb,Comparative","Adverb,Superlative","Particle","Symbol","to","Interjection","Verb,BaseForm","Verb,PastTense","Verb,GerundOrPresentParticiple","Verb,PastParticiple","Verb,Non-3rdPersonSingularPresent","Verb,3rdPersonSingularPresent","Wh-determiner","Wh-pronoun","PossessiveWh-pronoun","Wh-adverb"};
	public POSReference() { }



	public String getPOSMeaning( String POS)  {

		int index = Arrays.asList(PosTag).indexOf(POS);

		return Meaning[index];
	}

}
