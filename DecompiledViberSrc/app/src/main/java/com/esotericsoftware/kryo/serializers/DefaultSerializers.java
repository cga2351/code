package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Util;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

public class DefaultSerializers
{
  public static class BigDecimalSerializer extends Serializer<BigDecimal>
  {
    private DefaultSerializers.BigIntegerSerializer bigIntegerSerializer = new DefaultSerializers.BigIntegerSerializer();

    public BigDecimalSerializer()
    {
      setAcceptsNull(true);
      setImmutable(true);
    }

    public BigDecimal read(Kryo paramKryo, Input paramInput, Class<BigDecimal> paramClass)
    {
      BigInteger localBigInteger = this.bigIntegerSerializer.read(paramKryo, paramInput, null);
      if (localBigInteger == null)
        return null;
      return new BigDecimal(localBigInteger, paramInput.readInt(false));
    }

    public void write(Kryo paramKryo, Output paramOutput, BigDecimal paramBigDecimal)
    {
      if (paramBigDecimal == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      this.bigIntegerSerializer.write(paramKryo, paramOutput, paramBigDecimal.unscaledValue());
      paramOutput.writeInt(paramBigDecimal.scale(), false);
    }
  }

  public static class BigIntegerSerializer extends Serializer<BigInteger>
  {
    public BigIntegerSerializer()
    {
      setImmutable(true);
      setAcceptsNull(true);
    }

    public BigInteger read(Kryo paramKryo, Input paramInput, Class<BigInteger> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      return new BigInteger(paramInput.readBytes(i - 1));
    }

    public void write(Kryo paramKryo, Output paramOutput, BigInteger paramBigInteger)
    {
      if (paramBigInteger == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      byte[] arrayOfByte = paramBigInteger.toByteArray();
      paramOutput.writeVarInt(1 + arrayOfByte.length, true);
      paramOutput.writeBytes(arrayOfByte);
    }
  }

  public static class BooleanSerializer extends Serializer<Boolean>
  {
    public BooleanSerializer()
    {
      setImmutable(true);
    }

    public Boolean read(Kryo paramKryo, Input paramInput, Class<Boolean> paramClass)
    {
      return Boolean.valueOf(paramInput.readBoolean());
    }

    public void write(Kryo paramKryo, Output paramOutput, Boolean paramBoolean)
    {
      paramOutput.writeBoolean(paramBoolean.booleanValue());
    }
  }

  public static class ByteSerializer extends Serializer<Byte>
  {
    public ByteSerializer()
    {
      setImmutable(true);
    }

    public Byte read(Kryo paramKryo, Input paramInput, Class<Byte> paramClass)
    {
      return Byte.valueOf(paramInput.readByte());
    }

    public void write(Kryo paramKryo, Output paramOutput, Byte paramByte)
    {
      paramOutput.writeByte(paramByte.byteValue());
    }
  }

  public static class CalendarSerializer extends Serializer<Calendar>
  {
    private static final long DEFAULT_GREGORIAN_CUTOVER = -12219292800000L;
    DefaultSerializers.TimeZoneSerializer timeZoneSerializer = new DefaultSerializers.TimeZoneSerializer();

    public Calendar copy(Kryo paramKryo, Calendar paramCalendar)
    {
      return (Calendar)paramCalendar.clone();
    }

    public Calendar read(Kryo paramKryo, Input paramInput, Class<Calendar> paramClass)
    {
      Calendar localCalendar = Calendar.getInstance(this.timeZoneSerializer.read(paramKryo, paramInput, TimeZone.class));
      localCalendar.setTimeInMillis(paramInput.readLong(true));
      localCalendar.setLenient(paramInput.readBoolean());
      localCalendar.setFirstDayOfWeek(paramInput.readInt(true));
      localCalendar.setMinimalDaysInFirstWeek(paramInput.readInt(true));
      long l = paramInput.readLong(false);
      if ((l != -12219292800000L) && ((localCalendar instanceof GregorianCalendar)))
        ((GregorianCalendar)localCalendar).setGregorianChange(new Date(l));
      return localCalendar;
    }

    public void write(Kryo paramKryo, Output paramOutput, Calendar paramCalendar)
    {
      this.timeZoneSerializer.write(paramKryo, paramOutput, paramCalendar.getTimeZone());
      paramOutput.writeLong(paramCalendar.getTimeInMillis(), true);
      paramOutput.writeBoolean(paramCalendar.isLenient());
      paramOutput.writeInt(paramCalendar.getFirstDayOfWeek(), true);
      paramOutput.writeInt(paramCalendar.getMinimalDaysInFirstWeek(), true);
      if ((paramCalendar instanceof GregorianCalendar))
      {
        paramOutput.writeLong(((GregorianCalendar)paramCalendar).getGregorianChange().getTime(), false);
        return;
      }
      paramOutput.writeLong(-12219292800000L, false);
    }
  }

  public static class CharSerializer extends Serializer<Character>
  {
    public CharSerializer()
    {
      setImmutable(true);
    }

    public Character read(Kryo paramKryo, Input paramInput, Class<Character> paramClass)
    {
      return Character.valueOf(paramInput.readChar());
    }

    public void write(Kryo paramKryo, Output paramOutput, Character paramCharacter)
    {
      paramOutput.writeChar(paramCharacter.charValue());
    }
  }

  public static class ClassSerializer extends Serializer<Class>
  {
    public ClassSerializer()
    {
      setImmutable(true);
      setAcceptsNull(true);
    }

    public Class read(Kryo paramKryo, Input paramInput, Class<Class> paramClass)
    {
      Registration localRegistration = paramKryo.readClass(paramInput);
      int i = paramInput.read();
      Class localClass;
      if (localRegistration != null)
      {
        localClass = localRegistration.getType();
        if ((localClass != null) && (localClass.isPrimitive()))
          break label47;
      }
      label47: 
      while (i == 1)
      {
        return localClass;
        localClass = null;
        break;
      }
      return Util.getWrapperClass(localClass);
    }

    public void write(Kryo paramKryo, Output paramOutput, Class paramClass)
    {
      paramKryo.writeClass(paramOutput, paramClass);
      if ((paramClass != null) && (paramClass.isPrimitive()));
      for (int i = 1; ; i = 0)
      {
        paramOutput.writeByte(i);
        return;
      }
    }
  }

  public static class CollectionsEmptyListSerializer extends Serializer
  {
    public CollectionsEmptyListSerializer()
    {
      setImmutable(true);
    }

    public Object read(Kryo paramKryo, Input paramInput, Class paramClass)
    {
      return Collections.EMPTY_LIST;
    }

    public void write(Kryo paramKryo, Output paramOutput, Object paramObject)
    {
    }
  }

  public static class CollectionsEmptyMapSerializer extends Serializer
  {
    public CollectionsEmptyMapSerializer()
    {
      setImmutable(true);
    }

    public Object read(Kryo paramKryo, Input paramInput, Class paramClass)
    {
      return Collections.EMPTY_MAP;
    }

    public void write(Kryo paramKryo, Output paramOutput, Object paramObject)
    {
    }
  }

  public static class CollectionsEmptySetSerializer extends Serializer
  {
    public CollectionsEmptySetSerializer()
    {
      setImmutable(true);
    }

    public Object read(Kryo paramKryo, Input paramInput, Class paramClass)
    {
      return Collections.EMPTY_SET;
    }

    public void write(Kryo paramKryo, Output paramOutput, Object paramObject)
    {
    }
  }

  public static class CollectionsSingletonListSerializer extends Serializer<List>
  {
    public CollectionsSingletonListSerializer()
    {
      setImmutable(true);
    }

    public List read(Kryo paramKryo, Input paramInput, Class paramClass)
    {
      return Collections.singletonList(paramKryo.readClassAndObject(paramInput));
    }

    public void write(Kryo paramKryo, Output paramOutput, List paramList)
    {
      paramKryo.writeClassAndObject(paramOutput, paramList.get(0));
    }
  }

  public static class CollectionsSingletonMapSerializer extends Serializer<Map>
  {
    public CollectionsSingletonMapSerializer()
    {
      setImmutable(true);
    }

    public Map read(Kryo paramKryo, Input paramInput, Class paramClass)
    {
      return Collections.singletonMap(paramKryo.readClassAndObject(paramInput), paramKryo.readClassAndObject(paramInput));
    }

    public void write(Kryo paramKryo, Output paramOutput, Map paramMap)
    {
      Map.Entry localEntry = (Map.Entry)paramMap.entrySet().iterator().next();
      paramKryo.writeClassAndObject(paramOutput, localEntry.getKey());
      paramKryo.writeClassAndObject(paramOutput, localEntry.getValue());
    }
  }

  public static class CollectionsSingletonSetSerializer extends Serializer<Set>
  {
    public CollectionsSingletonSetSerializer()
    {
      setImmutable(true);
    }

    public Set read(Kryo paramKryo, Input paramInput, Class paramClass)
    {
      return Collections.singleton(paramKryo.readClassAndObject(paramInput));
    }

    public void write(Kryo paramKryo, Output paramOutput, Set paramSet)
    {
      paramKryo.writeClassAndObject(paramOutput, paramSet.iterator().next());
    }
  }

  public static class CurrencySerializer extends Serializer<Currency>
  {
    public CurrencySerializer()
    {
      setImmutable(true);
      setAcceptsNull(true);
    }

    public Currency read(Kryo paramKryo, Input paramInput, Class<Currency> paramClass)
    {
      String str = paramInput.readString();
      if (str == null)
        return null;
      return Currency.getInstance(str);
    }

    public void write(Kryo paramKryo, Output paramOutput, Currency paramCurrency)
    {
      if (paramCurrency == null);
      for (String str = null; ; str = paramCurrency.getCurrencyCode())
      {
        paramOutput.writeString(str);
        return;
      }
    }
  }

  public static class DateSerializer extends Serializer<Date>
  {
    // ERROR //
    private Date create(Kryo paramKryo, Class<?> paramClass, long paramLong)
      throws KryoException
    {
      // Byte code:
      //   0: aload_2
      //   1: ldc 19
      //   3: invokevirtual 25	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   6: ifeq +12 -> 18
      //   9: new 19	java/util/Date
      //   12: dup
      //   13: lload_3
      //   14: invokespecial 28	java/util/Date:<init>	(J)V
      //   17: areturn
      //   18: aload_2
      //   19: ldc 30
      //   21: invokevirtual 25	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   24: ifeq +12 -> 36
      //   27: new 30	java/sql/Timestamp
      //   30: dup
      //   31: lload_3
      //   32: invokespecial 31	java/sql/Timestamp:<init>	(J)V
      //   35: areturn
      //   36: aload_2
      //   37: ldc 33
      //   39: invokevirtual 25	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   42: ifeq +12 -> 54
      //   45: new 33	java/sql/Date
      //   48: dup
      //   49: lload_3
      //   50: invokespecial 34	java/sql/Date:<init>	(J)V
      //   53: areturn
      //   54: aload_2
      //   55: ldc 36
      //   57: invokevirtual 25	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   60: ifeq +12 -> 72
      //   63: new 36	java/sql/Time
      //   66: dup
      //   67: lload_3
      //   68: invokespecial 37	java/sql/Time:<init>	(J)V
      //   71: areturn
      //   72: iconst_1
      //   73: anewarray 39	java/lang/Class
      //   76: astore 6
      //   78: aload 6
      //   80: iconst_0
      //   81: getstatic 45	java/lang/Long:TYPE	Ljava/lang/Class;
      //   84: aastore
      //   85: aload_2
      //   86: aload 6
      //   88: invokevirtual 49	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
      //   91: astore 7
      //   93: aload 7
      //   95: ifnull +46 -> 141
      //   98: aload 7
      //   100: invokevirtual 55	java/lang/reflect/Constructor:isAccessible	()Z
      //   103: istore 8
      //   105: iload 8
      //   107: ifne +9 -> 116
      //   110: aload 7
      //   112: iconst_1
      //   113: invokevirtual 59	java/lang/reflect/Constructor:setAccessible	(Z)V
      //   116: iconst_1
      //   117: anewarray 21	java/lang/Object
      //   120: astore 9
      //   122: aload 9
      //   124: iconst_0
      //   125: lload_3
      //   126: invokestatic 63	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   129: aastore
      //   130: aload 7
      //   132: aload 9
      //   134: invokevirtual 67	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
      //   137: checkcast 19	java/util/Date
      //   140: areturn
      //   141: aload_1
      //   142: aload_2
      //   143: invokevirtual 72	com/esotericsoftware/kryo/Kryo:newInstance	(Ljava/lang/Class;)Ljava/lang/Object;
      //   146: checkcast 19	java/util/Date
      //   149: astore 11
      //   151: aload 11
      //   153: lload_3
      //   154: invokevirtual 75	java/util/Date:setTime	(J)V
      //   157: aload 11
      //   159: areturn
      //   160: astore 5
      //   162: new 13	com/esotericsoftware/kryo/KryoException
      //   165: dup
      //   166: aload 5
      //   168: invokespecial 78	com/esotericsoftware/kryo/KryoException:<init>	(Ljava/lang/Throwable;)V
      //   171: athrow
      //   172: astore 10
      //   174: goto -58 -> 116
      //
      // Exception table:
      //   from	to	target	type
      //   72	93	160	java/lang/Exception
      //   98	105	160	java/lang/Exception
      //   110	116	160	java/lang/Exception
      //   116	141	160	java/lang/Exception
      //   141	157	160	java/lang/Exception
      //   110	116	172	java/lang/Throwable
    }

    public Date copy(Kryo paramKryo, Date paramDate)
    {
      return create(paramKryo, paramDate.getClass(), paramDate.getTime());
    }

    public Date read(Kryo paramKryo, Input paramInput, Class<Date> paramClass)
    {
      return create(paramKryo, paramClass, paramInput.readLong(true));
    }

    public void write(Kryo paramKryo, Output paramOutput, Date paramDate)
    {
      paramOutput.writeLong(paramDate.getTime(), true);
    }
  }

  public static class DoubleSerializer extends Serializer<Double>
  {
    public DoubleSerializer()
    {
      setImmutable(true);
    }

    public Double read(Kryo paramKryo, Input paramInput, Class<Double> paramClass)
    {
      return Double.valueOf(paramInput.readDouble());
    }

    public void write(Kryo paramKryo, Output paramOutput, Double paramDouble)
    {
      paramOutput.writeDouble(paramDouble.doubleValue());
    }
  }

  public static class EnumSerializer extends Serializer<Enum>
  {
    private Object[] enumConstants;

    public EnumSerializer(Class<? extends Enum> paramClass)
    {
      setImmutable(true);
      setAcceptsNull(true);
      this.enumConstants = paramClass.getEnumConstants();
      if (this.enumConstants == null)
        throw new IllegalArgumentException("The type must be an enum: " + paramClass);
    }

    public Enum read(Kryo paramKryo, Input paramInput, Class<Enum> paramClass)
    {
      int i = paramInput.readVarInt(true);
      if (i == 0)
        return null;
      int j = i - 1;
      if ((j < 0) || (j > -1 + this.enumConstants.length))
        throw new KryoException("Invalid ordinal for enum \"" + paramClass.getName() + "\": " + j);
      return (Enum)this.enumConstants[j];
    }

    public void write(Kryo paramKryo, Output paramOutput, Enum paramEnum)
    {
      if (paramEnum == null)
      {
        paramOutput.writeVarInt(0, true);
        return;
      }
      paramOutput.writeVarInt(1 + paramEnum.ordinal(), true);
    }
  }

  public static class EnumSetSerializer extends Serializer<EnumSet>
  {
    public EnumSet copy(Kryo paramKryo, EnumSet paramEnumSet)
    {
      return EnumSet.copyOf(paramEnumSet);
    }

    public EnumSet read(Kryo paramKryo, Input paramInput, Class<EnumSet> paramClass)
    {
      Registration localRegistration = paramKryo.readClass(paramInput);
      EnumSet localEnumSet = EnumSet.noneOf(localRegistration.getType());
      Serializer localSerializer = localRegistration.getSerializer();
      int i = paramInput.readInt(true);
      for (int j = 0; j < i; j++)
        localEnumSet.add(localSerializer.read(paramKryo, paramInput, null));
      return localEnumSet;
    }

    public void write(Kryo paramKryo, Output paramOutput, EnumSet paramEnumSet)
    {
      EnumSet localEnumSet;
      if (paramEnumSet.isEmpty())
      {
        localEnumSet = EnumSet.complementOf(paramEnumSet);
        if (localEnumSet.isEmpty())
          throw new KryoException("An EnumSet must have a defined Enum to be serialized.");
      }
      for (Serializer localSerializer = paramKryo.writeClass(paramOutput, localEnumSet.iterator().next().getClass()).getSerializer(); ; localSerializer = paramKryo.writeClass(paramOutput, paramEnumSet.iterator().next().getClass()).getSerializer())
      {
        paramOutput.writeInt(paramEnumSet.size(), true);
        Iterator localIterator = paramEnumSet.iterator();
        while (localIterator.hasNext())
          localSerializer.write(paramKryo, paramOutput, localIterator.next());
      }
    }
  }

  public static class FloatSerializer extends Serializer<Float>
  {
    public FloatSerializer()
    {
      setImmutable(true);
    }

    public Float read(Kryo paramKryo, Input paramInput, Class<Float> paramClass)
    {
      return Float.valueOf(paramInput.readFloat());
    }

    public void write(Kryo paramKryo, Output paramOutput, Float paramFloat)
    {
      paramOutput.writeFloat(paramFloat.floatValue());
    }
  }

  public static class IntSerializer extends Serializer<Integer>
  {
    public IntSerializer()
    {
      setImmutable(true);
    }

    public Integer read(Kryo paramKryo, Input paramInput, Class<Integer> paramClass)
    {
      return Integer.valueOf(paramInput.readInt(false));
    }

    public void write(Kryo paramKryo, Output paramOutput, Integer paramInteger)
    {
      paramOutput.writeInt(paramInteger.intValue(), false);
    }
  }

  public static class KryoSerializableSerializer extends Serializer<KryoSerializable>
  {
    public KryoSerializable read(Kryo paramKryo, Input paramInput, Class<KryoSerializable> paramClass)
    {
      KryoSerializable localKryoSerializable = (KryoSerializable)paramKryo.newInstance(paramClass);
      paramKryo.reference(localKryoSerializable);
      localKryoSerializable.read(paramKryo, paramInput);
      return localKryoSerializable;
    }

    public void write(Kryo paramKryo, Output paramOutput, KryoSerializable paramKryoSerializable)
    {
      paramKryoSerializable.write(paramKryo, paramOutput);
    }
  }

  public static class LocaleSerializer extends Serializer<Locale>
  {
    public LocaleSerializer()
    {
      setImmutable(true);
    }

    protected static boolean isSameLocale(Locale paramLocale, String paramString1, String paramString2, String paramString3)
    {
      if (paramLocale == null);
      while ((!paramLocale.getLanguage().equals(paramString1)) || (!paramLocale.getCountry().equals(paramString2)) || (!paramLocale.getVariant().equals(paramString3)))
        return false;
      return true;
    }

    public Locale copy(Kryo paramKryo, Locale paramLocale)
    {
      return create(paramLocale.getLanguage(), paramLocale.getDisplayCountry(), paramLocale.getVariant());
    }

    protected Locale create(String paramString1, String paramString2, String paramString3)
    {
      if (isSameLocale(Locale.US, paramString1, paramString2, paramString3))
        return Locale.US;
      if (isSameLocale(Locale.UK, paramString1, paramString2, paramString3))
        return Locale.UK;
      if (isSameLocale(Locale.ENGLISH, paramString1, paramString2, paramString3))
        return Locale.ENGLISH;
      if (isSameLocale(Locale.FRENCH, paramString1, paramString2, paramString3))
        return Locale.FRENCH;
      if (isSameLocale(Locale.GERMAN, paramString1, paramString2, paramString3))
        return Locale.GERMAN;
      if (isSameLocale(Locale.ITALIAN, paramString1, paramString2, paramString3))
        return Locale.ITALIAN;
      if (isSameLocale(Locale.FRANCE, paramString1, paramString2, paramString3))
        return Locale.FRANCE;
      if (isSameLocale(Locale.GERMANY, paramString1, paramString2, paramString3))
        return Locale.GERMANY;
      if (isSameLocale(Locale.ITALY, paramString1, paramString2, paramString3))
        return Locale.ITALY;
      if (isSameLocale(Locale.JAPAN, paramString1, paramString2, paramString3))
        return Locale.JAPAN;
      if (isSameLocale(Locale.KOREA, paramString1, paramString2, paramString3))
        return Locale.KOREA;
      if (isSameLocale(Locale.CHINA, paramString1, paramString2, paramString3))
        return Locale.CHINA;
      if (isSameLocale(Locale.PRC, paramString1, paramString2, paramString3))
        return Locale.PRC;
      if (isSameLocale(Locale.TAIWAN, paramString1, paramString2, paramString3))
        return Locale.TAIWAN;
      if (isSameLocale(Locale.CANADA, paramString1, paramString2, paramString3))
        return Locale.CANADA;
      if (isSameLocale(Locale.CANADA_FRENCH, paramString1, paramString2, paramString3))
        return Locale.CANADA_FRENCH;
      if (isSameLocale(Locale.JAPANESE, paramString1, paramString2, paramString3))
        return Locale.JAPANESE;
      if (isSameLocale(Locale.KOREAN, paramString1, paramString2, paramString3))
        return Locale.KOREAN;
      if (isSameLocale(Locale.CHINESE, paramString1, paramString2, paramString3))
        return Locale.CHINESE;
      if (isSameLocale(Locale.SIMPLIFIED_CHINESE, paramString1, paramString2, paramString3))
        return Locale.SIMPLIFIED_CHINESE;
      if (isSameLocale(Locale.TRADITIONAL_CHINESE, paramString1, paramString2, paramString3))
        return Locale.TRADITIONAL_CHINESE;
      return new Locale(paramString1, paramString2, paramString3);
    }

    public Locale read(Kryo paramKryo, Input paramInput, Class<Locale> paramClass)
    {
      return create(paramInput.readString(), paramInput.readString(), paramInput.readString());
    }

    public void write(Kryo paramKryo, Output paramOutput, Locale paramLocale)
    {
      paramOutput.writeString(paramLocale.getLanguage());
      paramOutput.writeString(paramLocale.getCountry());
      paramOutput.writeString(paramLocale.getVariant());
    }
  }

  public static class LongSerializer extends Serializer<Long>
  {
    public LongSerializer()
    {
      setImmutable(true);
    }

    public Long read(Kryo paramKryo, Input paramInput, Class<Long> paramClass)
    {
      return Long.valueOf(paramInput.readLong(false));
    }

    public void write(Kryo paramKryo, Output paramOutput, Long paramLong)
    {
      paramOutput.writeLong(paramLong.longValue(), false);
    }
  }

  public static class ShortSerializer extends Serializer<Short>
  {
    public ShortSerializer()
    {
      setImmutable(true);
    }

    public Short read(Kryo paramKryo, Input paramInput, Class<Short> paramClass)
    {
      return Short.valueOf(paramInput.readShort());
    }

    public void write(Kryo paramKryo, Output paramOutput, Short paramShort)
    {
      paramOutput.writeShort(paramShort.shortValue());
    }
  }

  public static class StringBufferSerializer extends Serializer<StringBuffer>
  {
    public StringBufferSerializer()
    {
      setAcceptsNull(true);
    }

    public StringBuffer copy(Kryo paramKryo, StringBuffer paramStringBuffer)
    {
      return new StringBuffer(paramStringBuffer);
    }

    public StringBuffer read(Kryo paramKryo, Input paramInput, Class<StringBuffer> paramClass)
    {
      String str = paramInput.readString();
      if (str == null)
        return null;
      return new StringBuffer(str);
    }

    public void write(Kryo paramKryo, Output paramOutput, StringBuffer paramStringBuffer)
    {
      paramOutput.writeString(paramStringBuffer);
    }
  }

  public static class StringBuilderSerializer extends Serializer<StringBuilder>
  {
    public StringBuilderSerializer()
    {
      setAcceptsNull(true);
    }

    public StringBuilder copy(Kryo paramKryo, StringBuilder paramStringBuilder)
    {
      return new StringBuilder(paramStringBuilder);
    }

    public StringBuilder read(Kryo paramKryo, Input paramInput, Class<StringBuilder> paramClass)
    {
      return paramInput.readStringBuilder();
    }

    public void write(Kryo paramKryo, Output paramOutput, StringBuilder paramStringBuilder)
    {
      paramOutput.writeString(paramStringBuilder);
    }
  }

  public static class StringSerializer extends Serializer<String>
  {
    public StringSerializer()
    {
      setImmutable(true);
      setAcceptsNull(true);
    }

    public String read(Kryo paramKryo, Input paramInput, Class<String> paramClass)
    {
      return paramInput.readString();
    }

    public void write(Kryo paramKryo, Output paramOutput, String paramString)
    {
      paramOutput.writeString(paramString);
    }
  }

  public static class TimeZoneSerializer extends Serializer<TimeZone>
  {
    public TimeZoneSerializer()
    {
      setImmutable(true);
    }

    public TimeZone read(Kryo paramKryo, Input paramInput, Class<TimeZone> paramClass)
    {
      return TimeZone.getTimeZone(paramInput.readString());
    }

    public void write(Kryo paramKryo, Output paramOutput, TimeZone paramTimeZone)
    {
      paramOutput.writeString(paramTimeZone.getID());
    }
  }

  public static class TreeMapSerializer extends MapSerializer
  {
    protected Map create(Kryo paramKryo, Input paramInput, Class<Map> paramClass)
    {
      return new TreeMap((Comparator)paramKryo.readClassAndObject(paramInput));
    }

    protected Map createCopy(Kryo paramKryo, Map paramMap)
    {
      return new TreeMap(((TreeMap)paramMap).comparator());
    }

    public void write(Kryo paramKryo, Output paramOutput, Map paramMap)
    {
      paramKryo.writeClassAndObject(paramOutput, ((TreeMap)paramMap).comparator());
      super.write(paramKryo, paramOutput, paramMap);
    }
  }

  public static class TreeSetSerializer extends CollectionSerializer
  {
    protected TreeSet create(Kryo paramKryo, Input paramInput, Class<Collection> paramClass)
    {
      return new TreeSet((Comparator)paramKryo.readClassAndObject(paramInput));
    }

    protected TreeSet createCopy(Kryo paramKryo, Collection paramCollection)
    {
      return new TreeSet(((TreeSet)paramCollection).comparator());
    }

    public void write(Kryo paramKryo, Output paramOutput, Collection paramCollection)
    {
      paramKryo.writeClassAndObject(paramOutput, ((TreeSet)paramCollection).comparator());
      super.write(paramKryo, paramOutput, paramCollection);
    }
  }

  public static class VoidSerializer extends Serializer
  {
    public VoidSerializer()
    {
      setImmutable(true);
    }

    public Object read(Kryo paramKryo, Input paramInput, Class paramClass)
    {
      return null;
    }

    public void write(Kryo paramKryo, Output paramOutput, Object paramObject)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.DefaultSerializers
 * JD-Core Version:    0.6.2
 */