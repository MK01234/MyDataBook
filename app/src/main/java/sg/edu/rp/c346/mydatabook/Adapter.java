package sg.edu.rp.c346.mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<String> {
    private Context context;
    private String[] value;
    ImageView iv;
    TextView tv;

    public Adapter(Context context, int resource, String[] values) {
        super(context, resource, values);
        value = values;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_row, parent, false);

        iv = rowView.findViewById(R.id.iv);
        tv = rowView.findViewById(R.id.tv);
        tv.setText(value[position]);
        String cat =  value[position];

        if (cat.startsWith("Bio")) {
            iv.setImageResource(android.R.drawable.ic_dialog_info);
        } else if (cat.startsWith("Anni")) {
            iv.setImageResource(android.R.drawable.ic_menu_edit);
        } else if (cat.startsWith("About")){
            iv.setImageResource(android.R.drawable.ic_menu_my_calendar);
        } else {
            iv.setImageResource(android.R.drawable.star_big_on);
        }
        return rowView;
    }
}