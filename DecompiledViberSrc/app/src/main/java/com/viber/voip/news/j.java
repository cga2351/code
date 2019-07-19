package com.viber.voip.news;

import android.os.Handler;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.util.cj;
import com.viber.voip.util.cv;
import dagger.b;

public final class j<PRESENTER extends NewsBrowserPresenter, VIEW extends l>
  implements b<i<PRESENTER, VIEW>>
{
  public static <PRESENTER extends NewsBrowserPresenter, VIEW extends l> void a(Object paramObject, Handler paramHandler)
  {
    ((i)paramObject).g = paramHandler;
  }

  public static <PRESENTER extends NewsBrowserPresenter, VIEW extends l> void a(Object paramObject, q paramq)
  {
    ((i)paramObject).a = paramq;
  }

  public static <PRESENTER extends NewsBrowserPresenter, VIEW extends l> void a(Object paramObject, cj paramcj)
  {
    ((i)paramObject).c = paramcj;
  }

  public static <PRESENTER extends NewsBrowserPresenter, VIEW extends l> void a(Object paramObject, cv paramcv)
  {
    ((i)paramObject).b = paramcv;
  }

  public static <PRESENTER extends NewsBrowserPresenter, VIEW extends l> void a(Object paramObject, com.viber.voip.util.i.a parama)
  {
    ((i)paramObject).d = parama;
  }

  public static <PRESENTER extends NewsBrowserPresenter, VIEW extends l> void a(Object paramObject, dagger.a<ICdrController> parama)
  {
    ((i)paramObject).e = parama;
  }

  public static <PRESENTER extends NewsBrowserPresenter, VIEW extends l> void b(Object paramObject, dagger.a<com.viber.voip.analytics.story.g.a> parama)
  {
    ((i)paramObject).f = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.j
 * JD-Core Version:    0.6.2
 */