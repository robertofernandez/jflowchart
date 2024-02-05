package studio.itpex.apps.jflowchart.graph;

import ar.com.sodhium.commons.math.DoubleCoordinates;

public class StartNode extends ChartGraphNode {
    private Double fontSize;
    private Double radius;

    public StartNode() {
        this(12D, 15D);
    }
    
    public StartNode(Double fontSize, Double radius) {
        this.fontSize = fontSize;
        this.radius = radius;
    }

    @Override
    public void setOffset(DoubleCoordinates offset) {
        super.setOffset(offset);
        relationPoints.get(Direction.SOUTH).add(new DoubleCoordinates(offset.getX(), offset.getY() + radius));
    }

    @Override
    public String asSvg() {
        return "  <circle\r\n"
                + "     style=\"opacity:0.98999999;fill:#5671ff;fill-opacity:1;stroke:#000000;stroke-width:1.00157475;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1\"\r\n"
                + "     id=\"path1712\"\r\n"
                + "       cx=\""+ getOffset().getX() + "\"\r\n"
                + "       cy=\"" + getOffset().getY() + "\"\r\n"
                + "     r=\""+ radius + "\" />\r\n"
                + "   \r\n"
                + "    <text\r\n"
                + "       xml:space=\"preserve\"\r\n"
                + "       style=\"font-style:normal;font-weight:normal;font-size:10.58333302px;line-height:1.25;font-family:sans-serif;letter-spacing:0px;word-spacing:0px;fill:#000000;fill-opacity:1;stroke:none;stroke-width:0.26458332\"\r\n"
                + "       x=\""+ getOffset().getX() + "\"\r\n"
                + "       y=\"" + getOffset().getY() + "\"\r\n"
                + "       id=\"text1125\"><tspan\r\n"
                + "         sodipodi:role=\"line\"\r\n"
                + "         id=\"tspan1123\"\r\n"
                + "       x=\""+ getOffset().getX() + "\"\r\n"
                + "       y=\"" + (getOffset().getY() + fontSize / 4) + "\"\r\n"
                + "         style=\"font-size:"+fontSize.intValue() + ";letter-spacing:-0.00264583px;word-spacing:0px;stroke-width:0.26458332;text-anchor:middle;text-align:center\">c</tspan></text>";
    }

}
