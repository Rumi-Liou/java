package hash;

import java.io.File;  
import java.net.URL;
import java.util.Timer; 
import java.util.TimerTask;

import org.apache.commons.io.FileUtils; 


public class DownloadURLFile {
	
	

	
		 /** 
	     * @param args 
	     */  
	    public static void main(String[] args) {  
	  
	    	  
	    	long delay = 3000L; // 延遲開始執行的時間（毫秒），延遲3秒
	        long period = 86400000; // 重複的時間（毫秒），間格24H
	        Timer repeatTimer = new Timer(); 
	    
	        class TimerTest extends TimerTask {
	        	public void run() {
	      
	        		for(int i=10;i<32;i++) {
	        		String add = downloadFromUrl("https://www.good.nat.gov.tw/regcenter/csv/2022-05-"+i+"-new-addressbook.csv","D:");
	        		 String sub = downloadFromUrl("https://www.good.nat.gov.tw/regcenter/csv/2022-05-"+i+"-new-subrogation.csv","D:");  
	        		System.out.println(add+sub);
	        	    } 
	        }
	       } 
	        repeatTimer.schedule(new TimerTest(), delay, period);
	    }  
	  
	  
	    public static String downloadFromUrl(String url,String dir) {  
	  
	        try {  
	            URL httpurl = new URL(url);  
	            String fileName = getFileNameFromUrl(url);  
	            System.out.println(fileName);  
	            File f = new File(dir + fileName);  
	            FileUtils.copyURLToFile(httpurl, f);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return "Fault!";  
	        }   
	        return "Successful!";  
	    }  
	      
	    public static String getFileNameFromUrl(String url){  
	        String name = new Long(System.currentTimeMillis()).toString() + ".X";  
	        int index = url.lastIndexOf("/");  
	        if(index > 0){  
	            name = url.substring(index + 1);  
	            if(name.trim().length()>0){  
	                return name;  
	            }  
	        }  
	        return name;  
	    }  
	    
	    

	    }
	    

	

