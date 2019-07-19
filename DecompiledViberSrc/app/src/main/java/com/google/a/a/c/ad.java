package com.google.a.a.c;

import com.google.a.a.f.ag;
import com.google.a.a.f.i;
import com.google.a.a.f.m;
import com.google.a.a.f.z;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ad extends a
{
  private Object a;

  public ad(Object paramObject)
  {
    super(ae.a);
    a(paramObject);
  }

  private static boolean a(boolean paramBoolean, Writer paramWriter, String paramString, Object paramObject)
    throws IOException
  {
    if ((paramObject == null) || (i.a(paramObject)))
      return paramBoolean;
    if (paramBoolean)
    {
      paramBoolean = false;
      label19: paramWriter.write(paramString);
      if (!(paramObject instanceof Enum))
        break label81;
    }
    label81: for (String str1 = m.a((Enum)paramObject).b(); ; str1 = paramObject.toString())
    {
      String str2 = com.google.a.a.f.a.a.a(str1);
      if (str2.length() == 0)
        break;
      paramWriter.write("=");
      paramWriter.write(str2);
      return paramBoolean;
      paramWriter.write("&");
      break label19;
    }
  }

  public ad a(Object paramObject)
  {
    this.a = z.a(paramObject);
    return this;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(paramOutputStream, c()));
    Iterator localIterator1 = i.b(this.a).entrySet().iterator();
    boolean bool1 = true;
    Object localObject;
    String str;
    boolean bool2;
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      localObject = localEntry.getValue();
      if (localObject == null)
        break label186;
      str = com.google.a.a.f.a.a.a((String)localEntry.getKey());
      Class localClass = localObject.getClass();
      if (((localObject instanceof Iterable)) || (localClass.isArray()))
      {
        Iterator localIterator2 = ag.a(localObject).iterator();
        while (localIterator2.hasNext())
          bool1 = a(bool1, localBufferedWriter, str, localIterator2.next());
        bool2 = bool1;
      }
    }
    while (true)
    {
      bool1 = bool2;
      break;
      bool2 = a(bool1, localBufferedWriter, str, localObject);
      continue;
      localBufferedWriter.flush();
      return;
      label186: bool2 = bool1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.ad
 * JD-Core Version:    0.6.2
 */