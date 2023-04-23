package ch.zhaw.iwi.devops.demo;

public class Beer {

    private int id;
    private String title;
    private String recipe;

    public Beer() {
    }
    
    public Beer(int id, String title, String recipe) {
        this.id = id;
        this.title = title;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getRecipe() {
        return recipe;
    }
    
}
