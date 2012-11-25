curl -i -X PUT -H "Content-Type:application/json" -d '{ "id":'$1', "statusId":'$2', "scoreUser1": 2, "scoreUser2": 1 } ' http://localhost:8080/groupong/match
