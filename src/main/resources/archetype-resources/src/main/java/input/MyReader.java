#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.input;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import ${package}.config.InputConfig;
import org.talend.sdk.component.api.component.Icon;
import org.talend.sdk.component.api.component.Version;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.input.Emitter;
import org.talend.sdk.component.api.input.Producer;
import org.talend.sdk.component.api.meta.Documentation;
import org.talend.sdk.component.api.record.Record;
import org.talend.sdk.component.api.service.record.RecordBuilderFactory;

import lombok.Data;


@Data
@Version(1)
@Icon(value = Icon.IconType.CUSTOM, custom = "tck")
@Emitter(name = "Reader")
@Documentation("The input connector.")
public class MyReader implements Serializable {

    private final InputConfig config;

    private final static int MAX = 10;
    private final RecordBuilderFactory factory;

    private int count;

    public MyReader(@Option("configuration") final InputConfig config,
                    final RecordBuilderFactory factory) {
        this.config = config;
        this.factory = factory;
    }

    @PostConstruct
    public void init() {
        this.count = 0;
    }

    @Producer
    public Record next() {
        if (count >= MAX) {
            // No more data
            return null;
        }

        Record.Builder builder = factory.newRecordBuilder()
                .withString("endpoint",
                        String.format("http://%s:%s/%s",
                                config.getDataset().getDatastore().getHost(),
                                config.getDataset().getDatastore().getPort(),
                                config.getDataset().getEntity()))
                .withInt("count", count++);

        if (config.getDataset().getDatastore().isHasAuthent()) {
            builder.withString("user", config.getDataset().getDatastore().getUser())
                    .withString("password", config.getDataset().getDatastore().getPassword());
        }

        return builder.build();
    }

    @PreDestroy
    public void release() {
        // Nothing to do
    }

}
