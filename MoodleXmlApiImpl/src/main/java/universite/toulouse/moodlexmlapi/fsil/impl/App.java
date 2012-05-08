package universite.toulouse.moodlexmlapi.fsil.impl;

import org.jdom.Document;

import universite.toulouse.moodlexmlapi.core.data.QuestionError;
import universite.toulouse.moodlexmlapi.openmind.xml.Singleton;
import universite.toulouse.moodlexmlapi.openmind.xml.manager.QuizManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // Create a singleton
        Singleton xml = Singleton.getInstance();
        // Obtains a document instance
        Document document = xml.open("quiz.xml");
        // Create a manager instance
        new QuizManager(document);
        
        QuestionError questionError = new QuestionError("type not supported", "the question type is not supported");
        System.out.println(questionError.getDescription());
    }
}
