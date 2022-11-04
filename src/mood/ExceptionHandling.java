package mood;

public class ExceptionHandling extends Throwable 
{
	String message;

    public ExceptionHandling(String message) {
        this.message=message;
    }

    public ExceptionHandling() {

    }
    String ExceptionHandling(){
        return "SAD";
    }

    public String analyseMood(String message) throws ExceptionHandling, ExceptionHandling {
        try {
            if (message.contains("SAD"))
                return "SAD";
            else
                return "HAPPY";
        }catch (NullPointerException e) {
            throw new ExceptionHandling("please enter proper message");
        }
    }
}
