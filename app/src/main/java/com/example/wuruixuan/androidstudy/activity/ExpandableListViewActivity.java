package com.example.wuruixuan.androidstudy.activity;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

/**
 * 可展开的ListView
 */

public class ExpandableListViewActivity extends AppCompatActivity {

    private ExpandableListView elv;
    private String[] groups = {"好友", "联系人"};
    private String[][] children = {{"猪哥", "蛋蛋", "某人"}, {"老锅", "威哥", "阿珂"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        elv = findViewById(R.id.expandableListView);
        elv.setAdapter(new MyExpandableAdapter());
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ExpandableListViewActivity.this, children[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    class MyExpandableAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.group_layout, null);
            }
            ImageView icon = convertView.findViewById(R.id.icon);
            TextView title = convertView.findViewById(R.id.title);
//            icon.setImageResource();
            title.setText(groups[groupPosition]);
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.child_layout, null);
            }
            ImageView icon = convertView.findViewById(R.id.icon);
            TextView title = convertView.findViewById(R.id.title);
//            icon.setImageResource();
            title.setText(children[groupPosition][childPosition]);
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
