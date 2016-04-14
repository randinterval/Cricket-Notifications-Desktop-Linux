package randinterval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class CricketAPI {

	private URL apiurl;
	private ArrayList <Match> matches;

	CricketAPI(){
		matches = new ArrayList<Match>();
		try {
			this.apiurl = new URL("http://cricscore-api.appspot.com/csa");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void getMatches(){
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(apiurl.openStream(), Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray matchesArray = new JSONArray(jsonText); 
			for(int i=0;i<matchesArray.length();i++){
				JSONObject matchobj = matchesArray.getJSONObject(i);
				Match m = new Match();
				m.setId(String.valueOf(matchobj.get("id")));
				m.setT1((String) matchobj.get("t1"));
				m.setT2((String) matchobj.get("t2"));
				this.matches.add(m);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void getStatus(){
		
		for(int i=0;i<this.matches.size();i++){
			try {
				URL url = new URL("http://cricscore-api.appspot.com/csa?id="+this.matches.get(i).getId());
				BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
				String jsonText = readAll(rd);
				if(jsonText==null || jsonText.equals("") || jsonText.equals("null"))
					continue;
				JSONArray matchesArray = new JSONArray(jsonText); 					
				JSONObject matchobj = matchesArray.getJSONObject(0);
				Match m = this.matches.get(i);
				m.setStatus(matchobj.getString("si")+"\n"+matchobj.getString("de"));
				this.matches.set(i, m);
				rd.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void notifyStatus(){
		for(int i=0;i<this.matches.size();i++){
			System.out.println(this.matches.get(i).getStatus());
			String[] cmd = { "/usr/bin/notify-send","-t","6000",this.matches.get(i).getStatus()};
		    try {
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    try {
				Thread.sleep(6500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
	public void clearMatches(){
		this.matches.clear();
	}



}
