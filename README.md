# tdd-workshop
A workshop for using TDD to drive the development of the stack data structure


To ensure that we are using TDD, this project is using [pitest](http://pitest.org/).

# Running tests with maven
` mvn org.pitest:pitest-maven:scmMutationCoverage -Dinclude=ADDED,UNKNOWN -DmutationThreshold=85`

runs test coverage for the files added since the last commit. If you haven't added any files, you can use:

`mvn -DwithHistory org.pitest:pitest-maven:mutationCoverage -DmutationThreshold=85`
