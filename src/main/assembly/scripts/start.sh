#!/bin/bash

JAVA=`which java`
PORT=8081+

usage() { 
            echo "Start Cloudera Certification Cluster Builder";
            echo "Accepted parameters:";
            echo "-p port number. It should be greater than 1000 if you are not running as admin user";
            echo "Usage: $0 [-p <string>]"  1>&2; exit 1; 
        }

while getopts p:h: option
do
        case "${option}"
        in     
            p) PORT=${OPTARG};;
    		h) usage();;
    		*) echo unknown option. It will be ignored;;
        esac
done

if [ ! -z "$JAVA_HOME" ] ; then 
    JAVA=$JAVA_HOME/bin/java
else
    JAVA=`which java`
fi

if [ ! -x "$JAVA" ] ; then
  echo Cannot find java. Set JAVA_HOME or add java to path.
  exit 1
fi

if [ ! `ls cert-cluster-builder-*.jar 2> /dev/null` ] ; then
  echo Command must be run from the directory where it is installed.
  exit 1
fi

$JAVA -Xms256m -Xmx1024m -XX:MaxPermSize=1024m -classpath "*:lib/*" com.cloudera.cert.CertClusterBuilder "$@" $PORT
