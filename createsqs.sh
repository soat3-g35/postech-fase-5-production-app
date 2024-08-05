#!/bin/bash

export AWS_ACCESS_KEY_ID=localstack
export AWS_SECRET_ACCESS_KEY=localstack

awslocal sqs create-queue --queue-name inicia-preparo

echo "created table inicia-preparo"

awslocal sqs create-queue --queue-name preparo-finalizado

echo "created table preparo-finalizado"

#awslocal sqs create-queue --queue-name pedido-gerado
#awslocal sqs list-queues


#awslocal sqs receive-message --queue-url http://localhost:4566/000000000000/pedido-gerado
