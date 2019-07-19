package com.viber.voip.messages.conversation;

import android.database.Cursor;
import com.viber.voip.messages.adapters.p;
import com.viber.voip.messages.adapters.q;
import com.viber.voip.model.g;

public class y
  implements p, g
{
  public static final String[] a = { "messages_likes._id", "messages_likes.message_token", "messages_likes.like_token", "messages_likes.participant_number", "messages_likes.date", "messages_likes.read", "participants_info._id", "participants_info.participant_type", "participants_info.contact_id", "participants_info.contact_name", "participants_info.viber_name", "participants_info.number", "participants_info.viber_image", "participants_info.native_photo_id" };
  private long b;
  private long c;
  private long d;
  private String e;
  private long f;
  private boolean g;
  private String h;
  private long i;
  private int j;
  private long k;
  private String l;
  private String m;
  private String n;
  private long o;

  public y(Cursor paramCursor)
  {
    this.b = paramCursor.getLong(0);
    this.c = paramCursor.getLong(i1);
    this.d = paramCursor.getLong(2);
    this.e = paramCursor.getString(3);
    this.f = paramCursor.getLong(4);
    if (paramCursor.getInt(5) > 0);
    while (true)
    {
      this.g = i1;
      this.i = paramCursor.getLong(6);
      this.j = paramCursor.getInt(7);
      this.k = paramCursor.getLong(8);
      this.l = paramCursor.getString(9);
      this.h = paramCursor.getString(10);
      this.m = paramCursor.getString(11);
      this.n = paramCursor.getString(12);
      this.o = paramCursor.getLong(13);
      return;
      i1 = 0;
    }
  }

  public long a()
  {
    return this.f;
  }

  public int b()
  {
    return 1;
  }

  public int c()
  {
    return this.j;
  }

  public long d()
  {
    return this.i;
  }

  public long e()
  {
    return this.d;
  }

  public int f()
  {
    return q.a(this);
  }

  public long g()
  {
    return this.k;
  }

  public String getContactName()
  {
    return this.l;
  }

  public String getNumber()
  {
    return this.m;
  }

  public String getViberName()
  {
    return this.h;
  }

  public String h()
  {
    return this.n;
  }

  public long i()
  {
    return this.b;
  }

  public boolean isOwner()
  {
    return this.j == 0;
  }

  public long j()
  {
    return this.o;
  }

  public String toString()
  {
    return "MessageLikeLoaderEntity{id=" + this.b + ", messageToken=" + this.c + ", likeToken=" + this.d + ", participantMemberId='" + this.e + '\'' + ", likeDate=" + this.f + ", read=" + this.g + ", participantInfoId=" + this.i + ", participantType=" + this.j + ", contactName='" + this.l + '\'' + ", viberName='" + this.h + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.y
 * JD-Core Version:    0.6.2
 */