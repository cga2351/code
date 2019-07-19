package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.a.a.a;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.drm.p;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.n.a;
import com.google.android.exoplayer2.g.ag;

public final class k
{
  private static d a;

  public static aj a(Context paramContext, ah paramah, com.google.android.exoplayer2.trackselection.h paramh)
  {
    return a(paramContext, paramah, paramh, new f());
  }

  public static aj a(Context paramContext, ah paramah, com.google.android.exoplayer2.trackselection.h paramh, s params)
  {
    return a(paramContext, paramah, paramh, params, null, ag.a());
  }

  public static aj a(Context paramContext, ah paramah, com.google.android.exoplayer2.trackselection.h paramh, s params, l<p> paraml, Looper paramLooper)
  {
    return a(paramContext, paramah, paramh, params, paraml, new a.a(), paramLooper);
  }

  public static aj a(Context paramContext, ah paramah, com.google.android.exoplayer2.trackselection.h paramh, s params, l<p> paraml, a.a parama, Looper paramLooper)
  {
    return a(paramContext, paramah, paramh, params, paraml, a(), parama, paramLooper);
  }

  public static aj a(Context paramContext, ah paramah, com.google.android.exoplayer2.trackselection.h paramh, s params, l<p> paraml, d paramd, a.a parama, Looper paramLooper)
  {
    return new aj(paramContext, paramah, paramh, params, paraml, paramd, parama, paramLooper);
  }

  public static aj a(Context paramContext, com.google.android.exoplayer2.trackselection.h paramh)
  {
    return a(paramContext, new h(paramContext), paramh);
  }

  private static d a()
  {
    try
    {
      if (a == null)
        a = new n.a().a();
      d locald = a;
      return locald;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.k
 * JD-Core Version:    0.6.2
 */