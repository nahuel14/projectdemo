package com.correo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.correo.Dao.Impl.PedidoImpDao;
import com.correo.Dao.Impl.UsuarioImpDao;

@SpringBootApplication
@ComponentScan(basePackages = {"com.correo.demo", "com.correo.CorreoBO"})
public class SpringprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringprojectApplication.class, args);
    }
    
    @Bean
    public UsuarioImpDao usuarioDao() {
        return new UsuarioImpDao(); // Instancia de la implementación concreta UsuarioImpDao
    }

    @Bean
    public PedidoImpDao pedidoDao() {
        return new PedidoImpDao(); // Instancia de la implementación concreta PedidoImpDao
    }
}
