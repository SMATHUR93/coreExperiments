package com.shrek.leetCode._006_Stack;

/**
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 *
 * Hint 1
 * Consider each node in the stack having a minimum value.
 *
 */

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class _054M_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

}


class MinStack {

    public class StackElement{
        int el;
        int minVal;

        public int getEl() {
            return el;
        }

        public int getMinVal() {
            return minVal;
        }

        public StackElement(int el, int minVal) {
            this.el = el;
            this.minVal = minVal;
        }
    }

    Stack<StackElement> minStack;

    public MinStack() {
        this.minStack = new Stack<StackElement>();
    }

    public void push(int val) {
        minStack.push(new StackElement(val, minStack.isEmpty() ? val : Math.min(val, minStack.peek().getMinVal())));
    }

    public void pop() {
        minStack.pop();
    }

    public int top() {
        return minStack.peek().getEl();
    }

    public int getMin() {
        return minStack.peek().getMinVal();
    }
}