package com.developersbreach.xyzreader.model;

import com.developersbreach.xyzreader.repository.database.ArticleEntity;

public class Article extends ArticleEntity {

    private final int mArticleId;
    private final String mArticleTitle;
    private final String mArticleAuthorName;
    private final String mArticleBody;
    private final String mArticleThumbnail;
    private final double mArticleAspectRatio;
    private final String mArticlePublishedDate;

    public Article(int id, String title, String authorName, String body, String thumbnail,
                   double aspectRatio, String publishedDate) {
        super(id, title, authorName, body, thumbnail, aspectRatio, publishedDate);

        this.mArticleId = id;
        this.mArticleTitle = title;
        this.mArticleAuthorName = authorName;
        this.mArticleBody = body;
        this.mArticleThumbnail = thumbnail;
        this.mArticleAspectRatio = aspectRatio;
        this.mArticlePublishedDate = publishedDate;
    }

    @Override
    public int getArticleId() {
        return mArticleId;
    }

    @Override
    public String getArticleTitle() {
        return mArticleTitle;
    }

    @Override
    public String getArticleAuthorName() {
        return mArticleAuthorName;
    }

    @Override
    public String getArticleBody() {
        return mArticleBody;
    }

    @Override
    public String getArticleThumbnail() {
        return mArticleThumbnail;
    }

    @Override
    public double getArticleAspectRatio() {
        return mArticleAspectRatio;
    }

    @Override
    public String getArticlePublishedDate() {
        return mArticlePublishedDate;
    }
}
