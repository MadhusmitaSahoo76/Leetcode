class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            min.push(val);
        } else {
            st.push(val);
            min.push(Math.min(val, min.peek()));
        }
    }

    public void pop() {
        st.pop();
        min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}