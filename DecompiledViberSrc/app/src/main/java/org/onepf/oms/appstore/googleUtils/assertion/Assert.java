package org.onepf.oms.appstore.googleUtils.assertion;

public class Assert
{
  public static void assertEquals(byte paramByte1, byte paramByte2)
  {
    assertEquals(null, paramByte1, paramByte2);
  }

  public static void assertEquals(char paramChar1, char paramChar2)
  {
    assertEquals(null, paramChar1, paramChar2);
  }

  public static void assertEquals(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    assertEquals(null, paramDouble1, paramDouble2, paramDouble3);
  }

  public static void assertEquals(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    assertEquals(null, paramFloat1, paramFloat2, paramFloat3);
  }

  public static void assertEquals(int paramInt1, int paramInt2)
  {
    assertEquals(null, paramInt1, paramInt2);
  }

  public static void assertEquals(long paramLong1, long paramLong2)
  {
    assertEquals(null, paramLong1, paramLong2);
  }

  public static void assertEquals(Object paramObject1, Object paramObject2)
  {
    assertEquals(null, paramObject1, paramObject2);
  }

  public static void assertEquals(String paramString, byte paramByte1, byte paramByte2)
  {
    assertEquals(paramString, new Byte(paramByte1), new Byte(paramByte2));
  }

  public static void assertEquals(String paramString, char paramChar1, char paramChar2)
  {
    assertEquals(paramString, new Character(paramChar1), new Character(paramChar2));
  }

  public static void assertEquals(String paramString, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (Double.compare(paramDouble1, paramDouble2) == 0);
    while (Math.abs(paramDouble1 - paramDouble2) <= paramDouble3)
      return;
    failNotEquals(paramString, new Double(paramDouble1), new Double(paramDouble2));
  }

  public static void assertEquals(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Float.compare(paramFloat1, paramFloat2) == 0);
    while (Math.abs(paramFloat1 - paramFloat2) <= paramFloat3)
      return;
    failNotEquals(paramString, new Float(paramFloat1), new Float(paramFloat2));
  }

  public static void assertEquals(String paramString, int paramInt1, int paramInt2)
  {
    assertEquals(paramString, new Integer(paramInt1), new Integer(paramInt2));
  }

  public static void assertEquals(String paramString, long paramLong1, long paramLong2)
  {
    assertEquals(paramString, new Long(paramLong1), new Long(paramLong2));
  }

  public static void assertEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null));
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2)))
      return;
    failNotEquals(paramString, paramObject1, paramObject2);
  }

  public static void assertEquals(String paramString1, String paramString2)
  {
    assertEquals(null, paramString1, paramString2);
  }

  public static void assertEquals(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 == null) && (paramString3 == null));
    while ((paramString2 != null) && (paramString2.equals(paramString3)))
      return;
    if (paramString1 == null)
      paramString1 = "";
    throw new ComparisonFailure(paramString1, paramString2, paramString3);
  }

  public static void assertEquals(String paramString, short paramShort1, short paramShort2)
  {
    assertEquals(paramString, new Short(paramShort1), new Short(paramShort2));
  }

  public static void assertEquals(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    assertEquals(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2));
  }

  public static void assertEquals(short paramShort1, short paramShort2)
  {
    assertEquals(null, paramShort1, paramShort2);
  }

  public static void assertEquals(boolean paramBoolean1, boolean paramBoolean2)
  {
    assertEquals(null, paramBoolean1, paramBoolean2);
  }

  public static void assertFalse(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      assertTrue(paramString, bool);
      return;
    }
  }

  public static void assertFalse(boolean paramBoolean)
  {
    assertFalse(null, paramBoolean);
  }

  public static void assertNotNull(Object paramObject)
  {
    assertNotNull(null, paramObject);
  }

  public static void assertNotNull(String paramString, Object paramObject)
  {
    if (paramObject != null);
    for (boolean bool = true; ; bool = false)
    {
      assertTrue(paramString, bool);
      return;
    }
  }

  public static void assertNotSame(Object paramObject1, Object paramObject2)
  {
    assertNotSame(null, paramObject1, paramObject2);
  }

  public static void assertNotSame(String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2)
      failSame(paramString);
  }

  public static void assertNull(Object paramObject)
  {
    assertNull("Expected: <null> but was: " + String.valueOf(paramObject), paramObject);
  }

  public static void assertNull(String paramString, Object paramObject)
  {
    if (paramObject == null);
    for (boolean bool = true; ; bool = false)
    {
      assertTrue(paramString, bool);
      return;
    }
  }

  public static void assertSame(Object paramObject1, Object paramObject2)
  {
    assertSame(null, paramObject1, paramObject2);
  }

  public static void assertSame(String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2)
      return;
    failNotSame(paramString, paramObject1, paramObject2);
  }

  public static void assertTrue(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      fail(paramString);
  }

  public static void assertTrue(boolean paramBoolean)
  {
    assertTrue(null, paramBoolean);
  }

  public static void fail()
  {
    fail(null);
  }

  public static void fail(String paramString)
  {
    if (paramString == null)
      throw new AssertionFailedError();
    throw new AssertionFailedError(paramString);
  }

  public static void failNotEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    fail(format(paramString, paramObject1, paramObject2));
  }

  public static void failNotSame(String paramString, Object paramObject1, Object paramObject2)
  {
    String str = "";
    if (paramString != null)
      str = paramString + " ";
    fail(str + "expected same:<" + paramObject1 + "> was not:<" + paramObject2 + ">");
  }

  public static void failSame(String paramString)
  {
    String str = "";
    if (paramString != null)
      str = paramString + " ";
    fail(str + "expected not same");
  }

  public static String format(String paramString, Object paramObject1, Object paramObject2)
  {
    String str = "";
    if ((paramString != null) && (paramString.length() > 0))
      str = paramString + " ";
    return str + "expected:<" + paramObject1 + "> but was:<" + paramObject2 + ">";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.assertion.Assert
 * JD-Core Version:    0.6.2
 */