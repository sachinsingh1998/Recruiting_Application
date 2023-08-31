package com.Recruiting.IJP.Exception;

public class ReRegisteredException extends RuntimeException{
    public ReRegisteredException(Long id) {
        super("Worker "+id+" already registered");
        //System.out.println("At least aaya to");
    }
}
