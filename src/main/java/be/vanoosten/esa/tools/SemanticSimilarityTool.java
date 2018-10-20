package be.vanoosten.esa.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import joptsimple.internal.Strings;
import org.apache.lucene.queryparser.classic.ParseException;

/**
 * Calculates a numeric value for the semantic similarity between two texts.
 * @author Philip van Oosten
 */
public class SemanticSimilarityTool {

    private Vectorizer vectorizer;
    
    public SemanticSimilarityTool(Vectorizer vectorizer) {
        this.vectorizer = vectorizer;
    }
    
    public float findSemanticSimilarity(String textA, String textB) {
        try {
            if (Strings.isNullOrEmpty(textA) || Strings.isNullOrEmpty(textB))
                return 0.0f;

            ConceptVector vectorA = vectorizer.vectorize(textA);
            ConceptVector vectorB = vectorizer.vectorize(textB);
            return vectorA.dotProduct(vectorB);
        }
        catch(ParseException|IOException e)
        {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public float findSemanticSimilarity(byte[] bytesA, byte[] bytesB) {
        try {
            return findSemanticSimilarity(new String(bytesA, "UTF-8"), new String(bytesB, "UTF-8"));
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }
    
}
