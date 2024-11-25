package ProjArq.ControlSubApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ProjArq.ControlSubApp.config", "ProjArq.ControlSubApp.controllers","ProjArq.ControlSubApp.aplicacao.service", "ProjArq.ControlSubApp.aplicacao.casosDeUso"})
public class ControlSubAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(ControlSubAppApplication.class, args);
    }

}
