/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifpb.pibict.photogeo.repo;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import ifpb.pibict.photogeo.entidades.Face;
/**
 *
 * @author jefferson
 */
@Repository
public interface FaceRepository extends GraphRepository<Face>{
    
}
