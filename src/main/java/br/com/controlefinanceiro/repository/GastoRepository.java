package br.com.controlefinanceiro.repository;

import br.com.controlefinanceiro.model.GastoModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface GastoRepository extends ReactiveMongoRepository <GastoModel, String> {

   Flux <GastoModel> findByMesAndAno(String mes, Integer ano);
   Flux <GastoModel> findByMesAndAnoAndCategoria(String mes, Integer ano, String categoria);
}