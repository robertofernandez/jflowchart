package studio.itpex.apps.jflowchart.graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.com.sodhium.commons.math.DoubleCoordinates;

public class GraphDocumentTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAsSvg() {
        ChartGraphNode root = new StartNode(12D, 15D);
        root.setOffset(new DoubleCoordinates(50D, 30D));
        
        GraphDocument document = new GraphDocument(root, 210, 297);
        
        System.out.print(document.asSvg());
    }

    @Test
    public void firstSimpleDocument() {
        ChartGraphNode root = new StartNode(12D, 15D);
        //root.setOffset(new DoubleCoordinates(50D, 30D));

        SimpleGraphDocument document = new SimpleGraphDocument(420, 800);

        document.addNode(new ScreenOutputNode("'Insert a number'"));
        document.addNode(root);
        document.addNode(new ScreenOutputNode("'Insert another number'"));
        ChartGraphNode r2 = new InputNode("a, b");
        ChartGraphNode r3 = new ProcessNode("c := 4 + b");
        document.addRow();
        document.addNode(r2);
        document.addNode(r3);
        document.addRow();
        document.addNode(new SimpleDesicionNode("i < 1"));
        document.addRow();
        document.addRow();
        document.addNode(new ScreenOutputNode("'Your result is' + a"));
        document.addRow();
        document.addNode(new EndNode());

        System.out.print(document.asSvg());
    }

    @Test
    public void exerciseVowels() {
        SimpleGraphDocument document = new SimpleGraphDocument(800, 600);

        document.addNode(new StartNode(12D, 15D));
        document.addRow();
        document.addNode(new ScreenOutputNode("'Insert a character'"));
        document.addRow();
        document.addNode(new InputNode("character"));
        document.addRow();
        document.addNode(new ProcessNode("nChar := toLowerCase(character)"));
        document.addRow();
        document.addNode(new SimpleDesicionNode("nChar = 'a'"));
        document.addNode(new SimpleDesicionNode("nChar = 'e'"));
        document.addNode(new SimpleDesicionNode("nChar = 'i'"));
        document.addNode(new SimpleDesicionNode("nChar = 'o'"));
        document.addNode(new SimpleDesicionNode("nChar = 'u'"));
        document.addNode(new ScreenOutputNode("character + ' is a vowel'"));
        document.addRow();
        document.addNode(new ScreenOutputNode("character + ' is NOT a vowel'"));
        document.addNode(new EndNode());

        System.out.print(document.asSvg());
    }
    
    @Test
    public void exerciseVowels2() {
        SimpleGraphDocument document = new SimpleGraphDocument(800, 600);

        //document.addNode(new StartNode(12D, 15D));
        document.addRow();
        //document.addNode(new ScreenOutputNode("'Insert a character'"));
        document.addRow();
        document.addNode(new InputNode("character"));

        System.out.print(document.asSvg());
    }

}
