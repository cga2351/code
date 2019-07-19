package com.viber.voip.backup.c;

public abstract class h extends g
{
  protected abstract void a(d paramd);

  protected abstract void a(f paramf);

  protected final void c(d paramd)
  {
    if ((paramd instanceof f))
    {
      a((f)paramd);
      return;
    }
    a(paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.c.h
 * JD-Core Version:    0.6.2
 */