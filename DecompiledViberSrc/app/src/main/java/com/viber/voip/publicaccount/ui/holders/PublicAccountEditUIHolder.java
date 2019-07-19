package com.viber.voip.publicaccount.ui.holders;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.viber.voip.publicaccount.entity.PublicAccount;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class PublicAccountEditUIHolder<D extends HolderData, V extends a>
  implements c
{
  protected D a = d();
  protected V b = a(b());
  private boolean c;

  private V a(Class<V> paramClass)
  {
    return (a)Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, new InvocationHandler()
    {
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        return null;
      }
    });
  }

  private String a(String paramString)
  {
    return getClass().getName() + paramString;
  }

  private void e()
  {
    if (this.c)
      a(this.b, this.a);
  }

  public void a()
  {
    if (this.c)
      a(this.a, this.b);
    this.b.a();
    this.b = a(b());
  }

  public void a(Bundle paramBundle)
  {
    if (this.c)
    {
      a(this.a, this.b);
      paramBundle.putParcelable(a("holder_data"), this.a);
    }
    paramBundle.putBoolean(a("is_initialized"), this.c);
  }

  public void a(View paramView)
  {
    this.b = b(paramView);
    e();
  }

  public void a(PublicAccount paramPublicAccount)
  {
    if (c())
    {
      this.c = true;
      this.a.init(paramPublicAccount);
      e();
    }
  }

  protected abstract void a(D paramD, V paramV);

  protected abstract void a(V paramV, D paramD);

  protected abstract V b(View paramView);

  protected abstract Class<V> b();

  public void b(Bundle paramBundle)
  {
    this.c = paramBundle.getBoolean(a("is_initialized"));
    if (this.c)
    {
      HolderData localHolderData = (HolderData)paramBundle.getParcelable(a("holder_data"));
      if (localHolderData != null)
      {
        this.a = localHolderData;
        e();
      }
    }
  }

  public void b(PublicAccount paramPublicAccount)
  {
    if (this.c)
    {
      a(this.a, this.b);
      this.a.fill(paramPublicAccount);
    }
  }

  protected boolean c()
  {
    return !this.c;
  }

  protected abstract D d();

  public static abstract interface HolderData extends Parcelable
  {
    public abstract void fill(PublicAccount paramPublicAccount);

    public abstract void init(PublicAccount paramPublicAccount);
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder
 * JD-Core Version:    0.6.2
 */