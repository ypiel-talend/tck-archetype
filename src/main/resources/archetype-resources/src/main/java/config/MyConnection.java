#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import java.io.Serializable;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.condition.ActiveIf;
import org.talend.sdk.component.api.configuration.constraint.Max;
import org.talend.sdk.component.api.configuration.constraint.Min;
import org.talend.sdk.component.api.configuration.constraint.Required;
import org.talend.sdk.component.api.configuration.type.DataStore;
import org.talend.sdk.component.api.configuration.ui.DefaultValue;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.configuration.ui.widget.Credential;
import org.talend.sdk.component.api.meta.Documentation;

import lombok.Data;

@Data
@DataStore("MyConnection")
@GridLayout({
        @GridLayout.Row({"host"}),
        @GridLayout.Row({"hasAuthent"}),
        @GridLayout.Row({"user"}),
        @GridLayout.Row({"password"})
})
@GridLayout(names = GridLayout.FormType.ADVANCED, value = {
        @GridLayout.Row({"port"})
})
public class MyConnection implements Serializable {

    @Option
    @Required
    @Documentation("The connection URL.")
    private String host;

    @Option
    @Required
    @Min(0)
    @Max(65536)
    @Documentation("The connection port.")
    @DefaultValue("22")
    private int port = 22;

    @Option
    @Documentation("A login/password is required.")
    private boolean hasAuthent;

    @Option
    @Documentation("The user login.")
    @ActiveIf(target = "hasAuthent", value = "true")
    private String user;

    @Option
    @Credential
    @Documentation("The user password.")
    @ActiveIf(target = "hasAuthent", value = "true")
    private String password;

}
