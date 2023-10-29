import ballerina/http;
import ballerina/xmldata;
import ballerina/io;

configurable string BritishToken = ?;
configurable string BritishClientId = ?;
configurable string BritishClientSecret = ?;

configurable string QatarToken = ?;
configurable string QatarClientId = ?;
configurable string QatarClientSecret = ?;

public type Request record {
    string customerId;
};

service / on new http:Listener(9091) {
    // Define your resource functions here
    resource function post miles(@http:Payload Request payload) returns json|error {
        http:Client britishEP = check new ("https://b48cc93e-fa33-4420-a155-bc653b4d46be-dev.e1-us-east-azure.choreoapis.dev/jexg/british-airways-miles-calculator/british-miles-calculator-119/v1.0/britishairways/miles",
        
        auth ={
            tokenUrl: BritishToken ,
            clientId:BritishClientId ,
            clientSecret: BritishClientSecret
        });
        http:Client qatarEP = check new ("https://b48cc93e-fa33-4420-a155-bc653b4d46be-dev.e1-us-east-azure.choreoapis.dev/jexg/qatar-airways-miles-calculator/qatarairways-8c8/v1.0/miles",
        
        auth ={
            tokenUrl: QatarToken ,
            clientId:QatarClientId ,
            clientSecret: QatarClientSecret
        });

        json[] response = [];

        xml|error? britishResponse = britishEP->/.post(payload);
        io:print(britishResponse);
        if (britishResponse is xml) {
            json britishJsonResponse = check convertXmlToJson(britishResponse);
            response.push(britishJsonResponse);
        } else {
            // Handle the error appropriately, e.g., return an error response
        }

        xml|error? qatarResponse = qatarEP->/.post(payload);
        io:print(qatarResponse);
        if (qatarResponse is xml) {
            json qatarJsonResponse = check convertXmlToJson(qatarResponse);
            response.push(qatarJsonResponse);
        } else {
            // Handle the error appropriately, e.g., return an error response
        }

        json aggregatedResponse = {"checkInInfo": response};
        io:print(aggregatedResponse);
        return aggregatedResponse;
    }

}


function convertXmlToJson(xml inputXml) returns json|error {
    json jsonValue = check xmldata:toJson(inputXml);
    return jsonValue;
}
