Puppet Gatling Jenkins Plugin
================================

A Jenkins plugin that post-processes gatling simulation data to generate useful reports for Puppet


## Understanding Gatling
Within a project that uses Gatling there will be a results/${RUN_NAME}_${UNIX_TIME} folder that contains the html page and the statistics from the run. Within this folder we are primarily concerned with the stats.tsv and simulation.log files the rest are largely to support the html/javascript charts.

For example in Jenkins those file will be found at a location like this:

    /home/jenkins/workspace/gatling-vanilla-longrunning-pe28-cobbler-1size/simulation-runner/results/PE28_vanilla_1000-20131006200000/stats.tsv
    /home/jenkins/workspace/gatling-vanilla-longrunning-pe28-cobbler-1size/simulation-runner/results/PE28_vanilla_1000-20131006200000/simulation.log


You can refer to the example `stats.tsv` in `doc/` and please read the reference to the Gatling 1.x stats.tsv format in `doc/stats_tsv_breakdown.md`. There is also a `doc/simulation.log`, and a reference at `doc/simulation_log_breakdown.md`.


To understand the Scala format of the simulation/scenarios you can refer to:
http://gatling-tool.org/cheat-sheet/


Gatling largely changes its formats in the upcoming 2.0 release. For more information on the 1.x series that this currently supports as well as the upcoming changes please view the Gatling wiki at: https://github.com/excilys/gatling/wiki


## Contributing

Jenkins plugins are Maven projects. You should be able to execute:

To run tests:

```shell
    $ mvn test
```


To run a dev instance of Jenkins running your plugin code at `http://localhost:8000/jenkins`:

```shell
    $ export MAVEN_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=n"
    $ mvn hpi:run
```


To create installable plugin:

```shell
    $ mvn install
```
