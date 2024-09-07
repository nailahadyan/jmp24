package dev.nailah.jmppraktek;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DataMahasiswaActivity extends AppCompatActivity {

    private ListView listView; // Instance of ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

        listView = findViewById(R.id.listViewMahasiswa);
        showListFiles(); // Call method to show list of files
    }

    void showListFiles() {
        String pathDir = "DOCUMENT"; // Update with your directory path
        File directory = new File(getFilesDir(), pathDir); // Use getFilesDir() to get internal storage directory

        if (directory.exists()) {
            File[] files = directory.listFiles();
            String[] filenames = new String[files.length];
            String[] dateCreated = new String[files.length];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
            ArrayList<Map<String, Object>> itemDataList = new ArrayList<>();

            for (int i = 0; i < files.length; i++) {
                filenames[i] = files[i].getName();
                Date lastModDate = new Date(files[i].lastModified());
                dateCreated[i] = simpleDateFormat.format(lastModDate);

                Map<String, Object> listItemMap = new HashMap<>();
                listItemMap.put("name", filenames[i]);
                listItemMap.put("date", dateCreated[i]);
                itemDataList.add(listItemMap);
            }

            SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                    itemDataList, android.R.layout.simple_list_item_2,
                    new String[]{"name", "date"},
                    new int[]{android.R.id.text1, android.R.id.text2});

            listView.setAdapter(simpleAdapter); // Set adapter to ListView
        }
    }
}
