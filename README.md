Cloudera Connect Certified Technology Cluster Appliance
=======================================================
This project is an application that Cloudera technology partners can use to
easily launch a pre-configured cluster for use in certification testing.

### Dependencies

You must have the following software installed and compiled ():

* `git clone https://github.com/cloudsoft/brooklyn-cdh.git`
* cd brooklyn-cdh/
* `mvn clean install`

### Create a redistributable binary archive

Run `mvn clean assembly:assembly` to generate a redistributable binary archive
in `target/cert-cluster-builder-1.0.0-SNAPSHOT-dist.tar.gz`.  Unpacking this
gives a `start.sh` (and a `README`) which can be used to launch the tool.

For more information about the Cloudera Connect Partner Program, the Cloudera
Certified Technology program, or this application, please contact
`partner@cloudera.com`.
