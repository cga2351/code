package com.mopub.volley.toolbox;

import android.content.Context;
import com.mopub.volley.Network;
import com.mopub.volley.RequestQueue;
import java.io.File;

public class Volley
{
  private static RequestQueue a(Context paramContext, Network paramNetwork)
  {
    RequestQueue localRequestQueue = new RequestQueue(new DiskBasedCache(new File(paramContext.getCacheDir(), "volley")), paramNetwork);
    localRequestQueue.start();
    return localRequestQueue;
  }

  public static RequestQueue newRequestQueue(Context paramContext, BaseHttpStack paramBaseHttpStack)
  {
    if (paramBaseHttpStack == null);
    for (BasicNetwork localBasicNetwork = new BasicNetwork(new HurlStack()); ; localBasicNetwork = new BasicNetwork(paramBaseHttpStack))
      return a(paramContext, localBasicNetwork);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.Volley
 * JD-Core Version:    0.6.2
 */