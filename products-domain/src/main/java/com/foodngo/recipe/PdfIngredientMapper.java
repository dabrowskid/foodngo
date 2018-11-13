package com.foodngo.recipe;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PdfIngredientMapper implements IngredientMapper {

    private final List<String> MEAL_NAMES = Arrays.asList("ŚNIADANIE", "DRUGIE ŚNIADANIE", "OBIAD", "PODWIECZOREK", "KOLACJA");

    private final Path pdfPath;

    public PdfIngredientMapper(Path pdfPath) {
        this.pdfPath = pdfPath;
    }


    @Override
    public Optional<Ingredient> parseIngredient(String line) {
        return Optional.empty();
    }

    @Override
    public List<Ingredient> parse() {


        try (PDDocument document = PDDocument.load(pdfPath.toFile())) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {

                    MEAL_NAMES.stream().filter(line::startsWith).findAny().ifPresent(
                            name -> System.out.println("\n\n\n!!!!!! UWAGA POSIŁEK !!!!!! " + name)
                    );

                    System.out.println(line);


                }

            }

        } catch (Exception e ) {
            System.out.println("Erororo ");
            e.printStackTrace();
        }

        return null;
    }
}
