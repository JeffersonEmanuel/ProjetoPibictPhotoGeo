/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifpb.pibict.photogeo.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ifpb.pibict.photogeo.repo.FotografiaRepository;

/**
 *
 * @author jefferson
 */
@Component
public class RegistrarServicoFotografia {
    
    @Autowired
    private FotografiaRepository fotografiaRepository;

    public FotografiaRepository getFotografiaRepository() {
        return fotografiaRepository;
    }

    public void setFotografiaRepository(FotografiaRepository fotografiaRepository) {
        this.fotografiaRepository = fotografiaRepository;
    }
    
}
