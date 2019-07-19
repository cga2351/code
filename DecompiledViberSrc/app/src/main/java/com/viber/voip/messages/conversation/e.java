package com.viber.voip.messages.conversation;

import android.database.Cursor;
import com.viber.voip.messages.adapters.p;
import com.viber.voip.messages.adapters.q;
import com.viber.voip.util.da;

public class e
  implements p
{
  public static final String[] a = { "messages.read_message_time", "participants_info._id", "participants_info.member_id", "participants_info.contact_name", "participants_info.display_name" };
  private boolean b;
  private String c;
  private long d;
  private String e;
  private String f;
  private transient String g;

  public e(Cursor paramCursor)
  {
    boolean bool1 = paramCursor.getLong(0) < 0L;
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    this.b = bool2;
    this.d = paramCursor.getLong(1);
    this.c = paramCursor.getString(2);
    this.e = paramCursor.getString(3);
    this.f = paramCursor.getString(4);
  }

  public boolean a()
  {
    return this.b;
  }

  public int b()
  {
    return 4;
  }

  public int c()
  {
    return 1;
  }

  public long d()
  {
    return this.d;
  }

  public long e()
  {
    return 0L;
  }

  public int f()
  {
    return q.a(this);
  }

  public String g()
  {
    return this.f;
  }

  public String h()
  {
    if ((!da.a(this.f)) && (da.a(this.g)))
      this.g = da.f(this.f);
    return this.g;
  }

  public long i()
  {
    return 0L;
  }

  public String toString()
  {
    return "BroadcastMessageInfoLoaderEntity{mRead=" + this.b + ", mParticipantMemberId='" + this.c + '\'' + ", mParticipantInfoId=" + this.d + ", mContactName='" + this.e + '\'' + ", mDisplayName='" + this.f + '\'' + ", mInitials='" + this.g + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.e
 * JD-Core Version:    0.6.2
 */