INSERT INTO @jdbc.log.table@ (
sample_generation_ts,
sample_generation_dt,
dataflow_id,
dataflow_type,
dataflow_class,
dataflow_url,
sample_generation_code,
exception_class,
exception_message
) VALUES (
:r.getSampleGenerationTs,
:r.getSampleGenerationDt,
:r.getDataflowId,
:r.getDataflowType,
:r.getDataflowClass,
:r.getDataflowUrl,
:r.getSampleGenerationCode,
:r.getExceptionClass,
:r.getExceptionMessage
);