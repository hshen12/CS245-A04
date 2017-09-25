
public class ArrayStack implements Stack {

	
	public Object[] arr;
	public int top;
	
	@Override
	public void push(Object item) {

		
		if(top == arr.length) {
			growStack();
		}
		
		arr[top++] = item;
		
	}

	private void growStack() {
		Object[] new_arr = new Object[arr.length*2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;
	}

	@Override
	public Object pop() {
		if(empty()) {
			return null;
		}
		return arr[--top];
		
	}

	@Override
	public Object peek() {
		if(empty()) {
			return null;
		}
		
		return arr[top-1];
	}

	@Override
	public boolean empty() {

		if(top == 0) {
			return true;
		}
		return false;
	}
	
	public ArrayStack() {
		arr = new Object[10];
		top = 0;
	}

}
