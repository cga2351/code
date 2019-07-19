package com.viber.voip.market.a.a;

import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.List;

public class e extends d
{
  private static final Logger c = ViberEnv.getLogger();

  public e(List<? extends com.viber.voip.stickers.entity.d> paramList)
  {
    super(paramList);
  }

  public int a()
  {
    return super.a();
  }

  protected void a(a parama)
  {
    int i = -1 + this.a.size();
    if (i >= 0)
      if (!((a)this.a.get(i)).c());
    for (int j = i + 1; ; j = 0)
    {
      parama.a(j);
      this.a.add(j, parama);
      this.b.append(parama.e(), parama);
      return;
      i--;
      break;
    }
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    a locala = (a)this.a.remove(paramInt1);
    this.a.add(paramInt2, locala);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.a.a.e
 * JD-Core Version:    0.6.2
 */