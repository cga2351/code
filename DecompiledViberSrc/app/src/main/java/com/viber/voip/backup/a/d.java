package com.viber.voip.backup.a;

import android.accounts.Account;
import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.ax;
import com.viber.voip.util.n;

public class d<COMMON_DATA>
  implements b<COMMON_DATA>
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final f<COMMON_DATA> c;
  private final com.viber.voip.k.a d;

  public d(Context paramContext, f<COMMON_DATA> paramf, com.viber.voip.k.a parama)
  {
    this.b = paramContext;
    this.c = paramf;
    this.d = parama;
  }

  public a<COMMON_DATA> a()
  {
    int i = 0;
    Object localObject = this.c.b();
    if (localObject == null)
      return null;
    String str = this.d.a();
    if (str != null)
    {
      a.a[] arrayOfa2 = new a.a[1];
      arrayOfa2[0] = new a.a(str);
      return new a(localObject, arrayOfa2);
    }
    Account[] arrayOfAccount = ax.c(this.b);
    if (!n.a(arrayOfAccount))
    {
      a.a[] arrayOfa1 = new a.a[arrayOfAccount.length];
      while (i < arrayOfAccount.length)
      {
        arrayOfa1[i] = new a.a(arrayOfAccount[i].name);
        i++;
      }
      return new a(localObject, arrayOfa1);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.a.d
 * JD-Core Version:    0.6.2
 */