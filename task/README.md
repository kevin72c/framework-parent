# task
#### 开发环境
docker build -t task:latest .
docker stop task
docker rm task
docker run --name task -d task:latest java -Xms256m -Xmx256m -jar task.jar --spring.profiles.active=dev