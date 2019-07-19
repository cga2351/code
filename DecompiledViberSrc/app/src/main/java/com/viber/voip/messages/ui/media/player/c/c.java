package com.viber.voip.messages.ui.media.player.c;

class c
{
  private boolean a;
  private boolean b;
  private boolean c;

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public boolean a()
  {
    return this.a;
  }

  public void b()
  {
    if ((this.a) && (this.b))
      this.c = true;
    this.a = false;
  }

  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public boolean c()
  {
    return this.c;
  }

  public void d()
  {
    if (this.c)
    {
      this.b = false;
      this.c = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.c.c
 * JD-Core Version:    0.6.2
 */