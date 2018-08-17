public class ArrayQueue {
    private Integer[] arr;
    private Integer end;
    private Integer start;
    private Integer size;

    public ArrayQueue(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("the maxsize less than 0");
        }
        arr = new Integer[maxSize];
        end = 0;
        start = 0;
        size = 0;
    }

    public void push(Integer num) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        size++;
        arr[end] = num;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public Integer peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        return arr[start];
    }

    public Integer pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        size--;
        int tem = start;
        start = start == arr.length - 1 ? 0 : start + 1;
        return arr[tem];
    }


}
