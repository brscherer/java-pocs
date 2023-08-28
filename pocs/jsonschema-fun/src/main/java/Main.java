import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.*;

public class Main{
  public static void main(String args[]){
    SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2020_12, OptionPreset.PLAIN_JSON);
    SchemaGeneratorConfig config = configBuilder.with(Option.EXTRA_OPEN_API_FORMAT_VALUES)
            .without(Option.FLATTENED_ENUMS_FROM_TOSTRING)
            .build();

    SchemaGenerator generator = new SchemaGenerator(config);
    JsonNode jsonSchema = generator.generateSchema(Article.class);
    System.out.println(jsonSchema);
  }
}
