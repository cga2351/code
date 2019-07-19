package com.facebook.react.modules.share;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="ShareModule")
public class ShareModule extends ReactContextBaseJavaModule
{
  static final String ACTION_SHARED = "sharedAction";
  static final String ERROR_INVALID_CONTENT = "E_INVALID_CONTENT";
  static final String ERROR_UNABLE_TO_OPEN_DIALOG = "E_UNABLE_TO_OPEN_DIALOG";

  public ShareModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  public String getName()
  {
    return "ShareModule";
  }

  @ReactMethod
  public void share(ReadableMap paramReadableMap, String paramString, Promise paramPromise)
  {
    if (paramReadableMap == null)
    {
      paramPromise.reject("E_INVALID_CONTENT", "Content cannot be null");
      return;
    }
    while (true)
    {
      Intent localIntent2;
      try
      {
        Intent localIntent1 = new Intent("android.intent.action.SEND");
        localIntent1.setTypeAndNormalize("text/plain");
        if (paramReadableMap.hasKey("title"))
          localIntent1.putExtra("android.intent.extra.SUBJECT", paramReadableMap.getString("title"));
        if (paramReadableMap.hasKey("message"))
          localIntent1.putExtra("android.intent.extra.TEXT", paramReadableMap.getString("message"));
        localIntent2 = Intent.createChooser(localIntent1, paramString);
        localIntent2.addCategory("android.intent.category.DEFAULT");
        Activity localActivity = getCurrentActivity();
        if (localActivity != null)
        {
          localActivity.startActivity(localIntent2);
          WritableMap localWritableMap = Arguments.createMap();
          localWritableMap.putString("action", "sharedAction");
          paramPromise.resolve(localWritableMap);
          return;
        }
      }
      catch (Exception localException)
      {
        paramPromise.reject("E_UNABLE_TO_OPEN_DIALOG", "Failed to open share dialog");
        return;
      }
      getReactApplicationContext().startActivity(localIntent2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.share.ShareModule
 * JD-Core Version:    0.6.2
 */