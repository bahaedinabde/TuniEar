package org.example.backend.dto;

import java.util.List;

public class ModelIemDTO {
    private Long idModel;
    private String nomMarque;
    private String typeDriver;
    private String freqResponse;
    private List<String> urlsImages;

    public Long getIdModel() {
        return idModel;
    }
    public void setIdModel(Long idModel) {
        this.idModel = idModel;
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
}
