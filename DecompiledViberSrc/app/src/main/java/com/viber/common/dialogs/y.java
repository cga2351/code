package com.viber.common.dialogs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public final class y
{
  private static volatile Context a;
  private static volatile a b;

  public static Context a()
  {
    return a;
  }

  public static void a(Context paramContext)
  {
    a = paramContext;
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    if (b())
      paramContext.startActivity(paramIntent);
    label48: label97: label104: label108: 
    while (true)
    {
      return;
      Bundle localBundle = paramIntent.getBundleExtra("all_isolated_extras");
      a locala;
      String str;
      if (localBundle != null)
      {
        locala = (a)localBundle.getSerializable("dialog_instance");
        if (locala == null)
          break label97;
        str = locala.f().code();
        x localx = w.a();
        if (localx != null)
          localx.a(str);
        if (locala == null)
          break label104;
      }
      for (m.a locala1 = locala.e(); ; locala1 = null)
      {
        if (locala1 == null)
          break label108;
        locala1.onDialogDisplayingRejected(paramContext, m.f.a.a);
        return;
        locala = null;
        break;
        str = "-unknown-";
        break label48;
      }
    }
  }

  public static void a(Intent paramIntent)
  {
    Context localContext = a();
    if (localContext != null)
      a(localContext, paramIntent);
  }

  public static void a(a parama)
  {
    b = parama;
  }

  public static boolean b()
  {
    a locala = b;
    return (locala == null) || (locala.a());
  }

  static void c()
  {
    if (a == null);
  }

  public static abstract interface a
  {
    public abstract boolean a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.y
 * JD-Core Version:    0.6.2
 */