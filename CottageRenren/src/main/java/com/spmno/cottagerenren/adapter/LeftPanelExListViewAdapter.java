package com.spmno.cottagerenren.adapter;

import com.spmno.cottagerenren.R;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spmno.cottagerenren.entity.LeftPanelListItem;

import java.util.List;

/**
 * Created by spmno on 13-9-2.
 */
public class LeftPanelExListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<LeftPanelListItem> listItems;

    public LeftPanelExListViewAdapter(Context context, List<LeftPanelListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    public LeftPanelListItem getChild(int groupPosition, int childPosition) {
        return listItems.get(groupPosition).getGroups().get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = getItemLayout(80, R.drawable.v5_0_1_tabsbar_bg, 18, Color.GRAY, 30);
            viewHolder = new ViewHolder();
            viewHolder.groupName = (TextView) convertView.findViewById(0);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        LeftPanelListItem listItem = getChild(groupPosition, childPosition);
        viewHolder.groupName.setCompoundDrawablesRelativeWithIntrinsicBounds(listItem.getDrawableId(), 0, 0, 0);
        viewHolder.groupName.setCompoundDrawablePadding(10);
        viewHolder.groupName.setText(listItem.getName());

        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        return listItems.get(groupPosition).getGroups().size();
    }

    public LeftPanelListItem getGroup(int groupPosition) {
        return listItems.get(groupPosition);
    }

    public int getGroupCount() {
        return listItems.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = getItemLayout(60, R.drawable.v5_0_1_desktop_list_item, 15, Color.WHITE, 20);
            viewHolder = new ViewHolder();
            viewHolder.groupName = (TextView)convertView.findViewById(0);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.groupName.setText(getGroup(groupPosition).getName());
        return convertView;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class ViewHolder {
        public TextView groupName;
    }

    private LinearLayout getItemLayout(int height, int backgroundId, int textSize, int textColor, int padding) {
        LinearLayout linearLayout = new LinearLayout(context);
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        linearLayout.setBackgroundResource(backgroundId);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout.setLayoutParams(lp);

        TextView textView = new TextView(context);
        textView.setId(0);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        textView.setTextColor(textColor);
        textView.setPadding(padding, 0, 0, 0);

        linearLayout.addView(textView);
        return linearLayout;
    }

}
