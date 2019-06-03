package com.PayPay.queue;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ImmutableQueue<T> implements Queue<T>{

	private final List<T> queue;

	public ImmutableQueue() {
		this.queue = new ArrayList<T>();
	}

	public ImmutableQueue(List<T> queue) {
		this.queue = new ArrayList<T>(queue);
	}

	public ImmutableQueue (ImmutableQueue<T> original) {
		this(original.queue);
	}

	@Override
	public ImmutableQueue<T> enQueue(T t) {
		if (t != null) {
			this.queue.add(t);
			return new ImmutableQueue<T>(this.queue);
		}
		throw new NullPointerException();
	}

	@Override
	public ImmutableQueue<T> deQueue() {
		if (this.queue.isEmpty()) {
			System.out.println("Queue is Empty");
			throw new IndexOutOfBoundsException();
		}
		else {
			return new ImmutableQueue<T>(this.queue.subList(1, this.queue.size()));
		}
	}

	@Override
	public T head() {
		if (this.queue.isEmpty()) {
			System.out.println("Queue is Empty");
			throw new IndexOutOfBoundsException();
		}
		else {
			return this.queue.get(0);
		}
	}

	@Override
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	@Override
	public String toString() {
		return "ImmutableQueue " +
				"= " + queue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ImmutableQueue<?> that = (ImmutableQueue<?>) o;
		return Objects.equals(queue, that.queue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(queue);
	}
}
