package com.matrixlayering.api;

import java.util.Set;

/**
 * A builder for constructing chains of overlapping matrices. An individual layer can be fully or
 * partially populated using the {@link ILayer} {@link IWriter} interface. Reading values from a
 * {@link ILayer} using its {@link IReader} combines existing values from the current layer with
 * values from the previous layer. The coordinates of the values in the previous layer corresponding
 * to missing values in the current layer are obtained via the {@link ICoordinateLink} links.
 */
public interface ILayerBuilder {
    /**
     * Sets the layer whose data can be used to provide a default for any missing values in this
     * layer.
     *
     * @param previousLayer the previous layer
     * @return the layer builder (self)
     */
    ILayerBuilder after(ILayer previousLayer);

    /**
     * Sets the coordinate transformation from this layer's rows to the parent's rows. Used when
     * the current layer does not contain values a set of coordinates. Defaults to the identity
     * transform if not set.
     *
     * @param rowLink the coordinate transformation from this layer's rows to the parent layer's
     *                rows
     * @return the layer builder (self)
     */
    ILayerBuilder withRowLink(ICoordinateLink rowLink);

    /**
     * Sets the coordinate transformation from this layer's columns to the parent's columns. Used
     * when
     * the current layer does not contain values a set of coordinates. Defaults to the identity
     * transform if not set.
     *
     * @param columnLink the coordinate transformation from this layer's columns to the parent
     *                   layer's columns
     * @return the layer builder (self)
     */
    ILayerBuilder withColumnLink(ICoordinateLink columnLink);

    /**
     * Initializes this layer with the provided set of rows.
     *
     * @param rows the set of rows for the current layer
     * @return the layer builder (self)
     */
    ILayerBuilder withRows(Set<Object> rows);

    /**
     * Initializes this layer with the provided set of columns.
     *
     * @param columns the set of columns for the current layer
     * @return the layer builder (self)
     */
    ILayerBuilder withColumns(Set<Object> columns);

    /**
     * Builds a layer object with the provided characteristics.
     *
     * @return a layer object
     */
    ILayer buildLayer();
}
