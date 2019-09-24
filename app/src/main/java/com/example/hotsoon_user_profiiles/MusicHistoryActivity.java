package com.example.hotsoon_user_profiiles;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hotsoon_user_profiiles.Interface.OnItemClickListener;
import com.example.hotsoon_user_profiiles.adapter.MusicHistoryAdapter;
import com.example.hotsoon_user_profiiles.music.MusicParcelable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicHistoryActivity extends Activity {

    private static final String CONTENT_URI = "content://com.example.hotsoon.provider/music";


    private List<MusicParcelable> musicParcelableList = new ArrayList<>();

    private MusicHistoryAdapter mAdapter;


    @BindView(R.id.music_history_list)
    RecyclerView recyclerViewHistory;

    @BindView(R.id.music_title_back)
    Button musicBack;

    @BindView(R.id.music_title_search)
    EditText musicSearch;

    @BindView(R.id.music_title_btn)
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_history);
        ButterKnife.bind(this);

        queryDate(null);

        initHistoryList();

    }


    @OnClick(R.id.music_title_back)
    public void setMusicBack(){
        finish();

    }

    @OnClick(R.id.music_title_btn)
    public void setMusicSearch(){
        String title = musicSearch.getText().toString();

        String name = "title like '%"+title+"%'";

        queryDate(name);

    }


    private void initHistoryList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mAdapter = new MusicHistoryAdapter(musicParcelableList);
        recyclerViewHistory.setLayoutManager(linearLayoutManager);
        recyclerViewHistory.setAdapter(mAdapter);

        //长按删除。为了重用，未重新定义接口
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showConfirmDialog(position);
            }
        });
    }

    private void showConfirmDialog(int position) {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(MusicHistoryActivity.this);

        normalDialog.setMessage(getString(R.string.deleteConfirm));
        normalDialog.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int id = musicParcelableList.get(position).getId();
                if(id != -1){
                    Toast.makeText(MusicHistoryActivity.this,"长按位置"+position,Toast.LENGTH_LONG).show();
                    getContentResolver().delete(Uri.parse(CONTENT_URI),"id = ?",new String[]{String.valueOf(id)});
                    musicParcelableList.remove(position);
                    mAdapter.notifyItemRemoved(position);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
        normalDialog.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        normalDialog.show();

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void queryDate(String name){
        Cursor cursor = null;
        //数据清零
        musicParcelableList.clear();
        try {
            cursor = getContentResolver().query(Uri.parse(CONTENT_URI),null,name,null,null,null);

            if (cursor != null){
                while (cursor.moveToNext()){
                    String title = cursor.getString(cursor.getColumnIndex("title"));
                    String url = cursor.getString(cursor.getColumnIndex("url"));
                    String cover = cursor.getString(cursor.getColumnIndex("cover"));
                    int position = cursor.getInt(cursor.getColumnIndex("position"));
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    MusicParcelable musicParcelable = new MusicParcelable(url,title,cover,position,id);
                    musicParcelableList.add(musicParcelable);
                }
                cursor.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //通知数据更新
        if (mAdapter != null)
        {
            mAdapter.notifyDataSetChanged();

        }

    }


}
