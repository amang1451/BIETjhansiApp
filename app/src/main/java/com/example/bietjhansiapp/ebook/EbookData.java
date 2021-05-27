package com.example.bietjhansiapp.ebook;

public class EbookData {
    private String ebookTitle,ebookUrl;

    public EbookData() {
    }

    public String getEbookTitle() {
        return ebookTitle;
    }

    public void setEbookTitle(String ebookTitle) {
        this.ebookTitle = ebookTitle;
    }

    public String getEbookUrl() {
        return ebookUrl;
    }

    public void setEbookUrl(String ebookUrl) {
        this.ebookUrl = ebookUrl;
    }

    public EbookData(String ebookTitle, String ebookUrl) {
        this.ebookTitle = ebookTitle;
        this.ebookUrl = ebookUrl;
    }
}
