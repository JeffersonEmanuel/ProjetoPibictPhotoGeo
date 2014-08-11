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


    public void criarImagem(FileUploadEvent event) throws ImageProcessingException, IOException {
        List<Tag> tag = extrairMetadados.metadados(event);
        System.out.println(event.getFile().getFileName());
        for (Tag nome : tag) {
            System.out.println(nome.getDescription() +" --------> "+ nome.getTagName());
            System.out.println(getLatitude(nome));
            System.out.println(getLongitude(nome));
            System.out.println(getHora(nome));
            System.out.println(getData(nome));
            System.out.println(getAltura(nome));
            System.out.println(getLargura(nome));
        }

    }

    private String getLatitude(Tag tag) {
        if (tag.getTagName().contains("GPS Latitude")) {
            return tag.getDescription();
        }
        return "";
    }

    private String getLongitude(Tag tag) {
        if (tag.getTagName().contains("GPS Longitude")) {
            return tag.getDescription();
        }
        return "";
    }

    private String getHora(Tag tag) {
        if (tag.getTagName().contentEquals("Date/Time Original")) {
            return tag.getDescription().substring(11, 19);
        }
        return "";
    }

    private String getData(Tag tag) {
        if (tag.getTagName().contentEquals("Date/Time Original")) {
            return tag.getDescription().substring(0, 10);
        }
        return "";
    }

    private String getLargura(Tag tag) {
        if (tag.getTagName().contentEquals("Exif Image Width")) {
            return tag.getDescription();
        }
        return "";
    }

    private String getAltura(Tag tag) {
        if (tag.getTagName().contentEquals("Exif Image Height")) {
            return tag.getDescription();
        }
        return "";
    }



}
