package android.arch.persistence.a;

public final class a
  implements e
{
  private final String a;
  private final Object[] b;

  public a(String paramString)
  {
    this(paramString, null);
  }

  public a(String paramString, Object[] paramArrayOfObject)
  {
    this.a = paramString;
    this.b = paramArrayOfObject;
  }

  private static void a(d paramd, int paramInt, Object paramObject)
  {
    if (paramObject == null)
    {
      paramd.a(paramInt);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramd.a(paramInt, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramd.a(paramInt, ((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramd.a(paramInt, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramd.a(paramInt, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramd.a(paramInt, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Short))
    {
      paramd.a(paramInt, ((Short)paramObject).shortValue());
      return;
    }
    if ((paramObject instanceof Byte))
    {
      paramd.a(paramInt, ((Byte)paramObject).byteValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramd.a(paramInt, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue());
      for (long l = 1L; ; l = 0L)
      {
        paramd.a(paramInt, l);
        return;
      }
    }
    throw new IllegalArgumentException("Cannot bind " + paramObject + " at index " + paramInt + " Supported types: null, byte[], float, double, long, int, short, byte," + " string");
  }

  public static void a(d paramd, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null);
    while (true)
    {
      return;
      int i = paramArrayOfObject.length;
      for (int j = 0; j < i; j++)
      {
        Object localObject = paramArrayOfObject[j];
        a(paramd, j + 1, localObject);
      }
    }
  }

  public String a()
  {
    return this.a;
  }

  public void a(d paramd)
  {
    a(paramd, this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.a.a
 * JD-Core Version:    0.6.2
 */