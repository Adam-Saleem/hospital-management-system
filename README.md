# Hospital-Management-System
This REST API project for a Hospital Management System composed of doctors, patients, appointments, and treatments. It follows CRUD principles, enabling users to create, read, update, and delete records. The API allows for creating doctor and patient profiles, scheduling appointments, and recording treatments. It also provides retrieval and updating capabilities for accessing and managing information. By implementing this REST API, the hospital can streamline operations, improve communication, and enhance patient care through effective information management.

This is the uml class diagram for the resources in system bellow:

![SharedScreenshot](https://github.com/Adam-Saleem/hospital-management-system/assets/104377209/29d27ea7-ad53-4489-bb82-c90d2a1e04bd)

###  To run the project
```bash
java -jar .\target\rest-api-0.0.1-SNAPSHOT.jar
```
#### OR
```bash
.\mvnw spring-boot:run
```
### Testing 
Postman/SOAPUI will be good option to use.


# Rest Api Documentation
## Doctor 
<table>
        <thead>
            <tr>
                <th>HTTP Method</th>
                <th>URL Path</th>
                <th>Status Code</th>
                <th>Description</th>
                <th>Request</th>
                <th>Response</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>POST</td>
                <td>/doctor</td>
                <td>201 Created</td>
                <td>Create Doctor</td>
                <td>localhost:8080/doctor
                    <code>Body</code>:
                    {
                    "id":"1",
                    "name": "Adam Saleem",
                    "phoneNumber": "0595498633",
                    "address": "salfeet"
                    }
                </td>
                <td>{
                    "id": 1,
                    "name": "Adam Saleem",
                    "phoneNumber": "0595498633",
                    "address": "salfeet"
                    }
                </td>
            </tr>
            <tr>
                <td>GET</td>
                <td>/doctor</td>
                <td>200 OK</td>
                <td>Get All Doctor</td>
                <td>localhost:8080/doctor</td>
                <td>[
                    {
                    "id": 1,
                    "name": "Adam Saleem",
                    "phoneNumber": "0595498633",
                    "address": "salfeet"
                    }
                    ]
                </td>
            </tr>
            <tr>
                <td>GET</td>
                <td>/doctor/{id}</td>
                <td>200 OK</td>
                <td>Get Doctor By Id</td>
                <td>localhost:8080/doctor/1</td>
                <td>{
                    "id": 1,
                    "name": "Adam Saleem",
                    "phoneNumber": "0595498633",
                    "address": "salfeet"
                    }
                </td>
            </tr>
            <tr>
                <td>PUT</td>
                <td>/doctor/{id}</td>
                <td>200 OK</td>
                <td>Update Doctor By Id</td>
                <td>localhost:8080/doctor/1
                    <code>Body</code>:
                    {
                    "name": "Adam Saleem 2",
                    "phoneNumber": "0595498633",
                    "address": "salfeet"
                    }
                </td>
                <td>{
                    "id": 1,
                    "name": "Adam Saleem 2",
                    "phoneNumber": "0595498633",
                    "address": "salfeet"
                    }
                </td>
            </tr>
            <tr>
                <td>DELETE</td>
                <td>/doctor/{id}</td>
                <td>200 OK</td>
                <td>Delete Doctor By Id</td>
                <td>localhost:8080/doctor/1</td>
                <td>Deleted successfully</td>
            </tr>
        </tbody>
    </table>
   
## Patient
<table>
        <thead>
            <tr>
                <th>HTTP Method</th>
                <th>URL Path</th>
                <th>Status Code</th>
                <th>Description</th>
                <th>Request</th>
                <th>Response</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>POST</td>
                <td>/patient</td>
                <td>201 Created</td>
                <td>Create Patient</td>
                <td>localhost:8080/patient
                    <code>Body</code>:
                    {
                    "id":"1",
                    "name": "Adam Saleem",
                    "birthDate": "2001-07-02",
                    "gender": "male",
                    "phoneNumber": "0595498633"
                    }
                </td>
                <td>{
                    "id": 1,
                    "name": "Adam Saleem",
                    "birthDate": "2001-07-02",
                    "gender": "male",
                    "phoneNumber": "0595498633"
                    }
                </td>
            </tr>
            <tr>
                <td>GET</td>
                <td>/patient</td>
                <td>200 OK</td>
                <td>Get All Patient</td>
                <td>localhost:8080/patient</td>
                <td>[
                    {
                    "id": 1,
                    "name": "Adam Saleem",
                    "birthDate": "2001-07-02",
                    "gender": "male",
                    "phoneNumber": "0595498633"
                    }
                    ]
                </td>
            </tr>
            <tr>
                <td>GET</td>
                <td>/patient/{id}</td>
                <td>200 OK</td>
                <td>Get Patient By Id</td>
                <td>localhost:8080/patient/1</td>
                <td>{
                    "id": 1,
                    "name": "Adam Saleem",
                    "birthDate": "2001-07-02",
                    "gender": "male",
                    "phoneNumber": "0595498633"
                    }
                </td>
            </tr>
            <tr>
                <td>PUT</td>
                <td>/patient/{id}</td>
                <td>200 OK</td>
                <td>Update Patient By Id</td>
                <td>localhost:8080/patient/1
                    <code>Body</code>:
                    {
                    "name": "Adam Saleem 2",
                    "birthDate": "2001-07-02",
                    "gender": "male",
                    "phoneNumber": "0595498633"
                    }
                </td>
                <td>{
                    "id": 1,
                    "name": "Adam Saleem 2",
                    "birthDate": "2001-07-02",
                    "gender": "male",
                    "phoneNumber": "0595498633"
                    }
                </td>
            </tr>
            <tr>
                <td>DELETE</td>
                <td>/patient/{id}</td>
                <td>200 OK</td>
                <td>Delete Patient By Id</td>
                <td>localhost:8080/patient/1</td>
                <td>Deleted successfully</td>
            </tr>
        </tbody>
</table>

## Treatment
<table>
        <thead>
            <tr>
                <th>HTTP Method</th>
                <th>URL Path</th>
                <th>Status Code</th>
                <th>Description</th>
                <th>Request</th>
                <th>Response</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>POST</td>
                <td>/treatment</td>
                <td>201 Created</td>
                <td>Create Treatment</td>
                <td>localhost:8080/treatment
                    <code>Body</code>:
                    {
                    "id": 1,
                    "name": "Acamol",
                    "price": 20,
                    "description": "Acamol caplet is intended to relieve pain and reduce fever."
                    }
                </td>
                <td>{
                    "id": 1,
                    "name": "Acamol",
                    "price": 20,
                    "description": "Acamol caplet is intended to relieve pain and reduce fever."
                    }
                </td>
            </tr>
            <tr>
                <td>GET</td>
                <td>/treatment</td>
                <td>200 OK</td>
                <td>Get All Treatment</td>
                <td>localhost:8080/treatment</td>
                <td>[
                    {
                    "id": 1,
                    "name": "Acamol",
                    "price": 20,
                    "description": "Acamol caplet is intended to relieve pain and reduce fever."
                    }
                    ]
                </td>
            </tr>
            <tr>
                <td>GET</td>
                <td>/treatment/{id}</td>
                <td>200 OK</td>
                <td>Get Treatment By Id</td>
                <td>localhost:8080/treatment/1</td>
                <td>{
                    "id": 1,
                    "name": "Acamol",
                    "price": 20,
                    "description": "Acamol caplet is intended to relieve pain and reduce fever."
                    }
                </td>
            </tr>
            <tr>
                <td>PUT</td>
                <td>/treatment/{id}</td>
                <td>200 OK</td>
                <td>Update Treatment By Id</td>
                <td>localhost:8080/treatment/1
                    <code>Body</code>:
                    {
                    "name": "Acamol 2",
                    "price": 20,
                    "description": "Acamol caplet is intended to relieve pain and reduce fever."
                    }
                </td>
                <td>{
                    "id": 1,
                    "name": "Acamol 2",
                    "price": 20,
                    "description": "Acamol caplet is intended to relieve pain and reduce fever."
                    }
                </td>
            </tr>
            <tr>
                <td>DELETE</td>
                <td>/treatment/{id}</td>
                <td>200 OK</td>
                <td>Delete Treatment By Id</td>
                <td>localhost:8080/treatment/1</td>
                <td>Deleted successfully</td>
            </tr>
        </tbody>
</table>

## Appointment
<table>
        <thead>
            <tr>
                <th>HTTP Method</th>
                <th>URL Path</th>
                <th>Status Code</th>
                <th>Description</th>
                <th>Request</th>
                <th>Response</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>POST</td>
                <td>/appointment</td>
                <td>201 Created</td>
                <td>Create Appointment</td>
                <td>localhost:8080/appointment
                    <code>Body</code>:
                    {
                    "id": 1,
                    "patient_id": 1,
                    "doctor_id": 1,
                    "appointment_date": "2023-05-20",
                    "payment": 300
                    }
                </td>
                <td>{
                    "id": 1,
                    "patient_id": 1,
                    "doctor_id": 1,
                    "appointment_date": "2023-05-20",
                    "payment": 300
                    }
                </td>
            </tr>
            <tr>
                <td>GET</td>
                <td>/appointment</td>
                <td>200 OK</td>
                <td>Get All Appointment</td>
                <td>localhost:8080/appointment</td>
                <td>[
                    {
                    "id": 1,
                    "patient_id": 1,
                    "doctor_id": 1,
                    "appointment_date": "2023-05-20",
                    "payment": 300
                    }
                    ]
                </td>
            </tr>
            <tr>
                <td>GET</td>
                <td>/appointment/{id}</td>
                <td>200 OK</td>
                <td>Get Appointment By Id</td>
                <td>localhost:8080/appointment/1</td>
                <td>{
                    "id": 1,
                    "patient_id": 1,
                    "doctor_id": 1,
                    "appointment_date": "2023-05-20",
                    "payment": 300
                    }
                </td>
            </tr>
            <tr>
                <td>PUT</td>
                <td>/appointment/{id}</td>
                <td>200 OK</td>
                <td>Update Appointment By Id</td>
                <td>localhost:8080/appointment/1
                    <code>Body</code>:
                    {
                    "patient_id": 1,
                    "doctor_id": 1,
                    "appointment_date": "2023-05-20",
                    "payment": 200
                    }
                </td>
                <td>{
                    "id": 1,
                    "patient_id": 1,
                    "doctor_id": 1,
                    "appointment_date": "2023-05-20",
                    "payment": 200
                    }
                </td>
            </tr>
            <tr>
                <td>DELETE</td>
                <td>/appointment/{id}</td>
                <td>200 OK</td>
                <td>Delete Appointment By Id</td>
                <td>localhost:8080/appointment/1</td>
                <td>Deleted successfully</td>
            </tr>
        </tbody>
</table>
