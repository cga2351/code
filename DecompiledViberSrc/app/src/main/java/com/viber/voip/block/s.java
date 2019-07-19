package com.viber.voip.block;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.a;

public class s extends d
{
  private k.d l = new k.d()
  {
    public void a(long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2)
    {
      s.this.l();
    }

    public void b(long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2)
    {
      s.this.l();
    }
  };

  public s(Context paramContext, LoaderManager paramLoaderManager, d.a parama)
  {
    super(21, c.a.a, paramContext, paramLoaderManager, parama, 0);
    a(r.a);
    d("data_2 DESC");
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(0);
    arrayOfString[1] = String.valueOf(1);
    arrayOfString[2] = String.valueOf(2);
    a("type=? AND (status=? OR status=?)");
    b(arrayOfString);
  }

  public r e(int paramInt)
  {
    if (b_(paramInt))
      return new r(this.f);
    return null;
  }

  public void p()
  {
    super.p();
    b.a().b().a(this.l);
  }

  public void q()
  {
    super.q();
    b.a().b().b(this.l);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.s
 * JD-Core Version:    0.6.2
 */