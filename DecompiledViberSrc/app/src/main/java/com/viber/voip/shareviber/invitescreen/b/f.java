package com.viber.voip.shareviber.invitescreen.b;

import android.content.ContentResolver;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.memberid.Member;
import com.viber.voip.registration.af;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private final boolean a;
  private final Member b;
  private final ContentResolver c;
  private final com.viber.voip.contacts.c.d.m d;
  private final com.viber.voip.calls.d e;
  private final PhoneController f;
  private final af g;

  public f(boolean paramBoolean, Member paramMember, ContentResolver paramContentResolver, com.viber.voip.contacts.c.d.m paramm, com.viber.voip.calls.d paramd, PhoneController paramPhoneController, af paramaf)
  {
    this.a = paramBoolean;
    this.b = paramMember;
    this.c = paramContentResolver;
    this.d = paramm;
    this.e = paramd;
    this.f = paramPhoneController;
    this.g = paramaf;
  }

  public g a()
  {
    ArrayList localArrayList = new ArrayList(3);
    if (this.a)
    {
      localArrayList.add(new b(new b.a(this.c)));
      localArrayList.add(new a());
      localArrayList.add(new m(this.e));
      localArrayList.add(new c(this.f, this.g));
    }
    return new g(new e(this.b, this.d), new d(), (j[])localArrayList.toArray(new j[localArrayList.size()]));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.f
 * JD-Core Version:    0.6.2
 */