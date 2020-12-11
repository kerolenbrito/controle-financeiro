package br.com.controlefinanceiro;

import br.com.controlefinanceiro.model.GastoModel;
import br.com.controlefinanceiro.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Component
public class GastoHandler {

    @Autowired
    GastoService service;

    public Mono <ServerResponse> adicionarGastoPessoal(ServerRequest request) {

        final Mono <GastoModel> gasto = request.bodyToMono(GastoModel.class);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(gasto.flatMap(service::adicionarGastoPessoal), GastoModel.class));
    }

    public Mono <ServerResponse> alterarGastoPessoal(ServerRequest request) {

        final Mono <GastoModel> gasto = request.bodyToMono(GastoModel.class);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(gasto.flatMap(service::alterarGastoPessoal), GastoModel.class));
    }

    public Mono <ServerResponse> buscarGastoPessoalPorId(ServerRequest request) {

        String id = request.pathVariable("id");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.buscarGastoPessoalPorId(id), GastoModel.class);
    }

    public Mono <ServerResponse> buscarGastosPessoaisPorMesAno(ServerRequest request) {

        String mes = request.pathVariable("mes");
        String ano = request.pathVariable("ano");
        Integer anoInterger = Integer.parseInt(ano);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.buscarGastosPessoaisPorMesAno(mes, anoInterger), GastoModel.class);
    }

    public Mono <ServerResponse> buscarGastosPessoaisPorMesAnoCategoria(ServerRequest request) {

        String mes = request.pathVariable("mes");
        String ano = request.pathVariable("ano");
        Integer anoInterger = Integer.parseInt(ano);
        String categoria = request.pathVariable("categoria");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.buscarGastosPessoaisPorMesAnoCategoria(mes, anoInterger, categoria), GastoModel.class);
    }

    public Mono <ServerResponse> buscarTotalDeGastosPorMesAno(ServerRequest request) {

        String mes = request.pathVariable("mes");
        String ano = request.pathVariable("ano");
        Integer anoInterger = Integer.parseInt(ano);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.buscarTotalDeGastosPorMesAno(mes, anoInterger), BigDecimal.class);
    }

    public Mono <ServerResponse> buscarTotalDeGastosPorMesAnoCategoria(ServerRequest request) {

        String mes = request.pathVariable("mes");
        String ano = request.pathVariable("ano");
        Integer anoInterger = Integer.parseInt(ano);
        String categoria = request.pathVariable("categoria");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.buscarTotalDeGastosPorMesAnoCategoria(mes, anoInterger, categoria), BigDecimal.class);
    }
}
