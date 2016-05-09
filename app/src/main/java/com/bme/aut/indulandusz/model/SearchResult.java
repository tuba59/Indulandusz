package com.bme.aut.indulandusz.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class SearchResult   {
  
  @SerializedName("query")
  private String query = null;
  
  @SerializedName("stopIds")
  private Object stopIds = null;
  
  @SerializedName("routeIds")
  private Object routeIds = null;
  
  @SerializedName("alertIds")
  private Object alertIds = null;
  

  
  /**
   * Search criteria
   **/
  public String getQuery() {
    return query;
  }
  public void setQuery(String query) {
    this.query = query;
  }

  
  /**
   * List of stop ids.
   **/
  public Object getStopIds() {
    return stopIds;
  }
  public void setStopIds(Object stopIds) {
    this.stopIds = stopIds;
  }

  
  /**
   * List of route ids.
   **/
  public Object getRouteIds() {
    return routeIds;
  }
  public void setRouteIds(Object routeIds) {
    this.routeIds = routeIds;
  }

  
  /**
   * Alerts
   **/

  public Object getAlertIds() {
    return alertIds;
  }
  public void setAlertIds(Object alertIds) {
    this.alertIds = alertIds;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchResult searchResult = (SearchResult) o;
    return Objects.equals(query, searchResult.query) &&
        Objects.equals(stopIds, searchResult.stopIds) &&
        Objects.equals(routeIds, searchResult.routeIds) &&
        Objects.equals(alertIds, searchResult.alertIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, stopIds, routeIds, alertIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchResult {\n");
    
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    stopIds: ").append(toIndentedString(stopIds)).append("\n");
    sb.append("    routeIds: ").append(toIndentedString(routeIds)).append("\n");
    sb.append("    alertIds: ").append(toIndentedString(alertIds)).append("\n");
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
