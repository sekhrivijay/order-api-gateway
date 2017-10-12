
package com.groupon.generated.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Details {

    @SerializedName("serviceTitle")
    @Expose
    private String serviceTitle;
    @SerializedName("startAt")
    @Expose
    private String startAt;
    @SerializedName("endAt")
    @Expose
    private String endAt;
    @SerializedName("resourceName")
    @Expose
    private String resourceName;

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceTitle).append(startAt).append(endAt).append(resourceName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Details) == false) {
            return false;
        }
        Details rhs = ((Details) other);
        return new EqualsBuilder().append(serviceTitle, rhs.serviceTitle).append(startAt, rhs.startAt).append(endAt, rhs.endAt).append(resourceName, rhs.resourceName).isEquals();
    }

}
