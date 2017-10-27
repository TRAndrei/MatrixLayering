package com.calibration;

public class CalibrationInfo<R, C> {
    private final R riskFactorInfo;
    private final C curveInfo;

    public CalibrationInfo(R riskFactorInfo, C curveInfo) {
        this.riskFactorInfo = riskFactorInfo;
        this.curveInfo = curveInfo;
    }

    public R getRiskFactorInfo() {
        return riskFactorInfo;
    }

    public C getCurveInfo() {
        return curveInfo;
    }
}
