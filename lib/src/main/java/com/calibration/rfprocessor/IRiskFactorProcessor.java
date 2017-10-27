package com.calibration.rfprocessor;

import com.calibration.vocabulary.RiskFactorId;

public interface IRiskFactorProcessor<S> {
    S startProcessing(RiskFactorId riskFactorId);

    void visit(S state, RiskFactorId riskFactorId);

    void endProcessing(S state);
}
