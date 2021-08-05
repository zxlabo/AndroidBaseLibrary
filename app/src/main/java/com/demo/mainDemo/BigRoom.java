package com.demo.mainDemo;

class BigRoom {
    private final Object studyRoom = new Object();
    private final Object bedRoom = new Object();

    public void sleep() {
        synchronized (bedRoom) {
        }
    }

    public void study() {
        synchronized (studyRoom) {

        }
    }
}