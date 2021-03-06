package com.developersbreach.xyzreader.viewModel.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.developersbreach.xyzreader.model.Article;
import com.developersbreach.xyzreader.view.detail.ArticleDetailFragment;
import com.developersbreach.xyzreader.viewModel.ArticleDetailViewModel;

/**
 * A AndroidViewModelFactory for creating a instance of {@link ArticleDetailViewModel}
 * AndroidViewModel for fragment class {@link ArticleDetailFragment} with a constructor.
 */
public class ArticleDetailViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    // Needs to to be passed as parameter for AndroidViewModel class.
    private final Application mApplication;
    // Parcel model class Article as argument.
    private final Article mArticle;
    // Requires a string type argument which has name of the fragment.
    private final String mFragmentName;

    /**
     * Creates a {@link ViewModelProvider.AndroidViewModelFactory}
     *
     * @param application parameter to pass in {@link AndroidViewModel}
     * @param article     a user selected Article object to pass in {@link AndroidViewModel}
     */
    public ArticleDetailViewModelFactory(@NonNull Application application, Article article,
                                         String fragmentName) {
        super(application);
        this.mApplication = application;
        this.mArticle = article;
        this.mFragmentName = fragmentName;
    }

    /**
     * @param modelClass to check if our {@link ArticleDetailViewModel} model class is assignable.
     * @param <T>        type of generic class
     * @return returns the ViewModel class with passing parameters if instance is created.
     */
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ArticleDetailViewModel.class)) {
            //noinspection unchecked
            return (T) new ArticleDetailViewModel(mApplication, mArticle, mFragmentName);
        }
        throw new IllegalArgumentException("Cannot create Instance for ArticleDetailViewModel class");
    }
}
