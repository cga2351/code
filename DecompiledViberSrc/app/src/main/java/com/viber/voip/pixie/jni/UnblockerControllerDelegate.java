package com.viber.voip.pixie.jni;

import android.net.Uri;
import com.viber.common.b.g;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.pixie.UnblockerController.UnblockerControllerListener;
import com.viber.voip.util.dz;
import com.viber.voip.util.http.OkHttpClientFactory;
import com.viber.voip.util.http.OkHttpClientFactory.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class UnblockerControllerDelegate
  implements UnblockerController.UnblockerControllerListener
{
  private static final Logger L = ViberEnv.getLogger();
  HashSet<UnblockerController.UnblockerControllerListener> mListenerSet = new HashSet();

  private int downloadUrl(String paramString, double paramDouble, String[] paramArrayOfString)
  {
    int i = (int)(1000.0D * paramDouble);
    try
    {
      OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder(OkHttpClientFactory.Type.DIRECT).connectTimeout(i, TimeUnit.MILLISECONDS).readTimeout(i, TimeUnit.MILLISECONDS);
      Request.Builder localBuilder1 = new Request.Builder().url(paramString);
      localBuilder1.header("User-Agent", Uri.encode(dz.a(), " "));
      paramArrayOfString[0] = localBuilder.build().newCall(localBuilder1.build()).execute().body().string();
      return 0;
    }
    catch (Exception localException)
    {
    }
    return 1;
  }

  private int getPersistanceStorage(String paramString, String[] paramArrayOfString)
  {
    String str = ViberApplication.preferences().a(paramString, null);
    if ((str == null) || (str.length() == 0))
      return 6;
    paramArrayOfString[0] = str;
    return 0;
  }

  private int setPersistanceStorage(String paramString1, String paramString2)
  {
    ViberApplication.preferences().b(paramString1, paramString2);
    return 0;
  }

  public void addListener(UnblockerController.UnblockerControllerListener paramUnblockerControllerListener)
  {
    try
    {
      this.mListenerSet.add(paramUnblockerControllerListener);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onDebugInfo(int paramInt, String paramString1, String paramString2)
  {
  }

  public void onNetworkReadyToUse()
  {
    Iterator localIterator = this.mListenerSet.iterator();
    while (localIterator.hasNext())
      ((UnblockerController.UnblockerControllerListener)localIterator.next()).onNetworkReadyToUse();
  }

  public void onUnblockerStatusUpdate(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.mListenerSet.iterator();
    while (localIterator.hasNext())
      ((UnblockerController.UnblockerControllerListener)localIterator.next()).onUnblockerStatusUpdate(paramInt1, paramInt2);
  }

  public void removeListener(UnblockerController.UnblockerControllerListener paramUnblockerControllerListener)
  {
    try
    {
      this.mListenerSet.remove(paramUnblockerControllerListener);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.jni.UnblockerControllerDelegate
 * JD-Core Version:    0.6.2
 */