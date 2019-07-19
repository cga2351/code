package com.viber.voip.messages.conversation.chatinfo.d;

import android.net.Uri;

public class h
  implements d
{
  private final String a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private Uri f;

  public h(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Uri paramUri)
  {
    this.a = paramString;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean4;
    this.e = paramBoolean3;
    this.f = paramUri;
  }

  public String a()
  {
    return this.a;
  }

  public void a(Uri paramUri)
  {
    this.f = paramUri;
  }

  public boolean b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.e;
  }

  public com.viber.voip.messages.conversation.chatinfo.presentation.a.d d()
  {
    return com.viber.voip.messages.conversation.chatinfo.presentation.a.d.c;
  }

  public int e()
  {
    return e.a(this);
  }

  public boolean f()
  {
    return this.c;
  }

  public boolean g()
  {
    return this.d;
  }

  public Uri h()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.d.h
 * JD-Core Version:    0.6.2
 */