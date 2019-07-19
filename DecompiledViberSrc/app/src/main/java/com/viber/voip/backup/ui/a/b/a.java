package com.viber.voip.backup.ui.a.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Pair;
import com.viber.common.permission.b;
import com.viber.common.permission.c;
import com.viber.voip.permissions.e;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.dialogs.DialogCode;

public class a
{
  private final Activity a;
  private final c b;
  private final b c;
  private a d;

  public a(Activity paramActivity, Fragment paramFragment, c paramc)
  {
    this.a = paramActivity;
    this.b = paramc;
    this.c = a(paramFragment);
  }

  private b a(Fragment paramFragment)
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = m.a(79);
    return new e(paramFragment, arrayOfPair)
    {
      private int a(Object paramAnonymousObject)
      {
        if ((paramAnonymousObject instanceof Integer))
          return ((Integer)paramAnonymousObject).intValue();
        return -1;
      }

      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        super.onCustomDialogAction(paramAnonymousInt1, paramAnonymousString, paramAnonymousInt2);
        switch (paramAnonymousInt1)
        {
        default:
        case 79:
        }
        do
          return;
        while (((!DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)) && (!DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString))) || (paramAnonymousInt2 != -2) || (a.a(a.this) == null));
        a.a(a.this).b(-1);
      }

      public void onPermissionsDenied(int paramAnonymousInt, boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2, Object paramAnonymousObject)
      {
        super.onPermissionsDenied(paramAnonymousInt, paramAnonymousBoolean, paramAnonymousArrayOfString1, paramAnonymousArrayOfString2, paramAnonymousObject);
        switch (paramAnonymousInt)
        {
        default:
        case 79:
        }
        do
          return;
        while (a.a(a.this) == null);
        a.a(a.this).b(a(paramAnonymousObject));
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 79:
        }
        do
          return;
        while (a.a(a.this) == null);
        a.a(a.this).a(a(paramAnonymousObject));
      }
    };
  }

  public void a(int paramInt)
  {
    this.b.a(this.a, 79, n.j, Integer.valueOf(paramInt));
  }

  public void a(a parama)
  {
    this.d = parama;
    this.b.a(this.c);
  }

  public boolean a()
  {
    return this.b.a(n.j);
  }

  public void b()
  {
    this.b.b(this.c);
    this.d = null;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void b(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.b.a
 * JD-Core Version:    0.6.2
 */