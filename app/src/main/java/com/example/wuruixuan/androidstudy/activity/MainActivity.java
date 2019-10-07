package com.example.wuruixuan.androidstudy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wuruixuan.androidstudy.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_linearLayout:
                switchActivity(LinearLayoutActivity.class);
                break;
            case R.id.btn_relativeLayout:
                switchActivity(RelativeLayoutActivity.class);
                break;
            case R.id.btn_tableLayout:
                switchActivity(TableLayoutActivity.class);
                break;
            case R.id.btn_frameLayout:
                switchActivity(FrameLayoutActivity.class);
                break;
            case R.id.btn_gridLayout:
                switchActivity(GridLayoutActivity.class);
                break;
            case R.id.btn_toast:
                switchActivity(ToastActivity.class);
                break;
            case R.id.btn_textView:
                switchActivity(TextViewActivity.class);
                break;
            case R.id.btn_editText:
                switchActivity(EditTextActivity.class);
                break;
            case R.id.btn_button:
                switchActivity(ButtonActivity.class);
                break;
            case R.id.btn_imageView:
                switchActivity(ImageViewActivity.class);
                break;
            case R.id.btn_checkBox:
                switchActivity(CheckBoxActivity.class);
                break;
            case R.id.btn_radioButton:
                switchActivity(RadioButtonActivity.class);
                break;
            case R.id.btn_toggleButton:
                switchActivity(ToggleButtonActivity.class);
                break;
            case R.id.btn_ratingBar:
                switchActivity(RatingBarActivity.class);
                break;
            case R.id.btn_spinner:
                switchActivity(SpinnerActivity.class);
                break;
            case R.id.btn_progressBar:
                switchActivity(ProgressBarActivity.class);
                break;
            case R.id.btn_alertDialog:
                switchActivity(AlertDialogActivity.class);
                break;
            case R.id.btn_timePickerDialog:
                switchActivity(TimePickerActivity.class);
                break;
            case R.id.btn_datePickerDialog:
                switchActivity(DatePickerActivity.class);
                break;
            case R.id.btn_timeAndDatePicker:
                switchActivity(TimePickerAndDatePickerActivity.class);
                break;
            case R.id.btn_gridView:
                switchActivity(GridViewActivity.class);
                break;
            case R.id.btn_gridView2:
                switchActivity(GridViewActivity2.class);
                break;
            case R.id.btn_listView:
                switchActivity(ListViewActivity.class);
                break;
            case R.id.btn_listView2:
                switchActivity(ListViewActivity2.class);
                break;
            case R.id.btn_listView3:
                switchActivity(ListViewActivity3.class);
                break;
            case R.id.btn_listView4:
                switchActivity(ListViewActivity4.class);
                break;
            case R.id.btn_listView5:
                switchActivity(ListViewActivity5.class);
                break;
            case R.id.btn_listView6:
                switchActivity(ListViewActivity6.class);
                break;
            case R.id.btn_expandableListView:
                switchActivity(ExpandableListViewActivity.class);
                break;
            case R.id.btn_imageSwitcher:
                switchActivity(ImageSwitcherActivity.class);
                break;
            case R.id.btn_textSwitcher:
                switchActivity(TextSwitcherActivity.class);
            case R.id.btn_viewFlipper:
                switchActivity(ViewFlipperActivity.class);
            case R.id.btn_optionsMenu:
                switchActivity(OptionsMenuActivity.class);
            case R.id.btn_contextMenu:
                switchActivity(ContextMenuActivity.class);
            case R.id.btn_popupMenu:
                switchActivity(PopupMenuActivity.class);
            case R.id.btn_viewPager:
                switchActivity(ViewPagerActivity.class);
            case R.id.btn_viewPager2:
                switchActivity(ViewPagerActivity2.class);
            case R.id.btn_popupWindow:
                switchActivity(PopupWindowActivity.class);
            case R.id.btn_notifications:
                switchActivity(NotificationsActivity.class);
                break;
        }
    }

    private void setListeners() {
        Button btn_linearLayout = findViewById(R.id.btn_linearLayout);
        Button btn_relativeLayout = findViewById(R.id.btn_relativeLayout);
        Button btn_tableLayout = findViewById(R.id.btn_tableLayout);
        Button btn_frameLayout = findViewById(R.id.btn_frameLayout);
        Button btn_gridLayout = findViewById(R.id.btn_gridLayout);
        Button btn_toast = findViewById(R.id.btn_toast);
        Button btn_textView = findViewById(R.id.btn_textView);
        Button btn_editText = findViewById(R.id.btn_editText);
        Button btn_button = findViewById(R.id.btn_button);
        Button btn_imageView = findViewById(R.id.btn_imageView);
        Button btn_checkBox = findViewById(R.id.btn_checkBox);
        Button btn_radioButton = findViewById(R.id.btn_radioButton);
        Button btn_toggleButton = findViewById(R.id.btn_toggleButton);
        Button btn_ratingBar = findViewById(R.id.btn_ratingBar);
        Button btn_spinner = findViewById(R.id.btn_spinner);
        Button btn_progressBar = findViewById(R.id.btn_progressBar);
        Button btn_alertDialog = findViewById(R.id.btn_alertDialog);
        Button btn_timePickerDialog = findViewById(R.id.btn_timePickerDialog);
        Button btn_datePickerDialog = findViewById(R.id.btn_datePickerDialog);
        Button btn_timeAndDatePicker = findViewById(R.id.btn_timeAndDatePicker);
        Button btn_gridView = findViewById(R.id.btn_gridView);
        Button btn_gridView2 = findViewById(R.id.btn_gridView2);
        Button btn_listView = findViewById(R.id.btn_listView);
        Button btn_listView2 = findViewById(R.id.btn_listView2);
        Button btn_listView3 = findViewById(R.id.btn_listView3);
        Button btn_listView4 = findViewById(R.id.btn_listView4);
        Button btn_listView5 = findViewById(R.id.btn_listView5);
        Button btn_listView6 = findViewById(R.id.btn_listView6);
        Button btn_expandableListView = findViewById(R.id.btn_expandableListView);
        Button btn_imageSwitcher = findViewById(R.id.btn_imageSwitcher);
        Button btn_textSwitcher = findViewById(R.id.btn_textSwitcher);
        Button btn_viewFlipper = findViewById(R.id.btn_viewFlipper);
        Button btn_optionsMenu = findViewById(R.id.btn_optionsMenu);
        Button btn_contextMenu = findViewById(R.id.btn_contextMenu);
        Button btn_popupMenu = findViewById(R.id.btn_popupMenu);
        Button btn_viewPager = findViewById(R.id.btn_viewPager);
        Button btn_viewPager2 = findViewById(R.id.btn_viewPager2);
        Button btn_popupWindow = findViewById(R.id.btn_popupWindow);
        Button btn_notifications = findViewById(R.id.btn_notifications);

        btn_linearLayout.setOnClickListener(this);
        btn_relativeLayout.setOnClickListener(this);
        btn_tableLayout.setOnClickListener(this);
        btn_frameLayout.setOnClickListener(this);
        btn_gridLayout.setOnClickListener(this);
        btn_toast.setOnClickListener(this);
        btn_textView.setOnClickListener(this);
        btn_editText.setOnClickListener(this);
        btn_button.setOnClickListener(this);
        btn_imageView.setOnClickListener(this);
        btn_checkBox.setOnClickListener(this);
        btn_radioButton.setOnClickListener(this);
        btn_toggleButton.setOnClickListener(this);
        btn_ratingBar.setOnClickListener(this);
        btn_spinner.setOnClickListener(this);
        btn_progressBar.setOnClickListener(this);
        btn_alertDialog.setOnClickListener(this);
        btn_timePickerDialog.setOnClickListener(this);
        btn_datePickerDialog.setOnClickListener(this);
        btn_timeAndDatePicker.setOnClickListener(this);
        btn_gridView.setOnClickListener(this);
        btn_gridView2.setOnClickListener(this);
        btn_listView.setOnClickListener(this);
        btn_listView2.setOnClickListener(this);
        btn_listView3.setOnClickListener(this);
        btn_listView4.setOnClickListener(this);
        btn_listView5.setOnClickListener(this);
        btn_listView6.setOnClickListener(this);
        btn_expandableListView.setOnClickListener(this);
        btn_imageSwitcher.setOnClickListener(this);
        btn_textSwitcher.setOnClickListener(this);
        btn_viewFlipper.setOnClickListener(this);
        btn_optionsMenu.setOnClickListener(this);
        btn_contextMenu.setOnClickListener(this);
        btn_popupMenu.setOnClickListener(this);
        btn_viewPager.setOnClickListener(this);
        btn_viewPager2.setOnClickListener(this);
        btn_popupWindow.setOnClickListener(this);
        btn_notifications.setOnClickListener(this);
    }

    private void switchActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
