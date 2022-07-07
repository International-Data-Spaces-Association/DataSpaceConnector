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

### MessageProcessedNotificationMessage

```json
Content-Disposition: form-data; name="header"
Content-Type: text/plain;charset=UTF-8
Content-Length: 1269

{
  "@context" : {
    "ids" : "https://w3id.org/idsa/core/",
    "idsc" : "https://w3id.org/idsa/code/"
  },
  "@type" : "ids:MessageProcessedNotificationMessage",
  "@id" : "https://w3id.org/idsa/autogen/messageProcessedNotificationMessage/71ff549c-829a-438d-a6e8-18158c36bfdb",
  "ids:modelVersion" : "4.2.7",
  "ids:issued" : {
    "@value" : "2022-07-07T08:45:54.823Z",
    "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
  },
  "ids:correlationMessage" : {
    "@id" : "https://w3id.org/idsa/autogen/contractAgreementMessage/13ca5af6-b111-4ef4-bc76-d00f5e61e4c9"
  },
  "ids:issuerConnector" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:recipientConnector" : [ {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  } ],
  "ids:senderAgent" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:securityToken" : {
    "@type" : "ids:DynamicAttributeToken",
    "@id" : "https://w3id.org/idsa/autogen/dynamicAttributeToken/7affbc35-d7e1-4f50-93ea-957ad9b2bb4e",
    "ids:tokenValue" : "...",
    "ids:tokenFormat" : {
      "@id" : "https://w3id.org/idsa/code/JWT"
    }
  }
}

Content-Disposition: form-data; name="payload"
Content-Type: text/plain;charset=UTF-8
Content-Length: 36

Received contract agreement message.
```

### ResourceUnavailableMessage

```json
Content-Disposition: form-data; name="header"
Content-Length: 1092
{
  "@context" : {
    "ids" : "https://w3id.org/idsa/core/",
    "idsc" : "https://w3id.org/idsa/code/"
  },
  "@type" : "ids:ResourceUnavailableMessage",
  "@id" : "https://w3id.org/idsa/autogen/resourceUnavailableMessage/1ed79ee0-a0ba-4bd1-a7b3-4eddb3f9b92c",
  "ids:affectedResource" : {
    "@id" : "http://localhost:8080/api/offers/d870252b-c4c9-4b61-8957-b1696995c621"
  },
  "ids:modelVersion" : "4.2.7",
  "ids:issued" : {
    "@value" : "2022-07-07T08:36:39.439Z",
    "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
  },
  "ids:issuerConnector" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:senderAgent" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:securityToken" : {
    "@type" : "ids:DynamicAttributeToken",
    "@id" : "https://w3id.org/idsa/autogen/dynamicAttributeToken/2e6a8a7b-457a-4375-82c5-b5be669baecd",
    "ids:tokenValue" : "...",
    "ids:tokenFormat" : {
      "@id" : "https://w3id.org/idsa/code/JWT"
    }
  }
}

Content-Disposition: form-data; name="payload"
Content-Length: 0
```

### ResourceUpdateMessage

```json
Content-Disposition: form-data; name="header"
Content-Length: 1082

{
  "@context" : {
    "ids" : "https://w3id.org/idsa/core/",
    "idsc" : "https://w3id.org/idsa/code/"
  },
  "@type" : "ids:ResourceUpdateMessage",
  "@id" : "https://w3id.org/idsa/autogen/resourceUpdateMessage/ee841bcf-a25c-4d1d-882b-ac21a0d45549",
  "ids:affectedResource" : {
    "@id" : "http://localhost:8080/api/offers/d870252b-c4c9-4b61-8957-b1696995c621"
  },
  "ids:modelVersion" : "4.2.7",
  "ids:issued" : {
    "@value" : "2022-07-07T08:33:06.494Z",
    "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
  },
  "ids:issuerConnector" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:senderAgent" : {
    "@id" : "https://w3id.org/idsa/autogen/baseConnector/7b934432-a85e-41c5-9f65-669219dde4ea"
  },
  "ids:securityToken" : {
    "@type" : "ids:DynamicAttributeToken",
    "@id" : "https://w3id.org/idsa/autogen/dynamicAttributeToken/cb49028f-c90a-4026-9a4d-4e0be384e2d0",
    "ids:tokenValue" : "...",
    "ids:tokenFormat" : {
      "@id" : "https://w3id.org/idsa/code/JWT"
    }
  }
}

Content-Disposition: form-data; name="payload"
Content-Length: 3782

{
  "@context" : {
    "ids" : "https://w3id.org/idsa/core/",
    "idsc" : "https://w3id.org/idsa/code/"
  },
  "@type" : "ids:Resource",
  "@id" : "http://localhost:8080/api/offers/d870252b-c4c9-4b61-8957-b1696995c621",
  "ids:version" : "1",
  "ids:language" : [ {
    "@id" : "https://w3id.org/idsa/code/DE"
  } ],
  "ids:keyword" : [ {
    "@value" : "abc",
    "@language" : "DE"
  } ],
  "ids:title" : [ {
    "@value" : "TestTitel",
    "@language" : "DE"
  } ],
  "ids:description" : [ {
    "@value" : "abc",
    "@language" : "DE"
  } ],
  "ids:representation" : [ {
    "@type" : "ids:Representation",
    "@id" : "http://localhost:8080/api/representations/ca9a4ff5-4f6f-4d05-b1a2-6a29cb256596",
    "ids:mediaType" : {
      "@type" : "ids:IANAMediaType",
      "@id" : "https://w3id.org/idsa/autogen/iANAMediaType/308bdf03-1f1d-4853-aa7b-6a6cb9be0482",
      "ids:filenameExtension" : "xml"
    },
    "ids:language" : {
      "@id" : "https://w3id.org/idsa/code/DE"
    },
    "ids:instance" : [ {
      "@type" : "ids:Artifact",
      "@id" : "http://localhost:8080/api/artifacts/21bc7ed1-5579-4ab7-b591-534435e3b2a1",
      "ids:fileName" : "dsc-checkstyle.xml",
      "ids:creationDate" : {
        "@value" : "2022-07-07T08:10:18.250Z",
        "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
      },
      "ids:byteSize" : 7720,
      "ids:checkSum" : "795006632"
    } ],
    "ids:created" : {
      "@value" : "2022-07-07T08:10:18.096Z",
      "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
    },
    "ids:modified" : {
      "@value" : "2022-07-07T08:10:18.096Z",
      "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
    },
    "ids:representationStandard" : {
      "@id" : ""
    }
  } ],
  "ids:paymentModality" : {
    "@id" : "https://w3id.org/idsa/code/FREE"
  },
  "ids:publisher" : {
    "@id" : "http://example.org"
  },
  "ids:sovereign" : {
    "@id" : ""
  },
  "ids:standardLicense" : {
    "@id" : "http://example.org"
  },
  "ids:resourceEndpoint" : [ {
    "@type" : "ids:ConnectorEndpoint",
    "@id" : "https://w3id.org/idsa/autogen/connectorEndpoint/e9a65216-5973-4365-bf4a-030e204249a7",
    "ids:endpointDocumentation" : [ {
      "@id" : ""
    } ],
    "ids:accessURL" : {
      "@id" : "http://localhost:8080/api/offers/d870252b-c4c9-4b61-8957-b1696995c621"
    }
  } ],
  "ids:contractOffer" : [ {
    "@type" : "ids:ContractOffer",
    "@id" : "http://localhost:8080/api/contracts/be023918-a3f4-4e36-bc7c-9158edd1bf46",
    "ids:provider" : {
      "@id" : ""
    },
    "ids:permission" : [ {
      "@type" : "ids:Permission",
      "@id" : "http://localhost:8080/api/rules/3c31dfd7-f498-423f-8787-1ac9f4b86c45",
      "ids:title" : [ {
        "@value" : "",
        "@type" : "http://www.w3.org/2001/XMLSchema#string"
      } ],
      "ids:description" : [ {
        "@value" : "",
        "@type" : "http://www.w3.org/2001/XMLSchema#string"
      } ],
      "ids:action" : [ {
        "@id" : "https://w3id.org/idsa/code/USE"
      } ]
    } ],
    "ids:contractEnd" : {
      "@value" : "2022-07-31T00:00:00.000Z",
      "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
    },
    "ids:consumer" : {
      "@id" : ""
    },
    "ids:contractStart" : {
      "@value" : "2022-07-01T00:00:00.000Z",
      "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
    },
    "ids:contractDate" : {
      "@value" : "2022-07-07T08:33:06.480Z",
      "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
    }
  } ],
  "ids:created" : {
    "@value" : "2022-07-07T08:10:17.553Z",
    "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
  },
  "ids:modified" : {
    "@value" : "2022-07-07T08:10:17.553Z",
    "@type" : "http://www.w3.org/2001/XMLSchema#dateTimeStamp"
  }
}
```
