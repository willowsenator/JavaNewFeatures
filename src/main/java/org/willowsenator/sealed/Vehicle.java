package org.willowsenator.sealed;

public sealed abstract class Vehicle permits Car, Truck{
    public abstract String drive();
}
