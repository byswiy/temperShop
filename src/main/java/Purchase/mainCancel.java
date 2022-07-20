package Purchase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class mainCancel {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://api.iamport.kr/users/getToken");
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type","applicaiton/json;utf-8");
			con.setRequestProperty("Accept","application/json");
			con.setDoOutput(true);
			
			String jsonInputString = "{\"imp_key\":\"5281340698219713\",\"imp_secret\":\"b8b15790c56d63aa02f7cd17605f81c9eb46325c039a1f6cb44e188a3ab1a11f5ca19b12e1c4815e\"}";
			
			
			try(OutputStream os = con.getOutputStream()){
				byte[] input = jsonInputString.getBytes("utf-8");
			    	os.write(input, 0, input.length);
			}
			
			try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"))){
				StringBuilder response = new StringBuilder();
			    String responseLine = null;
			    while((responseLine = br.readLine()) != null) {
			    	response.append(responseLine.trim());
			    }
			    System.out.println(response.toString());
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
