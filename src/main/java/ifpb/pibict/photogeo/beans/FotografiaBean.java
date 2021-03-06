package ifpb.pibict.photogeo.beans;

import com.drew.imaging.ImageProcessingException;
import com.google.common.collect.Lists;
import ifpb.pibict.photogeo.entidades.Album;
import ifpb.pibict.photogeo.entidades.Fotografia;
import ifpb.pibict.photogeo.imagens.CriarImagem;
import ifpb.pibict.photogeo.servico.RegistrarServicoFotografia;
import ifpb.pibict.photogeo.util.FotoUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author jefferson
 */
@ManagedBean
@RequestScoped
public class FotografiaBean implements Serializable {

    public static final Logger LOGGER = Logger.getGlobal();

    private Fotografia fotografia = new Fotografia();

    private List<Fotografia> fotografias = new ArrayList<Fotografia>();

    private List<StreamedContent> imagemMostrar = new ArrayList<StreamedContent>();

    private Album album = new Album();

    private CriarImagem ci = new CriarImagem();

    private List<Fotografia> listaDeFotos;

    private List<Fotografia> listaDeFotosDoAlbum;

    private String nomeAlbumVer;

    FacesContext contexto = FacesContext.getCurrentInstance();

    @ManagedProperty(value = "#{registrarServicoFotografia}")
    private RegistrarServicoFotografia servicoFotografia;

    public FotografiaBean() {
    }

    @PostConstruct
    public void init() {
        listaDeFotos = new ArrayList<>();
        listaDeFotosDoAlbum = new ArrayList<>();
    }

    public String salvar() {
        this.servicoFotografia.getFotografiaRepository().save(this.fotografia);
        this.fotografia = new Fotografia();
        return "templates/template.xhtml";
    }

    public String fotoComAlbum(FileUploadEvent event) throws ImageProcessingException, IOException {
        String nomeDoAlbum = (String) contexto.getExternalContext().getSessionMap().get("album");
        this.album = this.servicoFotografia.getFotografiaRepository().getAlbumFoto(nomeDoAlbum);
        this.fotografia = ci.criarImagem(event, this.album);
        this.servicoFotografia.getFotografiaRepository().save(this.fotografia);
        this.fotografia = new Fotografia();
        return "fotografia.xhtml";
    }

    public List<Fotografia> getListaDeFotos() {
        for (Fotografia f : getFotografias()) {
            listaDeFotos.add(f);
        }
        return listaDeFotos;
    }

    public StreamedContent getFoto() throws FileNotFoundException {
        String fotoNome = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("fotoNome");

        if (FacesContext.getCurrentInstance().getRenderResponse() || fotoNome == null) {
            return new DefaultStreamedContent();
        } else {
            return FotoUtil.recuperarFotoDisco(fotoNome);
        }
    }

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

    public RegistrarServicoFotografia getServicoFotografia() {
        return servicoFotografia;
    }

    public void setServicoFotografia(RegistrarServicoFotografia servicoFotografia) {
        this.servicoFotografia = servicoFotografia;
    }

    public List<StreamedContent> getImagemMostrar() {
        return imagemMostrar;
    }

    public void setImagemMostrar(List<StreamedContent> imagemMostrar) {
        this.imagemMostrar = imagemMostrar;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String nomeAlbum() {
        System.out.println(nomeAlbumVer + "<=========================");
        contexto.getExternalContext().getSessionMap().put("album", nomeAlbumVer);
        return "fotografia_album.jsf";
    }

    public String getNomeAlbumVer() {
        return nomeAlbumVer;
    }

    public void setNomeAlbumVer(String nomeAlbumVer) {
        this.nomeAlbumVer = nomeAlbumVer;
    }

    public List<Fotografia> getListaDeFotosDoAlbum() {
        String nomeDoAlbum = (String) contexto.getExternalContext().getSessionMap().get("album");
        listaDeFotosDoAlbum = this.servicoFotografia.getFotografiaRepository().getFotografiaPorAlbum(nomeAlbumVer);
        System.out.println("sada");
        return listaDeFotosDoAlbum;
    }

}
