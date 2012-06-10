package com.shonanshachu.dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DateAdapter extends BaseAdapter{
	List<String> formats;
	LayoutInflater inflater;

	public class Holder {
		TextView format;
		TextView date;
		TextView dateUs;
	}

	public DateAdapter(Context context, List<String> formats) {
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.formats = formats;
	}

	@Override
	public int getCount() {
		return formats.size();
	}

	@Override
	public Object getItem(int position) {
		return formats.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		if(convertView == null) {
			holder = new Holder();
			convertView = inflater.inflate(R.layout.item_date, null);
			holder.format = (TextView) convertView.findViewById(R.id.item_format);
			holder.date = (TextView) convertView.findViewById(R.id.item_date);
			holder.dateUs = (TextView) convertView.findViewById(R.id.item_date_us);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		String format = formats.get(position);
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		holder.format.setText(format);
		holder.date.setText(df.format(date));
		df = new SimpleDateFormat(format, Locale.US);
		String dateUs = df.format(date);
		holder.dateUs.setText(df.format(date));
		df = new SimpleDateFormat(format);
		try {
			df.parse(dateUs);
		} catch (ParseException e) {
			Log.e("DateFormat", e.getMessage(), e);
		}
		return convertView;
	}
}
