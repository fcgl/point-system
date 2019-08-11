# User-Action-Point-System Microservice

**Note:** 
    * You will only need docker installed on your computer to run this app

## Git Steps
1. Fork Branch
2. Open terminal and clone **forked branch**: `git clone https://github.com/<YOUR USERNAME>/point-system.git`
3. Go inside point-system directory: `cd point-system`
3. Add upstream repo: `git remote add upstream https://github.com/fcgl/point-system.git`
4. Confirm that you have an origin and upstream repos: `git remote -v`

## Build & Run App

This build should work for both macOS and Linux

1. Download docker for your operating system
2. From project root run the following commands to build and run the app:
    * `docker-compose up --build`
    
## Swagger

Swagger can be accessed through http://localhost:8083/swagger-ui.html

## Health Endpoint

Confirm everything was ran correctly by going to the following endpoint: 
  * http://localhost:8083/health/v1/marco

