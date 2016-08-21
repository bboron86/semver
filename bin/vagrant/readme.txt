### helpful commands

docker run -d -p 8181:8080 --name provider_v1 de.maibornwolff.ace/semver:1.0

docker run --name nginx -p 8080:8080 -v /vagrant/bin/nginx/nginx.conf:/etc/nginx/nginx.conf:ro -d nginx

