package com.calibration.library;

import com.calibration.CalibrationInfo;
import com.calibration.curvebatch.FppBatch;
import com.calibration.rfprocessor.PrecomputedData;
import com.calibration.vocabulary.RiskFactorId;
import com.google.common.collect.Maps;

import java.util.Map;

public class FppLibrary implements ILibraryAdaptor<FppOutput, PrecomputedData, FppBatch> {
    @Override
    public FppOutput calibrate(CalibrationInfo<PrecomputedData, FppBatch> calibrationInfo) {
        Map<RiskFactorId, double[]> results = Maps.newHashMap();

        for (RiskFactorId riskFactorId : calibrationInfo.getRiskFactorInfo().getRiskFactorIds()) {
            results.put(riskFactorId, new double[] {});
        }

        return new FppOutput(results);
    }
}
