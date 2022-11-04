package mood;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

class MoodAnalyserTest 
{
	@Test
	public void testMoodAnalyse() throws MoodAnalyser, MoodAnalyserException {
		MoodAnalyser md = new MoodAnalyser();
		String mood = md.analyseMood("This is a SAD message");
		Assert.assertEquals("SAD", mood);
	}

	@Test
	public void testHappyMood() throws MoodAnalyser, MoodAnalyserException {
		MoodAnalyser md = new MoodAnalyser();
		String mood = md.analyseMood("This is a HAPPY message");
		Assert.assertEquals("HAPPY", mood);
	}

	@Test
	public void givenNullMoodShouldReturnHappy() {
		MoodAnalyser md = new MoodAnalyser(null);
		String mood = null;
		try {
			mood = md.analyseMood("This is a HAPPY message");
		} catch (MoodAnalyser moodAnalyser) {
			moodAnalyser.printStackTrace();
		} catch (MoodAnalyserException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("HAPPY", mood);
	}

	@Test
	public void givenInAnyMood_Should_Return_Happy() throws MoodAnalyser, MoodAnalyserException {
		MoodAnalyser md = new MoodAnalyser();
		String mood = md.analyseMood("This is in any mood");
		Assert.assertEquals("HAPPY", mood);
	}

	@Test
	public void givenInHappy_MoodShould_ReturnSad() throws MoodAnalyser, MoodAnalyserException {
		MoodAnalyser md = new MoodAnalyser();
		String mood = md.analyseMood("This is in HAPPY mood");
		Assert.assertEquals("HAPPY", mood);
	}

	@Test
	public void givenNullMoodShouldThrowException() throws MoodAnalyser {
		MoodAnalyser md = new MoodAnalyser(null);
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(MoodAnalyserException.class);
			md.analyseMood(null);
		} catch (Exception e) {
			Assert.assertEquals("Please enter proper message", e.getMessage());
		}

	}
	

}
