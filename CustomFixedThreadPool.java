package threadpool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CustomFixedThreadPool class is used to customise the thread.
 * @author Divya Razmi
 *
 */
public class CustomFixedThreadPool {
	public int FIXED_COUNT;
	AtomicInteger TASK_COUNT = new AtomicInteger(1);
	int[] taskArray; 

	CustomFixedThreadPool(int fixedCount){
		this.FIXED_COUNT = fixedCount;
		taskArray = new int[FIXED_COUNT];
		for(int i = 0; i < taskArray.length; i++) {
			taskArray[i] = i;
		}
	}

	/**
	 * execute method will call the task based on the thread availability. 
	 * @param threadCustomTask
	 */
	public void execute(ThreadTask threadCustomTask){
		// taskArray[TASK_COUNT.get()-1] = TASK_COUNT.get()-1;
		// insert the thread value into an array
		Thread thread = new Thread( new Runnable() {
			public void run() {
				if(TASK_COUNT.get() > FIXED_COUNT) {
					TASK_COUNT.set(1);
					threadCustomTask.execute();
					taskArray[TASK_COUNT.get()-1] = 0;
				}else {
					threadCustomTask.execute();
					taskArray[TASK_COUNT.get()-1] = 0;
				}
			}
		},"pool-1-thread-"+(TASK_COUNT.incrementAndGet()-1));
		thread.start();
	}

}
