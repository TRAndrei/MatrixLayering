package com.calibration.splitters;

import com.calibration.context.IContext;
import com.calibration.vocabulary.RiskFactorId;

import java.util.BitSet;
import java.util.Map;

public class SingleRiskFactorSplitter implements ISplitRiskFactors {

    @Override
    public <S> void visitRiskFactors(IContext context, IRiskFactorsGroupConsumer<S>
            riskFactorsGroupConsumer) {
        for(Map.Entry<RiskFactorId, BitSet> entry : context.getRiskFactorSimulations().entrySet()) {
            RiskFactorId riskFactorId = entry.getKey();
            BitSet simulations = entry.getValue();

            S state = riskFactorsGroupConsumer.startGroup(context, riskFactorId, simulations);
            riskFactorsGroupConsumer.visit(state, context, riskFactorId, simulations);
            riskFactorsGroupConsumer.endGroup(state, context);
        }
    }
}
