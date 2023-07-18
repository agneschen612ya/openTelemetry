# openTelemetry
This project is to send metrics out by using open telemetry  APIs to AMP(Amazon Managed Service for Prometheus) severs
# Prerequisite
Create a AMP workshop to get the AMP-End point
# Procedure
1.Using io.opentelemetry.sdk.metrics.SdkMeterProvider , io.opentelemetry.api.metrics.Meter and 
io.opentelemetry.api.metrics.MeterProvider APIs to create MeterProvider and Meter

2.Using io.opentelemetry.api.metrics.DoubleCounter and io.opentelemetry.api.metrics.DoubleCounterBuilder APIs to create a DoubleCounter

3.Generate and record synthetic metric values

4.Export metrics to AMP using OTLP exporter to send metrics to the AMP sever by using AMP-End point URL
# Problems
The OtlpMetricExporter class exists but it has to be used with the IntervalMetricReader,the IntervalMetricReader is deprecated, so can not use it.We need to find the correct method to export the metrics.



