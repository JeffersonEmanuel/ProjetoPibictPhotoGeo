
package ifpb.pibict.photogeo.util;

import ifpb.pibict.photogeo.constantes.ConstantesSistema;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author jefferson
 */
public class FotoUtil implements Serializable {

    private static final long serialVersionUID = 1L;


    public static StreamedContent recuperarFotoDisco(String id) throws FileNotFoundException {
        try {
            return new DefaultStreamedContent(new FileInputStream(new File(ConstantesSistema.CAMINHO_IMAGEM +  id)), "image/png");
        } catch (IOException e) {
            e.printStackTrace();

            return new DefaultStreamedContent(new FileInputStream(new File(ConstantesSistema.CAMINHO_IMAGEM + "1017397_362521270540657_1025517854_n.jpg")), "image/png");
        }
    }
}
