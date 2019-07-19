package com.viber.voip.messages.controller;

import android.net.Uri;
import com.viber.voip.model.entity.m;
import java.util.Set;

public abstract interface ci
{
  public abstract void a(Uri paramUri);

  public abstract void a(String paramString);

  public abstract void a(String paramString, a parama, boolean paramBoolean);

  public abstract void a(Set<String> paramSet, a parama, boolean paramBoolean);

  public abstract void a(Set<String> paramSet, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

  public abstract void b(String paramString, a parama, boolean paramBoolean);

  public abstract void b(Set<String> paramSet, a parama, boolean paramBoolean);

  public static abstract interface a
  {
    public abstract void onGetUserDetail(m[] paramArrayOfm);

    public abstract void onGetUserError();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.ci
 * JD-Core Version:    0.6.2
 */