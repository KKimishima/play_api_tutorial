FROM postgres:latest
RUN localedef -i ja_JP -c -f UTF-8 -A /usr/share/locale/locale.alias ja_JP.UTF-8
ENV LANG ja_JP.UTF-8
RUN echo 'create database slick_db_development;' >> /docker-entrypoint-initdb.d/init.sql
RUN echo 'create database slick_db_test;' >> /docker-entrypoint-initdb.d/init.sql
