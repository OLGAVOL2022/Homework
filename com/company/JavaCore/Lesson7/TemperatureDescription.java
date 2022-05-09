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
public class TemperatureDescription {
    private static double coefficient = 5.0 / 9.0;
    @JsonProperty(value = "Value")
    private double value;
    @JsonProperty(value = "Unit")
    private String unit;
    @JsonProperty(value = "UnitType")
    private int unitType;

    public String getCelsiusFormat() {
        return new StringBuilder().append((int)((value - 32) * coefficient))
                .append(" ")
                .append(Character.toChars(0x2103))
                .toString();
    }
}
