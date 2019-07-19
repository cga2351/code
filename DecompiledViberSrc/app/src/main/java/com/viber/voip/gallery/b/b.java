package com.viber.voip.gallery.b;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public abstract class b<D> extends AsyncTaskLoader<D>
{
  private D a;

  public b(Context paramContext)
  {
    super(paramContext);
  }

  public void deliverResult(D paramD)
  {
    if (isReset());
    do
    {
      return;
      this.a = paramD;
    }
    while (!isStarted());
    super.deliverResult(paramD);
  }

  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    this.a = null;
  }

  protected void onStartLoading()
  {
    super.onStartLoading();
    if (this.a != null)
      deliverResult(this.a);
    if ((takeContentChanged()) || (this.a == null))
      forceLoad();
  }

  protected void onStopLoading()
  {
    super.onStopLoading();
    cancelLoad();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.b.b
 * JD-Core Version:    0.6.2
 */