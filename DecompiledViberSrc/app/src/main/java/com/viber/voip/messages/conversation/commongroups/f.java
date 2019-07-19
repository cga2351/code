package com.viber.voip.messages.conversation.commongroups;

import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.util.da;
import java.util.Arrays;

public class f
{
  public static final String[] a = { "conversations._id", "conversations.group_id", "conversations.name", "conversations.icon_id", "conversations.participant_id_1", "conversations.participant_id_2", "conversations.participant_id_3", "conversations.participant_id_4", "IFNULL((SELECT SUM (messages.unread) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread > 0 AND messages.extra_mime <> 1007 AND messages.extra_flags & 4194304 = 0 AND messages.extra_mime <> 1008 AND messages.deleted=0), 0)" };
  private static final int[] b = { 4, 5, 6, 7 };
  private final long c;
  private final long d;
  private final String e;
  private final Uri f;
  private final long[] g = new long[4];
  private final int h;

  public f(Cursor paramCursor)
  {
    this.c = paramCursor.getLong(0);
    this.d = paramCursor.getLong(1);
    this.e = paramCursor.getString(2);
    String str = paramCursor.getString(3);
    if (da.a(str));
    for (Uri localUri = null; ; localUri = Uri.parse(str))
    {
      this.f = localUri;
      a(paramCursor);
      this.h = paramCursor.getInt(8);
      return;
    }
  }

  private void a(Cursor paramCursor)
  {
    int i = 0;
    int j = b.length;
    while (i < j)
    {
      this.g[i] = paramCursor.getLong(b[i]);
      i++;
    }
  }

  public long a()
  {
    return this.c;
  }

  public long b()
  {
    return this.d;
  }

  public String c()
  {
    return this.e;
  }

  public Uri d()
  {
    return this.f;
  }

  public long[] e()
  {
    return this.g;
  }

  public int f()
  {
    return this.h;
  }

  public String toString()
  {
    return "CommonGroupsLoaderEntity{mConversationId=" + this.c + ", mGroupId=" + this.d + ", mGroupName='" + this.e + '\'' + ", mIconUri=" + this.f + ", mParticipantInfoIds=" + Arrays.toString(this.g) + ", mUnreadEventsCount=" + this.h + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.commongroups.f
 * JD-Core Version:    0.6.2
 */