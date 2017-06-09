package com.hust.coapexample;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.StringTokenizer; 

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.Utils;

public class App {
	public static void main(String[] args) {
		// URI uri=null;
		// // input URI from command line arguments
		// try {
		// uri = new URI("coap://[fd00::c30c:0:0:3]:5683/sensors/battery");
		// } catch (URISyntaxException e) {
		// System.err.println("Invalid URI: " + e.getMessage());
		// System.exit(-1);
		// }
		//
		// CoapClient client = new CoapClient(uri);
		//
		// CoapResponse response = client.get();
		//
		// if (response!=null) {
		//
		// System.out.println(response.getCode());
		// System.out.println(response.getOptions());
		// System.out.println(response.getResponseText());
		//
		// System.out.println("\nADVANCED\n");
		// // access advanced API with access to more details through
		// .advanced()
		// System.out.println(Utils.prettyPrint(response));
		//
		// } else {
		// System.out.println("No response received.");
		// }

		CoapClient client = new CoapClient(
				"coap://[fd00::c30c:0:0:2]:5683/test/push");
//		CoapResponse response;
//		response = client.get();
//		System.out.println(response.getResponseText());
//		String dataString = response.getResponseText();
//		
//        
//        String flag="";
//  String tem="";
//    String light="";
//       String moisutre="";
//       int temValue=0,lightValue = 0,moisutreValue=0,flagValue=0,flag1=-1,flag2=-1,flag3=-1;
//       
//       String[] words = dataString.split("\\D");
//
//       
//             flag = words[0];
//          flagValue = Integer.parseInt(flag);
//        tem = words[1];
//        
//        light = words[2];
//        
//        moisutre = words[3];
//        moisutreValue = Integer.parseInt(moisutre);
//       if(flagValue%2 == 1) flag3 = 1;
//       flagValue /=2;
//       if(flagValue%2 == 1) flag2 = 1;
//       flagValue /=2;
//       if(flagValue%2 == 1) flag1 = 1;
//
//       temValue = Integer.parseInt(tem)*flag1+2000;
//       lightValue = Integer.parseInt(light)*flag2+4400;
//        moisutreValue = Integer.parseInt(moisutre)*flag3+3800;
//        
//                
//       System.out.print("---------------\n");
//       System.out.printf("temperature: %d\n",temValue);
//               System.out.printf("light: %d\n",lightValue);
//       System.out.printf("moisutre: %d\n",moisutreValue);

//
		
		CoapObserveRelation relation = client.observe(new CoapHandler() {

			@Override
			public void onLoad(CoapResponse response) {
				
				
				
				String dataString = response.getResponseText();
				
		        
		        String flag="";
		  String tem="";
		    String light="";
		       String moisutre="";
		       int temValue=0,lightValue = 0,moisutreValue=0,flagValue=0,flag1=-1,flag2=-1,flag3=-1;
		       
		       String[] words = dataString.split("\\D");

		       
		             flag = words[0];
		          flagValue = Integer.parseInt(flag);
		        tem = words[1];
		        
		        light = words[2];
		        
		        moisutre = words[3];
		        moisutreValue = Integer.parseInt(moisutre);
		       if(flagValue%2 == 1) flag3 = 1;
		       flagValue /=2;
		       if(flagValue%2 == 1) flag2 = 1;
		       flagValue /=2;
		       if(flagValue%2 == 1) flag1 = 1;

		       temValue = Integer.parseInt(tem)*flag1+2000;
		       lightValue = Integer.parseInt(light)*flag2+4400;
		        moisutreValue = Integer.parseInt(moisutre)*flag3+3800;
		        
		                
		       System.out.print("---------------\n");
		       System.out.println(response.getResponseText());
		       System.out.printf("temperature: %d\n",temValue);
		               System.out.printf("light: %d\n",lightValue);
		       System.out.printf("moisutre: %d\n",moisutreValue);
				
			}

			@Override
			public void onError() {
				System.err.println("Failed");
			}
		});
		try {
			while(true)
				Thread.sleep(6 * 1000);
		} catch (InterruptedException e) {
		}
		System.out.println("---------------\nCancel Observe");
		relation.reactiveCancel();

	}
}
