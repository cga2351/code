package com.e.a.c;

import com.e.a.d.c;
import e.a.b.d;
import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

final class e
{
  static g a(d paramd)
    throws ParseException
  {
    return g.a(com.e.a.d.e.b(paramd, "kty"));
  }

  static h b(d paramd)
    throws ParseException
  {
    if (paramd.containsKey("use"))
      return h.a(com.e.a.d.e.b(paramd, "use"));
    return null;
  }

  static Set<f> c(d paramd)
    throws ParseException
  {
    if (paramd.containsKey("key_ops"))
      return f.a(com.e.a.d.e.f(paramd, "key_ops"));
    return null;
  }

  static com.e.a.a d(d paramd)
    throws ParseException
  {
    if (paramd.containsKey("alg"))
      return new com.e.a.a(com.e.a.d.e.b(paramd, "alg"));
    return null;
  }

  static String e(d paramd)
    throws ParseException
  {
    if (paramd.containsKey("kid"))
      return com.e.a.d.e.b(paramd, "kid");
    return null;
  }

  static URI f(d paramd)
    throws ParseException
  {
    if (paramd.containsKey("x5u"))
      return com.e.a.d.e.c(paramd, "x5u");
    return null;
  }

  static c g(d paramd)
    throws ParseException
  {
    if (paramd.containsKey("x5t"))
      return new c(com.e.a.d.e.b(paramd, "x5t"));
    return null;
  }

  static c h(d paramd)
    throws ParseException
  {
    if (paramd.containsKey("x5t#S256"))
      return new c(com.e.a.d.e.b(paramd, "x5t#S256"));
    return null;
  }

  static List<com.e.a.d.a> i(d paramd)
    throws ParseException
  {
    if (paramd.containsKey("x5c"))
      return com.e.a.d.g.a(com.e.a.d.e.d(paramd, "x5c"));
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.e
 * JD-Core Version:    0.6.2
 */