package com.facebook.react.modules.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.SparseArray;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import java.util.ArrayList;

@ReactModule(name="PermissionsAndroid")
public class PermissionsModule extends ReactContextBaseJavaModule
  implements PermissionListener
{
  private static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
  public static final String NAME = "PermissionsAndroid";
  private final String DENIED = "denied";
  private final String GRANTED = "granted";
  private final String NEVER_ASK_AGAIN = "never_ask_again";
  private final SparseArray<Callback> mCallbacks = new SparseArray();
  private int mRequestCode = 0;

  public PermissionsModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private PermissionAwareActivity getPermissionAwareActivity()
  {
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
    if (!(localActivity instanceof PermissionAwareActivity))
      throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
    return (PermissionAwareActivity)localActivity;
  }

  @ReactMethod
  public void checkPermission(String paramString, Promise paramPromise)
  {
    boolean bool = true;
    Context localContext = getReactApplicationContext().getBaseContext();
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0);
      while (true)
      {
        paramPromise.resolve(Boolean.valueOf(bool));
        return;
        bool = false;
      }
    }
    if (localContext.checkSelfPermission(paramString) == 0);
    while (true)
    {
      paramPromise.resolve(Boolean.valueOf(bool));
      return;
      bool = false;
    }
  }

  public String getName()
  {
    return "PermissionsAndroid";
  }

  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Callback localCallback = (Callback)this.mCallbacks.get(paramInt);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramArrayOfInt;
    arrayOfObject[1] = getPermissionAwareActivity();
    localCallback.invoke(arrayOfObject);
    this.mCallbacks.remove(paramInt);
    return this.mCallbacks.size() == 0;
  }

  @ReactMethod
  public void requestMultiplePermissions(ReadableArray paramReadableArray, final Promise paramPromise)
  {
    int i = 0;
    final WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    final ArrayList localArrayList = new ArrayList();
    Context localContext = getReactApplicationContext().getBaseContext();
    int j = 0;
    if (i < paramReadableArray.size())
    {
      String str1 = paramReadableArray.getString(i);
      String str2;
      if (Build.VERSION.SDK_INT < 23)
        if (localContext.checkPermission(str1, Process.myPid(), Process.myUid()) == 0)
        {
          str2 = "granted";
          label79: localWritableNativeMap.putString(str1, str2);
          j++;
        }
      while (true)
      {
        i++;
        break;
        str2 = "denied";
        break label79;
        if (localContext.checkSelfPermission(str1) == 0)
        {
          localWritableNativeMap.putString(str1, "granted");
          j++;
        }
        else
        {
          localArrayList.add(str1);
        }
      }
    }
    if (paramReadableArray.size() == j)
    {
      paramPromise.resolve(localWritableNativeMap);
      return;
    }
    try
    {
      PermissionAwareActivity localPermissionAwareActivity = getPermissionAwareActivity();
      this.mCallbacks.put(this.mRequestCode, new Callback()
      {
        public void invoke(Object[] paramAnonymousArrayOfObject)
        {
          int[] arrayOfInt = (int[])paramAnonymousArrayOfObject[0];
          PermissionAwareActivity localPermissionAwareActivity = (PermissionAwareActivity)paramAnonymousArrayOfObject[1];
          int i = 0;
          if (i < localArrayList.size())
          {
            String str = (String)localArrayList.get(i);
            if ((arrayOfInt.length > 0) && (arrayOfInt[i] == 0))
              localWritableNativeMap.putString(str, "granted");
            while (true)
            {
              i++;
              break;
              if (localPermissionAwareActivity.shouldShowRequestPermissionRationale(str))
                localWritableNativeMap.putString(str, "denied");
              else
                localWritableNativeMap.putString(str, "never_ask_again");
            }
          }
          paramPromise.resolve(localWritableNativeMap);
        }
      });
      localPermissionAwareActivity.requestPermissions((String[])localArrayList.toArray(new String[0]), this.mRequestCode, this);
      this.mRequestCode = (1 + this.mRequestCode);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      paramPromise.reject("E_INVALID_ACTIVITY", localIllegalStateException);
    }
  }

  @ReactMethod
  public void requestPermission(final String paramString, final Promise paramPromise)
  {
    Context localContext = getReactApplicationContext().getBaseContext();
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0);
      for (String str = "granted"; ; str = "denied")
      {
        paramPromise.resolve(str);
        return;
      }
    }
    if (localContext.checkSelfPermission(paramString) == 0)
    {
      paramPromise.resolve("granted");
      return;
    }
    try
    {
      PermissionAwareActivity localPermissionAwareActivity = getPermissionAwareActivity();
      this.mCallbacks.put(this.mRequestCode, new Callback()
      {
        public void invoke(Object[] paramAnonymousArrayOfObject)
        {
          int[] arrayOfInt = (int[])paramAnonymousArrayOfObject[0];
          if ((arrayOfInt.length > 0) && (arrayOfInt[0] == 0))
          {
            paramPromise.resolve("granted");
            return;
          }
          if (((PermissionAwareActivity)paramAnonymousArrayOfObject[1]).shouldShowRequestPermissionRationale(paramString))
          {
            paramPromise.resolve("denied");
            return;
          }
          paramPromise.resolve("never_ask_again");
        }
      });
      localPermissionAwareActivity.requestPermissions(new String[] { paramString }, this.mRequestCode, this);
      this.mRequestCode = (1 + this.mRequestCode);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      paramPromise.reject("E_INVALID_ACTIVITY", localIllegalStateException);
    }
  }

  @ReactMethod
  public void shouldShowRequestPermissionRationale(String paramString, Promise paramPromise)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      paramPromise.resolve(Boolean.valueOf(false));
      return;
    }
    try
    {
      paramPromise.resolve(Boolean.valueOf(getPermissionAwareActivity().shouldShowRequestPermissionRationale(paramString)));
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      paramPromise.reject("E_INVALID_ACTIVITY", localIllegalStateException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.permissions.PermissionsModule
 * JD-Core Version:    0.6.2
 */