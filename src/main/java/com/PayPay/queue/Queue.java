package com.PayPay.queue;

public interface Queue<T> {
    /*
     * Adds an element at the end of the queue
     */
    public Queue<T> enQueue(T t);
    /*
     * Removes an element at the beginning of the queue
     */
    public Queue<T> deQueue();
    /*
     * Returns the element at the beginning of the queue
     */
    public T head();
    /*
     * Returns true if the queue is empty, false otherwise
     */
    public boolean isEmpty();
}