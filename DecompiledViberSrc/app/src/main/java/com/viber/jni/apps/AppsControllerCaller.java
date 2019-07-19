package com.viber.jni.apps;

import com.viber.jni.Engine;
import com.viber.jni.controller.ConnectedCaller;
import com.viber.voip.util.ar;
import java.util.HashMap;
import java.util.Map;

public class AppsControllerCaller extends ConnectedCaller
  implements AppsController, AppsControllerDelegate.UserAppsReceiver
{
  private AppsController mAppsController;
  private Map<Integer, String> mSeqs = new HashMap();
  private AppsUserAppsReceiverListener mUserAppsListener;
  private ar<String, Integer[]> mUserAppsResponse = new ar(86400000L);

  public AppsControllerCaller(Engine paramEngine, AppsController paramAppsController, AppsUserAppsReceiverListener paramAppsUserAppsReceiverListener)
  {
    super(paramEngine);
    this.mAppsController = paramAppsController;
    this.mUserAppsListener = paramAppsUserAppsReceiverListener;
  }

  public static Integer[] toObject(int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramArrayOfInt == null)
      return null;
    if (paramArrayOfInt.length == 0)
      return new Integer[0];
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    while (i < paramArrayOfInt.length)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i++;
    }
    return arrayOfInteger;
  }

  private int[] toPrimitive(Integer[] paramArrayOfInteger)
  {
    int i = 0;
    if (paramArrayOfInteger == null)
      return null;
    if (paramArrayOfInteger.length == 0)
      return new int[0];
    int[] arrayOfInt = new int[paramArrayOfInteger.length];
    while (i < paramArrayOfInteger.length)
    {
      arrayOfInt[i] = paramArrayOfInteger[i].intValue();
      i++;
    }
    return arrayOfInt;
  }

  public boolean handleAuthenticateApp(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return this.mAppsController.handleAuthenticateApp(paramInt1, paramString, paramInt2, paramInt3, paramBoolean);
  }

  public boolean handleBlockApp(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    return this.mAppsController.handleBlockApp(paramInt1, paramBoolean, paramInt2, paramInt3);
  }

  public boolean handleGetAppDetails(int[] paramArrayOfInt, int paramInt)
  {
    return this.mAppsController.handleGetAppDetails(paramArrayOfInt, paramInt);
  }

  public boolean handleGetUserApps(final String paramString, final int paramInt)
  {
    Integer[] arrayOfInteger = (Integer[])this.mUserAppsResponse.get(paramString);
    if (arrayOfInteger == null)
    {
      if (this.mSeqs.containsValue(paramString))
        return false;
      this.mSeqs.put(Integer.valueOf(paramInt), paramString);
      runOnConnect(paramInt, new Runnable()
      {
        public void run()
        {
          AppsControllerCaller.this.mAppsController.handleGetUserApps(paramString, paramInt);
        }
      });
      return true;
    }
    this.mUserAppsListener.onGetUserAppsReply(toPrimitive(arrayOfInteger), paramInt, 0);
    return true;
  }

  public boolean handleUnregisterApp(int paramInt1, int paramInt2)
  {
    return this.mAppsController.handleUnregisterApp(paramInt1, paramInt2);
  }

  public void onGetUserAppsReply(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    String str = (String)this.mSeqs.remove(Integer.valueOf(paramInt1));
    if (str != null)
      this.mUserAppsResponse.put(str, toObject(paramArrayOfInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.apps.AppsControllerCaller
 * JD-Core Version:    0.6.2
 */