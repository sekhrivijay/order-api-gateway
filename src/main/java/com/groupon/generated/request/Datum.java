
package com.groupon.generated.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "productId",
    "quantity",
    "priceSummary",
    "attributes",
    "reservedUnits",
    "purchaserDetails"
})
public class Datum implements Serializable
{

    @JsonProperty("productId")
    private String productId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("priceSummary")
    private PriceSummary priceSummary;
    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonProperty("reservedUnits")
    private List<ReservedUnit> reservedUnits = null;
    @JsonProperty("purchaserDetails")
    private List<PurchaserDetail> purchaserDetails = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4215913279309437890L;

    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("priceSummary")
    public PriceSummary getPriceSummary() {
        return priceSummary;
    }

    @JsonProperty("priceSummary")
    public void setPriceSummary(PriceSummary priceSummary) {
        this.priceSummary = priceSummary;
    }

    @JsonProperty("attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("reservedUnits")
    public List<ReservedUnit> getReservedUnits() {
        return reservedUnits;
    }

    @JsonProperty("reservedUnits")
    public void setReservedUnits(List<ReservedUnit> reservedUnits) {
        this.reservedUnits = reservedUnits;
    }

    @JsonProperty("purchaserDetails")
    public List<PurchaserDetail> getPurchaserDetails() {
        return purchaserDetails;
    }

    @JsonProperty("purchaserDetails")
    public void setPurchaserDetails(List<PurchaserDetail> purchaserDetails) {
        this.purchaserDetails = purchaserDetails;
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
        return new HashCodeBuilder().append(reservedUnits).append(additionalProperties).append(quantity).append(purchaserDetails).append(attributes).append(priceSummary).append(productId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Datum) == false) {
            return false;
        }
        Datum rhs = ((Datum) other);
        return new EqualsBuilder().append(reservedUnits, rhs.reservedUnits).append(additionalProperties, rhs.additionalProperties).append(quantity, rhs.quantity).append(purchaserDetails, rhs.purchaserDetails).append(attributes, rhs.attributes).append(priceSummary, rhs.priceSummary).append(productId, rhs.productId).isEquals();
    }

}
