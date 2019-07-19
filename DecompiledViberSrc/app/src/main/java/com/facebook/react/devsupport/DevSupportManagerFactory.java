package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.packagerconnection.RequestHandler;
import java.lang.reflect.Constructor;
import java.util.Map;
import javax.annotation.Nullable;

public class DevSupportManagerFactory
{
  private static final String DEVSUPPORT_IMPL_CLASS = "DevSupportManagerImpl";
  private static final String DEVSUPPORT_IMPL_PACKAGE = "com.facebook.react.devsupport";

  public static DevSupportManager create(Context paramContext, ReactInstanceManagerDevHelper paramReactInstanceManagerDevHelper, @Nullable String paramString, boolean paramBoolean, int paramInt)
  {
    return create(paramContext, paramReactInstanceManagerDevHelper, paramString, paramBoolean, null, null, paramInt, null);
  }

  public static DevSupportManager create(Context paramContext, ReactInstanceManagerDevHelper paramReactInstanceManagerDevHelper, @Nullable String paramString, boolean paramBoolean, @Nullable RedBoxHandler paramRedBoxHandler, @Nullable DevBundleDownloadListener paramDevBundleDownloadListener, int paramInt, @Nullable Map<String, RequestHandler> paramMap)
  {
    if (!paramBoolean)
      return new DisabledDevSupportManager();
    try
    {
      Class localClass = Class.forName("com.facebook.react.devsupport" + "." + "DevSupportManagerImpl");
      Class[] arrayOfClass = new Class[8];
      arrayOfClass[0] = Context.class;
      arrayOfClass[1] = ReactInstanceManagerDevHelper.class;
      arrayOfClass[2] = String.class;
      arrayOfClass[3] = Boolean.TYPE;
      arrayOfClass[4] = RedBoxHandler.class;
      arrayOfClass[5] = DevBundleDownloadListener.class;
      arrayOfClass[6] = Integer.TYPE;
      arrayOfClass[7] = Map.class;
      Constructor localConstructor = localClass.getConstructor(arrayOfClass);
      Object[] arrayOfObject = new Object[8];
      arrayOfObject[0] = paramContext;
      arrayOfObject[1] = paramReactInstanceManagerDevHelper;
      arrayOfObject[2] = paramString;
      arrayOfObject[3] = Boolean.valueOf(true);
      arrayOfObject[4] = paramRedBoxHandler;
      arrayOfObject[5] = paramDevBundleDownloadListener;
      arrayOfObject[6] = Integer.valueOf(paramInt);
      arrayOfObject[7] = paramMap;
      DevSupportManager localDevSupportManager = (DevSupportManager)localConstructor.newInstance(arrayOfObject);
      return localDevSupportManager;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Requested enabled DevSupportManager, but DevSupportManagerImpl class was not found or could not be created", localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevSupportManagerFactory
 * JD-Core Version:    0.6.2
 */