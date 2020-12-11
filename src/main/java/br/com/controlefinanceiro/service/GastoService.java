package br.com.controlefinanceiro.service;

import br.com.controlefinanceiro.model.GastoModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface GastoService {

    Mono <GastoModel> adicionarGastoPessoal(GastoModel gasto);
    Mono <GastoModel> alterarGastoPessoal(GastoModel gasto);
    Mono <GastoModel> buscarGastoPessoalPorId(String id);
    Flux <GastoModel> buscarGastosPessoaisPorMesAno( String mes, Integer ano );
    Flux <GastoModel> buscarGastosPessoaisPorMesAnoCategoria(String mes, Integer ano, String categoria);
    Mono <BigDecimal> buscarTotalDeGastosPorMesAno(String mes, Integer ano);
    Mono <BigDecimal> buscarTotalDeGastosPorMesAnoCategoria(String mes, Integer ano, String categoria);
    Flux <GastoModel> buscarGastosDoMesAnoAtualAVencerEmUmDia();
    
}