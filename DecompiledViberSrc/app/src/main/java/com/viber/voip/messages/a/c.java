package com.viber.voip.messages.a;

import com.viber.voip.model.entity.h;
import java.util.List;

public class c
{
  public static class a
  {
    public final int a;
    public final int b;
    public final int c;

    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }

    public String toString()
    {
      return "BanReplyReceivedEvent{seq=" + this.a + ", banType=" + this.b + ", status=" + this.c + '}';
    }
  }

  public static class b
  {
    public final long a;

    public b(long paramLong)
    {
      this.a = paramLong;
    }
  }

  public static class c
  {
    public final int a;
    public final int b;

    public c(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    public String toString()
    {
      return "CheckAllowsM2MChatEvent{seq=" + this.a + ", status=" + this.b + '}';
    }
  }

  public static class d
  {
    public final int a;
    public final int b;
    public final List<h> c;

    public d(int paramInt1, int paramInt2, List<h> paramList)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramList;
    }

    public String toString()
    {
      return "GetCommonCommunitiesEvent{seq=" + this.a + ", status=" + this.b + ", communities=" + this.c + '}';
    }
  }

  public static class e
  {
    public final long a;
    public final String b;
    public final long c;
    public final boolean d;
    public final String e;

    public e(String paramString1, long paramLong1, String paramString2, long paramLong2, boolean paramBoolean)
    {
      this.b = paramString1;
      this.c = paramLong1;
      this.e = paramString2;
      this.a = paramLong2;
      this.d = paramBoolean;
    }
  }

  public static class f
  {
    public final int a;

    public f(int paramInt)
    {
      this.a = paramInt;
    }

    public String toString()
    {
      return "GetMembersInvitationLinksEvent{status=" + this.a + '}';
    }
  }

  public static class g
  {
    public final long a;

    public g(long paramLong)
    {
      this.a = paramLong;
    }
  }

  public static class h
  {
    public final long a;
    public final h b;

    public h(long paramLong, h paramh)
    {
      this.a = paramLong;
      this.b = paramh;
    }
  }

  public static class i
  {
    public final int a;
    public final long b;
    public final int c;

    public i(int paramInt1, long paramLong, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramLong;
      this.c = paramInt2;
    }

    public String toString()
    {
      return "SentMessageReceivedEvent{seq=" + this.a + ", token=" + this.b + ", messageId=" + this.c + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.a.c
 * JD-Core Version:    0.6.2
 */