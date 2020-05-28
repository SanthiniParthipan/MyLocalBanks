package sg.edu.rp.c346.id19028654.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDbS,btnOcbC, btnUoB;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDbS=findViewById(R.id.buttonDBIS);
        btnOcbC=findViewById(R.id.buttonOCBC);
        btnUoB=findViewById(R.id.buttonUOB);

        registerForContextMenu(btnDbS);
        registerForContextMenu(btnOcbC);
        registerForContextMenu(btnUoB);



    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.equals(btnDbS)==true){
            menu.add(0, 0, 0, "Website");
            menu.add(0, 1, 1, "Contact Bank");
        }
        if(v.equals(btnOcbC)==true){

            menu.add(0, 2, 2, "Website");
            menu.add(0, 3, 3, "Contact Bank");
        }
        else if (v.equals(btnUoB)==true) {
            menu.add(0, 4, 4, "Website");
            menu.add(0, 5, 5, "Contact Bank");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId()==0){
            //code for action
            Intent dbsweb =new Intent(Intent.ACTION_VIEW, Uri.parse((getString(R.string.dbsurl))));
            startActivity(dbsweb);

            return true; //menu item successfully handled

        }else if(item.getItemId()==1) { //check whether the selected menu item ID is 0
            //code for action
            Intent dbsCall =new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:"+getString(R.string.dbstel))));
            startActivity(dbsCall);
            return true; //menu item successfully handled

        }
        else if(item.getItemId()==2) {
            //code for action

            Intent ocbcweb =new Intent(Intent.ACTION_VIEW, Uri.parse((getString(R.string.ocbcurl))));
            startActivity(ocbcweb);


            return true;  //menu item successfully handled
        }
        else if (item.getItemId()==3){
            Intent ocbcCall =new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:"+getString(R.string.ocbctel))));
            startActivity(ocbcCall);

        }
        else if (item.getItemId()==4){
            Intent uobweb =new Intent(Intent.ACTION_VIEW, Uri.parse((getString(R.string.uobweb))));
            startActivity(uobweb);

        }
        else if (item.getItemId()==6){

            Intent uobCall =new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:"+getString(R.string.uobtel))));
            startActivity(uobCall);
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDbS.setText(getString(R.string.dbs));
            btnOcbC.setText(getString(R.string.ocbc));
            btnUoB.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.ChineseSelection) {
            btnDbS.setText(getString(R.string.chiDBS));
            btnOcbC.setText(getString(R.string.chiocbc));
            btnUoB.setText(getString(R.string.chineseuob));
            return true;
        } else {
            btnUoB.setText("Error translation");
            btnOcbC.setText("Error translation");
            btnDbS.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }



}

