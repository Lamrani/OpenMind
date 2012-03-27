package universite.toulouse.moodlexmlapi.core;

import java.util.List;

/**
 * Interface representing a Moodle question
 * @author fsil
 *
 */
public interface Question {
	
	public QuestionType getQuestionType();
	public String getName();
	
	public List<QuestionError> getErrors();

}
