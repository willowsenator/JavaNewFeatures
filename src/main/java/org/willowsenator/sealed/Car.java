package org.willowsenator.sealed;

public sealed class Car extends Vehicle implements SmartMediaPlayer
        permits FlyingCar{
    @Override
    public String drive() {
        return "CAR";
    }

    @Override
    public void connectPhone() {
        System.out.println("Phone connected");
    }
}
