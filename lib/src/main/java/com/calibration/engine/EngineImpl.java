package com.calibration.engine;

import com.calibration.CalibrationInfo;
import com.calibration.context.IContext;
import com.calibration.context.IContextBuilder;
import com.calibration.curvebatch.FppBatch;
import com.calibration.curvebatch.ICurveBatching;
import com.calibration.library.FppOutput;
import com.calibration.library.ILibraryAdaptor;
import com.calibration.outputconverter.ILibraryOutputConverter;
import com.calibration.rfprocessor.IRiskFactorProcessor;
import com.calibration.rfprocessor.PrecomputedData;
import com.calibration.splitters.ISplitRiskFactors;
import com.calibration.splitters.ISplitRiskFactors.IRiskFactorsGroupConsumer;
import com.calibration.vocabulary.RiskFactorId;

import java.util.BitSet;

public class EngineImpl {
    ISplitRiskFactors splitRiskFactorsByBatch;

    IRiskFactorProcessor<PrecomputedData> precomputedDataIRiskFactorProcessor;
    ICurveBatching<FppBatch> curveBatching;
    ILibraryAdaptor<FppOutput, PrecomputedData, FppBatch> libraryAdaptor;
    ILibraryOutputConverter<FppOutput> outputConverter;

    public void process(IContext context, IContextBuilder contextBuilder) {
        splitRiskFactorsByBatch.visitRiskFactors(context, new
                IRiskFactorsGroupConsumer<CalibrationInfo<PrecomputedData, FppBatch>>() {
            @Override
            public CalibrationInfo<PrecomputedData, FppBatch> startGroup(IContext ctx, RiskFactorId riskFactorId, BitSet bitSet) {
                PrecomputedData precomputedData = precomputedDataIRiskFactorProcessor
                        .startProcessing(riskFactorId);
                FppBatch fppBatch = curveBatching.startBatch(ctx, riskFactorId, bitSet);

                return new CalibrationInfo<>(precomputedData, fppBatch);
            }

            @Override
            public void visit(CalibrationInfo<PrecomputedData, FppBatch> state, IContext ctx, RiskFactorId riskFactorId,
                              BitSet bitSet) {
                precomputedDataIRiskFactorProcessor.visit(state.getRiskFactorInfo(), riskFactorId);
                curveBatching.visit(state.getCurveInfo(), ctx, riskFactorId, bitSet);
            }

            @Override
            public void endGroup(CalibrationInfo<PrecomputedData, FppBatch> state, IContext ctx) {
                precomputedDataIRiskFactorProcessor.endProcessing(state.getRiskFactorInfo());
                curveBatching.endBatch(state.getCurveInfo(), ctx);

                FppOutput calibrationOutput = libraryAdaptor.calibrate(state);
                outputConverter.convert(calibrationOutput, contextBuilder);
            }
        });
    }
}
