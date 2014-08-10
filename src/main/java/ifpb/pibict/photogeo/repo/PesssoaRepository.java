/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifpb.pibict.photogeo.repo;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import ifpb.pibict.photogeo.entidades.Endereco;
import ifpb.pibict.photogeo.entidades.Pessoa;

/**
 *
 * @author jefferson
 */
@Repository
public interface PesssoaRepository extends GraphRepository<Pessoa>{
   
    @Query("start pessoa=node:__types__(className=\"spring.neo4j.entidades.Pessoa\") where pessoa.nome = 'Mateus' "
            + "return pessoa ")
    Pessoa getP();
    
}
