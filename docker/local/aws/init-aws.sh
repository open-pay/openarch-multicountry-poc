#!/bin/bash

# SQS
#
# https://docs.localstack.cloud/aws/services/sqs/
#
# send message
# docker exec -it openarch-multicountry-poc-aws sh -c 'awslocal sqs send-message --queue-url http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/local-queue --message-body "myBody"'
#
awslocal sqs create-queue --queue-name local-queue --region us-east-1

# S3
#
# https://docs.localstack.cloud/aws/services/s3/
#
# copy files to container
# docker cp file.extension openarch-multicountry-poc-aws:/tmp/file.extension
#
# put object in bucket
# docker exec -it openarch-multicountry-poc-aws sh -c 'awslocal s3api put-object --bucket local-bucket --key file.extension --body /tmp/file.extension'
#
awslocal s3api create-bucket --bucket local-bucket --region us-east-1

# DynamoDB
#
# https://docs.localstack.cloud/aws/services/dynamodb/
#