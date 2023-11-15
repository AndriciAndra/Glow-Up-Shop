package org.scrum.domain.project;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Facility {
    @JsonProperty("id")
    private int id;

    @JsonProperty("facilityName")
    private String facilityName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("costPrice")
    private Double costPrice;

    @JsonProperty("salePrice")
    private Double salePrice;

    @JsonProperty("category")
    private String category;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("currentdisponibility")
    private int currentdisponibility;

    public Facility() {

    }

    public Facility(String facilityName,
                String description,
                double costPrice,
                double salePrice,
                String category,
                String photo,
                int currentQuantity) {
        this.facilityName = facilityName;
        this.description = description;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.category = category;
        this.photo = photo;
        this.currentdisponibility = currentdisponibility;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void add(Facility facility) {
    }
}
