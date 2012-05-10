package universite.toulouse.moodlexmlapi.openmind.xml.access;


import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.CategoryQuestion;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;

public class CategoryQuestionAccess {
	
	/**
	 * Get a category of question and course value
	 * @return an instance of category question
	 */
	public static CategoryQuestion getCategoryQuestion(){
		
		CategoryQuestion categoryQuestion = new CategoryQuestion();
		
		try {
			Element quizElement = DomAccess.getRootElement("quiz");
			Element questionElement = DomAccess.getElement(quizElement, "question");
			String typeElement =  DomAccess.getAttributtValue(questionElement, "type");
			// Checking and add a value of type
			if(QuestionType.values().equals(typeElement)){
				categoryQuestion.setCategory(typeElement);
			}
			Element categoryElement = DomAccess.getElement(questionElement, "category");
			Element textElement = DomAccess.getElement(categoryElement, "text");
			// Add a value of course
			String course =  DomAccess.getElementValue(textElement);
			categoryQuestion.setCourse(course);
		} catch (InvalidQuizFormatException e) {
			e.printStackTrace();
		}
		return categoryQuestion;
	}
}
