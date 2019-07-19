package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.reflectasm.FieldAccess;
import java.lang.reflect.Field;

class ObjectField extends FieldSerializer.CachedField
{
  final FieldSerializer fieldSerializer;
  public Class[] generics;
  final Kryo kryo;
  final Class type;

  ObjectField(FieldSerializer paramFieldSerializer)
  {
    this.fieldSerializer = paramFieldSerializer;
    this.kryo = paramFieldSerializer.kryo;
    this.type = paramFieldSerializer.type;
  }

  public void copy(Object paramObject1, Object paramObject2)
  {
    try
    {
      if (this.accessIndex != -1)
      {
        FieldAccess localFieldAccess = (FieldAccess)this.fieldSerializer.access;
        localFieldAccess.set(paramObject2, this.accessIndex, this.kryo.copy(localFieldAccess.get(paramObject1, this.accessIndex)));
        return;
      }
      setField(paramObject2, this.kryo.copy(getField(paramObject1)));
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new KryoException("Error accessing field: " + this + " (" + this.type.getName() + ")", localIllegalAccessException);
    }
    catch (KryoException localKryoException2)
    {
      localKryoException2.addTrace(this + " (" + this.type.getName() + ")");
      throw localKryoException2;
    }
    catch (RuntimeException localRuntimeException)
    {
      KryoException localKryoException1 = new KryoException(localRuntimeException);
      localKryoException1.addTrace(this + " (" + this.type.getName() + ")");
      throw localKryoException1;
    }
  }

  public Object getField(Object paramObject)
    throws IllegalArgumentException, IllegalAccessException
  {
    return this.field.get(paramObject);
  }

  // ERROR //
  public void read(Input paramInput, Object paramObject)
  {
    // Byte code:
    //   0: getstatic 117	com/esotericsoftware/minlog/Log:TRACE	Z
    //   3: ifeq +59 -> 62
    //   6: ldc 118
    //   8: new 66	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   15: ldc 120
    //   17: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: ldc 78
    //   26: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 27	com/esotericsoftware/kryo/serializers/ObjectField:type	Ljava/lang/Class;
    //   33: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   36: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 86
    //   41: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 122
    //   46: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 128	com/esotericsoftware/kryo/io/Input:position	()I
    //   53: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 135	com/esotericsoftware/minlog/Log:trace	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 138	com/esotericsoftware/kryo/serializers/ObjectField:valueClass	Ljava/lang/Class;
    //   66: astore 8
    //   68: aload_0
    //   69: getfield 142	com/esotericsoftware/kryo/serializers/ObjectField:serializer	Lcom/esotericsoftware/kryo/Serializer;
    //   72: astore 9
    //   74: aload 8
    //   76: ifnonnull +74 -> 150
    //   79: aload_0
    //   80: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   83: aload_1
    //   84: invokevirtual 146	com/esotericsoftware/kryo/Kryo:readClass	(Lcom/esotericsoftware/kryo/io/Input;)Lcom/esotericsoftware/kryo/Registration;
    //   87: astore 10
    //   89: aload 10
    //   91: ifnonnull +14 -> 105
    //   94: aconst_null
    //   95: astore 11
    //   97: aload_0
    //   98: aload_2
    //   99: aload 11
    //   101: invokevirtual 64	com/esotericsoftware/kryo/serializers/ObjectField:setField	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   104: return
    //   105: aload 9
    //   107: ifnonnull +10 -> 117
    //   110: aload 10
    //   112: invokevirtual 152	com/esotericsoftware/kryo/Registration:getSerializer	()Lcom/esotericsoftware/kryo/Serializer;
    //   115: astore 9
    //   117: aload 9
    //   119: aload_0
    //   120: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   123: aload_0
    //   124: getfield 154	com/esotericsoftware/kryo/serializers/ObjectField:generics	[Ljava/lang/Class;
    //   127: invokevirtual 160	com/esotericsoftware/kryo/Serializer:setGenerics	(Lcom/esotericsoftware/kryo/Kryo;[Ljava/lang/Class;)V
    //   130: aload_0
    //   131: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   134: aload_1
    //   135: aload 10
    //   137: invokevirtual 164	com/esotericsoftware/kryo/Registration:getType	()Ljava/lang/Class;
    //   140: aload 9
    //   142: invokevirtual 168	com/esotericsoftware/kryo/Kryo:readObject	(Lcom/esotericsoftware/kryo/io/Input;Ljava/lang/Class;Lcom/esotericsoftware/kryo/Serializer;)Ljava/lang/Object;
    //   145: astore 11
    //   147: goto -50 -> 97
    //   150: aload 9
    //   152: ifnonnull +22 -> 174
    //   155: aload_0
    //   156: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   159: aload_0
    //   160: getfield 138	com/esotericsoftware/kryo/serializers/ObjectField:valueClass	Ljava/lang/Class;
    //   163: invokevirtual 171	com/esotericsoftware/kryo/Kryo:getSerializer	(Ljava/lang/Class;)Lcom/esotericsoftware/kryo/Serializer;
    //   166: astore 9
    //   168: aload_0
    //   169: aload 9
    //   171: putfield 142	com/esotericsoftware/kryo/serializers/ObjectField:serializer	Lcom/esotericsoftware/kryo/Serializer;
    //   174: aload 9
    //   176: aload_0
    //   177: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   180: aload_0
    //   181: getfield 154	com/esotericsoftware/kryo/serializers/ObjectField:generics	[Ljava/lang/Class;
    //   184: invokevirtual 160	com/esotericsoftware/kryo/Serializer:setGenerics	(Lcom/esotericsoftware/kryo/Kryo;[Ljava/lang/Class;)V
    //   187: aload_0
    //   188: getfield 174	com/esotericsoftware/kryo/serializers/ObjectField:canBeNull	Z
    //   191: ifeq +20 -> 211
    //   194: aload_0
    //   195: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   198: aload_1
    //   199: aload 8
    //   201: aload 9
    //   203: invokevirtual 177	com/esotericsoftware/kryo/Kryo:readObjectOrNull	(Lcom/esotericsoftware/kryo/io/Input;Ljava/lang/Class;Lcom/esotericsoftware/kryo/Serializer;)Ljava/lang/Object;
    //   206: astore 11
    //   208: goto -111 -> 97
    //   211: aload_0
    //   212: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   215: aload_1
    //   216: aload 8
    //   218: aload 9
    //   220: invokevirtual 168	com/esotericsoftware/kryo/Kryo:readObject	(Lcom/esotericsoftware/kryo/io/Input;Ljava/lang/Class;Lcom/esotericsoftware/kryo/Serializer;)Ljava/lang/Object;
    //   223: astore 12
    //   225: aload 12
    //   227: astore 11
    //   229: goto -132 -> 97
    //   232: astore 7
    //   234: new 33	com/esotericsoftware/kryo/KryoException
    //   237: dup
    //   238: new 66	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   245: ldc 69
    //   247: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_0
    //   251: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: ldc 78
    //   256: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: getfield 27	com/esotericsoftware/kryo/serializers/ObjectField:type	Ljava/lang/Class;
    //   263: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   266: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc 86
    //   271: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: aload 7
    //   279: invokespecial 92	com/esotericsoftware/kryo/KryoException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   282: athrow
    //   283: astore 5
    //   285: aload 5
    //   287: athrow
    //   288: astore 6
    //   290: aload 6
    //   292: new 66	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   299: aload_0
    //   300: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: ldc 78
    //   305: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_0
    //   309: getfield 27	com/esotericsoftware/kryo/serializers/ObjectField:type	Ljava/lang/Class;
    //   312: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   315: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc 86
    //   320: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokevirtual 96	com/esotericsoftware/kryo/KryoException:addTrace	(Ljava/lang/String;)V
    //   329: aload 6
    //   331: athrow
    //   332: astore_3
    //   333: new 33	com/esotericsoftware/kryo/KryoException
    //   336: dup
    //   337: aload_3
    //   338: invokespecial 99	com/esotericsoftware/kryo/KryoException:<init>	(Ljava/lang/Throwable;)V
    //   341: astore 4
    //   343: aload 4
    //   345: new 66	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   352: aload_0
    //   353: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   356: ldc 78
    //   358: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_0
    //   362: getfield 27	com/esotericsoftware/kryo/serializers/ObjectField:type	Ljava/lang/Class;
    //   365: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   368: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc 86
    //   373: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokevirtual 96	com/esotericsoftware/kryo/KryoException:addTrace	(Ljava/lang/String;)V
    //   382: aload 4
    //   384: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	62	232	java/lang/IllegalAccessException
    //   62	74	232	java/lang/IllegalAccessException
    //   79	89	232	java/lang/IllegalAccessException
    //   97	104	232	java/lang/IllegalAccessException
    //   110	117	232	java/lang/IllegalAccessException
    //   117	147	232	java/lang/IllegalAccessException
    //   155	174	232	java/lang/IllegalAccessException
    //   174	208	232	java/lang/IllegalAccessException
    //   211	225	232	java/lang/IllegalAccessException
    //   0	62	283	finally
    //   62	74	283	finally
    //   79	89	283	finally
    //   97	104	283	finally
    //   110	117	283	finally
    //   117	147	283	finally
    //   155	174	283	finally
    //   174	208	283	finally
    //   211	225	283	finally
    //   234	283	283	finally
    //   290	332	283	finally
    //   333	385	283	finally
    //   0	62	288	com/esotericsoftware/kryo/KryoException
    //   62	74	288	com/esotericsoftware/kryo/KryoException
    //   79	89	288	com/esotericsoftware/kryo/KryoException
    //   97	104	288	com/esotericsoftware/kryo/KryoException
    //   110	117	288	com/esotericsoftware/kryo/KryoException
    //   117	147	288	com/esotericsoftware/kryo/KryoException
    //   155	174	288	com/esotericsoftware/kryo/KryoException
    //   174	208	288	com/esotericsoftware/kryo/KryoException
    //   211	225	288	com/esotericsoftware/kryo/KryoException
    //   0	62	332	java/lang/RuntimeException
    //   62	74	332	java/lang/RuntimeException
    //   79	89	332	java/lang/RuntimeException
    //   97	104	332	java/lang/RuntimeException
    //   110	117	332	java/lang/RuntimeException
    //   117	147	332	java/lang/RuntimeException
    //   155	174	332	java/lang/RuntimeException
    //   174	208	332	java/lang/RuntimeException
    //   211	225	332	java/lang/RuntimeException
  }

  public void setField(Object paramObject1, Object paramObject2)
    throws IllegalArgumentException, IllegalAccessException
  {
    this.field.set(paramObject1, paramObject2);
  }

  // ERROR //
  public void write(Output paramOutput, Object paramObject)
  {
    // Byte code:
    //   0: getstatic 117	com/esotericsoftware/minlog/Log:TRACE	Z
    //   3: ifeq +59 -> 62
    //   6: ldc 118
    //   8: new 66	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   15: ldc 183
    //   17: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: ldc 78
    //   26: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   33: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   36: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 86
    //   41: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 122
    //   46: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 191	com/esotericsoftware/kryo/io/Output:position	()I
    //   53: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 135	com/esotericsoftware/minlog/Log:trace	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: aload_2
    //   64: invokevirtual 61	com/esotericsoftware/kryo/serializers/ObjectField:getField	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: astore 8
    //   69: aload_0
    //   70: getfield 142	com/esotericsoftware/kryo/serializers/ObjectField:serializer	Lcom/esotericsoftware/kryo/Serializer;
    //   73: astore 9
    //   75: aload_0
    //   76: getfield 138	com/esotericsoftware/kryo/serializers/ObjectField:valueClass	Ljava/lang/Class;
    //   79: ifnonnull +128 -> 207
    //   82: aload 8
    //   84: ifnonnull +14 -> 98
    //   87: aload_0
    //   88: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   91: aload_1
    //   92: aconst_null
    //   93: invokevirtual 195	com/esotericsoftware/kryo/Kryo:writeClass	(Lcom/esotericsoftware/kryo/io/Output;Ljava/lang/Class;)Lcom/esotericsoftware/kryo/Registration;
    //   96: pop
    //   97: return
    //   98: aload_0
    //   99: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   102: aload_1
    //   103: aload 8
    //   105: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   108: invokevirtual 195	com/esotericsoftware/kryo/Kryo:writeClass	(Lcom/esotericsoftware/kryo/io/Output;Ljava/lang/Class;)Lcom/esotericsoftware/kryo/Registration;
    //   111: astore 11
    //   113: aload 9
    //   115: ifnonnull +10 -> 125
    //   118: aload 11
    //   120: invokevirtual 152	com/esotericsoftware/kryo/Registration:getSerializer	()Lcom/esotericsoftware/kryo/Serializer;
    //   123: astore 9
    //   125: aload 9
    //   127: aload_0
    //   128: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   131: aload_0
    //   132: getfield 154	com/esotericsoftware/kryo/serializers/ObjectField:generics	[Ljava/lang/Class;
    //   135: invokevirtual 160	com/esotericsoftware/kryo/Serializer:setGenerics	(Lcom/esotericsoftware/kryo/Kryo;[Ljava/lang/Class;)V
    //   138: aload_0
    //   139: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   142: aload_1
    //   143: aload 8
    //   145: aload 9
    //   147: invokevirtual 199	com/esotericsoftware/kryo/Kryo:writeObject	(Lcom/esotericsoftware/kryo/io/Output;Ljava/lang/Object;Lcom/esotericsoftware/kryo/Serializer;)V
    //   150: return
    //   151: astore 7
    //   153: new 33	com/esotericsoftware/kryo/KryoException
    //   156: dup
    //   157: new 66	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   164: ldc 69
    //   166: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: ldc 78
    //   175: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_2
    //   179: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   182: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   185: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc 86
    //   190: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: aload 7
    //   198: invokespecial 92	com/esotericsoftware/kryo/KryoException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: athrow
    //   202: astore 5
    //   204: aload 5
    //   206: athrow
    //   207: aload 9
    //   209: ifnonnull +22 -> 231
    //   212: aload_0
    //   213: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   216: aload_0
    //   217: getfield 138	com/esotericsoftware/kryo/serializers/ObjectField:valueClass	Ljava/lang/Class;
    //   220: invokevirtual 171	com/esotericsoftware/kryo/Kryo:getSerializer	(Ljava/lang/Class;)Lcom/esotericsoftware/kryo/Serializer;
    //   223: astore 9
    //   225: aload_0
    //   226: aload 9
    //   228: putfield 142	com/esotericsoftware/kryo/serializers/ObjectField:serializer	Lcom/esotericsoftware/kryo/Serializer;
    //   231: aload 9
    //   233: aload_0
    //   234: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   237: aload_0
    //   238: getfield 154	com/esotericsoftware/kryo/serializers/ObjectField:generics	[Ljava/lang/Class;
    //   241: invokevirtual 160	com/esotericsoftware/kryo/Serializer:setGenerics	(Lcom/esotericsoftware/kryo/Kryo;[Ljava/lang/Class;)V
    //   244: aload_0
    //   245: getfield 174	com/esotericsoftware/kryo/serializers/ObjectField:canBeNull	Z
    //   248: ifeq +60 -> 308
    //   251: aload_0
    //   252: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   255: aload_1
    //   256: aload 8
    //   258: aload 9
    //   260: invokevirtual 202	com/esotericsoftware/kryo/Kryo:writeObjectOrNull	(Lcom/esotericsoftware/kryo/io/Output;Ljava/lang/Object;Lcom/esotericsoftware/kryo/Serializer;)V
    //   263: return
    //   264: astore 6
    //   266: aload 6
    //   268: new 66	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   275: aload_0
    //   276: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: ldc 78
    //   281: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_2
    //   285: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   288: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   291: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 86
    //   296: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 96	com/esotericsoftware/kryo/KryoException:addTrace	(Ljava/lang/String;)V
    //   305: aload 6
    //   307: athrow
    //   308: aload 8
    //   310: ifnonnull +103 -> 413
    //   313: new 33	com/esotericsoftware/kryo/KryoException
    //   316: dup
    //   317: new 66	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   324: ldc 204
    //   326: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_0
    //   330: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   333: ldc 78
    //   335: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_2
    //   339: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   342: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   345: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: ldc 86
    //   350: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokespecial 206	com/esotericsoftware/kryo/KryoException:<init>	(Ljava/lang/String;)V
    //   359: athrow
    //   360: astore_3
    //   361: new 33	com/esotericsoftware/kryo/KryoException
    //   364: dup
    //   365: aload_3
    //   366: invokespecial 99	com/esotericsoftware/kryo/KryoException:<init>	(Ljava/lang/Throwable;)V
    //   369: astore 4
    //   371: aload 4
    //   373: new 66	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   380: aload_0
    //   381: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   384: ldc 78
    //   386: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_2
    //   390: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   393: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   396: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: ldc 86
    //   401: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokevirtual 96	com/esotericsoftware/kryo/KryoException:addTrace	(Ljava/lang/String;)V
    //   410: aload 4
    //   412: athrow
    //   413: aload_0
    //   414: getfield 24	com/esotericsoftware/kryo/serializers/ObjectField:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   417: aload_1
    //   418: aload 8
    //   420: aload 9
    //   422: invokevirtual 199	com/esotericsoftware/kryo/Kryo:writeObject	(Lcom/esotericsoftware/kryo/io/Output;Ljava/lang/Object;Lcom/esotericsoftware/kryo/Serializer;)V
    //   425: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	62	151	java/lang/IllegalAccessException
    //   62	82	151	java/lang/IllegalAccessException
    //   87	97	151	java/lang/IllegalAccessException
    //   98	113	151	java/lang/IllegalAccessException
    //   118	125	151	java/lang/IllegalAccessException
    //   125	150	151	java/lang/IllegalAccessException
    //   212	231	151	java/lang/IllegalAccessException
    //   231	263	151	java/lang/IllegalAccessException
    //   313	360	151	java/lang/IllegalAccessException
    //   413	425	151	java/lang/IllegalAccessException
    //   0	62	202	finally
    //   62	82	202	finally
    //   87	97	202	finally
    //   98	113	202	finally
    //   118	125	202	finally
    //   125	150	202	finally
    //   153	202	202	finally
    //   212	231	202	finally
    //   231	263	202	finally
    //   266	308	202	finally
    //   313	360	202	finally
    //   361	413	202	finally
    //   413	425	202	finally
    //   0	62	264	com/esotericsoftware/kryo/KryoException
    //   62	82	264	com/esotericsoftware/kryo/KryoException
    //   87	97	264	com/esotericsoftware/kryo/KryoException
    //   98	113	264	com/esotericsoftware/kryo/KryoException
    //   118	125	264	com/esotericsoftware/kryo/KryoException
    //   125	150	264	com/esotericsoftware/kryo/KryoException
    //   212	231	264	com/esotericsoftware/kryo/KryoException
    //   231	263	264	com/esotericsoftware/kryo/KryoException
    //   313	360	264	com/esotericsoftware/kryo/KryoException
    //   413	425	264	com/esotericsoftware/kryo/KryoException
    //   0	62	360	java/lang/RuntimeException
    //   62	82	360	java/lang/RuntimeException
    //   87	97	360	java/lang/RuntimeException
    //   98	113	360	java/lang/RuntimeException
    //   118	125	360	java/lang/RuntimeException
    //   125	150	360	java/lang/RuntimeException
    //   212	231	360	java/lang/RuntimeException
    //   231	263	360	java/lang/RuntimeException
    //   313	360	360	java/lang/RuntimeException
    //   413	425	360	java/lang/RuntimeException
  }

  static final class ObjectBooleanField extends ObjectField
  {
    public ObjectBooleanField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        this.field.setBoolean(paramObject2, this.field.getBoolean(paramObject1));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public Object getField(Object paramObject)
      throws IllegalArgumentException, IllegalAccessException
    {
      return Boolean.valueOf(this.field.getBoolean(paramObject));
    }

    public void read(Input paramInput, Object paramObject)
    {
      try
      {
        this.field.setBoolean(paramObject, paramInput.readBoolean());
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public void write(Output paramOutput, Object paramObject)
    {
      try
      {
        paramOutput.writeBoolean(this.field.getBoolean(paramObject));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }
  }

  static final class ObjectByteField extends ObjectField
  {
    public ObjectByteField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        this.field.setByte(paramObject2, this.field.getByte(paramObject1));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public Object getField(Object paramObject)
      throws IllegalArgumentException, IllegalAccessException
    {
      return Byte.valueOf(this.field.getByte(paramObject));
    }

    public void read(Input paramInput, Object paramObject)
    {
      try
      {
        this.field.setByte(paramObject, paramInput.readByte());
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public void write(Output paramOutput, Object paramObject)
    {
      try
      {
        paramOutput.writeByte(this.field.getByte(paramObject));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }
  }

  static final class ObjectCharField extends ObjectField
  {
    public ObjectCharField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        this.field.setChar(paramObject2, this.field.getChar(paramObject1));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public Object getField(Object paramObject)
      throws IllegalArgumentException, IllegalAccessException
    {
      return Character.valueOf(this.field.getChar(paramObject));
    }

    public void read(Input paramInput, Object paramObject)
    {
      try
      {
        this.field.setChar(paramObject, paramInput.readChar());
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public void write(Output paramOutput, Object paramObject)
    {
      try
      {
        paramOutput.writeChar(this.field.getChar(paramObject));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }
  }

  static final class ObjectDoubleField extends ObjectField
  {
    public ObjectDoubleField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        this.field.setDouble(paramObject2, this.field.getDouble(paramObject1));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public Object getField(Object paramObject)
      throws IllegalArgumentException, IllegalAccessException
    {
      return Double.valueOf(this.field.getDouble(paramObject));
    }

    public void read(Input paramInput, Object paramObject)
    {
      try
      {
        this.field.setDouble(paramObject, paramInput.readDouble());
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public void write(Output paramOutput, Object paramObject)
    {
      try
      {
        paramOutput.writeDouble(this.field.getDouble(paramObject));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }
  }

  static final class ObjectFloatField extends ObjectField
  {
    public ObjectFloatField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        this.field.setFloat(paramObject2, this.field.getFloat(paramObject1));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public Object getField(Object paramObject)
      throws IllegalArgumentException, IllegalAccessException
    {
      return Float.valueOf(this.field.getFloat(paramObject));
    }

    public void read(Input paramInput, Object paramObject)
    {
      try
      {
        this.field.setFloat(paramObject, paramInput.readFloat());
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public void write(Output paramOutput, Object paramObject)
    {
      try
      {
        paramOutput.writeFloat(this.field.getFloat(paramObject));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }
  }

  static final class ObjectIntField extends ObjectField
  {
    public ObjectIntField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        this.field.setInt(paramObject2, this.field.getInt(paramObject1));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public Object getField(Object paramObject)
      throws IllegalArgumentException, IllegalAccessException
    {
      return Integer.valueOf(this.field.getInt(paramObject));
    }

    public void read(Input paramInput, Object paramObject)
    {
      try
      {
        if (this.varIntsEnabled)
        {
          this.field.setInt(paramObject, paramInput.readInt(false));
          return;
        }
        this.field.setInt(paramObject, paramInput.readInt());
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public void write(Output paramOutput, Object paramObject)
    {
      try
      {
        if (this.varIntsEnabled)
        {
          paramOutput.writeInt(this.field.getInt(paramObject), false);
          return;
        }
        paramOutput.writeInt(this.field.getInt(paramObject));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }
  }

  static final class ObjectLongField extends ObjectField
  {
    public ObjectLongField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        this.field.setLong(paramObject2, this.field.getLong(paramObject1));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public Object getField(Object paramObject)
      throws IllegalArgumentException, IllegalAccessException
    {
      return Long.valueOf(this.field.getLong(paramObject));
    }

    public void read(Input paramInput, Object paramObject)
    {
      try
      {
        if (this.varIntsEnabled)
        {
          this.field.setLong(paramObject, paramInput.readLong(false));
          return;
        }
        this.field.setLong(paramObject, paramInput.readLong());
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public void write(Output paramOutput, Object paramObject)
    {
      try
      {
        if (this.varIntsEnabled)
        {
          paramOutput.writeLong(this.field.getLong(paramObject), false);
          return;
        }
        paramOutput.writeLong(this.field.getLong(paramObject));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }
  }

  static final class ObjectShortField extends ObjectField
  {
    public ObjectShortField(FieldSerializer paramFieldSerializer)
    {
      super();
    }

    public void copy(Object paramObject1, Object paramObject2)
    {
      try
      {
        this.field.setShort(paramObject2, this.field.getShort(paramObject1));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public Object getField(Object paramObject)
      throws IllegalArgumentException, IllegalAccessException
    {
      return Short.valueOf(this.field.getShort(paramObject));
    }

    public void read(Input paramInput, Object paramObject)
    {
      try
      {
        this.field.setShort(paramObject, paramInput.readShort());
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }

    public void write(Output paramOutput, Object paramObject)
    {
      try
      {
        paramOutput.writeShort(this.field.getShort(paramObject));
        return;
      }
      catch (Exception localException)
      {
        KryoException localKryoException = new KryoException(localException);
        localKryoException.addTrace(this + " (" + this.type.getName() + ")");
        throw localKryoException;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.ObjectField
 * JD-Core Version:    0.6.2
 */