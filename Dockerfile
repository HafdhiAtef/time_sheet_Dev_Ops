FROM openjdk:8
COPY target/time_sheet_Dev_Ops-1.0.jar time_sheet_Dev_Ops-1.0.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","time_sheet_Dev_Ops-1.0.jar"]
