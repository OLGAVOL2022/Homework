package com.company.JavaCore.Lesson7;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty(value = "Date")
    private OffsetDateTime date;
    @JsonProperty(value = "EpochDate")
    private int epochDate;
    @JsonProperty(value = "Temperature")
    private Temperature temperature;
    @JsonProperty(value = "Day")
    private TimeOfDay day;
    @JsonProperty(value = "Night")
    private TimeOfDay night;
    @JsonProperty(value = "Sources")
    private List<String> sources;
    @JsonProperty(value = "MobileLink")
    private String mobileLink;
    @JsonProperty(value = "Link")
    private String link;
}
