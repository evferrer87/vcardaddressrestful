# Restful webservice

It provides places details using Google API and return them into vCard Format (v3.0):
## HTTP Methods

#### GET
##### /search?query=QUERY_STRING
Ex:
.../search?query=5757%20Guhn%20Road%20Houston

```json
[{
    "formatter_address":"5757 Guhn Rd, Houston, TX 77040, USA",
    "place_id":"ChIJA98cbYPFQIYRlEwbFpzpkrQ"
}]
```
##### /addressDetail?placeId=PLACE_ID
Ex:
/addressDetail?placeId=ChIJA98cbYPFQIYRlEwbFpzpkrQ
```json
{
    "vcard":"{
        BEGIN:VCARD
        VERSION:v3.0
        URL:
        ADR;TYPE=work:;;5757;Houston;;77040;United States
        TEL;TYPE=VOICE:
        GEO:29.849578;-95.515564
        END:VCARD
    }"
}
```
## Version of used technologies
```
java 1.8.0_31
SpringBoot 1.5.8.RELEASE
Gradlew 3.5.1
jackson-core-2.8.10
```

## Other features

```
Hexagonal architecture
Custom and centralized handler Exceptions
```