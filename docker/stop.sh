#!/bin/bash

if [ -z "$1" ]; then
   echo "The profile argument is required"
   echo "Usage: ./stop.sh local|local-es"
   exit 1
elif [[ "$1" != "local" && "$1" != "local-es" ]]; then
   echo "Supported profiles are local|local-es"
   exit 1
else
   if command -v docker-compose &> /dev/null; then
      docker-compose -f $1/compose.yml down
   else
      docker compose -f $1/compose.yml down
   fi
fi
