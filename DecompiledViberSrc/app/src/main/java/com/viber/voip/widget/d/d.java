package com.viber.voip.widget.d;

import android.content.Context;
import android.net.Uri;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.ptt.PttFactory;
import com.viber.voip.util.bw;
import com.viber.voip.widget.d.a.b;

public class d
{
  private static final e a = ViberEnv.getLogger();
  private Context b;
  private Uri c;

  public a a()
  {
    if (PttFactory.isNewPtt(this.c.getPath()))
    {
      b localb = new b(this.b);
      int[] arrayOfInt = bw.a(this.b, this.c);
      localb.a(arrayOfInt[0], arrayOfInt[1]);
      return localb;
    }
    return new c(this.b);
  }

  public d a(Context paramContext)
  {
    this.b = paramContext;
    return this;
  }

  public d a(Uri paramUri)
  {
    this.c = paramUri;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.d.d
 * JD-Core Version:    0.6.2
 */