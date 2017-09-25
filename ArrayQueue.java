

public class ArrayQueue implements Queue {
	
	public Object[] arr;
	public int head;
	public int tail;
	@Override
	public Object dequeue() {

		if(empty()) {
			return null;
		}
		Object item = arr[head];
		head++;
		if(head == arr.length) {
			head = 0;
		}
//		System.out.println(item);
		return item;
	}

	@Override
	public void enqueue(Object item) {
//		System.out.println(full());
		if(full()) {
//			System.out.println("here");
			growQueue();
		}
//		System.out.println("here===");
		arr[tail++] = item;
		if(tail == arr.length) {
			tail = 0;
		}

	}

	private void growQueue() {

		Object[] new_arr = new Object[arr.length*2];
		if(tail < head) {
			System.arraycopy(arr, head, new_arr, 0, arr.length-head);
			System.arraycopy(arr, 0, new_arr, arr.length-head, tail);
			tail = (arr.length-head)+tail;
			head = 0;
			arr = new_arr;
			return;
//			System.out.println("here");
		}
		System.arraycopy(arr, 0, new_arr, 0, tail);
		arr = new_arr;
//		System.out.println("here");
//		Arrays.toString(arr);
	}

	private boolean full() {
//		System.out.println(" 1st here");
//		System.out.println((tail+1) %arr.length ) ;
		if((tail+1) % arr.length == head) {
//			System.out.println(" true here:");
			return true;
		}
//		System.out.println("false here");
		return false;
//		System.out.println("here");
	}

	@Override
	public boolean empty() {

		if(head == tail) {
			return true;
		}
		return false;
	}
	
	public ArrayQueue() {
		
		arr = new Object[10];
		this.head = 0;
		this.tail = 0;
	}

}
