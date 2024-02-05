package studio.itpex.apps.jflowchart.graph;

import java.util.ArrayList;
import java.util.HashMap;

import ar.com.sodhium.commons.math.DoubleCoordinates;

public abstract class ChartGraphNode {
    private static final Double DEFAULT_ARROW_LENGTH = 20D;
    
    private DoubleCoordinates offset;
    public HashMap<Direction, ArrayList<DoubleCoordinates>> relationPoints;

    public ChartGraphNode() {
        relationPoints = new HashMap<>();
        relationPoints.put(Direction.NORTH, new ArrayList<>());
        relationPoints.put(Direction.SOUTH, new ArrayList<>());
        relationPoints.put(Direction.WEST, new ArrayList<>());
        relationPoints.put(Direction.EAST, new ArrayList<>());
    }

    public abstract String asSvg();
    
    public ArrayList<String> svgRelationArrows(Direction direction) {
        ArrayList<String> output = new ArrayList<>();
        for (DoubleCoordinates coordinates : relationPoints.get(direction)) {
            output.add(getSvgDirectionArrow(coordinates, direction));
        }
        return output;
    }

    private String getSvgDirectionArrow(DoubleCoordinates coordinates, Direction direction) {
        Double relativeX = 0D;
        Double relativeY = 0D;

        switch (direction) {
        case SOUTH: {
            relativeX = 0D;
            relativeY = DEFAULT_ARROW_LENGTH;
            break;
        }
        case NORTH: {
            relativeX = 0D;
            relativeY = -1D * DEFAULT_ARROW_LENGTH;
            break;
        }
        case EAST: {
            relativeX = DEFAULT_ARROW_LENGTH;
            relativeY = 0D;
            break;
        }
        case WEST: {
            relativeX = -1 * DEFAULT_ARROW_LENGTH;
            relativeY = 0D;
            break;
        }
        default:
            throw new IllegalArgumentException("Unexpected value: " + direction);
        }
        return "    <path\r\n"
                + "       style=\"fill:none;stroke:#000000;stroke-width:0.5;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1;stroke-miterlimit:4;stroke-dasharray:none;marker-end:url(#marker1121)\"\r\n"    
                + "       d=\"m "+coordinates.getX() + "," + coordinates.getY() + " " + relativeX + "," + relativeY + "\"\r\n"
                + "       id=\"path849\"\r\n"
                + "       inkscape:connector-curvature=\"0\" />";
    }

    public DoubleCoordinates getOffset() {
        return offset;
    }
    
    public void setOffset(DoubleCoordinates offset) {
        this.offset = offset;
    }
    
    public HashMap<Direction, ArrayList<DoubleCoordinates>> getRelationPoints() {
        return relationPoints;
    }
    
    public void setRelationPoints(HashMap<Direction, ArrayList<DoubleCoordinates>> relationPoints) {
        this.relationPoints = relationPoints;
    }


}
