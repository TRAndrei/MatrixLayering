package com.calibration.curvebatch;

import com.calibration.curve.Curve;
import com.calibration.vocabulary.RiskFactorId;
import com.google.common.collect.Maps;

import java.util.Map;

public class FppBatch {
    private final Map<RiskFactorId, Curve> curveMap;


    public FppBatch() {
        curveMap = Maps.newHashMap();
    }

    public void addCurve(RiskFactorId riskFactorId, Curve curve) {
        curveMap.put(riskFactorId, curve);
    }

    public Map<RiskFactorId, Curve> getCurveMap() {
        return curveMap;
    }
}
