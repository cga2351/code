package com.viber.voip.api.scheme;

import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import com.viber.voip.api.scheme.action.c;

public abstract class h
{
  private UriMatcher a = new UriMatcher(-1);
  private SparseArray<g> b = new SparseArray();

  public h()
  {
    b();
  }

  private void b()
  {
    for (g localg : a())
    {
      this.a.addURI(localg.a(), localg.b(), localg.c());
      this.b.put(localg.c(), localg);
    }
  }

  public c a(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    int i = this.a.match(paramUri);
    if (i == -1)
      return null;
    g localg = (g)this.b.get(i);
    if (localg == null)
      return null;
    return localg.a(paramContext, paramUri, paramBundle);
  }

  public boolean a(Uri paramUri, g paramg)
  {
    int i = this.a.match(paramUri);
    return (i != -1) && (this.b.get(i) == paramg);
  }

  public abstract g[] a();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.h
 * JD-Core Version:    0.6.2
 */