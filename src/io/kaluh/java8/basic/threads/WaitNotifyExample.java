package io.kaluh.java8.basic.threads;

/**
 * http://www.baeldung.com/java-wait-notify
 * 
 * One tool we can use to coordinate actions of multiple threads in Java – is
 * guarded blocks. Such blocks keep a check for a particular condition before
 * resuming the execution.
 * 
 * With that in mind, we’ll make use of:
 * 
 * Object.wait() – to suspend a thread
 * 
 * Object.notify() – to wake a thread up
 * 
 * Thread lide cycle:
 * 
 * New (admitted) -> Runnable
 * 
 * Runnable (scheduler dispatcher) -> Running
 * 
 * Running (interrupt) -> Runnable
 * 
 * Running (wait) -> Non runnable
 * 
 * Non runnable (notify) -> Runnable
 * 
 * Running (exit) -> Terminated
 * 
 * wait() -> when we call wait() – this forces the current thread to wait until
 * some other thread invokes notify() or notifyAll() on the same object. For
 * this, the current thread must own the object’s monitor. According to
 * Javadocs, this can happen when:
 * 
 * we’ve executed synchronized instance method for the given object we’ve
 * executed the body of a synchronized block on the given object by executing
 * synchronized static methods for objects of type Class
 * 
 * The notify() method is used for waking up threads that are waiting for an
 * access to this object’s monitor.
 * 
 * there may be some situations where the thread got woken up without receiving
 * a notification (this scenario is discussed later in an example).
 * 
 * @author Z462725
 *
 */
public class WaitNotifyExample {

}
