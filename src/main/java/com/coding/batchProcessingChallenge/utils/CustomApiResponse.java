package com.coding.batchProcessingChallenge.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomApiResponse {
    private Boolean success;

    private String message;


    public CustomApiResponse(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	/*public static void main(String[] args){
		String sDate5 = "Tue Mar 11 07:46:40 +0000 2014";

		String tgt = "2022-02-17 19:50:00";

		//String sDate5 = "Thu, Dec 31 1998 23:37:50";
		//SimpleDateFormat formatter5=new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");

		SimpleDateFormat formatter5=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date date5=formatter5.parse(tgt);
			Date now  = new Date();
			if(now.after(date5)){
				System.out.println("Trigger active");
			}else {
				System.out.println("Trigger wait....");
			}

			System.out.println("Target at:"+date5);

			System.out.println("Now we are:"+now);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}*/

}
