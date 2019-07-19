package com.mopub.mobileads.dfp.adapters;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DownloadDrawablesAsync extends AsyncTask<Object, Void, HashMap<String, Drawable>>
{
  public static final String KEY_ICON = "icon_key";
  public static final String KEY_IMAGE = "image_key";
  private static final Logger a = ViberEnv.getLogger();
  private DrawableDownloadListener b;

  public DownloadDrawablesAsync(DrawableDownloadListener paramDrawableDownloadListener)
  {
    this.b = paramDrawableDownloadListener;
  }

  private Future<Drawable> a(URL paramURL, ExecutorService paramExecutorService)
  {
    return paramExecutorService.submit(new a(paramURL));
  }

  protected HashMap<String, Drawable> a(Object[] paramArrayOfObject)
  {
    HashMap localHashMap1 = (HashMap)paramArrayOfObject[0];
    ExecutorService localExecutorService = Executors.newCachedThreadPool();
    Future localFuture1 = a((URL)localHashMap1.get("image_key"), localExecutorService);
    Future localFuture2 = a((URL)localHashMap1.get("icon_key"), localExecutorService);
    try
    {
      Drawable localDrawable1 = (Drawable)localFuture1.get(10L, TimeUnit.SECONDS);
      Drawable localDrawable2 = (Drawable)localFuture2.get(10L, TimeUnit.SECONDS);
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("image_key", localDrawable1);
      localHashMap2.put("icon_key", localDrawable2);
      return localHashMap2;
    }
    catch (InterruptedException localInterruptedException)
    {
      a.b("Native ad images failed to download", new Object[0]);
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      break label113;
    }
    catch (TimeoutException localTimeoutException)
    {
      label113: break label113;
    }
  }

  protected void a(HashMap<String, Drawable> paramHashMap)
  {
    super.onPostExecute(paramHashMap);
    if (paramHashMap != null)
    {
      this.b.onDownloadSuccess(paramHashMap);
      return;
    }
    this.b.onDownloadFailure();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.dfp.adapters.DownloadDrawablesAsync
 * JD-Core Version:    0.6.2
 */