package universite.toulouse.moodlexmlapi.openmind.xml.access;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.GenericQuestion;
import universite.toulouse.moodlexmlapi.core.data.QuestionText;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import universite.toulouse.moodlexmlapi.core.data.QuestionTextFormat;
import universite.toulouse.moodlexmlapi.openmind.xml.GenericQuestionEntity;

public class GenericQuestionAccess extends QuestionAccess {

	/**
	 * Get a category of question and course value
	 * @return an instance of category question
	 */
	public static GenericQuestion getGenericQuestion(Element questionElement){
		
		GenericQuestion genericQuestion = new GenericQuestionEntity();
		
		try {
			
			/*
			 * Type properties
			 */
			String type =  DomAccess.getAttributtValue(questionElement, "type");
			// Checking and add a value of type
			if(QuestionType.values().equals(type)){
				genericQuestion.setQuestionType(QuestionType.valueOf(type));
			}
			
			/*
			 * Name properties
			 */
			Element nameElement = DomAccess.getElement(questionElement, "name");
			Element textElement = DomAccess.getElement(nameElement, "text");
			String text =  DomAccess.getElementValue(textElement);
			// Add a value of name
			genericQuestion.setName(text);
			
			/*
			 * QuestionText properties
			 */
			QuestionText questionText = null;
			
			Element questionTextElement = DomAccess.getElement(questionElement, "questiontext");
			textElement = DomAccess.getElement(questionTextElement, "text");
			text =  DomAccess.getElementValue(textElement);
			
			String format = DomAccess.getAttributtValue(questionTextElement, "format");
			
			// Checking and add a value of type
			if(QuestionTextFormat.values().equals(format)){
				questionText = new QuestionText(text, QuestionTextFormat.valueOf(format));
			}
			// Add an instance of questionText
			genericQuestion.setQuestionText(questionText);
			
			/*
			 * Image properties
			 */
			Element imageElement = DomAccess.getElement(questionElement, "image");
			String image = DomAccess.getElementValue(imageElement);
			// Add a value of image
			genericQuestion.setImageUrl(image);
			
			/*
			 * Image64 properties
			 */
			Element imageBase64Element = DomAccess.getElement(questionElement, "image_base64");
			String imageBase64 = DomAccess.getElementValue(imageBase64Element);
			// Add a value of imageBase64
			genericQuestion.setImageBase64(imageBase64);
			
			/*
			 * General feedback properties
			 */
			Element generalFeedBackElement = DomAccess.getElement(questionElement, "generalFeedBack");
			String generalFeedBack = DomAccess.getElementValue(generalFeedBackElement);
			// Add a value of general feed-back
			genericQuestion.setGeneralFeedBack(generalFeedBack);
			
			/*
			 * Default grade properties
			 */
			Element defaultGradeElement = DomAccess.getElement(questionElement, "defaultgrade");
			String defaultgrade = DomAccess.getElementValue(defaultGradeElement);
			// Add a value of default grade
			genericQuestion.setDefaultGrade(Float.valueOf(defaultgrade));
			
			/*
			 * Penalty properties
			 */
			Element penaltyElement = DomAccess.getElement(questionElement, "penalty");
			String penalty = DomAccess.getElementValue(penaltyElement);
			// Add a value of penalty
			genericQuestion.setPenalty(Float.valueOf(penalty));
			
			/*
			 * Hidden properties
			 */
			Element hiddenElement = DomAccess.getElement(questionElement, "hidden");
			String hidden = DomAccess.getElementValue(hiddenElement);
			// Add a value of hidden
			if(hidden.equals("1"))
				genericQuestion.setIsHidden(true);
			else
				genericQuestion.setIsHidden(false);

		} catch (InvalidQuizFormatException e) {
			e.printStackTrace();
		}	
		return genericQuestion;
	}
}
