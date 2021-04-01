Basic To-Do-App using a React.js frontend and a Java Spring Boot back end
# **Todo-List Application**

_This app is focused on functionality and is my earliest project with  REACT.js_


### **Functionality**
Once complete this app should provide the following functionality:

* Add new tasks
* Delete tasks
* Edit task descriptions
* Set priority for each task
* Update data in server to represent user changes to the list

### **Considerations**
* _CORS policy_
  - I am running the frontend from localhost:3000 and the Spring server on localhost:8080 which in my case are the default ports.
  However if this app is ran with different ports for some reason, in addition to changing the frontend fetch addresses, @CrossOrigins annotation in the Controller will need to be changed to the required port.
  This will prevent the http request being blocked by the CORS policy.
* _Database_
  - At this stage I have not implemented a database and am using an ArrayList in the repository to store the todo tasks. This will be further amended to represent a fully operational database (PostgreSQL)
  once basic functionality between the frontend and server is achieved.
* _Aesthetic_
  - I have not given much thought into the aesthetic of this app as I am more concerned with the ability to create something increasingly functional. However, there might be potential to make
  this app more aesthetic once functionality is significantly improved. 

