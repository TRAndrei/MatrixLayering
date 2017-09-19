package com.matrixlayering.api;

import java.util.Set;

public interface ILayer extends IReader, IWriter {
    Set<Object> getRows();

    Set<Object> getColumns();
}
