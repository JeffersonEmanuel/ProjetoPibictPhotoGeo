/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pibict.photogeo.imagens;

import ifpb.pibict.photogeo.entidades.Fotografia;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author jefferson
 */
public class ExibirImagens {

    public ExibirImagens() {
    }

    public static List<StreamedContent> carregaImagem(List<Fotografia> getFotografias) {
        List<StreamedContent> imagem = new ArrayList<>();

        for (Fotografia fotografiaTemp : getFotografias) {
            String endereco = fotografiaTemp.getEndereco();
            System.out.println("------------------------->" + endereco);
            StreamedContent imgLogo = null;

            try {
                final File arquivoImagem = new File(endereco);
                final FileInputStream fileInputStream = new FileInputStream(arquivoImagem);
                final InputStream is = new BufferedInputStream(fileInputStream);
                imgLogo = new DefaultStreamedContent(is);
            } catch (FileNotFoundException e) {
                System.out.println("Erro ao importar a imagem " + endereco);
            }
            imagem.add(imgLogo);
        }
        return imagem;
    }

}
