package com.Recruiting.IJP.Exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Long id){
        super("Cannot find user with id:"+id);
        //System.out.println("Why idhar bc !!");
    }
}
