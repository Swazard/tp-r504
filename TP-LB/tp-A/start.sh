docker network create tplb
docker build -t im-nginx-lb .
mkdir -p shared1
mkdir -p shared2
echo "<h1>Hello 1</h1>" > shared1/index.html
echo "<h1>Hello 2</h1>" > shared2/index.html
docker run --rm -d \
	--name nginx1 \
	--network tplb \
	-p 81:80 \
	--mount type=bind,src=$(pwd)/shared1/,target=/usr/share/nginx/html \
	nginx:latest

docker run --rm -d \
	--name nginx2 \
	--network tplb \
	-p 82:80 \
	--mount type=bind,src=$(pwd)/shared2/,target=/usr/share/nginx/html \
	nginx:latest

docker run --rm -d \
	-p 83:80 \
	--network tplb \
	im-nginx-lb


