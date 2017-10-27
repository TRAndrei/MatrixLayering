package com.calibration;

import com.calibration.vocabulary.RiskFactorId;
import com.calibration.vocabulary.SimulationId;

import java.util.List;
import java.util.Map;

public class CalibrationTaskInputMaker implements ICalibrationTaskInputMaker {
    @Override
    public Iterable<ICalibrationTaskInput> split(Map<RiskFactorId, List<SimulationId>>
                                                             simulationIdMap) {
        return null;
    }
}
