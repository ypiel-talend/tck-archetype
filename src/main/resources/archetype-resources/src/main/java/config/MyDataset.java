#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import java.io.Serializable;

import ${package}.service.MyService;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.action.Suggestable;
import org.talend.sdk.component.api.configuration.constraint.Required;
import org.talend.sdk.component.api.configuration.type.DataSet;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.meta.Documentation;

import lombok.Data;

@Data
@DataSet("MyDataset")
@GridLayout({
        @GridLayout.Row({"datastore"}),
        @GridLayout.Row({"entity"})
})
@GridLayout(names = GridLayout.FormType.ADVANCED, value = {
        @GridLayout.Row({"datastore"})
})
public class MyDataset implements Serializable {

    @Option
    @Documentation("The connection configuration.")
    private MyConnection datastore;

    @Option
    @Required
    @Suggestable(value = MyService.LIST_ENTITIES, parameters = {"datastore"})
    @Documentation("The entity to retrieve.")
    private String entity;

}
