#!/bin/sh

echo "Replacing environment variables in Angular app"

# Replace the placeholder in the compiled files with the actual API URL
if [ -n "$API_URL" ]; then
  sed -i "s|API_URL|$API_URL|g" /usr/share/nginx/html/main-*.js
else
  echo "API_URL is not set, using default value"
fi

exec "$@"
