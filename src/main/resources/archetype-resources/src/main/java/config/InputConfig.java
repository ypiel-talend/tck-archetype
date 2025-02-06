#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.meta.Documentation;

import lombok.Data;

@Data
@GridLayout({
        @GridLayout.Row({"dataset"}),
        @GridLayout.Row({"attributes"})
})
@GridLayout(names = GridLayout.FormType.ADVANCED, value = {
        @GridLayout.Row({"dataset"})
})
public class InputConfig implements Serializable {

    @Option
    @Documentation("The dataset configuration.")
    private MyDataset dataset;

    @Option
    @Documentation("The selected attributes.")
    private List<AttributesConf> attributes = new ArrayList<>();


    @GridLayout({
            @GridLayout.Row({"name", "type"})
    })
    @Data
    public class AttributesConf implements Serializable{

        @Option
        @Documentation("The attribute's name.")
        private String name;

        @Option
        @Documentation("The attribute's type.")
        private Types type = Types.STRING;

    }

    enum Types{
        STRING, INTEGER, DOUBLE, BOOLEAN;
    }

}
