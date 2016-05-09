package com.bme.aut.indulandusz.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class ScheduleForStopResult   {
  
  @SerializedName("stopId")
  private String stopId = null;
  
  @SerializedName("serviceDate")
  private String serviceDate = null;
  
  @SerializedName("alertIds")
  private Object alertIds = null;
  
  @SerializedName("schedules")
  private Object schedules = null;
  

  
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
  public String getServiceDate() {
    return serviceDate;
  }
  public void setServiceDate(String serviceDate) {
    this.serviceDate = serviceDate;
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
  public Object getSchedules() {
    return schedules;
  }
  public void setSchedules(Object schedules) {
    this.schedules = schedules;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduleForStopResult scheduleForStopResult = (ScheduleForStopResult) o;
    return Objects.equals(stopId, scheduleForStopResult.stopId) &&
        Objects.equals(serviceDate, scheduleForStopResult.serviceDate) &&
        Objects.equals(alertIds, scheduleForStopResult.alertIds) &&
        Objects.equals(schedules, scheduleForStopResult.schedules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stopId, serviceDate, alertIds, schedules);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduleForStopResult {\n");
    
    sb.append("    stopId: ").append(toIndentedString(stopId)).append("\n");
    sb.append("    serviceDate: ").append(toIndentedString(serviceDate)).append("\n");
    sb.append("    alertIds: ").append(toIndentedString(alertIds)).append("\n");
    sb.append("    schedules: ").append(toIndentedString(schedules)).append("\n");
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
