package com.facebook.react.modules.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.module.annotations.ReactModule;
import javax.annotation.Nullable;

@ReactModule(name="IntentAndroid")
public class IntentModule extends ReactContextBaseJavaModule
{
  public static final String NAME = "IntentAndroid";

  public IntentModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @ReactMethod
  public void canOpenURL(String paramString, Promise paramPromise)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramPromise.reject(new JSApplicationIllegalArgumentException("Invalid URL: " + paramString));
      return;
    }
    while (true)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        localIntent.addFlags(268435456);
        if (localIntent.resolveActivity(getReactApplicationContext().getPackageManager()) != null)
        {
          bool = true;
          paramPromise.resolve(Boolean.valueOf(bool));
          return;
        }
      }
      catch (Exception localException)
      {
        paramPromise.reject(new JSApplicationIllegalArgumentException("Could not check if URL '" + paramString + "' can be opened: " + localException.getMessage()));
        return;
      }
      boolean bool = false;
    }
  }

  @ReactMethod
  public void getInitialURL(Promise paramPromise)
  {
    try
    {
      Activity localActivity = getCurrentActivity();
      String str1 = null;
      if (localActivity != null)
      {
        Intent localIntent = localActivity.getIntent();
        String str2 = localIntent.getAction();
        Uri localUri = localIntent.getData();
        boolean bool = "android.intent.action.VIEW".equals(str2);
        str1 = null;
        if (bool)
        {
          str1 = null;
          if (localUri != null)
            str1 = localUri.toString();
        }
      }
      paramPromise.resolve(str1);
      return;
    }
    catch (Exception localException)
    {
      paramPromise.reject(new JSApplicationIllegalArgumentException("Could not get the initial URL : " + localException.getMessage()));
    }
  }

  public String getName()
  {
    return "IntentAndroid";
  }

  @ReactMethod
  public void openURL(String paramString, Promise paramPromise)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramPromise.reject(new JSApplicationIllegalArgumentException("Invalid URL: " + paramString));
      return;
    }
    while (true)
    {
      Intent localIntent;
      try
      {
        Activity localActivity = getCurrentActivity();
        localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString).normalizeScheme());
        String str1 = getReactApplicationContext().getPackageName();
        ComponentName localComponentName = localIntent.resolveActivity(getReactApplicationContext().getPackageManager());
        if (localComponentName != null)
        {
          str2 = localComponentName.getPackageName();
          if ((localActivity == null) || (!str1.equals(str2)))
            localIntent.addFlags(268435456);
          if (localActivity == null)
            break label202;
          localActivity.startActivity(localIntent);
          paramPromise.resolve(Boolean.valueOf(true));
          return;
        }
      }
      catch (Exception localException)
      {
        paramPromise.reject(new JSApplicationIllegalArgumentException("Could not open URL '" + paramString + "': " + localException.getMessage()));
        return;
      }
      String str2 = "";
      continue;
      label202: getReactApplicationContext().startActivity(localIntent);
    }
  }

  @ReactMethod
  public void sendIntent(String paramString, @Nullable ReadableArray paramReadableArray, Promise paramPromise)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramPromise.reject(new JSApplicationIllegalArgumentException("Invalid Action: " + paramString + "."));
      return;
    }
    Intent localIntent = new Intent(paramString);
    if (localIntent.resolveActivity(getReactApplicationContext().getPackageManager()) == null)
    {
      paramPromise.reject(new JSApplicationIllegalArgumentException("Could not launch Intent with action " + paramString + "."));
      return;
    }
    if (paramReadableArray != null)
    {
      int i = 0;
      if (i < paramReadableArray.size())
      {
        ReadableMap localReadableMap = paramReadableArray.getMap(i);
        String str = localReadableMap.keySetIterator().nextKey();
        ReadableType localReadableType = localReadableMap.getType(str);
        switch (1.$SwitchMap$com$facebook$react$bridge$ReadableType[localReadableType.ordinal()])
        {
        default:
          paramPromise.reject(new JSApplicationIllegalArgumentException("Extra type for " + str + " not supported."));
          return;
        case 1:
          localIntent.putExtra(str, localReadableMap.getString(str));
        case 2:
        case 3:
        }
        while (true)
        {
          i++;
          break;
          localIntent.putExtra(str, Double.valueOf(localReadableMap.getDouble(str)));
          continue;
          localIntent.putExtra(str, localReadableMap.getBoolean(str));
        }
      }
    }
    getReactApplicationContext().startActivity(localIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.intent.IntentModule
 * JD-Core Version:    0.6.2
 */