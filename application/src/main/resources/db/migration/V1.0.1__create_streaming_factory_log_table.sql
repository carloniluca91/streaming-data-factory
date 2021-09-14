-- create sequence for log table
CREATE SEQUENCE IF NOT EXISTS streaming_sample_id;

-- log table
CREATE TABLE IF NOT EXISTS @jdbc.log.table@ (

    sample_id INT NOT NULL DEFAULT NEXTVAL('streaming_sample_id'),
    sample_generation_ts TIMESTAMP NOT NULL,
    sample_generation_dt DATE NOT NULL,
    dataflow_id TEXT NOT NULL,
    dataflow_type TEXT NOT NULL,
    dataflow_class TEXT NOT NULL,
    dataflow_url TEXT NOT NULL,
    sample_generation_code TEXT NOT NULL,
    exception_class TEXT,
    exception_message TEXT,
    insert_ts TIMESTAMP NOT NULL DEFAULT NOW(),
    insert_dt DATE NOT NULL DEFAULT NOW()::DATE,
    PRIMARY KEY (sample_id)
);

COMMENT ON COLUMN @jdbc.log.table@.sample_id IS 'Id of generated sample';
COMMENT ON COLUMN @jdbc.log.table@.sample_generation_ts IS 'Timestamp of generated sample';
COMMENT ON COLUMN @jdbc.log.table@.sample_generation_dt IS 'Date of generated sample';
COMMENT ON COLUMN @jdbc.log.table@.dataflow_id IS 'Human readable dataFlow id';
COMMENT ON COLUMN @jdbc.log.table@.dataflow_type IS 'JSON|XML';
COMMENT ON COLUMN @jdbc.log.table@.dataflow_class IS 'FQ name of generated sample class';
COMMENT ON COLUMN @jdbc.log.table@.dataflow_url IS 'DataFlow target URL';
COMMENT ON COLUMN @jdbc.log.table@.sample_generation_code IS 'OK|KO';
COMMENT ON COLUMN @jdbc.log.table@.exception_class IS 'FQ name of exception raised by sample generation process';
COMMENT ON COLUMN @jdbc.log.table@.exception_message IS 'Message of exception raised by sample generation process';
COMMENT ON COLUMN @jdbc.log.table@.insert_ts IS 'Timestamp of table record';
COMMENT ON COLUMN @jdbc.log.table@.insert_dt IS 'Date of table record';
