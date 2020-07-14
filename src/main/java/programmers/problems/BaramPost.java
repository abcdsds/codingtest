package programmers.problems;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class BaramPost implements Runnable{

	private String name;
	
	BaramPost(String name) {
		this.name = name;
	}
	public static void main(String[] args) throws ClientProtocolException, IOException {

		String[] a = {"블랙" , "보스" , "보겸" ,  "바다" , "비밀" ,  "뽀삐" , "본좌" , "부여" , "비비" , "부활", "반지"};
		
		int y = 0;
		for (int i=0; i<1000; i++) {
			
			Thread thread = new Thread(new BaramPost(a[y]));
			thread.start();
			System.out.println(a[y]);
			if (y == a.length-1) {
				y = 0;
			} else {
				y++;
			}

			
		}	
		
	
	}

	public static void post(String id) throws ClientProtocolException, IOException {

		InputStream is = null;

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("https://baram.nexon.com/E200709/GetReseve");

		httppost.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		httppost.setHeader("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
		httppost.setHeader("Connection", "keep-alive");
		 httppost.setHeader("Content-Type", "application/json; charset=UTF-8");
		// charset=UTF-8");
		// httppost.setHeader("Host", "sumnacare.com");
		httppost.setHeader("X-Requested-With", "XMLHttpRequest");
		httppost.setHeader("Origin", "https://baram.nexon.com");
		httppost.setHeader("Cache-Control", "max-age=0");
		httppost.setHeader("Cookie", "cookie");
		httppost.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
		httppost.setHeader("Referer", "https://baram.nexon.com/E200709/Event");

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();


		JSONObject json = new JSONObject();
		json.put("nm", id);
		
		StringEntity stringEntity = new StringEntity(json.toString(), "utf-8");
		httppost.setEntity(stringEntity);
		HttpEntity entity = client.execute(httppost).getEntity();
		System.out.println(EntityUtils.toString(entity));

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<2; i++) {
			try {
				post(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
