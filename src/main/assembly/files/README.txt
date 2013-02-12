Cloudera Connect: Certification Cluster Builder
===============================================

### Instructions

1) To launch, simply run `start.sh`

2) You should shortly see a dialog for "Cloudera Connect"; select your preferred
cloud target and enter your credentials, then click "Deploy Cluster".
The deployment operation takes about 10 minutes.

3) [OPTIONALLY] You can track roll-out in the "View Console" log trace
or drill down in the "Brooklyn UI".

4) When status becomes "RUNNING" your cluster is ready.
Details are available in "View Console" or as sensors in "Brooklyn UI".

5) When you are ready to gather the metrics, select "Cloudera Services"
in the "Applications" tab of the "Brooklyn UI", choose "Effectors", then
click "collectMetrics". This generates an archive which you can send to
us for certification analysis. 

 
### More Information

For more information, or to customise the launcher, see the following projects
on Github:

* GUI: https://github.com/templedf/CertClusterBuilder
* Brooklyn automation: https://github.com/cloudsoft/brooklyn-cdh
