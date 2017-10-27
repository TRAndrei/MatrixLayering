package com.calibration;

import com.calibration.vocabulary.RiskFactorId;
import com.calibration.vocabulary.SimulationId;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ICalibrationTaskInputMaker {
    Iterable<ICalibrationTaskInput> split(Map<RiskFactorId, List<SimulationId>> simulationIdMap);

    interface ICalibrationTaskInput {
        Set<RiskFactorId> getRiskFactorIds();

        Iterable<SimulationId> getSimulationIds();
    }
}
