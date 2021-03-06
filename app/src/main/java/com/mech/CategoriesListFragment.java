package com.mech;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.google.common.collect.Lists;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;

/**
 * Created by Agustin on 15/7/2017.
 */

@EFragment(R.layout.fragment_categories_list)
public class CategoriesListFragment extends Fragment {

    private static final String TAG = CategoriesListFragment.class.getSimpleName();

    @ViewById(R.id.list_view)
    protected RecyclerView recyclerView;

    private List<Category> categoryList;
    protected CategoriesListAdapter categoriesListAdapter;

    private DividerItemDecoration dividerItemDecoration;
    protected LinearLayoutManagerWithSmoothScroller linearLayoutManagerWithSmoothScroller;

    @AfterInject
    protected void afterInject() {
        populateAdapter();
    }

    protected void populateAdapter() {
        categoryList = Lists.newArrayList();
        Category category1 = new Category();
        category1.setName("Placas");
        category1.setDetail("Amplio catalogo de placas de madera, cortes personalizados");
        category1.setPictureId(R.drawable.melamina);
        categoryList.add(category1);

        Category category2 = new Category();
        category2.setName("Herrajes");
        category2.setDetail("Encuentre los herrajes de las marcas mas reconocidas");
        category2.setPictureId(R.drawable.herrajes);
        categoryList.add(category2);

        Category category3 = new Category();
        category3.setName("Herramientas");
        category3.setDetail("La mayor variedad de herramientas de alta calidad");
        category3.setPictureId(R.drawable.herramientas);
        categoryList.add(category3);

        categoriesListAdapter = new CategoriesListAdapter(categoryList);
        categoriesListAdapter.initializeListeners(new FlexibleAdapter.OnItemClickListener() {
            @Override
            public boolean onItemClick(int position) {
                ProductsListActivity_.intent(getContext()).start();
                return false;
            }
        });
    }

    @AfterViews
    protected void afterViews() {
        recyclerView.setAdapter(categoriesListAdapter);
        recyclerView.setHasFixedSize(true);
        linearLayoutManagerWithSmoothScroller = new LinearLayoutManagerWithSmoothScroller(getActivity());
        dividerItemDecoration = new DividerItemDecoration(getResources().getDrawable(R.drawable.divider_list));
        recyclerView.setLayoutManager(linearLayoutManagerWithSmoothScroller);
        recyclerView.addItemDecoration(dividerItemDecoration);

        setupView();

        getActivity().setTitle(R.string.title_categories_fragment);
    }

    private void setupView() {
        refreshList();
    }

    @UiThread
    protected void refreshList() {
        categoriesListAdapter.setItems(categoryList);
        categoriesListAdapter.notifyDataSetChanged();
    }
}
