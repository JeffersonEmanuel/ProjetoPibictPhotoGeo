package ifpb.pibict.photogeo.imagens;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Tag;
import ifpb.pibict.photogeo.entidades.Fotografia;
import java.io.IOException;
import java.util.List;
import org.primefaces.event.FileUploadEvent;
import ifpb.pibict.photogeo.metadados.ExtrairMetadados;
import java.util.Calendar;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author jefferson
 */
public class CriarImagem {

    public CriarImagem() {
    }

    private ExtrairMetadados extrairMetadados = new ExtrairMetadados();

    private Fotografia fotografia = new Fotografia();

    public Fotografia criarImagem(FileUploadEvent event) throws ImageProcessingException, IOException {
        List<Tag> tag = extrairMetadados.metadados(event);
        System.out.println(event.getFile().getFileName());
        for (Tag nome : tag) {
            System.out.println(nome.getDescription() + " --------> " + nome.getTagName());
            getLatitude(nome);
            getLongitude(nome);
            getHora(nome);
            getData(nome);
            getAltura(nome);
            getLargura(nome);
        }
        fotografia.setNome(event.getFile().getFileName());
        fotografia.setEndereco("/home/jefferson/Área de Trabalho/Imagens/Imagens Processadas/"
                + event.getFile().getFileName());
        return fotografia;
    }

    private void getLatitude(Tag tag) {
        if (tag.getTagName().contains("GPS Latitude")) {
            fotografia.setGeomLatitude(tag.getDescription());
        }
    }

    private void getLongitude(Tag tag) {
        if (tag.getTagName().contains("GPS Longitude")) {
            fotografia.setGeomLongitude(tag.getDescription());
        }
    }

    private void getHora(Tag tag) {
        if (tag.getTagName().contentEquals("Date/Time Original")) {
            fotografia.setHora(tag.getDescription().substring(11, 19));
        }
    }

    private void getData(Tag tag) {
        if (tag.getTagName().contentEquals("Date/Time Original")) {
            fotografia.setData(tag.getDescription().substring(0, 10));
        }
    }

    private void getLargura(Tag tag) {
        if (tag.getTagName().contentEquals("Exif Image Width")) {
            fotografia.setLargura(tag.getDescription());
        }
    }

    private void getAltura(Tag tag) {
        if (tag.getTagName().contentEquals("Exif Image Height")) {
            fotografia.setAltura(tag.getDescription());
        }
    }

}
