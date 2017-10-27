package com.calibration.curvebatch;

import com.calibration.context.IContext;
import com.calibration.vocabulary.RiskFactorId;

import java.util.BitSet;

public interface ICurveBatching<S> {
    S startBatch(IContext context, RiskFactorId riskFactorId, BitSet simulations);

    void visit(S state, IContext context, RiskFactorId riskFactorId, BitSet simulations);

    void endBatch(S state, IContext context);
}
