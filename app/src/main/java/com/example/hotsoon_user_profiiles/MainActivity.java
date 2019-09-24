package com.example.hotsoon_user_profiiles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotsoon_user_profiiles.Interface.HandlePosition;
import com.example.hotsoon_user_profiiles.Interface.OnItemClickListener;
import com.example.hotsoon_user_profiiles.Json.Production;
import com.example.hotsoon_user_profiiles.Json.ProductionExtra;
import com.example.hotsoon_user_profiiles.Json.RecommendUser;
import com.example.hotsoon_user_profiiles.Json.User;
import com.example.hotsoon_user_profiiles.Util.HttpUtil;
import com.example.hotsoon_user_profiiles.Util.Util;
import com.example.hotsoon_user_profiiles.adapter.ProductionAdapter;
import com.example.hotsoon_user_profiiles.adapter.RecommendUserAdapt;
import com.example.hotsoon_user_profiiles.music.MusicParcelable;
import com.example.hotsoon_user_profiiles.music.MusicService;
import com.example.hotsoon_user_profiiles.music.MusicServiceConnection;
import com.example.hotsoon_user_profiiles.music.PositionHandler;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    private static boolean ISRECOMMEND = false;
    //关注状态
    private static boolean ATTENTION = false;


    @BindView(R.id.btn_title_back)
    Button btnTitleBack;

    @BindView(R.id.text_user_name)
    TextView textUserName;

    @BindView(R.id.btn_title_share)
    Button btnTitleShare;

    @BindView(R.id.img_user_photo)
    SimpleDraweeView imgUserPhoto;

    @BindView(R.id.fans_num)
    TextView fansNum;

    @BindView(R.id.btn_attentiion)
    Button btnAttention;

    @BindView(R.id.attention_num)
    TextView attentionNum;

    @BindView(R.id.hot_num)
    TextView hotNum;

    @BindView(R.id.user_recommend)
    TextView userRecommend;

    @BindView(R.id.btn_attention)
    Button btnAttentioned;

    @BindView(R.id.recycler_view_recommend)
    RecyclerView recyclerViewRecommend;

    @BindView(R.id.layout_recommend)
    ConstraintLayout layoutRecommend;

    @BindView(R.id.user_tx_location)
    TextView userTxLocation;

    @BindView(R.id.tx_better_author)
    TextView txBetterAuthor;

    @BindView(R.id.author_lv)
    TextView authorLv;

    @BindView(R.id.user_tx_describe)
    TextView userTxDescribe;

    @BindView(R.id.user_live_time)
    TextView userLiveTime;

    @BindView(R.id.user_image_zhiboshuliang)
    ImageView userImageZhiboshuliang;

    @BindView(R.id.user_tx_gift_num)
    TextView userTxGiftNum;


    @BindView(R.id.user_img_send_fire)
    ImageView userImgSendFire;

    @BindView(R.id.user_tx_fire_num)
    TextView userTxFireNum;

    @BindView(R.id.user_btn_send_fire)
    Button userBtnSendFire;

    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;


    private List<Production> mProductionList;

    private List<RecommendUser> mRecommendUserList;

    private User muser = null;

    private ProductionAdapter mProductionAdapter;

    private int offset = 20;

    private ProductionExtra mProductionExtra;

    private MusicServiceConnection mMusicServiceConnection;

    PositionHandler positionHandler = new PositionHandler();

    private Messenger mClient = new Messenger(positionHandler);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mProductionList = new ArrayList<>();

        //初始化位置图片大小
        initLeftImage(this);

        //初始化用户信息
        initUserInfo();

        //初始化用户作品列表
        showProduction();
        initProductionFromSever(0);

        //处理service返回来的数据

        positionHandler.setmHandlePosition(new HandlePosition() {
            @Override
            public void sendMusicParcelable(Messenger service,int position) {
                Log.d(TAG, "sendMusicParcelable: "+ position);

                //上一曲到0
                if(position < 0){
                    position = mProductionList.size()-1;
                }
                if (position>=mProductionList.size()){
                    position = 0;
                }


                Intent intent = new Intent(MainActivity.this, MusicService.class);

                intent.putExtra("playing",true);

                MusicParcelable musicParcelable = generateMusicParcelable(position);

                mMusicServiceConnection = new MusicServiceConnection(musicParcelable,mClient);

                bindService(intent,mMusicServiceConnection,BIND_AUTO_CREATE);

            }
        });


    }

    @Override
    protected void onDestroy() {
        unbindService(mMusicServiceConnection);
        super.onDestroy();
    }

    //初始化用户信息
    private void initUserInfo() {
        String address = "https://hotsoon.snssdk.com/hotsoon/user/profile/_get_profile/?to_user_id=MS4wLjABAAAAVF0vRMIL5eEMlYhynSMOAasHj0EMzrGO1qeGQndQ2yM&live_sdk_version=755&iid=86074742939&device_id=67703969166&ac=wifi&channel=xiaomi&aid=1112&app_name=live_stream&version_code=755&version_name=7.5.5&device_platform=android&ssmix=a&device_type=MI+8&device_brand=Xiaomi&language=zh&os_api=28&os_version=9&uuid=860758049787957&openudid=327cb6e9b00fd723&manifest_version_code=755&resolution=1080*2029&dpi=440&update_version_code=7553&_rticket=1568641602192&ab_version=1143691%2C1145841%2C1159308%2C661938%2C712301%2C1156327%2C1162149%2C994817%2C1005399%2C1168131%2C1171175%2C1170481%2C692223%2C889328%2C1166124%2C1114546%2C1143745%2C1112067%2C1095512%2C1039076%2C841788%2C955277%2C1017639%2C1152364%2C947985%2C1163551%2C1174148%2C1048437%2C1030027%2C1050089%2C848690%2C1163514%2C1080023%2C1106061%2C792536%2C929433%2C682009%2C1146639%2C841998%2C1153992%2C1063522%2C1153757%2C1164773%2C1129537%2C988864%2C1169008%2C1167795%2C1143559%2C1153954%2C1153953%2C1038565%2C1104584%2C1028657%2C995853%2C1048486%2C1096188%2C689931%2C1159999%2C1166839%2C1127415%2C1002041%2C1156624%2C1149838%2C1119160%2C1145718%2C1165215%2C1143605%2C975749%2C1133591%2C557631%2C1169772%2C1075333%2C956108%2C1019391%2C1149085%2C1019139%2C1060649%2C1032070%2C1142596%2C1069234%2C1072545%2C1146441%2C1155965%2C1169258%2C1166255%2C1153437%2C1092636%2C1169500%2C1046183%2C643984%2C1143672%2C662293%2C1143730%2C1153180%2C1165209%2C1165329%2C1164668%2C768603%2C1132751%2C1173501%2C1158988&client_version_code=755&jssdk_version=2.13.3.t7_t28_h3&mcc_mnc=46000&ts=1568641602";
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> Toast.makeText(MainActivity.this, R.string.IntenetFail+"user", Toast.LENGTH_LONG).show());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    muser = Util.handleUserJson(jsonObject.getJSONObject("data").toString());
                    //Log.d(TAG, "onResponse: " + jsonObject.getJSONObject("data").toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, e.getMessage());
                }

                if (muser != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textUserName.setText(muser.getNickName());
                            long longfansNum = muser.getTotalFansCount();
                            if (longfansNum > 10000){
                                longfansNum = longfansNum / 10000;
                            }

                            long longfireCount = muser.getFanTicketCount();
                            if (longfireCount>10000){
                                longfireCount = longfireCount/10000;
                            }
                            String stringFansNum = String.valueOf(longfansNum) + "万";
                            fansNum.setText(stringFansNum);
                            String stringFireCount = String.valueOf(longfireCount) + "万";
                            hotNum.setText(stringFireCount);

                            attentionNum.setText(String.valueOf(muser.getStats().getFollowingCount()));

                            Uri imgUri = Uri.parse(muser.getAvatarThumb().urls.get(0));
                            Log.d(TAG, "run: " + imgUri);
                            imgUserPhoto.setImageURI(imgUri);
                        }
                    });
                }

            }
        });
    }


    //取消关注确认弹窗
    private void showDialog() {
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(MainActivity.this);
        normalDialog.setMessage(getString(R.string.dialogIfUnattention));
        normalDialog.setPositiveButton(getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btnAttention.setText(R.string.attention_name);
                        btnAttention.setBackground(getDrawable(R.drawable.btn_circle_red));
                        btnAttentioned.setVisibility(View.GONE);
                        ATTENTION = false;
                        if(ISRECOMMEND){
                            userRecommend.setBackground(getDrawable(R.drawable.btn_triangle_normal));
                        }else {
                            userRecommend.setBackground(getDrawable(R.drawable.btn_triangle));
                        }
                    }
                });
        normalDialog.setNegativeButton(getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }



    //初始化推荐联系人页面
    private void initRecommend() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserProfileData",MODE_PRIVATE);
        if (sharedPreferences.getString("data",null) != null){
            mRecommendUserList = Util.handleRecommendJson(sharedPreferences.getString("data",null));

            //Log.d(TAG, "initRecommend: ");
        }else {
            final String address = "https://hotsoon.snssdk.com/hotsoon/user/relation/recommend/?from_user_id=74095169403&live_sdk_version=755&iid=86074742939&device_id=67703969166&ac=wifi&channel=xiaomi&aid=1112&app_name=live_stream&version_code=755&version_name=7.5.5&device_platform=android&ssmix=a&device_type=MI+8&device_brand=Xiaomi&language=zh&os_api=28&os_version=9&uuid=860758049787957&openudid=327cb6e9b00fd723&manifest_version_code=755&resolution=1080*2029&dpi=440&update_version_code=7553&_rticket=1568715917169&ab_version=1143691%2C1175220%2C1145841%2C1159308%2C661938%2C712301%2C1174984%2C1156327%2C1162149%2C994817%2C1005399%2C1171175%2C1170481%2C692223%2C889328%2C1114546%2C1143745%2C1112067%2C1095512%2C1039076%2C1168131%2C955277%2C1017639%2C1152364%2C947985%2C1163551%2C1174148%2C1048437%2C1030027%2C1050089%2C848690%2C1176423%2C1080023%2C1106061%2C792536%2C929433%2C682009%2C1146639%2C1112398%2C841998%2C1153992%2C1176221%2C1063522%2C1153757%2C1175747%2C1164773%2C1129537%2C988864%2C1167795%2C1143559%2C1153954%2C1153953%2C1038565%2C1104584%2C1028657%2C995853%2C1048486%2C1096188%2C689931%2C1159999%2C1166839%2C1127415%2C1002041%2C1156624%2C1149838%2C1119160%2C1145718%2C1165215%2C1143605%2C975749%2C1133591%2C557631%2C1169772%2C1175519%2C1075333%2C956108%2C1019391%2C1149085%2C1019139%2C1060649%2C1032070%2C1142596%2C1069234%2C1072545%2C1155965%2C1169258%2C1166255%2C1153437%2C1092636%2C1169500%2C1046183%2C643984%2C1143672%2C662293%2C1143730%2C1153180%2C1165209%2C1175196%2C1164668%2C768603%2C1132751%2C1158988&client_version_code=755&jssdk_version=2.13.3.t7_t28_h3&mcc_mnc=46000&new_nav=1&ws_status=CONNECTED&ts=1568715918";
            HttpUtil.sendOkHttpRequest(address, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this,R.string.IntenetFail,Toast.LENGTH_LONG).show();
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String respoonseData = response.body().string();

                    mRecommendUserList = Util.handleRecommendJson(respoonseData);
                    SharedPreferences sharedPreferences = getSharedPreferences("UserProfileData",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("data",respoonseData);
                    editor.commit();

                }
            });
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewRecommend.setLayoutManager(linearLayoutManager);
        RecommendUserAdapt recommendUserAdapt = new RecommendUserAdapt(mRecommendUserList);
        recyclerViewRecommend.setAdapter(recommendUserAdapt);

        layoutRecommend.setVisibility(View.VISIBLE);
    }



    //设置位置图标大小
    private void initLeftImage(Context context) {

        Drawable leftDrawable = context.getResources().getDrawable(R.drawable.icon_myprofile_location);
        leftDrawable.setBounds(0, 0, 5, 5);
    }


    //初始化页面用户作品
    private void initProductionFromSever(int offset) {

        String address;


        if(mProductionExtra != null){

            String maxTime = mProductionExtra.getMaxTime();
            address = "https://api.huoshan.com/hotsoon/item/profile/published_list/?to_user_id=MS4wLjABAAAAVF0vRMIL5eEMlYhynSMOAasHj0EMzrGO1qeGQndQ2yM&max_time=" + maxTime + "&offset=" + offset+"&count=20&req_from=enter_auto&feed_relate_search=0&ad_user_agent=com.ss.android.ugc.live%2F756+%28Linux%3B+U%3B+Android+9%3B+zh_CN%3B+MI+8%3B+Build%2FPKQ1.180729.001%3B+Chrome%29&last_ad_items=%5B%7B%22id%22%3A6734583280030600455%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6731880214852422925%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A1644726203312157%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6736295265424264456%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6735758903361031438%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6737582778327649550%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6733756417972522252%2C%22show_time%22%3A-1%7D%2C%7B%22id%22%3A6732707684396715271%2C%22show_time%22%3A-1%7D%2C%7B%22id%22%3A1644689814620163%2C%22show_time%22%3A-1%7D%2C%7B%22id%22%3A6730959407246626060%2C%22show_time%22%3A-1%7D%5D&minor_control_status=0&live_sdk_version=756&iid=86601211949&device_id=67703969166&ac=wifi&channel=xiaomi&aid=1112&app_name=live_stream&version_code=756&version_name=7.5.6&device_platform=android&ssmix=a&device_type=MI+8&device_brand=Xiaomi&language=zh&os_api=28&os_version=9&uuid=860758049787957&openudid=327cb6e9b00fd723&manifest_version_code=756&resolution=1080*2029&dpi=440&update_version_code=7560&_rticket=1568728203077&ab_version=1143691%2C1175220%2C1145841%2C1159308%2C661938%2C712301%2C1174984%2C1156327%2C1162149%2C994817%2C1005399%2C1170481%2C692223%2C889328%2C1114546%2C1143745%2C1095512%2C1168131%2C955277%2C1048486%2C1152364%2C947985%2C1163551%2C1174148%2C1048437%2C1030027%2C1050089%2C848690%2C1176632%2C1080023%2C1106061%2C792536%2C929433%2C682009%2C1146639%2C1112398%2C841998%2C1153992%2C1176221%2C1063522%2C1153757%2C1175747%2C1164773%2C1129537%2C988864%2C1167795%2C1143559%2C1153954%2C1153953%2C1038565%2C1104584%2C1176423%2C1028657%2C995853%2C1017639%2C1096188%2C689931%2C1159999%2C1166839%2C1127415%2C1002041%2C1156624%2C1149838%2C1119160%2C1145718%2C1165215%2C1143605%2C975749%2C1133591%2C557631%2C1169772%2C1175519%2C1075333%2C956108%2C1176955%2C1019391%2C1149085%2C1019139%2C1060649%2C1032070%2C1142596%2C1069234%2C1072545%2C1155965%2C1169258%2C1166255%2C1153437%2C1092636%2C1169500%2C1046183%2C643984%2C1143672%2C662293%2C1143730%2C1153180%2C1112067%2C1176130%2C1165209%2C1175196%2C1164668%2C768603%2C1132751%2C1158988&client_version_code=756&jssdk_version=2.13.3.t7_t28_h3&mcc_mnc=46000&process_name=com.ss.android.ugc.live&new_nav=1&ws_status=CONNECTED&ts=1568728203";

        }else {
            address = "https://api.huoshan.com/hotsoon/item/profile/published_list/?to_user_id=MS4wLjABAAAAVF0vRMIL5eEMlYhynSMOAasHj0EMzrGO1qeGQndQ2yM&min_time=0&offset=20&count=20&req_from=enter_auto&feed_relate_search=0&ad_user_agent=com.ss.android.ugc.live%2F756+%28Linux%3B+U%3B+Android+9%3B+zh_CN%3B+MI+8%3B+Build%2FPKQ1.180729.001%3B+Chrome%29&last_ad_items=%5B%7B%22id%22%3A6734583280030600455%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6731880214852422925%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A1644726203312157%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6736295265424264456%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6735758903361031438%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6737582778327649550%2C%22show_time%22%3A1568728193%7D%2C%7B%22id%22%3A6733756417972522252%2C%22show_time%22%3A-1%7D%2C%7B%22id%22%3A6732707684396715271%2C%22show_time%22%3A-1%7D%2C%7B%22id%22%3A1644689814620163%2C%22show_time%22%3A-1%7D%2C%7B%22id%22%3A6730959407246626060%2C%22show_time%22%3A-1%7D%5D&minor_control_status=0&live_sdk_version=756&iid=86601211949&device_id=67703969166&ac=wifi&channel=xiaomi&aid=1112&app_name=live_stream&version_code=756&version_name=7.5.6&device_platform=android&ssmix=a&device_type=MI+8&device_brand=Xiaomi&language=zh&os_api=28&os_version=9&uuid=860758049787957&openudid=327cb6e9b00fd723&manifest_version_code=756&resolution=1080*2029&dpi=440&update_version_code=7560&_rticket=1568728203077&ab_version=1143691%2C1175220%2C1145841%2C1159308%2C661938%2C712301%2C1174984%2C1156327%2C1162149%2C994817%2C1005399%2C1170481%2C692223%2C889328%2C1114546%2C1143745%2C1095512%2C1168131%2C955277%2C1048486%2C1152364%2C947985%2C1163551%2C1174148%2C1048437%2C1030027%2C1050089%2C848690%2C1176632%2C1080023%2C1106061%2C792536%2C929433%2C682009%2C1146639%2C1112398%2C841998%2C1153992%2C1176221%2C1063522%2C1153757%2C1175747%2C1164773%2C1129537%2C988864%2C1167795%2C1143559%2C1153954%2C1153953%2C1038565%2C1104584%2C1176423%2C1028657%2C995853%2C1017639%2C1096188%2C689931%2C1159999%2C1166839%2C1127415%2C1002041%2C1156624%2C1149838%2C1119160%2C1145718%2C1165215%2C1143605%2C975749%2C1133591%2C557631%2C1169772%2C1175519%2C1075333%2C956108%2C1176955%2C1019391%2C1149085%2C1019139%2C1060649%2C1032070%2C1142596%2C1069234%2C1072545%2C1155965%2C1169258%2C1166255%2C1153437%2C1092636%2C1169500%2C1046183%2C643984%2C1143672%2C662293%2C1143730%2C1153180%2C1112067%2C1176130%2C1165209%2C1175196%2C1164668%2C768603%2C1132751%2C1158988&client_version_code=756&jssdk_version=2.13.3.t7_t28_h3&mcc_mnc=46000&process_name=com.ss.android.ugc.live&new_nav=1&ws_status=CONNECTED&ts=1568728203";

        }



        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,R.string.IntenetFail,Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                Util.handleProductionJson(responseData,mProductionList);
                mProductionExtra = Util.handleProductionHasMore(responseData);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> mProductionAdapter.notifyDataSetChanged());
            }
        });


    }

    //显示用户产品
    private void showProduction(){
        //设置3列布局
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(gridLayoutManager);
        mProductionAdapter = new ProductionAdapter(mProductionList);
        recyclerView.setAdapter(mProductionAdapter);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mProductionAdapter.isBottomView(position) ? gridLayoutManager.getSpanCount() : 1;
            }
        });

        //Log.d(TAG, "initProduction: "+mProductionList.get(0).getProductionData().getTitle());
        mProductionAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("MusicHandler", "onItemClick: ");
                Toast.makeText(MainActivity.this,"点击了"+position,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, MusicService.class);

                intent.putExtra("playing",true);

                MusicParcelable musicParcelable = generateMusicParcelable(position);

                mMusicServiceConnection = new MusicServiceConnection(musicParcelable,mClient);

                bindService(intent,mMusicServiceConnection,BIND_AUTO_CREATE);
            }
        });


        //recyclerview滑到底部监听
        myRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                //当前RecyclerView显示出来的最后一个的item的position
                int lastPosition = -1;

                //当前状态为停止滑动状态SCROLL_STATE_IDLE时
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if(layoutManager instanceof GridLayoutManager) {
                        //通过LayoutManager找到当前显示的最后的item的position
                        lastPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    //时判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                    //如果相等则说明已经滑动到最后了
                    if(lastPosition == recyclerView.getLayoutManager().getItemCount()-1){

                        offset = offset + 12;
                        initProductionFromSever(offset);

                        Log.d(TAG, "onScrollStateChanged: "+ offset);
                    }

                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }


    //生成MusicParcelable对象
    private MusicParcelable generateMusicParcelable(int position){
        String musicUrl = mProductionList.get(position).getProductionData().getSong().getPlayUrl().getUrlList().get(0);
        String musicTitle = mProductionList.get(position).getProductionData().getSong().getTitle();
        String musicCover = mProductionList.get(position).getProductionData().getSong().getCoverThumb().getUrlList().get(0);

        //通过parcelable向service发送数据

        return new MusicParcelable(musicUrl,musicTitle,musicCover,position);

    }

    /**
     * 点击事件
     */
    @OnClick(R.id.btn_attentiion)
    public void onAttention() {
        if (ATTENTION){

        }else {
            ATTENTION = true;
            btnAttention.setText(R.string.sendPersonMessage);
            btnAttention.setBackground(getDrawable(R.drawable.btn_circle_white));
            btnAttentioned.setVisibility(View.VISIBLE);
            initRecommend();
            ISRECOMMEND = true;
            userRecommend.setBackground(getDrawable(R.drawable.btn_triangle_green_up));
        }

    }

    //显示播放记录
    @OnClick(R.id.img_user_photo)
    public void showHistory(){
        Intent intent = new Intent(this,MusicHistoryActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fans_num)
    public void onFans(){

    }

    @OnClick(R.id.attention_num)
    public void onAttentionNum(){

    }

    @OnClick(R.id.btn_attention)
    public void onDisAttention(){
        showDialog();


    }

    @OnClick(R.id.user_recommend)
    public void onRecommend(){
        if(ISRECOMMEND){
            if(ATTENTION){
                userRecommend.setBackground(getDrawable(R.drawable.btn_triangle_green_down));
            }else {
                userRecommend.setBackground(getDrawable(R.drawable.btn_triangle));
            }

            layoutRecommend.setVisibility(View.GONE);
            ISRECOMMEND = false;

        }else {
            if(ATTENTION){
                userRecommend.setBackground(getDrawable(R.drawable.btn_triangle_green_up));
            }else {
                userRecommend.setBackground(getDrawable(R.drawable.btn_triangle_normal));
            }
            layoutRecommend.setVisibility(View.VISIBLE);
            initRecommend();
            ISRECOMMEND = true;
        }
    }

}
