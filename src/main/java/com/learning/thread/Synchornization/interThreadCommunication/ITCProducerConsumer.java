package com.learning.thread.Synchornization.interThreadCommunication;

class Person{

    int age;
    boolean isValueSet = false;

    public synchronized void getAge() {
        while (!isValueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isValueSet = false;
        System.out.println(Thread.currentThread().getName() + " : " + age);
        notify();
    }

    public synchronized void setAge(Integer age) {
        while (isValueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.age = age;
        System.out.println(Thread.currentThread().getName() + " : " + age);
        isValueSet = true;
        notify();
    }
}

class Producer implements Runnable{

    Person person;

    public Producer(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            person.setAge(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable{

    Person person;

    public Consumer(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            person.getAge();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ITCProducerConsumer {
    public static void main(String[] args) {
        Person person = new Person();

        Producer producer = new Producer(person);
        Thread producerThread = new Thread(producer, "Producer");
        producerThread.start();

        Consumer consumer = new Consumer(person);
        Thread consumerThread = new Thread(consumer, "Consumer");
        consumerThread.start();
    }
}
