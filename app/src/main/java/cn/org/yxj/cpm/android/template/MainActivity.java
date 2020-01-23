package cn.org.yxj.cpm.android.template;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import org.apache.weex.IWXRenderListener;
import org.apache.weex.WXSDKInstance;
import org.apache.weex.common.WXRenderStrategy;
import org.apache.weex.commons.WXAnalyzerDelegate;
import org.apache.weex.utils.WXFileUtils;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IWXRenderListener {
    WXSDKInstance mWXSDKInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rect outRect = new Rect();
        this.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        mWXSDKInstance = new WXSDKInstance(this);
        mWXSDKInstance.registerRenderListener(this);

        mWXSDKInstance.onActivityCreate();
        this.getWindow().setFormat(-3);

        String url = "http://dotwe.org/raw/dist/38e202c16bdfefbdb88a8754f975454c.bundle.wx";
        Map<String, Object> options = new HashMap();
        options.put("bundleUrl", url);
        mWXSDKInstance.setTrackComponent(true);
        mWXSDKInstance.renderByUrl("WXSample", url, options, null, WXRenderStrategy.APPEND_ASYNC);
    }
    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        //setContentView(view);
        // todo 只能通过add / remove 获得
        ViewGroup contentView= findViewById(android.R.id.content);
        contentView.addView(view);
    }
    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {
    }
    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {
    }
    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {
        System.out.println("error+++"+msg);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityResume();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityPause();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityStop();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityDestroy();
        }
    }
}
