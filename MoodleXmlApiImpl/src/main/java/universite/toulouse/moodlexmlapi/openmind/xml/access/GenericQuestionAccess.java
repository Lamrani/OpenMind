package universite.toulouse.moodlexmlapi.openmind.xml.access;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.CategoryQuestion;
import universite.toulouse.moodlexmlapi.core.data.GenericQuestion;
import universite.toulouse.moodlexmlapi.core.data.QuestionText;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import universite.toulouse.moodlexmlapi.core.data.QuestionTextFormat;
import universite.toulouse.moodlexmlapi.openmind.xml.GenericQuestionEntity;

public class GenericQuestionAccess {

	/**
	 * Get a category of question and course value
	 * @return an instance of category question
	 */
	public static GenericQuestion getGenericQuestion(){
		
		GenericQuestion genericQuestion = new GenericQuestionEntity();
		
		try {
			Element quizElement = DomAccess.getRootElement("quiz");
			Element questionElement = DomAccess.getElement(quizElement, "question");
			
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
		} catch (InvalidQuizFormatException e) {
			e.printStackTrace();
		}	
		return genericQuestion;
	}
}
