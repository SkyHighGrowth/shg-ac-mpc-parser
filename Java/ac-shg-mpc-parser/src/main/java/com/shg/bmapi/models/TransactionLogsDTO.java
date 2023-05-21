package com.shg.bmapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionLogsDTO {
    private String component;
    private String createdBy;
    private String transactionRequest;
    private Integer resultStatusCode;
    private String details;
}
