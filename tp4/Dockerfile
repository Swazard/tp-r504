FROM python:3.11

RUN apt update
RUN apt upgrade
RUN apt install default-libmysqlclient-dev
RUN pip3 install --upgrade pip
RUN pip3 install flask-mysqldb
RUN pip3 install mysql-connector-python
RUN mkdir /srv/templates/
COPY app_1.py /srv/app1.py
COPY index.html /srv/templates/index.html
COPY form.html /srv/templates/form.html
CMD ["flask","--app","/srv/app1","run","--host=0.0.0.0"]