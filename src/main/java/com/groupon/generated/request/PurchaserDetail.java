
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
    "firstName",
    "lastName",
    "meetsMinimumAgeRestriction",
    "shippingAddress"
})
public class PurchaserDetail implements Serializable
{

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("meetsMinimumAgeRestriction")
    private Integer meetsMinimumAgeRestriction;
    @JsonProperty("shippingAddress")
    private ShippingAddress shippingAddress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1877370039278258806L;

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("meetsMinimumAgeRestriction")
    public Integer getMeetsMinimumAgeRestriction() {
        return meetsMinimumAgeRestriction;
    }

    @JsonProperty("meetsMinimumAgeRestriction")
    public void setMeetsMinimumAgeRestriction(Integer meetsMinimumAgeRestriction) {
        this.meetsMinimumAgeRestriction = meetsMinimumAgeRestriction;
    }

    @JsonProperty("shippingAddress")
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @JsonProperty("shippingAddress")
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
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
        return new HashCodeBuilder().append(lastName).append(additionalProperties).append(meetsMinimumAgeRestriction).append(firstName).append(shippingAddress).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PurchaserDetail) == false) {
            return false;
        }
        PurchaserDetail rhs = ((PurchaserDetail) other);
        return new EqualsBuilder().append(lastName, rhs.lastName).append(additionalProperties, rhs.additionalProperties).append(meetsMinimumAgeRestriction, rhs.meetsMinimumAgeRestriction).append(firstName, rhs.firstName).append(shippingAddress, rhs.shippingAddress).isEquals();
    }

}
