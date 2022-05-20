package 排程;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.FileUtils;



public class TimerTest02 {
Timer timer;
public TimerTest02(){
Date time = getTime();
//System.out.println("指定時間time="  + time);
timer = new Timer();
timer.schedule(new TimerTasker(), time);
}
public Date getTime(){
Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.HOUR_OF_DAY, 11);
calendar.set(Calendar.MINUTE, 39);
calendar.set(Calendar.SECOND, 00);
Date time = calendar.getTime();
return time;
}
public static void main(String[] args) {
new TimerTest02();


}
	public class TimerTasker extends TimerTask{
		//@Override
		public void run() {
			System.out.println("指定時間執行執行緒任務...");
			String add = downloadFromUrl("https://www.good.nat.gov.tw/regcenter/csv/2022-05-09-new-addressbook.csv","D:");
			String sub = downloadFromUrl("https://www.good.nat.gov.tw/regcenter/csv/2022-05-09-new-subrogation.csv","D:");  
			System.out.println(add+sub);
		}
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