docker network create --internal tplb
docker build -t im-nginx-lb .
mkdir shared1
mkdir shared2
echo "<h1>Hello 1</h1>" > shared1/index.html
echo "<h1>Hello 2</h1>" > shared2/index.html
docker run --rm -d --name nginx1 --network=tplb -p 127.0.0.1:80:81 --mount type=bind,src=/home/yann/tp-r504/tp-A/shared1/,target=/usr/share/nginx/html nginx:latest
docker run --rm -d --name nginx2 --network=tplb -p 127.0.0.1:80:82 --mount type=bind,src=/home/yann/tp-r504/tp-A/shared2/,target=/usr/share/nginx/html nginx:latest
docker run --rm -d -p 127.0.0.1:80:83 --network=tplb im-nginx-lb


