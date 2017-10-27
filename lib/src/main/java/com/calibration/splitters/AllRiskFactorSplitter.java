package com.calibration.splitters;

import com.calibration.context.IContext;
import com.calibration.vocabulary.RiskFactorId;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;

public class AllRiskFactorSplitter implements ISplitRiskFactors {

    @Override
    public <S> void visitRiskFactors(IContext context, IRiskFactorsGroupConsumer<S>
            riskFactorsGroupConsumer) {
        Iterable<Map.Entry<RiskFactorId, BitSet>> iterable = context.getRiskFactorSimulations()
                .entrySet();

        Iterator<Map.Entry<RiskFactorId, BitSet>> iterator = iterable.iterator();

        if (iterator.hasNext()) {
            Map.Entry<RiskFactorId, BitSet> entry = iterator.next();
            RiskFactorId riskFactorId = entry.getKey();
            BitSet simulations = entry.getValue();

            S state = riskFactorsGroupConsumer.startGroup(context, riskFactorId, simulations);
            riskFactorsGroupConsumer.visit(state, context, riskFactorId, simulations);

            while (iterator.hasNext()) {
                riskFactorId = iterator.next().getKey();
                riskFactorsGroupConsumer.visit(state, context, riskFactorId, simulations);
            }

            riskFactorsGroupConsumer.endGroup(state, context);
        }
    }
}
