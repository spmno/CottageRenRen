package com.spmno.cottagerenren;

import android.app.ExpandableListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.spmno.cottagerenren.AppBaseActivity;
import com.spmno.cottagerenren.adapter.LeftPanelExListViewAdapter;
import com.spmno.cottagerenren.entity.LeftPanelListItem;

import java.util.ArrayList;
import java.util.List;

public class LeftPanelActivity extends AppBaseActivity {

    private ImageView userIcon;
    private TextView nickName;
    private ExpandableListView expandableListView;
    private LeftPanelExListViewAdapter exListViewAdapter;
    private List<LeftPanelListItem> listItems = new ArrayList<LeftPanelListItem>();
    private String[] groupNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupView() {
        userIcon = (ImageView)findViewById(R.id.iv_user_icon);
        nickName = (TextView)findViewById(R.id.tv_nickname);
        expandableListView = (ExpandableListView)findViewById(R.id.elv_list_view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_left_panel;
    }

    @Override
    protected void initData() {
        Resources resources = this.getResources();
        groupNames = resources.getStringArray(R.array.left_panel_group_names);
        String[] firstGroupNames = resources.getStringArray(R.array.left_panel_first_group_names);
        String[] secondGroupNames = resources.getStringArray(R.array.left_panel_second_group_names);
        String[] thirdGroupNames = resources.getStringArray(R.array.left_panel_third_group_names);

        int[] firstGroupIcon = {
             R.drawable.left_panel_item_newsfeed_icon_selector,
                R.drawable.left_panel_item_message_icon_selector,
                R.drawable.left_panel_item_chat_icon_selector,
                R.drawable.left_panel_item_friends_icon_selector,
                R.drawable.left_panel_item_search_icon_selector,
        };

        int[] secondGroupIcon = {
                R.drawable.left_panel_item_location_icon_selector,
                R.drawable.left_panel_item_mainpage_icon_selector,
                R.drawable.left_panel_item_hot_icon_selector,
                R.drawable.left_panel_item_apps_icon_selector,
        };

        int[] thirdGroupIcon = {
                R.drawable.left_panel_item_settings_icon_selector,
                R.drawable.left_panel_item_layout_icon_selector,
        };

        addGroup(0, firstGroupNames, firstGroupIcon);
        addGroup(1, secondGroupNames, secondGroupIcon);
        addGroup(2, thirdGroupNames, thirdGroupIcon);

        exListViewAdapter = new LeftPanelExListViewAdapter(this, listItems);
        expandableListView.setAdapter(exListViewAdapter);
        
    }

    private void addGroup(int groupId, String[] names, int[] icons) {
        LeftPanelListItem listItem = new LeftPanelListItem();
        listItem.setId(groupId);
        listItem.setName(groupNames[groupId]);

        ArrayList<LeftPanelListItem> firstGroup = new ArrayList<LeftPanelListItem>();
        for (int i = 0; i < names.length; ++i) {
            LeftPanelListItem leftPanelListItem = new LeftPanelListItem();
            leftPanelListItem.setId(i);
            leftPanelListItem.setName(names[i]);
            leftPanelListItem.setDrawableId(icons[i]);
            firstGroup.add(leftPanelListItem);
        }

        listItem.setGroups(firstGroup);
        listItems.add(listItem);
    }

}
