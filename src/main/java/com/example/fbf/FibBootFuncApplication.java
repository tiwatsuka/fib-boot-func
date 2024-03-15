package com.example.fbf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FibBootFuncApplication {

    @Value("${TARGET:10}")
    int value;
    
    @RestController
    class FibController {
        @GetMapping("/")
        public int fib() {
            return fibInternal(value);
        }

        private int fibInternal(int n) {
            if(n == 0) {
                return 0;
            } else if(n == 1) {
                return 1;
            } else if( n < 0 ) {
                return -1;
            }
            return fibInternal(n-1) + fibInternal(n-2);
        }
    }
    
	public static void main(String[] args) {
		SpringApplication.run(FibBootFuncApplication.class, args);
	}

}
