package com.viber.voip.gallery.preview;

import android.net.Uri;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class a
  implements Runnable
{
  private final List<Uri> a;

  public a(List<Uri> paramList)
  {
    this.a = paramList;
  }

  public a(Uri[] paramArrayOfUri)
  {
    this.a = Arrays.asList(paramArrayOfUri);
  }

  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      if (com.viber.voip.gallery.c.a.a(localUri))
        com.viber.voip.gallery.c.a.c(localUri);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.preview.a
 * JD-Core Version:    0.6.2
 */