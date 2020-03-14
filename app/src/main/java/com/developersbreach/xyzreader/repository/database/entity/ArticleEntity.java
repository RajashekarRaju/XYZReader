package com.developersbreach.xyzreader.repository.database.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.developersbreach.xyzreader.repository.database.ArticleDatabase;
import com.developersbreach.xyzreader.repository.database.dao.ArticleDao;


/**
 * This class will have a mapping SQLite "articles_table" in the {@link ArticleDatabase}.
 * This class fields are persisted once it is annotated with {@link Entity} and used as columns
 * in databases based on type of annotation they are assigned with. We pass this class entity into
 * database class with name.
 *
 * @see ArticleDao which uses this class table for queries.
 */
@Entity(tableName = "articles_table")
public class ArticleEntity implements Parcelable {

    /**
     * Each entity class requires at-least one primary key.
     * Fields need to be annotated as {@link ColumnInfo} with a name to generate rows and columns
     * inside the database properly.
     * <p>
     * Fields can be annotated as {@link Ignore} for not being used by room.
     */
    @PrimaryKey
    @ColumnInfo(name = "column_article_id")
    private int mArticleId;

    @ColumnInfo(name = "column_article_title")
    private String mArticleTitle;

    @ColumnInfo(name = "column_article_author_name")
    private String mArticleAuthorName;

    @ColumnInfo(name = "column_article_body")
    private String mArticleBody;

    @ColumnInfo(name = "column_article_thumbnail")
    private String mArticleThumbnail;

    @ColumnInfo(name = "column_article_published_date")
    private String mArticlePublishedDate;

    /////////////////// Getters /////////////////////

    public int getArticleId() {
        return mArticleId;
    }

    public String getArticleTitle() {
        return mArticleTitle;
    }

    public String getArticleAuthorName() {
        return mArticleAuthorName;
    }

    public String getArticleBody() {
        return mArticleBody;
    }

    public String getArticleThumbnail() {
        return mArticleThumbnail;
    }

    public String getArticlePublishedDate() {
        return mArticlePublishedDate;
    }

    ////////////////////// Setters ///////////////////////////////////////

    public void setArticleId(int id) {
        this.mArticleId = id;
    }

    public void setArticleTitle(String articleTitle) {
        this.mArticleTitle = articleTitle;
    }

    public void setArticleAuthorName(String authorName) {
        this.mArticleAuthorName = authorName;
    }

    public void setArticleBody(String articleBody) {
        this.mArticleBody = articleBody;
    }

    public void setArticleThumbnail(String articleThumbnail) {
        this.mArticleThumbnail = articleThumbnail;
    }

    public void setArticlePublishedDate(String articlePublishedDate) {
        this.mArticlePublishedDate = articlePublishedDate;
    }

    ///////////////////////////////////////////////////////////////////////////////

    /**
     * Each entity must either have a no-arg public constructor.
     */
    public ArticleEntity() {
    }

    /**
     * Let room know not to use this constructor by annotating with ignore.
     */
    @Ignore
    public ArticleEntity(int id, String title, String authorName, String body, String thumbnail,
                         String publishedDate) {
        this.mArticleId = id;
        this.mArticleTitle = title;
        this.mArticleAuthorName = authorName;
        this.mArticleBody = body;
        this.mArticleThumbnail = thumbnail;
        this.mArticlePublishedDate = publishedDate;
    }

    public static final Creator<ArticleEntity> CREATOR = new Creator<ArticleEntity>() {
        @Override
        public ArticleEntity createFromParcel(Parcel in) {
            return new ArticleEntity(in);
        }

        @Override
        public ArticleEntity[] newArray(int size) {
            return new ArticleEntity[size];
        }
    };

    private ArticleEntity(Parcel in) {
        mArticleId = in.readInt();
        mArticleTitle = in.readString();
        mArticleAuthorName = in.readString();
        mArticleBody = in.readString();
        mArticleThumbnail = in.readString();
        mArticlePublishedDate = in.readString();
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mArticleId);
        dest.writeString(mArticleTitle);
        dest.writeString(mArticleAuthorName);
        dest.writeString(mArticleBody);
        dest.writeString(mArticleThumbnail);
        dest.writeString(mArticlePublishedDate);
    }
}
