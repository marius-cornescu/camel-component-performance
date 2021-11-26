package com.rtzan.performance;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@Fork(value = 3, warmups = 0)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 10)
@Measurement(iterations = 5, time = 10)
/*
 * Thread: Each thread running the benchmark will create its own instance of the state object.
 * Group: Each thread group running the benchmark will create its own instance of the state object.
 * Benchmark: All threads running the benchmark share the same state object.
 */
@State(Scope.Benchmark)
public class TemplateAnalysis {

    private double rightX = Math.PI;
    private final double wrongX = Math.PI;

    @Benchmark
    public double wrong() {
        return Math.log(wrongX);
    }

    @Benchmark
    public double right() {
        return Math.log(rightX);
    }
}
