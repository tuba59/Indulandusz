package com.bme.aut.indulandusz.model;

import java.util.Objects;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class StopsForLocationResult   {
  
  @SerializedName("id")
  private String id = null;
  
  @SerializedName("lat")
  private BigDecimal lat = null;
  
  @SerializedName("lon")
  private BigDecimal lon = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("code")
  private String code = null;
  
  @SerializedName("direction")
  private String direction = null;
  
  @SerializedName("locationType")
  private BigDecimal locationType = null;
  
  @SerializedName("parentStation")
  private String parentStation = null;
  
  @SerializedName("type")
  private String type = null;
  
  @SerializedName("wheelchairBoarding")
  private String wheelchairBoarding = null;
  
  @SerializedName("routeIds")
  private Object routeIds = null;
  
  @SerializedName("stopColorType")
  private String stopColorType = null;
  

  
  /**
   **/
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   **/
  public BigDecimal getLat() {
    return lat;
  }
  public void setLat(BigDecimal lat) {
    this.lat = lat;
  }

  
  /**
   **/
  public BigDecimal getLon() {
    return lon;
  }
  public void setLon(BigDecimal lon) {
    this.lon = lon;
  }

  
  /**
   **/

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  
  /**
   **/
  public String getDirection() {
    return direction;
  }
  public void setDirection(String direction) {
    this.direction = direction;
  }

  
  /**
   **/
  public BigDecimal getLocationType() {
    return locationType;
  }
  public void setLocationType(BigDecimal locationType) {
    this.locationType = locationType;
  }

  
  /**
   **/
  public String getParentStation() {
    return parentStation;
  }
  public void setParentStation(String parentStation) {
    this.parentStation = parentStation;
  }

  
  /**
   **/
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
  /**
   **/
  public String getWheelchairBoarding() {
    return wheelchairBoarding;
  }
  public void setWheelchairBoarding(String wheelchairBoarding) {
    this.wheelchairBoarding = wheelchairBoarding;
  }

  
  /**
   **/
  public Object getRouteIds() {
    return routeIds;
  }
  public void setRouteIds(Object routeIds) {
    this.routeIds = routeIds;
  }

  
  /**
   **/
  public String getStopColorType() {
    return stopColorType;
  }
  public void setStopColorType(String stopColorType) {
    this.stopColorType = stopColorType;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StopsForLocationResult stopsForLocationResult = (StopsForLocationResult) o;
    return Objects.equals(id, stopsForLocationResult.id) &&
        Objects.equals(lat, stopsForLocationResult.lat) &&
        Objects.equals(lon, stopsForLocationResult.lon) &&
        Objects.equals(name, stopsForLocationResult.name) &&
        Objects.equals(code, stopsForLocationResult.code) &&
        Objects.equals(direction, stopsForLocationResult.direction) &&
        Objects.equals(locationType, stopsForLocationResult.locationType) &&
        Objects.equals(parentStation, stopsForLocationResult.parentStation) &&
        Objects.equals(type, stopsForLocationResult.type) &&
        Objects.equals(wheelchairBoarding, stopsForLocationResult.wheelchairBoarding) &&
        Objects.equals(routeIds, stopsForLocationResult.routeIds) &&
        Objects.equals(stopColorType, stopsForLocationResult.stopColorType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lat, lon, name, code, direction, locationType, parentStation, type, wheelchairBoarding, routeIds, stopColorType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StopsForLocationResult {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    locationType: ").append(toIndentedString(locationType)).append("\n");
    sb.append("    parentStation: ").append(toIndentedString(parentStation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    wheelchairBoarding: ").append(toIndentedString(wheelchairBoarding)).append("\n");
    sb.append("    routeIds: ").append(toIndentedString(routeIds)).append("\n");
    sb.append("    stopColorType: ").append(toIndentedString(stopColorType)).append("\n");
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
