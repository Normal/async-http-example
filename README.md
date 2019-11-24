# Build and run

    sbt assembly
    java -jar target/scala-2.13/http-async.jar $USER_ID
    
# Example

    java -jar target/scala-2.13/http-async.jar 1
    {
      "user" : {
        "id" : 1,
        ....
      "posts" : [ {
          "userId" : 1,
          "id" : 1,
        ...    