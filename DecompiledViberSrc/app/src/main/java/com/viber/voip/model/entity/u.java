package com.viber.voip.model.entity;

import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.util.da;
import com.viber.voip.util.upload.ObjectId;

public class u
{
  public static final String[] a = { "msg_date", "send_type", "body", "unread", "location_lat", "location_lng", "extra_upload_id", "extra_download_id", "extra_mime", "extra_duration", "flag", "group_id", "user_id", "extra_bucket_name", "seq", "token", "description", "msg_info" };
  public long b;
  public String c;
  public int d;
  public String e;
  public long f;
  public int g;
  public long h;
  public String i;
  public String j;
  public String k;
  public ObjectId l;
  public String m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public long s;
  private MsgInfo t;

  public void a(Cursor paramCursor)
  {
    this.b = paramCursor.getLong(0);
    this.o = paramCursor.getInt(1);
    this.e = paramCursor.getString(2);
    this.p = paramCursor.getInt(3);
    this.q = paramCursor.getInt(4);
    this.r = paramCursor.getInt(5);
    this.l = ObjectId.fromLong(paramCursor.getLong(6));
    this.j = paramCursor.getString(7);
    this.d = paramCursor.getInt(8);
    this.f = paramCursor.getLong(9);
    this.n = paramCursor.getInt(10);
    this.s = paramCursor.getLong(11);
    this.c = paramCursor.getString(12);
    this.k = paramCursor.getString(13);
    this.g = paramCursor.getInt(14);
    this.h = paramCursor.getLong(15);
    this.i = paramCursor.getString(16);
    this.m = paramCursor.getString(17);
    this.t = null;
  }

  public boolean a()
  {
    return this.p == 0;
  }

  public Uri b()
  {
    if (!da.a(this.e))
      return Uri.parse(this.e);
    return null;
  }

  public MsgInfo c()
  {
    if (this.t == null)
      this.t = ((MsgInfo)e.a().a().a(this.m));
    return this.t;
  }

  public boolean d()
  {
    return this.o == 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.u
 * JD-Core Version:    0.6.2
 */