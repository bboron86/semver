### helpful commands

docker run -d -p 8181:8080 --name provider_v1 -e "SERVICE_NAME=providerV1" de.maibornwolff.ace/semver:1.0

docker run --name nginx -p 8080:8080 -v /vagrant/bin/nginx/nginx.conf:/etc/nginx/nginx.conf:ro -d nginx

docker run -p 8400:8400 -p 8500:8500 -p 8600:53/udp -h node1 --name consul -d progrium/consul -server -bootstrap -ui-dir /ui

docker run -d --name=registrator --net=host --volume=/var/run/docker.sock:/tmp/docker.sock gliderlabs/registrator:latest -ip ${SERVICE_IP} consul://localhost:8500