import ballerinax/mysql;
import ballerina/http;
import ballerinax/mysql.driver as _;
import ballerina/io;

configurable string USER = ?;
configurable string PASSWORD = ?;
configurable string HOST = ?;
configurable string DATABASE = ?;

final mysql:Client dbClient = check new (
    host = HOST, user = USER, password = PASSWORD, database = DATABASE
);

service /qatarairways on new http:Listener(9092) {
    resource function post miles(@http:Payload Request request) returns xml?|error|error {
        CheckIn|error result= getMiles(request.customerId);
        float empty = 0.0;
        string cusId = "null";

        if (result is CheckIn){
                    io:print(result);

            return xml `
            <miles>
                <milesFlown>${result.flightDistance}</milesFlown>
                <customerId>${request.customerId}</customerId>
            </miles>
        `;

            
        }

        else{
            return xml `
            <miles>
                <milesFlown>${empty}</milesFlown>
                <customerId>${cusId}</customerId>
            </miles>
        `;


        }
  

       
    }
}

function getMiles(string customerId) returns CheckIn|error {
    return dbClient->queryRow(
        `SELECT sum(flightDistance) as flightDistance FROM qatarCheckin WHERE customerId = ${customerId}`
    );
}

