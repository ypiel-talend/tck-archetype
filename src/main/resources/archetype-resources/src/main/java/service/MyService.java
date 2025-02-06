#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ${package}.config.MyConnection;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.service.Service;
import org.talend.sdk.component.api.service.completion.SuggestionValues;
import org.talend.sdk.component.api.service.completion.Suggestions;

@Service
public class MyService {

    public static final String LIST_ENTITIES = "listEntities";

    @Suggestions(LIST_ENTITIES)
    public SuggestionValues retrieveListEntities(@Option final MyConnection connection) {
        // here you can implement a service that use the connection to retrieve elements
        List<SuggestionValues.Item> items = IntStream.range(0, 10)
                .mapToObj(i -> new SuggestionValues.Item("entity_" + i, "The label of entity " + i))
                .collect(Collectors.toList());
        return new SuggestionValues(true, items);
    }

}