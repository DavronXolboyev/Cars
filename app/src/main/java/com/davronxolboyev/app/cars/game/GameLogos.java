package com.davronxolboyev.app.cars.game;

public class GameLogos {
    private final int coorect;
    private final int image1;
    private final int image2;
    private final int image3;
    private final int image4;
    String question;

    public GameLogos(int coorect, int image1, int image2, int image3, int image4, String question) {
        this.coorect = coorect;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public int getCoorect() {
        return coorect;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public int getImage3() {
        return image3;
    }

    public int getImage4() {
        return image4;
    }
}
