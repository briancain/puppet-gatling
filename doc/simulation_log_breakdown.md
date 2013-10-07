

Gatling Simulation Log
==============================================================================

  Gatling creates a log for each simulation. The log is made of lines
of different types. Each type of line is a list of tab separated values.
The format must begin with a line of type *RUN* followed by one or
more scenarios. A Scenario begins with a *SCENARIO* line follwed by zero
or more groups. A Group begins with a *GROUP* line followed by zero or
more *ACTION* lines.

  Here is the start of an example simulation.log

      RUN	20131006200000	PE28_vanilla_1000	PE28VanillaCent5 long-running, 1000 instances, 2 repetitions
      SCENARIO	PE28VanillaCent5	1	START	1381114801868
      GROUP	PE28VanillaCent5	PE28VanillaCent5	1	START	1381114801872
      ACTION	PE28VanillaCent5	1	filemeta plugins	1381114801928	1381114802723	1381114803399	1381114803477	OK	 
      SCENARIO	PE28VanillaCent5	2	START	1381114803666
      GROUP	PE28VanillaCent5	PE28VanillaCent5	2	START	1381114803666
      ACTION	PE28VanillaCent5	2	filemeta plugins	1381114803669	1381114803819	1381114803886	1381114803905	OK	 


  Fun.

  There is an example simulation.log in the same directory as this file.
Please copy it if you need fixtures for your work.

  Below is a break down of each line type with descriptions and more
readable formatting. Each field maps to a field in the tab separated line.
When programatically using Gatling it is noteworthy that each line
corresponds to a RequestRecord object and each field directly corresponds
to a member in that object.

  _note: these are for Gatling 1.x please see the *Notes* section for Gatling 2_


Run Format
==============================================================================

  There will one and only one RUN line at the start of every simulation.log.
This line will uniquely identify the simulation when many archived as well
as provide a human readable description.

| ID      | timestamp      | simulationId      | runDescription (optional)                                    |
|---------|----------------|-------------------|--------------------------------------------------------------|
| RUN     | 20131006200000 | PE28_vanilla_1000 | PE28VanillaCent5 long-running, 1000 instances, 2 repetitions |


Scenario Format
==============================================================================

  Each run of a Simulation must have at least one Scenario.

| Line ID  | scenarioName     | userId | event | executionDate |
|----------|------------------|--------|-------|---------------|
| SCENARIO | PE28VanillaCent5 | 1      | START | 1381114801868 |
| SCENARIO | PE28VanillaCent5 | 2      | START | 1381114803666 |
| SCENARIO | PE28VanillaCent5 | 3      | START | 1381114805467 |


Group Format
==============================================================================

| Line ID | scenarioName     | groupName        | userId | event | executionDate |
|---------|------------------|------------------|--------|-------|---------------|
| GROUP   | PE28VanillaCent5 | PE28VanillaCent5 | 1      | START | 1381114801872 |
| GROUP   | PE28VanillaCent5 | PE28VanillaCent5 | 2      | START | 1381114803666 |
| GROUP   | PE28VanillaCent5 | PE28VanillaCent5 | 3      | START | 1381114805467 |


Action Format (Basics)
==========================================================
| Line ID | scenarioName     | userId | requestName      |
|---------|------------------|--------|------------------|
| ACTION  | PE28VanillaCent5 | 2      | filemeta plugins |
| ACTION  | PE28VanillaCent5 | 3      | filemeta plugins |
| ACTION  | PE28VanillaCent5 | 1      | catalog          |


Action Format (Times)
==============================================================================================
| executionStartDate | requestSendingEndDate | responseReceivingStartDate | executionEndDate |
|--------------------|-----------------------|----------------------------|------------------|
| 1381114803669      | 1381114803819         | 1381114803886              | 1381114803905    |
| 1381114805469      | 1381114805655         | 1381114805694              | 1381114805712    |
| 1381114805573      | 1381114805758         | 1381114807649              | 1381114807680    |

Action Format (Addtl)
============================================================
| requestStatus | requestMessage (optional) | extraInfo ++ |
|---------------|---------------------------|--------------|
| OK            |                           |              |
| OK            |                           |              |
| OK            |                           |              |


Action Format (Complete)
=======================================================================================================================================================================================================
| Line ID | scenarioName     | userId | requestName      | executionStartDate | requestSendingEndDate | responseReceivingStartDate | executionEndDate | requestStatus | requestMessage | extraInfo ++ |
|---------|------------------|--------|------------------|--------------------|-----------------------|----------------------------|------------------|---------------|----------------|--------------|
| ACTION  | PE28VanillaCent5 | 2      | filemeta plugins | 1381114803669      | 1381114803819         | 1381114803886              | 1381114803905    | OK            |                |              |
| ACTION  | PE28VanillaCent5 | 3      | filemeta plugins | 1381114805469      | 1381114805655         | 1381114805694              | 1381114805712    | OK            |                               |
| ACTION  | PE28VanillaCent5 | 1      | catalog          | 1381114805573      | 1381114805758         | 1381114807649              | 1381114807680    | OK            |                               |






Notes
==============================================================================
Gatling 1.x format: https://github.com/excilys/gatling/blob/1.5.X/gatling-core/src/main/scala/com/excilys/ebi/gatling/core/result/writer/FileDataWriter.scala
Gatling 2.x format: https://groups.google.com/forum/#!topic/gatling/mbvN5CBDK4w
