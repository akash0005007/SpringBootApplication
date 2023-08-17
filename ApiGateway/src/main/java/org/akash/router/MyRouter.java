package org.akash.router;

import org.springframework.stereotype.Service;

@Service
public class MyRouter {
    public String myString(){
        return "I'm publically acessiable to anyone";
    }
}
