package practice;

/**
 * 임의의 객체형 데이터를 쌓을수 있는 제네릭 스택 클래스작성
 *
 * @param <E>
 */
public class MyStack<E> {
    private int max = 10;//스택 용량
    private int ptr = 0;//스택 포인터
    private E[] stk = (E[]) new Object[max];//스택 본체

    //size
    public int size() {
        return ptr;
    }

    //capacity
    public int capacity() {
        return stk.length;
    }

    //push
    public void push(E item) {
        if (ptr < max) {
            stk[ptr] = item;
            ptr++;
        } else {
            throw new ArrayIndexOutOfBoundsException("MyStack is over capacity, max : " + max + ", current : " + ptr);
        }
    }

    //pop
    public E pop() {
        E result = stk[ptr-1];
        stk[ptr-1] = null;
        ptr--;
        return result;
    }

    //peek
    public E peek() {
        return stk[ptr-1];
    }

    //dump
}
