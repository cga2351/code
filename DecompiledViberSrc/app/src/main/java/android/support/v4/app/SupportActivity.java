package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.e;
import android.arch.lifecycle.e.b;
import android.arch.lifecycle.h;
import android.arch.lifecycle.i;
import android.arch.lifecycle.q;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v4.view.KeyEventDispatcher.Component;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

public class SupportActivity extends Activity
  implements h, KeyEventDispatcher.Component
{
  private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap = new SimpleArrayMap();
  private i mLifecycleRegistry = new i(this);

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (KeyEventDispatcher.dispatchBeforeHierarchy(localView, paramKeyEvent)))
      return true;
    return KeyEventDispatcher.dispatchKeyEvent(this, localView, this, paramKeyEvent);
  }

  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (KeyEventDispatcher.dispatchBeforeHierarchy(localView, paramKeyEvent)))
      return true;
    return super.dispatchKeyShortcutEvent(paramKeyEvent);
  }

  public <T extends ExtraData> T getExtraData(Class<T> paramClass)
  {
    return (ExtraData)this.mExtraDataMap.get(paramClass);
  }

  public e getLifecycle()
  {
    return this.mLifecycleRegistry;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    q.a(this);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLifecycleRegistry.a(e.b.c);
    super.onSaveInstanceState(paramBundle);
  }

  public void putExtraData(ExtraData paramExtraData)
  {
    this.mExtraDataMap.put(paramExtraData.getClass(), paramExtraData);
  }

  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public static class ExtraData
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.SupportActivity
 * JD-Core Version:    0.6.2
 */