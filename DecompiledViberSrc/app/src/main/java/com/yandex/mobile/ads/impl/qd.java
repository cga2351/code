package com.yandex.mobile.ads.impl;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.tracking.Tracker.ErrorListener;
import java.util.Random;

public final class qd
{
  private static Random a;
  private static qb b;

  static Random a()
  {
    if (a == null)
      return new Random();
    return a;
  }

  static qb b()
  {
    if (b == null)
      return new qb()
      {
        public final String a()
        {
          return pt.a();
        }
      };
    return b;
  }

  public static final class a
    implements pl.a<Void>
  {
    private final Tracker.ErrorListener a;

    public a(Tracker.ErrorListener paramErrorListener)
    {
      this.a = paramErrorListener;
    }

    public final void a(ov paramov)
    {
      if (this.a != null)
      {
        if (paramov == null)
          this.a.onTrackingError(VideoAdError.createInternalError("Tracking error"));
      }
      else
        return;
      if (paramov.a == null);
      for (VideoAdError localVideoAdError = VideoAdError.createConnectionError(paramov.getMessage()); ; localVideoAdError = VideoAdError.createInternalError("Tracking error"))
      {
        this.a.onTrackingError(localVideoAdError);
        return;
      }
    }
  }

  public static final class b<T>
    implements pl.a<T>
  {
    private final RequestListener<T> a;

    public b(RequestListener<T> paramRequestListener)
    {
      this.a = paramRequestListener;
    }

    public final void a(ov paramov)
    {
      VideoAdError localVideoAdError;
      if (this.a != null)
      {
        if (!(paramov instanceof py))
          break label35;
        localVideoAdError = VideoAdError.createNoAdError((py)paramov);
      }
      while (true)
      {
        this.a.onFailure(localVideoAdError);
        return;
        label35: if ((paramov instanceof pz))
        {
          localVideoAdError = VideoAdError.createInternalError((pz)paramov);
        }
        else
        {
          oh localoh = paramov.a;
          if (localoh == null)
          {
            localVideoAdError = VideoAdError.createConnectionError(paramov.getMessage());
          }
          else if ((localoh.a >= 500) && (localoh.a < 599))
          {
            localVideoAdError = VideoAdError.createRetriableError("Server temporarily unavailable. Please, try again later.");
          }
          else
          {
            String str1 = "Network Error. ";
            if (localoh != null)
            {
              String str2 = str1 + " Code: " + localoh.a + ".";
              str1 = str2 + " Data: \n" + new String(localoh.b);
            }
            localVideoAdError = VideoAdError.createInternalError(str1);
          }
        }
      }
    }

    public final void a(T paramT)
    {
      if (this.a != null)
        this.a.onSuccess(paramT);
    }
  }

  private static final class c
  {
    private static void a(Uri.Builder paramBuilder, String paramString1, String paramString2)
    {
      if (!TextUtils.isEmpty(paramString2))
        paramBuilder.appendQueryParameter(paramString1, paramString2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.qd
 * JD-Core Version:    0.6.2
 */