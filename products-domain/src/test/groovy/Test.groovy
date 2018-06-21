import com.foodngo.recipe.IngredientMapper
import com.foodngo.recipe.SimpleIngredientMapper
import spock.lang.*

class Test extends Specification  {

    def "product parsers should parse simple recipe" () {
        given :
            IngredientMapper mapper = new SimpleIngredientMapper()
        when :
            def ingredient = mapper.parseIngredient("200g butter")
        then :
            ingredient.isPresent()
            ingredient.get().amount() == 200


     }

}