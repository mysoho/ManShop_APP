package utils;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/8 12:33
 */

public class Myapp extends Application {
    public static Myapp mInstance;
    public  static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Fresco.initialize(this);
        context=this;
    }
    public static Myapp getInstance() {
        return mInstance;
    }
}
