
package com.groupon.generated.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ReservedUnit {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fulfillmentType")
    @Expose
    private String fulfillmentType;
    @SerializedName("expiresAt")
    @Expose
    private String expiresAt;
    @SerializedName("isRedeemed")
    @Expose
    private Boolean isRedeemed;
    @SerializedName("details")
    @Expose
    private Details details;
    @SerializedName("purchaserDetails")
    @Expose
    private List<PurchaserDetail> purchaserDetails = null;
    @SerializedName("redeemedAt")
    @Expose
    private String redeemedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFulfillmentType() {
        return fulfillmentType;
    }

    public void setFulfillmentType(String fulfillmentType) {
        this.fulfillmentType = fulfillmentType;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Boolean getIsRedeemed() {
        return isRedeemed;
    }

    public void setIsRedeemed(Boolean isRedeemed) {
        this.isRedeemed = isRedeemed;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public List<PurchaserDetail> getPurchaserDetails() {
        return purchaserDetails;
    }

    public void setPurchaserDetails(List<PurchaserDetail> purchaserDetails) {
        this.purchaserDetails = purchaserDetails;
    }

    public String getRedeemedAt() {
        return redeemedAt;
    }

    public void setRedeemedAt(String redeemedAt) {
        this.redeemedAt = redeemedAt;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(fulfillmentType).append(isRedeemed).append(redeemedAt).append(details).append(expiresAt).append(purchaserDetails).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReservedUnit) == false) {
            return false;
        }
        ReservedUnit rhs = ((ReservedUnit) other);
        return new EqualsBuilder().append(id, rhs.id).append(fulfillmentType, rhs.fulfillmentType).append(isRedeemed, rhs.isRedeemed).append(redeemedAt, rhs.redeemedAt).append(details, rhs.details).append(expiresAt, rhs.expiresAt).append(purchaserDetails, rhs.purchaserDetails).isEquals();
    }

}
