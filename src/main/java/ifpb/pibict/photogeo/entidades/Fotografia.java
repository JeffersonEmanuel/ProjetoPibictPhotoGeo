/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.pibict.photogeo.entidades;

import java.util.Calendar;
import java.util.List;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 *
 * @author jefferson
 */
@NodeEntity
public class Fotografia {

    @GraphId
    private Long id;

    // Nome da Fotografia
    private String nome;

    // local onde esta armazenada a fotografia
    private String endereco;

    // data em que a fotografia foi capiturada
    private String data;

    // horario em que a fotografia foi capiturada
    private String hora;

    // Altura da Fotografia
    private String altura;

    // Largura da Fotografia
    private String largura;

    // localização geografica Longitude da Fotografia
    private String geomLongitude;

     // localização geografica Latitude da Fotografia
    private String geomLatitude;
    
//    // Lista de faces encontradas na fotografia
//    @RelatedTo(type = "Face_Pertence_A", direction = Direction.INCOMING)
//    private List<Face> faces;
    
    
    // Album ao qual a fotografia Pertence
    @RelatedTo(type = "Fotografia_Em_Evento", direction = Direction.OUTGOING)
    private Album album;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public String getGeomLongitude() {
        return geomLongitude;
    }

    public void setGeomLongitude(String geomLongitude) {
        this.geomLongitude = geomLongitude;
    }

    public String getGeomLatitude() {
        return geomLatitude;
    }

    public void setGeomLatitude(String geomLatitude) {
        this.geomLatitude = geomLatitude;
    }

  
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
