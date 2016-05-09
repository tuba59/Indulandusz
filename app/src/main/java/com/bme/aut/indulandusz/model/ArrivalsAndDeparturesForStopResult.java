package com.bme.aut.indulandusz.model;

import java.util.Objects;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class ArrivalsAndDeparturesForStopResult   {
  
  @SerializedName("stopId")
  private String stopId = null;
  
  @SerializedName("alertIds")
  private Object alertIds = null;
  
  @SerializedName("nearbyStopIds")
  private BigDecimal nearbyStopIds = null;
  
  @SerializedName("stopTimes")
  private Object stopTimes = null;
  
  /**
   **/
  public String getStopId() {
    return stopId;
  }
  public void setStopId(String stopId) {
    this.stopId = stopId;
  }

  
  /**
   **/
  public Object getAlertIds() {
    return alertIds;
  }
  public void setAlertIds(Object alertIds) {
    this.alertIds = alertIds;
  }

  
  /**
   **/
  public BigDecimal getNearbyStopIds() {
    return nearbyStopIds;
  }
  public void setNearbyStopIds(BigDecimal nearbyStopIds) {
    this.nearbyStopIds = nearbyStopIds;
  }

  
  /**
   **/
  public Object getStopTimes() {
    return stopTimes;
  }
  public void setStopTimes(Object stopTimes) {
    this.stopTimes = stopTimes;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArrivalsAndDeparturesForStopResult arrivalsAndDeparturesForStopResult = (ArrivalsAndDeparturesForStopResult) o;
    return Objects.equals(stopId, arrivalsAndDeparturesForStopResult.stopId) &&
        Objects.equals(alertIds, arrivalsAndDeparturesForStopResult.alertIds) &&
        Objects.equals(nearbyStopIds, arrivalsAndDeparturesForStopResult.nearbyStopIds) &&
        Objects.equals(stopTimes, arrivalsAndDeparturesForStopResult.stopTimes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stopId, alertIds, nearbyStopIds, stopTimes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArrivalsAndDeparturesForStopResult {\n");
    
    sb.append("    stopId: ").append(toIndentedString(stopId)).append("\n");
    sb.append("    alertIds: ").append(toIndentedString(alertIds)).append("\n");
    sb.append("    nearbyStopIds: ").append(toIndentedString(nearbyStopIds)).append("\n");
    sb.append("    stopTimes: ").append(toIndentedString(stopTimes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
