# Build
mvn clean package && docker build -t com.airhacks/odata-hello .

# RUN

docker rm -f odata-hello || true && docker run -d -p 8080:8080 -p 4848:4848 --name odata-hello com.airhacks/odata-hello 