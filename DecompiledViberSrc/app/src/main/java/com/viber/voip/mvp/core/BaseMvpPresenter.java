package com.viber.voip.mvp.core;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.b;
import android.arch.lifecycle.e;
import android.arch.lifecycle.h;
import com.viber.voip.util.cl;

public abstract class BaseMvpPresenter<MVP_VIEW extends j, STATE extends State>
  implements DefaultLifecycleObserver
{
  protected e mLifecycle;
  protected MVP_VIEW mView = createStubView();

  private MVP_VIEW createStubView()
  {
    return (j)cl.c(getClass());
  }

  public final void attachView(MVP_VIEW paramMVP_VIEW, e parame, STATE paramSTATE)
  {
    this.mView = paramMVP_VIEW;
    this.mLifecycle = parame;
    onViewAttached(paramSTATE);
    parame.a(this);
  }

  protected STATE getSaveState()
  {
    return null;
  }

  public void onCreate(h paramh)
  {
    b.a(this, paramh);
  }

  public void onDestroy(h paramh)
  {
    paramh.getLifecycle().b(this);
    this.mView.onDestroy();
    this.mView = createStubView();
    this.mLifecycle = null;
  }

  public void onPause(h paramh)
  {
    this.mView.onPause();
  }

  public void onResume(h paramh)
  {
    this.mView.onResume();
  }

  public void onStart(h paramh)
  {
    this.mView.onStart();
  }

  public void onStop(h paramh)
  {
    this.mView.onStop();
  }

  protected void onViewAttached(STATE paramSTATE)
  {
  }

  protected void onViewConfigurationChanged()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.mvp.core.BaseMvpPresenter
 * JD-Core Version:    0.6.2
 */