
# play-frontend-libraries-microbenchmarking

Here we micro benchmark PlatUI frontend libraries using an SBT plugin [sbt-jmh](https://github.com/ktoso/sbt-jmh) which leverages [Java Microbenchmark Harness](http://openjdk.java.net/projects/code-tools/jmh/)


### Usage
An example of running it on the SBT console:
```
jmh:run -i 3 -wi 3 -f1 -t1 .*
```
which means "3 iterations" "3 warmup iterations" "1 fork" "1 thread". 
**Please note that benchmarks should be usually executed at least in 10 iterations (as a rule of thumb), but more is better.**

For "real" results we recommend to at least warm up 10 to 20 iterations, and then measure 10 to 20 iterations again. 
Forking the JVM is required to avoid falling into specific optimisations (no JVM optimisation is really "completely" predictable)
```
jmh:run -i 20 -wi 10 -f1 -t4 .*
```

To use custom runner class with runMain: 
```
jmh:runMain uk.gov.hmrc.microbenchmarking.runner.CustomRunnerApp -i 10 .* 
```


### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").