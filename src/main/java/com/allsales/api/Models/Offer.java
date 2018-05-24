package com.allsales.api.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name="offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String alias;
    private String title;
    private String subtitle;
    private String shortDescription;
    private Boolean published;
    private Boolean processed;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "city_id",foreignKey = @ForeignKey(name = "CITY_ID_FK"))
    private City offerCity;

    @ManyToOne
    @JoinColumn(name = "contract_id",foreignKey = @ForeignKey(name = "CONTRACT_ID_FK"))
    private Contract offerContract;

    @ManyToOne
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User offerUser;

    public User getOfferUser() {
        return offerUser;
    }

    public void setOfferUser(User offerUser) {
        this.offerUser = offerUser;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Contract getOfferContract() {
        return offerContract;
    }

    public void setOfferContract(Contract offerContract) {
        this.offerContract = offerContract;
    }

    public City getOfferCity(){

        return this.offerCity;
    }

    public void setOfferCity(City city) {
        this.offerCity = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
