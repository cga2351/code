package com.my.target;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.f.q;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.source.c.b;
import com.google.android.exoplayer2.source.c.j.a;
import com.google.android.exoplayer2.source.l.c;
import com.google.android.exoplayer2.source.n;
import com.my.target.common.a.c;

public class bp
{
  public static n a(Uri paramUri, Context paramContext)
  {
    q localq = new q(paramContext, ag.a(paramContext, "myTarget"));
    if (ag.b(paramUri) == 2)
      return new j.a(new b(localq)).a(paramUri);
    return new l.c(localq).a(paramUri);
  }

  public static n a(c paramc, Context paramContext)
  {
    String str = (String)paramc.d();
    if (str != null)
      return a(Uri.parse(str), paramContext);
    return a(Uri.parse(paramc.a()), paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bp
 * JD-Core Version:    0.6.2
 */