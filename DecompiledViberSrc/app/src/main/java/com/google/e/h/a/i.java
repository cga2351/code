package com.google.e.h.a;

import com.google.e.p;

public final class i
{
  private final boolean a;

  i(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void a(p[] paramArrayOfp)
  {
    if ((!this.a) || (paramArrayOfp == null) || (paramArrayOfp.length < 3))
      return;
    p localp = paramArrayOfp[0];
    paramArrayOfp[0] = paramArrayOfp[2];
    paramArrayOfp[2] = localp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.a.i
 * JD-Core Version:    0.6.2
 */