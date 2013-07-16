Cloudera Connect Certified Technology Cluster Appliance
=======================================================
This project is an application that Cloudera technology partners can use to easily launch a pre-configured cluster for use in certification testing.

<img src="https://raw.github.com/andreaturli/CertClusterBuilder/master/gui.png" alt="ClouderaConnectCluster">

### Setup: Location Credentials

Set up the target cloud and credentials in `~/.brooklyn/brooklyn.properties`, e.g.:

#### IBM CloudFirst Factory 
	brooklyn.location.named.ibm-cloud-first=jclouds:openstack-nova
	brooklyn.location.named.ibm-cloud-first.endpoint=https://cloudfirst.demos.ibm.com/keystone/v2.0
	brooklyn.location.named.ibm-cloud-first.privateKeyFile=/path/to/yous/ssh/private/key
	brooklyn.location.named.ibm-cloud-first.loginUser=idcuser
	brooklyn.location.named.ibm-cloud-first.securityGroups=universal
	brooklyn.location.named.ibm-cloud-first.keyPair=your-keypair-name
	brooklyn.location.named.ibm-cloud-first.loginUser.privateKeyFile=/path/to/keypair/your-keypair-name.pem
	brooklyn.location.named.ibm-cloud-first.hardwareId=RegionOne/9
	brooklyn.location.named.ibm-cloud-first.imageId=RegionOne/eeced716-bb37-4f3b-a3d6-977e17f20b21
	brooklyn.location.named.ibm-cloud-first.jclouds.openstack-nova.auto-create-floating-ips=true
	brooklyn.location.named.ibm-cloud-first.jclouds.openstack-nova.auto-generate-keypairs=false
	brooklyn.location.named.ibm-cloud-first.jclouds.ssh.max-retries=200

### Launch Cloudera Certified Technology Cluster appliance

In order to launch the GUI, please run the following commands from the root of this project: 

    mvn clean assembly:assembly
    cd target
    tar xvzf cert-cluster-builder-1.0.0-SNAPSHOT-dist.tar.gz
    cd cert-cluster-builder-1.0.0-SNAPSHOT-dist
    ./start.sh

For more information, please look at the `README`, inside the `target` folder.

For more information about the Cloudera Connect Partner Program, the Cloudera
Certified Technology program, or this application, please contact
`partner@cloudera.com`.
