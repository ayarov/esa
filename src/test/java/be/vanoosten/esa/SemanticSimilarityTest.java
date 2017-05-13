package be.vanoosten.esa;

import be.vanoosten.esa.tools.SemanticSimilarityTool;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SemanticSimilarityTest {

    SemanticSimilarityTool similarity;

    public SemanticSimilarityTest() {
        similarity = new SemanticSimilarityTool(new EnwikiFactory().getOrCreateVectorizer());
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSimilarity() throws Exception {
        float dotProduct = similarity.findSemanticSimilarity("New York City",
                "Lower Manhattan");
        assertTrue(dotProduct > 0.0f);
    }
}
