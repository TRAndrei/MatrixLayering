package com.calibration.splitters;

import com.calibration.context.IContext;
import com.calibration.vocabulary.RiskFactorId;

import java.util.BitSet;

public interface ISplitRiskFactors {
    <S> void visitRiskFactors(IContext context, IRiskFactorsGroupConsumer<S>
            riskFactorsGroupConsumer);

    interface IRiskFactorsGroupConsumer<S> {
        S startGroup(IContext context, RiskFactorId riskFactorId, BitSet simulations);

        void visit(S state, IContext context, RiskFactorId riskFactorId, BitSet simulations);

        void endGroup(S state, IContext context);
    }
}
