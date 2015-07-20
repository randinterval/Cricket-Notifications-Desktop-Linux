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
				Thread.sleep(180000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
