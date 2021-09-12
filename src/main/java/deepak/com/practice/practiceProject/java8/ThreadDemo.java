package deepak.com.practice.practiceProject.java8;

public class ThreadDemo {
	static  int count = 3;
	static Object obj = new Object();

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(()-> {
			System.out.println(sum(1,2));
		});
		
		Thread t2 = new Thread(()-> {
			System.out.println(sum(3,4));
		});
		
		t1.start();
		t1.join();
		t2.start();
		
		
		

	}

	 private static int sum(int i,int j) {
		int sum = 0;
		synchronized (obj) {
			  sum = count+i+j;
				count++;
		}
		
		return sum;
		
	}

}
