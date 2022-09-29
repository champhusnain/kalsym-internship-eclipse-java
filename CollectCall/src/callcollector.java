import java.util.Scanner;

public class callcollector {
	
	 public static void main(String[] args) 
	 		{
		  // TODO Auto-generated method stub
		  GuruThread3 threadguru1 = new GuruThread3("Call Connected");
		  threadguru1.start();
		  //GuruThread3 threadguru2 = new GuruThread3("guru2");
		  //threadguru2.start();
		 }
	 
		}

class GuruThread3 implements Runnable {
		 Thread guruthread;
		 private String guruname;
		 GuruThread3(String name) {
		  guruname = name;
		 }
		 
		 @Override
		 public void run() {
	Scanner sc= new Scanner(System.in); 
		System.out.println("Press 5 to Hangup the call or anyother number to continue:\n");
			   int l = sc.nextInt();
			   if(l==5) {
				   System.out.println("Call Hanged Up");
			   }
			 
			   else {
		System.out.println("Please press the following to proceed:\n 2: Permission to pay for the call\n 3: Reject Permission to pay");
		
		
		   
		int j = sc.nextInt();
		if (j==2) { 
		  //System.out.println("Thread running " + guruname);
		  //for (int i = 0; i < 4; i++) {
		   //System.out.println(i);
		   System.out.println(guruname);
		   
		   try {
		    Thread.sleep(1000);
		   } catch (InterruptedException e) {
		    System.out.println("Thread has been interrupted");
		   }
		   System.out.println("Press 5 to Hangup the call:\n");
		   int k = sc.nextInt();
		   if(k==5) {
			   System.out.println("Call Hanged Up");
		   }
		  }//
		if (j==3) {
			System.out.println("Permission denied! Call Hanged Up");
		 
		 }}
		
		 }
		 
		 public void start() {
		  System.out.println("Call Picked");
		  if (guruthread == null) {
		   guruthread = new Thread(this, guruname);
		   guruthread.start();
		  }
		  
		 }
		}