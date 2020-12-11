package br.com.controlefinanceiro.service;

import br.com.controlefinanceiro.model.GastoModel;
import br.com.controlefinanceiro.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Override
    public Mono <GastoModel> adicionarGastoPessoal(GastoModel gasto) {
        return gastoRepository.save(gasto);
    }

    @Override
    public Mono <GastoModel> alterarGastoPessoal(GastoModel gasto) {
        return gastoRepository.save(gasto);
    }

    @Override
    public Mono <GastoModel> buscarGastoPessoalPorId(String id) {
        return gastoRepository.findById(id);
    }

    @Override
    public Flux <GastoModel> buscarGastosPessoaisPorMesAno(String mes, Integer ano) {
        return gastoRepository.findByMesAndAno(mes, ano);
    }

    @Override
    public Flux <GastoModel> buscarGastosPessoaisPorMesAnoCategoria(String mes, Integer ano, String categoria) {
        return gastoRepository.findByMesAndAnoAndCategoria(mes, ano, categoria);
    }

    @Override
    public Mono <BigDecimal> buscarTotalDeGastosPorMesAno(String mes, Integer ano) {
        Flux<GastoModel> gastos = buscarGastosPessoaisPorMesAno(mes, ano);
        Mono<BigDecimal> total = gastos.map(GastoModel::getValor).reduce(BigDecimal::add);
        return total;
    }

    @Override
    public Mono <BigDecimal> buscarTotalDeGastosPorMesAnoCategoria(String mes, Integer ano, String categoria) {
       Flux<GastoModel> gastos = buscarGastosPessoaisPorMesAnoCategoria(mes, ano, categoria);
       Mono<BigDecimal> total = gastos.map(GastoModel::getValor).reduce(BigDecimal::add);
       return total;
    }

    @Override
    public Flux <GastoModel> buscarGastosDoMesAnoAtualAVencerEmUmDia() {
        return null;
    }
}
