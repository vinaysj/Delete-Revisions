# Delete-Revisions
This script/jar would help in deletion of undeployed revisions in a proxy. An immediate revision below the deployed revision would be retained. Only deployed proxies would be considered for proxy revision. Proxies deployed in certain environment would not be touched when specified.   

----
Execution steps
----
Create a text file with the list of environment. The environments specified here would be considered for excluding the proxies which are deployed in these environments. (Text file format: each line should correspond to one environment name. File should only contain environment names)

-Download the jar

-Open command line prompt traverse to the downloaded location

-Run below command with correct argument (run the below command with internal network)

          $java -jar RevisionDeletion.jar userLoginID password https domain orgname filepath outputfilepath

example: java -jar DeleteRevisions.jar username password http api.enterprise.apigee.com test C:\Users\username\Desktop\facadeEnvList.txt C:\Users\username\Desktop\test_deletion.txt

----
Description for the arguments being passed in above command
----
    Username and password are the authentication details which are required for login into apigee
    Protocol would be https or http
    Domain name would be api.enterprise.apigee.com for saas and 10.158.150.179:8080 or devapgw807.unix.gsm1900.org for on prem
    Organization name would be the name of organization
    Filepath is the path of the file which contains the list of environments for which the proxies deployed in this environment revision deletion will not be done.
