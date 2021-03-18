package com.ejrecupsp.demo

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CargaBaseDatos {
    companion object {
        var logger = LoggerFactory.getLogger(CargaBaseDatos.javaClass)
    }

    @Bean
    fun initDatabase(datos: RepositorioUsuarios, datosTexto: RepositorioTexto): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            logger.info("Preloading " + datos.save(Usuario("Aitor", "123")))
            logger.info("Preloading " + datosTexto.save(Texto("Aitor", "123")))
        }
    }
}

