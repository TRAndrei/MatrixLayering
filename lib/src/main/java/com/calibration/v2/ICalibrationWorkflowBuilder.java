package com.calibration.v2;

import com.calibration.CalibrationId;
import com.calibration.context.IContext;
import com.calibration.context.IContextBuilder;
import com.calibration.vocabulary.RiskFactorId;

import java.util.List;

public interface ICalibrationWorkflowBuilder<StaticData, CurveData> {

    ICalibrationWorkflowBuilder withRiskFactorGrouper(IRiskFactorGrouper riskFactorGrouper);

    <P, K> ICalibrationWorkflowBuilder withPrecomputedDataProvider(IDataCollector<P, K>
                                                                           precomputedDataKeyProvider,
                                                                   IDataCache<K,
                                                                           StaticData>
                                                                           precomputedDataCache);

    <S, K> ICalibrationWorkflowBuilder withStaticDataCollector(IDataCollector<S, StaticData>
                                                                       staticDataCollector,
                                                               IDataCache<K,
                                                                       StaticData>
                                                                       precomputedDataCache);

    <C> ICalibrationWorkflowBuilder withCurveDataCollector(IDataCollector<C, CurveData>
                                                                   curveDataCollector);

    <O, K, V> ICalibrationWorkflowBuilder withLibraryAdaptor(ICalibrationLibrary<O, StaticData,
            CurveData> calibrationLibrary, IDataCache<K, V> dataCache);

    ICalibrationEngine build();

    interface IRiskFactorGrouper<K> {
        void init(IContext context);

        K getGroupKey(RiskFactorId riskFactorId);
    }

    interface IDataCollector<S, T> {
        S init(IContext context, RiskFactorId first, CalibrationId calibrationId);

        List<Runnable> onRiskFactor(S state, IContext context, RiskFactorId riskFactorId);

        T end(S state, IContext context, CalibrationId calibrationId);
    }

    interface IDataCache<K, V> {
        V get(K key);

        void put(K key, V value);
    }

    interface IResultConsumer<O> {
        List<Runnable> consumeResults(O results, IContextBuilder contextBuilder);
    }

    interface ICalibrationLibrary<O, StaticData, CurveData> {
        void calibrate(IContext context, StaticData staticData, CurveData curveData,
                       IResultConsumer<O> resultConsumer);
    }

    interface ICalibrationEngine {
        void calibrate(IContext context, IContextBuilder contextBuilder, CalibrationId
                calibrationId);
    }
}
