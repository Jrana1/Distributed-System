package org.example;
    import jakarta.ws.rs.client.ClientBuilder;
    import jakarta.ws.rs.client.Entity;
    import jakarta.ws.rs.client.Invocation;
    import jakarta.ws.rs.client.WebTarget;
    import jakarta.ws.rs.core.MediaType;
    import jakarta.ws.rs.core.Response;
    import jakarta.xml.bind.JAXBContext;
    import jakarta.xml.bind.JAXBException;
    import jakarta.xml.bind.Unmarshaller;
    import org.w3c.dom.Document;
    import org.w3c.dom.Element;
    import org.w3c.dom.Node;
    import org.w3c.dom.NodeList;
    import org.xml.sax.InputSource;
    import org.xml.sax.SAXException;
    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.parsers.ParserConfigurationException;
    import java.io.IOException;
    import java.io.StringReader;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

public class Client {

        private static String base_url = "http://localhost:8080/";
        private static List<String>subjectsUni1=new ArrayList<>();
        private static List<String>subjectsUni2=new ArrayList<>();
        public static void main(String[] args) throws JAXBException, ParserConfigurationException, IOException, SAXException {
            getAllStudents("uni2");
            addStudent("uni2","Jacob","03-12-2005","Math");
            addStudent("uni2","Martin","03-12-2005","Math");
            addStudent("uni2","Bon","03-12-2005","Math");

            //getAllStudents("uni1");
            getStudentByName("uni2","Bon");
            changeSubjectByName("uni2","Bon","cse");
            changeSubjectByName("uni2","Martin","cse");
            getUniName("uni2");
            System.out.println(String.format("number of cse student in uni2: %d",getCSEStudentCount("uni2")));
        }

        private static int getCSEStudentCount(String uniName){

            int cnt=0;
            if(uniName.equals("uni1")) {
                for (String subject : subjectsUni1) {
                    if (subject.equals("cse")) {
                        cnt++;

                    }
                }
            }
            if(uniName.equals("uni2")) {
                for (String subject : subjectsUni2) {
                    if (subject.equals("cse")) {
                        cnt++;

                    }
                }
            }
            return cnt;
        }

        public static void getUniName(String uniName){
            jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
            WebTarget target = client.target(base_url).path(String.format("%s/uni-name",uniName));
            Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN);
            Response response = builder.get();
            System.out.println("University name: "+response.readEntity(String.class));
        }

    public static void getAllStudents(String uniName) throws JAXBException, ParserConfigurationException, IOException, SAXException {
        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target(base_url).path(String.format("%s/students",uniName));
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.get();
        String body=response.readEntity(String.class);


        System.out.println(String.format("List of Students as XML from %s: %s",uniName,body));

       // System.out.println(body);
        response.close();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document =  builder.parse(new InputSource(new StringReader(body)));
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName("student");
        subjectsUni1.clear();
        subjectsUni2.clear();
        for(int i=0;i<nodeList.getLength();i++){

            Node node = nodeList.item(i);
            if(node.getNodeType()== Node.ELEMENT_NODE){
                Element student = (Element) node;
               /* System.out.println(student.getElementsByTagName("name").item(0).getTextContent()
                        +" "+student.getElementsByTagName("DOB").item(0).getTextContent()
                        +" "+student.getElementsByTagName("subject").item(0).getTextContent());*/
                //System.out.println("lauf");
                if(uniName.equals("uni1"))
                subjectsUni1.add(student.getElementsByTagName("subject").item(0).getTextContent().toString());
                if(uniName.equals("uni2"))
                    subjectsUni2.add(student.getElementsByTagName("subject").item(0).getTextContent().toString());

            }
        }
        client.close();
    }

    public static void addStudent(String uniName,String name, String dob, String subject){

        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target(base_url).path(String.format("%s/add-student",uniName))
                .queryParam("name",name)
                .queryParam("dob",dob)
                .queryParam("subject",subject);
        Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN);
        Response response = builder.post(Entity.text("none"));
        System.out.println(response.readEntity(String.class));
        response.close();
        client.close();
        //
    }

    public static void getStudentByName(String uniName,String name) throws JAXBException {
        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target(base_url).path(String.format("%s/student-name",uniName))
                .queryParam("name",name);
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.get();
        Student student=response.readEntity(Student.class);
        if(student!=null) {
            System.out.println(String.format("Student object found: %s", student.toString()));
        }else{
            System.out.println(String.format("Student with name %s was not found in %s",name,uniName));
        }
        response.close();

      /*  JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        StringReader reader = new StringReader(body);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Student st = (Student) unmarshaller.unmarshal(reader);
        System.out.println(st.getName());
        System.out.println(body);
        System.out.println(st.toString());*/
        client.close();

    }

    public static  void changeSubjectByName(String uniName,String name, String subject){

        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target(base_url).path(String.format("/%s/modify-subject",uniName))
                .queryParam("name",name)
                .queryParam("subject",subject);
        Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN);
        Response response = builder.put(Entity.text("null"));
        System.out.println(response.readEntity(String.class));
        response.close();
        client.close();
    }
}


