package com.viber.voip.messages;

import java.util.HashMap;

public class c
{
  private static final HashMap<String, d> a = new HashMap();

  static
  {
    a("zip", d.a);
    a("zipx", d.a);
    a("7z", d.a);
    a("zz", d.a);
    a("rar", d.a);
    a("sit", d.a);
    a("sitx", d.a);
    a("ice", d.a);
    a("arj", d.a);
    a("arc", d.a);
    a("tgz", d.a);
    a("z", d.a);
    a("gz", d.a);
    a("tar", d.a);
    a("bz2", d.a);
    a("tbz2", d.a);
    a("tar", d.a);
    a("lzma", d.a);
    a("tlz", d.a);
    a("doc", d.b);
    a("docx", d.b);
    a("rtf", d.b);
    a("dot", d.b);
    a("dotx", d.b);
    a("odt", d.b);
    a("odf", d.b);
    a("fodt", d.b);
    a("txt", d.b);
    a("info", d.b);
    a("pdf", d.g);
    a("xps", d.g);
    a("eps", d.g);
    a("pdax", d.g);
    a("pdx", d.g);
    a("xls", d.c);
    a("xlsx", d.c);
    a("ods", d.c);
    a("fods", d.c);
    a("csv", d.c);
    a("xlsm", d.c);
    a("xltx", d.c);
    a("ppt", d.d);
    a("pptx", d.d);
    a("pps", d.d);
    a("ppsx", d.d);
    a("odp", d.d);
    a("fodp", d.d);
    a("mp3", d.e);
    a("aiff", d.e);
    a("wav", d.e);
    a("ogg", d.e);
    a("wma", d.e);
    a("m4a", d.e);
    a("psd", d.f);
    a("psb", d.f);
    a("avi", d.h);
    a("mp4", d.h);
    a("wmv", d.h);
    a("mov", d.h);
  }

  public static d a(String paramString)
  {
    d locald = (d)a.get(paramString.toLowerCase());
    if (locald == null)
      locald = d.i;
    return locald;
  }

  private static void a(String paramString, d paramd)
  {
    a.put(paramString, paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.c
 * JD-Core Version:    0.6.2
 */