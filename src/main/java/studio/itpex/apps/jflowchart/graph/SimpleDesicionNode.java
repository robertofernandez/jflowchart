package studio.itpex.apps.jflowchart.graph;

import org.apache.commons.lang.StringEscapeUtils;

import ar.com.sodhium.commons.math.DoubleCoordinates;

public class SimpleDesicionNode extends ChartGraphNode {
    private Double fontSize;
    private Double width;
    private Double height;
    private String condition;

    public SimpleDesicionNode(String condition) {
        this(12D, 30D, 20D, condition);
    }
    
    public SimpleDesicionNode(Double fontSize, Double width, Double height, String condition) {
        this.fontSize = fontSize;
        this.width = width;
        this.height = height;
        this.condition = StringEscapeUtils.escapeHtml(condition);
    }

    @Override
    public void setOffset(DoubleCoordinates offset) {
        super.setOffset(offset);
    }

    @Override
    public String asSvg() {
        return "<!-- rombo de decision de 60x40, cuyo vertice superior esta en 40, 20  (el resto de los puntos se definen relativos al anterior) -->\r\n"
                + "      <path\r\n"
                + "         id=\"path836\"\r\n"
                + "         d=\"m " + (getOffset().getX() + width) + "," + getOffset().getY() + "\r\n"
                + "             " + (-1D* width) + "," + height + "\r\n"
                + "             " + width + "," + height + "\r\n"
                + "             " + width + "," + (-1D*height) + " z\"\r\n"
                + "         inkscape:connector-curvature=\"0\"\r\n"
                + "         style=\"fill:#ffeecc;stroke:#000000\" />\r\n"
                + "\r\n"
                + "<!-- flecha que sale de 110,40 -->\r\n"
                + "    <path\r\n"
                + "       style=\"fill:none;stroke:#000000;stroke-width:0.5;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1;stroke-miterlimit:4;stroke-dasharray:none;marker-end:url(#marker1121)\"\r\n"
                + "       d=\"m " + (getOffset().getX() + 2D * width) + "," + (getOffset().getY() + height)
                + " 30,0 0,30\"\r\n"
                + "       id=\"path849\"\r\n"
                + "       inkscape:connector-curvature=\"0\" />\r\n"
                + "       \r\n"
                + "    <path\r\n"
                + "       style=\"fill:none;stroke:#000000;stroke-width:0.5;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1;stroke-miterlimit:4;stroke-dasharray:none;marker-end:url(#marker1121)\"\r\n"
                + "       d=\"m " + (getOffset().getX() - 0D * width) + "," + (getOffset().getY() + height)
                + " -30,0 0,30\"\r\n"
                + "       id=\"path849\"\r\n"
                + "       inkscape:connector-curvature=\"0\" />\r\n"
                + "       \r\n"
                + "     <!-- aca hay que calcular el largo del texto, tratando de que quede centrado en 40, 40-->\r\n"
                + "    <text\r\n"
                + "       xml:space=\"preserve\"\r\n"
                + "       style=\"font-style:normal;font-weight:normal;font-size:10.58333302px;line-height:1.25;font-family:sans-serif;letter-spacing:0px;word-spacing:0px;fill:#000000;fill-opacity:1;stroke:none;stroke-width:0.26458332\"\r\n"
                + "         x=\""+ (getOffset().getX() + width) + "\"\r\n"
                + "         y=\"" + (getOffset().getY() + height) + "\"\r\n"
                + "       id=\"text1125\"><tspan\r\n"
                + "         sodipodi:role=\"line\"\r\n"
                + "         id=\"tspan1123\"\r\n"
                + "         x=\""+ (getOffset().getX() + width) + "\"\r\n"
                + "         y=\"" + (getOffset().getY() + height) + "\"\r\n"
                + "         style=\"font-size:" + fontSize + "px;letter-spacing:-0.00264583px;word-spacing:0px;stroke-width:0.26458332;text-anchor:middle;text-align:center\">" + condition + "</tspan></text>\r\n"
                + "\r\n"
                + "    <text\r\n"
                + "       xml:space=\"preserve\"\r\n"
                + "       style=\"font-style:normal;font-weight:normal;font-size:10.58333302px;line-height:1.25;font-family:sans-serif;letter-spacing:0px;word-spacing:0px;fill:#000000;fill-opacity:1;stroke:none;stroke-width:0.26458332\"\r\n"
                + "         x=\""+ (getOffset().getX() - 0.5D * width) + "\"\r\n"
                + "         y=\"" + (getOffset().getY() + height - 3D) + "\"\r\n"
                + "       id=\"text1125\"><tspan\r\n"
                + "         sodipodi:role=\"line\"\r\n"
                + "         id=\"tspan1123\"\r\n"
                + "         x=\""+ (getOffset().getX() - 0.5D * width) + "\"\r\n"
                + "         y=\"" + (getOffset().getY() + height - 3D) + "\"\r\n"
                + "         style=\"font-size:" + (fontSize - 2) + "px;letter-spacing:-0.00264583px;word-spacing:0px;stroke-width:0.26458332;text-anchor:middle;text-align:center\">si</tspan></text>\r\n"
                + "         \r\n"
                + "    <text\r\n"
                + "       xml:space=\"preserve\"\r\n"
                + "       style=\"font-style:normal;font-weight:normal;font-size:10.58333302px;line-height:1.25;font-family:sans-serif;letter-spacing:0px;word-spacing:0px;fill:#000000;fill-opacity:1;stroke:none;stroke-width:0.26458332\"\r\n"
                + "         x=\""+ (getOffset().getX() + width * 2.5D) + "\"\r\n"
                + "         y=\"" + (getOffset().getY() + height - 3D) + "\"\r\n"
                + "       id=\"text1125\"><tspan\r\n"
                + "         sodipodi:role=\"line\"\r\n"
                + "         id=\"tspan1123\"\r\n"
                + "         x=\""+ (getOffset().getX() + width * 2.5D) + "\"\r\n"
                + "         y=\"" + (getOffset().getY() + height - 3D) + "\"\r\n"
                + "         style=\"font-size:" + (fontSize - 2) + "px;letter-spacing:-0.00264583px;word-spacing:0px;stroke-width:0.26458332;text-anchor:middle;text-align:center\">no</tspan></text>\r\n";
    }

}
