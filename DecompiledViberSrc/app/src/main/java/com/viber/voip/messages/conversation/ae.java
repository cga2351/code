package com.viber.voip.messages.conversation;

import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.group.participants.settings.b;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.messages.m;
import com.viber.voip.model.a;
import com.viber.voip.model.g;
import com.viber.voip.model.h;
import com.viber.voip.model.j;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dx;
import java.util.Collection;
import java.util.Iterator;

public class ae
  implements b, s, g, h
{
  public static final String[] a = { "participants._id", "participants.group_role", "participants.group_role_local", "participants.active", "participants_info._id", "participants_info.participant_type", "participants_info.contact_name", "participants_info.display_name", "participants_info.contact_id", "participants_info.member_id", "participants_info.number", "participants_info.viber_name", "participants_info.participant_info_flags", "participants_info.viber_image", "participants_info.native_photo_id", "participants_info.encrypted_number", "participants_info.encrypted_member_id" };
  private long b;
  private long c;
  private int d;
  private String e;
  private String f;
  private long g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private long m;
  private String n;
  private int o;
  private int p;
  private boolean q;
  private int r;

  public ae(Cursor paramCursor)
  {
    a(this, paramCursor);
  }

  private ae(a parama, String paramString, j paramj)
  {
    this.g = parama.j();
    this.e = parama.k();
    this.h = paramj.a();
    this.j = paramj.b();
    this.i = this.j;
    this.n = paramString;
    this.k = paramj.c();
    Uri localUri = dx.a(paramj.d());
    if (localUri != null)
      this.l = localUri.toString();
    this.p = 3;
    this.o = 3;
    this.d = 2;
  }

  private ae(String paramString1, String paramString2, String paramString3)
  {
    this.h = paramString1;
    this.j = paramString1;
    this.n = paramString2;
    this.k = paramString1;
    this.i = paramString1;
    Uri localUri = dx.a(paramString3);
    if (localUri != null)
      this.l = localUri.toString();
    this.p = 3;
    this.o = 3;
    this.d = 2;
  }

  public static ae a(String paramString1, String paramString2, a parama)
  {
    Iterator localIterator = parama.s().iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (paramString1.equals(localj.b()))
        return new ae(parama, paramString2, localj);
    }
    return new ae(paramString1, "", "");
  }

  public static ae a(String paramString1, String paramString2, String paramString3)
  {
    return new ae(paramString1, paramString2, paramString3);
  }

  private static void a(ae paramae, Cursor paramCursor)
  {
    paramae.b = paramCursor.getLong(0);
    paramae.o = paramCursor.getInt(1);
    paramae.c = paramCursor.getLong(4);
    paramae.d = paramCursor.getInt(5);
    paramae.e = paramCursor.getString(6);
    paramae.f = paramCursor.getString(7);
    paramae.g = paramCursor.getLong(8);
    paramae.h = paramCursor.getString(9);
    paramae.k = paramCursor.getString(10);
    paramae.n = paramCursor.getString(11);
    paramae.r = paramCursor.getInt(12);
    paramae.p = paramCursor.getInt(2);
    paramae.q = cd.h(paramCursor.getInt(3));
    paramae.l = paramCursor.getString(13);
    paramae.m = paramCursor.getLong(14);
    paramae.j = paramCursor.getString(15);
    paramae.i = paramCursor.getString(16);
  }

  public int a()
  {
    return this.o;
  }

  public String a(int paramInt1, int paramInt2)
  {
    return dg.a(this, paramInt2, paramInt1);
  }

  public String a(String paramString)
  {
    return da.f(paramString);
  }

  public int b()
  {
    return this.p;
  }

  public boolean c()
  {
    return this.q;
  }

  public boolean canWrite()
  {
    return cd.g(b());
  }

  public long d()
  {
    return this.c;
  }

  public int e()
  {
    return this.d;
  }

  public String f()
  {
    return this.f;
  }

  public long g()
  {
    return this.g;
  }

  public String getContactName()
  {
    return this.e;
  }

  public String getNumber()
  {
    return this.k;
  }

  public String getViberName()
  {
    return this.n;
  }

  public String h()
  {
    return this.h;
  }

  public long i()
  {
    return this.b;
  }

  public boolean isOwner()
  {
    return this.d == 0;
  }

  public Uri j()
  {
    return cd.a(isOwner(), this.l, this.m, this.g, m.c(this.k));
  }

  public String k()
  {
    return dg.a(this);
  }

  public boolean l()
  {
    return this.o == 2;
  }

  public int m()
  {
    return 0;
  }

  public boolean n()
  {
    return av.c(this.r, 0);
  }

  public String o()
  {
    return this.j;
  }

  public String p()
  {
    return this.i;
  }

  public String toString()
  {
    return "ParticipantLoaderEntity{id=" + this.b + ", participantInfo=" + this.c + ", participantType=" + this.d + ", contactName='" + this.e + '\'' + ", displayName='" + this.f + '\'' + ", contactId=" + this.g + ", memberId='" + this.h + '\'' + ", encryptedNumber='" + this.j + '\'' + ", number='" + this.k + '\'' + ", encryptedMemberId='" + this.i + '\'' + ", viberPhoto='" + this.l + '\'' + ", nativePhotoId=" + this.m + ", viberName='" + this.n + '\'' + ", groupRole=" + this.o + ", groupRoleLocal=" + this.p + ", flags=" + this.r + ", banned=" + this.q + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ae
 * JD-Core Version:    0.6.2
 */