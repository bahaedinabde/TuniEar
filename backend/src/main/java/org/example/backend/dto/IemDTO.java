package org.example.backend.dto;

import java.util.List;

public class IemDTO {
    private Long idIem;
    private Long modelId;
    private String nomMarque;
    private String typeDriver;
    private String freqResponse;
    private List<String> urlsImages;
    private Long prix;
    private Integer stock;
    private List<Long> avisIds;

    public Long getIdIem() {
        return idIem;
    }


    public Long getModelId() {
        return modelId;
    }
    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getNomMarque() {
        return nomMarque;
    }
    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public String getTypeDriver() {
        return typeDriver;
    }
    public void setTypeDriver(String typeDriver) {
        this.typeDriver = typeDriver;
    }

    public String getFreqResponse() {
        return freqResponse;
    }
    public void setFreqResponse(String freqResponse) {
        this.freqResponse = freqResponse;
    }

    public List<String> getUrlsImages() {
        return urlsImages;
    }
    public void setUrlsImages(List<String> urlsImages) {
        this.urlsImages = urlsImages;
    }

    public Long getPrix() {
        return prix;
    }
    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<Long> getAvisIds() {
        return avisIds;
    }
    public void setAvisIds(List<Long> avisIds) {
        this.avisIds = avisIds;
    }
}
