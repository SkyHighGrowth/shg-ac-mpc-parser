package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DimensionsUpdateDTO {
    List<DimensionUpdateDTO> dimensionValueUpdateDTOList;
}
