/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pibict.photogeo.beans;

import com.drew.imaging.ImageProcessingException;
import com.google.common.collect.Lists;
import ifpb.pibict.photogeo.entidades.Fotografia;
import ifpb.pibict.photogeo.imagens.CriarImagem;
import ifpb.pibict.photogeo.servico.RegistrarServicoFotografia;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author jefferson
 */
@ManagedBean
@SessionScoped
public class FotografiaBean implements Serializable {

    private Fotografia fotografia = new Fotografia();

    private List<Fotografia> fotografias = new ArrayList<Fotografia>();

    @ManagedProperty(value = "#{registrarServicoFotografia}")
    private RegistrarServicoFotografia servicoFotografia;

    public Fotografia getFotografia() {
        return fotografia;
    }

    public void setFotografia(Fotografia fotografia) {
        this.fotografia = fotografia;
    }

    public List<Fotografia> getFotografias() {
        this.fotografias = Lists.newArrayList(this.servicoFotografia.getFotografiaRepository().findAll());
        return fotografias;
    }

    public void setFotografias(List<Fotografia> fotografias) {
        this.fotografias = fotografias;
    }

    public RegistrarServicoFotografia getServicoFotografia() {
        return servicoFotografia;
    }

    public void setServicoFotografia(RegistrarServicoFotografia servicoFotografia) {
        this.servicoFotografia = servicoFotografia;
    }

    public String salvar() {
        this.servicoFotografia.getFotografiaRepository().save(this.fotografia);
        this.fotografia = new Fotografia();
        return "templates/template.xhtml";
    }

    private CriarImagem ci = new CriarImagem();

    public String fotoComAlbum(FileUploadEvent event) throws ImageProcessingException, IOException {
        this.fotografia = ci.criarImagem(event);
        this.servicoFotografia.getFotografiaRepository().save(this.fotografia);
        this.fotografia = new Fotografia();
        return "templates/template.xhtml";
    }
    
    
     public StreamedContent carregaImagem() {

        StreamedContent imgLogo = null;

        try {
            final File arquivoImagem = new File("/home/jefferson/Área de Trabalho/Imagens/Imagens Processadas/20131206_202424.jpg");
            final FileInputStream fileInputStream = new FileInputStream(arquivoImagem);
            final InputStream is = new BufferedInputStream(fileInputStream);
            imgLogo = new DefaultStreamedContent(is);
        } catch (Exception e) {

        }

        return imgLogo;

    }
    

}
