package com.kanbagisi.net;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloworld", eager = true)
public class HelloWorld {
    public HelloWorld() {
        System.out.println("Helloworld started !");
    }
    public String getMessage(){
        return "Hello World !";
    }
}
