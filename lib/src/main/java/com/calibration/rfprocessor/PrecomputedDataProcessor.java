package com.calibration.rfprocessor;

import com.calibration.vocabulary.RiskFactorId;

public class PrecomputedDataProcessor implements IRiskFactorProcessor<PrecomputedData> {
    @Override
    public PrecomputedData startProcessing(RiskFactorId riskFactorId) {
        return new PrecomputedData();
    }

    @Override
    public void visit(PrecomputedData state, RiskFactorId riskFactorId) {
        state.addRiskFactor(riskFactorId);
    }

    @Override
    public void endProcessing(PrecomputedData state) {

    }
}
