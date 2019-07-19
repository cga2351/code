package com.facebook.react.bridge;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PromiseImpl
  implements Promise
{
  private static final String ERROR_DEFAULT_CODE = "EUNSPECIFIED";
  private static final String ERROR_DEFAULT_MESSAGE = "Error not specified.";
  private static final String ERROR_MAP_KEY_CODE = "code";
  private static final String ERROR_MAP_KEY_MESSAGE = "message";
  private static final String ERROR_MAP_KEY_NATIVE_STACK = "nativeStackAndroid";
  private static final String ERROR_MAP_KEY_USER_INFO = "userInfo";
  private static final int ERROR_STACK_FRAME_LIMIT = 10;
  private static final String STACK_FRAME_KEY_FILE = "file";
  private static final String STACK_FRAME_KEY_LINE_NUMBER = "lineNumber";
  private static final String STACK_FRAME_KEY_METHOD_NAME = "methodName";

  @Nullable
  private Callback mReject;

  @Nullable
  private Callback mResolve;

  public PromiseImpl(@Nullable Callback paramCallback1, @Nullable Callback paramCallback2)
  {
    this.mResolve = paramCallback1;
    this.mReject = paramCallback2;
  }

  @Deprecated
  public void reject(String paramString)
  {
    reject(null, paramString, null, null);
  }

  public void reject(String paramString, @Nonnull WritableMap paramWritableMap)
  {
    reject(paramString, null, null, paramWritableMap);
  }

  public void reject(String paramString1, String paramString2)
  {
    reject(paramString1, paramString2, null, null);
  }

  public void reject(String paramString1, String paramString2, @Nonnull WritableMap paramWritableMap)
  {
    reject(paramString1, paramString2, null, paramWritableMap);
  }

  public void reject(String paramString1, String paramString2, Throwable paramThrowable)
  {
    reject(paramString1, paramString2, paramThrowable, null);
  }

  public void reject(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable, @Nullable WritableMap paramWritableMap)
  {
    if (this.mReject == null)
    {
      this.mResolve = null;
      return;
    }
    WritableNativeMap localWritableNativeMap1 = new WritableNativeMap();
    if (paramString1 == null)
    {
      localWritableNativeMap1.putString("code", "EUNSPECIFIED");
      if (paramString2 == null)
        break label180;
      localWritableNativeMap1.putString("message", paramString2);
      label47: if (paramWritableMap == null)
        break label210;
      localWritableNativeMap1.putMap("userInfo", paramWritableMap);
    }
    label180: 
    while (true)
      label61: if (paramThrowable != null)
      {
        StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
        WritableNativeArray localWritableNativeArray = new WritableNativeArray();
        int i = 0;
        while (true)
          if ((i < arrayOfStackTraceElement.length) && (i < 10))
          {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
            WritableNativeMap localWritableNativeMap2 = new WritableNativeMap();
            localWritableNativeMap2.putString("file", localStackTraceElement.getFileName());
            localWritableNativeMap2.putInt("lineNumber", localStackTraceElement.getLineNumber());
            localWritableNativeMap2.putString("methodName", localStackTraceElement.getMethodName());
            localWritableNativeArray.pushMap(localWritableNativeMap2);
            i++;
            continue;
            localWritableNativeMap1.putString("code", paramString1);
            break;
            if (paramThrowable != null)
            {
              localWritableNativeMap1.putString("message", paramThrowable.getMessage());
              break label47;
            }
            localWritableNativeMap1.putString("message", "Error not specified.");
            break label47;
            label210: localWritableNativeMap1.putNull("userInfo");
            break label61;
          }
        localWritableNativeMap1.putArray("nativeStackAndroid", localWritableNativeArray);
      }
    while (true)
    {
      this.mReject.invoke(new Object[] { localWritableNativeMap1 });
      this.mResolve = null;
      this.mReject = null;
      return;
      localWritableNativeMap1.putArray("nativeStackAndroid", new WritableNativeArray());
    }
  }

  public void reject(String paramString, Throwable paramThrowable)
  {
    reject(paramString, null, paramThrowable, null);
  }

  public void reject(String paramString, Throwable paramThrowable, WritableMap paramWritableMap)
  {
    reject(paramString, null, paramThrowable, paramWritableMap);
  }

  public void reject(Throwable paramThrowable)
  {
    reject(null, null, paramThrowable, null);
  }

  public void reject(Throwable paramThrowable, WritableMap paramWritableMap)
  {
    reject(null, null, paramThrowable, paramWritableMap);
  }

  public void resolve(Object paramObject)
  {
    if (this.mResolve != null)
    {
      this.mResolve.invoke(new Object[] { paramObject });
      this.mResolve = null;
      this.mReject = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.PromiseImpl
 * JD-Core Version:    0.6.2
 */