package org.akash.controller;

import org.akash.router.MyRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    MyRouter myRouter;

    @Autowired
    public MyController(MyRouter myRouter) {
        this.myRouter = myRouter;
    }

    @GetMapping("/")
    public String availableToAll() {
        return myRouter.myString();
    }
}
