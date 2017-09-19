package com.matrixlayering.api;

/**
 * Defines the coordinate transformation from one layer's rows (or columns) to its parent's rows
 * (or columns).
 */
public interface ICoordinateLink {
    /**
     * Gets the previous layer's equivalent coordinate.
     *
     * @param coordinate a layer's row or column coordinate
     * @return the equivalent coordinate in the parent layer
     */
    Object getParentCoordinate(Object coordinate);
}
