package com.foodngo.recipe;

import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class PdfParserTest {


    @Test
    public void test() throws URISyntaxException {

        PdfIngredientMapper pdfIngredientMapper = new PdfIngredientMapper(Paths.get(getClass().getClassLoader().getResource("recipies1.pdf").toURI()));


        pdfIngredientMapper.parse();
    }


}
