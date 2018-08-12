package juno.springboot.junopetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JunoPetclinicApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JunoPetclinicApplication.class, args);
        
    }
}
