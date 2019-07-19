package com.viber.voip.registration;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.StringWriter;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ar
{
  private static final Logger a = ViberEnv.getLogger();

  public <T> T a(Class<? extends T> paramClass, ResponseBody paramResponseBody)
    throws Exception
  {
    return new Persister().read(paramClass, paramResponseBody.string(), false);
  }

  public String a(Object paramObject)
    throws Exception
  {
    Persister localPersister = new Persister();
    StringWriter localStringWriter = new StringWriter();
    localPersister.write(paramObject, localStringWriter);
    String str = localStringWriter.toString();
    localStringWriter.close();
    return str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ar
 * JD-Core Version:    0.6.2
 */