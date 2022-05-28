package com.example.spinnerpersonalizado;

public class ItemData {
    private String textCategoria;
    private String textDescripcion;
    private Integer imageId;

    public ItemData(String text, String text2, Integer imageId) {
        this.textCategoria = text;
        this.textDescripcion = text2;
        this.imageId = imageId;
    }

    public String getTextCategoria() {
        return textCategoria;
    }

    public void setTextCategoria(String text2) {
        this.textCategoria = text2;
    }

    public String getTextDescripcion() {
        return textDescripcion;
    }

    public void setTextDescripcion(String text) {
        this.textDescripcion = text;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
