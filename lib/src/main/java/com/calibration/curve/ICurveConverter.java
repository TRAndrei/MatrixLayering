package com.calibration.curve;

import com.calibration.context.IContext;
import com.calibration.vocabulary.RiskFactorId;

import java.util.BitSet;

public interface ICurveConverter {
    Curve convert(IContext context, RiskFactorId riskFactorId, BitSet simulations);
}
