#!/usr/bin/python

import os
import sys


cmd = "install"
if len(sys.argv) > 1:
	cmd = sys.argv[1]


if os.system("mvn -version") != 0:
	print "maven not installed!"
	exit(1)

def mvn(x):
	os.chdir(x)
	print "#" * 78
	os.system("mvn %s" % cmd)
	os.chdir("..")
	
if cmd == "install" or cmd == "clean" or cmd == "test":
	mvn("Math")
	mvn("Proteins")
	mvn("JavaSwingExtensions")
	mvn("Xml")
	mvn("ExtendedSeparatedValues")
	mvn("App")
	mvn("Graphs")
	mvn("Signal")
	mvn("Collections")
	mvn("Files")
	mvn("GroupFile")
	mvn("MarkovChain")
	mvn("MzML")
	mvn("Proteomics")
	mvn("SalvatorDenoise")
	mvn("TraML")
	mvn("DecoyTraMLGenerator")
	mvn("Csv2Traml")
else:
	print "unknown mvn command '%s'" % cmd
	exit(1)
