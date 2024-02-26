package studio.itpex.apps.jflowchart.graph;

import org.apache.commons.lang.StringEscapeUtils;

import ar.com.sodhium.commons.math.DoubleCoordinates;

public class InputNode extends ChartGraphNode {
    private Double fontSize;
    private String text;
    private Double width;
    private Double height;

    public InputNode(String text) {
        this(10D, 60D, 30D, text);
    }
    
    public InputNode(Double fontSize, Double width, Double height, String text) {
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

    @Override
    public String asSvg() {
        return "<g>  <path\r\n"
                + "     d=\"m " + getOffset().getX() + " " + (getOffset().getY() + height) + " l " + width/6 + " " + (-1D * height) + " h " + (5 * width / 6) + " l " + (width/-6D)  + " " + height + "z\"\r\n"
                + "     fill=\"#ccddff\"\r\n"
                + "     stroke=\"#000000\"\r\n"
                + "     id=\"path1159\" /> </g>"
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
