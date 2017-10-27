package com.calibration.curve;

import com.calibration.vocabulary.RiskFactorId;

public class Curve {
    private final RiskFactorId riskFactorId;
    private final double[] values;

    public Curve(RiskFactorId riskFactorId, double[] values) {
        this.riskFactorId = riskFactorId;
        this.values = values;
    }

    public RiskFactorId getRiskFactorId() {
        return riskFactorId;
    }

    public double[] getValues() {
        return values;
    }
}
