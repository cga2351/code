package com.viber.voip.engagement.d;

import android.content.ContentResolver;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.memberid.Member;
import com.viber.voip.user.OnlineUserActivityHelper;
import java.util.ArrayList;
import java.util.List;

public class g
  implements j
{
  private final boolean a;
  private final Member b;
  private final ContentResolver c;
  private final m d;
  private final PhoneController e;
  private final OnlineUserActivityHelper f;

  public g(boolean paramBoolean, Member paramMember, ContentResolver paramContentResolver, m paramm, PhoneController paramPhoneController, OnlineUserActivityHelper paramOnlineUserActivityHelper)
  {
    this.a = paramBoolean;
    this.b = paramMember;
    this.c = paramContentResolver;
    this.d = paramm;
    this.e = paramPhoneController;
    this.f = paramOnlineUserActivityHelper;
  }

  public i a()
  {
    ArrayList localArrayList = new ArrayList(3);
    if (this.a)
      localArrayList.add(new d(new d.a(this.c)));
    localArrayList.add(new c());
    localArrayList.add(new a(this.e, this.f));
    return new i(new f(this.b, this.d), new h(), (l[])localArrayList.toArray(new l[localArrayList.size()]));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.g
 * JD-Core Version:    0.6.2
 */