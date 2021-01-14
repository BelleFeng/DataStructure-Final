import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;
	
   
	public WebPage(String url,String name) throws IOException{
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);
		
		URL Url = new URL(url);
		HttpURLConnection conn = null;
		conn = (HttpURLConnection) Url.openConnection();
	    conn.setDoOutput(true);
	    conn.setUseCaches(false);
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("User-agent","Mozilla/5.0");
	    conn.setRequestProperty("Content-Type", "text/plain"); 
	    conn.setRequestProperty("charset", "utf-8");
	    conn.connect();
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
		score = 0;
		int i =0;
		for(Keyword k : keywords){		
			score += k.weight*counter.countKeyword(k.name).get(i);	
			i++;
		}
	}
	
}