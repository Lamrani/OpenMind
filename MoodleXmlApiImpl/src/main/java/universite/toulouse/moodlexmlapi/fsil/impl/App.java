package universite.toulouse.moodlexmlapi.fsil.impl;

import universite.toulouse.moodlexmlapi.core.data.QuestionError;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        QuestionError questionError = new QuestionError("type not supported", "the question type is not supported");
        System.out.println(questionError.getDescription());
    }
}
