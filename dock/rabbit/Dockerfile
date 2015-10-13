FROM rabbitmq
MAINTAINER Dmitriy I. Yakovlev diyakovlev@edi.hse.ru
EXPOSE 1883
RUN rabbitmq-plugins enable rabbitmq_mqtt --offline
RUN rabbitmq-plugins enable rabbitmq_management --offline
EXPOSE 15672
