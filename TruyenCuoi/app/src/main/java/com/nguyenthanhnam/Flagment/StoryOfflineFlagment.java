package com.nguyenthanhnam.Flagment;

import ConfigApp.ConfigApp;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.nguyenthanhnam.Activity.ActivityLoveStory;
import com.nguyenthanhnam.Activity.ReadActivity;
import com.nguyenthanhnam.Adapter.ListStoryAdapter;
import com.nguyenthanhnam.Adapter.MenuApadapter;
import com.nguyenthanhnam.DatabaseSqlite.DataBasemanager;
import com.nguyenthanhnam.Object.ItemMenu;
import com.nguyenthanhnam.Object.ItemStory;
import com.nguyenthanhnam.truyencuoi.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class StoryOfflineFlagment extends Fragment implements Serializable, View.OnClickListener, TabHost.OnTabChangeListener, AdapterView.OnItemClickListener {


    private TabHost mTabHost;
    private Button mBtnNga, mBtnAnh, mBtnNuocKhac, mBtnConGai, mBtnConTrai,
            mBtnCongNghe, mBtnDanGian, mBtnHocDuong, mBtnYhoc, mBtnKhoaHoc, mBtnSayXin, mBtnTrangQuynh, mBtnTieuLam;
    private ArrayList<ItemStory> listStory = new ArrayList<>();
    private ListView mListVietNam, mListForeign;
    private ListStoryAdapter adapter;
    private DataBasemanager mDataBasemanager;
    private DrawerLayout mDrawer;
    private ImageView mImageMenu;
    private ListView mListMenu;
    private List<ItemMenu> listMenu = new ArrayList<>();
    private MenuApadapter menuApadapter;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.flagment_storyofline,container,false);
        mDataBasemanager = new DataBasemanager(getActivity());
        initData();
        initmenu();
        findViewBys();
        init();
        setEvent();
        return rootView;
    }


    private void initData() {
        mDataBasemanager.selectStory("Con Gái", listStory);
    }

    public void initmenu() {
        listMenu.add(new ItemMenu(R.drawable.ic_heart_black, "Truyện Ua Thích"));
        listMenu.add(new ItemMenu(R.drawable.ic_application, "Ứng Dụng Khác"));
        listMenu.add(new ItemMenu(R.drawable.ic_star, "Đánh Gía"));
        listMenu.add(new ItemMenu(R.drawable.ic_exit, "Thoát"));
    }

    private void findViewBys() {
        mTabHost = (TabHost)rootView.findViewById(R.id.tabhost);
        mTabHost.setup();

        mListVietNam = (ListView)rootView. findViewById(R.id.lv_storyvietnam);
        mListForeign = (ListView) rootView.findViewById(R.id.lv_storyforeign);


        mBtnAnh = (Button) rootView.findViewById(R.id.btn_anh);
        mBtnNga = (Button) rootView.findViewById(R.id.btn_nga);
        mBtnNuocKhac = (Button) rootView.findViewById(R.id.btn_nuockhac);

        mBtnConGai = (Button) rootView.findViewById(R.id.btn_congai);
        mBtnConGai.setFocusable(true);
        mBtnConTrai = (Button) rootView.findViewById(R.id.btn_contrai);
        mBtnCongNghe = (Button) rootView.findViewById(R.id.btn_congnghe);
        mBtnDanGian = (Button) rootView.findViewById(R.id.btn_dangian);
        mBtnHocDuong = (Button) rootView.findViewById(R.id.btn_hocduong);
        mBtnKhoaHoc = (Button) rootView.findViewById(R.id.btn_khoahoc);
        mBtnSayXin = (Button) rootView.findViewById(R.id.btn_sayxin);
        mBtnTieuLam = (Button) rootView.findViewById(R.id.btn_tieulam);
        mBtnTrangQuynh = (Button) rootView.findViewById(R.id.btn_trangquynh);
        mBtnYhoc = (Button) rootView.findViewById(R.id.btn_yhoc);

        mImageMenu = (ImageView) rootView.findViewById(R.id.img_menu);

        mDrawer = (DrawerLayout) rootView.findViewById(R.id.drawer_layout);

        mListMenu = (ListView) rootView.findViewById(R.id.lv_face);


    }

    private void init() {
        mTabHost.getTabWidget().setDividerDrawable(R.drawable.tab_background);
        TabHost.TabSpec tabSpec1 = mTabHost.newTabSpec(ConfigApp.TAB_VIETNAM);
        tabSpec1.setContent(R.id.tab_vietnam);
        tabSpec1.setIndicator(ConfigApp.TAB_VIETNAM);
        mTabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = mTabHost.newTabSpec(ConfigApp.TAB_FOREIGN);
        tabSpec2.setContent(R.id.tab_foreign);
        tabSpec2.setIndicator(ConfigApp.TAB_FOREIGN);
        mTabHost.addTab(tabSpec2);

        menuApadapter = new MenuApadapter(getActivity(), listMenu);
        mListMenu.setAdapter(menuApadapter);

        adapter = new ListStoryAdapter(getActivity(), listStory);
        mListVietNam.setAdapter(adapter);

    }

    private void setEvent() {
        mBtnAnh.setOnClickListener(this);
        mBtnNga.setOnClickListener(this);
        mBtnNuocKhac.setOnClickListener(this);

        mBtnConGai.setOnClickListener(this);
        mBtnConTrai.setOnClickListener(this);
        mBtnCongNghe.setOnClickListener(this);
        mBtnDanGian.setOnClickListener(this);
        mBtnHocDuong.setOnClickListener(this);
        mBtnKhoaHoc.setOnClickListener(this);
        mBtnSayXin.setOnClickListener(this);
        mBtnTieuLam.setOnClickListener(this);
        mBtnTrangQuynh.setOnClickListener(this);
        mBtnYhoc.setOnClickListener(this);

        mTabHost.setOnTabChangedListener(this);
        mListForeign.setOnItemClickListener(this);
        mListVietNam.setOnItemClickListener(this);
        mImageMenu.setOnClickListener(this);

        mBtnSayXin.setOnClickListener(this);
        mListMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        mDrawer.closeDrawers();
                        Intent intent = new Intent(getActivity(), ActivityLoveStory.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_menu:
                mDrawer.openDrawer(Gravity.LEFT);
                break;
            case R.id.btn_anh:
                fillStoryForeign(mBtnAnh.getText().toString());
                break;
            case R.id.btn_nga:
                fillStoryForeign(mBtnNga.getText().toString());
                break;
            case R.id.btn_nuockhac:
                fillStoryForeign(mBtnNuocKhac.getText().toString());
                break;
            case R.id.btn_congai:
                fillStoryVietNam(mBtnConGai.getText().toString());
                break;
            case R.id.btn_contrai:
                fillStoryVietNam(mBtnConTrai.getText().toString());
                break;
            case R.id.btn_congnghe:
                fillStoryVietNam(mBtnCongNghe.getText().toString());
                break;
            case R.id.btn_dangian:
                fillStoryVietNam(mBtnDanGian.getText().toString());
                break;
            case R.id.btn_hocduong:
                fillStoryVietNam(mBtnHocDuong.getText().toString());
                break;
            case R.id.btn_khoahoc:
                fillStoryVietNam(mBtnKhoaHoc.getText().toString());
                break;
            case R.id.btn_sayxin:
                fillStoryVietNam(mBtnSayXin.getText().toString());
                break;
            case R.id.btn_tieulam:
                fillStoryVietNam(mBtnTieuLam.getText().toString());
                break;
            case R.id.btn_trangquynh:
                fillStoryVietNam(mBtnTrangQuynh.getText().toString());
                break;
            case R.id.btn_yhoc:
                fillStoryVietNam(mBtnYhoc.getText().toString());
                break;

            default:
                break;

        }
    }

    private void fillStoryVietNam(String type) {
        listStory.clear();
        mDataBasemanager.selectStory(type, listStory);
        adapter = new ListStoryAdapter(getActivity(), listStory);
        mListVietNam.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void fillStoryForeign(String type) {
        listStory.clear();
        mDataBasemanager.selectStory(type, listStory);
        adapter = new ListStoryAdapter(getActivity(), listStory);
        mListForeign.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onTabChanged(String tabId) {
        if (tabId.equals(ConfigApp.TAB_FOREIGN)) {
            listStory.clear();
            mDataBasemanager.selectStory(ConfigApp.STORY_DEFAULT_FOREIGN, listStory);
            mListForeign = (ListView) rootView.findViewById(R.id.lv_storyforeign);
            adapter = new ListStoryAdapter(getActivity(), listStory);
            mListForeign.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        if (tabId.equals(ConfigApp.TAB_VIETNAM)) {
            listStory.clear();
            mDataBasemanager.selectStory(ConfigApp.STORY_DEFAULT_VIETNAM, listStory);
            mListVietNam = (ListView) rootView.findViewById(R.id.lv_storyvietnam);
            adapter = new ListStoryAdapter(getActivity(), listStory);
            mListVietNam.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ReadActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ConfigApp.KEY_DATA_LISTSTORY, listStory);
        bundle.putInt(ConfigApp.KEY_POSITON, position);
        bundle.putString(ConfigApp.KEY_NAME_STORY, listStory.get(position).getNameStory());
        bundle.putInt(ConfigApp.KEY_ID, listStory.get(position).getId());
        bundle.putInt(ConfigApp.KEY_LIKE, listStory.get(position).getLike());
        intent.putExtra(ConfigApp.DATA_STORY, bundle);
        adapter.setPositioncurrent(position);
        adapter.notifyDataSetChanged();
        startActivityForResult(intent, ConfigApp.REQUEST_CODE);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            int position = data.getIntExtra(ConfigApp.RESUILT_DATA, -1);
            adapter.setPositioncurrent(position);
            adapter.notifyDataSetChanged();
        }
    }


}
