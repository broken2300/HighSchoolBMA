# HighSchoolBMA
487Project

I had a similar issue except the "Server Name" field was disabled.

Found this was due to the Apache Tomcat v7.0 runtime environment pointing to the wrong folder. This was fixed by going to Window - Preferences - Server - Runtime Environments, clicking on the runtime environment entry and clicking "Edit..." and then modifying the Tomcat installation directory.
