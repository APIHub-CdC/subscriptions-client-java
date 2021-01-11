package io.Subscriptions.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
@ApiModel(description = "A list of subscriptions showed in pages.")



public class SubscriptionsMetadata {
  @SerializedName("_metadata")
  private Metadata metadata = null;
  @SerializedName("subscriptions")
  private List<Subscription> subscriptions = null;
  public SubscriptionsMetadata metadata(Metadata metadata) {
    this.metadata = metadata;
    return this;
  }
   
  @ApiModelProperty(value = "")
  public Metadata getMetadata() {
    return metadata;
  }
  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }
  public SubscriptionsMetadata subscriptions(List<Subscription> subscriptions) {
    this.subscriptions = subscriptions;
    return this;
  }
  public SubscriptionsMetadata addSubscriptionsItem(Subscription subscriptionsItem) {
    if (this.subscriptions == null) {
      this.subscriptions = new ArrayList<Subscription>();
    }
    this.subscriptions.add(subscriptionsItem);
    return this;
  }
   
  @ApiModelProperty(value = "")
  public List<Subscription> getSubscriptions() {
    return subscriptions;
  }
  public void setSubscriptions(List<Subscription> subscriptions) {
    this.subscriptions = subscriptions;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionsMetadata subscriptionsMetadata = (SubscriptionsMetadata) o;
    return Objects.equals(this.metadata, subscriptionsMetadata.metadata) &&
        Objects.equals(this.subscriptions, subscriptionsMetadata.subscriptions);
  }
  @Override
  public int hashCode() {
    return Objects.hash(metadata, subscriptions);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionsMetadata {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    subscriptions: ").append(toIndentedString(subscriptions)).append("\n");
    sb.append("}");
    return sb.toString();
  }
  
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
