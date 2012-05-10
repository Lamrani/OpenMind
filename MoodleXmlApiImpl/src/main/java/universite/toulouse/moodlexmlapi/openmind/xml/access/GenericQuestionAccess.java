package universite.toulouse.moodlexmlapi.openmind.xml.access;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.CategoryQuestion;
import universite.toulouse.moodlexmlapi.core.data.GenericQuestion;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
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
			String typeElement =  DomAccess.getAttributtValue(questionElement, "type");
			// Checking and add a value of type
			if(QuestionType.values().equals(typeElement)){
				genericQuestion.setQuestionType(QuestionType.valueOf(typeElement));
			}
		} catch (InvalidQuizFormatException e) {
			e.printStackTrace();
		}	
		return genericQuestion;
	}
}
