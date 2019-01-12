package controller;

import com.iwbz.controller.HelloController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloControllerTest {
    @Test
    public void sayHello() {
        assertEquals("Hello,SpringBoot",new HelloController().sayHello());
    }
}