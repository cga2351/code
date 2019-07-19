package com.viber.voip.b.c.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.b.c.a.a.g;
import com.viber.voip.util.af;
import com.viber.voip.util.dk;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.List;

public class j extends c
{
  private static final Logger d = ViberEnv.getLogger();

  public j(Context paramContext)
  {
    super(paramContext);
  }

  private void a(Uri paramUri)
  {
    if (dk.b(paramUri));
    for (File localFile = new File(paramUri.getPath()); ; localFile = dv.B.b(this.c, paramUri.toString(), false))
    {
      if ((localFile != null) && (localFile.exists()))
        this.b.a(localFile.getAbsolutePath());
      return;
    }
  }

  public void a()
  {
    this.b = new f(new g(new a()));
  }

  protected void b()
  {
    if (this.a);
    while (true)
    {
      return;
      b localb = d.a(this.c);
      try
      {
        Cursor localCursor2 = localb.a("SELECT icon_id FROM conversations WHERE icon_id IS NOT NULL AND icon_id != ''", null);
        localCursor1 = localCursor2;
        try
        {
          if (localCursor1.moveToNext())
            a(Uri.parse(localCursor1.getString(0)));
        }
        finally
        {
          af.a(localCursor1);
        }
        while (true)
        {
          try
          {
            localCursor1 = localb.a("SELECT body FROM messages WHERE extra_mime = 1000 AND conversation_type IN ('1', '2') AND body LIKE 'group_icon_changed_with_icon%'", null);
            if (!localCursor1.moveToNext())
              break;
            String[] arrayOfString = localCursor1.getString(0).split("/");
            if (arrayOfString.length == 3)
            {
              str = com.viber.voip.messages.j.j(arrayOfString[2]);
              if (TextUtils.isEmpty(str))
                continue;
              a(Uri.parse(str));
              continue;
            }
          }
          finally
          {
            af.a(localCursor1);
          }
          String str = null;
        }
        af.a(localCursor1);
        List localList = this.b.a(dv.B.a(this.c));
        if (this.a)
          continue;
        this.b.a(localList);
        return;
      }
      finally
      {
        while (true)
          Cursor localCursor1 = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.j
 * JD-Core Version:    0.6.2
 */