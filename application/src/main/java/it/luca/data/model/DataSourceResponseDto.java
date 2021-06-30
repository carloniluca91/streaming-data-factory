package it.luca.data.model;

import lombok.Data;

@Data
public class DataSourceResponseDto {

    private String messageTs;
    private String messageDt;
    private String dataSourceId;
    private String dataSourceType;
    private String ingestionOperationCode;
    private String ingestionOperationMessage;
    private String httpStatus;
    private String httpStatusDescription;
}
