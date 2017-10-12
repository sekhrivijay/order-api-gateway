
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
    "id",
    "grouponCustomerServiceId"
})
public class ReservedUnit implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("grouponCustomerServiceId")
    private String grouponCustomerServiceId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3353029864036676599L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("grouponCustomerServiceId")
    public String getGrouponCustomerServiceId() {
        return grouponCustomerServiceId;
    }

    @JsonProperty("grouponCustomerServiceId")
    public void setGrouponCustomerServiceId(String grouponCustomerServiceId) {
        this.grouponCustomerServiceId = grouponCustomerServiceId;
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
        return new HashCodeBuilder().append(id).append(additionalProperties).append(grouponCustomerServiceId).toHashCode();
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
        return new EqualsBuilder().append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(grouponCustomerServiceId, rhs.grouponCustomerServiceId).isEquals();
    }

}
