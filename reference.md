# Reference
## Addresses
<details><summary><code>client.addresses.list() -> SyncPagingIterable&amp;lt;Address&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of all addresses in an organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Addresses** under the Addresses category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.addresses().list(
    ListAddressesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**createdAfterTime:** `Optional<String>` — A filter on data to have a created at time after or equal to this specified time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.addresses.create(request) -> AddressResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new address in the organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Addresses** under the Addresses category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.addresses().create(
    CreateAddressRequest
        .builder()
        .formattedAddress("350 Rhode Island St, San Francisco, CA")
        .geofence(
            CreateAddressRequestGeofence
                .builder()
                .build()
        )
        .name("Samsara HQ")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**addressTypes:** `Optional<List<CreateAddressRequestAddressTypesItem>>` — Reporting location type associated with the address (used for ELD reporting purposes). Valid values: `yard`, `shortHaul`, `workforceSite`, `riskZone`, `industrialSite`, `alertsOnly`, `agricultureSource`, `avoidanceZone`, `knownGPSJammingZone`, `authorizedZone`, `unauthorizedZone`.
    
</dd>
</dl>

<dl>
<dd>

**contactIds:** `Optional<List<String>>` — An array of Contact IDs associated with this Address.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — The [external IDs](https://developers.samsara.com/docs/external-ids) for the given object.
    
</dd>
</dl>

<dl>
<dd>

**formattedAddress:** `String` — The full street address for this address/geofence, as it might be recognized by Google Maps.
    
</dd>
</dl>

<dl>
<dd>

**geofence:** `CreateAddressRequestGeofence` 
    
</dd>
</dl>

<dl>
<dd>

**latitude:** `Optional<Double>` — Latitude of the address. Will be geocoded from `formattedAddress` if not provided.
    
</dd>
</dl>

<dl>
<dd>

**longitude:** `Optional<Double>` — Longitude of the address. Will be geocoded from `formattedAddress` if not provided.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Name of the address.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — Notes about the address.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — An array of IDs of tags to associate with this address.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.addresses.get(id) -> AddressResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a specific address. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Addresses** under the Addresses category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.addresses().get(
    "id",
    GetAddressesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the Address. This can either be the Samsara-provided ID or an external ID. External IDs are customer-specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `crmId:abc123`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.addresses.delete(id) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a specific address. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Addresses** under the Addresses category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.addresses().delete(
    "id",
    DeleteAddressesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the Address. This can either be the Samsara-provided ID or an external ID. External IDs are customer-specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `crmId:abc123`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.addresses.update(id, request) -> AddressResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a specific address. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Addresses** under the Addresses category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.addresses().update(
    "id",
    UpdateAddressRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the Address. This can either be the Samsara-provided ID or an external ID. External IDs are customer-specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `crmId:abc123`
    
</dd>
</dl>

<dl>
<dd>

**addressTypes:** `Optional<List<UpdateAddressRequestAddressTypesItem>>` — Reporting location type associated with the address (used for ELD reporting purposes). Valid values: `yard`, `shortHaul`, `workforceSite`, `riskZone`, `industrialSite`, `alertsOnly`, `agricultureSource`, `avoidanceZone`, `knownGPSJammingZone`, `authorizedZone`, `unauthorizedZone`.
    
</dd>
</dl>

<dl>
<dd>

**contactIds:** `Optional<List<String>>` — An array of Contact IDs associated with this Address.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — The [external IDs](https://developers.samsara.com/docs/external-ids) for the given object.
    
</dd>
</dl>

<dl>
<dd>

**formattedAddress:** `Optional<String>` — The full street address for this address/geofence, as it might be recognized by Google Maps.
    
</dd>
</dl>

<dl>
<dd>

**geofence:** `Optional<UpdateAddressRequestGeofence>` 
    
</dd>
</dl>

<dl>
<dd>

**latitude:** `Optional<Double>` — Latitude of the address. Will be geocoded from `formattedAddress` if not provided.
    
</dd>
</dl>

<dl>
<dd>

**longitude:** `Optional<Double>` — Longitude of the address. Will be geocoded from `formattedAddress` if not provided.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — Name of the address.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — Notes about the address.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — An array of IDs of tags to associate with this address.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Alerts
<details><summary><code>client.alerts.getConfigurations() -> AlertsGetConfigurationsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get specified Alert Configurations.

The following trigger types are API enabled and will show up in the results:
Vehicle Speed
Ambient Temperature
Fuel Level (Percentage)
Vehicle DEF Level (Percentage)
Vehicle Battery
Gateway Unplugged
Dashcam Disconnected
Camera Connector Disconnected
Asset starts moving
Inside Geofence
Outside Geofence
Unassigned Driving
Driver HOS Violation
Vehicle Engine Idle
Asset Engine On
Asset Engine Off
Harsh Event
Scheduled Maintenance
Scheduled Maintenance by Odometer
Scheduled Maintenance by Engine Hours
Out of Route
GPS Signal Loss
Cell Signal Loss
Fault Code
Tire Faults
Gateway Disconnected
Panic Button
Tampering Detected
Asset Reading
If vehicle is severely speeding (as defined by your organization)
DVIR Submitted for Asset
Driver Document Submitted
Driver App Sign In
Driver App Sign Out
Geofence Entry
Geofence Exit
Route Stop ETA Alert
Driver Recorded
Sudden Fuel Level Rise
Sudden Fuel Level Drop
Scheduled Date And Time
Training Assignment Due Soon
Training Assignment Past Due

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Alerts** under the Alerts category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.alerts().getConfigurations(
    GetConfigurationsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — Filter by the IDs. Returns all if no ids are provided.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<GetConfigurationsRequestStatus>` — The status of the alert configuration.  Valid values: `all`, `enabled`, `disabled`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.alerts.postConfigurations(request) -> AlertsPostConfigurationsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates an alert configuration.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Alerts** under the Alerts category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.alerts().postConfigurations(
    AlertsPostConfigurationsRequestBody
        .builder()
        .isEnabled(true)
        .name("My Harsh Event Alert")
        .scope(
            ScopeObjectRequestBody
                .builder()
                .all(true)
                .build()
        )
        .actions(
            Arrays.asList(
                ActionObjectRequestBody
                    .builder()
                    .actionTypeId(1)
                    .build()
            )
        )
        .triggers(
            Arrays.asList(
                WorkflowTriggerObjectRequestBody
                    .builder()
                    .triggerTypeId(1000)
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**actions:** `List<ActionObjectRequestBody>` — An array of actions.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**isEnabled:** `Boolean` — Whether the alert is enabled or not.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — The custom name of the configuration.
    
</dd>
</dl>

<dl>
<dd>

**operationalSettings:** `Optional<OperationalSettingsObjectRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**scope:** `ScopeObjectRequestBody` 
    
</dd>
</dl>

<dl>
<dd>

**triggers:** `List<WorkflowTriggerObjectRequestBody>` — An array of triggers.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.alerts.deleteConfigurations()</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete an alert configuration.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Alerts** under the Alerts category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.alerts().deleteConfigurations(
    DeleteConfigurationsRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The unqiue Samsara id of the alert configuration.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.alerts.patchConfigurations(request) -> AlertsPatchConfigurationsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an alert configuration.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Alerts** under the Alerts category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.alerts().patchConfigurations(
    AlertsPatchConfigurationsRequestBody
        .builder()
        .id("e1c5dffc-c7b7-47b0-a778-6a65de638abf")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**actions:** `Optional<List<ActionObjectRequestBody>>` — An array of actions.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unqiue Samsara id of the alert configuration.
    
</dd>
</dl>

<dl>
<dd>

**isEnabled:** `Optional<Boolean>` — Whether the alert is enabled or not.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The custom name of the configuration.
    
</dd>
</dl>

<dl>
<dd>

**operationalSettings:** `Optional<OperationalSettingsObjectRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**scope:** `Optional<ScopeObjectRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**triggers:** `Optional<List<WorkflowTriggerObjectRequestBody>>` — An array of triggers.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.alerts.getIncidents() -> AlertsGetIncidentsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get Alert Incidents for specific Alert Configurations over a specified period of time.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Alerts** under the Alerts category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.alerts().getIncidents(
    GetIncidentsRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` — Required RFC 3339 timestamp that indicates when to begin receiving data. This will be based on updatedAtTime.
    
</dd>
</dl>

<dl>
<dd>

**configurationIds:** `Optional<String>` — Required array of alert configuration ids to return incident data for.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — Optional RFC 3339 timestamp to stop receiving data. Defaults to now if not provided. This will be based on updatedAtTime.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Assets
<details><summary><code>client.assets.list() -> SyncPagingIterable&amp;lt;AssetResponseBody&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List all assets. Up to 300 assets will be returned per page.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Assets** under the Assets category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().list(
    ListAssetsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**type:** `Optional<ListAssetsRequestType>` — The operational context in which the asset interacts with the Samsara system. Examples: Vehicle (eg: truck, bus...), Trailer (eg: dry van, reefer, flatbed...), Powered Equipment (eg: dozer, crane...), Unpowered Equipment (eg: container, dumpster...), or Uncategorized.  Valid values: `uncategorized`, `trailer`, `equipment`, `unpowered`, `vehicle`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**updatedAfterTime:** `Optional<String>` —  A filter on data to have an updated at time after or equal to this specified time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>

<dl>
<dd>

**includeTags:** `Optional<Boolean>` — Optional boolean indicating whether to return tags on supported entities
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**ids:** `Optional<String>` — A filter on the data based on this comma-separated list of asset IDs and External IDs.
    
</dd>
</dl>

<dl>
<dd>

**attributeValueIds:** `Optional<String>` — A filter on the data based on this comma-separated list of attribute value IDs. Only entities associated with ALL of the referenced values will be returned (i.e. the intersection of the sets of entities with each value). Example: `attributeValueIds=076efac2-83b5-47aa-ba36-18428436dcac,6707b3f0-23b9-4fe3-b7be-11be34aea544`
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<String>` — A filter on the data to return entities within given range query (only for numeric and date attributes) separated by a comma. Only entities meeting all the conditions will be returned. At least one bound must be provided. Example: `attributes=Length:range(8,)&attributes=Length:range(10,20)&attributes=Date:range(2025-01-01,2025-01-31)`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.assets.createAsset(request) -> AssetsCreateAssetResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new asset.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Assets** under the Assets category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().createAsset(
    AssetsCreateAssetRequestBody
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**licensePlate:** `Optional<String>` — The license plate of the asset.
    
</dd>
</dl>

<dl>
<dd>

**make:** `Optional<String>` — The OEM/manufacturer of the asset. Updates to this field are restricted.
    
</dd>
</dl>

<dl>
<dd>

**model:** `Optional<String>` — The model of the asset. Updates to this field are restricted.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The human-readable name of the asset. This is set by a fleet administrator and will appear in both Samsara’s cloud dashboard as well as the Samsara Driver mobile app. By default, this name is the serial number of the Samsara Asset Gateway. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — These are generic notes about the asset. Can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**readingsIngestionEnabled:** `Optional<Boolean>` — Indicates whether the asset is expected to have data ingested using the Readings API.
    
</dd>
</dl>

<dl>
<dd>

**regulationMode:** `Optional<AssetsCreateAssetRequestBodyRegulationMode>` — Whether or not the asset is regulated, unregulated (non-CMV), or a mixed use unregulated asset. Primarily used with vehicles.  Valid values: `mixed`, `regulated`, `unregulated`
    
</dd>
</dl>

<dl>
<dd>

**serialNumber:** `Optional<String>` — The serial number of the asset. This can be an internal serial number or used to hold legacy VIN/PIN numbers such as ones of shorter lengths.
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<AssetsCreateAssetRequestBodyType>` — The operational context in which the asset interacts with the Samsara system. Examples: Vehicle (eg: truck, bus...), Trailer (eg: dry van, reefer, flatbed...), Powered Equipment (eg: dozer, crane...), Unpowered Equipment (eg: container, dumpster...), or Uncategorized.  Valid values: `uncategorized`, `trailer`, `equipment`, `unpowered`, `vehicle`
    
</dd>
</dl>

<dl>
<dd>

**vin:** `Optional<String>` — The unique 17-digit VIN (Vehicle Identification Number) or PIN (Product Identification Number) of the asset.
    
</dd>
</dl>

<dl>
<dd>

**year:** `Optional<Long>` — The model year of the asset. Updates to this field are restricted.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.assets.deleteAsset()</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete an existing asset.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Assets** under the Assets category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().deleteAsset(
    DeleteAssetRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — A filter selecting a single asset by id.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.assets.updateAsset(request) -> AssetsUpdateAssetResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an existing asset.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Assets** under the Assets category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().updateAsset(
    AssetsUpdateAssetRequestBody
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — A filter selecting a single asset by id.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**licensePlate:** `Optional<String>` — The license plate of the asset.
    
</dd>
</dl>

<dl>
<dd>

**make:** `Optional<String>` — The OEM/manufacturer of the asset. Updates to this field are restricted.
    
</dd>
</dl>

<dl>
<dd>

**model:** `Optional<String>` — The model of the asset. Updates to this field are restricted.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The human-readable name of the asset. This is set by a fleet administrator and will appear in both Samsara’s cloud dashboard as well as the Samsara Driver mobile app. By default, this name is the serial number of the Samsara Asset Gateway. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — These are generic notes about the asset. Can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**readingsIngestionEnabled:** `Optional<Boolean>` — Indicates whether the asset is expected to have data ingested using the Readings API.
    
</dd>
</dl>

<dl>
<dd>

**regulationMode:** `Optional<AssetsUpdateAssetRequestBodyRegulationMode>` — Whether or not the asset is regulated, unregulated (non-CMV), or a mixed use unregulated asset. Primarily used with vehicles.  Valid values: `mixed`, `regulated`, `unregulated`
    
</dd>
</dl>

<dl>
<dd>

**serialNumber:** `Optional<String>` — The serial number of the asset. This can be an internal serial number or used to hold legacy VIN/PIN numbers such as ones of shorter lengths.
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<AssetsUpdateAssetRequestBodyType>` — The operational context in which the asset interacts with the Samsara system. Examples: Vehicle (eg: truck, bus...), Trailer (eg: dry van, reefer, flatbed...), Powered Equipment (eg: dozer, crane...), Unpowered Equipment (eg: container, dumpster...), or Uncategorized.  Valid values: `uncategorized`, `trailer`, `equipment`, `unpowered`, `vehicle`
    
</dd>
</dl>

<dl>
<dd>

**vin:** `Optional<String>` — The unique 17-digit VIN (Vehicle Identification Number) or PIN (Product Identification Number) of the asset.
    
</dd>
</dl>

<dl>
<dd>

**year:** `Optional<Long>` — The model year of the asset. Updates to this field are restricted.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.assets.v1GetAllAssetCurrentLocations() -> InlineResponse2002</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch current locations of all assets. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().v1GetAllAssetCurrentLocations(
    V1GetAllAssetCurrentLocationsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startingAfter:** `Optional<String>` — Pagination parameter indicating the cursor position to continue returning results after. Used in conjunction with the 'limit' parameter. Mutually exclusive with 'endingBefore' parameter.
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` — Pagination parameter indicating the cursor position to return results before. Used in conjunction with the 'limit' parameter. Mutually exclusive with 'startingAfter' parameter.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Pagination parameter indicating the number of results to return in this request. Used in conjunction with either 'startingAfter' or 'endingBefore'.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.assets.v1GetAssetsReefers() -> InlineResponse2003</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetches all reefers and reefer-specific stats. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Trailers** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().v1GetAssetsReefers(
    V1GetAssetsReefersRequest
        .builder()
        .startMs(1000000L)
        .endMs(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startMs:** `Long` — Timestamp in milliseconds representing the start of the period to fetch, inclusive. Used in combination with endMs.
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Long` — Timestamp in milliseconds representing the end of the period to fetch, inclusive. Used in combination with startMs.
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — Pagination parameter indicating the cursor position to continue returning results after. Used in conjunction with the 'limit' parameter. Mutually exclusive with 'endingBefore' parameter.
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` — Pagination parameter indicating the cursor position to return results before. Used in conjunction with the 'limit' parameter. Mutually exclusive with 'startingAfter' parameter.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Pagination parameter indicating the number of results to return in this request. Used in conjunction with either 'startingAfter' or 'endingBefore'.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.assets.v1GetAssetLocation(assetId) -> List&amp;lt;V1AssetLocationResponseItem&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

List historical locations for a given asset. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().v1GetAssetLocation(
    1000000L,
    V1GetAssetLocationRequest
        .builder()
        .startMs(1000000L)
        .endMs(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assetId:** `Long` — ID of the asset. Must contain only digits 0-9.
    
</dd>
</dl>

<dl>
<dd>

**startMs:** `Long` — Timestamp in milliseconds representing the start of the period to fetch, inclusive. Used in combination with endMs.
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Long` — Timestamp in milliseconds representing the end of the period to fetch, inclusive. Used in combination with startMs.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.assets.v1GetAssetReefer(assetId) -> V1AssetReeferResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch the reefer-specific stats of an asset. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Trailers** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().v1GetAssetReefer(
    1000000L,
    V1GetAssetReeferRequest
        .builder()
        .startMs(1000000L)
        .endMs(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assetId:** `Long` — ID of the asset. Must contain only digits 0-9.
    
</dd>
</dl>

<dl>
<dd>

**startMs:** `Long` — Timestamp in milliseconds representing the start of the period to fetch, inclusive. Used in combination with endMs.
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Long` — Timestamp in milliseconds representing the end of the period to fetch, inclusive. Used in combination with startMs.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.assets.get(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().get(
    "id",
    GetAssetsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.assets.update(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.assets().update(
    "id",
    UpdateAssetsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Beta APIs
<details><summary><code>client.betaApIs.getDepreciationTransactions() -> DepreciationGetDepreciationTransactionsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns depreciation and adjustment transactions for assets. Transactions are returned ordered by updatedAt in ascending order (oldest to newest). Use startTime parameter for incremental sync.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Assets** under the Assets category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getDepreciationTransactions(
    GetDepreciationTransactionsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `Optional<OffsetDateTime>` — RFC 3339 timestamp. Returns transactions updated after this time. Compared against updatedAt. If not provided, returns all transactions. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — RFC 3339 timestamp. Returns transactions updated before this time. Compared against updatedAt. If not provided, behaves as an unending feed of changes. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — Filter by asset IDs. Up to 50 ids.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getAssetsInputs() -> AssetsInputsGetAssetsInputsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return data collected from the inputs of your organization's assets based on the time parameters passed in. Results are paginated. If you include an endTime, the endpoint will return data up until that point. If you don’t include an endTime, you can continue to poll the API real-time with the pagination cursor that gets returned on every call. The endpoint will only return data up until the endTime that has been processed by the server at the time of the original request. You will need to request the same [startTime, endTime) range again to receive data for assets processed after the original request time. This endpoint sorts data by time ascending.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Assets** under the Assets category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getAssetsInputs(
    GetAssetsInputsRequest
        .builder()
        .type(GetAssetsInputsRequestType.AUX_INPUT1)
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — Comma-separated list of asset IDs. Limited to 100 ID's for each request.
    
</dd>
</dl>

<dl>
<dd>

**type:** `GetAssetsInputsRequestType` — Input stat type to query for.  Valid values: `auxInput1`, `auxInput2`, `auxInput3`, `auxInput4`, `auxInput5`, `auxInput6`, `auxInput7`, `auxInput8`, `auxInput9`, `auxInput10`, `auxInput11`, `auxInput12`, `auxInput13`, `analogInput1Voltage`, `analogInput2Voltage`, `analogInput1Current`, `analogInput2Current`, `batteryVoltage`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Defaults to never if not provided; if not provided then pagination will not cease, and a valid pagination cursor will always be returned. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>

<dl>
<dd>

**includeTags:** `Optional<Boolean>` — Optional boolean indicating whether to return tags on supported entities
    
</dd>
</dl>

<dl>
<dd>

**includeAttributes:** `Optional<Boolean>` — Optional boolean indicating whether to return attributes on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getAempEquipmentList(pageNumber) -> AempEquipmentGetAempEquipmentListResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of equipment following the AEMP ISO 15143-3 standard.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read AEMP** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getAempEquipmentList(
    "pageNumber",
    GetAempEquipmentListRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**pageNumber:** `String` — The number corresponding to a specific page of paginated results, defaulting to the first page if not provided. The default page size is 100 records.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getDriverEfficiency() -> DriverEfficienciesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all driver and associated vehicle efficiency data. 

 This is a legacy endpoint, consider using this endpoint [/driver-efficiency/drivers](https://developers.samsara.com/reference/getdriverefficiencybydrivers) instead. The endpoint will continue to function as documented. 

 <b>Rate limit:</b> 50 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Fuel & Energy** under the Fuel & Energy category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getDriverEfficiency(
    GetDriverEfficiencyRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverActivationStatus:** `Optional<GetDriverEfficiencyRequestDriverActivationStatus>` — If value is `deactivated`, only drivers that are deactivated will appear in the response. This parameter will default to `active` if not provided (fetching only active drivers).
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — A filter on the data based on this comma-separated list of driver IDs. Cannot be used with tag filtering or driver status. Example: `driverIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**driverTagIds:** `Optional<String>` — Filters summary to drivers based on this comma-separated list of tag IDs. Data from all the drivers' respective vehicles will be included in the summary, regardless of which tag the vehicle is associated with. Should not be provided in addition to `driverIds`. Example: driverTagIds=1234,5678
    
</dd>
</dl>

<dl>
<dd>

**driverParentTagIds:** `Optional<String>` — Filters like `driverTagIds` but includes descendants of all the given parent tags. Should not be provided in addition to `driverIds`. Example: `driverParentTagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<OffsetDateTime>` 

A start time in RFC 3339 format. The results will be truncated to the hour mark for the provided time. For example, if `startTime` is 2020-03-17T12:06:19Z then the results will include data starting from 2020-03-17T12:00:00Z. The provided start time cannot be in the future. Start time can be at most 31 days before the end time. If the start time is within the last hour, the results will be empty. Default: 24 hours prior to endTime.

Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` 

An end time in RFC 3339 format. The results will be truncated to the hour mark for the provided time. For example, if `endTime` is 2020-03-17T12:06:19Z then the results will include data up until 2020-03-17T12:00:00Z. The provided end time cannot be in the future. End time can be at most 31 days after the start time. Default: The current time truncated to the hour mark.

Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.patchEquipment(id, request) -> EquipmentPatchEquipmentResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an equipment.  **Note** this implementation of patch uses [the JSON merge patch](https://tools.ietf.org/html/rfc7396) proposed standard.
 This means that any fields included in the patch request will _overwrite_ fields which exist on the target resource.
 For arrays, this means any array included in the request will _replace_ the array that exists at the specified path, it will not _add_ to the existing array

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Equipment** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().patchEquipment(
    "id",
    EquipmentPatchEquipmentRequestBody
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The unique Samsara ID of the Equipment. This is automatically generated when the Equipment object is created. It cannot be changed.
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<List<GoaAttributeTiny>>` — List of attributes associated with the entity
    
</dd>
</dl>

<dl>
<dd>

**engineHours:** `Optional<Long>` — When you provide a manual engine hours override, Samsara will begin updating a equipment's engine hours used since this override was set.
    
</dd>
</dl>

<dl>
<dd>

**equipmentSerialNumber:** `Optional<String>` — The serial number of the equipment.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The human-readable name of the Equipment. This is set by a fleet administrator and will appear in both Samsara’s cloud dashboard as well as the Samsara Driver mobile app. By default, this name is the serial number of the Samsara Asset Gateway. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — These are generic notes about the Equipment. Empty by default. Can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**odometerMeters:** `Optional<Long>` — When you provide a manual odometer override, Samsara will begin updating a equipment's odometer using GPS distance traveled since this override was set.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — An array of IDs of tags to associate with this equipment. If your access to the API is scoped by one or more tags, this field is required to pass in. 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getHosEldEvents() -> HosEldEventsGetHosEldEventsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all HOS ELD events in a time range, grouped by driver. Attributes will be populated depending on which ELD Event Type is being returned.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read ELD Compliance Settings (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getHosEldEvents(
    GetHosEldEventsRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver IDs and externalIds. Example: `driverIds=1234,5678,payroll:4841`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**driverActivationStatus:** `Optional<GetHosEldEventsRequestDriverActivationStatus>` — If value is `deactivated`, only drivers that are deactivated will appear in the response. This parameter will default to `active` if not provided (fetching only active drivers).  Valid values: `active`, `deactivated`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 25 objects.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getTrailerStatsSnapshot() -> TrailerStatsGetTrailerStatsSnapshotResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the last known stats of all trailers at the given `time`. If no `time` is specified, the current time is used.

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Trailer Statistics** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getTrailerStatsSnapshot(
    GetTrailerStatsSnapshotRequest
        .builder()
        .types("types")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**types:** `String` 

The stat types you want this endpoint to return information on.

You may list **up to 3** types using comma-separated format. For example: `types=gps,reeferAmbientAirTemperatureMilliC,gpsOdometerMeters`.

* `gps`: GPS data including lat/long, heading, speed, and a reverse geocode address.
* `gpsOdometerMeters`: Odometer reading provided by GPS calculations. You must provide a manual odometer reading before this value is updated. Manual odometer readings can be provided via the PATCH /fleet/trailers/{id} endpoint or through the [cloud dashboard](https://kb.samsara.com/hc/en-us/articles/115005273667-Editing-Odometer-Reading). Odometer readings wthat are manually set will update as GPS trip data is gathered.
* `reeferAmbientAirTemperatureMilliC`: The ambient air temperature reading of the reefer in millidegree Celsius.
* `reeferObdEngineSeconds`: The cumulative number of seconds the reefer has run according to onboard diagnostics. Only supported on reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone1`: The supply or discharge air temperature zone 1 in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone2`: The supply or discharge air temperature zone 2 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone3`: The supply or discharge air temperature zone 3 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferFuelPercent`: The fuel level of the reefer unit in percentage points (e.g. `99`, `50`, etc). Only supported on reefer solutions.
* `carrierReeferState`: The overall state of the reefer (`Off`, `On`). Only supported on multizone Carrier reefer solutions.
* `reeferStateZone1`: The state of the reefer in zone 1. For single zone reefers, this applies tot he single zone. Only supported on multizone reefer solutions.
* `reeferStateZone2`: The state of the reefer in zone 2. Only supported on multizone reefer solutions.
* `reeferStateZone3`: The state of the reefer in zone 3. Only supported on multizone reefer solutions.
* `reeferRunMode`: The operational mode of the reefer (`Start/Stop`, `Continuous`)
* `reeferAlarms`: Any alarms that are present on the reefer. Only supported on reefer solutions.
* `reeferReturnAirTemperatureMilliCZone1`: The return air temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone2`: The return air temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone3`: The return air temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone1`: The set point temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone2`: The set point temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone3`: The set point temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferDoorStateZone1`: The door status in zone 1 of the reefer. For single zone reefers, this applies to the single zone.
* `reeferDoorStateZone2`: The door status in zone 2 of the reefer. Only supported on multizone reefer solutions.
* `reeferDoorStateZone3`: The door status in zone 3 of the reefer. Only supported on multizone reefer solutions.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**trailerIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of trailer IDs and externalIds. Example: `trailerIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**time:** `Optional<String>` —  A filter on the data that returns the last known data points with timestamps less than or equal to this value. Defaults to now if not provided. Must be a string in RFC 3339 Format. Millisecond precision and timezones are supported.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getTrailerStatsFeed() -> TrailerStatsGetTrailerStatsFeedResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Follow a feed of trailer stats.

The first call to this endpoint will provide the most recent stats for each trailer and an `endCursor`.

Providing the `endCursor` value to the `after` query parameter will fetch all updates since the previous API call.

If `hasNextPage` is false, no new data is immediately available. Please wait a minimum of 5 seconds before making a subsequent request.

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Trailer Statistics** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getTrailerStatsFeed(
    GetTrailerStatsFeedRequest
        .builder()
        .types("types")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**types:** `String` 

The stat types you want this endpoint to return information on.

You may list **up to 3** types using comma-separated format. For example: `types=gps,reeferAmbientAirTemperatureMilliC,gpsOdometerMeters`.

* `gps`: GPS data including lat/long, heading, speed, and a reverse geocode address.
* `gpsOdometerMeters`: Odometer reading provided by GPS calculations. You must provide a manual odometer reading before this value is updated. Manual odometer readings can be provided via the PATCH /fleet/trailers/{id} endpoint or through the [cloud dashboard](https://kb.samsara.com/hc/en-us/articles/115005273667-Editing-Odometer-Reading). Odometer readings wthat are manually set will update as GPS trip data is gathered.
* `reeferAmbientAirTemperatureMilliC`: The ambient air temperature reading of the reefer in millidegree Celsius.
* `reeferObdEngineSeconds`: The cumulative number of seconds the reefer has run according to onboard diagnostics. Only supported on reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone1`: The supply or discharge air temperature zone 1 in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone2`: The supply or discharge air temperature zone 2 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone3`: The supply or discharge air temperature zone 3 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferFuelPercent`: The fuel level of the reefer unit in percentage points (e.g. `99`, `50`, etc). Only supported on reefer solutions.
* `carrierReeferState`: The overall state of the reefer (`Off`, `On`). Only supported on multizone Carrier reefer solutions.
* `reeferStateZone1`: The state of the reefer in zone 1. For single zone reefers, this applies tot he single zone. Only supported on multizone reefer solutions.
* `reeferStateZone2`: The state of the reefer in zone 2. Only supported on multizone reefer solutions.
* `reeferStateZone3`: The state of the reefer in zone 3. Only supported on multizone reefer solutions.
* `reeferRunMode`: The operational mode of the reefer (`Start/Stop`, `Continuous`)
* `reeferAlarms`: Any alarms that are present on the reefer. Only supported on reefer solutions.
* `reeferReturnAirTemperatureMilliCZone1`: The return air temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone2`: The return air temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone3`: The return air temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone1`: The set point temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone2`: The set point temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone3`: The set point temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferDoorStateZone1`: The door status in zone 1 of the reefer. For single zone reefers, this applies to the single zone.
* `reeferDoorStateZone2`: The door status in zone 2 of the reefer. Only supported on multizone reefer solutions.
* `reeferDoorStateZone3`: The door status in zone 3 of the reefer. Only supported on multizone reefer solutions.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**trailerIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of trailer IDs and externalIds. Example: `trailerIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**decorations:** `Optional<String>` 

Decorations add to the primary stats listed in the `types` parameter. For example, if you wish to know the trailer's location whenever the odometer updates, you may set `types=gpsOdometerMeters&decorations=gps`.

You may list **up to 2** types using comma-separated format. If multiple stats are listed in the types parameter, the decorations will be added to each type. For example: `types=reeferStateZone1,reeferAmbientAirTemperatureMilliC,gpsOdometerMeters&decorations=gps` will list GPS decorations for each reeferStateZone1 reading, each reeferAmbientAirTemperatureMilliC reding, and gpsOdometerMeters reading.

Note that decorations may significantly increase the response payload size.

* `gps`: GPS data including lat/long, heading, speed, and a reverse geocode address.
* `gpsOdometerMeters`: Odometer reading provided by GPS calculations. You must provide a manual odometer reading before this value is updated. Manual odometer readings can be provided via the PATCH /fleet/trailers/{id} endpoint or through the [cloud dashboard](https://kb.samsara.com/hc/en-us/articles/115005273667-Editing-Odometer-Reading). Odometer readings wthat are manually set will update as GPS trip data is gathered.
* `reeferAmbientAirTemperatureMilliC`: The ambient air temperature reading of the reefer in millidegree Celsius.
* `reeferObdEngineSeconds`: The cumulative number of seconds the reefer has run according to onboard diagnostics. Only supported on reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone1`: The supply or discharge air temperature zone 1 in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone2`: The supply or discharge air temperature zone 2 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone3`: The supply or discharge air temperature zone 3 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferFuelPercent`: The fuel level of the reefer unit in percentage points (e.g. `99`, `50`, etc). Only supported on reefer solutions.
* `carrierReeferState`: The overall state of the reefer (`Off`, `On`). Only supported on multizone Carrier reefer solutions.
* `reeferStateZone1`: The state of the reefer in zone 1. For single zone reefers, this applies tot he single zone. Only supported on multizone reefer solutions.
* `reeferStateZone2`: The state of the reefer in zone 2. Only supported on multizone reefer solutions.
* `reeferStateZone3`: The state of the reefer in zone 3. Only supported on multizone reefer solutions.
* `reeferRunMode`: The operational mode of the reefer (`Start/Stop`, `Continuous`)
* `reeferAlarms`: Any alarms that are present on the reefer. Only supported on reefer solutions.
* `reeferReturnAirTemperatureMilliCZone1`: The return air temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone2`: The return air temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone3`: The return air temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone1`: The set point temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone2`: The set point temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone3`: The set point temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferDoorStateZone1`: The door status in zone 1 of the reefer. For single zone reefers, this applies to the single zone.
* `reeferDoorStateZone2`: The door status in zone 2 of the reefer. Only supported on multizone reefer solutions.
* `reeferDoorStateZone3`: The door status in zone 3 of the reefer. Only supported on multizone reefer solutions.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getTrailerStatsHistory() -> TrailerStatsGetTrailerStatsHistoryResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns trailer stats during the given time range for all trailers. This can be optionally filtered by tags or specific trailer IDs.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Trailer Statistics** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getTrailerStatsHistory(
    GetTrailerStatsHistoryRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .types("types")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**types:** `String` 

The stat types you want this endpoint to return information on.

You may list **up to 3** types using comma-separated format. For example: `types=gps,reeferAmbientAirTemperatureMilliC,gpsOdometerMeters`.

* `gps`: GPS data including lat/long, heading, speed, and a reverse geocode address.
* `gpsOdometerMeters`: Odometer reading provided by GPS calculations. You must provide a manual odometer reading before this value is updated. Manual odometer readings can be provided via the PATCH /fleet/trailers/{id} endpoint or through the [cloud dashboard](https://kb.samsara.com/hc/en-us/articles/115005273667-Editing-Odometer-Reading). Odometer readings wthat are manually set will update as GPS trip data is gathered.
* `reeferAmbientAirTemperatureMilliC`: The ambient air temperature reading of the reefer in millidegree Celsius.
* `reeferObdEngineSeconds`: The cumulative number of seconds the reefer has run according to onboard diagnostics. Only supported on reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone1`: The supply or discharge air temperature zone 1 in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone2`: The supply or discharge air temperature zone 2 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone3`: The supply or discharge air temperature zone 3 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferFuelPercent`: The fuel level of the reefer unit in percentage points (e.g. `99`, `50`, etc). Only supported on reefer solutions.
* `carrierReeferState`: The overall state of the reefer (`Off`, `On`). Only supported on multizone Carrier reefer solutions.
* `reeferStateZone1`: The state of the reefer in zone 1. For single zone reefers, this applies tot he single zone. Only supported on multizone reefer solutions.
* `reeferStateZone2`: The state of the reefer in zone 2. Only supported on multizone reefer solutions.
* `reeferStateZone3`: The state of the reefer in zone 3. Only supported on multizone reefer solutions.
* `reeferRunMode`: The operational mode of the reefer (`Start/Stop`, `Continuous`)
* `reeferAlarms`: Any alarms that are present on the reefer. Only supported on reefer solutions.
* `reeferReturnAirTemperatureMilliCZone1`: The return air temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone2`: The return air temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone3`: The return air temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone1`: The set point temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone2`: The set point temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone3`: The set point temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferDoorStateZone1`: The door status in zone 1 of the reefer. For single zone reefers, this applies to the single zone.
* `reeferDoorStateZone2`: The door status in zone 2 of the reefer. Only supported on multizone reefer solutions.
* `reeferDoorStateZone3`: The door status in zone 3 of the reefer. Only supported on multizone reefer solutions.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**trailerIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of trailer IDs and externalIds. Example: `trailerIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**decorations:** `Optional<String>` 

Decorations add to the primary stats listed in the `types` parameter. For example, if you wish to know the trailer's location whenever the odometer updates, you may set `types=gpsOdometerMeters&decorations=gps`.

You may list **up to 2** types using comma-separated format. If multiple stats are listed in the types parameter, the decorations will be added to each type. For example: `types=reeferStateZone1,reeferAmbientAirTemperatureMilliC,gpsOdometerMeters&decorations=gps` will list GPS decorations for each reeferStateZone1 reading, each reeferAmbientAirTemperatureMilliC reding, and gpsOdometerMeters reading.

Note that decorations may significantly increase the response payload size.

* `gps`: GPS data including lat/long, heading, speed, and a reverse geocode address.
* `gpsOdometerMeters`: Odometer reading provided by GPS calculations. You must provide a manual odometer reading before this value is updated. Manual odometer readings can be provided via the PATCH /fleet/trailers/{id} endpoint or through the [cloud dashboard](https://kb.samsara.com/hc/en-us/articles/115005273667-Editing-Odometer-Reading). Odometer readings wthat are manually set will update as GPS trip data is gathered.
* `reeferAmbientAirTemperatureMilliC`: The ambient air temperature reading of the reefer in millidegree Celsius.
* `reeferObdEngineSeconds`: The cumulative number of seconds the reefer has run according to onboard diagnostics. Only supported on reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone1`: The supply or discharge air temperature zone 1 in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone2`: The supply or discharge air temperature zone 2 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSupplyAirTemperatureMilliCZone3`: The supply or discharge air temperature zone 3 in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferFuelPercent`: The fuel level of the reefer unit in percentage points (e.g. `99`, `50`, etc). Only supported on reefer solutions.
* `carrierReeferState`: The overall state of the reefer (`Off`, `On`). Only supported on multizone Carrier reefer solutions.
* `reeferStateZone1`: The state of the reefer in zone 1. For single zone reefers, this applies tot he single zone. Only supported on multizone reefer solutions.
* `reeferStateZone2`: The state of the reefer in zone 2. Only supported on multizone reefer solutions.
* `reeferStateZone3`: The state of the reefer in zone 3. Only supported on multizone reefer solutions.
* `reeferRunMode`: The operational mode of the reefer (`Start/Stop`, `Continuous`)
* `reeferAlarms`: Any alarms that are present on the reefer. Only supported on reefer solutions.
* `reeferReturnAirTemperatureMilliCZone1`: The return air temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone2`: The return air temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferReturnAirTemperatureMilliCZone3`: The return air temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone1`: The set point temperature in zone 1 of the reefer in millidegrees Celsius. For single zone reefers, this applies to the single zone. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone2`: The set point temperature in zone 2 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferSetPointTemperatureMilliCZone3`: The set point temperature in zone 3 of the reefer in millidegrees Celsius. Only supported on multizone reefer solutions.
* `reeferDoorStateZone1`: The door status in zone 1 of the reefer. For single zone reefers, this applies to the single zone.
* `reeferDoorStateZone2`: The door status in zone 2 of the reefer. Only supported on multizone reefer solutions.
* `reeferDoorStateZone3`: The door status in zone 3 of the reefer. Only supported on multizone reefer solutions.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.updateEngineImmobilizerState(id, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update the engine immobilizer state of a vehicle. This requires an engine immobilizer to be installed on the vehicle gateway.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Vehicle Immobilization** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().updateEngineImmobilizerState(
    1000000L,
    EngineImmobilizerUpdateEngineImmobilizerStateRequestBody
        .builder()
        .relayStates(
            Arrays.asList(
                UpdateEngineImmobilizerRelayStateRequestBodyRequestBody
                    .builder()
                    .id(UpdateEngineImmobilizerRelayStateRequestBodyRequestBodyId.RELAY1)
                    .isOpen(true)
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `Long` — Vehicle ID
    
</dd>
</dl>

<dl>
<dd>

**relayStates:** `List<UpdateEngineImmobilizerRelayStateRequestBodyRequestBody>` — A list of relay states. If a relay is omitted, its state won't be updated. If the list is empty, a 400 bad request status code will be returned. If there are multiple states for the same relay, a 400 bad request status code will be returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getJobs() -> JobsGetJobsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetches jobs based on id/uuid or provided filters.

To use this endpoint, select **Read Jobs** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getJobs(
    GetJobsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `Optional<String>` — A jobId or uuid in STRING format. JobId must be prefixed with `jobId:`(Examples: `"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596"`, `"jobId:98765"`).
    
</dd>
</dl>

<dl>
<dd>

**startDate:** `Optional<String>` —  A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endDate:** `Optional<String>` —  An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**industrialAssetIds:** `Optional<String>` — IndustrialAssetId in STRING format. (Example: `"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596"`).
    
</dd>
</dl>

<dl>
<dd>

**fleetDeviceIds:** `Optional<Long>` — FleetDeviceId in INTEGER format. (Example: `123456`).
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<GetJobsRequestStatus>` — A job status in STRING format. Job statuses can be one of three (ignores case): `"active", "scheduled", "completed"`  Valid values: `active`, `scheduled`, `completed`
    
</dd>
</dl>

<dl>
<dd>

**customerName:** `Optional<String>` — Customer name to filter by
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.createJob(request) -> JobsCreateJobResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new job and returns it.

To use this endpoint, select **Write Jobs** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().createJob(
    JobsCreateJobRequestBody
        .builder()
        .job(
            PostJobObjectRequestBody
                .builder()
                .endDate("2019-06-13T19:08:25Z")
                .id("8d218e6c-7a16-4f9f-90f7-cc1d93b9e596")
                .name("My Job Name")
                .startDate("2019-06-13T19:08:25Z")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**job:** `PostJobObjectRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.deleteJob() -> JobsDeleteJobResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes an existing job.

To use this endpoint, select **Write Jobs** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().deleteJob(
    DeleteJobRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — A jobId or uuid in STRING format. JobId must be prefixed with `jobId:`(Examples: `"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596"`, `"jobId:98765"`).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.patchJob(request) -> JobsPatchJobResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Patches an existing job and returns it.

To use this endpoint, select **Write Jobs** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().patchJob(
    JobsPatchJobRequestBody
        .builder()
        .id("id")
        .job(
            PatchJobObjectRequestBody
                .builder()
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — A jobId or uuid in STRING format. JobId must be prefixed with `jobId:`(Examples: `"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596"`, `"jobId:98765"`).
    
</dd>
</dl>

<dl>
<dd>

**job:** `PatchJobObjectRequestBody` 
    
</dd>
</dl>

<dl>
<dd>

**keepHistory:** `Optional<Boolean>` — Defaults to true if user does not want to overwrite entire history for an active job (irrelevant for scheduled/completed jobs)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getDetections() -> DetectionLogGetDetectionsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return all detections detected by in-vehicle assets and associated metadata. To get core endpoint data, select View Safety Detection Log under the Safety & Cameras category when creating or editing an API token.

If you include an endTime, the endpoint will return data up until that point. If you don’t include an endTime, you can continue to poll the API real-time with the pagination cursor that gets returned on every call. Results are paginated.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Detection Log** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getDetections(
    GetDetectionsRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverIds:** `Optional<String>` — Optional string of comma separated driver IDs. If driver ID is present, events for the specified driver(s) will be returned. Max for this value is 2000 objects. (Example: 281474982859091,281471982957527)
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — Optional string of comma separated asset IDs. If asset ID is present, events for the specified asset(s) will be returned. Max for this value is 2000 objects. (Example: 281474982859091,281471982957527)
    
</dd>
</dl>

<dl>
<dd>

**detectionBehaviorLabels:** `Optional<String>` — Optional string of comma separated labels to filter behavior labels. Uses OR semantics for filtering. An empty list allows all values. Valid values: `acceleration`, `braking`, `crash`, `drowsy`, `eatingDrinking`, `edgeRailroadCrossingViolation`, `followingDistance`, `forwardCollisionWarning`, `genericDistraction`, `harshTurn`, `heavySpeeding`, `laneDeparture`, `lightSpeeding`, `maxSpeed`, `mobileUsage`, `moderateSpeeding`, `noSeatbelt`, `obstructedCamera`, `passenger`, `policyViolationMask`, `ranRedLight`, `rearCollisionWarning`, `rollingStop`, `rolloverProtection`, `severeSpeeding`, `smoking`, `speeding`, `unsafeParking`, `vehicleInBlindSpotWarning`, `vulnerableRoadUserCollisionWarning`, `yawControl`. (Example: rollingStop,obstructedCamera,noSeatbelt)
    
</dd>
</dl>

<dl>
<dd>

**inboxFilterReason:** `Optional<String>` — Optional string of comma separated reasons to filter detections. Uses OR semantics for filtering. An empty list allows all values. Valid values: `overDailyLimit`, `overHourlyLimit`, `overTripLimit`, `belowConfidenceThreshold`, `belowSeverityThreshold`, `overEventRateLimit`, `geofenceFilter`, `belowNudgeThreshold`, `belowSpeedThreshold`, `nighttimeFilter`, `speedingFilter`, `inCabAlertOnly`, `unknown`. (Example: overDailyLimit,overHourlyLimit,belowConfidenceThreshold)
    
</dd>
</dl>

<dl>
<dd>

**inboxEvent:** `Optional<Boolean>` — Indicates whether or not to return detections with an associated Safety Inbox event. An empty entry allows all values. (Example: true)
    
</dd>
</dl>

<dl>
<dd>

**inCabAlertPlayed:** `Optional<Boolean>` — Indicates whether or not to return detections where in-cab alert played. An empty entry allows all values. (Example: true)
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — An optional filter on the data based on this comma-separated list of tag IDs. The filtering is OR inclusive for asset and driver tags. (Example: 1234,5678)
    
</dd>
</dl>

<dl>
<dd>

**includeAsset:** `Optional<Boolean>` — Indicates whether or not to return expanded data for asset objects. (Example: true)
    
</dd>
</dl>

<dl>
<dd>

**includeDriver:** `Optional<Boolean>` — Indicates whether or not to return expanded data for driver objects. (Example: true)
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — Required RFC 3339 timestamp that indicates when to begin receiving data. Value is compared against `updatedAtTime`. (Example: 2024-04-16T19:08:25Z)
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — Optional RFC 3339 timestamp. If not provided then the endpoint behaves as an unending feed of changes. If endTime is set the same as startTime, the most recent data point before that time will be returned per asset. Value is compared against `updatedAtTime`. (Example: 2024-04-23T19:08:25Z)
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getDevices() -> DevicesGetDevicesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all installed cameras (CM3x), vehicle gateways (VGs), and asset gateways (AGs) and their health information within an organization. 

**Beta:** This endpoint is in beta and is likely to change before being broadly available. Reach out to your Samsara Representative to have Devices API enabled for your organization.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Devices** under the Devices category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getDevices(
    GetDevicesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**models:** `Optional<String>` — Optional string of comma separated device models. Valid values: `CM31`, `CM32`, `CM33`, `CM34`, `VG34`, `VG34M`, `VG34EU`, `VG34FN`, `VG54NA`, `VG54EU`, `VG55NA`, `VG55EU`, `AG24`, `AG24EU`, `AG26`, `AG26EU`, `AG45`, `AG45EU`, `AG46`, `AG46EU`, `AG46P`, `AG46PEU`, `AG51`, `AG51EU`, `AG52`, `AG52EU`, `AG53`, `AG53EU`
    
</dd>
</dl>

<dl>
<dd>

**healthStatuses:** `Optional<String>` — Optional string of comma separated device health statuses. Valid values: `healthy`, `needsAttention`, `needsReplacement`, `dataPending`.
    
</dd>
</dl>

<dl>
<dd>

**includeHealth:** `Optional<Boolean>` — Optional boolean to control whether device health information is returned in the response. Defaults to false.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 100 objects.
    
</dd>
</dl>

<dl>
<dd>

**includeTags:** `Optional<Boolean>` — Optional boolean to control whether tags are returned in the response. Defaults to false.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getEngineImmobilizerStates() -> EngineImmobilizerGetEngineImmobilizerStatesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the engine immobilizer states of the queried vehicles. If a vehicle has never had an engine immobilizer connected, there won't be any state returned for that vehicle.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Vehicle Immobilization** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getEngineImmobilizerStates(
    GetEngineImmobilizerStatesRequest
        .builder()
        .vehicleIds("vehicleIds")
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**vehicleIds:** `String` —  A filter on the data based on this comma-separated list of vehicle IDs and externalIds. Example: `vehicleIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.startFunctionRun(name, request) -> FunctionsStartFunctionRunResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Start an asynchronous run for the specified Function. This endpoint allows you to override parameters available at runtime.

 <b>Rate limit:</b> 2 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Functions** under the Closed Beta category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().startFunctionRun(
    "name",
    FunctionsStartFunctionRunRequestBody
        .builder()
        .paramsOverride(
            FunctionsStartFunctionRunRequestBodyParamsOverride
                .builder()
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**name:** `String` — The name of the Function to run.
    
</dd>
</dl>

<dl>
<dd>

**paramsOverride:** `FunctionsStartFunctionRunRequestBodyParamsOverride` — Parameter overrides for the Function execution. Can be an empty object but must be provided.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.updateShippingDocs(request) -> HosDailyLogsUpdateShippingDocsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update the shippingDocs field of an existing assignment.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write ELD Hours of Service (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().updateShippingDocs(
    HosDailyLogsUpdateShippingDocsRequestBody
        .builder()
        .hosDate("hosDate")
        .driverId("driverID")
        .shippingDocs("ShippingID1, ShippingID2")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**hosDate:** `String` — A start date in yyyy-mm-dd format. Required.
    
</dd>
</dl>

<dl>
<dd>

**driverId:** `String` — ID of the driver for whom the duty status is being set.
    
</dd>
</dl>

<dl>
<dd>

**shippingDocs:** `String` — ShippingDocs associated with the driver for the day.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.listHubCustomProperties() -> HubCustomPropertiesListHubCustomPropertiesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve custom properties for a specific hub.

**Beta:** This endpoint is in beta and is likely to change before being broadly available. Reach out to your Samsara Representative to have RoutePlanning APIs enabled for your organization.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().listHubCustomProperties(
    ListHubCustomPropertiesRequest
        .builder()
        .hubId("hubId")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**hubId:** `String` — The hub identifier
    
</dd>
</dl>

<dl>
<dd>

**customPropertyIds:** `Optional<String>` — A comma-separated list of custom property IDs that can be used for filtering.
    
</dd>
</dl>

<dl>
<dd>

**customPropertyNames:** `Optional<String>` — A comma-separated list of custom property names that can be used for filtering.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<OffsetDateTime>` — Time filter of when the custom property was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — Time filter of when the custom property was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, should be the endCursor from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of objects to return. Default and maximum is 100
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.createPlanOrders(request) -> PlanOrdersCreatePlanOrdersResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create one or more orders (bulk upsert). Pass an array of order objects; any object whose customerOrderId already exists will be updated, otherwise a new order is created. Functions can return JSON arrays in this Order POST format. Orders are initially created at the plan level but will migrate to hub-level entities, with planId becoming optional in future versions.

**Beta:** This endpoint is in beta and is likely to change before being broadly available. Reach out to your Samsara Representative to have RoutePlanning APIs enabled for your organization.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().createPlanOrders(
    PlanOrdersCreatePlanOrdersRequestBody
        .builder()
        .data(
            Arrays.asList(
                OrderInputObjectRequestBody
                    .builder()
                    .customerOrderId("ORDER-2024-001")
                    .hubId("550e8400-e29b-41d4-a716-446655440000")
                    .planId("650e8400-e29b-41d4-a716-446655440023")
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**data:** `List<OrderInputObjectRequestBody>` — An array of order objects to be created or updated
    
</dd>
</dl>

<dl>
<dd>

**enableUpdateExistingOrders:** `Optional<Boolean>` — Enable update of existing orders if an order with the same customerOrderId exists. The input must match the same quantity dimensions as the existing order. If not provided, requests will fail if an order's customerOrderId already exists.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getQualificationRecords() -> QualificationsGetQualificationRecordsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns qualification records for the specified list of IDs.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Qualification Records** under the Qualification Records category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getQualificationRecords(
    GetQualificationRecordsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — A comma-separated list containing up to 100 qualification record IDs to filter on. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a query parameter, use the following format: key:value.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — If true, externalIds for qualification record and for the owner entity are returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.postQualificationRecord(request) -> QualificationsPostQualificationRecordResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new qualification record.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Qualification Records** under the Qualification Records category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().postQualificationRecord(
    QualificationsPostQualificationRecordRequestBody
        .builder()
        .issueDate(OffsetDateTime.parse("2025-08-27T10:20:30Z"))
        .owner(
            QualificationOwnerRequestObjectRequestBody
                .builder()
                .entityType(QualificationOwnerRequestObjectRequestBodyEntityType.WORKER)
                .id("281474")
                .build()
        )
        .qualificationType(
            QualificationTypeRequestObjectRequestBody
                .builder()
                .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                .build()
        )
        .fields(
            Optional.of(
                Arrays.asList(
                    QualificationRecordRequestFieldInputObjectRequestBody
                        .builder()
                        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                        .type(QualificationRecordRequestFieldInputObjectRequestBodyType.NUMBER)
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**expirationDate:** `Optional<OffsetDateTime>` — Expiration date. UTC timestamp in RFC 3339 format.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<QualificationRecordRequestFieldInputObjectRequestBody>>` — Other custom fields in a qualification record.
    
</dd>
</dl>

<dl>
<dd>

**issueDate:** `OffsetDateTime` — Issue/effective date. UTC timestamp in RFC 3339 format.
    
</dd>
</dl>

<dl>
<dd>

**owner:** `QualificationOwnerRequestObjectRequestBody` 
    
</dd>
</dl>

<dl>
<dd>

**qualificationType:** `QualificationTypeRequestObjectRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.deleteQualificationRecord(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes an existing qualification record.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Qualification Records** under the Qualification Records category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().deleteQualificationRecord(
    QualificationsDeleteQualificationRecordRequestBody
        .builder()
        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the qualification record to delete.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.patchQualificationRecord(request) -> QualificationsPatchQualificationRecordResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an existing qualification record.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Qualification Records** under the Qualification Records category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().patchQualificationRecord(
    QualificationsPatchQualificationRecordRequestBody
        .builder()
        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
        .issueDate(OffsetDateTime.parse("2025-08-27T10:20:30Z"))
        .owner(
            QualificationOwnerRequestObjectRequestBody
                .builder()
                .entityType(QualificationOwnerRequestObjectRequestBodyEntityType.WORKER)
                .id("281474")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**expirationDate:** `Optional<OffsetDateTime>` — Expiration date. UTC timestamp in RFC 3339 format. Set to '1970-01-01T00:00:00Z' to clear existing expiration date.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<QualificationRecordRequestFieldInputObjectRequestBody>>` — Other custom fields in a qualification record. Only set fields that needs to be updated.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — ID of the qualification record to update.
    
</dd>
</dl>

<dl>
<dd>

**issueDate:** `Optional<OffsetDateTime>` — Issue/effective date. UTC timestamp in RFC 3339 format.
    
</dd>
</dl>

<dl>
<dd>

**owner:** `Optional<QualificationOwnerRequestObjectRequestBody>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.archiveQualificationRecord(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Archives an existing qualification record.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Qualification Records** under the Qualification Records category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().archiveQualificationRecord(
    QualificationsArchiveQualificationRecordRequestBody
        .builder()
        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the qualification record to archive.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getQualificationRecordsStream() -> QualificationsGetQualificationRecordsStreamResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all qualification records that have been created or modified for your organization based on the time parameters passed in. Results are paginated and are sorted by last modified date. If you include an endTime, the endpoint will return data up until that point (exclusive). If you don't include an endTime, the API will continue to poll with the pagination cursor that gets returned on every call. The hasNextPage response value will be true if there is no endTime specified and endCursor is nonempty.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Qualification Records** under the Qualification Records category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getQualificationRecordsStream(
    GetQualificationRecordsStreamRequest
        .builder()
        .entityType(GetQualificationRecordsStreamRequestEntityType.WORKER)
        .startTime(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityType:** `GetQualificationRecordsStreamRequestEntityType` — String of entity type.  Valid values: `worker`, `asset`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `OffsetDateTime` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. Examples: '2019-06-13T19:08:25Z' (basic UTC), '2019-06-13T19:08:25.455Z' (with milliseconds), '2015-09-15T14:00:12-04:00' (with timezone).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — An end time in RFC 3339 format. Optional and defaults to now if not provided. Millisecond precision and timezones are supported. Examples: '2019-06-13T19:08:25Z' (basic UTC), '2019-06-13T19:08:25.455Z' (with milliseconds), '2015-09-15T14:00:12-04:00' (with timezone).
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**qualificationTypeIds:** `Optional<String>` — Optional comma-separated list containing up to 100 qualification type IDs to filter on.
    
</dd>
</dl>

<dl>
<dd>

**ownerIds:** `Optional<String>` — Optional comma-separated list of unique Samsara IDs of workers (if "entityType" is "worker") or assets (if "entityType" is "asset") to filter on. Max value for this field is 100 objects.
    
</dd>
</dl>

<dl>
<dd>

**includeDeleted:** `Optional<Boolean>` — If true, deleted qualification records are returned.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — If true, externalIds for qualification record and for the owner entity are returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.unarchiveQualificationRecord(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Unarchives an existing qualification record.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Qualification Records** under the Qualification Records category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().unarchiveQualificationRecord(
    QualificationsUnarchiveQualificationRecordRequestBody
        .builder()
        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the qualification record to unarchive.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getQualificationTypes() -> QualificationsGetQualificationTypesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of qualification types for the specified list of IDs. If no IDs are provided, all qualification types will be returned.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Qualification Records** under the Qualification Records category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getQualificationTypes(
    GetQualificationTypesRequest
        .builder()
        .entityType(GetQualificationTypesRequestEntityType.WORKER)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityType:** `GetQualificationTypesRequestEntityType` — String of entity type.  Valid values: `worker`, `asset`
    
</dd>
</dl>

<dl>
<dd>

**ids:** `Optional<String>` — Optional comma-separated list containing up to 100 qualification type IDs to filter on. If no IDs are provided, all qualification types will be returned.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.postReadings(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Ingest new readings. This endpoint allows the ingestion of batches of readings.

Ingesting readings is only supported for assets created using the POST /assets API endpoint with readingsIngestionEnabled set to true. To see a full list of readings available for ingestion use the GET readings definitions API. When ingesting location data, the readingID 'location' must be used and the value object must contain at least the following fields: 'speed', 'latitude', 'longitude'.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Readings** under the Closed Beta category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().postReadings(
    ReadingsPostReadingsRequestBody
        .builder()
        .data(
            Arrays.asList(
                ReadingDatapointRequestBody
                    .builder()
                    .entityId("123451234512345")
                    .entityType(ReadingDatapointRequestBodyEntityType.ASSET)
                    .happenedAtTime("2023-10-27T10:00:00Z")
                    .readingId("airInletPressure")
                    .value(
                        new HashMap<String, Object>() {{
                            put("key", "value");
                        }}
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**data:** `List<ReadingDatapointRequestBody>` — An array of readings data points to create.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.listReadingsDefinitions() -> ReadingsListReadingsDefinitionsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

An introspection endpoint for discovering the set of readings including their name, description, data type, unit, and other metadata.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Readings** under the Closed Beta category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().listReadingsDefinitions(
    ListReadingsDefinitionsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**ids:** `Optional<String>` — A String of comma separated reading IDs. Include up to 50 readings IDs. If not set, all readings are returned.
    
</dd>
</dl>

<dl>
<dd>

**entityTypes:** `Optional<String>` — A list of entity type to return readings for. (Examples: asset, sensor)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getReadingsHistory() -> ReadingsGetReadingsHistoryResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the values of a reading for a set of entities within the specified time range. Returns a paginated response with data for the specified resource IDs where startTime <= happenedAtTime < endTime. End time of null implies endTime is infinite and all known readings are returned.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Readings** under the Closed Beta category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getReadingsHistory(
    GetReadingsHistoryRequest
        .builder()
        .readingId("readingId")
        .entityType("entityType")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**readingId:** `String` — The reading ID to retrieve data for. Use /readings/definitions endpoint to get a list of valid reading IDs. (Examples: engineRpm,fuelLevel)
    
</dd>
</dl>

<dl>
<dd>

**entityIds:** `Optional<String>` — A filter on the data based on this comma-separated list of entity IDs or external IDs. If not set, all entities are returned.
    
</dd>
</dl>

<dl>
<dd>

**entityType:** `String` — A entity type of the entityIds or externalIds to fetch readings for. Use /readings/definitions endpoint to get a list of valid entity types. (Examples: asset, sensor)
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<String>` — A filter on the data based on this comma-separated list of external IDs. (Examples: samsara.serial:ZPXKLMN7VJ, samsara.serial:ABXKIMN4NM)
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` — A filter on the data that returns the last known data points with timestamps greater than or equal to this value. Must be a string in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2020-01-27T07:06:25Z)
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — A filter on the data that returns the last known data points with timestamps less than or equal to this value. If not set, the time of the request is considered the endTime. Must be a string in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2020-01-27T07:06:25Z)
    
</dd>
</dl>

<dl>
<dd>

**feed:** `Optional<Boolean>` — Set to true to enable feed mode for continuous reading updates. When enabled, the API always includes an endCursor in the response. If hasNextPage is false, it indicates that no new data is currently available — wait at least 5 seconds before making the next request to avoid unnecessary polling.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getReadingsSnapshot() -> ReadingsGetReadingsSnapshotResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

An endpoint to get the last value of a reading for a set of entities at the specified time.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Readings** under the Closed Beta category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getReadingsSnapshot(
    GetReadingsSnapshotRequest
        .builder()
        .readingIds("readingIds")
        .entityType("entityType")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**readingIds:** `String` — A collection of comma separated reading IDs. Include up to 3 readings IDs. Use /readings/definitions endpoint to get a list of valid reading IDs. (Examples: engineRpm,fuelLevel)
    
</dd>
</dl>

<dl>
<dd>

**entityIds:** `Optional<String>` — A filter on the data based on this comma-separated list of entity IDs or external IDs. If not set, all entities are returned.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<String>` — A filter on the data based on this comma-separated list of external IDs. (Examples: samsara.serial:ZPXKLMN7VJ, samsara.serial:ABXKIMN4NM)
    
</dd>
</dl>

<dl>
<dd>

**asOfTime:** `Optional<String>` — A filter on the data that returns the last known data points with timestamps less than or equal to this value. Defaults to now if not provided. Must be a string in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2020-01-27T07:06:25Z)
    
</dd>
</dl>

<dl>
<dd>

**entityType:** `String` — A entity type of the entityIds or externalIds to fetch readings for. Use /readings/definitions endpoint to get a list of valid entity types. (Examples: asset, sensor)
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getReportConfigs() -> ReportsGetReportConfigsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get report configs created in the organization.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Custom Reports** under the Custom Reports category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getReportConfigs(
    GetReportConfigsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of configs to return
    
</dd>
</dl>

<dl>
<dd>

**ids:** `Optional<String>` — The list of report config IDs to retrieve. Include up to 10 report config IDs. If not provided, all configs will be returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getDatasets() -> ReportsGetDatasetsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get datasets for custom reports.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Custom Reports** under the Custom Reports category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getDatasets(
    GetDatasetsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — The list of dataset IDs to retrieve the datasets for. Include up to 10 dataset IDs. If not provided, all datasets will be returned.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of datasets to return.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getReportRuns() -> ReportsGetReportRunsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get custom report runs created by the user.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Custom Reports** under the Custom Reports category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getReportRuns(
    GetReportRunsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**reportConfigIds:** `Optional<String>` — The list of report config IDs to retrieve the report runs for. Include up to 10 report config IDs. If not provided, runs for all configs will be returned.
    
</dd>
</dl>

<dl>
<dd>

**ids:** `Optional<String>` — The list of report run IDs to retrieve the report runs for. Include up to 10 report run IDs. If not provided, all report runs will be returned.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of runs to return.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.createReportRun(request) -> ReportsCreateReportRunResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Triggers a new custom report run based on the provided configuration.

 <b>Rate limit:</b> 50 requests/hour (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Custom Reports** under the Custom Reports category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().createReportRun(
    ReportsCreateReportRunRequestBody
        .builder()
        .reportConfig(
            CreateReportConfigObjectRequestBody
                .builder()
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**reportConfig:** `CreateReportConfigObjectRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getReportRunData() -> ReportsGetReportRunDataResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get data for the given custom report run.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Custom Reports** under the Custom Reports category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getReportRunData(
    GetReportRunDataRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the report run.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of rows to return.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getDriverSafetyScores() -> SafetyScoresGetDriverSafetyScoresResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get safety scores and overall risk factors for drivers.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getDriverSafetyScores(
    GetDriverSafetyScoresRequest
        .builder()
        .endTime("endTime")
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endTime:** `String` — End time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end before this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — Start time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end after this timestamp. Can be up to 1 year before endTime.
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — Comma separated list of driver IDs to filter by. Include up to 100 IDs. Defaults to all drivers.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getDriverSafetyScoreTrips() -> SafetyScoresGetDriverSafetyScoreTripsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get trips contributing to a driver's safety score, and risk factors in each trip.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getDriverSafetyScoreTrips(
    GetDriverSafetyScoreTripsRequest
        .builder()
        .endTime("endTime")
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endTime:** `String` — End time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end before this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — Start time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end after this timestamp. Can be up to 1 year before endTime.
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — Comma separated list of driver IDs to fetch trip breakdowns for. Include up to 100 drivers.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getTagGroupSafetyScores() -> SafetyScoresGetTagGroupSafetyScoresResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a combined safety score and risk factors for a set of tags.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getTagGroupSafetyScores(
    GetTagGroupSafetyScoresRequest
        .builder()
        .endTime("endTime")
        .startTime("startTime")
        .scoreType(GetTagGroupSafetyScoresRequestScoreType.DRIVER)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endTime:** `String` — End time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end before this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — Start time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end after this timestamp. Can be up to 1 year before endTime.
    
</dd>
</dl>

<dl>
<dd>

**scoreType:** `GetTagGroupSafetyScoresRequestScoreType` — Whether to calculate tag score with either all drivers or all vehicles in the tag. Deactivated drivers and unassigned trips are not included when calculating scores for drivers.   Valid values: `driver`, `vehicle`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — Comma separated list of tag IDs to filter by. Include up to 100 IDs. Defaults to all tags.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getTagSafetyScores() -> SafetyScoresGetTagSafetyScoresResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get safety scores and overall risk factors for tags.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getTagSafetyScores(
    GetTagSafetyScoresRequest
        .builder()
        .endTime("endTime")
        .startTime("startTime")
        .scoreType(GetTagSafetyScoresRequestScoreType.DRIVER)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endTime:** `String` — End time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end before this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — Start time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end after this timestamp. Can be up to 1 year before endTime.
    
</dd>
</dl>

<dl>
<dd>

**scoreType:** `GetTagSafetyScoresRequestScoreType` — Whether to calculate tag score with either all drivers or all vehicles in the tag. Deactivated drivers and unassigned trips are not included when calculating scores for drivers.   Valid values: `driver`, `vehicle`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — Comma separated list of tag IDs to filter by. Include up to 100 IDs. Defaults to all tags.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getVehicleSafetyScores() -> SafetyScoresGetVehicleSafetyScoresResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get safety scores and overall risk factors for vehicles.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getVehicleSafetyScores(
    GetVehicleSafetyScoresRequest
        .builder()
        .endTime("endTime")
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endTime:** `String` — End time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end before this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — Start time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end after this timestamp. Can be up to 1 year before endTime.
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — Comma separated list of vehicle IDs to filter by. Include up to 100 IDs. Defaults to all vehicles.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getVehicleSafetyScoreTrips() -> SafetyScoresGetVehicleSafetyScoreTripsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get trips contributing to a vehicle's safety score, and risk factors in each trip.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getVehicleSafetyScoreTrips(
    GetVehicleSafetyScoreTripsRequest
        .builder()
        .endTime("endTime")
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endTime:** `String` — End time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end before this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — Start time in RFC 3339 format. Millisecond precision and timezones are supported. Includes trips that end after this timestamp. Can be up to 1 year before endTime.
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — Comma separated list of vehicle IDs to fetch trip breakdowns for. Include up to 100 vehicles.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.postTrainingAssignments() -> TrainingAssignmentsPostTrainingAssignmentsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create training assignments. Existing assignments will remain unchanged. 

**Beta:** This endpoint is in beta and is likely to change before being broadly available. Reach out to your Samsara Representative to have Training APIs enabled for your organization.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Training Assignments** under the Training Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().postTrainingAssignments(
    PostTrainingAssignmentsRequest
        .builder()
        .courseId("courseId")
        .dueAtTime("dueAtTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**courseId:** `String` — String for the course ID.
    
</dd>
</dl>

<dl>
<dd>

**dueAtTime:** `String` — Due date of the training assignment in RFC 3339 format. Millisecond precision and timezones are supported.
    
</dd>
</dl>

<dl>
<dd>

**learnerIds:** `Optional<String>` — Optional string of comma separated learner IDs. If learner ID is present, training assignments for the specified learner(s) will be returned. Max value for this value is 100 objects. Example: `learnerIds=driver-281474,driver-46282156`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.deleteTrainingAssignments()</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint supports batch deletion operations. The response does not indicate which specific deletions, if any, have failed. On a successful deletion or partial failure, a ‘204 No Content’ status is returned. 

**Beta:** This endpoint is in beta and is likely to change before being broadly available. Reach out to your Samsara Representative to have Training APIs enabled for your organization.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Training Assignments** under the Training Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().deleteTrainingAssignments(
    DeleteTrainingAssignmentsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — String of comma separated assignments IDs. Max value for this value is 100 objects. Example: `ids=a4db8702-79d5-4396-a717-e301d52ecc11,c6490f6a-d84e-49b5-b0ad-b6baae304075`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.patchTrainingAssignments() -> TrainingAssignmentsPatchTrainingAssignmentsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update training assignments. 

**Beta:** This endpoint is in beta and is likely to change before being broadly available. Reach out to your Samsara Representative to have Training APIs enabled for your organization.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Training Assignments** under the Training Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().patchTrainingAssignments(
    PatchTrainingAssignmentsRequest
        .builder()
        .dueAtTime("dueAtTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — String of comma separated assignments IDs. Max value for this value is 100 objects. Example: `ids=a4db8702-79d5-4396-a717-e301d52ecc11,c6490f6a-d84e-49b5-b0ad-b6baae304075`
    
</dd>
</dl>

<dl>
<dd>

**dueAtTime:** `String` — Due date of the training assignment in RFC 3339 format. Millisecond precision and timezones are supported.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getTrainingAssignmentsStream() -> TrainingAssignmentsGetTrainingAssignmentsStreamResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all training assignments data that has been created or modified for your organization based on the time parameters passed in. Results are paginated and are sorted by last modified date. If you include an endTime, the endpoint will return data up until that point (exclusive). If you don't include an endTime, the API will continue to poll with the pagination cursor that gets returned on every call. The hasNextPage response value will be true if there is no endTime specified and endCursor is nonempty.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Training Assignments** under the Training Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getTrainingAssignmentsStream(
    GetTrainingAssignmentsStreamRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**learnerIds:** `Optional<String>` — Optional string of comma separated learner IDs. If learner ID is present, training assignments for the specified learner(s) will be returned. Max value for this value is 100 objects. Example: `learnerIds=driver-281474,driver-46282156`
    
</dd>
</dl>

<dl>
<dd>

**courseIds:** `Optional<String>` — Optional string of comma separated course IDs. If course ID is present, training assignments for the specified course ID(s) will be returned. Max value for this value is 100 objects. Defaults to returning all courses. Example: `courseIds=a4db8702-79d5-4396-a717-e301d52ecc11,c6490f6a-d84e-49b5-b0ad-b6baae304075`
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<String>` — Optional string of comma separated values. If status is present, training assignments for the specified status(s) will be returned. Valid values: "notStarted", "inProgress", "completed". Defaults to returning all courses.
    
</dd>
</dl>

<dl>
<dd>

**isOverdue:** `Optional<Boolean>` — Optional boolean value. If present, training assignments for the specified overdue status will be returned. Valid values: true, false. Defaults to returning all assignments.
    
</dd>
</dl>

<dl>
<dd>

**categoryIds:** `Optional<String>` — Optional string of comma separated category IDs. If category ID is present, training assignments for the specified category ID(s) will be returned. Max value for this value is 100 objects. Example: `categoryIds=a4db8702-79d5-4396-a717-e301d52ecc11,c6490f6a-d84e-49b5-b0ad-b6baae304075`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.betaApIs.getTrainingCourses() -> TrainingCoursesGetTrainingCoursesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all training courses data. Results are paginated. 
 Courses in the ‘draft’ status are excluded from the data returned by this endpoint.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Training Courses** under the Training Courses category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.betaApIs().getTrainingCourses(
    GetTrainingCoursesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**courseIds:** `Optional<String>` — Optional string of comma separated course IDs. If course ID is present, training assignments for the specified course ID(s) will be returned. Max value for this value is 100 objects. Defaults to returning all courses. Example: `courseIds=a4db8702-79d5-4396-a717-e301d52ecc11,c6490f6a-d84e-49b5-b0ad-b6baae304075`
    
</dd>
</dl>

<dl>
<dd>

**categoryIds:** `Optional<String>` — Optional string of comma separated course category IDs. If courseCategoryId is present, training courses for the specified course category(s) will be returned. Max value for this value is 100 objects. Defaults to returning all courses.  Example: `categoryIds=a4db8702-79d5-4396-a717-e301d52ecc11,c6490f6a-d84e-49b5-b0ad-b6baae304075`
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<String>` — Optional string of comma separated values. If status is present, training courses with the specified status(s) will be returned. Valid values: “published”, “deleted”, “archived”. Defaults to returning all courses.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## LocationAndSpeed
<details><summary><code>client.locationAndSpeed.getLocationAndSpeed() -> LocationAndSpeedGetLocationAndSpeedResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return asset locations and speed data that has been collected for your organization based on the time parameters passed in. Results are paginated. If you include an endTime, the endpoint will return data up until that point. If you don’t include an endTime, you can continue to poll the API real-time with the pagination cursor that gets returned on every call. The endpoint will only return data up until the endTime that has been processed by the server at the time of the original request. You will need to request the same [startTime, endTime) range again to receive data for assets processed after the original request time. This endpoint sorts the time-series data by device.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Vehicles** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.locationAndSpeed().getLocationAndSpeed(
    GetLocationAndSpeedRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Defaults to never if not provided; if not provided then pagination will not cease, and a valid pagination cursor will always be returned. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**ids:** `Optional<String>` — Comma-separated list of asset IDs.
    
</dd>
</dl>

<dl>
<dd>

**includeSpeed:** `Optional<Boolean>` — Optional boolean indicating whether or not to return the 'speed' object
    
</dd>
</dl>

<dl>
<dd>

**includeReverseGeo:** `Optional<Boolean>` — Optional boolean indicating whether or not to return the 'address' object. Address information won't be returned for high-frequency locations.
    
</dd>
</dl>

<dl>
<dd>

**includeGeofenceLookup:** `Optional<Boolean>` — Optional boolean indicating whether or not to return the 'geofence' object
    
</dd>
</dl>

<dl>
<dd>

**includeHighFrequencyLocations:** `Optional<Boolean>` — Optional boolean indicating whether or not to return high-frequency location data (up to 1Hz). Cannot be used with includeGeofenceLookup.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Attributes
<details><summary><code>client.attributes.getAttributesByEntityType() -> GetAttributesByEntityTypeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch all attributes in an organization associated with either drivers or assets. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Attributes** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.attributes().getAttributesByEntityType(
    GetAttributesByEntityTypeRequest
        .builder()
        .entityType(GetAttributesByEntityTypeRequestEntityType.DRIVER)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityType:** `GetAttributesByEntityTypeRequestEntityType` — Denotes the type of entity, driver or asset.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.attributes.createAttribute(request) -> AttributeExpandedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new attribute in the organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Attributes** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.attributes().createAttribute(
    CreateAttributeRequest
        .builder()
        .attributeType(CreateAttributeRequestAttributeType.SINGLE_SELECT)
        .entityType(CreateAttributeRequestEntityType.DRIVER)
        .name("License Certifications")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**attributeType:** `CreateAttributeRequestAttributeType` — Denotes the data type of the attribute's values. Valid values: `single-select`, `multi-select`, `text`, `freeform-multi-select`, `number`, `date`.
    
</dd>
</dl>

<dl>
<dd>

**entities:** `Optional<List<CreateAttributeRequestEntities>>` — Entities that will be applied to this attribute
    
</dd>
</dl>

<dl>
<dd>

**entityType:** `CreateAttributeRequestEntityType` — Denotes the type of entity, driver or asset.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Name
    
</dd>
</dl>

<dl>
<dd>

**numberValues:** `Optional<List<Double>>` — Number values that can be associated with this attribute
    
</dd>
</dl>

<dl>
<dd>

**stringValues:** `Optional<List<String>>` — String values that can be associated with this attribute
    
</dd>
</dl>

<dl>
<dd>

**unit:** `Optional<CreateAttributeRequestUnit>` — Unit of the attribute (only for Number attributes).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.attributes.getAttribute(id) -> AttributeExpandedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch an attribute by id, including all of its applications. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Attributes** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.attributes().getAttribute(
    "id",
    GetAttributeRequest
        .builder()
        .entityType(GetAttributeRequestEntityType.DRIVER)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Samsara-provided UUID of the attribute.
    
</dd>
</dl>

<dl>
<dd>

**entityType:** `GetAttributeRequestEntityType` — Denotes the type of entity, driver or asset.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.attributes.deleteAttribute(id) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete an attribute by id, including all of its applications. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Attributes** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.attributes().deleteAttribute(
    "id",
    DeleteAttributeRequest
        .builder()
        .entityType(DeleteAttributeRequestEntityType.DRIVER)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Samsara-provided UUID of the attribute.
    
</dd>
</dl>

<dl>
<dd>

**entityType:** `DeleteAttributeRequestEntityType` — Denotes the type of entity, driver or asset.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.attributes.updateAttribute(id, request) -> AttributeExpandedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an attribute in the organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Attributes** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.attributes().updateAttribute(
    "id",
    UpdateAttributeRequest
        .builder()
        .entityType(UpdateAttributeRequestEntityType.DRIVER)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Samsara-provided UUID of the attribute.
    
</dd>
</dl>

<dl>
<dd>

**attributeType:** `Optional<UpdateAttributeRequestAttributeType>` — Denotes the data type of the attribute's values. Valid values: `single-select`, `multi-select`, `text`, `freeform-multi-select`, `number`, `date`.
    
</dd>
</dl>

<dl>
<dd>

**entities:** `Optional<List<CreateAttributeRequestEntities>>` — Entities that will be applied to this attribute
    
</dd>
</dl>

<dl>
<dd>

**entityType:** `UpdateAttributeRequestEntityType` — Denotes the type of entity, driver or asset.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — Name
    
</dd>
</dl>

<dl>
<dd>

**numberValues:** `Optional<List<Double>>` — Number values that can be associated with this attribute
    
</dd>
</dl>

<dl>
<dd>

**stringValues:** `Optional<List<String>>` — String values that can be associated with this attribute
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Media
<details><summary><code>client.media.listUploadedMedia() -> MediaRetrievalListUploadedMediaResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint returns a list of all uploaded media (video and still images) matching query parameters, with a maximum query range of one day. Additional media can be retrieved with the [Create a media retrieval request](https://developers.samsara.com/reference/postmediaretrieval) endpoint, and they will be included in the list after they are uploaded. Urls provided by this endpoint expire in 8 hours.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Media Retrieval** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.media().listUploadedMedia(
    ListUploadedMediaRequest
        .builder()
        .vehicleIds("vehicleIds")
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**vehicleIds:** `String` — A filter on the data based on this comma-separated list of vehicle IDs and externalIds. You can specify up to 20 vehicles. Example: `vehicleIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**inputs:** `Optional<ListUploadedMediaRequestInputsItem>` — An optional list of desired camera inputs for which to return captured media. If empty, media for all available inputs will be returned.
    
</dd>
</dl>

<dl>
<dd>

**mediaTypes:** `Optional<ListUploadedMediaRequestMediaTypesItem>` — An optional list of desired media types for which to return captured media. If empty, media for all available media types will be returned. Possible options include: image, videoHighRes.
    
</dd>
</dl>

<dl>
<dd>

**triggerReasons:** `Optional<ListUploadedMediaRequestTriggerReasonsItem>` — An optional list of desired trigger reasons for which to return captured media. If empty, media for all available trigger reasons will be returned. Possible options include: api, panicButton, periodicStill, rfidEvent, safetyEvent, tripEndStill, tripStartStill, videoRetrieval. videoRetrieval represents media captured for a dashboard video retrieval request.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. End time cannot be more than 24 hours after startTime. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**availableAfterTime:** `Optional<String>` — An optional timestamp in RFC 3339 format that can act as a cursor to track which media has previously been retrieved; only media whose availableAtTime comes after this parameter will be returned. Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.media.getMediaRetrieval() -> MediaRetrievalGetMediaRetrievalResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint returns media information corresponding to a retrieval ID. Retrieval IDs are associated to prior [media retrieval requests](https://developers.samsara.com/reference/postmediaretrieval). Urls provided by this endpoint expire in 8 hours.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Media Retrieval** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.media().getMediaRetrieval(
    GetMediaRetrievalRequest
        .builder()
        .retrievalId("retrievalId")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**retrievalId:** `String` — Retrieval ID associated with this media capture request. Examples: 2308cec4-82e0-46f1-8b3c-a3592e5cc21e
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.media.postMediaRetrieval(request) -> MediaRetrievalPostMediaRetrievalResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint creates an asynchronous request to upload certain media from a device. The closest available media to the requested timestamp is returned. Images and high-res videos are supported; other types of media (e.g. hyperlapse, low-res) are planned to be supported in the future. Currently, only unblurred media is supported. If a device is offline, the requested media will be uploaded once it comes back online. Quota limits are enforced for media retrievals made through the API. The Create a media retrieval request response includes information about the media retrieval quota remaining for the organization. The media retrieval quota for the organization is reset at the beginning of each month.The quota is expressed using seconds of High Resolution video. 10 still images are equivalent to a 1 second of High Resolution footage.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Media Retrieval** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.media().postMediaRetrieval(
    MediaRetrievalPostMediaRetrievalRequestBody
        .builder()
        .endTime("2019-06-13T19:08:55Z")
        .mediaType(MediaRetrievalPostMediaRetrievalRequestBodyMediaType.IMAGE)
        .startTime("2019-06-13T19:08:25Z")
        .vehicleId("1234")
        .inputs(
            Arrays.asList(MediaRetrievalPostMediaRetrievalRequestBodyInputsItem.DASHCAM_ROAD_FACING, MediaRetrievalPostMediaRetrievalRequestBodyInputsItem.DASHCAM_ROAD_FACING, MediaRetrievalPostMediaRetrievalRequestBodyInputsItem.DASHCAM_ROAD_FACING)
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. If endTime is the same as startTime, an image will be captured at startTime. Must be 1 second or more after startTime and no more than the maximum allowed duration per video retrieval type. Please refer to our KB articles for more information. (Examples: 2019-06-13T19:08:55Z, 2019-06-13T19:08:55.455Z, OR 2015-09-15T14:00:42-04:00).
    
</dd>
</dl>

<dl>
<dd>

**inputs:** `List<MediaRetrievalPostMediaRetrievalRequestBodyInputsItem>` — A list of desired camera inputs for which to capture media. Only media with valid inputs (e.g. device has that input stream and device was recording at the time) will be uploaded. An empty list is invalid.
    
</dd>
</dl>

<dl>
<dd>

**mediaType:** `MediaRetrievalPostMediaRetrievalRequestBodyMediaType` — The desired media type. If a video is requested, endTime must be after startTime. If an image is requested, endTime must be the same as startTime. Must be one of: image, videoHighRes, videoLowRes. Examples: image, videoHighRes, videoLowRes.  Valid values: `image`, `videoHighRes`, `videoLowRes`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `String` — Vehicle ID for which to initiate media capture. Examples: 1234
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Coaching
<details><summary><code>client.coaching.getDriverCoachAssignment() -> DriverCoachAssignmentsGetDriverCoachAssignmentResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return coach assignments for your organization based on the parameters passed in. Results are paginated.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Coaching** under the Coaching category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.coaching().getDriverCoachAssignment(
    GetDriverCoachAssignmentRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverIds:** `Optional<String>` — Optional string of comma separated IDs of the drivers. This can be either a unique Samsara driver ID or an external ID for the driver.
    
</dd>
</dl>

<dl>
<dd>

**coachIds:** `Optional<String>` — Optional string of comma separated IDs of the coaches.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.coaching.putDriverCoachAssignment() -> DriverCoachAssignmentsPutDriverCoachAssignmentResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will update an existing or create a new coach-to-driver assignment for your organization based on the parameters passed in. This endpoint should only be used for existing Coach to Driver assignments. In order to remove a driver-coach-assignment for a given driver, set coachId to null

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Coaching** under the Coaching category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.coaching().putDriverCoachAssignment(
    PutDriverCoachAssignmentRequest
        .builder()
        .driverId("driverId")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverId:** `String` — Required string ID of the driver. This is a unique Samsara ID of a driver.
    
</dd>
</dl>

<dl>
<dd>

**coachId:** `Optional<String>` — Optional string ID of the coach. This is a unique Samsara user ID. If not provided, existing coach assignment will be removed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.coaching.getCoachingSessions() -> CoachingSessionsGetCoachingSessionsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return coaching sessions for your organization based on the time parameters passed in. Results are paginated by sessions. If you include an endTime, the endpoint will return data up until that point. If you don’t include an endTime, you can continue to poll the API real-time with the pagination cursor that gets returned on every call.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Coaching** under the Coaching category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.coaching().getCoachingSessions(
    GetCoachingSessionsRequest
        .builder()
        .startTime(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverIds:** `Optional<String>` — Optional string of comma separated driver IDs. If driver ID is present, sessions for the specified driver(s) will be returned.
    
</dd>
</dl>

<dl>
<dd>

**coachIds:** `Optional<String>` — Optional string of comma separated user IDs. If coach ID is present, sessions for the specified coach(s) will be returned for either assignedCoach or completedCoach. If both driverId(s) and coachId(s) are present, sessions with specified driver(s) and coach(es) will be returned.
    
</dd>
</dl>

<dl>
<dd>

**sessionStatuses:** `Optional<String>` — Optional string of comma separated statuses. Valid values:  “upcoming”, “completed”, “deleted”.
    
</dd>
</dl>

<dl>
<dd>

**includeCoachableEvents:** `Optional<Boolean>` — Optional boolean to control whether behaviors will include coachableEvents in the response. Defaults to false.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `OffsetDateTime` — Required RFC 3339 timestamp that indicates when to begin receiving data. Value is compared against `updatedAtTime`
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — Optional RFC 3339 timestamp. If not provided then the endpoint behaves as an unending feed of changes. If endTime is set the same as startTime, the most recent data point before that time will be returned per asset. Value is compared against `updatedAtTime`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Contacts
<details><summary><code>client.contacts.listContacts() -> ListContactsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of all contacts in an organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Alert Contacts** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.contacts().listContacts(
    ListContactsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.createContact(request) -> ContactResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Add a contact to the organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Alert Contacts** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.contacts().createContact(
    CreateContactRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**email:** `Optional<String>` — Email address of the contact.
    
</dd>
</dl>

<dl>
<dd>

**firstName:** `Optional<String>` — First name of the contact.
    
</dd>
</dl>

<dl>
<dd>

**lastName:** `Optional<String>` — Last name of the contact.
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` — Phone number of the contact.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.getContact(id) -> ContactResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a specific contact's information. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Alert Contacts** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.contacts().getContact(
    "id",
    GetContactRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the contact.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.deleteContact(id) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete the given contact. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Alert Contacts** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.contacts().deleteContact(
    "id",
    DeleteContactRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the contact.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.updateContact(id, request) -> ContactResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a specific contact's information. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Alert Contacts** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.contacts().updateContact(
    "id",
    UpdateContactRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the contact.
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` — Email address of the contact.
    
</dd>
</dl>

<dl>
<dd>

**firstName:** `Optional<String>` — First name of the contact.
    
</dd>
</dl>

<dl>
<dd>

**lastName:** `Optional<String>` — Last name of the contact.
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` — Phone number of the contact.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Maintenance
<details><summary><code>client.maintenance.getDefectTypes() -> DvirDefectTypeGetDefectTypesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get DVIR defect types.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Defect Types** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.maintenance().getDefectTypes(
    GetDefectTypesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**ids:** `Optional<String>` — A filter on the data based on this comma-separated list of defect type IDs.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.maintenance.streamDefects() -> DvirDefectStreamDefectsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Stream DVIR defects.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Defects** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.maintenance().streamDefects(
    StreamDefectsRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 200 objects.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — Required RFC 3339 timestamp to begin the feed or history by `updatedAtTime` at `startTime`.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — Optional RFC 3339 timestamp. If not provided then the endpoint behaves as an unending feed of changes.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>

<dl>
<dd>

**isResolved:** `Optional<Boolean>` — Boolean value for whether filter defects by resolved status.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.maintenance.getDefect(id) -> DvirDefectGetDefectResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a single DVIR defect by ID.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Defects** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.maintenance().getDefect(
    "id",
    GetDefectRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The unique ID of the DVIR defect.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.maintenance.getDvirs() -> DvirGetDvirsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a history/feed of changed DVIRs by updatedAtTime between startTime and endTime parameters. In case of missing `endTime` parameter it will return a never ending stream of data.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read DVIRs** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.maintenance().getDvirs(
    GetDvirsRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 200 objects.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — Required RFC 3339 timestamp to begin the feed or history by `updatedAtTime` at `startTime`.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — Optional RFC 3339 timestamp. If not provided then the endpoint behaves as an unending feed of changes.
    
</dd>
</dl>

<dl>
<dd>

**safetyStatus:** `Optional<String>` — Optional list of safety statuses. Valid values: [safe, unsafe, resolved]
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.maintenance.getDvir(id) -> DvirGetDvirResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a single DVIR by ID.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read DVIRs** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.maintenance().getDvir(
    "id",
    GetDvirRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Id of the DVIR.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.maintenance.updateDvirDefect(id, request) -> DefectResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a given defect. Can be used to resolve a defect by marking its `isResolved` field to `true`. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Defects** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.maintenance().updateDvirDefect(
    "id",
    DefectPatch
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the defect.
    
</dd>
</dl>

<dl>
<dd>

**isResolved:** `Optional<Boolean>` — Resolves the defect. Must be `true`.
    
</dd>
</dl>

<dl>
<dd>

**mechanicNotes:** `Optional<String>` — The mechanics notes on the defect.
    
</dd>
</dl>

<dl>
<dd>

**resolvedAtTime:** `Optional<String>` — Time when defect was resolved. Defaults to now if not provided. UTC timestamp in RFC 3339 format. Example: `2020-01-27T07:06:25Z`.
    
</dd>
</dl>

<dl>
<dd>

**resolvedBy:** `Optional<ResolvedBy>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.maintenance.createDvir(request) -> DvirResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new mechanic DVIR in the organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write DVIRs** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.maintenance().createDvir(
    CreateDvirRequest
        .builder()
        .authorId("11")
        .safetyStatus(CreateDvirRequestSafetyStatus.SAFE)
        .type(CreateDvirRequestType.MECHANIC)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authorId:** `String` — Samsara user ID of the mechanic creating the DVIR.
    
</dd>
</dl>

<dl>
<dd>

**licensePlate:** `Optional<String>` — The license plate of this vehicle.
    
</dd>
</dl>

<dl>
<dd>

**location:** `Optional<String>` — Optional string if your jurisdiction requires a location of the DVIR.
    
</dd>
</dl>

<dl>
<dd>

**mechanicNotes:** `Optional<String>` — The mechanics notes on the DVIR.
    
</dd>
</dl>

<dl>
<dd>

**odometerMeters:** `Optional<Long>` — The odometer reading in meters.
    
</dd>
</dl>

<dl>
<dd>

**resolvedDefectIds:** `Optional<List<String>>` — Array of ids for defects being resolved with this DVIR.
    
</dd>
</dl>

<dl>
<dd>

**safetyStatus:** `CreateDvirRequestSafetyStatus` — Whether or not this vehicle or trailer is safe to drive.
    
</dd>
</dl>

<dl>
<dd>

**trailerId:** `Optional<String>` — Id of trailer being inspected. Either vehicleId or trailerId must be provided.
    
</dd>
</dl>

<dl>
<dd>

**type:** `CreateDvirRequestType` — Only type 'mechanic' is currently accepted.
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `Optional<String>` — Id of vehicle being inspected. Either vehicleId or trailerId must be provided.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.maintenance.updateDvir(id, request) -> DvirResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Resolves a given DVIR by marking its `isResolved` field to `true`. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write DVIRs** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.maintenance().updateDvir(
    "id",
    UpdateDvirRequest
        .builder()
        .authorId("11")
        .isResolved(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the DVIR.
    
</dd>
</dl>

<dl>
<dd>

**authorId:** `String` — The user who is resolving the dvir.
    
</dd>
</dl>

<dl>
<dd>

**isResolved:** `Boolean` — Resolves the DVIR. Must be `true`.
    
</dd>
</dl>

<dl>
<dd>

**mechanicNotes:** `Optional<String>` — The mechanics notes on the DVIR.
    
</dd>
</dl>

<dl>
<dd>

**signedAtTime:** `Optional<String>` — Time when user signed this DVIR. Defaults to now. UTC timestamp in RFC 3339 format. Example: `2020-01-27T07:06:25Z`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.maintenance.v1GetFleetMaintenanceList() -> InlineResponse2004</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get list of the vehicles with any engine faults or check light data. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read DVIRs** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.maintenance().v1GetFleetMaintenanceList();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## FuelAndEnergy
<details><summary><code>client.fuelAndEnergy.getDriverEfficiencyByDrivers() -> DriverEfficiencyGetDriverEfficiencyByDriversResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return driver efficiency data that has been collected for your organization and grouped by drivers based on the time parameters passed in. Results are paginated. 

**Note:** The data from this endpoint comes from the Driver Efficiency (Eco-Driving) Report. The existing [/fleet/drivers/efficiency](https://developers.samsara.com/reference/getdriverefficiency) endpoint has now been moved to Legacy.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Driver Efficiency** under the Fuel & Energy category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.fuelAndEnergy().getDriverEfficiencyByDrivers(
    GetDriverEfficiencyByDriversRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Must be in multiple of hours and at least 1 day before endTime. Timezones are supported. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. (Examples: 2019-06-11T19:00:00Z, 2015-09-12T14:00:00-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Must be in multiple of hours and no later than 3 hours before the current time. Timezones are supported. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. (Examples: 2019-06-13T19:00:00Z, 2015-09-15T14:00:00-04:00).
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver IDs and externalIds. Example: `driverIds=1234,5678,payroll:4841`
    
</dd>
</dl>

<dl>
<dd>

**dataFormats:** `Optional<String>` — A comma-separated list of data formats you want to fetch. Valid values: `score`, `raw` and `percentage`. The default data format is `score`. Example: `dataFormats=raw,score`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.fuelAndEnergy.getDriverEfficiencyByVehicles() -> DriverEfficiencyGetDriverEfficiencyByVehiclesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return driver efficiency data that has been collected for your organization and grouped by vehicle drivers used based on the time parameters passed in. Results are paginated. 

**Note:** The data from this endpoint comes from the Driver Efficiency (Eco-Driving) Report. The existing [/fleet/drivers/efficiency](https://developers.samsara.com/reference/getdriverefficiency) endpoint has now been moved to Legacy.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Driver Efficiency** under the Fuel & Energy category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.fuelAndEnergy().getDriverEfficiencyByVehicles(
    GetDriverEfficiencyByVehiclesRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Must be in multiple of hours and at least 1 day before endTime. Timezones are supported. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. (Examples: 2019-06-11T19:00:00Z, 2015-09-12T14:00:00-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Must be in multiple of hours and no later than 3 hours before the current time. Timezones are supported. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. (Examples: 2019-06-13T19:00:00Z, 2015-09-15T14:00:00-04:00).
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of vehicle IDs and externalIds. Example: `vehicleIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**dataFormats:** `Optional<String>` — A comma-separated list of data formats you want to fetch. Valid values: `score`, `raw` and `percentage`. The default data format is `score`. Example: `dataFormats=raw,score`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.fuelAndEnergy.getFuelEnergyDriverReports() -> FuelEnergyGetFuelEnergyDriverReportsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get fuel and energy efficiency driver reports for the requested time range.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Fuel & Energy** under the Fuel & Energy category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.fuelAndEnergy().getFuelEnergyDriverReports(
    GetFuelEnergyDriverReportsRequest
        .builder()
        .startDate("startDate")
        .endDate("endDate")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startDate:** `String` — A start date in RFC 3339 format. This parameter ignores everything (i.e. hour, minutes, seconds, nanoseconds, etc.) besides the date and timezone. If no time zone is passed in, then the UTC time zone will be used. This parameter is inclusive, so data on the date specified will be considered. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. For example, 2022-07-13T14:20:50.52-07:00 is a time in Pacific Daylight Time.
    
</dd>
</dl>

<dl>
<dd>

**endDate:** `String` — An end date in RFC 3339 format. This parameter ignores everything (i.e. hour, minutes, seconds, nanoseconds, etc.) besides the date and timezone. If no time zone is passed in, then the UTC time zone will be used. This parameter is inclusive, so data on the date specified will be considered. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. For example, 2022-07-13T14:20:50.52-07:00 is a time in Pacific Daylight Time.
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver IDs and externalIds. Example: `driverIds=1234,5678,payroll:4841`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.fuelAndEnergy.getFuelEnergyVehicleReports() -> FuelEnergyGetFuelEnergyVehicleReportsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get fuel and energy efficiency vehicle reports for the requested time range.

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Fuel & Energy** under the Fuel & Energy category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.fuelAndEnergy().getFuelEnergyVehicleReports(
    GetFuelEnergyVehicleReportsRequest
        .builder()
        .startDate("startDate")
        .endDate("endDate")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startDate:** `String` — A start date in RFC 3339 format. This parameter ignores everything (i.e. hour, minutes, seconds, nanoseconds, etc.) besides the date and timezone. If no time zone is passed in, then the UTC time zone will be used. This parameter is inclusive, so data on the date specified will be considered. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. For example, 2022-07-13T14:20:50.52-07:00 is a time in Pacific Daylight Time.
    
</dd>
</dl>

<dl>
<dd>

**endDate:** `String` — An end date in RFC 3339 format. This parameter ignores everything (i.e. hour, minutes, seconds, nanoseconds, etc.) besides the date and timezone. If no time zone is passed in, then the UTC time zone will be used. This parameter is inclusive, so data on the date specified will be considered. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. For example, 2022-07-13T14:20:50.52-07:00 is a time in Pacific Daylight Time.
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of vehicle IDs and externalIds. Example: `vehicleIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**energyType:** `Optional<GetFuelEnergyVehicleReportsRequestEnergyType>` — The type of energy used by the vehicle.  Valid values: `fuel`, `hybrid`, `electric`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.fuelAndEnergy.postFuelPurchase(request) -> FuelPurchasePostFuelPurchaseResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a fuel purchase transaction.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Fuel Purchase** under the Fuel & Energy category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.fuelAndEnergy().postFuelPurchase(
    FuelPurchasePostFuelPurchaseRequestBody
        .builder()
        .fuelQuantityLiters("676.8")
        .transactionLocation("350 Rhode Island St, San Francisco, CA 94103")
        .transactionPrice(
            PostFuelPurchaseRequestBodyPriceRequestBody
                .builder()
                .amount("640.2")
                .currency(PostFuelPurchaseRequestBodyPriceRequestBodyCurrency.USD)
                .build()
        )
        .transactionReference("5454534")
        .transactionTime("2022-07-13T14:20:50.52-07:00")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**discount:** `Optional<PostFuelPurchaseRequestBodyDiscountRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**driverId:** `Optional<String>` — Samsara ID of the driver that purchased the fuel.
    
</dd>
</dl>

<dl>
<dd>

**fuelGrade:** `Optional<FuelPurchasePostFuelPurchaseRequestBodyFuelGrade>` — The grade of the fuel purchased.  Valid values: `Unknown`, `Regular`, `Premium`
    
</dd>
</dl>

<dl>
<dd>

**fuelQuantityLiters:** `String` — The amount of fuel purchased in liters.
    
</dd>
</dl>

<dl>
<dd>

**iftaFuelType:** `Optional<FuelPurchasePostFuelPurchaseRequestBodyIftaFuelType>` — The type of fuel purchased supported by IFTA.  Valid values: `Unspecified`, `A55`, `Biodiesel`, `CompressedNaturalGas`, `Diesel`, `E85`, `Electricity`, `Ethanol`, `Gasohol`, `Gasoline`, `Hydrogen`, `LiquifiedNaturalGas`, `M85`, `Methanol`, `Propane`, `Other`
    
</dd>
</dl>

<dl>
<dd>

**merchantName:** `Optional<String>` — Brand name of the fuel station the fuel was purchased at. For example: Shell, Bp, Exxon.
    
</dd>
</dl>

<dl>
<dd>

**source:** `Optional<String>` — The integration provider. For example: Customer, Shell Integration
    
</dd>
</dl>

<dl>
<dd>

**transactionLocation:** `String` — The full street address for the location of the fuel transaction, as it might be recognized by Google Maps. Ideal entries should be in accordance with the format used by the national postal service of the country concerned (example: 1 De Haro St, San Francisco, CA 94107, United States). Alternatively, exact latitude/longitude can be provided (example: 40.748441, -73.985664).
    
</dd>
</dl>

<dl>
<dd>

**transactionPrice:** `PostFuelPurchaseRequestBodyPriceRequestBody` 
    
</dd>
</dl>

<dl>
<dd>

**transactionReference:** `String` — The fuel transaction reference. This is the transaction identifier. For instance, this can be the Serial Number on the invoice.
    
</dd>
</dl>

<dl>
<dd>

**transactionTime:** `String` — The time of the fuel transaction in RFC 3339 format. Timezone must be specified. For example, 2022-07-13T14:20:50.52-07:00 is a time in Pacific Daylight Time.
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `Optional<String>` — Samsara ID of the vehicle that purchased the fuel.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## DriverTrailerAssignments
<details><summary><code>client.driverTrailerAssignments.getDriverTrailerAssignments() -> TrailerAssignmentsGetDriverTrailerAssignmentsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get currently active driver-trailer assignments for driver.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverTrailerAssignments().getDriverTrailerAssignments(
    GetDriverTrailerAssignmentsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver IDs and externalIds. Example: `driverIds=1234,5678,payroll:4841`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.driverTrailerAssignments.createDriverTrailerAssignment(request) -> TrailerAssignmentsCreateDriverTrailerAssignmentResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new driver-trailer assignment

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverTrailerAssignments().createDriverTrailerAssignment(
    TrailerAssignmentsCreateDriverTrailerAssignmentRequestBody
        .builder()
        .driverId("494123")
        .trailerId("12345")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverId:** `String` — ID of the driver. This can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the driver.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` — The start time in RFC 3339 format. The time needs to be current or within the past 7 days. Defaults to now if not provided
    
</dd>
</dl>

<dl>
<dd>

**trailerId:** `String` — ID of the trailer. This can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the trailer.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.driverTrailerAssignments.updateDriverTrailerAssignment(request) -> TrailerAssignmentsUpdateDriverTrailerAssignmentResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an existing driver-trailer assignment.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverTrailerAssignments().updateDriverTrailerAssignment(
    TrailerAssignmentsUpdateDriverTrailerAssignmentRequestBody
        .builder()
        .id("id")
        .endTime("2019-06-13T19:08:25Z")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Samsara ID for the assignment.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — The end time in RFC 3339 format. The end time should not be in the future
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## DriverQrCodes
<details><summary><code>client.driverQrCodes.getDriversQrCodes() -> DriverQrCodesGetDriversQrCodesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get details for requested driver(s) QR code, used for driver trip assignment.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Drivers** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverQrCodes().getDriversQrCodes(
    GetDriversQrCodesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverIds:** `Optional<String>` — String of comma separated driver IDs. List of driver - QR codes for specified driver(s) will be returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.driverQrCodes.createDriverQrCode(request) -> DriverQrCodesCreateDriverQrCodeResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Assign a new QR code for the requested driver. Return error if an active QR code already exists.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Drivers** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverQrCodes().createDriverQrCode(
    DriverQrCodesCreateDriverQrCodeRequestBody
        .builder()
        .driverId(494123L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverId:** `Long` — Unique ID of the driver.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.driverQrCodes.deleteDriverQrCode(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Revoke requested driver's currently active QR code.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Drivers** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverQrCodes().deleteDriverQrCode(
    DriverQrCodesDeleteDriverQrCodeRequestBody
        .builder()
        .driverId(494123L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverId:** `Long` — Unique ID of the driver.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Carrier Proposed Assignments
<details><summary><code>client.carrierProposedAssignments.listCarrierProposedAssignments() -> ListCarrierProposedAssignmentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Show the assignments created by the POST fleet/carrier-proposed-assignments. This endpoint will only show the assignments that are active for drivers and currently visible to them in the driver app. Once a proposed assignment has been accepted, the endpoint will not return any data. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Carrier-Proposed Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.carrierProposedAssignments().listCarrierProposedAssignments(
    ListCarrierProposedAssignmentsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — A filter on the data based on this comma-separated list of driver IDs and externalIds. Example: `driverIds=1234,5678,payroll:4841`
    
</dd>
</dl>

<dl>
<dd>

**activeTime:** `Optional<String>` — If specified, shows assignments that will be active at this time. Defaults to now, which would show current active assignments. In RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.carrierProposedAssignments.createCarrierProposedAssignment(request) -> CarrierProposedAssignmentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new assignment that a driver can later use. Each driver can only have one future assignment. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Carrier-Proposed Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.carrierProposedAssignments().createCarrierProposedAssignment(
    CreateCarrierProposedAssignmentRequest
        .builder()
        .driverId("42")
        .vehicleId("123")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**activeTime:** `Optional<String>` — Time after which this assignment will be active and visible to the driver on the mobile app. Not setting it makes it active now. UTC timestamp in RFC 3339 format. Example: `2020-01-27T07:06:25Z`.
    
</dd>
</dl>

<dl>
<dd>

**driverId:** `String` — ID for the driver for the driver that this assignment is for. This can be either a unique Samsara ID or an external ID for the driver.
    
</dd>
</dl>

<dl>
<dd>

**shippingDocs:** `Optional<String>` — Shipping Documents that this assignment will propose to the driver.
    
</dd>
</dl>

<dl>
<dd>

**trailerIds:** `Optional<List<String>>` — IDs of trailers to propose. This can be either a unique Samsara IDs or an external IDs for the trailers. (forbidden if trailerNames is set)
    
</dd>
</dl>

<dl>
<dd>

**trailerNames:** `Optional<List<String>>` — Names of trailers to propose. (forbidden if trailerIds is set)
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `String` — ID for the vehicle to propose. This can be either a unique Samsara ID or an external ID for the vehicle.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.carrierProposedAssignments.deleteCarrierProposedAssignment(id) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Permanently delete an assignment. You can only delete assignments that are not yet active. To override a currently active assignment, create a new empty one, instead. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Carrier-Proposed Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.carrierProposedAssignments().deleteCarrierProposedAssignment(
    "id",
    DeleteCarrierProposedAssignmentRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the assignment.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Legacy APIs
<details><summary><code>client.legacyApIs.getDvirDefects() -> DefectsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Note: This is a legacy endpoint, consider using [this endpoint](https://developers.samsara.com/reference/streamdefects) instead. The endpoint will continue to function as documented.** 

Returns a list of DVIR defects in an organization, filtered by creation time. The maximum time period you can query for is 30 days. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Defects** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.legacyApIs().getDvirDefects(
    GetDvirDefectsRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00). *The maximum time period you can query for is 30 days.*
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00). *The maximum time period you can query for is 30 days.*
    
</dd>
</dl>

<dl>
<dd>

**isResolved:** `Optional<Boolean>` — A filter on the data based on resolution status. Example: `isResolved=true`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.legacyApIs.getDriversVehicleAssignments() -> DriversVehicleAssignmentsGetDriversVehicleAssignmentsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Note: This is a legacy endpoint, consider using [this endpoint](https://developers.samsara.com/reference/getdrivervehicleassignments) instead. The endpoint will continue to function as documented.** Get all vehicle assignments for the requested drivers in the requested time range. The only type of assignment supported right now are assignments created through the driver app.

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.legacyApIs().getDriversVehicleAssignments(
    GetDriversVehicleAssignmentsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver IDs and externalIds. Example: `driverIds=1234,5678,payroll:4841`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00). The maximum allowed startTime-endTime range is 7 days.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00). The maximum allowed startTime-endTime range is 7 days.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**driverActivationStatus:** `Optional<GetDriversVehicleAssignmentsRequestDriverActivationStatus>` — If value is `deactivated`, only drivers that are deactivated will appear in the response. This parameter will default to `active` if not provided (fetching only active drivers).  Valid values: `active`, `deactivated`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.legacyApIs.getDvirHistory() -> DvirsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Note: This is a legacy endpoint, consider using [this endpoint](https://developers.samsara.com/reference/getdvirs) instead. The endpoint will continue to function as documented.** 

 Returns a list of all DVIRs in an organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read DVIRs** under the Maintenance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.legacyApIs().getDvirHistory(
    GetDvirHistoryRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.legacyApIs.getVehicleIdlingReports() -> IdlingReportsGetVehicleIdlingReportsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Note: This is a legacy endpoint, consider using [this endpoint](https://developers.samsara.com/reference/getidlingevents) instead. The endpoint will continue to function as documented.** Get all vehicle idling reports for the requested time duration.

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Fuel & Energy** under the Fuel & Energy category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.legacyApIs().getVehicleIdlingReports(
    GetVehicleIdlingReportsRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of vehicle IDs and externalIds. Example: `vehicleIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**isPtoActive:** `Optional<Boolean>` — A filter on the data based on power take-off being active or inactive.
    
</dd>
</dl>

<dl>
<dd>

**minIdlingDurationMinutes:** `Optional<Long>` — A filter on the data based on a minimum idling duration.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.legacyApIs.getSafetyEvents() -> SafetyEventsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Note: This is a legacy endpoint, consider using [this endpoint](https://developers.samsara.com/reference/getsafetyeventsv2stream) instead. The endpoint will continue to function as documented.** 

 Fetch safety events for the organization in a given time period. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.legacyApIs().getSafetyEvents(
    GetSafetyEventsRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — A filter on the data based on this comma-separated list of vehicle IDs. Example: `vehicleIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.legacyApIs.getSafetyActivityEventFeed() -> SafetyEventsGetSafetyActivityEventFeedResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Note: This is a legacy endpoint, consider using [this endpoint](https://developers.samsara.com/reference/getsafetyeventsv2stream) instead. The endpoint will continue to function as documented.**

Get continuous safety events. The safety activity event feed offers a change-log for safety events. Use this endpoint to subscribe to safety event changes. See documentation below for all supported change-log types.

| ActivityType      | Description |
| ----------- | ----------- |
| CreateSafetyEventActivityType | a new safety event is processed by Samsara      |
| BehaviorLabelActivityType     | a label is added or removed from a safety event |
| CoachingStateActivityType     | a safety event coaching state is updated        |

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.legacyApIs().getSafetyActivityEventFeed(
    GetSafetyActivityEventFeedRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.legacyApIs.getVehiclesDriverAssignments() -> VehiclesDriverAssignmentsGetVehiclesDriverAssignmentsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Note: This is a legacy endpoint, consider using [this endpoint](https://developers.samsara.com/reference/getdrivervehicleassignments) instead. The endpoint will continue to function as documented.** Get all driver assignments for the requested vehicles in the requested time range. The only type of assignment supported right now are assignments created through the driver app.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.legacyApIs().getVehiclesDriverAssignments(
    GetVehiclesDriverAssignmentsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `Optional<String>` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00). The maximum allowed startTime-endTime range is 7 days.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00). The maximum allowed startTime-endTime range is 7 days.
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of vehicle IDs and externalIds. Example: `vehicleIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.legacyApIs.v1GetVehicleHarshEvent(vehicleId) -> V1VehicleHarshEventResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Note: This is a legacy endpoint, consider using [this endpoint](https://developers.samsara.com/reference/getsafetyeventsv2stream) instead. The endpoint will continue to function as documented.** <n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch harsh event details for a vehicle. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.legacyApIs().v1GetVehicleHarshEvent(
    1000000L,
    V1GetVehicleHarshEventRequest
        .builder()
        .timestamp(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**vehicleId:** `Long` — ID of the vehicle. Must contain only digits 0-9.
    
</dd>
</dl>

<dl>
<dd>

**timestamp:** `Long` — Timestamp in milliseconds representing the timestamp of a harsh event.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Documents
<details><summary><code>client.documents.getDocumentTypes() -> DocumentTypesGetDocumentTypesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of the organization document types. The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/getDriverDocumentTypesByOrgId).

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Documents** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.documents().getDocumentTypes(
    GetDocumentTypesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.documents.getDocuments() -> DocumentsGetDocumentsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all documents for the given time range. The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/getDriverDocumentsByOrgId).

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Documents** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.documents().getDocuments(
    GetDocumentsRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**documentTypeId:** `Optional<String>` — ID of the document template type.
    
</dd>
</dl>

<dl>
<dd>

**queryBy:** `Optional<String>` — Query by document creation time (`created`) or updated time (`updated`). Defaults to `created`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.documents.postDocument(request) -> DocumentsPostDocumentResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a single document. The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/createDriverDocument).

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Documents** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.documents().postDocument(
    DocumentsPostDocumentRequestBody
        .builder()
        .documentTypeId("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
        .driverId("45646")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**documentTypeId:** `String` — ID for the document type.
    
</dd>
</dl>

<dl>
<dd>

**driverId:** `String` — ID of the driver. Can be either unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the driver.
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<FieldObjectPostRequestBody>>` — The fields associated with this document.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — Name of the document.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — Notes on the document.
    
</dd>
</dl>

<dl>
<dd>

**routeStopId:** `Optional<String>` — ID of the route stop. Can be either unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the route stop.
    
</dd>
</dl>

<dl>
<dd>

**state:** `Optional<DocumentsPostDocumentRequestBodyState>` — The condition of the document created for the driver. Can be either `required` or `submitted`, if no value is specified, `state` defaults to `required`. `required` documents are pre-populated documents for the Driver to fill out in the Driver App.  Valid values: `submitted`, `required`
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `Optional<String>` — ID of the vehicle. Can be either unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the vehicle.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.documents.generateDocumentPdf(request) -> DocumentPdfGenerationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Request creation of a document PDF. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Documents** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.documents().generateDocumentPdf(
    DocumentPdfGenerationRequest
        .builder()
        .documentId("6c8c0c01-206a-41a4-9d21-15b9978d04cb")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**documentId:** `String` — ID of the document.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.documents.getDocumentPdf(id) -> DocumentPdfQueryResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns generation job status and download URL for a PDF. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Documents** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.documents().getDocumentPdf(
    "id",
    GetDocumentPdfRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the pdf.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.documents.getDocument(id) -> DocumentsGetDocumentResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single document. The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/getDriverDocumentByIdAndDriverId).

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Documents** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.documents().getDocument(
    "id",
    GetDocumentRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the document
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.documents.deleteDocument(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a single document. The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/deleteDriverDocumentByIdAndDriverId).

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Documents** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.documents().deleteDocument(
    "id",
    DeleteDocumentRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the document to delete
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## DriverVehicleAssignments
<details><summary><code>client.driverVehicleAssignments.getDriverVehicleAssignments() -> DriverVehicleAssignmentsV2GetDriverVehicleAssignmentsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all driver-vehicle assignments for the requested drivers or vehicles in the requested time range. To fetch driver-vehicle assignments out of the vehicle trips' time ranges, assignmentType needs to be specified. Note: this endpoint replaces past endpoints to fetch assignments by driver or by vehicle. Visit [this migration guide](https://developers.samsara.com/docs/migrating-from-driver-vehicle-assignment-or-vehicle-driver-assignment-endpoints) for more information.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverVehicleAssignments().getDriverVehicleAssignments(
    GetDriverVehicleAssignmentsRequest
        .builder()
        .filterBy(GetDriverVehicleAssignmentsRequestFilterBy.DRIVERS)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**filterBy:** `GetDriverVehicleAssignmentsRequestFilterBy` — Option to filter by drivers or vehicles.  Valid values: `drivers`, `vehicles`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver IDs and externalIds. Example: `driverIds=1234,5678,payroll:4841`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — ID of the vehicle. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: "key:value". For example, "maintenanceId:250020".
    
</dd>
</dl>

<dl>
<dd>

**driverTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**vehicleTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of vehicle tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**assignmentType:** `Optional<GetDriverVehicleAssignmentsRequestAssignmentType>` — Specifies which assignment type to filter by.  Valid values: `HOS`, `idCard`, `static`, `faceId`, `tachograph`, `safetyManual`, `RFID`, `trailer`, `external`, `qrCode`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.driverVehicleAssignments.createDriverVehicleAssignment(request) -> DriverVehicleAssignmentsV2CreateDriverVehicleAssignmentResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Assign vehicle drive-time to a driver via API. For a step-by-step instruction on how to leverage this endpoint, see [this guide](https://developers.samsara.com/docs/creating-driver-vehicle-assignments)

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverVehicleAssignments().createDriverVehicleAssignment(
    DriverVehicleAssignmentsV2CreateDriverVehicleAssignmentRequestBody
        .builder()
        .driverId("494123")
        .vehicleId("281474978683353")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assignedAtTime:** `Optional<String>` — The time at which the assignment was made in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**driverId:** `String` — ID of the driver. This can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the driver.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — The end time in RFC 3339 format. Defaults to max-time (meaning it's an ongoing assignment) if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**isPassenger:** `Optional<Boolean>` — Is this driver a passenger? Defaults to false if not provided
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<PostDriverVehicleAssignmentsV2RequestBodyMetadataRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` — The start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `String` — ID of the vehicle. This can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the vehicle.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.driverVehicleAssignments.deleteDriverVehicleAssignments(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete driver assignments that were created using the `POST fleet/driver-vehicle-assignments` endpoint for the requested vehicle in the requested time range.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverVehicleAssignments().deleteDriverVehicleAssignments(
    DriverVehicleAssignmentsV2DeleteDriverVehicleAssignmentsRequestBody
        .builder()
        .vehicleId("281474978683353")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assignedAtTime:** `Optional<String>` —  Assigned at time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**isPassenger:** `Optional<Boolean>` — Indicates if assigned driver is passenger
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` —  A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `String` — ID of the vehicle. This can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the vehicle.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.driverVehicleAssignments.updateDriverVehicleAssignment(request) -> DriverVehicleAssignmentsV2UpdateDriverVehicleAssignmentResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update driver assignments that were created using the `POST fleet/driver-vehicle-assignments`. Vehicle Id, Driver Id, and Start Time must match an existing assignment.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.driverVehicleAssignments().updateDriverVehicleAssignment(
    DriverVehicleAssignmentsV2UpdateDriverVehicleAssignmentRequestBody
        .builder()
        .driverId("494123")
        .startTime("2019-06-13T19:08:25Z")
        .vehicleId("281474978683353")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assignedAtTime:** `Optional<String>` — The time at which the assignment was made in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**driverId:** `String` — ID of the driver. This can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the driver.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — The end time in RFC 3339 format. To make this an ongoing assignment (ie. an assignment with no end time), provide an endTime value of 'null'. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**isPassenger:** `Optional<Boolean>` — Is this driver a passenger?
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<PatchDriverVehicleAssignmentsV2RequestBodyMetadataRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — The start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `String` — ID of the vehicle. This can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the vehicle.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Drivers
<details><summary><code>client.drivers.list() -> SyncPagingIterable&amp;lt;Driver&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all drivers in organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Drivers** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.drivers().list(
    ListDriversRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverActivationStatus:** `Optional<ListDriversRequestDriverActivationStatus>` — If value is `deactivated`, only drivers that are deactivated will appear in the response. This parameter will default to `active` if not provided (fetching only active drivers).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**attributeValueIds:** `Optional<String>` — A filter on the data based on this comma-separated list of attribute value IDs. Only entities associated with ALL of the referenced values will be returned (i.e. the intersection of the sets of entities with each value). Example: `attributeValueIds=076efac2-83b5-47aa-ba36-18428436dcac,6707b3f0-23b9-4fe3-b7be-11be34aea544`
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<String>` — A filter on the data to return entities having given attributes using name-value pair or range query (only for numeric attributes), separated by semicolon. Only entities associated with ALL of the referenced values will be returned (i.e. the intersection of the sets of entities with each value). Example: `attributes=ExampleAttributeName:some_value&attributes=SomeOtherAttr:123&attributes=someNumericAttribute:range(10,20)`
    
</dd>
</dl>

<dl>
<dd>

**updatedAfterTime:** `Optional<String>` — A filter on data to have an updated at time after or equal to this specified time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**createdAfterTime:** `Optional<String>` — A filter on data to have a created at time after or equal to this specified time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.drivers.create(request) -> DriverResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Add a driver to the organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Drivers** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.drivers().create(
    CreateDriverRequest
        .builder()
        .name("Susan Jones")
        .password("aSecurePassword1234")
        .username("SusanJones")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**attributes:** `Optional<List<CreateDriverRequestAttributes>>` 
    
</dd>
</dl>

<dl>
<dd>

**carrierSettings:** `Optional<DriverCarrierSettings>` 
    
</dd>
</dl>

<dl>
<dd>

**currentIdCardCode:** `Optional<String>` — The ID Card Code on the back of the physical card assigned to the driver.  Contact Samsara if you would like to enable this feature.
    
</dd>
</dl>

<dl>
<dd>

**eldAdverseWeatherExemptionEnabled:** `Optional<Boolean>` — Flag indicating this driver may use Adverse Weather exemptions in ELD logs.
    
</dd>
</dl>

<dl>
<dd>

**eldBigDayExemptionEnabled:** `Optional<Boolean>` — Flag indicating this driver may use Big Day exemption in ELD logs.
    
</dd>
</dl>

<dl>
<dd>

**eldDayStartHour:** `Optional<Long>` — `0` indicating midnight-to-midnight ELD driving hours, `12` to indicate noon-to-noon driving hours.
    
</dd>
</dl>

<dl>
<dd>

**eldExempt:** `Optional<Boolean>` — Flag indicating this driver is exempt from the Electronic Logging Mandate.
    
</dd>
</dl>

<dl>
<dd>

**eldExemptReason:** `Optional<String>` — Reason that this driver is exempt from the Electronic Logging Mandate (see eldExempt).
    
</dd>
</dl>

<dl>
<dd>

**eldPcEnabled:** `Optional<Boolean>` — Flag indicating this driver may select the Personal Conveyance duty status in ELD logs.
    
</dd>
</dl>

<dl>
<dd>

**eldYmEnabled:** `Optional<Boolean>` — Flag indicating this driver may select the Yard Move duty status in ELD logs.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — The [external IDs](https://developers.samsara.com/docs/external-ids) for the given object.
    
</dd>
</dl>

<dl>
<dd>

**hasDrivingFeaturesHidden:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasVehicleUnpinningEnabled:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hosSetting:** `Optional<DriverHosSetting>` 
    
</dd>
</dl>

<dl>
<dd>

**licenseNumber:** `Optional<String>` — Driver's state issued license number. The combination of this number and `licenseState` must be unique.
    
</dd>
</dl>

<dl>
<dd>

**licenseState:** `Optional<String>` — Abbreviation of US state, Canadian province, or US territory that issued driver's license.
    
</dd>
</dl>

<dl>
<dd>

**locale:** `Optional<CreateDriverRequestLocale>` — Locale override (uncommon). These are specified by ISO 3166-2 country codes for supported locales. Valid values: `us`, `at`, `be`, `ca`, `gb`, `fr`, `de`, `ie`, `it`, `lu`, `mx`, `nl`, `es`, `ch`, `pr`.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Driver's name.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — Notes about the driver.
    
</dd>
</dl>

<dl>
<dd>

**password:** `String` — Password that the driver can use to login to the Samsara driver app.
    
</dd>
</dl>

<dl>
<dd>

**peerGroupTagId:** `Optional<String>` — The peer group tag id this driver belong to, used for gamification.
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` — Phone number of the driver.
    
</dd>
</dl>

<dl>
<dd>

**profileImageBase64:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**profileImageUrl:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**staticAssignedVehicleId:** `Optional<String>` — ID of vehicle that the driver is permanently assigned to. (uncommon).
    
</dd>
</dl>

<dl>
<dd>

**tachographCardNumber:** `Optional<String>` — Driver's assigned tachograph card number (Europe specific)
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — IDs of tags the driver is associated with. If your access to the API is scoped by one or more tags, this field is required to pass in.
    
</dd>
</dl>

<dl>
<dd>

**timezone:** `Optional<String>` — Home terminal timezone, in order to indicate what time zone should be used to calculate the ELD logs. Driver timezones use [IANA timezone database](https://www.iana.org/time-zones) keys (e.g. `America/Los_Angeles`, `America/New_York`, `Europe/London`, etc.). You can find a mapping of common timezone formats to IANA timezone keys [here](https://unicode.org/cldr/charts/latest/supplemental/zone_tzid.html).
    
</dd>
</dl>

<dl>
<dd>

**usDriverRulesetOverride:** `Optional<UsDriverRulesetOverride>` 
    
</dd>
</dl>

<dl>
<dd>

**username:** `String` — Driver's login username into the driver app. The username may not contain spaces or the '@' symbol. The username must be unique.
    
</dd>
</dl>

<dl>
<dd>

**vehicleGroupTagId:** `Optional<String>` — Tag ID which determines which vehicles a driver will see when selecting vehicles.
    
</dd>
</dl>

<dl>
<dd>

**waitingTimeDutyStatusEnabled:** `Optional<Boolean>` — Flag indicating this driver may select waiting time duty status in ELD logs
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.drivers.postDriverRemoteSignout(request) -> DriverRemoteSignoutPostDriverRemoteSignoutResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Sign out a driver from the Samsara Driver App

To access this endpoint, your organization must have the Samsara Platform Premier license.

Note: Sign out requests made while a logged-in driver does not have internet connection will not log the driver out. A success response will still be provided and the driver will be logged out once they have internet connection.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Driver Remote Signout** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.drivers().postDriverRemoteSignout(
    DriverRemoteSignoutPostDriverRemoteSignoutRequestBody
        .builder()
        .driverId("12434")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverId:** `String` — ID of the driver.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.drivers.get(id) -> DriverResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get information about a driver. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Drivers** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.drivers().get(
    "id",
    GetDriversRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the driver. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `payrollId:ABFS18600`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.drivers.delete(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.drivers().delete(
    "id",
    DeleteDriversRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.drivers.update(id, request) -> DriverResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a specific driver's information. This can also be used to activate or de-activate a given driver by setting the driverActivationStatus field. If the driverActivationStatus field is 'deactivated' then the user can also specify the deactivatedAtTime. The deactivatedAtTime cannot be more than 6 months in the past and must not come before the dirver's latest active HOS log. It will be considered an error if deactivatedAtTime is provided with a driverActivationStatus of active. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Drivers** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.drivers().update(
    "id",
    UpdateDriverRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the driver. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `payrollId:ABFS18600`
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<List<UpdateDriverRequestAttributes>>` 
    
</dd>
</dl>

<dl>
<dd>

**carrierSettings:** `Optional<DriverCarrierSettings>` 
    
</dd>
</dl>

<dl>
<dd>

**currentIdCardCode:** `Optional<String>` — The ID Card Code on the back of the physical card assigned to the driver.  Contact Samsara if you would like to enable this feature.
    
</dd>
</dl>

<dl>
<dd>

**deactivatedAtTime:** `Optional<String>` — The date and time this driver is considered to be deactivated in RFC 3339 format.
    
</dd>
</dl>

<dl>
<dd>

**driverActivationStatus:** `Optional<UpdateDriverRequestDriverActivationStatus>` — A value indicating whether the driver is active or deactivated. Valid values: `active`, `deactivated`.
    
</dd>
</dl>

<dl>
<dd>

**eldAdverseWeatherExemptionEnabled:** `Optional<Boolean>` — Flag indicating this driver may use Adverse Weather exemptions in ELD logs.
    
</dd>
</dl>

<dl>
<dd>

**eldBigDayExemptionEnabled:** `Optional<Boolean>` — Flag indicating this driver may use Big Day exemption in ELD logs.
    
</dd>
</dl>

<dl>
<dd>

**eldDayStartHour:** `Optional<Long>` — `0` indicating midnight-to-midnight ELD driving hours, `12` to indicate noon-to-noon driving hours.
    
</dd>
</dl>

<dl>
<dd>

**eldExempt:** `Optional<Boolean>` — Flag indicating this driver is exempt from the Electronic Logging Mandate.
    
</dd>
</dl>

<dl>
<dd>

**eldExemptReason:** `Optional<String>` — Reason that this driver is exempt from the Electronic Logging Mandate (see eldExempt).
    
</dd>
</dl>

<dl>
<dd>

**eldPcEnabled:** `Optional<Boolean>` — Flag indicating this driver may select the Personal Conveyance duty status in ELD logs.
    
</dd>
</dl>

<dl>
<dd>

**eldYmEnabled:** `Optional<Boolean>` — Flag indicating this driver may select the Yard Move duty status in ELD logs.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — The [external IDs](https://developers.samsara.com/docs/external-ids) for the given object.
    
</dd>
</dl>

<dl>
<dd>

**hasDrivingFeaturesHidden:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hasVehicleUnpinningEnabled:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hosSetting:** `Optional<UpdateDriverRequestHosSetting>` 
    
</dd>
</dl>

<dl>
<dd>

**licenseNumber:** `Optional<String>` — Driver's state issued license number. The combination of this number and `licenseState` must be unique.
    
</dd>
</dl>

<dl>
<dd>

**licenseState:** `Optional<String>` — Abbreviation of US state, Canadian province, or US territory that issued driver's license.
    
</dd>
</dl>

<dl>
<dd>

**locale:** `Optional<UpdateDriverRequestLocale>` — Locale override (uncommon). These are specified by ISO 3166-2 country codes for supported locales. Valid values: `us`, `at`, `be`, `ca`, `gb`, `fr`, `de`, `ie`, `it`, `lu`, `mx`, `nl`, `es`, `ch`, `pr`.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — Driver's name.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — Notes about the driver.
    
</dd>
</dl>

<dl>
<dd>

**password:** `Optional<String>` — Password that the driver can use to login to the Samsara driver app.
    
</dd>
</dl>

<dl>
<dd>

**peerGroupTagId:** `Optional<String>` — The peer group tag id this driver belong to, leave blank to be in group with everyone, used for gamification.
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` — Phone number of the driver.
    
</dd>
</dl>

<dl>
<dd>

**profileImageBase64:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**profileImageUrl:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**staticAssignedVehicleId:** `Optional<String>` — ID of vehicle that the driver is permanently assigned to. (uncommon).
    
</dd>
</dl>

<dl>
<dd>

**tachographCardNumber:** `Optional<String>` — Driver's assigned tachograph card number (Europe specific)
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — IDs of tags the driver is associated with. If your access to the API is scoped by one or more tags, this field is required to pass in.
    
</dd>
</dl>

<dl>
<dd>

**timezone:** `Optional<String>` — Home terminal timezone, in order to indicate what time zone should be used to calculate the ELD logs. Driver timezones use [IANA timezone database](https://www.iana.org/time-zones) keys (e.g. `America/Los_Angeles`, `America/New_York`, `Europe/London`, etc.). You can find a mapping of common timezone formats to IANA timezone keys [here](https://unicode.org/cldr/charts/latest/supplemental/zone_tzid.html).
    
</dd>
</dl>

<dl>
<dd>

**usDriverRulesetOverride:** `Optional<UsDriverRulesetOverride>` 
    
</dd>
</dl>

<dl>
<dd>

**username:** `Optional<String>` — Driver's login username into the driver app. The username may not contain spaces or the '@' symbol. The username must be unique.
    
</dd>
</dl>

<dl>
<dd>

**vehicleGroupTagId:** `Optional<String>` — Tag ID which determines which vehicles a driver will see when selecting vehicles.
    
</dd>
</dl>

<dl>
<dd>

**waitingTimeDutyStatusEnabled:** `Optional<Boolean>` — Flag indicating this driver may select waiting time duty status in ELD logs
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## AuthTokenForDriver
<details><summary><code>client.authTokenForDriver.authToken(request) -> AuthTokenAuthTokenResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a short-lived auth token a driver can use to login.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Driver Auth Token** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.authTokenForDriver().authToken(
    AuthTokenAuthTokenRequestBody
        .builder()
        .code("dp[gZc1wAigz4uGa0Hh")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**code:** `String` — Required. Random 12+ character string, used with the auth token to help secure the client from intercepted tokens.
    
</dd>
</dl>

<dl>
<dd>

**driverId:** `Optional<Long>` — Optional. Samsara ID of the driver. One of `id`, `externalId`, or `username` is required.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — Optional. External ID of the driver, in the format `key:value` (e.g., `payrollId:ABFS18600`). One of `id`, `externalId`, or `username` is required.
    
</dd>
</dl>

<dl>
<dd>

**username:** `Optional<String>` — Optional. Username of the driver. This is the login identifier configured when the driver is created. One of `id`, `externalId`, or `username` is required.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Tachograph (EU Only)
<details><summary><code>client.tachographEuOnly.getDriverTachographActivity() -> DriverTachographActivityResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all known tachograph activity for all specified drivers in the time range. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Tachograph (EU)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tachographEuOnly().getDriverTachographActivity(
    GetDriverTachographActivityRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. It can't be more than 30 days past startTime. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — A filter on the data based on this comma-separated list of driver IDs. Example: `driverIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tachographEuOnly.getDriverTachographFiles() -> TachographDriverFilesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all known tachograph files for all specified drivers in the time range. 

 <b>Rate limit:</b> 50 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Tachograph (EU)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tachographEuOnly().getDriverTachographFiles(
    GetDriverTachographFilesRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — A filter on the data based on this comma-separated list of driver IDs. Example: `driverIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tachographEuOnly.getVehicleTachographFiles() -> TachographVehicleFilesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all known tachograph files for all specified vehicles in the time range. 

 <b>Rate limit:</b> 150 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Tachograph (EU)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tachographEuOnly().getVehicleTachographFiles(
    GetVehicleTachographFilesRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — A filter on the data based on this comma-separated list of vehicle IDs. Example: `vehicleIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Equipment
<details><summary><code>client.equipment.listEquipment() -> EquipmentListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of all equipment in an organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.equipment().listEquipment(
    ListEquipmentRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.equipment.getEquipmentLocations() -> EquipmentLocationsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns last known locations for all equipment. This can be optionally filtered by tags or specific equipment IDs. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.equipment().getEquipmentLocations(
    GetEquipmentLocationsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**equipmentIds:** `Optional<String>` — A filter on the data based on this comma-separated list of equipment IDs. Example: `equipmentIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.equipment.getEquipmentLocationsFeed() -> EquipmentLocationsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Follow a continuous feed of all equipment locations.

Your first call to this endpoint will provide you with the most recent location for each unit of equipment and a `pagination` object that contains an `endCursor`.

You can provide the `endCursor` to subsequent calls via the `after` parameter. The response will contain any equipment location updates since that `endCursor`.

If `hasNextPage` is `false`, no updates are readily available yet. We'd suggest waiting a minimum of 5 seconds before requesting updates. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.equipment().getEquipmentLocationsFeed(
    GetEquipmentLocationsFeedRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**equipmentIds:** `Optional<String>` — A filter on the data based on this comma-separated list of equipment IDs. Example: `equipmentIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.equipment.getEquipmentLocationsHistory() -> EquipmentLocationsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns historical equipment locations during the given time range. This can be optionally filtered by tags or specific equipment IDs. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.equipment().getEquipmentLocationsHistory(
    GetEquipmentLocationsHistoryRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**equipmentIds:** `Optional<String>` — A filter on the data based on this comma-separated list of equipment IDs. Example: `equipmentIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.equipment.getEquipmentStats() -> EquipmentStatsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the last known stats for all equipment. This can be optionally filtered by tags or specific equipment IDs. 

 <b>Rate limit:</b> 150 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.equipment().getEquipmentStats(
    GetEquipmentStatsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**equipmentIds:** `Optional<String>` — A filter on the data based on this comma-separated list of equipment IDs. Example: `equipmentIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**types:** `Optional<GetEquipmentStatsRequestTypesItem>` 

The types of equipment stats you want to query. Currently, you may submit up to 4 types.

- `engineRpm`: The revolutions per minute of the engine.
- `fuelPercents`: The percent of fuel in the unit of equipment.
- `obdEngineSeconds`: The number of seconds the engine has been running as reported directly from on-board diagnostics. This is supported with the following hardware configurations: AG24/AG26 + AOPEN/A9PIN/ACT9/ACT14.
- `gatewayEngineSeconds`: An approximation of the number of seconds the engine has been running since it was new, based on the amount of time the asset gateway has been receiving power with an offset provided manually through the Samsara cloud dashboard. This is supported with the following hardware configurations: 
  - AG24/AG26/AG46P + APWR cable ([Auxiliary engine configuration](https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs#UUID-d514abff-d10a-efaf-35d9-e10fa6c4888d) required) 
  - AG52 + BPWR/BEQP cable ([Auxiliary engine configuration](https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs#UUID-d514abff-d10a-efaf-35d9-e10fa6c4888d) required). 
- `gatewayJ1939EngineSeconds`: An approximation of the number of seconds the engine has been running since it was new, based on the amount of time the AG26 device is receiving power via J1939/CAT cable and an offset provided manually through the Samsara cloud dashboard.
- `obdEngineStates`: The state of the engine read from on-board diagnostics. Can be `Off`, `On`, or `Idle`.
- `gatewayEngineStates`: An approximation of engine state based on readings the AG26 receives from the aux/digio cable. Can be `Off` or `On`.
- `gpsOdometerMeters`: An approximation of odometer reading based on GPS calculations since the AG26 was activated, and a manual odometer offset provided in the Samsara cloud dashboard. Valid values: `Off`, `On`.
- `gps`: GPS data including lat/long, heading, speed, address book entry (if exists), and a reverse geocoded address. 
- `engineTotalIdleTimeMinutes`: Total time in minutes that the engine has been idling.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.equipment.getEquipmentStatsFeed() -> EquipmentStatsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Follow a continuous feed of all equipment stats.

Your first call to this endpoint will provide you with the most recent stats for each unit of equipment and a `pagination` object that contains an `endCursor`.

You can provide the `endCursor` to subsequent calls via the `after` parameter. The response will contain any equipment stats updates since that `endCursor`.

If `hasNextPage` is `false`, no updates are readily available yet. Each stat type has a different refresh rate, but in general we'd suggest waiting a minimum of 5 seconds before requesting updates. 

 <b>Rate limit:</b> 150 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.equipment().getEquipmentStatsFeed(
    GetEquipmentStatsFeedRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**equipmentIds:** `Optional<String>` — A filter on the data based on this comma-separated list of equipment IDs. Example: `equipmentIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**types:** `Optional<GetEquipmentStatsFeedRequestTypesItem>` 

The types of equipment stats you want to query. Currently, you may submit up to 4 types.

- `engineRpm`: The revolutions per minute of the engine.
- `fuelPercents`: The percent of fuel in the unit of equipment.
- `obdEngineSeconds`: The number of seconds the engine has been running as reported directly from on-board diagnostics. This is supported with the following hardware configurations: AG24/AG26 + AOPEN/A9PIN/ACT9/ACT14.
- `gatewayEngineSeconds`: An approximation of the number of seconds the engine has been running since it was new, based on the amount of time the asset gateway has been receiving power with an offset provided manually through the Samsara cloud dashboard. This is supported with the following hardware configurations: 
  - AG24/AG26/AG46P + APWR cable ([Auxiliary engine configuration](https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs#UUID-d514abff-d10a-efaf-35d9-e10fa6c4888d) required) 
  - AG52 + BPWR/BEQP cable ([Auxiliary engine configuration](https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs#UUID-d514abff-d10a-efaf-35d9-e10fa6c4888d) required). 
- `gatewayJ1939EngineSeconds`: An approximation of the number of seconds the engine has been running since it was new, based on the amount of time the AG26 device is receiving power via J1939/CAT cable and an offset provided manually through the Samsara cloud dashboard.
- `obdEngineStates`: The state of the engine read from on-board diagnostics. Can be `Off`, `On`, or `Idle`.
- `gatewayEngineStates`: An approximation of engine state based on readings the AG26 receives from the aux/digio cable. Can be `Off` or `On`.
- `gpsOdometerMeters`: An approximation of odometer reading based on GPS calculations since the AG26 was activated, and a manual odometer offset provided in the Samsara cloud dashboard. Valid values: `Off`, `On`.
- `gps`: GPS data including lat/long, heading, speed, address book entry (if exists), and a reverse geocoded address. 
- `engineTotalIdleTimeMinutes`: Total time in minutes that the engine has been idling.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.equipment.getEquipmentStatsHistory() -> EquipmentStatsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns historical equipment status during the given time range. This can be optionally filtered by tags or specific equipment IDs. 

 <b>Rate limit:</b> 150 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.equipment().getEquipmentStatsHistory(
    GetEquipmentStatsHistoryRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**equipmentIds:** `Optional<String>` — A filter on the data based on this comma-separated list of equipment IDs. Example: `equipmentIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**types:** `Optional<GetEquipmentStatsHistoryRequestTypesItem>` 

The types of equipment stats you want to query. Currently, you may submit up to 4 types.

- `engineRpm`: The revolutions per minute of the engine.
- `fuelPercents`: The percent of fuel in the unit of equipment.
- `obdEngineSeconds`: The number of seconds the engine has been running as reported directly from on-board diagnostics. This is supported with the following hardware configurations: AG24/AG26 + AOPEN/A9PIN/ACT9/ACT14.
- `gatewayEngineSeconds`: An approximation of the number of seconds the engine has been running since it was new, based on the amount of time the asset gateway has been receiving power with an offset provided manually through the Samsara cloud dashboard. This is supported with the following hardware configurations: 
  - AG24/AG26/AG46P + APWR cable ([Auxiliary engine configuration](https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs#UUID-d514abff-d10a-efaf-35d9-e10fa6c4888d) required) 
  - AG52 + BPWR/BEQP cable ([Auxiliary engine configuration](https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs#UUID-d514abff-d10a-efaf-35d9-e10fa6c4888d) required). 
- `gatewayJ1939EngineSeconds`: An approximation of the number of seconds the engine has been running since it was new, based on the amount of time the AG26 device is receiving power via J1939/CAT cable and an offset provided manually through the Samsara cloud dashboard.
- `obdEngineStates`: The state of the engine read from on-board diagnostics. Can be `Off`, `On`, or `Idle`.
- `gatewayEngineStates`: An approximation of engine state based on readings the AG26 receives from the aux/digio cable. Can be `Off` or `On`.
- `gpsOdometerMeters`: An approximation of odometer reading based on GPS calculations since the AG26 was activated, and a manual odometer offset provided in the Samsara cloud dashboard. Valid values: `Off`, `On`.
- `gps`: GPS data including lat/long, heading, speed, address book entry (if exists), and a reverse geocoded address. 
- `engineTotalIdleTimeMinutes`: Total time in minutes that the engine has been idling.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.equipment.getEquipment(id) -> EquipmentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the unit of equipment with the given Samsara ID. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.equipment().getEquipment(
    "id",
    GetEquipmentRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Samsara ID of the Equipment.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Hours of Service
<details><summary><code>client.hoursOfService.getHosClocks() -> HosClocksResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the current HOS status for all drivers. Note that this includes inactive as well as active drivers. The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/getFleetHosLogsSummary). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read ELD Compliance Settings (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hoursOfService().getHosClocks(
    GetHosClocksRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — A filter on the data based on this comma-separated list of driver IDs. Example: `driverIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hoursOfService.getHosDailyLogs() -> HosDailyLogsGetHosDailyLogsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get summarized daily Hours of Service charts for the specified drivers.

The time range for a log is defined by the `driver`'s `eldDayStartHour`. This value is configurable per driver.

The `startDate` and `endDate` parameters indicate the date range you'd like to retrieve daily logs for. A daily log will be returned if its `startTime` is on any of the days within in this date range (inclusive of `startDate` and `endDate`).

**Note:** If data is still being uploaded from the Samsara Driver App, it may not be completely reflected in the response from this endpoint. The best practice is to wait a couple of days before querying this endpoint to make sure that all data from the Samsara Driver App has been uploaded.

If you are using the legacy version of this endpoint and looking for its documentation, you can find it [here](https://www.samsara.com/api-legacy#operation/getFleetDriversHosDailyLogs).

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read ELD Compliance Settings (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hoursOfService().getHosDailyLogs(
    GetHosDailyLogsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver IDs and externalIds. Example: `driverIds=1234,5678,payroll:4841`
    
</dd>
</dl>

<dl>
<dd>

**startDate:** `Optional<String>` —  A start date in YYYY-MM-DD. This is a date only without an associated time. Example: `2019-06-13`. This is a required field
    
</dd>
</dl>

<dl>
<dd>

**endDate:** `Optional<String>` —  An end date in YYYY-MM-DD. This is a date only without an associated time. Must be greater than or equal to the start date. Example: `2019-07-21`. This is a required field
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**driverActivationStatus:** `Optional<GetHosDailyLogsRequestDriverActivationStatus>` — If value is `deactivated`, only drivers that are deactivated will appear in the response. This parameter will default to `active` if not provided (fetching only active drivers).  Valid values: `active`, `deactivated`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**expand:** `Optional<GetHosDailyLogsRequestExpand>` 

Expands the specified value(s) in the response object. Expansion populates additional fields in an object, if supported. Unsupported fields are ignored. To expand multiple fields, input a comma-separated list.

Valid value: `vehicle`  Valid values: `vehicle`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hoursOfService.getHosLogs() -> HosLogsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns HOS logs between a given `startTime` and `endTime`. The logs can be further filtered using tags or by providing a list of driver IDs (including external IDs). The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/getFleetHosLogs).

**Note:** If data is still being uploaded from the Samsara Driver App, it may not be completely reflected in the response from this endpoint. The best practice is to wait a couple of days before querying this endpoint to make sure that all data from the Samsara Driver App has been uploaded. 

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read ELD Compliance Settings (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hoursOfService().getHosLogs(
    GetHosLogsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — A filter on the data based on this comma-separated list of driver IDs. Example: `driverIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` — A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hoursOfService.getHosViolations() -> HosViolationsGetHosViolationsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get active Hours of Service violations for the specified drivers.

The day object time range for a violation is defined by the `driver`'s `eldDayStartHour`. This value is configurable per driver.

The `startTime` and `endTime` parameters indicate the datetime range you'd like to retrieve violations for. A violation will be returned if its `violationStartTime` falls within this datetime range (inclusive of `startTime` and `endTime`) 

**Note:** The following are all the violation types with a short explanation about what each of them means: `californiaMealbreakMissed` (Missed California Meal Break), `cycleHoursOn` (Cycle Limit), `cycleOffHoursAfterOnDutyHours` (Cycle 2 Limit), `dailyDrivingHours` (Daily Driving Limit), `dailyOffDutyDeferralAddToDay2Consecutive` (Daily Off-Duty Deferral: Add To Day2 Consecutive), `dailyOffDutyDeferralNotPartMandatory` (Daily Off-Duty Deferral: Not Part Of Mandatory), `dailyOffDutyDeferralTwoDayDrivingLimit` (Daily Off-Duty Deferral: 2 Day Driving Limit), `dailyOffDutyDeferralTwoDayOffDuty` (Daily Off-Duty Deferral: 2 Day Off Duty), `dailyOffDutyNonResetHours` (Daily Off-Duty Time: Non-Reset), `dailyOffDutyTotalHours` (Daily Off-Duty Time), `dailyOnDutyHours` (Daily On-Duty Limit), `mandatory24HoursOffDuty` (24 Hours of Off Duty required), `restbreakMissed` (Missed Rest Break), `shiftDrivingHours` (Shift Driving Limit), `shiftHours` (Shift Duty Limit), `shiftOnDutyHours` (Shift On-Duty Limit), `unsubmittedLogs` (Missing Driver Certification)

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read ELD Compliance Settings (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hoursOfService().getHosViolations(
    GetHosViolationsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of driver IDs and externalIds. Example: `driverIds=1234,5678,payroll:4841`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**types:** `Optional<String>` — A filter on violations data based on the violation type enum. Supported types: `NONE, californiaMealbreakMissed, cycleHoursOn, cycleOffHoursAfterOnDutyHours, dailyDrivingHours, dailyOffDutyDeferralAddToDay2Consecutive, dailyOffDutyDeferralNotPartMandatory, dailyOffDutyDeferralTwoDayDrivingLimit, dailyOffDutyDeferralTwoDayOffDuty, dailyOffDutyNonResetHours, dailyOffDutyTotalHours, dailyOnDutyHours, mandatory24HoursOffDuty, restbreakMissed, shiftDrivingHours, shiftHours, shiftOnDutyHours, unsubmittedLogs`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hoursOfService.setCurrentDutyStatus(driverId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Set an individual driver’s current duty status to 'On Duty' or 'Off Duty'.

 To ensure compliance with the ELD Mandate, only  authenticated drivers can make direct duty status changes on their own logbook. Any system external to the Samsara Driver App using this endpoint to trigger duty status changes must ensure that such changes are only triggered directly by the driver in question and that the driver has been properly authenticated. This endpoint should not be used to algorithmically trigger duty status changes nor should it be used by personnel besides the driver to trigger duty status changes on the driver’s behalf. Carriers and their drivers are ultimately responsible for maintaining accurate logs and should confirm that their use of the endpoint is compliant with the ELD Mandate. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write ELD Hours of Service (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hoursOfService().setCurrentDutyStatus(
    1000000L,
    InlineObject1
        .builder()
        .dutyStatus("ON_DUTY")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverId:** `Long` — ID of the driver for whom the duty status is being set.
    
</dd>
</dl>

<dl>
<dd>

**dutyStatus:** `String` — Duty status to set the driver to. The only supported values are 'ON_DUTY' and 'OFF_DUTY'.
    
</dd>
</dl>

<dl>
<dd>

**location:** `Optional<String>` — Location to associate the duty status change with.
    
</dd>
</dl>

<dl>
<dd>

**remark:** `Optional<String>` — Remark to associate the duty status change with.
    
</dd>
</dl>

<dl>
<dd>

**statusChangeAtMs:** `Optional<Long>` — Timestamp that the duty status will begin at specified in milliseconds UNIX time. Defaults to the current time if left blank. This can only be set to up to 8 hours in the past.
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `Optional<Long>` — Vehicle ID to associate the duty status change with.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hoursOfService.v1GetFleetHosAuthenticationLogs() -> V1HosAuthenticationLogsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get the HOS (hours of service) signin and signout logs for the specified driver. The response includes 4 fields that are now deprecated.

**Note:** If data is still being uploaded from the Samsara Driver App, it may not be completely reflected in the response from this endpoint. The best practice is to wait a couple of days before querying this endpoint to make sure that all data from the Samsara Driver App has been uploaded. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read ELD Hours of Service (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hoursOfService().v1GetFleetHosAuthenticationLogs(
    V1GetFleetHosAuthenticationLogsRequest
        .builder()
        .driverId(1000000L)
        .startMs(1000000L)
        .endMs(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverId:** `Long` — Driver ID to query.
    
</dd>
</dl>

<dl>
<dd>

**startMs:** `Long` — Beginning of the time range, specified in milliseconds UNIX time.
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Long` — End of the time range, specified in milliseconds UNIX time.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Ifta
<details><summary><code>client.ifta.getIftaJurisdictionReports() -> IftaGetIftaJurisdictionReportsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all jurisdiction IFTA reports for the requested time duration. Data is returned in your organization's defined timezone.

**Note:** The most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read IFTA (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.ifta().getIftaJurisdictionReports(
    GetIftaJurisdictionReportsRequest
        .builder()
        .year(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**year:** `Long` —  The year of the requested IFTA report summary. Must be provided with a month or quarter param. Example: `year=2021`
    
</dd>
</dl>

<dl>
<dd>

**month:** `Optional<GetIftaJurisdictionReportsRequestMonth>` —  The month of the requested IFTA report summary. Can not be provided with the quarter param. Example: `month=January`  Valid values: `January`, `February`, `March`, `April`, `May`, `June`, `July`, `August`, `September`, `October`, `November`, `December`
    
</dd>
</dl>

<dl>
<dd>

**quarter:** `Optional<GetIftaJurisdictionReportsRequestQuarter>` —  The quarter of the requested IFTA report summary. Can not be provided with the month param. Q1: January, February, March. Q2: April, May, June. Q3: July, August, September. Q4: October, November, December. Example: `quarter=Q1`  Valid values: `Q1`, `Q2`, `Q3`, `Q4`
    
</dd>
</dl>

<dl>
<dd>

**jurisdictions:** `Optional<String>` —  A filter on the data based on this comma-separated list of jurisdictions. Example: `jurisdictions=GA`
    
</dd>
</dl>

<dl>
<dd>

**fuelType:** `Optional<GetIftaJurisdictionReportsRequestFuelType>` —  A filter on the data based on this comma-separated list of IFTA fuel types. Example: `fuelType=Diesel`  Valid values: `Unspecified`, `A55`, `Biodiesel`, `CompressedNaturalGas`, `Diesel`, `E85`, `Electricity`, `Ethanol`, `Gasohol`, `Gasoline`, `Hydrogen`, `LiquifiedNaturalGas`, `M85`, `Methanol`, `Propane`, `Other`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of vehicle IDs and externalIds. Example: `vehicleIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ifta.getIftaVehicleReports() -> IftaGetIftaVehicleReportsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all vehicle IFTA reports for the requested time duration. Data is returned in your organization's defined timezone.

**Note:** The most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours.

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read IFTA (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.ifta().getIftaVehicleReports(
    GetIftaVehicleReportsRequest
        .builder()
        .year(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**year:** `Long` —  The year of the requested IFTA report summary. Must be provided with a month or quarter param. Example: `year=2021`
    
</dd>
</dl>

<dl>
<dd>

**month:** `Optional<GetIftaVehicleReportsRequestMonth>` —  The month of the requested IFTA report summary. Can not be provided with the quarter param. Example: `month=January`  Valid values: `January`, `February`, `March`, `April`, `May`, `June`, `July`, `August`, `September`, `October`, `November`, `December`
    
</dd>
</dl>

<dl>
<dd>

**quarter:** `Optional<GetIftaVehicleReportsRequestQuarter>` —  The quarter of the requested IFTA report summary. Can not be provided with the month param. Q1: January, February, March. Q2: April, May, June. Q3: July, August, September. Q4: October, November, December. Example: `quarter=Q1`  Valid values: `Q1`, `Q2`, `Q3`, `Q4`
    
</dd>
</dl>

<dl>
<dd>

**jurisdictions:** `Optional<String>` —  A filter on the data based on this comma-separated list of jurisdictions. Example: `jurisdictions=GA`
    
</dd>
</dl>

<dl>
<dd>

**fuelType:** `Optional<GetIftaVehicleReportsRequestFuelType>` —  A filter on the data based on this comma-separated list of IFTA fuel types. Example: `fuelType=Diesel`  Valid values: `Unspecified`, `A55`, `Biodiesel`, `CompressedNaturalGas`, `Diesel`, `E85`, `Electricity`, `Ethanol`, `Gasohol`, `Gasoline`, `Hydrogen`, `LiquifiedNaturalGas`, `M85`, `Methanol`, `Propane`, `Other`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of vehicle IDs and externalIds. Example: `vehicleIds=1234,5678,samsara.vin:1HGBH41JXMN109186`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ifta.createIftaDetailJob(request) -> IftaCreateIftaDetailJobResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a job to generate csv files of IFTA mileage segments.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write IFTA (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.ifta().createIftaDetailJob(
    IftaCreateIftaDetailJobRequestBody
        .builder()
        .endHour("2019-06-13T19:00:00Z")
        .startHour("2019-06-13T19:00:00Z")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endHour:** `String` —  An end time in RFC 3339 format. Hour precision and timezones are supported. Any minutes or seconds will be truncated down to the nearest hour. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. The maximum request duration is 1 month. Limit the number of vehicles to 1000 when requesting more than 24 hours of data. (Examples: 2019-06-13T19:00:00Z, 2019-06-13T19:00:00.000Z, OR 2015-09-15T14:00:00-04:00).
    
</dd>
</dl>

<dl>
<dd>

**startHour:** `String` —  A start time in RFC 3339 format. Hour precision and timezones are supported. Any minutes or seconds will be truncated down to the nearest hour. Note that the most recent 72 hours of data may still be processing and is subject to change and latency, so it is not recommended to request data for the most recent 72 hours. The maximum request duration is 1 month. Limit the number of vehicles to 1000 when requesting more than 24 hours of data. (Examples: 2019-06-13T19:00:00Z, 2019-06-13T19:00:00.000Z, OR 2015-09-15T14:00:00-04:00).
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — A filter on the data based on this comma-separated list of vehicle IDs and external IDs. The number of vehicles requested per job shouldn't exceed 5000. Example: `vehicleIds: '1234,5678,samsara.vin:1HGBH41JXMN109186'`
    
</dd>
</dl>

<dl>
<dd>

**vehicleParentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of vehicle parent tag IDs. The number of vehicles requested per job shouldn't exceed 5000. Example: `vehicleParentTagIds: '1234,5678'`
    
</dd>
</dl>

<dl>
<dd>

**vehicleTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of vehicle tag IDs. The number of vehicles requested per job shouldn't exceed 5000. Example: `vehicleTagIds: '1234,5678'`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ifta.getIftaDetailJob(id) -> IftaGetIftaDetailJobResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get information about an existing IFTA detail job.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read IFTA (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.ifta().getIftaDetailJob(
    "id",
    GetIftaDetailJobRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the requested job.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Routes
<details><summary><code>client.routes.fetchRoutes() -> RoutesFetchRoutesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns multiple routes. The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/fetchAllDispatchRoutes).

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.routes().fetchRoutes(
    FetchRoutesRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` —  A start time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — A comma-separated list of additional fields to include in the response. Valid values: `stops.actualDistanceMeters`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.routes.createRoute(request) -> RoutesCreateRouteResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a route. The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/createDispatchRoute).

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.routes().createRoute(
    RoutesCreateRouteRequestBody
        .builder()
        .name("Bid 123")
        .stops(
            Arrays.asList(
                CreateRoutesStopRequestObjectRequestBody
                    .builder()
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverId:** `Optional<String>` — ID of the driver. Can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the driver.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Name for the route
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — Notes about the route.
    
</dd>
</dl>

<dl>
<dd>

**recomputeScheduledTimes:** `Optional<Boolean>` — This optional boolean parameter controls whether route schedule arrival and departure times are recalculated. When set to true, the system will automatically recompute the scheduledArrivalTime and scheduledDepartureTime for each stop along the route during route creation. This process overrides any manually provided values, with the exception of the first stop, which retains its user-defined schedule.
    
</dd>
</dl>

<dl>
<dd>

**settings:** `Optional<RouteSettingsRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**stops:** `List<CreateRoutesStopRequestObjectRequestBody>` — List of stops along the route. For each stop, exactly one of `addressId` and `singleUseLocation` are required. Depending on the `settings` on your route, either a `scheduledArrivalTime` or `scheduledDepartureTime` must be specified for the first job.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — An array of IDs of tags to associate with this route.
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `Optional<String>` — ID of the vehicle. Can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the vehicle.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.routes.getRoutesFeed() -> RoutesGetRoutesFeedResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Subscribes to a feed of immutable, append-only updates for routes. The initial request to this feed endpoint returns a cursor, which can be used on the next request to fetch updated routes that have had state changes since that request.

The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/fetchAllRouteJobUpdates).

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.routes().getRoutesFeed(
    GetRoutesFeedRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**expand:** `Optional<GetRoutesFeedRequestExpand>` 

Expands the specified value(s) in the response object. Expansion populates additional fields in an object, if supported. Unsupported fields are ignored. To expand multiple fields, input a comma-separated list.

Valid value: `route`  Valid values: `route`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.routes.fetchRoute(id) -> RoutesFetchRouteResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single route. The legacy version of this endpoint can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/getDispatchRouteById).

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.routes().fetchRoute(
    "id",
    FetchRouteRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the route. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `payrollId:ABFS18600`
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — A comma-separated list of additional fields to include in the response. Valid values: `stops.actualDistanceMeters`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.routes.deleteRoute(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a dispatch route and its associated stops.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.routes().deleteRoute(
    "id",
    DeleteRouteRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the route. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `payrollId:ABFS18600`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.routes.patchRoute(id, request) -> RoutesPatchRouteResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a route.  **Note** this implementation of patch uses [the JSON merge patch](https://tools.ietf.org/html/rfc7396) proposed standard.
 This means that any fields included in the patch request will _overwrite_ fields which exist on the target resource.
 For arrays, this means any array included in the request will _replace_ the array that exists at the specified path, it will not _add_ to the existing array.

The legacy version of this endpoint (which uses PUT instead of PATCH) can be found at [samsara.com/api-legacy](https://www.samsara.com/api-legacy#operation/updateDispatchRouteById).

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.routes().patchRoute(
    "id",
    RoutesPatchRouteRequestBody
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the route. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `payrollId:ABFS18600`
    
</dd>
</dl>

<dl>
<dd>

**driverId:** `Optional<String>` — ID of the driver. Can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the driver.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — Name for the route
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — Notes about the route.
    
</dd>
</dl>

<dl>
<dd>

**recomputeScheduledTimes:** `Optional<Boolean>` — This optional boolean parameter controls whether route schedule arrival and departure times are recalculated. When set to true, the system will automatically recompute the scheduledArrivalTime and scheduledDepartureTime for each stop along the route during route creation. This process overrides any manually provided values, with the exception of the first stop, which retains its user-defined schedule.
    
</dd>
</dl>

<dl>
<dd>

**settings:** `Optional<RouteSettingsRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**stops:** `Optional<List<UpdateRoutesStopRequestObjectRequestBody>>` — List of stops along the route. If a valid `id` of a stop is provided, that stop will be updated. If no `id` is provided for a passed in stop, that stop will be created. If `id` value are passed in for some stops and not for others, those with `id` value specified will be retained and updated in the original route, those without `id` value specified in the body will be created, and those without `id` value specified that already existed on the route will be deleted. For each new stop, exactly one of `addressId` and `singleUseLocation` are required. Depending on the `settings` on your route, either a `scheduledArrivalTime` or `scheduledDepartureTime` must be specified for the first job, if a new first job is being added.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — An array of IDs of tags to associate with this route.
    
</dd>
</dl>

<dl>
<dd>

**vehicleId:** `Optional<String>` — ID of the vehicle. Can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the vehicle.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.routes.listHubPlanRoutes() -> HubPlanRoutesListHubPlanRoutesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve routes for a specific plan.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.routes().listHubPlanRoutes(
    ListHubPlanRoutesRequest
        .builder()
        .planId("planId")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**planId:** `String` — The plan identifier
    
</dd>
</dl>

<dl>
<dd>

**routeIds:** `Optional<String>` — Comma-separated list of route IDs for filtering.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<OffsetDateTime>` — Time filter of when the route was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — Time filter of when the route was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, should be the endCursor from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of objects to return. Default and maximum is 100
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.routes.v1DeleteDispatchRouteById(routeIdOrExternalId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Delete a dispatch route and its associated jobs. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.routes().v1DeleteDispatchRouteById(
    "route_id_or_external_id",
    InlineObject
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**routeIdOrExternalId:** `String` — ID of the route. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `payrollId:ABFS18600`
    
</dd>
</dl>

<dl>
<dd>

**applyToFutureRoutes:** `Optional<Boolean>` — This is only for a recurring route.  If set to true, delete all following runs of the route.  If set to false, only delete the current route.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Settings
<details><summary><code>client.settings.getComplianceSettings() -> SettingsGetComplianceSettingsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get organization's compliance settings, including carrier name, office address, and DOT number

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read ELD Compliance Settings (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.settings().getComplianceSettings();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.settings.patchComplianceSettings(request) -> SettingsPatchComplianceSettingsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update organization's compliance settings, including carrier name, office address, and DOT number

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write ELD Compliance Settings (US)** under the Compliance category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.settings().patchComplianceSettings(
    SettingsPatchComplianceSettingsRequestBody
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**allowUnregulatedVehiclesEnabled:** `Optional<Boolean>` — [deprecated] Allow Unregulated Vehicles. This setting is deprecated as all organizations can now mark vehicles as unregulated.
    
</dd>
</dl>

<dl>
<dd>

**canadaHosEnabled:** `Optional<Boolean>` — Enable Canada HOS
    
</dd>
</dl>

<dl>
<dd>

**carrierName:** `Optional<String>` — Carrier Name / Principal Place of Business Name
    
</dd>
</dl>

<dl>
<dd>

**dotNumber:** `Optional<Long>` — Carrier US DOT Number
    
</dd>
</dl>

<dl>
<dd>

**driverAutoDutyEnabled:** `Optional<Boolean>` — Enable Driver Auto-Duty
    
</dd>
</dl>

<dl>
<dd>

**editCertifiedLogsEnabled:** `Optional<Boolean>` — Drivers Can Edit Certified Log
    
</dd>
</dl>

<dl>
<dd>

**forceManualLocationForDutyStatusChangesEnabled:** `Optional<Boolean>` — Force Manual Location For Duty Status Changes
    
</dd>
</dl>

<dl>
<dd>

**forceReviewUnassignedHosEnabled:** `Optional<Boolean>` — Force Review of Unassigned HOS
    
</dd>
</dl>

<dl>
<dd>

**mainOfficeFormattedAddress:** `Optional<String>` — Main Office Address / Principal Place of Businesss Address
    
</dd>
</dl>

<dl>
<dd>

**persistentDutyStatusEnabled:** `Optional<Boolean>` — Persistent Duty Status
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.settings.getDriverAppSettings() -> SettingsGetDriverAppSettingsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get driver app settings.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Driver App Settings** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.settings().getDriverAppSettings();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.settings.patchDriverAppSettings(request) -> SettingsPatchDriverAppSettingsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update driver app settings.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Driver App Settings** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.settings().patchDriverAppSettings(
    SettingsPatchDriverAppSettingsRequestBody
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverFleetId:** `Optional<String>` — Global login user name for the fleet driver app
    
</dd>
</dl>

<dl>
<dd>

**gamification:** `Optional<Boolean>` — Driver gamification feature. Enabling this will turn on the feature for all drivers using the mobile app. Drivers can be configured into peer groups within the Drivers Page. Unconfigured drivers will be grouped on an organization level.
    
</dd>
</dl>

<dl>
<dd>

**gamificationConfig:** `Optional<DriverAppSettingsGamificationConfigTinyObjectRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**orgVehicleSearch:** `Optional<Boolean>` — Allow drivers to search for vehicles outside of their selection tag when connected to the internet.
    
</dd>
</dl>

<dl>
<dd>

**trailerSelection:** `Optional<Boolean>` — Allow drivers to see and select trailers in the Samsara Driver app. 
    
</dd>
</dl>

<dl>
<dd>

**trailerSelectionConfig:** `Optional<DriverAppSettingsTrailerSelectionConfigTinyObjectRequestBody>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.settings.getSafetySettings() -> SafetySettingsGetSafetySettingsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get safety settings

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.settings().getSafetySettings();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Trailers
<details><summary><code>client.trailers.listTrailers() -> TrailersListTrailersResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List all trailers.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Trailers** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trailers().listTrailers(
    ListTrailersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trailers.createTrailer(request) -> TrailersCreateTrailerResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new trailer asset.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Trailers** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trailers().createTrailer(
    TrailersCreateTrailerRequestBody
        .builder()
        .name("Trailer-123")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**attributes:** `Optional<List<GoaAttributeTinyRequestBody>>` — A list of attributes to assign to the trailer.
    
</dd>
</dl>

<dl>
<dd>

**enabledForMobile:** `Optional<Boolean>` — Indicates if the trailer is visible on the Samsara mobile apps.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**licensePlate:** `Optional<String>` — The license plate of the Trailer. **By default**: empty. Can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — The human-readable name of the Trailer. This is set by a fleet administrator and will appear in both Samsara’s cloud dashboard as well as the Samsara Driver mobile app. By default, this name is the serial number of the Samsara Asset Gateway. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — These are generic notes about the Trailer. Empty by default. Can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — An array of IDs of tags to associate with this trailer. If your access to the API is scoped by one or more tags, this field is required to pass in.
    
</dd>
</dl>

<dl>
<dd>

**trailerSerialNumber:** `Optional<String>` — The serial number of the trailer.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trailers.getTrailer(id) -> TrailersGetTrailerResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a trailer with given ID.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Trailers** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trailers().getTrailer(
    "id",
    GetTrailerRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the trailer. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: "key:value". For example, "maintenanceId:250020".
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trailers.deleteTrailer(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a trailer with the given ID.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Trailers** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trailers().deleteTrailer(
    "id",
    DeleteTrailerRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the trailer to delete.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trailers.updateTrailer(id, request) -> TrailersUpdateTrailerResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a trailer.  **Note** this implementation of patch uses [the JSON merge patch](https://tools.ietf.org/html/rfc7396) proposed standard.
 This means that any fields included in the patch request will _overwrite_ fields which exist on the target resource.
 For arrays, this means any array included in the request will _replace_ the array that exists at the specified path, it will not _add_ to the existing array

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Trailers** under the Trailers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trailers().updateTrailer(
    "id",
    TrailersUpdateTrailerRequestBody
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the trailer. Can be either unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the trailer.
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<List<GoaAttributeTinyRequestBody>>` — A list of attributes to assign to the trailer.
    
</dd>
</dl>

<dl>
<dd>

**enabledForMobile:** `Optional<Boolean>` — Indicates if the trailer is visible on the Samsara mobile apps.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**licensePlate:** `Optional<String>` — The license plate of the Trailer. **By default**: empty. Can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The human-readable name of the Trailer. This is set by a fleet administrator and will appear in both Samsara’s cloud dashboard as well as the Samsara Driver mobile app. By default, this name is the serial number of the Samsara Asset Gateway. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — These are generic notes about the Trailer. Empty by default. Can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**odometerMeters:** `Optional<Long>` — When you provide a manual odometer override, Samsara will begin updating a trailer's odometer using GPS distance traveled since this override was set. Only applies to trailers installed with Samsara gateways.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — An array of IDs of tags to associate with this trailer. If your access to the API is scoped by one or more tags, this field is required to pass in.
    
</dd>
</dl>

<dl>
<dd>

**trailerSerialNumber:** `Optional<String>` — The serial number of the trailer.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Vehicles
<details><summary><code>client.vehicles.list() -> SyncPagingIterable&amp;lt;VehicleResponseObjectResponseBody&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of all vehicles.

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Vehicles** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vehicles().list(
    ListVehiclesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` —  A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**attributeValueIds:** `Optional<String>` — A filter on the data based on this comma-separated list of attribute value IDs. Only entities associated with ALL of the referenced values will be returned (i.e. the intersection of the sets of entities with each value). Example: `attributeValueIds=076efac2-83b5-47aa-ba36-18428436dcac,6707b3f0-23b9-4fe3-b7be-11be34aea544`
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<String>` — A filter on the data to return entities having given attributes using either name-value pair, or range query (only for numeric and date attributes) separated by a comma. Only entities meeting all the conditions will be returned. Example: `attributes=ExampleAttributeName:some_value&attributes=SomeOtherAttr:123&attributes=Length:range(10,20)&attributes=Date:range(2025-01-01,2025-01-31)`
    
</dd>
</dl>

<dl>
<dd>

**updatedAfterTime:** `Optional<String>` —  A filter on data to have an updated at time after or equal to this specified time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**createdAfterTime:** `Optional<String>` —  A filter on data to have a created at time after or equal to this specified time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.vehicles.get(id) -> VehicleResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get information about a specific vehicle. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Vehicles** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vehicles().get(
    "id",
    GetVehiclesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the vehicle. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource, or automatically populated by fields on the vehicle. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `maintenanceId:250020`. Automatically populated external IDs are prefixed with `samsara.`. For example, `samsara.vin:1HGBH41JXMN109186`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.vehicles.update(id, request) -> VehicleResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the given Vehicle object.

**Note:** Vehicle objects are automatically created when Samsara Vehicle Gateways are installed. You cannot create a Vehicle object via API.

You are able to *update* many of the fields of a Vehicle.

**Note**: There are no required fields in the request body, and you only need to provide the fields you wish to update. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Vehicles** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vehicles().update(
    "id",
    UpdateVehicleRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the vehicle. This can either be the Samsara-specified ID, or an external ID. External IDs are customer specified key-value pairs created in the POST or PATCH requests of this resource, or automatically populated by fields on the vehicle. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `maintenanceId:250020`. Automatically populated external IDs are prefixed with `samsara.`. For example, `samsara.vin:1HGBH41JXMN109186`.
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<List<AttributeTiny>>` 
    
</dd>
</dl>

<dl>
<dd>

**auxInputType1:** `Optional<UpdateVehicleRequestAuxInputType1>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType10:** `Optional<UpdateVehicleRequestAuxInputType10>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType11:** `Optional<UpdateVehicleRequestAuxInputType11>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType12:** `Optional<UpdateVehicleRequestAuxInputType12>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType13:** `Optional<UpdateVehicleRequestAuxInputType13>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType2:** `Optional<UpdateVehicleRequestAuxInputType2>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType3:** `Optional<UpdateVehicleRequestAuxInputType3>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType4:** `Optional<UpdateVehicleRequestAuxInputType4>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType5:** `Optional<UpdateVehicleRequestAuxInputType5>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType6:** `Optional<UpdateVehicleRequestAuxInputType6>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType7:** `Optional<UpdateVehicleRequestAuxInputType7>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType8:** `Optional<UpdateVehicleRequestAuxInputType8>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**auxInputType9:** `Optional<UpdateVehicleRequestAuxInputType9>` — The type of <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary input</a> configured for this Vehicle. Once configured, these inputs will generate dynamic, time-series data that will be available to view in the Samsara Dashboard. **By default**: empty. This can be set or updated through the Samsara Dashboard or the API at any time. Inputs 3-13 are only available on gateways with an attached aux expander. Valid values: `None`, `Emergency Lights`, `Emergency Alarm`, `Stop Paddle`, `Power Take-Off`, `Plow`, `Sweeper`, `Salter`, `Reefer`, `Door`, `Boom`, `Auxiliary Engine`, `Generator`, `Eight-Way Lights`, `Panic Button`, `Privacy Button`, `Front Axle Drive`, `Weight Sensor`, `Other`, `Secondary Fuel Source`, `(ECU) Power Take-Off`.
    
</dd>
</dl>

<dl>
<dd>

**engineHours:** `Optional<Long>` — A manual override for the vehicle's engine hours. You may only override a vehicle's engine hours if it cannot be read from on-board diagnostics. When you provide a manual engine hours override, Samsara will begin updating a vehicle's engine hours based on when the Samsara Vehicle Gateway is recieving power or not. Setting the value to 0 will unset the manual engine hours.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — The <a href="/docs/external-ids" target="_blank">external IDs</a> for the given object.
    
</dd>
</dl>

<dl>
<dd>

**gatewaySerial:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**grossVehicleWeight:** `Optional<GrossVehicleWeight>` 
    
</dd>
</dl>

<dl>
<dd>

**harshAccelerationSettingType:** `Optional<UpdateVehicleRequestHarshAccelerationSettingType>` — The harsh acceleration setting type. This setting influences the acceleration sensitivity from which a <a href="https://kb.samsara.com/hc/en-us/articles/360043051792-Safety-Event-Overview" target="_blank">harsh event</a> is triggered. **By default**, this setting is inferred by the Samsara Vehicle Gateway from the engine computer, but it may be set or updated through the Samsara Dashboard or the API at any time. If set to `off`, then no acceleration based harsh events are triggered for the vehicle. Valid values: `passengerCar`, `lightTruck`, `heavyDuty`, `off`, `automatic`.
    
</dd>
</dl>

<dl>
<dd>

**licensePlate:** `Optional<String>` — The license plate of the Vehicle. **By default**: empty. Can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The human-readable name of the Vehicle. This is set by a fleet administrator and will appear in both Samsara’s cloud dashboard as well as the Samsara Driver mobile app. **By default**, this name is the serial number of the Samsara Vehicle Gateway. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**notes:** `Optional<String>` — These are generic notes about the Vehicle. Empty by default. Can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**odometerMeters:** `Optional<Long>` — A manual override for the vehicle's odometer. You may only override a vehicle's odometer if it cannot be read from on-board diagnostics. When you provide a manual odometer override, Samsara will begin updating a vehicle's odometer using GPS distance traveled since this override was set. See <a href="https://kb.samsara.com/hc/en-us/articles/115005273667" target="_blank">here</a> for more details.
    
</dd>
</dl>

<dl>
<dd>

**staticAssignedDriverId:** `Optional<String>` — ID for the static assigned driver of the vehicle. Setting the value to 0 will unassign the current driver.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` — An array of IDs of tags to associate with this vehicle. If your access to the API is scoped by one or more tags, this field is required to pass in.
    
</dd>
</dl>

<dl>
<dd>

**vehicleRegulationMode:** `Optional<VehicleRegulationMode>` 
    
</dd>
</dl>

<dl>
<dd>

**vehicleType:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**vin:** `Optional<String>` — The VIN of the Vehicle. Most of the time, this will be automatically read from the engine computer by the Samsara Vehicle Gateway. It will be empty if it cannot be read. It can be set or updated through the Samsara Dashboard or the API at any time.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Vehicle Locations
<details><summary><code>client.vehicleLocations.getVehicleLocations() -> VehicleLocationsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

***NOTE: The Vehicle Locations API is an older API that does not combine GPS data with onboard diagnostics. Try our new [Vehicle Stats API](ref:getvehiclestats) instead.***

Returns the last known location of all vehicles at the given `time`. If no `time` is specified, the current time is used. This can be optionally filtered by tags or specific vehicle IDs.

Related guide: <a href="/docs/vehicle-locations-1" target="_blank">Vehicle Locations</a>. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Vehicle Statistics** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vehicleLocations().getVehicleLocations(
    GetVehicleLocationsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**time:** `Optional<String>` — A filter on the data that returns the last known data points with timestamps less than or equal to this value. Defaults to now if not provided. Must be a string in RFC 3339 format. Millisecond precision and timezones are supported. (Example: `2020-01-27T07:06:25Z`).
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — A filter on the data based on this comma-separated list of vehicle IDs. Example: `vehicleIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.vehicleLocations.getVehicleLocationsFeed() -> VehicleLocationsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

***NOTE: The Vehicle Locations API is an older API that does not combine GPS data with onboard diagnostics. Try our new [Vehicle Stats API](ref:getvehiclestatsfeed) instead.***

Follow a continuous feed of all vehicle locations from Samsara Vehicle Gateways.

Your first call to this endpoint will provide you with the most recent location for each vehicle and a `pagination` object that contains an `endCursor`.

You can provide the `endCursor` to the `after` parameter of this endpoint to get location updates since that `endCursor`. 

If `hasNextPage` is `false`, no updates are readily available yet. We'd suggest waiting a minimum of 5 seconds before requesting updates.

Related guide: <a href="/docs/vehicle-locations-1" target="_blank">Vehicle Locations</a>. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Vehicle Statistics** under the Vehicle category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vehicleLocations().getVehicleLocationsFeed(
    GetVehicleLocationsFeedRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — A filter on the data based on this comma-separated list of vehicle IDs. Example: `vehicleIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.vehicleLocations.getVehicleLocationsHistory() -> VehicleLocationsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

***NOTE: The Vehicle Locations API is an older API that does not combine GPS data with onboard diagnostics. Try our new [Vehicle Stats API](ref:getvehiclestatshistory) instead.***

Returns all known vehicle locations during the given time range. This can be optionally filtered by tags or specific vehicle IDs.

Related guide: <a href="/docs/vehicle-locations-1" target="_blank">Vehicle Locations</a>. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Vehicle Statistics** under the Vehicle category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vehicleLocations().getVehicleLocationsHistory(
    GetVehicleLocationsHistoryRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — A filter on the data based on this comma-separated list of vehicle IDs. Example: `vehicleIds=1234,5678`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Vehicle Stats
<details><summary><code>client.vehicleStats.getVehicleStats() -> VehicleStatsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the last known stats of all vehicles at the given `time`. If no `time` is specified, the current time is used.

Related guide: <a href="/docs/telematics" target="_blank">Telematics</a>. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Vehicle Statistics** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vehicleStats().getVehicleStats(
    GetVehicleStatsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**time:** `Optional<String>` — A filter on the data that returns the last known data points with timestamps less than or equal to this value. Defaults to now if not provided. Must be a string in RFC 3339 format. Millisecond precision and timezones are supported. (Example: `2020-01-27T07:06:25Z`).
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — A filter on the data based on this comma-separated list of vehicle IDs. Example: `vehicleIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**types:** `Optional<GetVehicleStatsRequestTypesItem>` 

The stat types you want this endpoint to return information on. See also the <a href="/docs/telematics#query-parameters" target="_blank">Telematics</a> guide for more details.

You may list ***up to 3*** types using comma-separated format. For example: `types=gps,engineStates,obdOdometerMeters`.

*Note:* `auxInput3`-`auxInput10` count as a single type against the limit of 3. For example, you could list `types=engineStates,obdOdometerMeters,auxInput3,auxInput4` because `auxInput3` and `auxInput4` count as a single stat type. `auxInput1` and `auxInput2` still count as their own individual types.

- `ambientAirTemperatureMilliC`: The ambient air temperature reading in millidegree Celsius.
- `auxInput1`-`auxInput13`: Stat events from the <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary inputs</a> for the vehicle.
- `barometricPressurePa`: The barometric pressure reading in pascals.
- `batteryMilliVolts`: The vehicle battery voltage reading.
- `defLevelMilliPercent`: The Diesel Exhaust Fluid (DEF) level in milli percentage points (e.g. `99001`, `49999`, etc).
- `ecuSpeedMph`: The speed of the engine in miles per hour according to the ECU.
- `engineCoolantTemperatureMilliC`: The engine coolant temperature reading in millidegree Celsius.
- `engineImmobilizer`: The state of the engine immobilizer - Valid values: `ignition_disabled`, `ignition_enabled`. This stat type will only return states of our first Engine Immobilizer Hardware (ACC-EI). Please use <a href="https://developers.samsara.com/reference/getengineimmobilizerstates" target="_blank">Get engine immobilizer states</a> to get states for both Engine Immobilizer Hardware versions (incl. HW-EI21).
- `engineLoadPercent`: The engine load in percentage points (e.g. `99`, `50`, etc).
- `engineOilPressureKPa`: The engine oil pressure reading in kilopascals.
- `engineRpm`: The revolutions per minute of the engine.
- `engineStates`: The state of the engine (`Off`, `On`, `Idle`).
- `faultCodes`: The diagnostic fault codes for the vehicle.
- `fuelPercents`: The engine fuel level in percentage points (e.g. `99`, `50`, etc).
- `fuelConsumedMilliliters`: The cumulative fuel consumption in milliliters for vehicles. Cumulative values always increase. This includes all fuel consumption reported by vehicles without filtering of invalid data points. For filtered fuel consumption that matches the Fuel & Energy Report, please use <a href="https://developers.samsara.com/reference/getfuelenergyvehiclereports" target="_blank">the Fuel and Energy API</a>.
- `gps`: GPS data including lat/long, heading, speed, address book entry (if exists), and a reverse geocoded address.
- `gpsDistanceMeters`: The distance the vehicle has traveled since the gateway was installed based on GPS calculations.
- `gpsOdometerMeters`: Odometer reading provided by GPS calculations when OBD odometer cannot be pulled automatically. You must provide a manual odometer reading before this value is updated. Manual odometer readings can be provided via the [PATCH /fleet/vehicles/{id}](ref:updatevehicle) endpoint or through the <a href="https://kb.samsara.com/hc/en-us/articles/115005273667-Editing-Odometer-Reading" target="_blank">cloud dasbhoard</a>. Odometer readings that are manually set will update as GPS trip data is gathered. Try combining with `obdOdometerMeters`.
- `idlingDurationMilliseconds`: The cumulative idling duration in milliseconds. Cumulative values always increase. For filtering of idling duration please use [the Idling Events API](https://developers.samsara.com/reference/getvehicleidlingreports).
- `intakeManifoldTemperatureMilliC`: The intake manifold temperature reading in millidegree Celsius.
- `nfcCardScans`: ID card scans.
- `obdEngineSeconds`: The cumulative number of seconds the engine has run according to onboard diagnostics. When onboard diagnostic data is unavailable, ignition-based engine data (for ELD vehicles) will be used as a proxy to accumulate engine hours.
- `obdOdometerMeters`: The odometer reading according to onboard diagnostics. If Samsara does not have diagnostic coverage for a particular vehicle, the value for this stat type will be omitted.
- `syntheticEngineSeconds`: The cumulative number of seconds the engine has run estimated based on when the engine is running. Please note that this method <a href="https://kb.samsara.com/hc/en-us/articles/360043552511-Synthetic-Engine-Hours" target="_blank">requires the addition of a baseline</a> to trigger accumulation.
- `evStateOfChargeMilliPercent`: Milli percent State of Charge for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evChargingStatus`: Charging status for electric and hybrid vehicles. Not all EV and HEVs may report this field. Statuses: unknown - 0, not charging - 1, charging - 2.
- `evChargingEnergyMicroWh`: Charging energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evChargingVoltageMilliVolt`: Charging voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evChargingCurrentMilliAmp`: Charging current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evConsumedEnergyMicroWh`: Consumed energy (including regenerated) for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evRegeneratedEnergyMicroWh`: Regenerated energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evBatteryVoltageMilliVolt`: Battery voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evBatteryCurrentMilliAmp`: Battery current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evBatteryStateOfHealthMilliPercent`: Milli percent battery state of health for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evAverageBatteryTemperatureMilliCelsius`: Battery temperature for electric and hybrid vehicles in milli celsius. Not all EV and HEVs may report this field.
- `evDistanceDrivenMeters`: Electric distance driven for electric and hybrid vehicles in meters. Not all EV and HEVs may report this field.
- `spreaderLiquidRate`: Liquid spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderGranularRate`: Granular spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderPrewetRate`: Prewet spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderAirTemp`: Air (ambient) temperature in milli celsius reading from material spreader.
- `spreaderRoadTemp`: Road temperature reading in milli celsius from material spreader.
- `spreaderOnState`: Whether vehicle spreader is enabled.
- `spreaderActive`: Whether vehicle is actively spreading any material.
- `spreaderBlastState`: Whether vehicle is actively spreading material in ‘blast mode’.
- `spreaderGranularName`: Name of most recent type of granular material spread, read from the material spreader.
- `spreaderPrewetName`: Name of most recent type of prewet material spread, read from the material spreader.
- `spreaderLiquidName`: Name of most recent type of liquid material spread, read from the material spreader.
- `spreaderPlowStatus`: Snow plow status (`Up` or `Down`), as read from the material spreader. Note: this is separate from plow status defined via auxInput.
- `seatbeltDriver`: Seatbelt Driver Status as read from the vehicle. `Buckled` or `Unbuckled`. (Beta only)
- `tellTales`: Tell tales status as read from the vehicle.
- `ecuDoorStatus`: Status of doors, sourced from ECU or from AUX port assigned to a Door label if diagnostic from ECU is not available. Either `Closed`, `Open` or `Unknown`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.vehicleStats.getVehicleStatsFeed() -> VehicleStatsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Follow a feed of vehicle stats. 

Your first call to this endpoint will provide you with the most recent stats for each vehicle and an `endCursor`.

You can the provide the `endCursor` value to the `after` query parameter to get all updates since the last call you made.

If `hasNextPage` is `false`, no new data is immediately available. You should wait a minimum of 5 seconds making a subsequent request.

Related guide: <a href="/docs/telematics" target="_blank">Telematics</a>. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Vehicle Statistics** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vehicleStats().getVehicleStatsFeed(
    GetVehicleStatsFeedRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — A filter on the data based on this comma-separated list of vehicle IDs. Example: `vehicleIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**types:** `Optional<GetVehicleStatsFeedRequestTypesItem>` 

The stat types you want this endpoint to return information on. See also the <a href="/docs/telematics#query-parameters" target="_blank">Telematics</a> guide for more details.

You may list ***up to 3*** types using comma-separated format. For example: `types=gps,engineStates,obdOdometerMeters`.

*Note:* `auxInput3`-`auxInput10` count as a single type against the limit of 3. For example, you could list `types=engineStates,obdOdometerMeters,auxInput3,auxInput4` because `auxInput3` and `auxInput4` count as a single stat type. `auxInput1` and `auxInput2` still count as their own individual types.

- `ambientAirTemperatureMilliC`: The ambient air temperature reading in millidegree Celsius.
- `auxInput1`-`auxInput13`: Stat events from the <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary inputs</a> for the vehicle.
- `barometricPressurePa`: The barometric pressure reading in pascals.
- `batteryMilliVolts`: The vehicle battery voltage reading.
- `defLevelMilliPercent`: The Diesel Exhaust Fluid (DEF) level in milli percentage points (e.g. `99001`, `49999`, etc).
- `ecuSpeedMph`: The speed of the engine in miles per hour according to the ECU.
- `engineCoolantTemperatureMilliC`: The engine coolant temperature reading in millidegree Celsius.
- `engineImmobilizer`: The state of the engine immobilizer - Valid values: `ignition_disabled`, `ignition_enabled`. This stat type will only return states of our first Engine Immobilizer Hardware (ACC-EI). Please use <a href="https://developers.samsara.com/reference/getengineimmobilizerstates" target="_blank">Get engine immobilizer states</a> to get states for both Engine Immobilizer Hardware versions (incl. HW-EI21).
- `engineLoadPercent`: The engine load in percentage points (e.g. `99`, `50`, etc).
- `engineOilPressureKPa`: The engine oil pressure reading in kilopascals.
- `engineRpm`: The revolutions per minute of the engine.
- `engineStates`: The state of the engine (`Off`, `On`, `Idle`).
- `faultCodes`: The diagnostic fault codes for the vehicle.
- `fuelPercents`: The engine fuel level in percentage points (e.g. `99`, `50`, etc).
- `fuelConsumedMilliliters`: The cumulative fuel consumption in milliliters for vehicles. Cumulative values always increase. This includes all fuel consumption reported by vehicles without filtering of invalid data points. For filtered fuel consumption that matches the Fuel & Energy Report, please use <a href="https://developers.samsara.com/reference/getfuelenergyvehiclereports" target="_blank">the Fuel and Energy API</a>.
- `gps`: GPS data including lat/long, heading, speed, address book entry (if exists), and a reverse geocoded address.
- `gpsDistanceMeters`: The distance the vehicle has traveled since the gateway was installed based on GPS calculations.
- `gpsOdometerMeters`: Odometer reading provided by GPS calculations when OBD odometer cannot be pulled automatically. You must provide a manual odometer reading before this value is updated. Manual odometer readings can be provided via the [PATCH /fleet/vehicles/{id}](ref:updatevehicle) endpoint or through the <a href="https://kb.samsara.com/hc/en-us/articles/115005273667-Editing-Odometer-Reading" target="_blank">cloud dasbhoard</a>. Odometer readings that are manually set will update as GPS trip data is gathered. Try combining with `obdOdometerMeters`.
- `idlingDurationMilliseconds`: The cumulative idling duration in milliseconds. Cumulative values always increase. For filtering of idling duration please use [the Idling Events API](https://developers.samsara.com/reference/getvehicleidlingreports).
- `intakeManifoldTemperatureMilliC`: The intake manifold temperature reading in millidegree Celsius.
- `nfcCardScans`: ID card scans.
- `obdEngineSeconds`: The cumulative number of seconds the engine has run according to onboard diagnostics. When onboard diagnostic data is unavailable, ignition-based engine data (for ELD vehicles) will be used as a proxy to accumulate engine hours.
- `obdOdometerMeters`: The odometer reading according to onboard diagnostics. If Samsara does not have diagnostic coverage for a particular vehicle, the value for this stat type will be omitted.
- `syntheticEngineSeconds`: The cumulative number of seconds the engine has run estimated based on when the engine is running. Please note that this method <a href="https://kb.samsara.com/hc/en-us/articles/360043552511-Synthetic-Engine-Hours" target="_blank">requires the addition of a baseline</a> to trigger accumulation.
- `evStateOfChargeMilliPercent`: Milli percent State of Charge for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evChargingStatus`: Charging status for electric and hybrid vehicles. Not all EV and HEVs may report this field. Statuses: unknown - 0, not charging - 1, charging - 2.
- `evChargingEnergyMicroWh`: Charging energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evChargingVoltageMilliVolt`: Charging voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evChargingCurrentMilliAmp`: Charging current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evConsumedEnergyMicroWh`: Consumed energy (including regenerated) for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evRegeneratedEnergyMicroWh`: Regenerated energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evBatteryVoltageMilliVolt`: Battery voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evBatteryCurrentMilliAmp`: Battery current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evBatteryStateOfHealthMilliPercent`: Milli percent battery state of health for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evAverageBatteryTemperatureMilliCelsius`: Battery temperature for electric and hybrid vehicles in milli celsius. Not all EV and HEVs may report this field.
- `evDistanceDrivenMeters`: Electric distance driven for electric and hybrid vehicles in meters. Not all EV and HEVs may report this field.
- `spreaderLiquidRate`: Liquid spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderGranularRate`: Granular spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderPrewetRate`: Prewet spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderAirTemp`: Air (ambient) temperature in milli celsius reading from material spreader.
- `spreaderRoadTemp`: Road temperature reading in milli celsius from material spreader.
- `spreaderOnState`: Whether vehicle spreader is enabled.
- `spreaderActive`: Whether vehicle is actively spreading any material.
- `spreaderBlastState`: Whether vehicle is actively spreading material in ‘blast mode’.
- `spreaderGranularName`: Name of most recent type of granular material spread, read from the material spreader.
- `spreaderPrewetName`: Name of most recent type of prewet material spread, read from the material spreader.
- `spreaderLiquidName`: Name of most recent type of liquid material spread, read from the material spreader.
- `spreaderPlowStatus`: Snow plow status (`Up` or `Down`), as read from the material spreader. Note: this is separate from plow status defined via auxInput.
- `seatbeltDriver`: Seatbelt Driver Status as read from the vehicle. `Buckled` or `Unbuckled`. (Beta only)
- `tellTales`: Tell tales status as read from the vehicle.
- `ecuDoorStatus`: Status of doors, sourced from ECU or from AUX port assigned to a Door label if diagnostic from ECU is not available. Either `Closed`, `Open` or `Unknown`.
    
</dd>
</dl>

<dl>
<dd>

**decorations:** `Optional<GetVehicleStatsFeedRequestDecorationsItem>` 

Decorations to add to the primary stats listed in the `types` parameter. For example, if you wish to know the vehicle's location whenever the engine changes state, you may set `types=engineStates&decorations=gps`.

You may list ***up to 2*** decorations using comma-separated format. If multiple stats are listed in the `types` parameter, the decorations will be added to each one. For example: `types=engineStates,obdOdometerMeters,faultCodes&decorations=gps,fuelPercents` will list GPS and fuel decorations for each engine state change, each odometer reading, and each fault code. See the <a href="/docs/telematics#query-parameters" target="_blank">Telematics</a> guide for more details.

Note that decorations may significantly increase the response payload size.

- `ambientAirTemperatureMilliC`: The ambient air temperature reading in millidegree Celsius.
- `auxInput1`-`auxInput13`: Stat events from the <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary inputs</a> for the vehicle.
- `batteryMilliVolts`: The vehicle battery voltage reading.
- `barometricPressurePa`: The barometric pressure reading in pascals.
- `ecuSpeedMph`: The speed of the engine in miles per hour according to the ECU.
- `engineCoolantTemperatureMilliC`: The engine coolant temperature reading in millidegree Celsius.
- `engineImmobilizer`: The state of the engine immobilizer - Valid values: `ignition_disabled`, `ignition_enabled`. This stat type will only return states of our first Engine Immobilizer Hardware (ACC-EI). Please use <a href="https://developers.samsara.com/reference/getengineimmobilizerstates" target="_blank">Get engine immobilizer states</a> to get states for both Engine Immobilizer Hardware versions (incl. HW-EI21).
- `engineOilPressureKPa`: The engine oil pressure reading in kilopascals.
- `engineLoadPercent`: The engine load in percentage points (e.g. `99`, `50`, etc).
- `engineRpm`: The revolutions per minute of the engine.
- `engineStates`: The state of the engine (`Off`, `On`, `Idle`).
- `faultCodes`: The diagnostic fault codes for the vehicle.
- `fuelPercents`: The engine fuel level in percentage points (e.g. `99`, `50`, etc).
- `fuelConsumedMilliliters`: The cumulative fuel consumption in milliliters for vehicles. Cumulative values always increase. This includes all fuel consumption reported by vehicles without filtering of invalid data points. For filtered fuel consumption that matches the Fuel & Energy Report, please use <a href="https://developers.samsara.com/reference/getfuelenergyvehiclereports" target="_blank">the Fuel and Energy API</a>.
- `gps`: GPS data including lat/long, heading, speed, address book entry (if exists), and a reverse geocoded address.
- `gpsDistanceMeters`: The distance the vehicle has traveled since the gateway was installed based on GPS calculations.
- `idlingDurationMilliseconds`: The cumulative idling duration in milliseconds. Cumulative values always increase. For filtering of idling duration please use <a href="https://developers.samsara.com/reference/getvehicleidlingreports" target="_blank">the Idling Events API</a>.
- `intakeManifoldTemperatureMilliC`: The intake manifold temperature reading in millidegree Celsius.
- `nfcCardScans`: ID card scans.
- `obdEngineSeconds`: The cumulative number of seconds the engine has run according to onboard diagnostics. When onboard diagnostic data is unavailable, ignition-based engine data (for ELD vehicles) will be used as a proxy to accumulate engine hours.
- `obdOdometerMeters`: The odometer reading according to onboard diagnostics. If Samsara does not have diagnostic coverage for a particular vehicle, the value for this stat type will be omitted.
- `syntheticEngineSeconds`: The cumulative number of seconds the engine has run estimated based on when the engine is running. Please note that this method <a href="https://kb.samsara.com/hc/en-us/articles/360043552511-Synthetic-Engine-Hours" target="_blank">requires the addition of a baseline</a> to trigger accumulation.
- `evStateOfChargeMilliPercent`: Milli percent State of Charge for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evChargingStatus`: Charging status for electric and hybrid vehicles. Not all EV and HEVs may report this field. Statuses: unknown - 0, not charging - 1, charging - 2.
- `evChargingEnergyMicroWh`: Charging energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evChargingVoltageMilliVolt`: Charging voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evChargingCurrentMilliAmp`: Charging current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evConsumedEnergyMicroWh`: Consumed energy (including regenerated) for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evRegeneratedEnergyMicroWh`: Regenerated energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evBatteryVoltageMilliVolt`: Battery voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evBatteryCurrentMilliAmp`: Battery current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evBatteryStateOfHealthMilliPercent`: Milli percent battery state of health for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evAverageBatteryTemperatureMilliCelsius`: Battery temperature for electric and hybrid vehicles in milli celsius. Not all EV and HEVs may report this field.
- `evDistanceDrivenMeters`: Electric distance driven for electric and hybrid vehicles in meters. Not all EV and HEVs may report this field.
- `spreaderLiquidRate`: Liquid spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderGranularRate`: Granular spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderPrewetRate`: Prewet spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderAirTemp`: Air (ambient) temperature in milli celsius reading from material spreader.
- `spreaderRoadTemp`: Road temperature reading in milli celsius from material spreader.
- `spreaderOnState`: Whether vehicle spreader is enabled.
- `spreaderActive`: Whether vehicle is actively spreading any material.
- `spreaderBlastState`: Whether vehicle is actively spreading material in 'blast mode'.
- `spreaderGranularName`: Name of most recent type of granular material spread, read from the material spreader.
- `spreaderPrewetName`: Name of most recent type of prewet material spread, read from the material spreader.
- `spreaderLiquidName`: Name of most recent type of liquid material spread, read from the material spreader.
- `spreaderPlowStatus`: Snow plow status (`Up` or `Down`), as read from the material spreader. Note: this is separate from plow status defined via auxInput.
- `seatbeltDriver`: Seatbelt Driver Status as read from the vehicle. `Buckled` or `Unbuckled`. (Beta only)
- `tellTales`: Tell tales status as read from the vehicle.
- `ecuDoorStatus`: Status of doors, sourced from ECU or from AUX port assigned to a Door label if diagnostic from ECU is not available. Either `Closed`, `Open` or `Unknown`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.vehicleStats.getVehicleStatsHistory() -> VehicleStatsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns vehicle stats during the given time range for all vehicles. This can be optionally filtered by tags or specific vehicle IDs.

Related guide: <a href="/docs/telematics" target="_blank">Telematics</a>. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Vehicle Statistics** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vehicleStats().getVehicleStatsHistory(
    GetVehicleStatsHistoryRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**vehicleIds:** `Optional<String>` — A filter on the data based on this comma-separated list of vehicle IDs. Example: `vehicleIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**types:** `Optional<GetVehicleStatsHistoryRequestTypesItem>` 

The stat types you want this endpoint to return information on. See also the <a href="/docs/telematics#query-parameters" target="_blank">Telematics</a> guide for more details.

You may list ***up to 3*** types using comma-separated format. For example: `types=gps,engineStates,obdOdometerMeters`.

*Note:* `auxInput3`-`auxInput10` count as a single type against the limit of 3. For example, you could list `types=engineStates,obdOdometerMeters,auxInput3,auxInput4` because `auxInput3` and `auxInput4` count as a single stat type. `auxInput1` and `auxInput2` still count as their own individual types.

- `ambientAirTemperatureMilliC`: The ambient air temperature reading in millidegree Celsius.
- `auxInput1`-`auxInput13`: Stat events from the <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary inputs</a> for the vehicle.
- `barometricPressurePa`: The barometric pressure reading in pascals.
- `batteryMilliVolts`: The vehicle battery voltage reading.
- `defLevelMilliPercent`: The Diesel Exhaust Fluid (DEF) level in milli percentage points (e.g. `99001`, `49999`, etc).
- `ecuSpeedMph`: The speed of the engine in miles per hour according to the ECU.
- `engineCoolantTemperatureMilliC`: The engine coolant temperature reading in millidegree Celsius.
- `engineImmobilizer`: The state of the engine immobilizer - Valid values: `ignition_disabled`, `ignition_enabled`. This stat type will only return states of our first Engine Immobilizer Hardware (ACC-EI). Please use <a href="https://developers.samsara.com/reference/getengineimmobilizerstates" target="_blank">Get engine immobilizer states</a> to get states for both Engine Immobilizer Hardware versions (incl. HW-EI21).
- `engineLoadPercent`: The engine load in percentage points (e.g. `99`, `50`, etc).
- `engineOilPressureKPa`: The engine oil pressure reading in kilopascals.
- `engineRpm`: The revolutions per minute of the engine.
- `engineStates`: The state of the engine (`Off`, `On`, `Idle`).
- `faultCodes`: The diagnostic fault codes for the vehicle.
- `fuelPercents`: The engine fuel level in percentage points (e.g. `99`, `50`, etc).
- `fuelConsumedMilliliters`: The cumulative fuel consumption in milliliters for vehicles. Cumulative values always increase. This includes all fuel consumption reported by vehicles without filtering of invalid data points. For filtered fuel consumption that matches the Fuel & Energy Report, please use <a href="https://developers.samsara.com/reference/getfuelenergyvehiclereports" target="_blank">the Fuel and Energy API</a>.
- `gps`: GPS data including lat/long, heading, speed, address book entry (if exists), and a reverse geocoded address.
- `gpsDistanceMeters`: The distance the vehicle has traveled since the gateway was installed based on GPS calculations.
- `gpsOdometerMeters`: Odometer reading provided by GPS calculations when OBD odometer cannot be pulled automatically. You must provide a manual odometer reading before this value is updated. Manual odometer readings can be provided via the [PATCH /fleet/vehicles/{id}](ref:updatevehicle) endpoint or through the <a href="https://kb.samsara.com/hc/en-us/articles/115005273667-Editing-Odometer-Reading" target="_blank">cloud dasbhoard</a>. Odometer readings that are manually set will update as GPS trip data is gathered. Try combining with `obdOdometerMeters`.
- `idlingDurationMilliseconds`: The cumulative idling duration in milliseconds. Cumulative values always increase. For filtering of idling duration please use [the Idling Events API](https://developers.samsara.com/reference/getvehicleidlingreports).
- `intakeManifoldTemperatureMilliC`: The intake manifold temperature reading in millidegree Celsius.
- `nfcCardScans`: ID card scans.
- `obdEngineSeconds`: The cumulative number of seconds the engine has run according to onboard diagnostics. When onboard diagnostic data is unavailable, ignition-based engine data (for ELD vehicles) will be used as a proxy to accumulate engine hours.
- `obdOdometerMeters`: The odometer reading according to onboard diagnostics. If Samsara does not have diagnostic coverage for a particular vehicle, the value for this stat type will be omitted.
- `syntheticEngineSeconds`: The cumulative number of seconds the engine has run estimated based on when the engine is running. Please note that this method <a href="https://kb.samsara.com/hc/en-us/articles/360043552511-Synthetic-Engine-Hours" target="_blank">requires the addition of a baseline</a> to trigger accumulation.
- `evStateOfChargeMilliPercent`: Milli percent State of Charge for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evChargingStatus`: Charging status for electric and hybrid vehicles. Not all EV and HEVs may report this field. Statuses: unknown - 0, not charging - 1, charging - 2.
- `evChargingEnergyMicroWh`: Charging energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evChargingVoltageMilliVolt`: Charging voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evChargingCurrentMilliAmp`: Charging current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evConsumedEnergyMicroWh`: Consumed energy (including regenerated) for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evRegeneratedEnergyMicroWh`: Regenerated energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evBatteryVoltageMilliVolt`: Battery voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evBatteryCurrentMilliAmp`: Battery current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evBatteryStateOfHealthMilliPercent`: Milli percent battery state of health for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evAverageBatteryTemperatureMilliCelsius`: Battery temperature for electric and hybrid vehicles in milli celsius. Not all EV and HEVs may report this field.
- `evDistanceDrivenMeters`: Electric distance driven for electric and hybrid vehicles in meters. Not all EV and HEVs may report this field.
- `spreaderLiquidRate`: Liquid spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderGranularRate`: Granular spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderPrewetRate`: Prewet spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderAirTemp`: Air (ambient) temperature in milli celsius reading from material spreader.
- `spreaderRoadTemp`: Road temperature reading in milli celsius from material spreader.
- `spreaderOnState`: Whether vehicle spreader is enabled.
- `spreaderActive`: Whether vehicle is actively spreading any material.
- `spreaderBlastState`: Whether vehicle is actively spreading material in ‘blast mode’.
- `spreaderGranularName`: Name of most recent type of granular material spread, read from the material spreader.
- `spreaderPrewetName`: Name of most recent type of prewet material spread, read from the material spreader.
- `spreaderLiquidName`: Name of most recent type of liquid material spread, read from the material spreader.
- `spreaderPlowStatus`: Snow plow status (`Up` or `Down`), as read from the material spreader. Note: this is separate from plow status defined via auxInput.
- `seatbeltDriver`: Seatbelt Driver Status as read from the vehicle. `Buckled` or `Unbuckled`. (Beta only)
- `tellTales`: Tell tales status as read from the vehicle.
- `ecuDoorStatus`: Status of doors, sourced from ECU or from AUX port assigned to a Door label if diagnostic from ECU is not available. Either `Closed`, `Open` or `Unknown`.
    
</dd>
</dl>

<dl>
<dd>

**decorations:** `Optional<GetVehicleStatsHistoryRequestDecorationsItem>` 

Decorations to add to the primary stats listed in the `types` parameter. For example, if you wish to know the vehicle's location whenever the engine changes state, you may set `types=engineStates&decorations=gps`.

You may list ***up to 2*** decorations using comma-separated format. If multiple stats are listed in the `types` parameter, the decorations will be added to each one. For example: `types=engineStates,obdOdometerMeters,faultCodes&decorations=gps,fuelPercents` will list GPS and fuel decorations for each engine state change, each odometer reading, and each fault code. See the <a href="/docs/telematics#query-parameters" target="_blank">Telematics</a> guide for more details.

Note that decorations may significantly increase the response payload size.

- `ambientAirTemperatureMilliC`: The ambient air temperature reading in millidegree Celsius.
- `auxInput1`-`auxInput13`: Stat events from the <a href="https://kb.samsara.com/hc/en-us/articles/360043040512-Auxiliary-Inputs" target="_blank">auxiliary inputs</a> for the vehicle.
- `batteryMilliVolts`: The vehicle battery voltage reading.
- `barometricPressurePa`: The barometric pressure reading in pascals.
- `ecuSpeedMph`: The speed of the engine in miles per hour according to the ECU.
- `engineCoolantTemperatureMilliC`: The engine coolant temperature reading in millidegree Celsius.
- `engineImmobilizer`: The state of the engine immobilizer - Valid values: `ignition_disabled`, `ignition_enabled`. This stat type will only return states of our first Engine Immobilizer Hardware (ACC-EI). Please use <a href="https://developers.samsara.com/reference/getengineimmobilizerstates" target="_blank">Get engine immobilizer states</a> to get states for both Engine Immobilizer Hardware versions (incl. HW-EI21).
- `engineOilPressureKPa`: The engine oil pressure reading in kilopascals.
- `engineLoadPercent`: The engine load in percentage points (e.g. `99`, `50`, etc).
- `engineRpm`: The revolutions per minute of the engine.
- `engineStates`: The state of the engine (`Off`, `On`, `Idle`).
- `faultCodes`: The diagnostic fault codes for the vehicle.
- `fuelPercents`: The engine fuel level in percentage points (e.g. `99`, `50`, etc).
- `fuelConsumedMilliliters`: The cumulative fuel consumption in milliliters for vehicles. Cumulative values always increase. This includes all fuel consumption reported by vehicles without filtering of invalid data points. For filtered fuel consumption that matches the Fuel & Energy Report, please use <a href="https://developers.samsara.com/reference/getfuelenergyvehiclereports" target="_blank">the Fuel and Energy API</a>.
- `gps`: GPS data including lat/long, heading, speed, address book entry (if exists), and a reverse geocoded address.
- `gpsDistanceMeters`: The distance the vehicle has traveled since the gateway was installed based on GPS calculations.
- `idlingDurationMilliseconds`: The cumulative idling duration in milliseconds. Cumulative values always increase. For filtering of idling duration please use <a href="https://developers.samsara.com/reference/getvehicleidlingreports" target="_blank">the Idling Events API</a>.
- `intakeManifoldTemperatureMilliC`: The intake manifold temperature reading in millidegree Celsius.
- `nfcCardScans`: ID card scans.
- `obdEngineSeconds`: The cumulative number of seconds the engine has run according to onboard diagnostics. When onboard diagnostic data is unavailable, ignition-based engine data (for ELD vehicles) will be used as a proxy to accumulate engine hours.
- `obdOdometerMeters`: The odometer reading according to onboard diagnostics. If Samsara does not have diagnostic coverage for a particular vehicle, the value for this stat type will be omitted.
- `syntheticEngineSeconds`: The cumulative number of seconds the engine has run estimated based on when the engine is running. Please note that this method <a href="https://kb.samsara.com/hc/en-us/articles/360043552511-Synthetic-Engine-Hours" target="_blank">requires the addition of a baseline</a> to trigger accumulation.
- `evStateOfChargeMilliPercent`: Milli percent State of Charge for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evChargingStatus`: Charging status for electric and hybrid vehicles. Not all EV and HEVs may report this field. Statuses: unknown - 0, not charging - 1, charging - 2.
- `evChargingEnergyMicroWh`: Charging energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evChargingVoltageMilliVolt`: Charging voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evChargingCurrentMilliAmp`: Charging current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evConsumedEnergyMicroWh`: Consumed energy (including regenerated) for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evRegeneratedEnergyMicroWh`: Regenerated energy for electric and hybrid vehicles in microwatt hours. Not all EV and HEVs may report this field.
- `evBatteryVoltageMilliVolt`: Battery voltage for electric and hybrid vehicles in milli volts. Not all EV and HEVs may report this field.
- `evBatteryCurrentMilliAmp`: Battery current for electric and hybrid vehicles in milli amps. Not all EV and HEVs may report this field.
- `evBatteryStateOfHealthMilliPercent`: Milli percent battery state of health for electric and hybrid vehicles. Not all EV and HEVs may report this field.
- `evAverageBatteryTemperatureMilliCelsius`: Battery temperature for electric and hybrid vehicles in milli celsius. Not all EV and HEVs may report this field.
- `evDistanceDrivenMeters`: Electric distance driven for electric and hybrid vehicles in meters. Not all EV and HEVs may report this field.
- `spreaderLiquidRate`: Liquid spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderGranularRate`: Granular spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderPrewetRate`: Prewet spread rate reading in milliliters per meter, read from the material spreader. Unfiltered live stats are supplied as-read from the Material Spreader unit. Readings do not consider total spread rate(s) over time or distance.
- `spreaderAirTemp`: Air (ambient) temperature in milli celsius reading from material spreader.
- `spreaderRoadTemp`: Road temperature reading in milli celsius from material spreader.
- `spreaderOnState`: Whether vehicle spreader is enabled.
- `spreaderActive`: Whether vehicle is actively spreading any material.
- `spreaderBlastState`: Whether vehicle is actively spreading material in 'blast mode'.
- `spreaderGranularName`: Name of most recent type of granular material spread, read from the material spreader.
- `spreaderPrewetName`: Name of most recent type of prewet material spread, read from the material spreader.
- `spreaderLiquidName`: Name of most recent type of liquid material spread, read from the material spreader.
- `spreaderPlowStatus`: Snow plow status (`Up` or `Down`), as read from the material spreader. Note: this is separate from plow status defined via auxInput.
- `seatbeltDriver`: Seatbelt Driver Status as read from the vehicle. `Buckled` or `Unbuckled`. (Beta only)
- `tellTales`: Tell tales status as read from the vehicle.
- `ecuDoorStatus`: Status of doors, sourced from ECU or from AUX port assigned to a Door label if diagnostic from ECU is not available. Either `Closed`, `Open` or `Unknown`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Forms
<details><summary><code>client.forms.getFormSubmissions() -> FormSubmissionsGetFormSubmissionsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all form submissions data for the specified list of IDs.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Form Submissions** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.forms().getFormSubmissions(
    GetFormSubmissionsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — A comma-separated list containing up to 100 form submission IDs to filter on. Can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the form submission.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — A comma-separated list of strings indicating whether to return additional information. Valid values: `externalIds`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.forms.postFormSubmission(request) -> FormSubmissionsPostFormSubmissionResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a form submission and assigns it to an individual worker. This endpoint can be used to create an empty or partially complete form submission and assign it to a worker.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Form Submissions** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.forms().postFormSubmission(
    FormSubmissionsPostFormSubmissionRequestBody
        .builder()
        .formTemplate(
            FormTemplateRequestObjectRequestBody
                .builder()
                .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                .revisionId("1214a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                .build()
        )
        .status(FormSubmissionsPostFormSubmissionRequestBodyStatus.NOT_STARTED)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assignedTo:** `Optional<FormSubmissionRequestAssignedToRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**dueAtTime:** `Optional<OffsetDateTime>` — Due date of the form submission. UTC timestamp in RFC 3339 format.
    
</dd>
</dl>

<dl>
<dd>

**fields:** `Optional<List<FormSubmissionRequestFieldInputObjectRequestBody>>` — List of field inputs in a form submission.
    
</dd>
</dl>

<dl>
<dd>

**formTemplate:** `FormTemplateRequestObjectRequestBody` 
    
</dd>
</dl>

<dl>
<dd>

**isRequired:** `Optional<Boolean>` — Indicates whether the worker is required to complete this form or not at a specific route stop. Defaults to `true` if the form is assigned to a user or driver. When true, the worker cannot depart the route stop until this form submission is `submitted`.
    
</dd>
</dl>

<dl>
<dd>

**routeStopId:** `Optional<String>` — ID of the route stop the form submission is assigned to. Must be a unique Samsara ID.
    
</dd>
</dl>

<dl>
<dd>

**status:** `FormSubmissionsPostFormSubmissionRequestBodyStatus` — Status of the form submission.  Valid values: `notStarted`
    
</dd>
</dl>

<dl>
<dd>

**title:** `Optional<String>` — Title of the form submission.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.forms.patchFormSubmission(request) -> FormSubmissionsPatchFormSubmissionResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an instance of a form submission.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Form Submissions** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.forms().patchFormSubmission(
    FormSubmissionsPatchFormSubmissionRequestBody
        .builder()
        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac8")
        .status(FormSubmissionsPatchFormSubmissionRequestBodyStatus.NOT_STARTED)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**approvalDetails:** `Optional<FormSubmissionRequestApprovalDetailsRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**assignedTo:** `Optional<FormSubmissionRequestAssignedToRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**dueAtTime:** `Optional<OffsetDateTime>` — Due date of the form submission. UTC timestamp in RFC 3339 format.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — ID of the form submission.
    
</dd>
</dl>

<dl>
<dd>

**isRequired:** `Optional<Boolean>` — Indicates whether the worker is required to complete this form or not at a specific route stop. Defaults to `true` if the form is assigned to a user or driver. When true, the worker cannot depart the route stop until this form submission is `submitted`.
    
</dd>
</dl>

<dl>
<dd>

**routeStopId:** `Optional<String>` — ID of the route stop the form submission is assigned to. Must be a unique Samsara ID.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<FormSubmissionsPatchFormSubmissionRequestBodyStatus>` — Status of the form submission.  Valid values: `notStarted`, `archived`, `inProgress`, `changesRequested`, `approved`
    
</dd>
</dl>

<dl>
<dd>

**title:** `Optional<String>` — Title of the form submission.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.forms.getFormSubmissionsPdfExports() -> FormSubmissionsGetFormSubmissionsPdfExportsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a PDF export that has already been generated for a form submission.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Form Submissions** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.forms().getFormSubmissionsPdfExports(
    GetFormSubmissionsPdfExportsRequest
        .builder()
        .pdfId("pdfId")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**pdfId:** `String` — ID of the form submission PDF export.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.forms.postFormSubmissionsPdfExports() -> FormSubmissionsPostFormSubmissionsPdfExportsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a PDF export for an existing form submission.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Form Submissions** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.forms().postFormSubmissionsPdfExports(
    PostFormSubmissionsPdfExportsRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the form submission to create a PDF export from.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.forms.getFormSubmissionsStream() -> FormSubmissionsGetFormSubmissionsStreamResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all form submissions data that has been created or modified for your organization based on the time parameters passed in. Results are paginated and are sorted by last modified date. If you include an endTime, the endpoint will return data up until that point (exclusive). If you don’t include an endTime, you can continue to poll the API real-time with the pagination cursor that gets returned on every call.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Form Submissions** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.forms().getFormSubmissionsStream(
    GetFormSubmissionsStreamRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. Value is compared against `updatedAtTime`. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. Value is compared against `updatedAtTime`. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**formTemplateIds:** `Optional<String>` — A comma-separated list containing up to 50 template IDs to filter data to.
    
</dd>
</dl>

<dl>
<dd>

**userIds:** `Optional<String>` — A comma-separated list containing up to 50 user IDs to filter data to.
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — A comma-separated list containing up to 50 user IDs to filter data to.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — A comma-separated list of strings indicating whether to return additional information. Valid values: `externalIds`
    
</dd>
</dl>

<dl>
<dd>

**assignedToRouteStopIds:** `Optional<String>` — A comma-separated list containing up to 50 route stop IDs to filter data to.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.forms.getFormTemplates() -> FormTemplatesGetFormTemplatesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of the organization's form templates for the specified list of IDs. If no IDs are provided, all form templates for the organization will be returned.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Form Submissions** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.forms().getFormTemplates(
    GetFormTemplatesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — A comma-separated list containing up to 100 template IDs to filter on.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Gateways
<details><summary><code>client.gateways.getGateways() -> GatewaysGetGatewaysResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List all gateways

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Gateways** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.gateways().getGateways(
    GetGatewaysRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**models:** `Optional<String>` — Filter by a comma separated list of gateway models.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.gateways.postGateway(request) -> GatewaysPostGatewayResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Activate a new gateway. To activate a device and associate it with your organization, enter its serial number. Each device's serial number can also be found on its label or packaging, or from your order confirmation email. A Not Found error could mean that the serial was not found or it has already been activated

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Gateways** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.gateways().postGateway(
    GatewaysPostGatewayRequestBody
        .builder()
        .serial("GFRV-43N-VGX")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**serial:** `String` — Gateway serial number
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.gateways.deleteGateway(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deactivate a gateway

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Gateways** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.gateways().deleteGateway(
    "id",
    DeleteGatewayRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Gateway serial number
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Hubs
<details><summary><code>client.hubs.listHubCapacities() -> HubCapacitiesListHubCapacitiesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve capacity types for a specific hub.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hubs().listHubCapacities(
    ListHubCapacitiesRequest
        .builder()
        .hubId("hubId")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**hubId:** `String` — The hub identifier
    
</dd>
</dl>

<dl>
<dd>

**capacityIds:** `Optional<String>` — Comma-separated list of capacity IDs for filtering.
    
</dd>
</dl>

<dl>
<dd>

**capacityNames:** `Optional<String>` — Comma-separated list of capacity names for filtering.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<OffsetDateTime>` — Time filter of when the capacity was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — Time filter of when the capacity was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, should be the endCursor from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of objects to return. Default and maximum is 100
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hubs.updateHubLocation(id, request) -> HubLocationsUpdateHubLocationResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update existing location by ID.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hubs().updateHubLocation(
    "id",
    HubLocationsUpdateHubLocationRequestBody
        .builder()
        .data(
            UpdateHubLocationRequestBodyRequestBody
                .builder()
                .address("123 Industrial Blvd, Los Angeles, CA 90210, US")
                .customerLocationId("LOC-123")
                .driverInstructions("sample instructions")
                .isDepot(false)
                .latitude(34.0522)
                .longitude(-118.2437)
                .name("Customer ABC Warehouse")
                .plannerNotes("sample note")
                .serviceTimeSeconds(1800)
                .serviceWindows(
                    Optional.of(
                        Arrays.asList(
                            HubLocationServiceWindowInputRequestBody
                                .builder()
                                .endTime("17:00:00")
                                .startTime("08:00:00")
                                .daysOfWeek(
                                    Arrays.asList("monday", "tuesday", "wednesday", "thursday", "friday")
                                )
                                .build()
                        )
                    )
                )
                .skillsRequired(
                    Optional.of(
                        Arrays.asList("650e8400-e29b-41d4-a716-446655440001")
                    )
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The unique Samsara ID of the hub location to update
    
</dd>
</dl>

<dl>
<dd>

**data:** `UpdateHubLocationRequestBodyRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hubs.listHubLocations() -> HubLocationsListHubLocationsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve locations for a specific hub.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hubs().listHubLocations(
    ListHubLocationsRequest
        .builder()
        .hubId("hubId")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**hubId:** `String` — The hub identifier
    
</dd>
</dl>

<dl>
<dd>

**locationIds:** `Optional<String>` — A comma-separated list of location IDs that can be used for filtering
    
</dd>
</dl>

<dl>
<dd>

**customerLocationIds:** `Optional<String>` — A comma-separated list of customer provided location IDs that can be used for filtering
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<OffsetDateTime>` — Time filter of when the location was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — Time filter of when the location was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, should be the endCursor from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of objects to return. Default and maximum is 100
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hubs.createHubLocations(request) -> HubLocationsCreateHubLocationsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create new locations.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hubs().createHubLocations(
    HubLocationsCreateHubLocationsRequestBody
        .builder()
        .data(
            Arrays.asList(
                HubLocationInputObjectRequestBody
                    .builder()
                    .address("123 Industrial Blvd, Los Angeles, CA 90210, US")
                    .customerLocationId("LOC-123")
                    .hubId("550e8400-e29b-41d4-a716-446655440000")
                    .isDepot(false)
                    .name("Customer ABC Warehouse")
                    .driverInstructions("sample instructions")
                    .latitude(34.0522)
                    .longitude(-118.2437)
                    .plannerNotes("sample note")
                    .serviceTimeSeconds(1800)
                    .serviceWindows(
                        Optional.of(
                            Arrays.asList(
                                HubLocationServiceWindowInputRequestBody
                                    .builder()
                                    .endTime("17:00:00")
                                    .startTime("08:00:00")
                                    .daysOfWeek(
                                        Arrays.asList("monday", "tuesday", "wednesday", "thursday", "friday")
                                    )
                                    .build()
                            )
                        )
                    )
                    .skillsRequired(
                        Optional.of(
                            Arrays.asList("650e8400-e29b-41d4-a716-446655440001")
                        )
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**data:** `List<HubLocationInputObjectRequestBody>` — An array of location objects to be created or updated
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hubs.listHubSkills() -> HubSkillsListHubSkillsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve skills for a specific hub.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hubs().listHubSkills(
    ListHubSkillsRequest
        .builder()
        .hubId("hubId")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**hubId:** `String` — The hub identifier
    
</dd>
</dl>

<dl>
<dd>

**skillIds:** `Optional<String>` — A comma-separated list of skill IDs that can be used for filtering.
    
</dd>
</dl>

<dl>
<dd>

**skillNames:** `Optional<String>` — A comma-separated list of skill namess that can be used for filtering.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<OffsetDateTime>` — Time filter of when the skill was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — Time filter of when the skill was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, should be the endCursor from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of objects to return. Default and maximum is 100
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.hubs.listHubs() -> HubsListHubsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all hubs (planners) in the organization. This endpoint supports pagination and filtering based on hub IDs and update times.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.hubs().listHubs(
    ListHubsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**hubIds:** `Optional<String>` — A comma-separated list of hub IDs for filtering results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<OffsetDateTime>` — Returns hubs updated after the specified time in UTC
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — Returns hubs updated before the specified time in UTC
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, should be the endCursor from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of objects to return. Default and maximum is 100
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Plans
<details><summary><code>client.plans.createHubPlan(request) -> HubPlansCreateHubPlanResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new plan.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.plans().createHubPlan(
    HubPlansCreateHubPlanRequestBody
        .builder()
        .hubId("550e8400-e29b-41d4-a716-446655440000")
        .name("Weekly Plan - Week 15")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**hubId:** `String` — The ID of the hub the plan belongs to
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — The name of the plan
    
</dd>
</dl>

<dl>
<dd>

**shiftStartTime:** `Optional<OffsetDateTime>` — The shift start time for the plan in RFC 3339 format. If not provided, defaults to 9:00 AM on the next business day in the hub's timezone.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.plans.listHubPlans() -> HubPlansListHubPlansResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all plans for a specific hub.

 <b>Rate limit:</b> 10 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.plans().listHubPlans(
    ListHubPlansRequest
        .builder()
        .hubId("hubId")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**hubId:** `String` — The hub identifier
    
</dd>
</dl>

<dl>
<dd>

**planIds:** `Optional<String>` — Comma-separated list of plan IDs for filtering.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<OffsetDateTime>` — Time filter of when the plan was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<OffsetDateTime>` — Time filter of when the plan was updated, in RFC 3339 format
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, should be the endCursor from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Maximum number of objects to return. Default and maximum is 100
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Idling
<details><summary><code>client.idling.getIdlingEvents() -> AdvancedIdlingGetIdlingEventsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get idling events for the requested time duration.

**Note:** The data from this endpoint comes from the new Advanced Idling Report, which provides additional data fields for each idling event such as air temperature, geofence, PTO state and minimum idle time. This endpoint includes data from January 1, 2024. If you require additional historical data, you can access it via the [vehicle idling reports API](https://developers.samsara.com/reference/getvehicleidlingreports).

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Idling** under the Fuel & Energy category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.idling().getIdlingEvents(
    GetIdlingEventsRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` — The start of the time range for filtering idling events in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-11T19:00:00Z, 2015-09-12T14:00:00-04:00). Returns events that begin at or after this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — The end of the time range for filtering idling events in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:00:00Z, 2015-09-15T14:00:00-04:00). Returns events that begin before this timestamp.
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — A filter on the data based on this comma-separated list of asset IDs. Asset IDs only include vehicle IDs at this time.
    
</dd>
</dl>

<dl>
<dd>

**operatorIds:** `Optional<String>` — A filter on the data based on this comma-separated list of operator IDs. Operator IDs only include driver IDs at this time.
    
</dd>
</dl>

<dl>
<dd>

**ptoState:** `Optional<GetIdlingEventsRequestPtoState>` — A filter on the data on this PTO (Power Take-Off) state. If no specific state is provided, data including any state will be included.  Valid values: `active`, `inactive`
    
</dd>
</dl>

<dl>
<dd>

**minAirTemperatureMillicelsius:** `Optional<Long>` — A filter on the data based on the minimum value of air temperature in millicelsius. The acceptable range for this value is between -20,000 and 50,000 millicelsius.
    
</dd>
</dl>

<dl>
<dd>

**maxAirTemperatureMillicelsius:** `Optional<Long>` — A filter on the data based on the maximum value of air temperature in millicelsius. The acceptable range for this value is between -20,000 and 50,000 millicelsius.
    
</dd>
</dl>

<dl>
<dd>

**excludeEventsWithUnknownAirTemperature:** `Optional<Boolean>` — A filter on the data based on unknown air temperature value.
    
</dd>
</dl>

<dl>
<dd>

**minDurationMilliseconds:** `Optional<Long>` — A filter on the data based on the minimum value of Idling duration in milliseconds. The acceptable range for this value is between 2 minutes and 24 hours.
    
</dd>
</dl>

<dl>
<dd>

**maxDurationMilliseconds:** `Optional<Long>` — A filter on the data based on the maximum value of Idling duration in milliseconds. The acceptable range for this value is between 2 minutes and 24 hours.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Tag IDs only include vehicle IDs at this time.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs. Parent tag IDs only include vehicle IDs at this time.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 200 objects.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Industrial
<details><summary><code>client.industrial.getIndustrialAssets() -> ListIndustrialAssetsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List all assets in the organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().getIndustrialAssets(
    GetIndustrialAssetsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — A comma-separated list of industrial asset UUIDs. Example: `assetIds=076efac2-83b5-47aa-ba36-18428436dcac,6707b3f0-23b9-4fe3-b7be-11be34aea544`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.createIndustrialAsset(request) -> InlineResponse200</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create an asset with optional configuration parameters. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Equipment** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().createIndustrialAsset(
    AssetCreate
        .builder()
        .name("name")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customMetadata:** `Optional<Map<String, String>>` 
    
</dd>
</dl>

<dl>
<dd>

**location:** `Optional<AssetLocation>` 
    
</dd>
</dl>

<dl>
<dd>

**locationDataInputId:** `Optional<String>` — Required if locationType is "dataInput". Specifies the id of a location data input which will determine the asset's location. **The data input will be moved to the new asset.**
    
</dd>
</dl>

<dl>
<dd>

**locationType:** `Optional<LocationType>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**parentId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**runningStatusDataInputId:** `Optional<String>` — The asset's isRunning status will be true when the associated data input's value is 1. Data input cannot be of location format. **The data input will be moved to the new asset.**
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.deleteIndustrialAsset(id) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete asset. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Equipment** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().deleteIndustrialAsset(
    "id",
    DeleteIndustrialAssetRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Id of the asset to be deleted.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.patchIndustrialAsset(id, request) -> InlineResponse200</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an existing asset. Only the provided fields will be updated. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Equipment** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().patchIndustrialAsset(
    "id",
    AssetPatch
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Id of the asset to be updated
    
</dd>
</dl>

<dl>
<dd>

**customMetadata:** `Optional<Map<String, String>>` 
    
</dd>
</dl>

<dl>
<dd>

**location:** `Optional<AssetLocation>` 
    
</dd>
</dl>

<dl>
<dd>

**locationDataInputId:** `Optional<String>` — Required if locationType is "dataInput". Specifies the id of a location data input which will determine the asset's location. The data input must be in the asset.
    
</dd>
</dl>

<dl>
<dd>

**locationType:** `Optional<LocationType>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**parentId:** `Optional<String>` — The id of the parent asset that the asset belongs to. Pass in an empty string to remove the child from the parent.
    
</dd>
</dl>

<dl>
<dd>

**runningStatusDataInputId:** `Optional<String>` — The asset's isRunning status will be true when the associated data input's value is 1. Data input cannot be of location format. The data input must be in the asset.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<List<String>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.patchAssetDataOutputs(id, request) -> AssetDataOutputsPatchAssetDataOutputsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Writes values to multiple data outputs on an asset simultaneously. Only the provided data outputs will be updated.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().patchAssetDataOutputs(
    "id",
    AssetDataOutputsPatchAssetDataOutputsRequestBody
        .builder()
        .values(
            new HashMap<String, Object>() {{
                put("key", "value");
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Asset ID
    
</dd>
</dl>

<dl>
<dd>

**values:** `Map<String, Object>` — A map of data output IDs to values. All data outputs must belong to the same asset. Only the specified IDs will be written to.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.getDataInputs() -> DataInputsTinyResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all data inputs, optionally filtered by tags or asset ids. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().getDataInputs(
    GetDataInputsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — A comma-separated list of industrial asset UUIDs. Example: `assetIds=076efac2-83b5-47aa-ba36-18428436dcac,6707b3f0-23b9-4fe3-b7be-11be34aea544`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.getDataInputDataSnapshot() -> DataInputSnapshotResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns last known data points for all data inputs. This can be filtered by optional tags, specific data input IDs or asset IDs. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().getDataInputDataSnapshot(
    GetDataInputDataSnapshotRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**dataInputIds:** `Optional<String>` — A comma-separated list of data input IDs. Example: `dataInputIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — A comma-separated list of industrial asset UUIDs. Example: `assetIds=076efac2-83b5-47aa-ba36-18428436dcac,6707b3f0-23b9-4fe3-b7be-11be34aea544`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.getDataInputDataFeed() -> DataInputListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Follow a continuous feed of all data input data points.

Your first call to this endpoint will provide you with the most recent data points for each data input and a `pagination` object that contains an `endCursor`.

You can provide the `endCursor` to the `after` parameter of this endpoint to get data point updates since that `endCursor`.

If `hasNextPage` is `false`, no updates are readily available yet. We suggest waiting a minimum of 5 seconds before requesting updates. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().getDataInputDataFeed(
    GetDataInputDataFeedRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**dataInputIds:** `Optional<String>` — A comma-separated list of data input IDs. Example: `dataInputIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — A comma-separated list of industrial asset UUIDs. Example: `assetIds=076efac2-83b5-47aa-ba36-18428436dcac,6707b3f0-23b9-4fe3-b7be-11be34aea544`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.getDataInputDataHistory() -> DataInputListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all known data points during the given time range for all data inputs. This can be filtered by optional tags, specific data input IDs or asset IDs. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment Statistics** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().getDataInputDataHistory(
    GetDataInputDataHistoryRequest
        .builder()
        .startTime("startTime")
        .endTime("endTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `String` — An end time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**parentTagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of parent tag IDs, for use by orgs with tag hierarchies. Specifying a parent tag will implicitly include all descendent tags of the parent tag. Example: `parentTagIds=345,678`
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — A filter on the data based on this comma-separated list of tag IDs. Example: `tagIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**dataInputIds:** `Optional<String>` — A comma-separated list of data input IDs. Example: `dataInputIds=1234,5678`
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — A comma-separated list of industrial asset UUIDs. Example: `assetIds=076efac2-83b5-47aa-ba36-18428436dcac,6707b3f0-23b9-4fe3-b7be-11be34aea544`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.v1GetCameras() -> List&amp;lt;V1VisionCamerasResponseItem&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch all cameras. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Industrial** under the Industrial category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().v1GetCameras();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.v1GetVisionProgramsByCamera(cameraId) -> List&amp;lt;V1ProgramsForTheCameraResponseItem&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch configured programs on the camera. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Industrial** under the Industrial category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().v1GetVisionProgramsByCamera(
    1000000L,
    V1GetVisionProgramsByCameraRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cameraId:** `Long` — The camera_id should be valid for the given accessToken.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.v1GetVisionLatestRunCamera(cameraId) -> V1VisionRunByCameraResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch the latest run for a camera or program by default. If startedAtMs is supplied, fetch the specific run that corresponds to that start time. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Industrial** under the Industrial category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().v1GetVisionLatestRunCamera(
    1000000L,
    V1GetVisionLatestRunCameraRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cameraId:** `Long` — The camera_id should be valid for the given accessToken.
    
</dd>
</dl>

<dl>
<dd>

**programId:** `Optional<Long>` — The configured program's ID on the camera.
    
</dd>
</dl>

<dl>
<dd>

**startedAtMs:** `Optional<Long>` — EndMs is an optional param. It will default to the current time.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — Include is a filter parameter. Accepts 'pass', 'reject' or 'no_read'.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Limit is an integer value from 1 to 1,000.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.v1GetVisionRuns() -> V1VisionRunsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch runs. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Industrial** under the Industrial category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().v1GetVisionRuns(
    V1GetVisionRunsRequest
        .builder()
        .durationMs(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**durationMs:** `Long` — DurationMs is a required param. This works with the EndMs parameter. Indicates the duration in which the visionRuns will be fetched
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Optional<Long>` — EndMs is an optional param. It will default to the current time.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.getVisionRunsByCamera(cameraId) -> List&amp;lt;V1VisionRunsByCameraResponseItem&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch runs by camera. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Industrial** under the Industrial category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().getVisionRunsByCamera(
    1000000L,
    GetVisionRunsByCameraRequest
        .builder()
        .durationMs(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cameraId:** `Long` — The camera_id should be valid for the given accessToken.
    
</dd>
</dl>

<dl>
<dd>

**durationMs:** `Long` — DurationMs is a required param. This works with the EndMs parameter. Indicates the duration in which the visionRuns will be fetched
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Optional<Long>` — EndMs is an optional param. It will default to the current time.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.v1GetVisionRunsByCameraAndProgram(cameraId, programId, startedAtMs) -> V1VisionRunsByCameraAndProgramResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch runs by camera and program. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Industrial** under the Industrial category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().v1GetVisionRunsByCameraAndProgram(
    1000000L,
    1000000L,
    1000000L,
    V1GetVisionRunsByCameraAndProgramRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cameraId:** `Long` — The camera_id should be valid for the given accessToken.
    
</dd>
</dl>

<dl>
<dd>

**programId:** `Long` — The configured program's ID on the camera.
    
</dd>
</dl>

<dl>
<dd>

**startedAtMs:** `Long` — Started_at_ms is a required param. Indicates the start time of the run to be fetched.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — Include is a filter parameter. Accepts 'pass', 'reject' or 'no_read'.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.v1GetMachinesHistory(request) -> V1MachineHistoryResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get historical data for machine objects. This method returns a set of historical data for all machines. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Industrial** under the Industrial category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().v1GetMachinesHistory(
    InlineObject3
        .builder()
        .endMs(1462881998034L)
        .startMs(1462878398034L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endMs:** `Long` — End of the time range, specified in milliseconds UNIX time.
    
</dd>
</dl>

<dl>
<dd>

**startMs:** `Long` — Beginning of the time range, specified in milliseconds UNIX time.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.industrial.v1GetMachines() -> InlineResponse2008</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get machine objects. This method returns a list of the machine objects in the Samsara Cloud and information about them. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Industrial** under the Industrial category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.industrial().v1GetMachines();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Issues
<details><summary><code>client.issues.getIssues() -> IssuesGetIssuesResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all issues data for the specified IDs.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Issues** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.issues().getIssues(
    GetIssuesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — A comma-separated list containing up to 100 issue IDs to filter on. Can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the issue.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — A comma separated list of additional fields to include on requested objects. Valid values: `externalIds`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.issues.patchIssue(request) -> IssuesPatchIssueResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an instance of an issue.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Issues** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.issues().patchIssue(
    IssuesPatchIssueRequestBody
        .builder()
        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assignedTo:** `Optional<PatchIssueRequestBodyAssignedToRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**dueDate:** `Optional<OffsetDateTime>` — Due date of the issue. UTC timestamp in RFC 3339 format.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — A map of external ids
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — ID of the issue. Can be either a unique Samsara ID or an [external ID](https://developers.samsara.com/docs/external-ids) for the issue.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<IssuesPatchIssueRequestBodyStatus>` — Status of the issue.  Valid values: `open`, `inProgress`, `resolved`, `dismissed`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.issues.getIssuesStream() -> IssuesGetIssuesStreamResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all issues data that has been created or modified for your organization based on the time parameters passed in. Results are paginated and are sorted by last modified date. If you include an endTime, the endpoint will return data up until that point (exclusive). If you don’t include an endTime, you can continue to poll the API real-time with the pagination cursor that gets returned on every call.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Issues** under the Forms category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.issues().getIssuesStream(
    GetIssuesStreamRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. Value is compared against `updatedAtTime`. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. Value is compared against `updatedAtTime`. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<String>` — A comma-separated list containing status values to filter issues on. Valid values: `open`, `inProgress`, `resolved`, `dismissed`
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — A comma-separated list containing up to 50 asset IDs to filter issues on. Issues with untracked assets can also be included by passing the value: 'untracked'.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — A comma separated list of additional fields to include on requested objects. Valid values: `externalIds`
    
</dd>
</dl>

<dl>
<dd>

**assignedToRouteStopIds:** `Optional<String>` — A comma-separated list containing up to 50 route stop IDs to filter data on.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## LiveSharingLinks
<details><summary><code>client.liveSharingLinks.getLiveSharingLinks() -> LiveSharingLinksGetLiveSharingLinksResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all non-expired Live Sharing Links.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Live Sharing Links** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.liveSharingLinks().getLiveSharingLinks(
    GetLiveSharingLinksRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — A filter on the data based on this comma-separated list of Live Share Link IDs
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<GetLiveSharingLinksRequestType>` — A filter on the data based on the Live Sharing Link type.  Valid values: `all`, `assetsLocation`, `assetsNearLocation`, `assetsOnRoute`
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 100 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.liveSharingLinks.createLiveSharingLink(request) -> LiveSharingLinksCreateLiveSharingLinkResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create Live Sharing Link.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Live Sharing Links** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.liveSharingLinks().createLiveSharingLink(
    LiveSharingLinksCreateLiveSharingLinkRequestBody
        .builder()
        .name("Example Live Sharing Link name")
        .type(LiveSharingLinksCreateLiveSharingLinkRequestBodyType.ASSETS_LOCATION)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assetsLocationLinkConfig:** `Optional<AssetsLocationLinkRequestConfigObject>` 
    
</dd>
</dl>

<dl>
<dd>

**assetsNearLocationLinkConfig:** `Optional<AssetsNearLocationLinkConfigObject>` 
    
</dd>
</dl>

<dl>
<dd>

**assetsOnRouteLinkConfig:** `Optional<AssetsOnRouteLinkConfigObject>` 
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — Description for the Live Sharing Link (not applicable for 'assetsOnRoute' type).
    
</dd>
</dl>

<dl>
<dd>

**expiresAtTime:** `Optional<String>` — Date that this link expires in RFC 3339 format. Can't be set in the past. If not provided then link will never expire.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Name of the Live Sharing Link.
    
</dd>
</dl>

<dl>
<dd>

**type:** `LiveSharingLinksCreateLiveSharingLinkRequestBodyType` — Type of the Live Sharing Link. This field specifies which one of '<type>LinkConfig' objects will be used to configure the sharing link.  Valid values: `assetsLocation`, `assetsNearLocation`, `assetsOnRoute`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.liveSharingLinks.deleteLiveSharingLink()</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete Live Sharing Link.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Live Sharing Links** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.liveSharingLinks().deleteLiveSharingLink(
    DeleteLiveSharingLinkRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the Live Sharing Link.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.liveSharingLinks.updateLiveSharingLink(request) -> LiveSharingLinksUpdateLiveSharingLinkResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update Live Sharing Link.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Live Sharing Links** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.liveSharingLinks().updateLiveSharingLink(
    LiveSharingLinksUpdateLiveSharingLinkRequestBody
        .builder()
        .id("id")
        .name("Example Live Sharing Link name")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the Live Sharing Link.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — Description for the Live Sharing Link (not applicable for 'assetsOnRoute' type).
    
</dd>
</dl>

<dl>
<dd>

**expiresAtTime:** `Optional<String>` — Date that this link expires in RFC 3339 format. Can't be set in the past. If not provided then link will never expire.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Name of the Live Sharing Link.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## WorkOrders
<details><summary><code>client.workOrders.postInvoiceScan(request) -> WorkOrdersPostInvoiceScanResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Process an invoice scan to create or update a work order with AI-extracted data. Accepts base64 encoded invoice files (PDF, JPEG, PNG) up to 10MB.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Work Orders** under the Work Orders category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.workOrders().postInvoiceScan(
    WorkOrdersPostInvoiceScanRequestBody
        .builder()
        .file(
            InvoiceScanFileRequestBody
                .builder()
                .base64Content("JVBERi0xLjQKJeLjz9MKMyAwIG9iago8P...")
                .contentType("application/pdf")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assetId:** `Optional<String>` — Asset ID to create a new work order for the invoice. Provide either workOrderId OR assetId, but not both. If assetId is provided, a new work order will be created for that asset. If workOrderId is provided instead, the invoice will be attached to the existing work order.
    
</dd>
</dl>

<dl>
<dd>

**file:** `InvoiceScanFileRequestBody` 
    
</dd>
</dl>

<dl>
<dd>

**workOrderId:** `Optional<String>` — Work order ID to attach the invoice to an existing work order. Provide either workOrderId OR assetId, but not both. If workOrderId is provided, the invoice will be attached to the existing work order. If assetId is provided instead, a new work order will be created for that asset.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.workOrders.getServiceTasks() -> WorkOrdersGetServiceTasksResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Gets service tasks.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Work Orders** under the Work Orders category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.workOrders().getServiceTasks(
    GetServiceTasksRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — Filter by the IDs. If not provided, won't filter by id.
    
</dd>
</dl>

<dl>
<dd>

**includeArchived:** `Optional<Boolean>` — Include archived service task definitions.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.workOrders.getWorkOrders() -> WorkOrdersGetWorkOrdersResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Gets work orders.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Work Orders** under the Work Orders category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.workOrders().getWorkOrders(
    GetWorkOrdersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` — Filter by the IDs. Up to 100 ids. Returns all if no ids are provided.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.workOrders.postWorkOrders(request) -> WorkOrdersPostWorkOrdersResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a work order.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Work Orders** under the Work Orders category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.workOrders().postWorkOrders(
    WorkOrdersPostWorkOrdersRequestBody
        .builder()
        .assetId("12443")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assetId:** `String` — The ID of the asset.
    
</dd>
</dl>

<dl>
<dd>

**assignedUserId:** `Optional<String>` — The ID of the assigned mechanic.
    
</dd>
</dl>

<dl>
<dd>

**category:** `Optional<String>` — The category of the work order
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — A description of what needs to be fixed.
    
</dd>
</dl>

<dl>
<dd>

**discount:** `Optional<WorkOrderDiscountObjectRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**dueAtTime:** `Optional<OffsetDateTime>` — The due date of the work order in RFC 3339 format.
    
</dd>
</dl>

<dl>
<dd>

**engineHours:** `Optional<Long>` — The engine hours at the time of the work order. Will default to current asset reading if unset.
    
</dd>
</dl>

<dl>
<dd>

**invoiceNumber:** `Optional<String>` — The invoice number for the work order.
    
</dd>
</dl>

<dl>
<dd>

**items:** `Optional<List<WorkOrderItemObjectRequestBody>>` — Items related to the work order.
    
</dd>
</dl>

<dl>
<dd>

**odometerMeters:** `Optional<Long>` — The odometer reading at the time of the work order. Will default to current asset reading if unset.
    
</dd>
</dl>

<dl>
<dd>

**poNumber:** `Optional<String>` — The purchase order number for the work order.
    
</dd>
</dl>

<dl>
<dd>

**priority:** `Optional<WorkOrdersPostWorkOrdersRequestBodyPriority>` — The priority of the work order  Valid values: `High`, `Low`, `Medium`, `Urgent`
    
</dd>
</dl>

<dl>
<dd>

**serviceTaskInstances:** `Optional<List<ServiceTaskInstanceInputObjectRequestBody>>` — Service Tasks for the work order.
    
</dd>
</dl>

<dl>
<dd>

**tax:** `Optional<WorkOrderTaxCreateObjectRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**vendorUuid:** `Optional<String>` — The vendor UUID for the work order.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.workOrders.deleteWorkOrders()</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a work order.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Work Orders** under the Work Orders category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.workOrders().deleteWorkOrders(
    DeleteWorkOrdersRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The unique id of the work order.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.workOrders.patchWorkOrders(request) -> WorkOrdersPatchWorkOrdersResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a work order.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Work Orders** under the Work Orders category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.workOrders().patchWorkOrders(
    WorkOrdersPatchWorkOrdersRequestBody
        .builder()
        .id("5")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assignedUserId:** `Optional<String>` — The ID of the assigned mechanic.
    
</dd>
</dl>

<dl>
<dd>

**category:** `Optional<String>` — The category of the work order
    
</dd>
</dl>

<dl>
<dd>

**closingNotes:** `Optional<String>` — Notes on the work order.
    
</dd>
</dl>

<dl>
<dd>

**completedAtTime:** `Optional<OffsetDateTime>` — The time the work order was completed in RFC 3339 format. Is automatically set when the status changes and this field is not provided.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — A description of what needs to be fixed.
    
</dd>
</dl>

<dl>
<dd>

**discount:** `Optional<WorkOrderDiscountObjectRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**dueAtTime:** `Optional<OffsetDateTime>` — The due date of the work order in RFC 3339 format.
    
</dd>
</dl>

<dl>
<dd>

**engineHours:** `Optional<Long>` — The engine hours at the time of the work order. Will default to current asset reading if unset.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique id of the work order.
    
</dd>
</dl>

<dl>
<dd>

**invoiceNumber:** `Optional<String>` — The invoice number for the work order.
    
</dd>
</dl>

<dl>
<dd>

**items:** `Optional<List<WorkOrderItemObjectRequestBody>>` — Items related to the work order.
    
</dd>
</dl>

<dl>
<dd>

**odometerMeters:** `Optional<Long>` — The odometer reading at the time of the work order. Will default to current asset reading if unset.
    
</dd>
</dl>

<dl>
<dd>

**poNumber:** `Optional<String>` — The purchase order number for the work order.
    
</dd>
</dl>

<dl>
<dd>

**priority:** `Optional<WorkOrdersPatchWorkOrdersRequestBodyPriority>` — The priority of the work order  Valid values: `High`, `Low`, `Medium`, `Urgent`
    
</dd>
</dl>

<dl>
<dd>

**serviceTaskInstances:** `Optional<List<ServiceTaskInstanceInputObjectRequestBody>>` — Service Tasks for the work order.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<WorkOrdersPatchWorkOrdersRequestBodyStatus>` — The status of the work order  Valid values: `Assigned`, `Cancelled`, `Closed`, `Completed`, `In Progress`, `On Hold`, `Open`, `Pending Approval`, `Pending Parts`
    
</dd>
</dl>

<dl>
<dd>

**tax:** `Optional<WorkOrderTaxObjectRequestBody>` 
    
</dd>
</dl>

<dl>
<dd>

**vendorUuid:** `Optional<String>` — The vendor UUID for the work order.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.workOrders.streamWorkOrders() -> WorkOrdersStreamWorkOrdersResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Stream work orders.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Work Orders** under the Work Orders category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.workOrders().streamWorkOrders(
    StreamWorkOrdersRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — A start time in RFC 3339 format. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` —  An end time in RFC 3339 format. Defaults to now if not provided. Millisecond precision and timezones are supported. (Examples: 2019-06-13T19:08:25Z, 2019-06-13T19:08:25.455Z, OR 2015-09-15T14:00:12-04:00).
    
</dd>
</dl>

<dl>
<dd>

**workOrderStatuses:** `Optional<StreamWorkOrdersRequestWorkOrderStatusesItem>` — Work Order status filter.
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — Work Order asset id filter. Up to 50 ids.
    
</dd>
</dl>

<dl>
<dd>

**assignedUserIds:** `Optional<String>` — Work Order assigned user id filter. Up to 50 ids.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Organization Info
<details><summary><code>client.organizationInfo.getOrganizationInfo() -> OrganizationInfoResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get information about your organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Org Information** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizationInfo().getOrganizationInfo();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Preview APIs
<details><summary><code>client.previewApIs.createDriverAuthToken(request) -> DriversAuthTokenCreateDriverAuthTokenResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a short-lived auth token for a driver.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Driver Auth Token** under the Drivers category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>

Endpoints in this section are in Preview. These APIs are not functional and are instead for soliciting feedback from our API users on the intended design of this API. Additionally, it is not guaranteed that we will be releasing an endpoint included in this section to production. This means that developers should **NOT** rely on these APIs to build business critical applications

- Samsara may change the structure of a preview API's interface without versioning or any notice to API users.

- When an endpoint becomes generally available, it will be announced in the API [changelog](https://developers.samsara.com/changelog).
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.previewApIs().createDriverAuthToken(
    DriversAuthTokenCreateDriverAuthTokenRequestBody
        .builder()
        .code("dp[gZc1wAigz4uGa0Hh")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**code:** `String` — Required. Random 12+ character string, used with the auth token to help secure the client from intercepted tokens.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — Optional. External ID of the driver, in the format `key:value` (e.g., `payrollId:ABFS18600`). One of `id`, `externalId`, or `username` is required.
    
</dd>
</dl>

<dl>
<dd>

**id:** `Optional<Long>` — Optional. Samsara ID of the driver. One of `id`, `externalId`, or `username` is required.
    
</dd>
</dl>

<dl>
<dd>

**username:** `Optional<String>` — Optional. Username of the driver. This is the login identifier configured when the driver is created. One of `id`, `externalId`, or `username` is required.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.previewApIs.lockVehicle(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lock a vehicle. This requires a vehicle gateway with locking capabilities.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Vehicle Lock/Unlock** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>

Endpoints in this section are in Preview. These APIs are not functional and are instead for soliciting feedback from our API users on the intended design of this API. Additionally, it is not guaranteed that we will be releasing an endpoint included in this section to production. This means that developers should **NOT** rely on these APIs to build business critical applications

- Samsara may change the structure of a preview API's interface without versioning or any notice to API users.

- When an endpoint becomes generally available, it will be announced in the API [changelog](https://developers.samsara.com/changelog).
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.previewApIs().lockVehicle(
    "id",
    LockVehicleRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the vehicle to lock or unlock. This can be a Samsara internal ID or an external ID in the format `samsara.vin:{VIN}`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.previewApIs.unlockVehicle(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Unlock a vehicle.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Vehicle Lock/Unlock** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>

Endpoints in this section are in Preview. These APIs are not functional and are instead for soliciting feedback from our API users on the intended design of this API. Additionally, it is not guaranteed that we will be releasing an endpoint included in this section to production. This means that developers should **NOT** rely on these APIs to build business critical applications

- Samsara may change the structure of a preview API's interface without versioning or any notice to API users.

- When an endpoint becomes generally available, it will be announced in the API [changelog](https://developers.samsara.com/changelog).
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.previewApIs().unlockVehicle(
    "id",
    UnlockVehicleRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the vehicle to lock or unlock. This can be a Samsara internal ID or an external ID in the format `samsara.vin:{VIN}`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## RouteEvents
<details><summary><code>client.routeEvents.getRouteEventsStream() -> RoutesGetRouteEventsStreamResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Subscribes to a feed of immutable, append-only updates for routes. The initial request to this feed endpoint returns a cursor, which can be used in subsequent requests to fetch events on all routes that occurred after the last retrieved event. An initial request (with empty after and startTime parameters) will return events from the past 24 hours.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Routes** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.routeEvents().getRouteEventsStream(
    GetRouteEventsStreamRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Optional<String>` — A start time in RFC 3339 format. Defaults to 24 hours ago if not provided. Millisecond precision and timezones are supported. (Examples: 2025-07-01T19:08:25Z, 2025-07-01T19:08:25.455Z, OR 2025-07-01T14:00:12-04:00). Cannot be more than 7 days in the past.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many events will be in the response. Default and max for this value is 200 events.
    
</dd>
</dl>

<dl>
<dd>

**includeExternalIds:** `Optional<Boolean>` — Optional boolean indicating whether to return external IDs on supported entities
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Safety
<details><summary><code>client.safety.getSafetyEventsV2() -> SafetyEventsV2GetSafetyEventsV2ResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return details for the specified safety events based on the parameters passed in. Results are paginated.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.safety().getSafetyEventsV2(
    GetSafetyEventsV2Request
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**safetyEventIds:** `Optional<String>` — Required string of comma separated Safety Event IDs. Unique Samsara IDs (uuid) of the safety event.
    
</dd>
</dl>

<dl>
<dd>

**includeAsset:** `Optional<Boolean>` — Indicates whether or not to return expanded “asset” data
    
</dd>
</dl>

<dl>
<dd>

**includeDriver:** `Optional<Boolean>` — Indicates whether or not to return expanded “driver” data
    
</dd>
</dl>

<dl>
<dd>

**includeVgOnlyEvents:** `Optional<Boolean>` — Indicates whether or not to return events that are captured by devices with only a Vehicle Gateway (VG) installed.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.safety.getSafetyEventsV2Stream() -> SafetyEventsV2GetSafetyEventsV2StreamResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return all safety events associated with your organization based on the parameters passed in. To get core endpoint data, select Read Safety Events & Scores under the Safety & Cameras category when creating or editing an API token. Read Camera Media permissions required to get Safety Event video media via this endpoint. If you include an endTime, the endpoint will return data up until that point. If you do not include an endTime, you can continue to poll the API real-time with the pagination cursor that gets returned on every call. Results are paginated.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.safety().getSafetyEventsV2Stream(
    GetSafetyEventsV2StreamRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startTime:** `String` — RFC 3339 timestamp that indicates when to begin receiving data. Value is compared against `updatedAtTime` or `createdAtTime` depending on the `queryByTimeField` parameter.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — RFC 3339 timestamp. If not provided and filtering by `updatedAtTime` then the endpoint behaves as an unending feed of changes. If endTime is set the same as startTime, the most recent data point before that time will be returned per asset. Value is compared against `updatedAtTime` or `createdAtTime` depending on the `queryByTimeField` parameter.
    
</dd>
</dl>

<dl>
<dd>

**queryByTimeField:** `Optional<GetSafetyEventsV2StreamRequestQueryByTimeField>` — Optional string that decides which field to compare against the provided time range.  Valid values: `updatedAtTime`, `createdAtTime`
    
</dd>
</dl>

<dl>
<dd>

**assetIds:** `Optional<String>` — Optional string of comma separated asset IDs. If asset ID is present, events for the specified asset(s) will be returned. Limit of 2000 asset IDs.
    
</dd>
</dl>

<dl>
<dd>

**driverIds:** `Optional<String>` — Optional string of comma separated driver IDs. If driver ID is present, events for the specified driver(s) will be returned. Limit of 2000 driver IDs.
    
</dd>
</dl>

<dl>
<dd>

**tagIds:** `Optional<String>` — Optional string of comma separated tag IDs. If tag ID is present, events for the specified tag(s) will be returned. Limit of 2000 tag IDs.
    
</dd>
</dl>

<dl>
<dd>

**assignedCoaches:** `Optional<String>` — Optional string of comma separated coach IDs to filter events assigned to a particular coach. Limit of 2000 coach IDs.
    
</dd>
</dl>

<dl>
<dd>

**behaviorLabels:** `Optional<String>` — Optional string of comma separated values to filter behavior labels. Valid values: `Acceleration`, `AggressiveDriving`, `BluetoothHeadset`, `Braking`, `ContextConstructionOrWorkZone`, `ContextSnowyOrIcy`, `ContextVulnerableRoadUser`, `ContextWet`, `Crash`, `DefensiveDriving`, `DidNotYield`, `Drinking`, `Drowsy`, `Eating`, `EatingDrinking`, `EdgeDistractedDriving`, `EdgeRailroadCrossingViolation`, `FollowingDistance`, `FollowingDistanceModerate`, `FollowingDistanceSevere`, `ForwardCollisionWarning`, `GenericDistraction`, `GenericTailgating`, `HarshTurn`, `HeavySpeeding`, `HosViolation`, `Idling`, `Invalid`, `LaneDeparture`, `LateResponse`, `LeftTurn`, `LightSpeeding`, `MaxSpeed`, `MobileUsage`, `ModerateSpeeding`, `NearCollison`, `NearPedestrianCollision`, `NoSeatbelt`, `ObstructedCamera`, `OtherViolation`, `Passenger`, `PolicyViolationMask`, `ProtectiveEquipment`, `RanRedLight`, `Reversing`, `RollingStop`, `RolloverProtection`, `SevereSpeeding`, `Smoking`, `Speeding`, `UTurn`, `UnsafeManeuver`, `UnsafeParking`, `VulnerableRoadUserCollisionWarning`, `YawControl`
    
</dd>
</dl>

<dl>
<dd>

**eventStates:** `Optional<String>` — Optional string of comma separated values to filter event states. Valid values: `needsReview`, `reviewed`, `needsCoaching`, `coached`, `dismissed`, `needsRecognition`, `recognized`
    
</dd>
</dl>

<dl>
<dd>

**includeAsset:** `Optional<Boolean>` — Indicates whether or not to return expanded “asset” data
    
</dd>
</dl>

<dl>
<dd>

**includeDriver:** `Optional<Boolean>` — Indicates whether or not to return expanded “driver” data
    
</dd>
</dl>

<dl>
<dd>

**includeVgOnlyEvents:** `Optional<Boolean>` — Indicates whether or not to return events that are captured by devices with only a Vehicle Gateway (VG) installed.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.safety.v1GetDriverSafetyScore(driverId) -> V1DriverSafetyScoreResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch the safety score for the driver.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.safety().v1GetDriverSafetyScore(
    1000000L,
    V1GetDriverSafetyScoreRequest
        .builder()
        .startMs(1000000L)
        .endMs(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverId:** `Long` — ID of the driver. Must contain only digits 0-9.
    
</dd>
</dl>

<dl>
<dd>

**startMs:** `Long` — Timestamp in milliseconds representing the start of the period to fetch, inclusive. Used in combination with endMs. Total duration (endMs - startMs) must be greater than or equal to 1 hour.
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Long` — Timestamp in milliseconds representing the end of the period to fetch, inclusive. Used in combination with startMs. Total duration (endMs - startMs) must be greater than or equal to 1 hour.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.safety.v1GetVehicleSafetyScore(vehicleId) -> V1VehicleSafetyScoreResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch the safety score for the vehicle. 

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Safety Events & Scores** under the Safety & Cameras category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.safety().v1GetVehicleSafetyScore(
    1000000L,
    V1GetVehicleSafetyScoreRequest
        .builder()
        .startMs(1000000L)
        .endMs(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**vehicleId:** `Long` — ID of the vehicle. Must contain only digits 0-9.
    
</dd>
</dl>

<dl>
<dd>

**startMs:** `Long` — Timestamp in milliseconds representing the start of the period to fetch, inclusive. Used in combination with endMs. Total duration (endMs - startMs) must be greater than or equal to 1 hour.
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Long` — Timestamp in milliseconds representing the end of the period to fetch, inclusive. Used in combination with startMs. Total duration (endMs - startMs) must be greater than or equal to 1 hour.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## SpeedingIntervals
<details><summary><code>client.speedingIntervals.getSpeedingIntervals() -> SpeedingIntervalsGetSpeedingIntervalsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return all speeding intervals associated with all trips that have been collected for your organization based on the time parameters passed in. Only completed trips are included. Trips with no speeding intervals detected will be returned with an empty list of intervals. Results are paginated.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Speeding Intervals** under the Speeding Intervals category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.speedingIntervals().getSpeedingIntervals(
    GetSpeedingIntervalsRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**assetIds:** `Optional<String>` — Comma-separated list of asset IDs. Include up to 50 asset IDs.
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — RFC 3339 timestamp that indicates when to begin receiving data. Value is compared against `updatedAtTime` or `tripStartTime` depending on the queryBy parameter.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — RFC 3339 timestamp which is compared against `updatedAtTime` or `tripStartTime` depending on the queryBy parameter. If not provided then the endpoint behaves as an unending feed of changes.
    
</dd>
</dl>

<dl>
<dd>

**queryBy:** `Optional<GetSpeedingIntervalsRequestQueryBy>` — Decide which timestamp the `startTime` and `endTime` are compared to.  Valid values: `updatedAtTime`, `tripStartTime`
    
</dd>
</dl>

<dl>
<dd>

**includeAsset:** `Optional<Boolean>` — Indicates whether or not to return expanded “asset” data
    
</dd>
</dl>

<dl>
<dd>

**includeDriverId:** `Optional<Boolean>` — Indicates whether or not to return trip's driver id
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**severityLevels:** `Optional<String>` — Optional string of comma-separated severity levels to filter speeding intervals by. Valid values:  “light”, ”moderate”, ”heavy”, “severe”. This filter does not exclude trips that have no speeding intervals.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Tags
<details><summary><code>client.tags.listTags() -> ListTagsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Return all of the tags for an organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Tags** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tags().listTags(
    ListTagsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.createTag(request) -> TagResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new tag for the organization. This may include up to 20,000 tagged entities. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Tags** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tags().createTag(
    CreateTagRequest
        .builder()
        .name("California")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**addresses:** `Optional<List<String>>` — The addresses that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**assets:** `Optional<List<String>>` — The trailers, unpowered, and powered assets that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**drivers:** `Optional<List<String>>` — The drivers that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — The [external IDs](https://developers.samsara.com/docs/external-ids) for the given object.
    
</dd>
</dl>

<dl>
<dd>

**machines:** `Optional<List<String>>` — The machines that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Name of this tag.
    
</dd>
</dl>

<dl>
<dd>

**parentTagId:** `Optional<String>` — If this tag is part a hierarchical tag tree, this is the ID of the parent tag, otherwise this will be omitted.
    
</dd>
</dl>

<dl>
<dd>

**sensors:** `Optional<List<String>>` — The sensors that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**vehicles:** `Optional<List<String>>` — The vehicles that belong to this tag.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.getTag(id) -> TagResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch a tag by id. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Tags** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tags().getTag(
    "id",
    GetTagRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the Tag. This can either be the Samsara-provided ID or an external ID. External IDs are customer-specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `crmId:abc123`. Automatically populated external IDs are prefixed with `samsara.`. For example, `samsara.name:ELD-exempt`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.replaceTag(id, request) -> TagResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a tag with a new name and new members. This API call would replace all old members of a tag with new members specified in the request body. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Tags** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tags().replaceTag(
    "id",
    ReplaceTagRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the Tag. This can either be the Samsara-provided ID or an external ID. External IDs are customer-specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `crmId:abc123`. Automatically populated external IDs are prefixed with `samsara.`. For example, `samsara.name:ELD-exempt`.
    
</dd>
</dl>

<dl>
<dd>

**addresses:** `Optional<List<String>>` — The addresses that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**assets:** `Optional<List<String>>` — The trailers, unpowered, and powered assets that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**drivers:** `Optional<List<String>>` — The drivers that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**machines:** `Optional<List<String>>` — The machines that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — Name of this tag.
    
</dd>
</dl>

<dl>
<dd>

**parentTagId:** `Optional<String>` — If this tag is part a hierarchical tag tree, this is the ID of the parent tag, otherwise this will be omitted.
    
</dd>
</dl>

<dl>
<dd>

**sensors:** `Optional<List<String>>` — The sensors that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**vehicles:** `Optional<List<String>>` — The vehicles that belong to this tag.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.deleteTag(id) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Permanently deletes a tag. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Tags** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tags().deleteTag(
    "id",
    DeleteTagRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the Tag. This can either be the Samsara-provided ID or an external ID. External IDs are customer-specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `crmId:abc123`. Automatically populated external IDs are prefixed with `samsara.`. For example, `samsara.name:ELD-exempt`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.patchTag(id, request) -> TagResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an existing tag. **Note** this implementation of patch uses [the JSON merge patch](https://tools.ietf.org/html/rfc7396) proposed standard. 

 This means that any fields included in the patch request will _overwrite_ fields which exist on the target resource. 

 For arrays, this means any array included in the request will _replace_ the array that exists at the specified path, it will not _add_ to the existing array. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Tags** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tags().patchTag(
    "id",
    PatchTagRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the Tag. This can either be the Samsara-provided ID or an external ID. External IDs are customer-specified key-value pairs created in the POST or PATCH requests of this resource. To specify an external ID as part of a path parameter, use the following format: `key:value`. For example, `crmId:abc123`. Automatically populated external IDs are prefixed with `samsara.`. For example, `samsara.name:ELD-exempt`.
    
</dd>
</dl>

<dl>
<dd>

**addresses:** `Optional<List<String>>` — The addresses that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**assets:** `Optional<List<String>>` — The trailers, unpowered, and powered assets that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**drivers:** `Optional<List<String>>` — The drivers that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**externalIds:** `Optional<Map<String, String>>` — The [external IDs](https://developers.samsara.com/docs/external-ids) for the given object.
    
</dd>
</dl>

<dl>
<dd>

**machines:** `Optional<List<String>>` — The machines that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — Name of this tag.
    
</dd>
</dl>

<dl>
<dd>

**parentTagId:** `Optional<String>` — If this tag is part a hierarchical tag tree, this is the ID of the parent tag, otherwise this will be omitted.
    
</dd>
</dl>

<dl>
<dd>

**sensors:** `Optional<List<String>>` — The sensors that belong to this tag.
    
</dd>
</dl>

<dl>
<dd>

**vehicles:** `Optional<List<String>>` — The vehicles that belong to this tag.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Trips
<details><summary><code>client.trips.getTrips() -> TripsGetTripsResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint will return trips that have been collected for your organization based on the time parameters passed in. Results are paginated.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Trips** under the Trips category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trips().getTrips(
    GetTripsRequest
        .builder()
        .startTime("startTime")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**includeAsset:** `Optional<Boolean>` — Indicates whether or not to return expanded “asset” data
    
</dd>
</dl>

<dl>
<dd>

**completionStatus:** `Optional<GetTripsRequestCompletionStatus>` — Filters trips based on a specific completion status  Valid values: `inProgress`, `completed`, `all`
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `String` — RFC 3339 timestamp that indicates when to begin receiving data. Value is compared against `updatedAtTime` or `tripStartTime` depending on the queryBy parameter.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` — RFC 3339 timestamp which is compared against `updatedAtTime` or `tripStartTime` depending on the queryBy parameter. If not provided then the endpoint behaves as an unending feed of changes.
    
</dd>
</dl>

<dl>
<dd>

**queryBy:** `Optional<GetTripsRequestQueryBy>` — Decide which timestamp the `startTime` and `endTime` are compared to.  Valid values: `updatedAtTime`, `tripStartTime`
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>

<dl>
<dd>

**ids:** `Optional<String>` — Comma-separated list of asset IDs. Include up to 50 asset IDs.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trips.v1GetFleetTrips() -> V1TripResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get historical trips data for specified vehicle. This method returns a set of historical trips data for the specified vehicle in the specified time range. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Vehicle Trips** under the Vehicles category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trips().v1GetFleetTrips(
    V1GetFleetTripsRequest
        .builder()
        .vehicleId(1000000L)
        .startMs(1000000L)
        .endMs(1000000L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**vehicleId:** `Long` — Vehicle ID to query.
    
</dd>
</dl>

<dl>
<dd>

**startMs:** `Long` — Beginning of the time range, specified in milliseconds UNIX time. Limited to a 90 day window with respect to startMs and endMs
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Long` — End of the time range, specified in milliseconds UNIX time.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Users
<details><summary><code>client.users.listUserRoles() -> ListUserRolesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of all user roles in an organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Users** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().listUserRoles(
    ListUserRolesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.listUsers() -> ListUsersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of all users in an organization. Users that have expired access will not be returned. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Users** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().listUsers(
    ListUsersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` — If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.createUser(request) -> UserResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Add a user to the organization. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Users** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().createUser(
    CreateUserRequest
        .builder()
        .authType(CreateUserRequestAuthType.DEFAULT)
        .email("user@company.com")
        .name("Bob Smith")
        .roles(
            Arrays.asList(
                CreateUserRequestRoles
                    .builder()
                    .roleId("8a9371af-82d1-4158-bf91-4ecc8d3a114c")
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authType:** `CreateUserRequestAuthType` — The authentication type the user uses to authenticate. To use SAML this organization must have a configured SAML integration. Valid values: `default`, `saml`.
    
</dd>
</dl>

<dl>
<dd>

**email:** `String` — The email address of this user.
    
</dd>
</dl>

<dl>
<dd>

**expireAt:** `Optional<String>` — For users with temporary access, this is the expiration datetime in RFC3339 format
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — The first and last name of the user.
    
</dd>
</dl>

<dl>
<dd>

**roles:** `List<CreateUserRequestRoles>` — The list of roles that applies to this user. A user may have "organizational" roles, which apply to the user at the organizational level, and "tag-specific" roles, which apply to the user for a given tag.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.getUser(id) -> UserResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a specific user's information. Users that have expired access will not be returned. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Users** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().getUser(
    "id",
    GetUserRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the user.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.deleteUser(id) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete the given user. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Users** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().deleteUser(
    "id",
    DeleteUserRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the user.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.updateUser(id, request) -> UserResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a specific user's information. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Users** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().updateUser(
    "id",
    UpdateUserRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the user.
    
</dd>
</dl>

<dl>
<dd>

**authType:** `Optional<UpdateUserRequestAuthType>` — The authentication type the user uses to authenticate. To use SAML this organization must have a configured SAML integration. Valid values: `default`, `saml`.
    
</dd>
</dl>

<dl>
<dd>

**expireAt:** `Optional<String>` — For users with temporary access, this is the expiration datetime in RFC3339 format
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The first and last name of the user.
    
</dd>
</dl>

<dl>
<dd>

**roles:** `Optional<List<CreateUserRequestRoles>>` — The list of roles that applies to this user. A user may have "organizational" roles, which apply to the user at the organizational level, and "tag-specific" roles, which apply to the user for a given tag.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Legacy
<details><summary><code>client.legacy.v1GetAllAssets() -> InlineResponse2001</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

**Note: This is a legacy endpoint, consider using [this endpoint](https://developers.samsara.com/reference/listassets) instead. The endpoint will continue to function as documented.** 

 Fetch all powered and unpowered equipment. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Equipment** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.legacy().v1GetAllAssets();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Messages
<details><summary><code>client.messages.v1GetMessages() -> InlineResponse2005</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get all messages. 

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Messages** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.messages().v1GetMessages(
    V1GetMessagesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endMs:** `Optional<Long>` — Time in unix milliseconds that represents the end of time range of messages to return. Used in combination with durationMs. Defaults to now.
    
</dd>
</dl>

<dl>
<dd>

**durationMs:** `Optional<Long>` — Time in milliseconds that represents the duration before endMs to query. Defaults to 24 hours.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.messages.v1CreateMessages(request) -> InlineResponse2006</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Send a message to a list of driver ids. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Messages** under the Driver Workflow category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.messages().v1CreateMessages(
    InlineObject2
        .builder()
        .text("This is a message.")
        .driverIds(
            Arrays.asList(111L, 222L, 333L)
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**driverIds:** `List<Long>` — IDs of the drivers for whom the messages are sent to.
    
</dd>
</dl>

<dl>
<dd>

**text:** `String` — The text sent in the message. Max 2500 characters allowed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Trailer Assignments
<details><summary><code>client.trailerAssignments.v1GetAllTrailerAssignments() -> InlineResponse2007</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch trailer assignment data for all trailers in your organization. 

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trailerAssignments().v1GetAllTrailerAssignments(
    V1GetAllTrailerAssignmentsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**startMs:** `Optional<Long>` — Timestamp in Unix epoch miliseconds representing the start of the period to fetch. Omitting both startMs and endMs only returns current assignments.
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Optional<Long>` — Timestamp in Unix epoch miliseconds representing the end of the period to fetch. Omitting endMs sets endMs as the current time
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — Pagination parameter indicating the number of results to return in this request. Used in conjunction with either 'startingAfter' or 'endingBefore'.
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — Pagination parameter indicating the cursor position to continue returning results after. Used in conjunction with the 'limit' parameter. Mutually exclusive with 'endingBefore' parameter.
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` — Pagination parameter indicating the cursor position to return results before. Used in conjunction with the 'limit' parameter. Mutually exclusive with 'startingAfter' parameter.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trailerAssignments.v1GetFleetTrailerAssignments(trailerId) -> V1TrailerAssignmentsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Fetch trailer assignment data for a single trailer. 

 <b>Rate limit:</b> 25 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Read Assignments** under the Assignments category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trailerAssignments().v1GetFleetTrailerAssignments(
    1000000L,
    V1GetFleetTrailerAssignmentsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**trailerId:** `Long` — ID of trailer. Must contain only digits 0-9.
    
</dd>
</dl>

<dl>
<dd>

**startMs:** `Optional<Long>` — Timestamp in Unix epoch milliseconds representing the start of the period to fetch. Omitting both startMs and endMs only returns current assignments.
    
</dd>
</dl>

<dl>
<dd>

**endMs:** `Optional<Long>` — Timestamp in Unix epoch milliseconds representing the end of the period to fetch. Omitting endMs sets endMs as the current time
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Sensors
<details><summary><code>client.sensors.v1GetSensorsCargo(request) -> V1CargoResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get cargo monitor status (empty / full) for requested sensors. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Sensors** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sensors().v1GetSensorsCargo(
    InlineObject4
        .builder()
        .sensors(
            Arrays.asList(122L)
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sensors:** `List<Long>` — List of sensor IDs to query.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.sensors.v1GetSensorsDoor(request) -> V1DoorResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get door monitor status (closed / open) for requested sensors. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Sensors** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sensors().v1GetSensorsDoor(
    InlineObject5
        .builder()
        .sensors(
            Arrays.asList(122L)
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sensors:** `List<Long>` — List of sensor IDs to query.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.sensors.v1GetSensorsHistory(request) -> V1SensorHistoryResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get historical data for specified sensors. This method returns a set of historical data for the specified sensors in the specified time range and at the specified time resolution. 

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>). 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Sensors** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sensors().v1GetSensorsHistory(
    InlineObject6
        .builder()
        .endMs(1462881998034L)
        .startMs(1462878398034L)
        .stepMs(3600000L)
        .series(
            Arrays.asList(
                V1SensorsHistorySeries
                    .builder()
                    .field(V1SensorsHistorySeriesField.AMBIENT_TEMPERATURE)
                    .widgetId(1L)
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**endMs:** `Long` — End of the time range, specified in milliseconds UNIX time.
    
</dd>
</dl>

<dl>
<dd>

**fillMissing:** `Optional<InlineObject6FillMissing>` 
    
</dd>
</dl>

<dl>
<dd>

**series:** `List<V1SensorsHistorySeries>` 
    
</dd>
</dl>

<dl>
<dd>

**startMs:** `Long` — Beginning of the time range, specified in milliseconds UNIX time.
    
</dd>
</dl>

<dl>
<dd>

**stepMs:** `Long` — Time resolution for which data should be returned, in milliseconds. Specifying 3600000 will return data at hour intervals.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.sensors.v1GetSensorsHumidity(request) -> V1HumidityResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get humidity for requested sensors. This method returns the current relative humidity for the requested sensors. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Sensors** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sensors().v1GetSensorsHumidity(
    InlineObject7
        .builder()
        .sensors(
            Arrays.asList(122L)
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sensors:** `List<Long>` — List of sensor IDs to query.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.sensors.v1GetSensors() -> InlineResponse2009</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get sensor objects. This method returns a list of the sensor objects in the Samsara Cloud and information about them. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Sensors** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sensors().v1GetSensors();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.sensors.v1GetSensorsTemperature(request) -> V1TemperatureResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<n class="warning">
<nh>
<i class="fa fa-exclamation-circle"></i>
This endpoint is still on our legacy API.
</nh>
</n>

Get temperature for requested sensors. This method returns the current ambient temperature (and probe temperature if applicable) for the requested sensors. 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.

To use this endpoint, select **Write Sensors** under the Equipment category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sensors().v1GetSensorsTemperature(
    InlineObject8
        .builder()
        .sensors(
            Arrays.asList(122L)
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sensors:** `List<Long>` — List of sensor IDs to query.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Webhooks
<details><summary><code>client.webhooks.listWebhooks() -> WebhooksListWebhooksResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List all webhooks belonging to a specific org.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Webhooks** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().listWebhooks(
    ListWebhooksRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**ids:** `Optional<String>` —  A filter on the data based on this comma-separated list of webhook IDs. Example: `ids=49412323223,49412329928`
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Long>` — The limit for how many objects will be in the response. Default and max for this value is 512 objects.
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<String>` —  If specified, this should be the endCursor value from the previous page of results. When present, this request will return the next page of results that occur immediately after the previous page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.postWebhooks(request) -> WebhooksPostWebhooksResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a webhook

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Webhooks** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().postWebhooks(
    WebhooksPostWebhooksRequestBody
        .builder()
        .name("Webhook-123")
        .url("https://www.Webhook-123.com/webhook/listener")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customHeaders:** `Optional<List<CustomHeadersObjectRequestBody>>` — The list of custom headers that users can include with their request
    
</dd>
</dl>

<dl>
<dd>

**eventTypes:** `Optional<List<WebhooksPostWebhooksRequestBodyEventTypesItem>>` — [beta] The list of event types associated with a particular event type
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — The  name of the webhook. This will appear in both Samsara’s cloud dashboard and the API. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — The url of the webhook. This will appear in both Samsara’s cloud dashboard and the API. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**version:** `Optional<WebhooksPostWebhooksRequestBodyVersion>` — The version of the webhook.  Valid values: `2018-01-01`, `2021-06-09`, `2022-09-13`, `2024-02-27`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.getWebhook(id) -> WebhooksGetWebhookResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a webhook with given ID.

 <b>Rate limit:</b> 5 requests/sec (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Read Webhooks** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().getWebhook(
    "id",
    GetWebhookRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — ID of the webhook. This is the Samsara-specified ID.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.deleteWebhook(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a webhook with the given ID.

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Webhooks** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().deleteWebhook(
    "id",
    DeleteWebhookRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the webhook to delete.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.patchWebhook(id, request) -> WebhooksPatchWebhookResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a specific webhook's information.  **Note** this implementation of patch uses [the JSON merge patch](https://tools.ietf.org/html/rfc7396) proposed standard.
 This means that any fields included in the patch request will _overwrite_ fields which exist on the target resource.
 For arrays, this means any array included in the request will _replace_ the array that exists at the specified path, it will not _add_ to the existing array

 <b>Rate limit:</b> 100 requests/min (learn more about rate limits <a href="https://developers.samsara.com/docs/rate-limits" target="_blank">here</a>).

To use this endpoint, select **Write Webhooks** under the Setup & Administration category when creating or editing an API token. <a href="https://developers.samsara.com/docs/authentication#scopes-for-api-tokens" target="_blank">Learn More.</a>
 

 **Submit Feedback**: Likes, dislikes, and API feature requests should be filed as feedback in our <a href="https://forms.gle/zkD4NCH7HjKb7mm69" target="_blank">API feedback form</a>. If you encountered an issue or noticed inaccuracies in the API documentation, please <a href="https://www.samsara.com/help" target="_blank">submit a case</a> to our support team.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().patchWebhook(
    "id",
    WebhooksPatchWebhookRequestBody
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — Unique identifier for the webhook to update.
    
</dd>
</dl>

<dl>
<dd>

**customHeaders:** `Optional<List<CustomHeadersObjectRequestBody>>` — The list of custom headers that users can include with their request
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The  name of the webhook. This will appear in both Samsara’s cloud dashboard and the API. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**url:** `Optional<String>` — The url of the webhook. This will appear in both Samsara’s cloud dashboard and the API. It can be set or updated through the Samsara Dashboard or through the API at any time.
    
</dd>
</dl>

<dl>
<dd>

**version:** `Optional<WebhooksPatchWebhookRequestBodyVersion>` — The version of the webhook.  Valid values: `2018-01-01`, `2021-06-09`, `2022-09-13`, `2024-02-27`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Fleet Attributes
<details><summary><code>client.fleet.attributes.update(id)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.fleet().attributes().update(
    "id",
    UpdateAttributesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>
