#!/bin/bash

scalac *.scala

scalac -cp jars/scalatest-app_2.11-3.0.0.jar:. tests/*.scala

scala -cp jars/scalatest-app_2.11-3.0.0.jar org.scalatest.run EulerSpecs