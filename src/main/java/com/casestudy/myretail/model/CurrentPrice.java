package com.casestudy.myretail.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class CurrentPrice{
    @Field("value")
    public double value;

    public double getValue() {
        return value;
    }

    public CurrentPrice(double value, String currency_Code) {
        this.value = value;
        this.currency_Code = currency_Code;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency_Code() {
        return currency_Code;
    }

    public void setCurrency_Code(String currency_Code) {
        this.currency_Code = currency_Code;
    }
    @Field("currency_code")
    public String currency_Code;
}
