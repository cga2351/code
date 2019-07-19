package com.viber.voip.pixie.jni;

import android.os.Bundle;

public class UnblockerControllerHelper
{
  protected native boolean ShouldCheckGeoInfo();

  protected native void addRedirect(String paramString1, String paramString2);

  @Deprecated
  protected native void crashLibrary();

  protected native void done();

  protected native String[] getDomains();

  protected native String getUnblockerInfo();

  protected native int init(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, boolean paramBoolean, String paramString8);

  protected native void setProxy(int paramInt, Bundle paramBundle, boolean paramBoolean);

  protected native void setPushConfig(String paramString);

  protected native void setSocksProxy(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean);

  protected native void updateGeoInfo();

  protected native void updatePhoneNumber(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.jni.UnblockerControllerHelper
 * JD-Core Version:    0.6.2
 */