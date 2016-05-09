package com.bme.aut.indulandusz.Network;

import com.bme.aut.indulandusz.model.ArrivalsAndDeparturesForStopResult;
import com.bme.aut.indulandusz.model.ScheduleForStopResult;
import com.bme.aut.indulandusz.model.SearchResult;
import com.bme.aut.indulandusz.model.StopsForLocationResult;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.UUID;
import java.math.BigDecimal;
import java.util.List;

public interface DefaultApi {
  
  /**
   * 
   * Arriving and departing vehicles for a certain stop
   * @param key API key
   * @param stopId id of the stop
   * @param version API version
   * @param appVersion version of the application using the API
   * @param includeReferences reference types included in the response
   * @param onlyDepartures display only departures
   * @return Call<List<ArrivalsAndDeparturesForStopResult>>
   */
  
  @GET("arrivals-and-departures-for-stop.json")
  Call<List<ArrivalsAndDeparturesForStopResult>> arrivalsAndDeparturesForStopJsonGet(
    @Query("key") UUID key, @Query("stopId") String stopId, @Query("version") BigDecimal version, @Query("appVersion") String appVersion, @Query("includeReferences") String includeReferences, @Query("onlyDepartures") Boolean onlyDepartures
  );

  
  /**
   * 
   * A stop&#39;s scheadule with live data update
   * @param key API key
   * @param stopId id of the stop
   * @param version API version
   * @param appVersion version of the application using the API
   * @param includeReferences reference types included in the response
   * @param onlyDepartures display only departures
   * @param date display only departures
   * @return Call<List<ScheduleForStopResult>>
   */
  
  @GET("schedule-for-stop.json")
  Call<List<ScheduleForStopResult>> scheduleForStopJsonGet(
    @Query("key") UUID key, @Query("stopId") String stopId, @Query("version") BigDecimal version, @Query("appVersion") String appVersion, @Query("includeReferences") String includeReferences, @Query("onlyDepartures") Boolean onlyDepartures, @Query("date") String date
  );

  
  /**
   * 
   * Search for stops or vehicles
   * @param key API key
   * @param version API version
   * @param appVersion version of the application using the API
   * @param includeReferences reference types included in the response
   * @param query the search criteria
   * @return Call<List<SearchResult>>
   */
  
  @GET("search.json")
  Call<List<SearchResult>> searchJsonGet(
    @Query("key") UUID key, @Query("version") BigDecimal version, @Query("appVersion") String appVersion, @Query("includeReferences") String includeReferences, @Query("query") String query
  );

  
  /**
   * 
   * Search for stops nearby
   * @param key API key
   * @param lon longitude
   * @param lat latitude
   * @param version API version
   * @param appVersion version of the application using the API
   * @param includeReferences reference types included in the response
   * @param query the search criteria
   * @return Call<List<StopsForLocationResult>>
   */
  
  @GET("stops-for-location.json")
  Call<List<StopsForLocationResult>> stopsForLocationJsonGet(
    @Query("key") UUID key, @Query("lon") BigDecimal lon, @Query("lat") BigDecimal lat, @Query("version") BigDecimal version, @Query("appVersion") String appVersion, @Query("includeReferences") String includeReferences, @Query("query") String query
  );

  
}
