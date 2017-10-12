
package com.groupon.generated.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class PurchaserDetail {

    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("shippingAddress")
    @Expose
    private ShippingAddress shippingAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastName).append(firstName).append(shippingAddress).toHashCode();
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
        return new EqualsBuilder().append(lastName, rhs.lastName).append(firstName, rhs.firstName).append(shippingAddress, rhs.shippingAddress).isEquals();
    }

}
