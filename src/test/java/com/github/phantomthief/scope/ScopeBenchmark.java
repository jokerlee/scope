package com.github.phantomthief.scope;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

import com.google.common.collect.ImmutableSet;

/**
 * @author lijie <lijie02@kuaishou.com>
 * Created on 2019-07-03
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 3, time = 3)
@Threads(8)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class ScopeBenchmark {

    private static ScopeKey<Long> longScopeKey = ScopeKey.withDefaultValue(0L);
    private static ScopeKey<String> stringScopeKey = ScopeKey.withDefaultValue("asdasdasd");
    private static ScopeKey<Integer> intScopeKey = ScopeKey.withDefaultValue(122);
    private static ScopeKey<Set<String>> setScopeKey = ScopeKey.withInitializer(() -> ImmutableSet.of("11", "22", "33"));

    private static ScopeKey2<Long> longScopeKey2 = ScopeKey2.withDefaultValue(0L);
    private static ScopeKey2<String> stringScopeKey2 = ScopeKey2.withDefaultValue("asdasdasd");
    private static ScopeKey2<Integer> intScopeKey2 = ScopeKey2.withDefaultValue(122);
    private static ScopeKey2<Set<String>> setScopeKey2 = ScopeKey2.withInitializer(() -> ImmutableSet.of("11", "22", "33"));

    @Benchmark
    public void benchmarkGet() {
        longScopeKey.get();
        stringScopeKey.get();
        intScopeKey.get();
        setScopeKey.get();
    }

    @Benchmark
    public void benchmarkGet2() {
        longScopeKey2.get();
        stringScopeKey2.get();
        intScopeKey2.get();
        setScopeKey2.get();
    }

}
