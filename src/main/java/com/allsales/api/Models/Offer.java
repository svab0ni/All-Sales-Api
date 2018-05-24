package com.allsales.api.Models;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50)
    @NotNull
    private String name;

    @Column(name = "alias", length = 500)
    @NotNull
    private String alias;

    @Column(name = "title", length = 500)
    @NotNull
    private String title;

    @Column(name = "subtitle", length = 500)
    @NotNull
    private String subtitle;

    @Column(name = "shortDescription", length = 500)
    @NotNull
    private String shortDescription;

    @Column(name = "published", length = 1)
    @NotNull
    private Boolean published;

    @Column(name = "processed", length = 1)
    @NotNull
    private Boolean processed;

    @Column(name = "imageUrl", length = 500)
    @NotNull
    private String imageUrl;

    @Column(name = "currentPrice", length = 500)
    @NotNull
    private Integer currentPrice;

    public Integer getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(Integer previousPrice) {
        this.previousPrice = previousPrice;
    }

    @Column(name = "previousPrice", length = 500)
    @NotNull
    private Integer previousPrice;

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
