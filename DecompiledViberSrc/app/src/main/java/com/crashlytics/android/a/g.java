package com.crashlytics.android.a;

import android.content.Context;
import android.os.Looper;
import c.a.a.a.a.b.w;
import c.a.a.a.a.f.a;
import java.io.File;
import java.io.IOException;

class g
{
  final Context a;
  final a b;

  public g(Context paramContext, a parama)
  {
    this.a = paramContext;
    this.b = parama;
  }

  public z a()
    throws IOException
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    af localaf = new af();
    w localw = new w();
    File localFile = this.b.a();
    c.a.a.a.a.d.g localg = new c.a.a.a.a.d.g(this.a, localFile, "session_analytics.tap", "session_analytics_to_send");
    return new z(this.a, localaf, localw, localg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.g
 * JD-Core Version:    0.6.2
 */