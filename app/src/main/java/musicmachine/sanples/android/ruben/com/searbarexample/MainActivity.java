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

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private Toolbar mTbMainSearch;
    private RecyclerView mRvToolbarSearch;
    private final String TAG= MainActivity.class.getSimpleName();
    private ArrayAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        mAdapter  = new ArrayAdapter();

        mTbMainSearch = findViewById(R.id.toolBarSearch);
        mRvToolbarSearch = findViewById(R.id.listRecycleView);

        mRvToolbarSearch.setAdapter(mAdapter);
        mRvToolbarSearch.setLayoutManager(new LinearLayoutManager(this));

//        setSupportActionBar(mTbMainSearch);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d(TAG, "OnQueryTextSymmit: Query->" + query);
        mAdapter.getFilter().filter(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(TAG, "OnQueryTextChange: Query->" + newText);
        mAdapter.getFilter().filter(newText);
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
}
