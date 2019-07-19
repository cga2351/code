package com.viber.voip.notif.h;

import android.database.Cursor;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.l;
import com.viber.voip.util.av;
import com.viber.voip.util.da;

public class d
{
  public static final String[] a = { "conversations._id", "conversations.group_id", "public_accounts._id", "conversations.name", "conversations.group_role", "conversations.icon_id", "public_accounts.server_message_id", "public_accounts.last_media_type", "public_accounts.last_msg_text", "public_accounts.sender_phone", "public_accounts.sender_name", "messages.extra_mime", "messages.body", "messages.msg_info", "messages.user_id", "messages.message_global_id", "messages.extra_flags", "messages.flag", "(CASE WHEN ((conversations.smart_notification=1 AND conversations.smart_event_date>0 AND conversations.smart_event_date>?)) THEN 1 ELSE 0 END)", "MAX(public_accounts.server_message_id , public_accounts.local_message_id) AS unreadMsgId", "(CASE WHEN (conversations.conversation_type = 5 OR conversations.conversation_type = 2) THEN ( MAX( public_accounts.local_message_id, public_accounts.server_message_id ) - public_accounts.last_read_message_id ) ELSE (IFNULL((SELECT SUM ([messages].[unread]) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread>0 AND messages.extra_mime <> 1007 AND [messages].[extra_flags] & 4194304 = 0 AND messages.extra_mime <> 1008 AND messages.extra_mime <> 1002 AND messages.deleted=0 ), 0)) END) AS unreadMsgCount" };
  private final long b;
  private final long c;
  private final long d;
  private final String e;
  private final String f;
  private final int g;
  private final int h;
  private final int i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final MsgInfo n;
  private final int o;
  private final String p;
  private final int q;
  private final long r;
  private final long s;
  private final int t;
  private final int u;
  private final boolean v;

  public d(Cursor paramCursor, a<MsgInfo> parama)
  {
    this.b = paramCursor.getLong(0);
    this.c = paramCursor.getLong(1);
    this.d = paramCursor.getLong(2);
    this.e = paramCursor.getString(3);
    this.g = paramCursor.getInt(4);
    this.f = paramCursor.getString(5);
    this.h = paramCursor.getInt(6);
    this.i = a(paramCursor.getString(7));
    this.j = paramCursor.getString(8);
    this.k = paramCursor.getString(9);
    this.l = paramCursor.getString(10);
    this.o = paramCursor.getInt(11);
    this.m = paramCursor.getString(12);
    this.n = ((MsgInfo)parama.a(paramCursor.getString(13)));
    this.p = paramCursor.getString(14);
    this.q = paramCursor.getInt(15);
    this.r = paramCursor.getLong(16);
    this.s = paramCursor.getLong(17);
    if (paramCursor.getInt(18) > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.v = bool;
      this.t = paramCursor.getInt(19);
      this.u = paramCursor.getInt(20);
      return;
    }
  }

  private static int a(String paramString)
  {
    try
    {
      int i1 = Integer.valueOf(paramString).intValue();
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0;
  }

  private boolean z()
  {
    return r() <= q();
  }

  public long a()
  {
    return this.b;
  }

  public long b()
  {
    return this.c;
  }

  public long c()
  {
    return this.d;
  }

  public String d()
  {
    return this.e;
  }

  public String e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    d locald;
    boolean bool7;
    do
    {
      boolean bool5;
      boolean bool6;
      do
      {
        int i3;
        int i4;
        do
        {
          int i1;
          int i2;
          do
          {
            boolean bool4;
            do
            {
              boolean bool3;
              do
              {
                Class localClass1;
                Class localClass2;
                do
                {
                  do
                  {
                    return bool2;
                    bool2 = false;
                  }
                  while (paramObject == null);
                  localClass1 = getClass();
                  localClass2 = paramObject.getClass();
                  bool2 = false;
                }
                while (localClass1 != localClass2);
                locald = (d)paramObject;
                bool3 = this.b < locald.b;
                bool2 = false;
              }
              while (bool3);
              bool4 = this.d < locald.d;
              bool2 = false;
            }
            while (bool4);
            i1 = this.t;
            i2 = locald.t;
            bool2 = false;
          }
          while (i1 != i2);
          i3 = this.u;
          i4 = locald.u;
          bool2 = false;
        }
        while (i3 != i4);
        bool5 = this.v;
        bool6 = locald.v;
        bool2 = false;
      }
      while (bool5 != bool6);
      if (this.e == null)
        break;
      bool7 = this.e.equals(locald.e);
      bool2 = false;
    }
    while (!bool7);
    if (this.f != null)
      bool1 = this.f.equals(locald.f);
    while (true)
    {
      return bool1;
      if (locald.e == null)
        break;
      return false;
      if (locald.f != null)
        bool1 = false;
    }
  }

  public int f()
  {
    return this.u;
  }

  public int g()
  {
    return this.i;
  }

  public String h()
  {
    return this.j;
  }

  public int hashCode()
  {
    int i1 = 31 * (31 * (int)(this.b ^ this.b >>> 32) + (int)(this.d ^ this.d >>> 32));
    int i2;
    int i3;
    if (this.e != null)
    {
      i2 = this.e.hashCode();
      i3 = 31 * (i2 + i1);
      if (this.f == null)
        break label125;
    }
    label125: for (int i4 = this.f.hashCode(); ; i4 = 0)
    {
      int i5 = 31 * (31 * (31 * (i4 + i3) + this.t) + this.u);
      boolean bool = this.v;
      int i6 = 0;
      if (bool)
        i6 = 1;
      return i5 + i6;
      i2 = 0;
      break;
    }
  }

  public String i()
  {
    return this.k;
  }

  public String j()
  {
    return this.l;
  }

  public int k()
  {
    return this.g;
  }

  public int l()
  {
    return this.t;
  }

  public String m()
  {
    return this.m;
  }

  public MsgInfo n()
  {
    return this.n;
  }

  public int o()
  {
    return this.o;
  }

  public String p()
  {
    return this.p;
  }

  public int q()
  {
    return this.q;
  }

  public int r()
  {
    return this.h;
  }

  public long s()
  {
    return this.r;
  }

  public boolean t()
  {
    return this.v;
  }

  public String toString()
  {
    return "CommunityNotificationItem{mConversationId=" + this.b + ", mGroupId=" + this.c + ", mPublicAccountId=" + this.d + ", mCommunityName='" + this.e + '\'' + ", mCommunityIcon='" + this.f + '\'' + ", mCommunityRole=" + this.g + ", mCommunityGlobalId=" + this.h + ", mLastMsgType=" + this.i + ", mLastMsgText='" + this.j + '\'' + ", mLastMsgSender='" + this.k + '\'' + ", mLastMsgSenderName='" + this.l + '\'' + ", mLocalMsgBody='" + da.a(this.m, this.o) + '\'' + ", mLocalMsgInfo='" + this.n + '\'' + ", mLocalMsgType=" + l.c(this.o) + ", mLocalMsgMemberId='" + this.p + '\'' + ", mLocalMsgGlobalId=" + this.q + ", mLocalMsgExtraFlags=" + this.r + ", mUnreadMessageId=" + this.t + ", mUnreadMessagesCount=" + this.u + ", mSmart=" + this.v + '}';
  }

  public boolean u()
  {
    return (z()) && (1000 == o());
  }

  public boolean v()
  {
    return (z()) && (av.c(s(), 34));
  }

  public boolean w()
  {
    return (z()) && (av.c(s(), 32));
  }

  public boolean x()
  {
    return (z()) && (av.c(s(), 38));
  }

  public boolean y()
  {
    return (z()) && (av.a(this.s, 8L));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.d
 * JD-Core Version:    0.6.2
 */