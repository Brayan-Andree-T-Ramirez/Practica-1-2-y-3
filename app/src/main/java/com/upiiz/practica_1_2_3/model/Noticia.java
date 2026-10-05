package com.upiiz.practica_1_2_3.model;

public class Noticia {
    private Long id;
    private String noticia;
    private String fecha;

    public Noticia() {
    }

    public Noticia(Long id, String noticia, String fecha) {
        this.id = id;
        this.noticia = noticia;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
