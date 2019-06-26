#!/bin/bash
# -*- ENCODING: UTF-8 -*-
cd ../gestor-tiempos-maria

cd ..
docker build -t api -f docker/Dockerfile .
cd docker/
docker-compose up