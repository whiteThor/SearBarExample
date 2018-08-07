package musicmachine.sanples.android.ruben.com.searbarexample;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import musicmachine.sanples.android.ruben.com.searbarexample.adapter.RecyclerAdapter;
import musicmachine.sanples.android.ruben.com.searbarexample.model.Actor;
import musicmachine.sanples.android.ruben.com.searbarexample.model.Category;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, android.widget.SearchView.OnCloseListener{

    private Toolbar mTbMainSearch;
    private RecyclerView mRvToolbarSearch;
    private final String TAG= MainActivity.class.getSimpleName();
    private RecyclerAdapter mAdapter;
    private ArrayList<Category> mCategories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTbMainSearch = findViewById(R.id.toolBarSearch);
        mRvToolbarSearch = findViewById(R.id.listRecycleView);
        mCategories = new ArrayList<>();

        mCategories = ArrayItem.getData();

        mRvToolbarSearch.setLayoutManager(new LinearLayoutManager(this));
        mAdapter  = new RecyclerAdapter(this,mCategories);
        mRvToolbarSearch.setAdapter(mAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }




    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d(TAG, "OnQueryTextSymmit: Query->" + query);
     //   mAdapter.getFilter().filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(TAG, "OnQueryTextChange: Query->" + newText);
        ArrayList<Category> listFiltered;
        ArrayList<Actor> listFilteredAct;

        listFiltered = new ArrayList<>();

        for (Category row : ArrayItem.getData()) {
            listFilteredAct = new ArrayList<>();
            for (Actor actor: row.getItems() ) {
                if(actor.getName().contains(newText)){
                    listFilteredAct.add(actor);
                }
            }
            listFiltered.add(new Category(row.getTitle(), listFilteredAct));
        }
        mAdapter  = new RecyclerAdapter(this,listFiltered);
        mRvToolbarSearch.setAdapter(mAdapter);
     //   mAdapter.getFilter().filter(newText);

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem menuSearchItem = menu.findItem(R.id.menu_toolbarsearch) ;

        SearchView searchView = (SearchView) menuSearchItem.getActionView();
        searchView.setQueryHint("enter text");
        searchView.setOnQueryTextListener(this);
        Log.d(TAG, "onCreateoptionMenu: mSearchMenuItem->" + menuSearchItem.getActionView());

        return true;
    }



    @Override
    public boolean onClose() {
        mAdapter.getFilter().filter("");

        return false;
    }


}
