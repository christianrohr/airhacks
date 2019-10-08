package ff;

/**
 * Message
 */
public class Message {

    public String content;
    public int priority;

    public Message(String content, int priority) {
        this.content = content;
        this.priority = priority;
    }
}