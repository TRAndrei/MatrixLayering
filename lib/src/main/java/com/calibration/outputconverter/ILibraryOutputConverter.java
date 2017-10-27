package com.calibration.outputconverter;

import com.calibration.context.IContextBuilder;

public interface ILibraryOutputConverter<O> {
    void convert(O output, IContextBuilder contextBuilder);
}
