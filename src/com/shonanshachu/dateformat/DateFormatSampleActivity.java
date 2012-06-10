package com.shonanshachu.dateformat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * @author dommy <shonan.shachu at gmail.com>
 *
 */
public class DateFormatSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView list = (ListView) findViewById(R.id.list);
        List<String> formats = new ArrayList<String>();
        formats.add("yyyy.MM.dd G 'at' HH:mm:ss z");
        formats.add("EEE, MMM d, ''yy");
        formats.add("EEE, dd MMM yyyy HH:mm:ss Z");
        formats.add("h:mm a");
        formats.add("hh 'o''clock' a, zzzz");
        formats.add("K:mm a, z");
        formats.add("yyyyy.MMMMM.dd GGG hh:mm aaa");
        formats.add("yyMMddHHmmssZ");
        formats.add("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        DateAdapter adapter = new DateAdapter(this, formats);
        list.setAdapter(adapter);
    }
}