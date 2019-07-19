package com.viber.voip.block.a;

import com.viber.jni.block.BlockControllerDelegate.BlockDelegate;
import com.viber.voip.block.a.b;
import com.viber.voip.block.a.c;
import com.viber.voip.block.b;
import com.viber.voip.block.k;
import com.viber.voip.block.k.b;
import com.viber.voip.block.k.c;
import com.viber.voip.block.k.d;

public class a
  implements BlockControllerDelegate.BlockDelegate
{
  private com.viber.voip.block.a a = new com.viber.voip.block.a();

  public void onBlockGroupInviteReply(int paramInt1, int paramInt2)
  {
    final a.b localb;
    if (paramInt2 == 0)
    {
      localb = this.a.a(paramInt1);
      if ((localb instanceof a.c))
      {
        if (!localb.c)
          break label48;
        b.a().b().a(new k.c()
        {
          public void a(k.b paramAnonymousb)
          {
            if ((paramAnonymousb instanceof k.d))
            {
              a.c localc = (a.c)localb;
              ((k.d)paramAnonymousb).a(localc.a, localc.b, localc.d);
            }
          }
        });
      }
    }
    return;
    label48: b.a().b().a(new k.c()
    {
      public void a(k.b paramAnonymousb)
      {
        if ((paramAnonymousb instanceof k.d))
        {
          a.c localc = (a.c)localb;
          ((k.d)paramAnonymousb).b(localc.a, localc.b, localc.d);
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.a.a
 * JD-Core Version:    0.6.2
 */