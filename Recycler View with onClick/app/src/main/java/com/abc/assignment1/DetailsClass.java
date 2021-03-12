package com.abc.assignment1;

class DetailsClass {
    private String capital;
    private String country;
    private String currency;

    DetailsClass(String country , String capital, String currency){
        this.country = country;
        this.capital = capital;
        this.currency =  currency;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
