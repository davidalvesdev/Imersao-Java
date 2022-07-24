package br.com.david.linguagens.api;

@Document()

public class Linguagem {
    

    private String title;
    private String image;
    private int raking;

       

    public Linguagem(String title, String image, int raking) {
        this.title = title;
        this.image = image;
        this.raking = raking;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public int getRaking() {
        return raking;
    }


    
}
