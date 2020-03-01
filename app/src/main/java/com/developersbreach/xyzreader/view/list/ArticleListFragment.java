package com.developersbreach.xyzreader.view.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.developersbreach.xyzreader.R;
import com.developersbreach.xyzreader.databinding.FragmentArticleListBinding;
import com.developersbreach.xyzreader.model.Article;
import com.developersbreach.xyzreader.viewModel.ArticleListViewModel;

import java.util.List;


public class ArticleListFragment extends Fragment {

    private RecyclerView mArticleRecyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentArticleListBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_article_list, container, false);

        mArticleRecyclerView = binding.articlesRecyclerView;
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArticleListViewModel viewModel = new ViewModelProvider(this).get(ArticleListViewModel.class);

        viewModel.getArticleList().observe(getViewLifecycleOwner(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                ArticleAdapter adapter = new ArticleAdapter(new BoolItemListener());
                adapter.setArticleList(articles);
                mArticleRecyclerView.setAdapter(adapter);
            }
        });
    }

    private static class BoolItemListener implements ArticleAdapter.ArticleAdapterListener {
        /**
         * @param article get recipes from selected list of recipes.
         * @param view used to create navigation with controller, which needs view.
         */
        @Override
        public void onArticleSelected(Article article, View view) {
            NavDirections direction = ArticleListFragmentDirections
                    .actionArticleListFragmentToArticleDetailFragment(article);
            // Find NavController with view and navigate to destination using directions.
            Navigation.findNavController(view).navigate(direction);
        }
    }
}