package day22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Thread1{
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        Runnable work = ()-> {
            try{
                for (int i = 0; i< 5; i++) {
                    System.out.println("작업 스레드 : " + i);
                    Thread.sleep(1000);
                    }
                }catch (InterruptedException e) {
                }
            exec.shutdown();
            };

        exec.submit(work);

        int alphabet = 'a';
        while (!exec.isShutdown()){        //작업 스레드가 살아있는 동안
             System.out.print("메인 스레드 : ");
             System.out.println((char) (alphabet));
             alphabet++;
             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 System.out.println("오류 발생");
             }
         }exec.shutdown();
    }
}