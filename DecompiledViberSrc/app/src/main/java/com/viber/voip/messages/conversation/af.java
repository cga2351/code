package com.viber.voip.messages.conversation;

import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.util.av;
import com.viber.voip.util.da;

public class af
{
  public static final String[] a = { "messages.msg_date", "messages.status", "messages.token", "messages.send_type", "messages.msg_info", "messages.extra_uri", "messages.user_id", "messages.spans", "messages.extra_flags" };
  private long b;
  private int c;
  private long d;
  private int e;
  private MsgInfo f;
  private String g;
  private String h;
  private Uri i;
  private String j;
  private long k;

  public af(Cursor paramCursor)
  {
    this.b = paramCursor.getLong(0);
    this.c = paramCursor.getInt(1);
    this.d = paramCursor.getLong(2);
    this.e = paramCursor.getInt(3);
    this.g = paramCursor.getString(4);
    this.h = paramCursor.getString(6);
    this.j = paramCursor.getString(7);
    this.k = paramCursor.getLong(8);
    String str = paramCursor.getString(5);
    if (!da.a(str))
      this.i = Uri.parse(str);
  }

  public boolean a()
  {
    return (this.c == 1) || (this.c == 2);
  }

  public long b()
  {
    return this.d;
  }

  public long c()
  {
    return this.b;
  }

  public Pin d()
  {
    if (this.f == null)
      this.f = ((MsgInfo)e.a().a().a(this.g));
    return this.f.getPin();
  }

  public Uri e()
  {
    return this.i;
  }

  public boolean f()
  {
    return this.e == 0;
  }

  public String g()
  {
    return this.h;
  }

  public String h()
  {
    return this.j;
  }

  public boolean i()
  {
    return av.c(this.k, 41);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.af
 * JD-Core Version:    0.6.2
 */