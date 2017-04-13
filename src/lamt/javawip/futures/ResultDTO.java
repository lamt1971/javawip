package lamt.javawip.futures;

public class ResultDTO {

    public String name;
    public boolean completed;
    
    public ResultDTO(String name) {
        super();
        this.name = name;
        this.completed = false;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    } 
    
    
}
