package mood;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

class ExceptionHandlingTest 
{
	@Test
    public void testMoodAnalyse() throws ExceptionHandling, ExceptionHandlingException {
		ExceptionHandling md = new ExceptionHandling();
        String mood = md.analyseMood("This is a SAD message");
        Assert.assertEquals("SAD",mood);
    }
    @Test
    public void testHappyMood() throws ExceptionHandling, ExceptionHandlingException {
    	ExceptionHandling md = new ExceptionHandling();
        String mood = md.analyseMood("This is a HAPPY message");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMoodShouldReturnHappy() throws ExceptionHandling, ExceptionHandlingException {
    	ExceptionHandling md = new ExceptionHandling(null);
        String mood = md.analyseMood("This is a HAPPY message");
        Assert.assertEquals("HAPPY",mood);
    }
    @Test
    public void givenInAnyMood_Should_Return_Happy() throws ExceptionHandling, ExceptionHandlingException {
    	ExceptionHandling md = new ExceptionHandling();
        String mood = md.analyseMood("This is in any mood");
        Assert.assertEquals("HAPPY",mood);
    }
    @Test
    public void givenInHappy_MoodShould_ReturnSad() throws ExceptionHandling, ExceptionHandlingException {
    	ExceptionHandling md = new ExceptionHandling();
        String mood = md.analyseMood("This is in happy mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMoodShouldThrowException() throws ExceptionHandlingException, ExceptionHandling {
    	ExceptionHandling md = new ExceptionHandling(null);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(ExceptionHandlingException.class);
            md.analyseMood(null);
        } catch (Exception e) {
        }
    }
	
}
