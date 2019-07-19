package com.facebook.react.devsupport;

import android.util.Pair;
import android.view.View;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="JSDevSupport")
public class JSDevSupport extends ReactContextBaseJavaModule
{
  public static final int ERROR_CODE_EXCEPTION = 0;
  public static final int ERROR_CODE_VIEW_NOT_FOUND = 1;
  public static final String MODULE_NAME = "JSDevSupport";

  @Nullable
  private volatile DevSupportCallback mCurrentCallback = null;

  public JSDevSupport(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  public void computeDeepestJSHierarchy(View paramView, DevSupportCallback paramDevSupportCallback)
  {
    try
    {
      getJSHierarchy(Integer.valueOf(((View)ViewHierarchyUtil.getDeepestLeaf(paramView).first).getId()).intValue(), paramDevSupportCallback);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ERROR_CODE_EXCEPTION", Integer.valueOf(0));
    localHashMap.put("ERROR_CODE_VIEW_NOT_FOUND", Integer.valueOf(1));
    return localHashMap;
  }

  public void getJSHierarchy(int paramInt, DevSupportCallback paramDevSupportCallback)
  {
    try
    {
      JSDevSupportModule localJSDevSupportModule = (JSDevSupportModule)getReactApplicationContext().getJSModule(JSDevSupportModule.class);
      if (localJSDevSupportModule == null)
        paramDevSupportCallback.onFailure(0, new JSCHeapCapture.CaptureException("JSDevSupport module not registered."));
      while (true)
      {
        return;
        this.mCurrentCallback = paramDevSupportCallback;
        localJSDevSupportModule.getJSHierarchy(paramInt);
      }
    }
    finally
    {
    }
  }

  public String getName()
  {
    return "JSDevSupport";
  }

  @ReactMethod
  public void onFailure(int paramInt, String paramString)
  {
    try
    {
      if (this.mCurrentCallback != null)
        this.mCurrentCallback.onFailure(paramInt, new RuntimeException(paramString));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @ReactMethod
  public void onSuccess(String paramString)
  {
    try
    {
      if (this.mCurrentCallback != null)
        this.mCurrentCallback.onSuccess(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static abstract interface DevSupportCallback
  {
    public abstract void onFailure(int paramInt, Exception paramException);

    public abstract void onSuccess(String paramString);
  }

  public static abstract interface JSDevSupportModule extends JavaScriptModule
  {
    public abstract void getJSHierarchy(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.JSDevSupport
 * JD-Core Version:    0.6.2
 */