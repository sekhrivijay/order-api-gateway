
package com.groupon.generated.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Product {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("priceSummary")
    @Expose
    private PriceSummary priceSummary;
    @SerializedName("reservedUnits")
    @Expose
    private List<ReservedUnit> reservedUnits = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PriceSummary getPriceSummary() {
        return priceSummary;
    }

    public void setPriceSummary(PriceSummary priceSummary) {
        this.priceSummary = priceSummary;
    }

    public List<ReservedUnit> getReservedUnits() {
        return reservedUnits;
    }

    public void setReservedUnits(List<ReservedUnit> reservedUnits) {
        this.reservedUnits = reservedUnits;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(reservedUnits).append(id).append(quantity).append(priceSummary).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return new EqualsBuilder().append(reservedUnits, rhs.reservedUnits).append(id, rhs.id).append(quantity, rhs.quantity).append(priceSummary, rhs.priceSummary).isEquals();
    }

}
