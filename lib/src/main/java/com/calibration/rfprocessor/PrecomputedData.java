package com.calibration.rfprocessor;

import com.calibration.vocabulary.RiskFactorId;
import com.google.common.collect.Sets;

import java.util.Set;

public class PrecomputedData {
    private final Set<RiskFactorId> riskFactorIds;

    public PrecomputedData() {
        this.riskFactorIds = Sets.newHashSet();
    }

    public void addRiskFactor(RiskFactorId riskFactorId) {
        riskFactorIds.add(riskFactorId);
    }

    public Set<RiskFactorId> getRiskFactorIds() {
        return riskFactorIds;
    }
}
