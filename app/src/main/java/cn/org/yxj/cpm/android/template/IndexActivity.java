package cn.org.yxj.cpm.android.template;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import org.apache.weex.WXSDKInstance;
import org.apache.weex.commons.AbstractWeexActivity;

public class IndexActivity extends AbstractWeexActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setContainer((ViewGroup) findViewById(R.id.help));
        //getWindow().setFormat(PixelFormat.TRANSLUCENT);

        renderPageByURL("http://dotwe.org/raw/dist/2bbe1860da4669a68595c1aed01d7fd2.bundle.wx");
    }
}
