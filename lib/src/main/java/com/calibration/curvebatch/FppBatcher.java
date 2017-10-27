package com.calibration.curvebatch;

import com.calibration.context.IContext;
import com.calibration.curve.ICurveConverter;
import com.calibration.vocabulary.RiskFactorId;

import java.util.BitSet;

public class FppBatcher implements ICurveBatching<FppBatch> {
    private final ICurveConverter curveConverter;

    public FppBatcher(ICurveConverter curveConverter) {
        this.curveConverter = curveConverter;
    }

    @Override
    public FppBatch startBatch(IContext context, RiskFactorId riskFactorId, BitSet simulations) {
        return new FppBatch();
    }

    @Override
    public void visit(FppBatch state, IContext context, RiskFactorId riskFactorId, BitSet simulations) {
        state.addCurve(riskFactorId, curveConverter.convert(context, riskFactorId, simulations));
    }

    @Override
    public void endBatch(FppBatch state, IContext context) {

    }
}
