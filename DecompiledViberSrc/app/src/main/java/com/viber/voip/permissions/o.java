package com.viber.voip.permissions;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.common.d.i;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerReadyListener;
import com.viber.jni.controller.PhoneController;
import com.viber.provider.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backgrounds.m;
import com.viber.voip.settings.d.i;
import com.viber.voip.stickers.c.g;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.af;
import com.viber.voip.util.at;
import com.viber.voip.util.cm;
import com.viber.voip.util.dk;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import org.sqlite.database.SQLException;
import org.sqlite.database.sqlite.SQLiteStatement;

public class o
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String b = m.a + "\\w+?_(?:tail|port|land)\\.jpg";
  private final Context c;
  private final b d;
  private final SQLiteStatement e;
  private final SQLiteStatement f;
  private final SQLiteStatement g;
  private final SQLiteStatement h;

  public o(Context paramContext, b paramb)
  {
    this.c = paramContext;
    this.d = paramb;
    this.e = a("messages", "extra_uri", paramb);
    this.f = a("messages", "body", paramb);
    this.g = a("conversations", "background_portrait", paramb);
    this.h = a("conversations", "background_landscape", paramb);
  }

  private static SQLiteStatement a(String paramString1, String paramString2, b paramb)
  {
    return paramb.b(String.format(Locale.US, "UPDATE `%1$s` SET `%2$s` = replace(`%2$s`, ?, ?) WHERE `%2$s` LIKE ?", new Object[] { paramString1, paramString2 }));
  }

  private static void a(h paramh, File paramFile)
  {
    String str = paramh.d();
    if (TextUtils.isEmpty(str))
      return;
    paramh.a(Uri.fromFile(new File(paramFile, new File(Uri.parse(str).getPath()).getName())).toString());
  }

  private void a(final File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()))
      return;
    ViberApplication.getInstance().getEngine(false).addReadyListener(new PhoneControllerReadyListener()
    {
      public void ready(PhoneController paramAnonymousPhoneController)
      {
        int i = o.a(o.this).getApplicationInfo().uid;
        int j = paramAnonymousPhoneController.getFileOwnerUid(paramFile.getAbsolutePath());
        if (j != i)
          o.b().a(new Exception("File migration failed"), "Owner " + j + " was transferred during migration of the file = " + paramFile);
      }
    });
  }

  private void a(dv[] paramArrayOfdv)
  {
    int i = paramArrayOfdv.length;
    for (int j = 0; j < i; j++)
    {
      File localFile = paramArrayOfdv[j].b(this.c);
      if (localFile.exists())
      {
        i.a();
        at.h(localFile);
      }
    }
  }

  private boolean a(dv paramdv)
  {
    return a(paramdv.b(this.c), paramdv.a(this.c));
  }

  private boolean a(File paramFile1, File paramFile2)
  {
    if (paramFile1.exists())
    {
      i.a();
      return paramFile1.renameTo(paramFile2);
    }
    return false;
  }

  private boolean a(SQLiteStatement paramSQLiteStatement, Uri paramUri1, Uri paramUri2)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramUri1.toString();
    arrayOfString[1] = paramUri2.toString();
    arrayOfString[2] = (paramUri1.toString() + "%");
    paramSQLiteStatement.bindAllArgsAsStrings(arrayOfString);
    try
    {
      paramSQLiteStatement.executeUpdateDelete();
      return true;
    }
    catch (SQLException localSQLException)
    {
    }
    return false;
  }

  private void c()
  {
    at.f(at.a(".viber"));
  }

  private void d()
  {
    dv[] arrayOfdv = new dv[4];
    arrayOfdv[0] = dv.C;
    arrayOfdv[1] = dv.E;
    arrayOfdv[2] = dv.J;
    arrayOfdv[3] = dv.I;
    a(arrayOfdv);
    at.h(at.a("media/.cache"));
  }

  private void e()
  {
    if (a(dv.u))
    {
      i.a();
      Uri localUri1 = Uri.fromFile(dv.u.b(this.c));
      Uri localUri2 = Uri.fromFile(dv.u.a(this.c));
      a(this.e, localUri1, localUri2);
    }
  }

  private void f()
  {
    dv[] arrayOfdv = new dv[1];
    arrayOfdv[0] = dv.p;
    a(arrayOfdv);
  }

  private void g()
  {
    a(dv.w);
  }

  private void h()
  {
    if (a(dv.A))
    {
      i.a();
      Uri localUri1 = Uri.fromFile(dv.A.b(this.c));
      Uri localUri2 = Uri.fromFile(dv.A.a(this.c));
      a(this.e, localUri1, localUri2);
    }
  }

  private void i()
  {
    a(dv.G);
  }

  private void j()
  {
    File localFile1 = g.c();
    File localFile2 = g.a(this.c);
    a(localFile1, localFile2);
    a(localFile2);
  }

  private void k()
  {
    a(at.a("media/.backgrounds"), m.b(this.c));
  }

  private void l()
  {
    if (t())
    {
      i.a();
      q();
      Uri localUri1 = Uri.fromFile(dv.L.b(this.c));
      Uri localUri2 = Uri.fromFile(dv.L.a(this.c));
      Uri localUri3 = Uri.fromFile(dv.M.b(this.c));
      Uri localUri4 = Uri.fromFile(dv.M.a(this.c));
      a(this.g, localUri1, localUri2);
      a(this.h, localUri3, localUri4);
    }
  }

  private void m()
  {
    if (a(dv.q))
    {
      i.a();
      Uri localUri1 = Uri.fromFile(dv.q.b(this.c));
      Uri localUri2 = Uri.fromFile(dv.q.a(this.c));
      a(this.f, localUri1, localUri2);
    }
    n();
  }

  private void n()
  {
    try
    {
      i.a();
      Cursor localCursor2 = this.d.a("messages", new String[] { "body" }, "extra_mime = 1005 AND body LIKE 'http://viber-fake-uri.com%'", null, null, null, null);
      localCursor1 = localCursor2;
      try
      {
        while (localCursor1.moveToNext())
        {
          String str = localCursor1.getString(0);
          File localFile1 = dv.n.c(this.c, str, false);
          File localFile2 = dv.q.b(this.c, str, false);
          if ((localFile1 != null) && (localFile2 != null))
            localFile1.renameTo(localFile2);
        }
      }
      finally
      {
      }
      af.a(localCursor1);
      throw localObject1;
      af.a(localCursor1);
      return;
    }
    finally
    {
      while (true)
        Cursor localCursor1 = null;
    }
  }

  private void o()
  {
    p();
    dv[] arrayOfdv = new dv[1];
    arrayOfdv[0] = dv.s;
    a(arrayOfdv);
  }

  private void p()
  {
    UserData localUserData = UserManager.from(this.c).getUserData();
    File localFile1 = localUserData.getImageFile(this.c);
    if (localFile1 == null);
    File localFile3;
    do
    {
      return;
      File localFile2 = dv.s.a(this.c);
      localFile3 = new File(localFile2, localFile1.getName());
      at.c(localFile2);
    }
    while (!at.a(localFile1, localFile3));
    localUserData.setImage(Uri.fromFile(localFile3));
  }

  private void q()
  {
    a(d.i.d, dv.L.a(this.c));
    a(d.i.e, dv.M.a(this.c));
  }

  private void r()
  {
    try
    {
      i.a();
      Cursor localCursor2 = this.d.a("conversations", new String[] { "icon_id" }, "icon_id IS NOT NULL AND icon_id != ''", null, null, null, null);
      localCursor1 = localCursor2;
      while (true)
      {
        Uri localUri;
        boolean bool;
        try
        {
          if (!localCursor1.moveToNext())
            break;
          localUri = Uri.parse(localCursor1.getString(0));
          bool = dk.b(localUri);
          if (!bool)
            break label149;
          localFile1 = new File(localUri.getPath());
          localFile2 = new File(dv.B.a(this.c), localFile1.getName());
          if ((localFile1 == null) || (localFile2 == null))
            continue;
          if (localFile1.renameTo(localFile2))
            break label188;
          if (bool)
            continue;
          localFile1.delete();
          continue;
        }
        finally
        {
        }
        af.a(localCursor1);
        throw localObject1;
        label149: File localFile1 = dv.n.c(this.c, localUri.toString(), false);
        File localFile2 = dv.B.b(this.c, localUri.toString(), false);
        continue;
        label188: if (bool)
        {
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("icon_id", Uri.fromFile(localFile2).toString());
          b localb = this.d;
          String[] arrayOfString = new String[1];
          arrayOfString[0] = localUri.toString();
          localb.a("conversations", localContentValues, "icon_id = ?", arrayOfString);
        }
      }
      af.a(localCursor1);
      return;
    }
    finally
    {
      while (true)
        Cursor localCursor1 = null;
    }
  }

  private void s()
  {
    File localFile = dv.g.a(this.c);
    if (localFile.exists())
      at.h(localFile);
    a(dv.g.b(this.c), localFile);
  }

  private boolean t()
  {
    File localFile1 = dv.g.b(this.c);
    File localFile2 = dv.L.a(this.c);
    File[] arrayOfFile = localFile1.listFiles(new cm(b));
    if (arrayOfFile == null);
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = new ArrayList();
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        File localFile3 = arrayOfFile[j];
        if (!localFile3.renameTo(new File(localFile2, localFile3.getName())))
          localArrayList.add(localFile3);
      }
    }
    while ((!localArrayList.isEmpty()) && (arrayOfFile.length <= localArrayList.size()));
    return true;
  }

  public void a()
  {
    if (!c.a(this.c).a(n.m))
      return;
    c();
    d();
    e();
    f();
    g();
    h();
    i();
    j();
    m();
    k();
    l();
    o();
    r();
    s();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.o
 * JD-Core Version:    0.6.2
 */