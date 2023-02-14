package day22;


public class Thread1{
    public static void main(String[] args){
        Runnable work = ()-> {
            for (int i = 0; i< 5; i++){
                System.out.println("작업 스레드 : " + i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e) {
                }
            }
        };
       Thread worker =  new Thread(work);
       worker.start();

        int alphabet = 'a';
        while (worker.isAlive()){        //작업 스레드가 살아있는 동안
             System.out.print("메인 스레드 : ");
             System.out.println((char) (alphabet));
             alphabet++;
             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 System.out.println("오류 발생");
             }
         }
    }
}