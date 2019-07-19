package com.android.camera.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import com.android.camera.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class b
  implements d
{
  private static final Logger g = ViberEnv.getLogger();
  private static final Pattern i = Pattern.compile("(.*)/\\d+");
  protected ContentResolver a;
  protected int b;
  protected Uri c;
  protected Cursor d;
  protected String e;
  protected boolean f = false;
  private final h<Integer, a> h = new h(512);

  public b(ContentResolver paramContentResolver, Uri paramUri, int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramUri;
    this.e = paramString;
    this.a = paramContentResolver;
    this.d = d();
    if (this.d == null)
      g.d("createCursor returns null.", new Object[0]);
    this.h.a();
  }

  private static String b(Uri paramUri)
  {
    String str = paramUri.getPath();
    Matcher localMatcher = i.matcher(str);
    if (localMatcher.matches())
      str = localMatcher.group(1);
    return str;
  }

  private boolean c(Uri paramUri)
  {
    Uri localUri = this.c;
    return (e.a(localUri.getScheme(), paramUri.getScheme())) && (e.a(localUri.getHost(), paramUri.getHost())) && (e.a(localUri.getAuthority(), paramUri.getAuthority())) && (e.a(localUri.getPath(), b(paramUri)));
  }

  private Cursor g()
  {
    try
    {
      if (this.d == null)
        return null;
      if (this.f)
      {
        this.d.requery();
        this.f = false;
      }
      Cursor localCursor = this.d;
      return localCursor;
    }
    finally
    {
    }
  }

  public Uri a(long paramLong)
  {
    try
    {
      if (ContentUris.parseId(this.c) != paramLong)
        g.d("id mismatch", new Object[0]);
      Uri localUri = this.c;
      return localUri;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return ContentUris.withAppendedId(this.c, paramLong);
  }

  protected abstract a a(Cursor paramCursor);

  public c a(int paramInt)
  {
    a locala1 = (a)this.h.a(Integer.valueOf(paramInt));
    Cursor localCursor;
    if (locala1 == null)
    {
      localCursor = g();
      if (localCursor == null)
        locala1 = null;
    }
    else
    {
      return locala1;
    }
    while (true)
    {
      try
      {
        if (localCursor.moveToPosition(paramInt))
        {
          locala2 = a(localCursor);
          this.h.a(Integer.valueOf(paramInt), locala2);
          return locala2;
        }
      }
      finally
      {
      }
      a locala2 = null;
    }
  }

  public c a(Uri paramUri)
  {
    int j = 0;
    if (!c(paramUri))
      return null;
    while (true)
    {
      try
      {
        long l = ContentUris.parseId(paramUri);
        Cursor localCursor = g();
        if (localCursor == null)
          break;
        try
        {
          localCursor.moveToPosition(-1);
          if (!localCursor.moveToNext())
            break label148;
          if (b(localCursor) == l)
          {
            a locala = (a)this.h.a(Integer.valueOf(j));
            if (locala == null)
            {
              locala = a(localCursor);
              this.h.a(Integer.valueOf(j), locala);
            }
            return locala;
          }
        }
        finally
        {
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        g.d("fail to get id in: ?", new Object[] { paramUri, localNumberFormatException });
        return null;
      }
      j++;
    }
    label148: return null;
  }

  public void a()
  {
    try
    {
      e();
      this.a = null;
      if (this.d != null)
      {
        this.d.close();
        this.d = null;
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
        g.a(localIllegalStateException, "Caught exception while deactivating cursor.", new Object[0]);
    }
  }

  public int b()
  {
    Cursor localCursor = g();
    if (localCursor == null)
      return 0;
    try
    {
      int j = localCursor.getCount();
      return j;
    }
    finally
    {
    }
  }

  protected abstract long b(Cursor paramCursor);

  public boolean c()
  {
    return b() == 0;
  }

  protected abstract Cursor d();

  protected void e()
  {
    if (this.d == null)
      return;
    this.d.deactivate();
    this.f = true;
  }

  protected String f()
  {
    if (this.b == 1);
    for (String str = " ASC"; ; str = " DESC")
      return "case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end" + str + ", _id" + str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.a.b
 * JD-Core Version:    0.6.2
 */