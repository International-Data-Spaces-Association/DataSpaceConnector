---
layout: default
title: Messages
nav_order: 4
description: ""
permalink: /Documentation/v6/Messages
parent: Documentation
---

# IDS Messages
{: .fs-9 }

See what IDS message types can be sent and received.
{: .fs-6 .fw-300 }

[previous version](../v5/messages.md)

---

## Message Types

IDS messages and their content are defined
[here](http://htmlpreview.github.io/?https://github.com/IndustrialDataSpace/InformationModel/blob/feature/message_taxonomy_description/model/communication/Message_Description.htm).
The table below lists the supported message types. Thereby, it is to be distinguished whether the
Dataspace Connector provides functionality for sending messages as request or response, or for
processing incoming messages.

| IDS Message Type                    | Outgoing           | Incoming | Description              |
|:------------------------------------|:------------------:|:--------:|:-------------------------|
| ArtifactRequestMessage              | request            | x        | message asking for retrieving a specified artifact  |
| DescriptionRequestMessage           | request            | x        | message requesting metadata (If no URI is supplied via the ids:requestedElement field, this messages is treated like a self-description request.) |
| ContractRequestMessage              | request            | x        | message containing a contract offer |
| ArtifactResponseMessage             | response           | x        | message that contains the artifact's data in the payload |
| DescriptionResponseMessage          | response           | x        | message containing the metadata of a requested object |
| ContractAgreementMessage            | request + response | x        | message containing a contract agreement |
| ContractRejectionMessage            | response           | x        | message indicating rejection of a contract |
| RejectionMessage                    | response           | x        | message that notifies the issuer that processing the request message has failed |
| NotificationMessage                 | request            | x        | message is informative and no response is expected |
| LogMessage                          | request            | x        | message that is used to transfer logs e.g. to the clearing house |
| MessageProcessedNotificationMessage | response           | x        | message that notifies whether a message has been received and successfully processed |
| ConnectorUpdateMessage              | request            |          | message notifying the recipient(s) about the availability and current configuration of a connector |
| ConnectorUnavailableMessage         | request            |          | message indicating that a specific connector is unavailable |
| ResourceUpdateMessage               | request            | x        | message indicating the availability and current description of a specific resource |
| ResourceUnavailableMessage          | request            |          | message indicating that a specific resource is unavailable |
| QueryMessage                        | request            |          | message intended to be consumed by specific components |

`request` = initially send this kind of IDS message, `response` = response with this IDS message

## Messaging Sequence

![Automated IDS Messaging Sequence](../../../assets/images/diagram/messaging_sequence.png)

## Examples

### ConnectorUnavailableMessage

```json
Content-Disposition: form-data; name="header"
Content-Length: 1140

{
  "@context" : {
    "ids" : "https://w3id.org/idsa/core/",
    "idsc" : "https://w3id.org/idsa/code/"
  },
  "@type" : "ids:ConnectorUnavailableMessage",
  "@id" : "https://w3id.org/idsa/autogen/connectorUnavailableMessage/f0a54a08-c055-47a3-af39-c1f6cc5661e9",
  "ids:affectedConnector" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:issuerConnector" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:securityToken" : {
    "@type" : "ids:DynamicAttributeToken",
    "@id" : "https://w3id.org/idsa/autogen/dynamicAttributeToken/f0b59452-0620-43f5-87ab-ff9adc6479c7",
    "ids:tokenFormat" : {
      "@id" : "https://w3id.org/idsa/code/JWT"
    },
    "ids:tokenValue" : "..."
  },
  "ids:modelVersion" : "4.2.7",
  "ids:senderAgent" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:issued" : {
    "@value" : "2022-07-07T08:27:30.484+02:00",
    "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
  }
}

Content-Disposition: form-data; name="payload"
Content-Length: 0
```

### ConnectorUpdateMessage

```json
Content-Disposition: form-data; name="header"
Content-Length: 1130

{
  "@context" : {
  "ids" : "https://w3id.org/idsa/core/",
  "idsc" : "https://w3id.org/idsa/code/"
  },
  "@type" : "ids:ConnectorUpdateMessage",
  "@id" : "https://w3id.org/idsa/autogen/connectorUpdateMessage/38e8a1e1-937a-42b5-bb5b-984e4fa68c0b",
  "ids:affectedConnector" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:issuerConnector" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:securityToken" : {
    "@type" : "ids:DynamicAttributeToken",
    "@id" : "https://w3id.org/idsa/autogen/dynamicAttributeToken/ccc80ff6-54e9-4381-b130-d47bb973c9f7",
    "ids:tokenFormat" : {
      "@id" : "https://w3id.org/idsa/code/JWT"
    },
    "ids:tokenValue" : "..."
  },
  "ids:modelVersion" : "4.2.7",
  "ids:senderAgent" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:issued" : {
    "@value" : "2022-07-07T08:25:11.702+02:00",
    "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
  }
}

Content-Disposition: form-data; name="payload"
Content-Length: 1994

{
  "@context" : {
    "ids" : "https://w3id.org/idsa/core/",
    "idsc" : "https://w3id.org/idsa/code/"
  },
  "@type" : "ids:BaseConnector",
  "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea",
  "ids:publicKey" : {
    "@type" : "ids:PublicKey",
    "@id" : "https://w3id.org/idsa/autogen/publicKey/78eb73a3-3a2a-4626-a0ff-631ab50a00f9",
    "ids:keyType" : {
      "@id" : "https://w3id.org/idsa/code/RSA"
    },
    "ids:keyValue" : "..."
  },
  "ids:version" : "8.0.0",
  "ids:description" : [ {
    "@value" : "IDS Connector reference implementation",
    "@type" : "http://www.w3.org/2001/XMLSchema#string"
  } ],
  "ids:hasDefaultEndpoint" : {
    "@type" : "ids:ConnectorEndpoint",
    "@id" : "https://w3id.org/idsa/autogen/connectorEndpoint/e5e2ab04-633a-44b9-87d9-a097ae6da3cf",
    "ids:accessURL" : {
      "@id" : "https://localhost:8080/api/ids/data"
    }
  },
  "ids:outboundModelVersion" : "4.2.7",
  "ids:maintainer" : {
    "@id" : "https://sovity.de/"
  },
  "ids:inboundModelVersion" : [ "4.2.6", "4.2.7", "4.2.0", "4.2.1", "4.1.2", "4.0.0", "4.1.0", "4.2.4", "4.2.5", "4.2.2", "4.2.3" ],
  "ids:title" : [ {
    "@value" : "Dataspace Connector",
    "@type" : "http://www.w3.org/2001/XMLSchema#string"
  } ],
  "ids:securityProfile" : {
    "@id" : "https://w3id.org/idsa/code/BASE_SECURITY_PROFILE"
  },
  "ids:curator" : {
    "@id" : "https://example.org/"
  }
}
```

### LogMessage

```json
Content-Disposition: form-data; name="header"
Content-Length: 1081

{
  "@context" : {
    "ids" : "https://w3id.org/idsa/core/",
    "idsc" : "https://w3id.org/idsa/code/"
  },
  "@type" : "ids:LogMessage",
  "@id" : "https://w3id.org/idsa/autogen/logMessage/e81faecf-d9a9-405c-979a-5314cb125008",
  "ids:modelVersion" : "4.2.7",
  "ids:issued" : {
    "@value" : "2022-07-07T10:16:51.121Z",
    "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
  },
  "ids:issuerConnector" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:recipientConnector" : [ {
    "@id" : "https://ch-ids.aisec.fraunhofer.de/messages/log/eec72aac-ab93-4988-a62e-19b7078a8693"
  } ],
  "ids:senderAgent" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:securityToken" : {
    "@type" : "ids:DynamicAttributeToken",
    "@id" : "https://w3id.org/idsa/autogen/dynamicAttributeToken/64d37082-e2aa-4881-9e12-0ac9c2532e77",
    "ids:tokenValue" : "...",
    "ids:tokenFormat" : {
      "@id" : "https://w3id.org/idsa/code/JWT"
    }
  }
}

Content-Disposition: form-data; name="payload"; filename="payload"
Content-Type: application/ld+json; charset=utf-8
Content-Length: 1234

<message-to-log>
```
