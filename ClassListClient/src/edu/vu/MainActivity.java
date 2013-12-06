package edu.vu;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map.Entry;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appspot.tasklistserver.tasklistserver.Tasklistserver;
import com.appspot.tasklistserver.tasklistserver.model.JsonMap;
import com.appspot.tasklistserver.tasklistserver.model.Task;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.ArrayMap;


public class MainActivity extends ListActivity {

    private Tasklistserver service;
    private NetworkTask netTask;
    private final ArrayList<Task> mTasks = new ArrayList<Task>();
    private TaskAdapter mAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Tasklistserver.Builder builder = new Tasklistserver.Builder(
                AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
        service = builder.build();

        netTask = new NetworkTask(getApplicationContext());

        final EditText et1 = (EditText) findViewById(R.id.editText1);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        final EditText et3 = (EditText) findViewById(R.id.editText3);
        final EditText et4 = (EditText) findViewById(R.id.editText4);

        final Button add = (Button) findViewById(R.id.button1);

        add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(final View v) {
                final String[] params = new String[4];
                params[0] = et1.getText().toString();
                params[1] = et2.getText().toString();
                params[2] = et3.getText().toString();
                params[3] = et4.getText().toString();
                netTask.execute(params);
            }
        });

        mTasks.add(new Task());
        final Task[] temp = new Task[mTasks.size()];
        mTasks.toArray(temp);
        mAdapter = new TaskAdapter(this, temp);
        setListAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private class NetworkTask extends AsyncTask<String, Void, Task>{
        Context context;
        private JsonMap list;

        public NetworkTask(final Context context) {
            this.context = context;
        }

        protected Task doInBackground(final String... params) {
            Task task = null;

            try {
                task = service.addtask(params[0], params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3])).execute();
                list = service.gettasks().execute();

            } catch (final IOException e) {
                Log.d("TaskList", e.getMessage(), e);
            }
            return task;
        }

        protected void onPostExecute(final Task task) {
            Toast.makeText(context, "Created: " + task.toString(), Toast.LENGTH_SHORT).show();
            for (final Entry<String, Object> x : list.entrySet()) {
                Log.e("list", x.getValue().toString());
                try {
                    final ArrayMap temp = (ArrayMap) x.getValue();
                    final Task cur = new Task();
                    cur.setName((String) temp.getValue(0));
                    cur.setTime((String) temp.getValue(1));
                    cur.setLat(((BigDecimal) temp.getValue(2)).intValue());
                    cur.setLon(((BigDecimal) temp.getValue(3)).intValue());
                    mTasks.add(cur);
                    mAdapter.notifyDataSetChanged();
                    updateListSize(mTasks.size());
                } catch (final ClassCastException e) {
                    Log.e("", "ClassCastException happened!", e);
                }
            }
        }
    }

    class TaskAdapter extends ArrayAdapter<Task> {
        Activity context;
        Task[] data;

        TaskAdapter(final Activity context, final Task[] adapterInput) {
            super(context, R.layout.row, adapterInput);
            this.context=context;
            data = adapterInput;
        }

        @Override
        public View getView(final int position, final View convertView, final ViewGroup parent) {
            final View ret;


            /*if (position == 0) {
                final LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ret = li.inflate(R.layout.add_item, null);

                final EditText et1 = (EditText) ret.findViewById(R.id.editText1);
                final EditText et2 = (EditText) ret.findViewById(R.id.editText2);
                final EditText et3 = (EditText) ret.findViewById(R.id.editText3);
                final EditText et4 = (EditText) ret.findViewById(R.id.editText4);

                final Button add = (Button) ret.findViewById(R.id.button1);

                add.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(final View v) {
                        final Object[] params = new Object[4];
                        params[0] = et1.getText().toString();
                        params[1] = et2.getText().toString();
                        params[2] = et3.getText().toString();
                        params[3] = et4.getText().toString();
                        netTask.execute(params);
                    }
                });

                return ret;
            } else {*/
                if (data[position] != null) {
                    if (convertView == null || convertView.getId() != R.id.good_row_id) {
                        final LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        ret = li.inflate(R.layout.row, null);
                    } else {
                        ret = convertView;
                    }

                    ((CheckBox) ret.findViewById(R.id.cbox1)).setChecked(false);
                    ((TextView) ret.findViewById(R.id.tvid)).setText(data[position].getName()+"");
                    ((TextView) ret.findViewById(R.id.tvdesc)).setText(data[position].getLat() + "," + data[position].getLon());
                    ((TextView) ret.findViewById(R.id.tvdue)).setText(data[position].getTime());

                    return ret;
                } else {
                    return null;
                }
            /*}*/

        }
    }

    private void updateListSize(final int size) {
        final Task[] temp = new Task[size];
        mTasks.toArray(temp);
        mAdapter = new TaskAdapter(this, temp);
        setListAdapter(mAdapter);
    }

}
