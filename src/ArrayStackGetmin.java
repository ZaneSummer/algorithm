public class ArrayStackGetmin {
    private ArrayStack arr;
    private ArrayStack minDatas;

    public ArrayStackGetmin(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("the maxsize less than 0");
        }
        arr = new ArrayStack(maxSize);
        minDatas = new ArrayStack(maxSize);
    }

    public void push(Integer num) {
        arr.push(num);
        if (null == minDatas.peek())
            minDatas.push(num);
        else
            minDatas.push(num > minDatas.peek() ? minDatas.peek() : num);
    }

    public Integer peek() {
        return arr.peek();
    }

    public Integer pop() {
        minDatas.pop();
        return arr.pop();
    }

    public int getMin() {
        return minDatas.peek();
    }

    public static void main(String[] args) {
        ArrayStackGetmin asg = new ArrayStackGetmin(3);

        asg.push(2);
        asg.push(4);
        asg.push(1);

        CommonUtils.print(asg.getMin() + "");
        asg.pop();
        CommonUtils.print(asg.getMin() + "");
        asg.pop();
        CommonUtils.print(asg.getMin() + "");

    }

}
