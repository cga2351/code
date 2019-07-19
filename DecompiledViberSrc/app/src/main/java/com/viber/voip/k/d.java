package com.viber.voip.k;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.viber.voip.g.b.b;

public abstract class d
{
  protected final a a;
  private final dagger.a<com.google.a.a.b.a.a.b.a.a> b;

  public d(final Context paramContext, final a parama)
  {
    this.a = parama;
    this.b = new b()
    {
      protected com.google.a.a.b.a.a.b.a.a a()
      {
        return d.this.a(paramContext.getApplicationContext(), parama);
      }
    };
  }

  protected abstract com.google.a.a.b.a.a.b.a.a a(Context paramContext, a parama);

  public void a(Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(((com.google.a.a.b.a.a.b.a.a)this.b.get()).d(), paramInt);
  }

  public void a(Fragment paramFragment, int paramInt)
  {
    paramFragment.startActivityForResult(((com.google.a.a.b.a.a.b.a.a)this.b.get()).d(), paramInt);
  }

  public void a(String paramString)
  {
    ((com.google.a.a.b.a.a.b.a.a)this.b.get()).a(paramString);
    this.a.a(paramString);
  }

  public boolean a(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      String str = paramIntent.getStringExtra("authAccount");
      if (str != null)
      {
        a(str);
        return true;
      }
    }
    return false;
  }

  public com.google.a.a.b.a.a.b.a.a b()
  {
    return (com.google.a.a.b.a.a.b.a.a)this.b.get();
  }

  public com.google.a.a.b.a.a.b.a.a c()
  {
    return a(((com.google.a.a.b.a.a.b.a.a)this.b.get()).a(), this.a);
  }

  public boolean d()
  {
    return ((com.google.a.a.b.a.a.b.a.a)this.b.get()).c() != null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.k.d
 * JD-Core Version:    0.6.2
 */