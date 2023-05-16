import java.io.Serializable;

public class Message implements Serializable {

   private String uniName;
   private String SName;
   private String BOD;
   private String subject;
   private String requestType;
   private String responseMsg;

    public Message(String requestType, String uniName, String SName, String BOD, String subject,String responseMsg) {
        this.uniName = uniName;
        this.SName = SName;
        this.BOD = BOD;
        this.subject = subject;
        this.requestType = requestType;
        this.responseMsg=responseMsg;
    }
    public String getResponseMsg(){

        return this.responseMsg;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getBOD() {
        return BOD;
    }

    public void setBOD(String BOD) {
        this.BOD = BOD;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
