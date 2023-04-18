public class MyThread  extends  Thread{
     private  int num;
    MyThread(int num){
         this.num=num;
    }
     public  void  run(){

          int cnt=0;
          while (cnt<5){
              String str = String.format("iteration - %d:   %d",cnt+1,this.num);
              System.out.println(str);
              try {
                    Thread.sleep(3000);
              }
              catch (Exception e){
                  System.out.println("error");
              }
              cnt++;
          }
     }
}
