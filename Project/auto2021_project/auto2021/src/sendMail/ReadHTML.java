package sendMail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadHTML {
	public static String reMailString(){
		//String info="";
		StringBuffer buff=new StringBuffer();
		InputStreamReader in=null;
		BufferedReader br=null;
//		获取存放html文件的路径?
		String path = System.getProperty("user.dir") + "/src/report.html";
//		进行文件内容的读取
		File file=new File(path);
		try {
			in=new InputStreamReader(new FileInputStream(file));
			br=new BufferedReader(in);
			String line=null;
			while((line=br.readLine()) != null){
				//System.out.println(line);
				buff.append(line).append("\n");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return buff.toString();
	}
}
