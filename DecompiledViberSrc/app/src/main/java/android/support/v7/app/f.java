package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v4.view.KeyEventDispatcher.Component;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class f extends Dialog
  implements d
{
  private e mDelegate;
  private final KeyEventDispatcher.Component mKeyDispatcher = new KeyEventDispatcher.Component()
  {
    public boolean superDispatchKeyEvent(KeyEvent paramAnonymousKeyEvent)
    {
      return f.this.superDispatchKeyEvent(paramAnonymousKeyEvent);
    }
  };

  public f(Context paramContext)
  {
    this(paramContext, 0);
  }

  public f(Context paramContext, int paramInt)
  {
    super(paramContext, getThemeResId(paramContext, paramInt));
    getDelegate().a(null);
    getDelegate().j();
  }

  protected f(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }

  private static int getThemeResId(Context paramContext, int paramInt)
  {
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(R.attr.dialogTheme, localTypedValue, true);
      paramInt = localTypedValue.resourceId;
    }
    return paramInt;
  }

  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().b(paramView, paramLayoutParams);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    return KeyEventDispatcher.dispatchKeyEvent(this.mKeyDispatcher, localView, this, paramKeyEvent);
  }

  public <T extends View> T findViewById(int paramInt)
  {
    return getDelegate().a(paramInt);
  }

  public e getDelegate()
  {
    if (this.mDelegate == null)
      this.mDelegate = e.a(this, this);
    return this.mDelegate;
  }

  public a getSupportActionBar()
  {
    return getDelegate().a();
  }

  public void invalidateOptionsMenu()
  {
    getDelegate().f();
  }

  protected void onCreate(Bundle paramBundle)
  {
    getDelegate().i();
    super.onCreate(paramBundle);
    getDelegate().a(paramBundle);
  }

  protected void onStop()
  {
    super.onStop();
    getDelegate().d();
  }

  public void onSupportActionModeFinished(b paramb)
  {
  }

  public void onSupportActionModeStarted(b paramb)
  {
  }

  public b onWindowStartingSupportActionMode(b.a parama)
  {
    return null;
  }

  public void setContentView(int paramInt)
  {
    getDelegate().b(paramInt);
  }

  public void setContentView(View paramView)
  {
    getDelegate().a(paramView);
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().a(paramView, paramLayoutParams);
  }

  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    getDelegate().a(getContext().getString(paramInt));
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    getDelegate().a(paramCharSequence);
  }

  boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().c(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.f
 * JD-Core Version:    0.6.2
 */