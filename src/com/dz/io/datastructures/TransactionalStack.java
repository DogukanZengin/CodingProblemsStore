package com.dz.io.datastructures;

import java.util.ArrayDeque;

public class TransactionalStack {

    private ArrayDeque<Integer> content;
    private ArrayDeque<TransactionalStack> transactions;

    private TransactionalStack() {
        content = new ArrayDeque<>();
        transactions = new ArrayDeque<>();
        transactions.push(this);
    }

    public void push(int value) {
        transactions.peek().content.push(value);
    }

    public int top() {
        return transactions.peek().content.isEmpty() ? 0 : transactions.peek().content.peek();
    }

    public int pop() {
        return transactions.peek().content.isEmpty() ? 0 : transactions.peek().content.pop();
    }

    public void begin() {
        transactions.add(new TransactionalStack());
    }

    public boolean rollback() {
        TransactionalStack lastTransaction = transactions.peek();
        if (lastTransaction != this) {
            transactions.pop();
            return true;
        }
        return false;
    }

    public boolean commit() {
        TransactionalStack lastTransaction = transactions.peek();
        if (lastTransaction != this) {
            lastTransaction = transactions.pop();
            while(!lastTransaction.content.isEmpty()){
                transactions.peek().push(lastTransaction.content.poll());
            }
            return true;
        }
        return false;
    }

    public static void main(String[] as) {
        TransactionalStack sol = new TransactionalStack();
        sol.push(4);
        sol.begin();                    // start transaction 1
        sol.push(7);                    // stack: [4,7]
        sol.begin();                    // start transaction 2
        sol.push(2);                    // stack: [4,7,2]
        System.out.println(sol.rollback());// == true;  // rollback transaction 2
        System.out.println(sol.top());// == 7;          // stack: [4,7]
        sol.begin();                    // start transaction 3
        sol.push(10);                   // stack: [4,7,10]
        System.out.println(sol.commit());// == true;    // transaction 3 is committed
        System.out.println(sol.top()); //== 10;
        System.out.println(sol.rollback());// == true;  // rollback transaction 1
        System.out.println(sol.top());// == 4;          // stack: [4]
        System.out.println(sol.commit());// == false;   // there is no open transaction
    }
}
