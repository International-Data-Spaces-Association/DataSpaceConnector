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

