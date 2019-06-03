package com.PayPay.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ImmutableQueueTests {

	public List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
	public ImmutableQueue<Integer> queue;

	@BeforeEach
	public void prepareInput() {
		queue = new ImmutableQueue<>(list);
	}

	@Test
	void enQueueTest() {
		ImmutableQueue<Integer> newQ = queue.enQueue(5);
		Assertions.assertEquals(new ImmutableQueue<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))), newQ);
	}

	@Test
	void deQueueTest() {
		ImmutableQueue<Integer> newQ = queue.deQueue();
		Assertions.assertEquals(new ImmutableQueue<>(new ArrayList<>(Arrays.asList(2, 3, 4))), newQ);
	}

	@Test
	void headTest() {
		Integer a = queue.head();
		Assertions.assertEquals(1, a);
	}

	@Test
	void isEmptyTest() {
		Assertions.assertFalse(queue.isEmpty());
	}

	@Test
	void headExceptionTest() {
		ImmutableQueue<Integer> qQueue = new ImmutableQueue<>();
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> qQueue.head());
	}

	@Test
	void deQueueExceptionTest() {
		ImmutableQueue<Integer> qQueue = new ImmutableQueue<>();
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> qQueue.deQueue());
	}

	@Test
	void enQueueExceptionTest() {
		ImmutableQueue<Integer> qQueue = null;
		Assertions.assertThrows(NullPointerException.class, () -> qQueue.enQueue(1));
	}

}
