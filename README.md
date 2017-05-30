# tdd-workshop
A workshop for using TDD to drive the development of the stack data structure

# Writing unit tests

[JUnit](http://junit.org/junit4/) is used to run the tests.

Read through different assertions on: [fest assertions](https://github.com/alexruiz/fest-assert-2.x/wiki/One-minute-starting-guide)

To check for null pointer handling, check out Guava's [NullPointerTester](https://github.com/google/guava/blob/master/guava-testlib/src/com/google/common/testing/NullPointerTester.java). It's a great library for writing unit tests.

If there's a need for performance testing of small bits of code, [Caliper](https://github.com/google/caliper/wiki/JavaMicrobenchmarks) is a great tool to measure performance. [Best Practices for using Caliper](https://github.com/google/caliper/wiki/BestPractices)

To ensure that we are using TDD, this project is using [pitest](http://pitest.org/).

# Running tests with maven
` mvn org.pitest:pitest-maven:scmMutationCoverage -Dinclude=ADDED,UNKNOWN -DmutationThreshold=85`

runs test coverage for the files added since the last commit. If you haven't added any files, you can use:

`mvn -DwithHistory org.pitest:pitest-maven:mutationCoverage -DmutationThreshold=85`
