package com.example.jr.address;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private TextView tvConsole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvConsole = (TextView) findViewById(R.id.tv_console);
    }

    public void setAddressDialog(View view) {
        setAddress(getAreaList());
    }

    /**
     * 选择地区的AlertDialog
     * @param areasnow
     */
    private void setAddress(final List<Area> areasnow) {

        String[] strs = new String[areasnow.size()];
        for (int i = 0; i < areasnow.size(); i++) {
            strs[i] = areasnow.get(i).getName();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择地区");
        builder.setItems(strs, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (areasnow.get(which).getArea() != null && areasnow.get(which).getArea().size() > 0) {
                    setAddress(areasnow.get(which).getArea());
                } else {
                    tvConsole.setText(areasnow.get(which).getEntireName());
                }
            }
        });
        builder.show();
    }


    /**
     * 获取List类型的地区信息
     * @return
     */
    private List<Area> getAreaList() {
        String area = getTextFromAssets();
        Log.i("tag", area);
        Type listType = new TypeToken<List<Area>>() {
        }.getType();
        Gson gson = new Gson();
        List<Area> jsonList = gson.fromJson(area, listType);
        return jsonList;
    }

    /**
     * 用于读取assets中的文件
     *
     * @return
     */
    private String getTextFromAssets() {
        InputStream is;
        try {
            is = this.getAssets().open("area.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
