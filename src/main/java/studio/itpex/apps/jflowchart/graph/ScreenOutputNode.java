package studio.itpex.apps.jflowchart.graph;

import org.apache.commons.lang.StringEscapeUtils;

import ar.com.sodhium.commons.math.DoubleCoordinates;

public class ScreenOutputNode extends ChartGraphNode {
    private Double fontSize;
    private String text;
    private Double width;
    private Double height;

    public ScreenOutputNode(String text) {
        this(10D, 60D, 30D, text);
    }
    
    public ScreenOutputNode(Double fontSize, Double width, Double height, String text) {
        this.fontSize = fontSize;
        this.width = width;
        this.height = height;
        this.text =  StringEscapeUtils.escapeHtml(text);
    }

    @Override
    public void setOffset(DoubleCoordinates offset) {
        super.setOffset(offset);
        relationPoints.get(Direction.SOUTH).add(new DoubleCoordinates(offset.getX() + width / 2, offset.getY() + height));
    }

    private String textCoordinatesFromOffset(Double relativeOffsetX, Double relativeOffsetY) {
        return "" + (getOffset().getX() + relativeOffsetX) + "," + (getOffset().getY() + relativeOffsetY);
    }
    
    @Override
    public String asSvg() {
        return "  <g\r\n"
                + "     id=\"g14\">\r\n"
                + "    <path\r\n"
                + "       id=\"path2780\"\r\n"
                + "       d=\"M " + textCoordinatesFromOffset(0D, height) + "\r\n"
                + "       C " + textCoordinatesFromOffset(-4D, height) + "\r\n"
                + "         " + textCoordinatesFromOffset(-18D, height-6D) + "\r\n"
                + "         " + textCoordinatesFromOffset(-18D, height-15D) + "\r\n"
                + "         " + textCoordinatesFromOffset(-18D, height-27D) + "\r\n"
                + "         " + textCoordinatesFromOffset(-8D, height-32D) + "\r\n"
                + "         " + textCoordinatesFromOffset(0D, height-34D) + "\r\n"
                + "       H " + (getOffset().getX() + 50D) + "\r\n"
                + "       C " + textCoordinatesFromOffset(60D, height-27D) + "\r\n"
                + "         " + textCoordinatesFromOffset(60D, height+0D) + "\r\n"
                + "         " + textCoordinatesFromOffset(57D, height+0D) + " Z\"\r\n"
                + "       inkscape:connector-curvature=\"0\"\r\n"
                + "       style=\"fill:#ffffcc;stroke:#000000\"\r\n"
                + "       sodipodi:nodetypes=\"sscccs\" />\r\n"
                + "  </g>"
                + "    <text\r\n"
                + "       xml:space=\"preserve\"\r\n"
                + "       style=\"font-style:normal;font-weight:normal;font-size:10.58333302px;line-height:1.25;font-family:sans-serif;letter-spacing:0px;word-spacing:0px;fill:#000000;fill-opacity:1;stroke:none;stroke-width:0.26458332\"\r\n"
                + "         x=\"" + (getOffset().getX() + width * 0.5D) + "\"\r\n"
                + "         y=\"" + (getOffset().getY() + height * 0.5D) + "\"\r\n"
                + "       id=\"text1125\"><tspan\r\n"
                + "         sodipodi:role=\"line\"\r\n"
                + "         id=\"tspan1123\"\r\n"
                + "         x=\"" + (getOffset().getX() + width * 0.5D) + "\"\r\n"
                + "         y=\"" + (getOffset().getY() + height * 0.5D) + "\"\r\n"
                + "         style=\"font-size:" + fontSize + "px;letter-spacing:-0.00264583px;word-spacing:0px;stroke-width:0.26458332;text-anchor:middle;text-align:center\">" + text + "</tspan></text>";
    }

}
