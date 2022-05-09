package com.company.JavaCore.Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty(value = "Minimum")
    private TemperatureDescription minimum;
    @JsonProperty(value = "Maximum")
    private TemperatureDescription maximum;
}
