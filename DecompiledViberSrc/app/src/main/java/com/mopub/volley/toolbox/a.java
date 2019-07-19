package com.mopub.volley.toolbox;

import android.os.Looper;

final class a
{
  static void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      throw new IllegalStateException("Must be invoked from the main thread.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.a
 * JD-Core Version:    0.6.2
 */