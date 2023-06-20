package org.example;

import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.HashSet;

@Path("/uni1")
@Singleton
public class RestService1 {
   private University university;
   public RestService1(){
        this.university=new University("fra uas");
        this.university.addStudent("Max","22-07-1995","cse");
        this.university.addStudent("John","23-09-2000","eee");
    }
    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)

     public String hello(){

         return "hello,rest";
     }
     @Path("/students")
     @GET
     @Produces(MediaType.APPLICATION_XML)
    public HashSet<Student>retriveAllStudents(){

        return this.university.getAllStudents();
     }
     @Path("/student-name")
     @GET
     @Produces(MediaType.APPLICATION_XML)
     public Student getStudentByName(@QueryParam("name")String name){
       var st = university.getStudentByName(name);
       if(st!=null){
           return st;
       }
       else return null;
     }
     @Path("/add-student")
     @POST
     @Produces(MediaType.TEXT_PLAIN)
    public String addStudent(@QueryParam("name")String name, @QueryParam("dob")String dob,@QueryParam("subject")String subject){

         this.university.addStudent(name,dob,subject);
         return String.format("A Student with name %s has been added!!",name);
     }

     @Path("/uni-name")
     @GET
     @Produces(MediaType.TEXT_PLAIN)
     public String getUniName(){
       return  this.university.getUniName();
     }

    @Path("/modify-subject")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String modifySubjectByName(@QueryParam("name")String name, @QueryParam("subject")String subject){

        var st = this.university.getAllStudents().stream().filter(s->s.getName().equals(name)).findFirst().orElse(null);
        if(st==null){
            return String.format("student with name %s has not been found!!!!!!",name);
        }
        String prevSub=st.getSubject();
        st.setSubject(subject);
        return String.format("subject has been modified from %s to %s",prevSub,subject);

    }

}