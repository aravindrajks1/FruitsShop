package app.async.aravindraj.customlistcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String fruits[] ={"Apple","Apricot","Kiwi","lemon","Orange","Peach","Pear","Strawberry","Tomato"};
    int images[]={R.drawable.apple,R.drawable.apricot,R.drawable.kiwi,R.drawable.lemon,R.drawable.orange,R.drawable.peach,R.drawable.pear,R.drawable.strawberry,R.drawable.tomato};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Fruits Shop");
        lv=(ListView)findViewById(R.id.listview);
        customListAdapter adapter = new customListAdapter();
        lv.setAdapter(adapter);
    }

    public class customListAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return fruits.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            view=getLayoutInflater().inflate(R.layout.customlistview,null);
            ImageView imageView =(ImageView)view.findViewById(R.id.imageView);
            TextView textView = (TextView)view.findViewById(R.id.textview);
            final ImageButton imageButton = (ImageButton)view.findViewById(R.id.imageButton);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Toast.makeText(MainActivity.this, "Added 1Kg " +fruits[position]+" to the Cart", Toast.LENGTH_SHORT).show();

                }
            });
            imageView.setImageResource(images[position]);
            textView.setText(fruits[position]);
            return view;
        }
    }
}
