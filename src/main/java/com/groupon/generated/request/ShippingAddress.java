
package com.groupon.generated.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "streetAddress",
    "extendedAddress",
    "locality",
    "region",
    "postalCode",
    "countryCode"
})
public class ShippingAddress implements Serializable
{

    @JsonProperty("streetAddress")
    private String streetAddress;
    @JsonProperty("extendedAddress")
    private String extendedAddress;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("region")
    private String region;
    @JsonProperty("postalCode")
    private Integer postalCode;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6399656496684886732L;

    @JsonProperty("streetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    @JsonProperty("streetAddress")
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @JsonProperty("extendedAddress")
    public String getExtendedAddress() {
        return extendedAddress;
    }

    @JsonProperty("extendedAddress")
    public void setExtendedAddress(String extendedAddress) {
        this.extendedAddress = extendedAddress;
    }

    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }

    @JsonProperty("locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("postalCode")
    public Integer getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(region).append(streetAddress).append(postalCode).append(extendedAddress).append(additionalProperties).append(countryCode).append(locality).toHashCode();
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
        return new EqualsBuilder().append(region, rhs.region).append(streetAddress, rhs.streetAddress).append(postalCode, rhs.postalCode).append(extendedAddress, rhs.extendedAddress).append(additionalProperties, rhs.additionalProperties).append(countryCode, rhs.countryCode).append(locality, rhs.locality).isEquals();
    }

}
