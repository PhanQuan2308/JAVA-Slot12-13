package bank.t2108a;

import java.util.concurrent.locks.ReentrantLock;

public class IdGenerate {
    private static Long id = 0L;
    private static ReentrantLock lock = new ReentrantLock();
    public static Long getNewID(){
        Long result;
        lock.lock();

        try {
            result = ++id;

        }finally {
            lock.unlock();
        }
        return  result;
    }
    private IdGenerate(){

    }
}
