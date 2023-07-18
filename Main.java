import io.opentelemetry.api.metrics.DoubleCounter;
import io.opentelemetry.api.metrics.DoubleCounterBuilder;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.export.IntervalMetricReader;


public class Main {
    public static void main(String[] args) {

        // Create MeterProvider and Meter
        MeterProvider meterProvider = SdkMeterProvider.builder().build();
        Meter meter = meterProvider.get("meter");


// Create a DoubleCounter
        DoubleCounterBuilder counterBuilder = (DoubleCounterBuilder) meter.counterBuilder("metric-name").build();
        DoubleCounter counter = counterBuilder.setDescription(" metric description").build();


// Generate and record synthetic metric values
        for (int i = 0; i < 10; i++) {
            double value = generateMetricValue();
            counter.add(value);
            Thread.sleep(1000);
        }


// Export metrics to AMP using OTLP exporter
        OtlpMetricExporter exporter = OtlpGrpcMetricExporter.builder()
                .setEndpoint("https://aps-workspaces.us-east-2.amazonaws.com/workspaces/ws-05ea38bc-a83a-4087-a5db-96d0f4f46736/api/v1/remote_write")
                .build();
    }

    private static double generateMetricValue() {
// Generate a synthetic metric value
        return Math.random() * 100;
    }

}