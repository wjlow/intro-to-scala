FROM hseeberger/scala-sbt:8u181_2.12.6_1.2.1

WORKDIR /work

ADD . /work

RUN sbt test:compile

CMD ["bash"]
