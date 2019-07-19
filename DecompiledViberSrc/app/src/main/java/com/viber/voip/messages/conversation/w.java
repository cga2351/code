package com.viber.voip.messages.conversation;

import android.database.Cursor;
import com.viber.voip.messages.adapters.p;
import com.viber.voip.model.g;

public class w
  implements p, g
{
  public static final String[] a = { "messages_likes.like_token", "messages_likes.date", "participants_info._id", "participants_info.participant_type", "participants_info.contact_id", "participants_info.contact_name", "participants_info.viber_name", "participants_info.member_id", "participants_info.number", "participants_info.viber_image", "participants_info.native_photo_id", "participants.group_role" };
  private long b;
  private long c;
  private int d;
  private long e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private long k;
  private int l;
  private long m;

  public w(Cursor paramCursor)
  {
    this.b = paramCursor.getLong(0);
    this.m = paramCursor.getLong(1);
    this.c = paramCursor.getLong(2);
    this.d = paramCursor.getInt(3);
    this.e = paramCursor.getLong(4);
    this.f = paramCursor.getString(5);
    this.g = paramCursor.getString(6);
    this.h = paramCursor.getString(7);
    this.i = paramCursor.getString(8);
    this.j = paramCursor.getString(9);
    this.k = paramCursor.getLong(10);
    this.l = paramCursor.getInt(11);
  }

  public long a()
  {
    return this.e;
  }

  public void a(long paramLong)
  {
    this.m = paramLong;
  }

  public int b()
  {
    return 0;
  }

  public int c()
  {
    return this.d;
  }

  public long d()
  {
    return this.c;
  }

  public long e()
  {
    return this.b;
  }

  public int f()
  {
    return this.l;
  }

  public String g()
  {
    return this.h;
  }

  public String getContactName()
  {
    return this.f;
  }

  public String getNumber()
  {
    return this.i;
  }

  public String getViberName()
  {
    return this.g;
  }

  public long h()
  {
    return this.m;
  }

  public long i()
  {
    return 0L;
  }

  public boolean isOwner()
  {
    return this.d == 0;
  }

  public String j()
  {
    return this.j;
  }

  public long k()
  {
    return this.k;
  }

  public String toString()
  {
    return "MessageInfoEntity{likeToken=" + this.b + ", participantInfoId=" + this.c + ", participantType=" + this.d + ", contactId=" + this.e + ", contactName='" + this.f + '\'' + ", viberName='" + this.g + '\'' + ", memberId='" + this.h + '\'' + ", number='" + this.i + '\'' + ", viberPhoto='" + this.j + '\'' + ", nativePhotoId=" + this.k + ", groupRole=" + this.l + ", date=" + this.m + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.w
 * JD-Core Version:    0.6.2
 */