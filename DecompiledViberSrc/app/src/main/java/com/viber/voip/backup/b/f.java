package com.viber.voip.backup.b;

import com.viber.voip.util.cj;
import java.io.IOException;

public class f
  implements e
{
  private cj a;

  public f(cj paramcj)
  {
    this.a = paramcj;
  }

  public void a()
    throws IOException
  {
    if (this.a.a() != 1)
      throw new IOException("Wi-Fi network is required");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.b.f
 * JD-Core Version:    0.6.2
 */