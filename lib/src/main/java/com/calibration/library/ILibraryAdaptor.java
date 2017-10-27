package com.calibration.library;

import com.calibration.CalibrationInfo;

public interface ILibraryAdaptor<O, R, C> {
    O calibrate(CalibrationInfo<R, C> calibrationInfo);
}
