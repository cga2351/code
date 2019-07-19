package com.viber.voip.messages.a;

import com.viber.voip.messages.conversation.ui.ck;
import java.util.Collection;

public class d
{
  public static class a
  {
  }

  public static class b
  {
    public final long a;
    public final boolean b;
    public final boolean c;

    public b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramLong;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
    }
  }

  public static class c
  {
    public final long a;
    public final Collection<ck> b;
    public final boolean c;

    public c(long paramLong, Collection<ck> paramCollection, boolean paramBoolean)
    {
      this.a = paramLong;
      this.b = paramCollection;
      this.c = paramBoolean;
    }

    public String toString()
    {
      return "GroupUserIsTyping{groupId=" + this.a + ", userDeviceInfos=" + this.b + ", isTyping=" + this.c + '}';
    }
  }

  public static class d
  {
    public final int a;

    public d(int paramInt)
    {
      this.a = paramInt;
    }

    public String toString()
    {
      return "SuperPropertyConversationsSizeChangedEvent{mConversationType=" + this.a + "";
    }
  }

  public static class e
  {
    public final ck a;
    public final int b;
    public final boolean c;

    public e(ck paramck, int paramInt, boolean paramBoolean)
    {
      this.a = paramck;
      this.b = paramInt;
      this.c = paramBoolean;
    }

    public String toString()
    {
      return "UserIsTyping{info=" + this.a + ", isTyping=" + this.c + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.a.d
 * JD-Core Version:    0.6.2
 */