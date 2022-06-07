package threadpool;

/**
 * ThreadTask is used to perform tasks.
 * @author Divya Razmi
 *
 */
class ThreadTask{
	public synchronized void execute(){
		System.out.println(Thread.currentThread().getName() + " : Thread excecuted");	
	}
}

/**
 * MainThreadPool class is used to execute the ThreadTask using CustomFixedThreadPool
 */
public class MainThreadPool {

	public static void main(String[] args) {
		CustomFixedThreadPool customFixedThreadPool = new CustomFixedThreadPool(4);
		ThreadTask threadCustomTask = new ThreadTask();
		for (int i = 0; i < 10; i++) {
			customFixedThreadPool.execute(threadCustomTask);
		}
	}
}
