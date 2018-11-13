import com.foodngo.recipe.IngredientMapper
import com.foodngo.recipe.PdfIngredientMapper
import com.foodngo.recipe.SimpleIngredientMapper
import spock.lang.*

import java.nio.file.Paths

class SimpleIngredientMapperTest extends Specification  {

    def "should parse product " () {
        given :
            IngredientMapper mapper = new SimpleIngredientMapper()
        when :
            def ingredient = mapper.parseIngredient("200g butter")
        then :
            ingredient.isPresent()
            ingredient.get().amount() == 200


     }
    
    def "should parse pdf document" () {
        given :
            IngredientMapper mapper = new PdfIngredientMapper(Paths.get(getClass().getClassLoader().getResource("recipes1.pdf").toURI()))
        when :
            def ingredients = mapper.parse()
        then :
             print(ingredients)
    }

}