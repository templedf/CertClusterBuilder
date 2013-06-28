Cloudera Connect Certified Technology Cluster Appliance
=======================================================
This project is an application that Cloudera technology partners can use to
easily launch a pre-configured cluster for use in certification testing.

### Dependencies

You must have the following software installed and compiled ():

* `git clone https://github.com/cloudsoft/brooklyn-cdh.git`
* cd brooklyn-cdh/
* `git checkout update/brooklyn-060-SNAPSHOT`
* `mvn clean install`

### Setup: Location Credentials

Set up the target cloud and credentials in `~/.brooklyn/brooklyn.properties`, e.g.:

    #### IBM CloudFirst Factory 
    brooklyn.location.named.ibm-cloud-first.privateKeyFile = /path/to/your/.ssh/id_rsa
    brooklyn.location.named.ibm-cloud-first = jclouds:openstack-nova
    brooklyn.location.named.ibm-cloud-first.endpoint=https://cloudfirst.demos.ibm.com/keystone/v2.0
    brooklyn.location.named.ibm-cloud-first.identity=tenantName:userName@organization
    brooklyn.location.named.ibm-cloud-first.credential=your-password
    brooklyn.location.named.ibm-cloud-first.loginUser=idcuser
    brooklyn.location.named.ibm-cloud-first.securityGroups=universal
    brooklyn.location.named.ibm-cloud-first.keyPair=cdh
    brooklyn.location.named.ibm-cloud-first.loginUser.privateKeyFile=/path/to/your/privateKey.pem
    brooklyn.location.named.ibm-cloud-first.jclouds.openstack-nova.auto-generate-keypairs=false
    brooklyn.location.named.ibm-cloud-first.jclouds.openstack-nova.auto-create-floating-ips=true
    brooklyn.location.named.ibm-cloud-first.hardwareId=RegionOne/9
    brooklyn.location.named.ibm-cloud-first.imageId=RegionOne/eeced716-bb37-4f3b-a3d6-977e17f20b21
    brooklyn.location.named.ibm-cloud-first.image-id=RegionOne/eeced716-bb37-4f3b-a3d6-977e17f20b21

    #### IBM SmartCloudEnterprise
    brooklyn.location.named.ibm-sce=ibm-smartcloud
    brooklyn.location.named.ibm-sce.identity=your-identity
    brooklyn.location.named.ibm-sce.credential=your-password
    brooklyn.location.named.ibm-sce.user=idcuser

### Create a redistributable binary archive

Run `mvn clean assembly:assembly` to generate a redistributable binary archive
in `target/cert-cluster-builder-1.0.0-SNAPSHOT-dist.tar.gz`.  Unpacking this
gives a `start.sh` (and a `README`) which can be used to launch the tool.

For more information about the Cloudera Connect Partner Program, the Cloudera
Certified Technology program, or this application, please contact
`partner@cloudera.com`.
