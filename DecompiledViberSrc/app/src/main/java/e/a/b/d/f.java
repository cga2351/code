package e.a.b.d;

import java.io.IOException;

public abstract class f<T>
{
  private static String a = "Invalid or non Implemented status";
  public final e q;

  public f(e parame)
  {
    this.q = parame;
  }

  public f<?> a(String paramString)
    throws e.a.b.b.e, IOException
  {
    throw new RuntimeException(a + " startObject(String key) in " + getClass() + " key=" + paramString);
  }

  public Object a()
  {
    throw new RuntimeException(a + " createArray() in " + getClass());
  }

  public T a(Object paramObject)
  {
    return paramObject;
  }

  public void a(Object paramObject1, Object paramObject2)
    throws e.a.b.b.e, IOException
  {
    throw new RuntimeException(a + " addValue(Object current, Object value) in " + getClass());
  }

  public void a(Object paramObject1, String paramString, Object paramObject2)
    throws e.a.b.b.e, IOException
  {
    throw new RuntimeException(a + " setValue in " + getClass() + " key=" + paramString);
  }

  public f<?> b(String paramString)
    throws e.a.b.b.e, IOException
  {
    throw new RuntimeException(a + " startArray in " + getClass() + " key=" + paramString);
  }

  public Object b()
  {
    throw new RuntimeException(a + " createObject() in " + getClass());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.d.f
 * JD-Core Version:    0.6.2
 */