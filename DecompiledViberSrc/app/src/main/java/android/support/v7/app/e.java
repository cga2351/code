package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class e
{
  private static int a = -1;

  public static e a(Activity paramActivity, d paramd)
  {
    return new AppCompatDelegateImpl(paramActivity, paramActivity.getWindow(), paramd);
  }

  public static e a(Dialog paramDialog, d paramd)
  {
    return new AppCompatDelegateImpl(paramDialog.getContext(), paramDialog.getWindow(), paramd);
  }

  public static int k()
  {
    return a;
  }

  public abstract a a();

  public abstract b a(android.support.v7.view.b.a parama);

  public abstract <T extends View> T a(int paramInt);

  public abstract void a(Configuration paramConfiguration);

  public abstract void a(Bundle paramBundle);

  public abstract void a(Toolbar paramToolbar);

  public abstract void a(View paramView);

  public abstract void a(View paramView, ViewGroup.LayoutParams paramLayoutParams);

  public abstract void a(CharSequence paramCharSequence);

  public abstract MenuInflater b();

  public abstract void b(int paramInt);

  public abstract void b(Bundle paramBundle);

  public abstract void b(View paramView, ViewGroup.LayoutParams paramLayoutParams);

  public abstract void c();

  public abstract void c(Bundle paramBundle);

  public abstract boolean c(int paramInt);

  public abstract void d();

  public abstract void e();

  public abstract void f();

  public abstract void g();

  public abstract b.a h();

  public abstract void i();

  public abstract boolean j();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.e
 * JD-Core Version:    0.6.2
 */