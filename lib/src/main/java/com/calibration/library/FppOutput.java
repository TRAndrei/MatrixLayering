package com.calibration.library;

import com.calibration.vocabulary.RiskFactorId;

import java.util.Map;

public class FppOutput {
    private final Map<RiskFactorId, double[]> results;

    public FppOutput(Map<RiskFactorId, double[]> results) {
        this.results = results;
    }

    public Map<RiskFactorId, double[]> getResults() {
        return results;
    }
}
