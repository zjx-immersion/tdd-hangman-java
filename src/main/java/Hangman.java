
/*
 * Copyright 2008 Google Inc.
 *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/**
 * Created by jxzhong on 1/23/16.
 */
public class Hangman {
    private String practiseWordTemplate = new String();
    private String targetWord = new String();
    private String basicFilter = "aeiou";
    private Integer tries = 5;

    public void start(String practiseWord) {

        this.targetWord = practiseWord;
        initPracticeWordDefaultTemplate(targetWord);

        this.practiseWordTemplate = caculateTargetWord(this.basicFilter);
        this.tries = targetWord.length() + 1;
    }

    private void initPracticeWordDefaultTemplate(String practiceWord) {
        for (int i = 0; i < practiceWord.length(); i++) {
            practiseWordTemplate = practiseWordTemplate.concat("_");
        }
    }


    private String caculateTargetWord(String filter) {
        StringBuilder practiceWordBuild = new StringBuilder();
        char[] wordArray = targetWord.toCharArray();
        char[] practiceWordxArry = practiseWordTemplate.toCharArray();
        for (int i = 0; i < practiceWordxArry.length; i++) {
            char currentType = getCurrentType(filter, practiceWordxArry[i], wordArray[i]);
            practiceWordBuild.append(currentType);
        }
        return practiceWordBuild.toString();
    }

    private char getCurrentType(String filter, char currentType, char targetType) {
        if (filter.contains(String.valueOf(targetType))) {
            currentType = targetType;
        }
        return currentType;
    }

    public String getPractiseWordTemplate() {
        return practiseWordTemplate;
    }

    public Integer getTries() {
        return tries;
    }

    public Integer getWordLenth() {
        return this.practiseWordTemplate.length();
    }

    public String getCaculatedWord() {

        return this.practiseWordTemplate;
    }

    public Boolean caculate(String type) {

        String fillter = basicFilter.concat(type);
        String newPracticeWord = caculateTargetWord(fillter);
        Boolean isSuccess = !this.practiseWordTemplate.equals(newPracticeWord);
        this.tries--;

        if (isSuccess) {
            this.practiseWordTemplate = newPracticeWord;
            this.basicFilter = fillter;
            this.tries++;
        }

        return isSuccess;
    }

    public Boolean isWinTheGame() {
        return this.practiseWordTemplate.equals(this.targetWord) && this.tries > 0;
    }

    public Boolean isLoseTheGame() {

        return this.tries <= 0;
    }
}
