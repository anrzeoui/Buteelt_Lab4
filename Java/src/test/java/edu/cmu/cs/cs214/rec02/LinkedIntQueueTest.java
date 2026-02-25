package edu.cmu.cs.cs214.rec02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class LinkedIntQueueTest {
    private IntQueue mQueue;

    @Before
    public void setUp() {
        mQueue = new LinkedIntQueue();
    }

    @Test
    public void testNewQueueIsEmpty() {
        assertTrue(mQueue.isEmpty());
        assertEquals(0, mQueue.size());
    }

    @Test
    public void testEnqueueAndDequeue() {
        mQueue.enqueue(10);
        mQueue.enqueue(20);
        
        assertEquals(Integer.valueOf(10), mQueue.dequeue());
        assertEquals(Integer.valueOf(20), mQueue.dequeue());
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testPeekReturnsHeadWithoutRemoving() {
        mQueue.enqueue(50);
        assertEquals(Integer.valueOf(50), mQueue.peek());
        assertEquals(1, mQueue.size()); 
    }

    @Test
    public void testDequeueEmptyQueueReturnsNull() {
        assertNull(mQueue.dequeue());
    }

    @Test
    public void testClearRemovesAllElements() {
        mQueue.enqueue(1);
        mQueue.enqueue(2);
        mQueue.clear();
        
        assertTrue(mQueue.isEmpty());
        assertEquals(0, mQueue.size());
        assertNull(mQueue.peek());
    }

    @Test
    public void testLargeNumberOfElements() {
        for (int i = 0; i < 1000; i++) {
            mQueue.enqueue(i);
        }
        assertEquals(1000, mQueue.size());
        for (int i = 0; i < 1000; i++) {
            assertEquals(Integer.valueOf(i), mQueue.dequeue());
        }
        assertTrue(mQueue.isEmpty());
    }
    
}
