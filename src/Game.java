import java.io.*;


public class Game {
	private GameStatus status;
	
	
	private void displayFirstMessage()
	{
		String firstMessage = "Hello, welcome to Notches. Would you like to create a new game or load a saved game? Type create or load.";
		System.out.println(firstMessage);
	}
	
	private void displayHomeMessage()
	{
		
	}
	
	private String getInput() 
	{
		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(r);
		
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public GameStatus getStatus()
	{
		return this.status;
	}
	
	public void Play()
	{
		displayFirstMessage();
		System.out.println(getInput());
	}
	
	
}
