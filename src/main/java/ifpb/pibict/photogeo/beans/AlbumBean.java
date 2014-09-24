package ifpb.pibict.photogeo.beans;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import ifpb.pibict.photogeo.entidades.Album;
import ifpb.pibict.photogeo.servico.RegistrarServicoAlbum;

/**
 *
 * @author jefferson
 */
@ManagedBean
@SessionScoped
public class AlbumBean implements Serializable{
    
    private Album album = new Album();
        
    private List<Album> albums;
    
    @ManagedProperty(value = "#{registrarServicoAlbum}")
    private RegistrarServicoAlbum servico;

    public String salvar () {
        this.servico.getAlbumRepository().save(this.album);
        this.album = new Album();
        return "album.xhtml";
    } 

    public String abrirFotosDoAlbum () {
        return "fotografia.xhtml";
    }
    
    
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Album> getAlbums() {
        this.albums = Lists.newArrayList(this.servico.getAlbumRepository().findAll());
        return albums;
    }

    public RegistrarServicoAlbum getServico() {
        return servico;
    }

    public void setServico(RegistrarServicoAlbum servico) {
        this.servico = servico;
    }

    
    
    
    
    
}
