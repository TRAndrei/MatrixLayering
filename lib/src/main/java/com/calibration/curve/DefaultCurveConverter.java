package com.calibration.curve;

import com.calibration.context.IContext;
import com.calibration.vocabulary.RiskFactorId;

import java.util.BitSet;

public class DefaultCurveConverter implements ICurveConverter {
    @Override
    public Curve convert(IContext context, RiskFactorId riskFactorId, BitSet simulations) {
        return new Curve(riskFactorId, new double[] {});
    }
}
