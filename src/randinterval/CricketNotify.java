package randinterval;

public class CricketNotify{
	
	public static void main(String args[]) 
	{
		CricketAPI api = new CricketAPI();
		while(true){
			api.clearMatches();
			api.getMatches();
			api.getStatus();
			api.notifyStatus();
			try {
				//Optimize the Sleep Level
				Thread.sleep(Math.random()*2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
