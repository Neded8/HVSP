public class Something extends  Model{
    private String type;
    private String name;

    public void setType(String type){
        this.type = type;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }
}

