
package com.groupon.generated.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class PriceSummary {

    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("price")
    @Expose
    private Price price;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(price).append(currencyCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PriceSummary) == false) {
            return false;
        }
        PriceSummary rhs = ((PriceSummary) other);
        return new EqualsBuilder().append(price, rhs.price).append(currencyCode, rhs.currencyCode).isEquals();
    }

}
