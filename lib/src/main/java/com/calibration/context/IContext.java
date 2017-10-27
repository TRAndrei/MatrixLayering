package com.calibration.context;

import com.calibration.vocabulary.RiskFactorId;
import com.calibration.vocabulary.SimulationId;

import java.util.BitSet;
import java.util.List;
import java.util.Map;

public interface IContext {
    List<SimulationId> getSimulationIds();

    Map<RiskFactorId, BitSet> getRiskFactorSimulations();

}
