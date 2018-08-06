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

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

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
        setData();

        mRvToolbarSearch.setLayoutManager(new LinearLayoutManager(this));
        mAdapter  = new RecyclerAdapter(this,mCategories);
        mRvToolbarSearch.setAdapter(mAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }




    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d(TAG, "OnQueryTextSymmit: Query->" + query);
      //  mAdapter.getFilter().filter(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(TAG, "OnQueryTextChange: Query->" + newText);
     //   mAdapter.getFilter().filter(newText);
        return true;
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

    private void setData() {
        ArrayList<Actor> drama = new ArrayList<>();
        drama.add(new Actor("Tom Hardy",  "(541) 754-3010", "https://api.androidhive.info/json/images/tom_hardy.jpg"));
        drama.add(new Actor("Johnny Depp", "(452) 839-1210", "htps://api.androidhive.info/json/images/johnny.jpg"));
        drama.add(new Actor("Keira Knightley", "(535) 324-4334", "https://api.androidhive.info/json/images/keira.jpg"));
        drama.add(new Actor("Leonardo DiCaprio", "(564) 333-2452", "https://api.androidhive.info/json/images/leonardo.jpg"));
        drama.add(new Actor("Brad Pitt", "(567) 754-8945", "https://api.androidhive.info/json/images/brad.jpg"));
        drama.add(new Actor("Angelina Jolie", "(324) 754-5433", "https://api.androidhive.info/json/images/angelina.jpg"));
        drama.add(new Actor("Kate Winslet", "(788) 343-3433", "https://api.androidhive.info/json/images/kate.jpg"));
        drama.add(new Actor("Christian Bale", "(865) 755-3555", "https://api.androidhive.info/json/images/christian.jpg"));
        drama.add(new Actor("Morgan Freeman", "(445) 776-9076", "https://api.androidhive.info/json/images/morgan.jpg"));
        drama.add(new Actor("Scarlett Johanssonn", "(545) 454-2567", "https://api.androidhive.info/json/images/scarlett.jpg"));


        ArrayList<Actor> accion = new ArrayList<>();
        drama.add(new Actor("Tom Cruise",  "(541) 453-2311", "https://api.androidhive.info/json/images/tom_cruise.jpg"));
        drama.add(new Actor("Robert De Niro",  "(767) 544-8867", "https://api.androidhive.info/json/images/robert_de.jpg"));
        drama.add(new Actor("Russell Crowe",  "(234) 234-3321", "https://api.androidhive.info/json/images/russell.jpg"));
        drama.add(new Actor("Keanu Reeves",  "(454) 455-5445", "https://api.androidhive.info/json/images/keanu.jpg"));
        drama.add(new Actor("Robert Downey Jr.",  "(444) 444-4444", "https://api.androidhive.info/json/images/robert.jpg"));



        ArrayList<Actor> comedia = new ArrayList<>();
        drama.add(new Actor("Will Smith",  "(541) 879-3453", "https://api.androidhive.info/json/images/will.jpg"));
        drama.add(new Actor("Hugh Jackman",  "(544) 454-4544", "https://api.androidhive.info/json/images/hugh.jpg"));
        drama.add(new Actor("Tom Hanks",  "(541) 454-4544", "https://api.androidhive.info/json/images/tom.jpg"));

        mCategories.add(new Category("Drama",drama));
        mCategories.add(new Category("Accion",accion));
        mCategories.add(new Category("Comedia",comedia));



    }
}
