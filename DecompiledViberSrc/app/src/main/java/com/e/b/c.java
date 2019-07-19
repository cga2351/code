package com.e.b;

import com.e.a.e;
import com.e.a.j;
import com.e.a.l;
import e.a.b.d;
import java.text.ParseException;

public class c extends j
  implements a
{
  public c(com.e.a.d.c paramc1, com.e.a.d.c paramc2, com.e.a.d.c paramc3)
    throws ParseException
  {
    super(paramc1, paramc2, paramc3);
  }

  public static c b(String paramString)
    throws ParseException
  {
    com.e.a.d.c[] arrayOfc = e.a(paramString);
    if (arrayOfc.length != 3)
      throw new ParseException("Unexpected number of Base64URL parts, must be three", 0);
    return new c(arrayOfc[0], arrayOfc[1], arrayOfc[2]);
  }

  public b g()
    throws ParseException
  {
    d locald = a().a();
    if (locald == null)
      throw new ParseException("Payload of JWS object is not a valid JSON object", 0);
    return b.a(locald);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.b.c
 * JD-Core Version:    0.6.2
 */