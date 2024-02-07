package studio.itpex.apps.jflowchart.graph;

import java.util.ArrayList;

import ar.com.sodhium.commons.math.DoubleCoordinates;

public class SimpleGraphDocument {
    private ArrayList<ArrayList<ChartGraphNode>> nodes;
    private Integer width;
    private Integer height;

    public SimpleGraphDocument(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        nodes = new ArrayList<>();
        nodes.add(new ArrayList<>());
    }
    
    public void addNode(ChartGraphNode node) {
        nodes.get(nodes.size() - 1).add(node);
    }

    public void addRow() {
        nodes.add(new ArrayList<>());
    }

    public String asSvg() {
        String output = "<svg\r\n"
                + "   xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\r\n"
                + "   xmlns:cc=\"http://creativecommons.org/ns#\"\r\n"
                + "   xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\r\n"
                + "   xmlns:svg=\"http://www.w3.org/2000/svg\"\r\n"
                + "   xmlns=\"http://www.w3.org/2000/svg\"\r\n"
                + "   xmlns:sodipodi=\"http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd\"\r\n"
                + "   xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\"\r\n"
                + "   width=\""+ width + "mm\"\r\n"
                + "   height=\"" + height + "mm\"\r\n"
                + "   viewBox=\"0 0 " + width + " " + height +"\"\r\n"
                + "   version=\"1.1\"\r\n"
                + "   id=\"svg834\"\r\n"
                + "   inkscape:version=\"0.92.4 (5da689c313, 2019-01-14)\"\r\n"
                + "   sodipodi:docname=\"des4.svg\">\r\n"
                + "   \r\n"
                + "  <defs\r\n"
                + "     id=\"defs828\">\r\n"
                + "    <marker\r\n"
                + "       inkscape:stockid=\"TriangleOutL\"\r\n"
                + "       orient=\"auto\"\r\n"
                + "       refY=\"0.0\"\r\n"
                + "       refX=\"0.0\"\r\n"
                + "       id=\"marker1121\"\r\n"
                + "       style=\"overflow:visible\"\r\n"
                + "       inkscape:isstock=\"true\">\r\n"
                + "      <path\r\n"
                + "         id=\"path1119\"\r\n"
                + "         d=\"M 5.77,0.0 L -2.88,5.0 L -2.88,-5.0 L 5.77,0.0 z \"\r\n"
                + "         style=\"fill-rule:evenodd;stroke:#000000;stroke-width:1pt;stroke-opacity:1;fill:#000000;fill-opacity:1\"\r\n"
                + "         transform=\"scale(0.8)\" />\r\n"
                + "    </marker>\r\n"
                + "    <marker\r\n"
                + "       inkscape:stockid=\"TriangleOutL\"\r\n"
                + "       orient=\"auto\"\r\n"
                + "       refY=\"0.0\"\r\n"
                + "       refX=\"0.0\"\r\n"
                + "       id=\"TriangleOutL\"\r\n"
                + "       style=\"overflow:visible\"\r\n"
                + "       inkscape:isstock=\"true\">\r\n"
                + "      <path\r\n"
                + "         id=\"path993\"\r\n"
                + "         d=\"M 5.77,0.0 L -2.88,5.0 L -2.88,-5.0 L 5.77,0.0 z \"\r\n"
                + "         style=\"fill-rule:evenodd;stroke:#000000;stroke-width:1pt;stroke-opacity:1;fill:#000000;fill-opacity:1\"\r\n"
                + "         transform=\"scale(0.8)\" />\r\n"
                + "    </marker>\r\n"
                + "    <marker\r\n"
                + "       inkscape:stockid=\"Arrow1Lend\"\r\n"
                + "       orient=\"auto\"\r\n"
                + "       refY=\"0.0\"\r\n"
                + "       refX=\"0.0\"\r\n"
                + "       id=\"Arrow1Lend\"\r\n"
                + "       style=\"overflow:visible;\"\r\n"
                + "       inkscape:isstock=\"true\">\r\n"
                + "      <path\r\n"
                + "         id=\"path854\"\r\n"
                + "         d=\"M 0.0,0.0 L 5.0,-5.0 L -12.5,0.0 L 5.0,5.0 L 0.0,0.0 z \"\r\n"
                + "         style=\"fill-rule:evenodd;stroke:#000000;stroke-width:1pt;stroke-opacity:1;fill:#000000;fill-opacity:1\"\r\n"
                + "         transform=\"scale(0.8) rotate(180) translate(12.5,0)\" />\r\n"
                + "    </marker>\r\n"
                + "    <marker\r\n"
                + "       inkscape:stockid=\"Arrow1Lstart\"\r\n"
                + "       orient=\"auto\"\r\n"
                + "       refY=\"0.0\"\r\n"
                + "       refX=\"0.0\"\r\n"
                + "       id=\"Arrow1Lstart\"\r\n"
                + "       style=\"overflow:visible\"\r\n"
                + "       inkscape:isstock=\"true\">\r\n"
                + "      <path\r\n"
                + "         id=\"path851\"\r\n"
                + "         d=\"M 0.0,0.0 L 5.0,-5.0 L -12.5,0.0 L 5.0,5.0 L 0.0,0.0 z \"\r\n"
                + "         style=\"fill-rule:evenodd;stroke:#000000;stroke-width:1pt;stroke-opacity:1;fill:#000000;fill-opacity:1\"\r\n"
                + "         transform=\"scale(0.8) translate(12.5,0)\" />\r\n"
                + "    </marker>\r\n"
                + "  </defs>\r\n"
                + svgRows()
                + "\r\n"
                + "\r\n"
                + "</svg>";
        
        return output;
    }

    private String svgRows() {
        //FIXME improve
        Double defaultXOffset = 140D;
        Double defaultYOffset = 90D;

        String output = "";

        Double currentY = defaultYOffset;

        for (ArrayList<ChartGraphNode> row : nodes) {
            Double currentX = defaultXOffset;
            for (ChartGraphNode node : row) {
                node.setOffset(new DoubleCoordinates(currentX, currentY));
                output += node.asSvg();
                for (Direction direction : Direction.values()) {
                    if (!node.getRelationPoints().get(direction).isEmpty()) {
                        ArrayList<String> arrows = node.svgRelationArrows(direction);
                        output += arrows.get(0);
                    }
                }
                currentX += defaultXOffset;
            }

            currentY += defaultYOffset;
        }

        return output;
    }

}
