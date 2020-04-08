public class Message {
   private String sender;
   private String text;

    public Message(String username, String text) {
        this.text=text;
        this.sender=username;
    }
    public Message(){}

    public void setSender(String sender) {
        this.sender=sender;
    }

    public void setText(String text) {
        this.text=text;
    }
    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }
}
