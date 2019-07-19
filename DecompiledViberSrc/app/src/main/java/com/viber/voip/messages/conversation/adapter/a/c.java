package com.viber.voip.messages.conversation.adapter.a;

import android.net.Uri;
import android.text.TextUtils;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.d.b;
import com.viber.voip.user.UserData;

public class c
{
  private final aa a;
  private final UserData b;

  public c(aa paramaa, UserData paramUserData)
  {
    this.a = paramaa;
    this.b = paramUserData;
  }

  public Uri a(b paramb)
  {
    if (this.a.ap())
      return this.b.getImage();
    if (a())
      return Uri.parse(this.a.bs());
    return paramb.a(this.a.u());
  }

  public String a(int paramInt)
  {
    if ((this.a.V()) && (!TextUtils.isEmpty(this.a.bq())))
      return this.a.bq();
    return this.a.c(paramInt);
  }

  public boolean a()
  {
    return (!this.a.ap()) && (this.a.V()) && (!TextUtils.isEmpty(this.a.bs()));
  }

  public String b(int paramInt)
  {
    if ((this.a.V()) && (!TextUtils.isEmpty(this.a.br())))
      return this.a.br();
    return this.a.d(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.c
 * JD-Core Version:    0.6.2
 */