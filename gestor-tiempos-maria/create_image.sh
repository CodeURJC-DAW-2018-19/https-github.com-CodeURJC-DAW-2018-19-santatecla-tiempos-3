#!/bin/bash
# -*- ENCODING: UTF-8 -*-
docker build -t daw -f Dockerfile .
docker-compose up
