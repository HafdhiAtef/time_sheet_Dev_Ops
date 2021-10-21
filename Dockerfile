FROM openjdk:8
COPY target/time_sheet_Dev_Ops-0.0.1-SNAPSHOT.jar time_sheet_Dev_Ops-0.0.1-SNAPSHOT.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","/dtarget/time_sheet_Dev_Ops-0.0.1-SNAPSHOT.jar"]
