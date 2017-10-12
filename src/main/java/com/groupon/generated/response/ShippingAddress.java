
package com.groupon.generated.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ShippingAddress {

    @SerializedName("streetAddress")
    @Expose
    private String streetAddress;
    @SerializedName("extendedAddress")
    @Expose
    private String extendedAddress;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("postalCode")
    @Expose
    private Integer postalCode;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getExtendedAddress() {
        return extendedAddress;
    }

    public void setExtendedAddress(String extendedAddress) {
        this.extendedAddress = extendedAddress;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(region).append(streetAddress).append(postalCode).append(extendedAddress).append(countryCode).append(locality).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ShippingAddress) == false) {
            return false;
        }
        ShippingAddress rhs = ((ShippingAddress) other);
        return new EqualsBuilder().append(region, rhs.region).append(streetAddress, rhs.streetAddress).append(postalCode, rhs.postalCode).append(extendedAddress, rhs.extendedAddress).append(countryCode, rhs.countryCode).append(locality, rhs.locality).isEquals();
    }

}
