/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifpb.pibict.photogeo.repo;

import ifpb.pibict.photogeo.entidades.Album;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import ifpb.pibict.photogeo.entidades.Fotografia;
import org.springframework.data.neo4j.annotation.Query;

/**
 *
 * @author jefferson
 */
@Repository
public interface FotografiaRepository extends GraphRepository<Fotografia>{
 
    
      @Query("start album=node:__types__(className=\"ifpb.pibict.photogeo.entidades.Album\") "
              + "where album.nome = {0} "
            + "return album ")
    Album getAlbumFoto(String nomeAlbum);
}
