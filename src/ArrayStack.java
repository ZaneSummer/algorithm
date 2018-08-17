public class ArrayStack {
    private Integer[] arr;
    private Integer end;

    public ArrayStack(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("the maxsize less than 0");
        }
        arr = new Integer[maxSize];
        end = 0;
    }

    public void push(Integer num) {
        if (end >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        arr[end++] = num;
    }

    public Integer peek() {
        if (end <= 0) {
            return null;
        }
        return arr[end-1];
    }
     public Integer pop() {
        if (end < 0) {
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        return arr[--end];
    }



}
