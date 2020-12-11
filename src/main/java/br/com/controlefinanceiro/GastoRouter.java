package br.com.controlefinanceiro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class GastoRouter {

    @Bean
    public RouterFunction <ServerResponse> router(GastoHandler handler) {
        return RouterFunctions

                .route(POST("/gasto"), handler::adicionarGastoPessoal)
                .andRoute(PUT("/gasto"), handler::alterarGastoPessoal)
                .andRoute(GET("/gasto/{id}"), handler::buscarGastoPessoalPorId)
                .andRoute(GET("/gasto/total/{mes}/{ano}"), handler::buscarTotalDeGastosPorMesAno)
                .andRoute(GET("/gasto/total/{mes}/{ano}/{categoria}"), handler::buscarTotalDeGastosPorMesAnoCategoria)
                .andRoute(GET("/gasto/{mes}/{ano}"), handler::buscarGastosPessoaisPorMesAno)
                .andRoute(GET("/gasto/{mes}/{ano}/{categoria}"), handler::buscarGastosPessoaisPorMesAnoCategoria);

    }
}