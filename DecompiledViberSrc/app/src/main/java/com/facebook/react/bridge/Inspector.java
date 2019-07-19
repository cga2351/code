package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DoNotStrip
public class Inspector
{
  private final HybridData mHybridData;

  static
  {
    ReactBridge.staticInit();
  }

  private Inspector(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public static LocalConnection connect(int paramInt, RemoteConnection paramRemoteConnection)
  {
    try
    {
      LocalConnection localLocalConnection = instance().connectNative(paramInt, paramRemoteConnection);
      return localLocalConnection;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      FLog.e("ReactNative", "Inspector doesn't work in open source yet", localUnsatisfiedLinkError);
      throw new RuntimeException(localUnsatisfiedLinkError);
    }
  }

  private native LocalConnection connectNative(int paramInt, RemoteConnection paramRemoteConnection);

  public static List<Page> getPages()
  {
    try
    {
      List localList = Arrays.asList(instance().getPagesNative());
      return localList;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      FLog.e("ReactNative", "Inspector doesn't work in open source yet", localUnsatisfiedLinkError);
    }
    return Collections.emptyList();
  }

  private native Page[] getPagesNative();

  private static native Inspector instance();

  @DoNotStrip
  public static class LocalConnection
  {
    private final HybridData mHybridData;

    private LocalConnection(HybridData paramHybridData)
    {
      this.mHybridData = paramHybridData;
    }

    public native void disconnect();

    public native void sendMessage(String paramString);
  }

  @DoNotStrip
  public static class Page
  {
    private final int mId;
    private final String mTitle;
    private final String mVM;

    @DoNotStrip
    private Page(int paramInt, String paramString1, String paramString2)
    {
      this.mId = paramInt;
      this.mTitle = paramString1;
      this.mVM = paramString2;
    }

    public int getId()
    {
      return this.mId;
    }

    public String getTitle()
    {
      return this.mTitle;
    }

    public String getVM()
    {
      return this.mVM;
    }

    public String toString()
    {
      return "Page{mId=" + this.mId + ", mTitle='" + this.mTitle + '\'' + '}';
    }
  }

  @DoNotStrip
  public static abstract interface RemoteConnection
  {
    @DoNotStrip
    public abstract void onDisconnect();

    @DoNotStrip
    public abstract void onMessage(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.Inspector
 * JD-Core Version:    0.6.2
 */