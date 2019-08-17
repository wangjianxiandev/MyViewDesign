package com.example.adminstator.myviewdesign.ShortCutsTest;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.adminstator.myviewdesign.R;

import java.util.ArrayList;
import java.util.List;

public class ShortCutsTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_cuts_test);
        setDynamicShortCuts();
        createPinnedShortCuts();
    }
    @TargetApi(Build.VERSION_CODES.N_MR1)
    private ShortcutInfo createShortCutInfo(){
        return new ShortcutInfo.Builder(this, "one")
                .setShortLabel(getString(R.string.shortcut_short_name))
                .setLongLabel(getString(R.string.shortcut_long_name))
                .setIcon(Icon.createWithResource(this,R.mipmap.ic_launcher))
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("www.baidu.com")))
                .build();
    }
    private void setDynamicShortCuts(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
            List<ShortcutInfo> shortcutInfo = new ArrayList<>();
            shortcutInfo.add(createShortCutInfo());
            if (shortcutManager != null) {
                shortcutManager.setDynamicShortcuts(shortcutInfo);
            }
        }
    }
    private void createPinnedShortCuts(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
            if ((shortcutManager != null) && (shortcutManager.isRequestPinShortcutSupported())) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                ShortcutInfo shortcutInfo = new ShortcutInfo.Builder(this, "two")
                        .setShortLabel(getString(R.string.shortcut_short_name))
                        .setLongLabel(getString(R.string.shortcut_long_name))
                        .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                        .setIntent(intent)
                        .build();
                Intent pinnedShortCutCallback = shortcutManager.createShortcutResultIntent(shortcutInfo);
                PendingIntent successCallback = PendingIntent.getBroadcast(this, 0,
                        pinnedShortCutCallback, 0);
                boolean b = shortcutManager.requestPinShortcut(shortcutInfo, successCallback.getIntentSender());
            }
        }
    }
}
