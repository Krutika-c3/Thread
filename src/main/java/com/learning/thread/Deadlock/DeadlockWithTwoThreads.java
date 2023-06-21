package com.learning.thread.Deadlock;


class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
class OneThread implements Runnable{

    private Person person;

    public OneThread(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        synchronized (person.getName()){
            System.out.println(Thread.currentThread().getName() + " : locked resource" + person.getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (person.getAge()){
                System.out.println(Thread.currentThread().getName() + " : locked resource" + person.getAge());
            }
        }
    }
}

class TwoThread implements Runnable{
    private Person person;
    public TwoThread(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        synchronized (person.getAge()){
            System.out.println(Thread.currentThread().getName() + " : locked resource " + person.getAge());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (person.getName()){
                System.out.println(Thread.currentThread().getName() + " : locked resource " + person.getName());
            }
        }
    }
}
public class DeadlockWithTwoThreads {
    public static void main(String[] args) {

        Person person = new Person("anil", 29);

        OneThread oneThread = new OneThread(person);
        Thread thread1 = new Thread(oneThread, "thread1");
        thread1.start();

        TwoThread t2 = new TwoThread(person);
        Thread thread2 = new Thread(t2, "thread2");
        thread2.start();
    }
}
