package cn.org.yxj.cpm.android.template;

import android.app.Application;
import androidx.multidex.MultiDex;
import com.facebook.drawee.backends.pipeline.Fresco;
import org.apache.weex.InitConfig;
import org.apache.weex.WXEnvironment;
import org.apache.weex.WXSDKEngine;
import org.apache.weex.adapter.DefaultWXHttpAdapter;
import org.apache.weex.bridge.WXBridgeManager;
import org.apache.weex.commons.adapter.FrescoImageAdapter;

public class CPMApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);

        WXBridgeManager.updateGlobalConfig("wson_on");
        WXEnvironment.setOpenDebugLog(true);
        WXEnvironment.setApkDebugable(true);
        WXSDKEngine.addCustomOptions("appName", "WXSample");
        WXSDKEngine.addCustomOptions("appGroup", "WXApp");
        InitConfig.Builder builder = new InitConfig.Builder()
                //图片库接口
                .setImgAdapter(new FrescoImageAdapter())
                //网络库接口
                .setHttpAdapter(new DefaultWXHttpAdapter());
        CPMInitialize(builder);
        WXSDKEngine.initialize(this, builder.build());
        Fresco.initialize(this);
    }

    protected void CPMInitialize(InitConfig.Builder builder) {

    }
}
