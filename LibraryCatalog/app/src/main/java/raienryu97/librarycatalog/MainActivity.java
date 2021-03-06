package raienryu97.librarycatalog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements AboutFragment.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri){

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent team = new Intent(MainActivity.this, AboutTeam.class);
            team.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(team);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        item.setChecked(true);


        if (id == R.id.nav_all) {
            Intent all = new Intent(MainActivity.this, AllBooks.class);
            all.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(all);
            finish();
        } else if (id == R.id.nav_computers) {
            Intent csc = new Intent(MainActivity.this, CSc.class);
            csc.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(csc);
            finish();
        } else if (id == R.id.nav_electronics) {
            Intent ele = new Intent(MainActivity.this, Ele.class);
            ele.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(ele);
            finish();
        } else if (id == R.id.nav_math) {
            Intent math = new Intent(MainActivity.this,Math.class);
            math.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(math);
            finish();
        } else if (id == R.id.nav_mechanical) {
            Intent mech = new Intent(MainActivity.this,Mech.class);
            mech.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mech);
            finish();
        } else if (id == R.id.nav_physics) {
            Intent phy = new Intent(MainActivity.this,Phy.class);
            phy.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(phy);
            finish();
        }else if (id == R.id.nav_about) {
            Intent about = new Intent(MainActivity.this, MainActivity.class);
            startActivity(about);
        }


        // Highlight the selected item, update the title, and close the drawer
        item.setChecked(true);
        if(id != R.id.nav_about)
        setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawers();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
