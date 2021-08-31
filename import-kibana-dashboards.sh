#!/usr/bin/env bash

echo "Import Dashboards in Kibana"

echo "* Import counter dashboard status code:" $(curl -XPOST --write-out '%{http_code}' --silent --output /dev/null -H "Content-Type: application/json" -H "kbn-xsrf: reporting" http://localhost:5601/api/kibana/dashboards/import -d @monitoring/kibana/dashboards/random-names-counter-dashboard-example.json)
