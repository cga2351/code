package com.viber.voip.messages.conversation.chatinfo.d;

public class n
  implements d
{
  private final com.viber.voip.messages.conversation.chatinfo.presentation.a.d a;
  private final int b;
  private final String c;
  private final boolean d;

  private n(com.viber.voip.messages.conversation.chatinfo.presentation.a.d paramd, int paramInt, String paramString, boolean paramBoolean)
  {
    this.a = paramd;
    this.b = paramInt;
    this.c = paramString;
    this.d = paramBoolean;
  }

  public static n a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, true);
  }

  public static n a(int paramInt, String paramString, boolean paramBoolean)
  {
    return new n(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.d, paramInt, paramString, paramBoolean);
  }

  public static n b(int paramInt, String paramString)
  {
    return new n(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.e, paramInt, paramString, true);
  }

  public static n c(int paramInt, String paramString)
  {
    return new n(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.f, paramInt, paramString, true);
  }

  public static n d(int paramInt, String paramString)
  {
    return new n(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.g, paramInt, paramString, true);
  }

  public String a()
  {
    return this.c;
  }

  public boolean b()
  {
    return this.d;
  }

  public com.viber.voip.messages.conversation.chatinfo.presentation.a.d d()
  {
    return this.a;
  }

  public int e()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.d.n
 * JD-Core Version:    0.6.2
 */