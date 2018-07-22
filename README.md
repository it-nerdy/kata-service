# kata-service

Prerequsites:
Please install all the required tools to run this.

    1) Java 8     
    2) Maven 3.2+ sudo apt install maven
    3) docker - https://docs.docker.com/install/

Procedure to run kata service

1) Clone the repository `git clone https://github.com/nutim/kata-service.git`
2) Run `mvn clean install`
3) Run this command as administator. In Ubuntu linux run this command `sudo mvn package dockerfile:build`. This command creates docker image file. This step takes time depending on the internet speed.
4) Make sure docker image file is created. To check this, run command `sudo docker images`. Somithing similar will appear.

| REPOSITORY  | TAG  | IMAGE ID  | CREATED  | SIZE  |
|---|---|---|---|---|
|carfax/kata-service   |  latest |  392e7c60a650 | About an hour ago  |  659 MB |

5) Run `sudo docker run -p 8080:8080 -t carfax/kata-service` to start Spring boot application.
6) There are 2 ways to test the service. 
    1) Got to web browser type http://localhost:8080/ in address bar, provided your docker container is running in local system or else http://ip_address:8080/. Select `Choose File` button, choose the file. Click on `Upload` button. See server logs (`docker logs`) for output.
    2) Clone this repository https://github.com/nutim/kata-client.git follow the given procedure and run Standalone client for the kata service.
   
