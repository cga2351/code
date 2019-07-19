package com.viber.voip.messages.conversation.ui.edit.group;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcelable;
import com.viber.voip.analytics.g;

public abstract interface AddGroupDetailsPresenter
{
  public abstract void a(Parcelable paramParcelable);

  public abstract void a(AddDetailsGoNextAction paramAddDetailsGoNextAction);

  public abstract void a(c paramc);

  public abstract void a(String paramString);

  public abstract void b();

  public abstract void b(long paramLong);

  public abstract void c();

  public abstract void d();

  public abstract void e();

  public abstract void f();

  public abstract void g();

  public abstract void h();

  public abstract void i();

  public abstract Parcelable j();

  public static abstract interface AddDetailsGoNextAction extends Parcelable
  {
    public abstract void goNext(Activity paramActivity, g paramg, String paramString1, Uri paramUri, String paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.edit.group.AddGroupDetailsPresenter
 * JD-Core Version:    0.6.2
 */