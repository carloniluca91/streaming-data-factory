package it.luca.streaming.factory.app.dto;

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

    @Override
    public String toString() {

        return String.format("  messageTs: %s\n", messageTs)
                .concat(String.format("  dataSourceId: %s\n", dataSourceId))
                .concat(String.format("  httpStatus: %s\n", httpStatus))
                .concat(String.format("  ingestionOperationCd: %s\n", ingestionOperationCode))
                .concat(String.format("  ingestionOperationMsg: %s\n", ingestionOperationMessage));
    }
}
