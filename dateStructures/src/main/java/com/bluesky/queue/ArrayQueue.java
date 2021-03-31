package com.bluesky.queue;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        //创建一个队列
        Queue queue = new Queue(3);
        char key = ' ' ;
        Scanner scanner = new Scanner(System.in);
        boolean loop  = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                       int res =  queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                case 'h':
                    try{
                        int res =  queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                case 'e':
                   scanner.close();
                   loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}

//使用数组模拟队列 - 编写一个ArrayQueue类
class Queue{
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数组用于存放数组，模拟队列

    //创建队列的构造器
    public Queue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1; //指向队列头部，前一个位置
        rear = -1; //指向队列尾，具体位置（即对垒最后一个数据）
    }
    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据~");
        }
        //让rear后移
        rear++;
        arr[rear] = n;
    }
    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列满，不能加入数据~");
        }
        //让front后移
        front++;
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
        }else {
            for(int i = 0;i<arr.length; i++ ){
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
    }
    //显示队列的头数据
    public int headQueue(){
        //判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
