package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.FieldAccess;
import java.lang.reflect.Field;
import java.util.List;
import sun.misc.Unsafe;

final class FieldSerializerUnsafeUtilImpl
  implements FieldSerializerUnsafeUtil
{
  private FieldSerializer serializer;

  public FieldSerializerUnsafeUtilImpl(FieldSerializer paramFieldSerializer)
  {
    this.serializer = paramFieldSerializer;
  }

  private int fieldSizeOf(Class<?> paramClass)
  {
    if ((paramClass == Integer.TYPE) || (paramClass == Float.TYPE))
      return 4;
    if ((paramClass == Long.TYPE) || (paramClass == Double.TYPE))
      return 8;
    if ((paramClass == Byte.TYPE) || (paramClass == Boolean.TYPE))
      return 1;
    if ((paramClass == Short.TYPE) || (paramClass == Character.TYPE))
      return 2;
    return UnsafeUtil.unsafe().addressSize();
  }

  public void createUnsafeCacheFieldsAndRegions(List<Field> paramList, List<FieldSerializer.CachedField> paramList1, int paramInt, IntArray paramIntArray)
  {
    int i = paramList.size();
    long l1 = -1L;
    int j = -1;
    int k = 0;
    int m = 0;
    long l2 = 0L;
    int n = 0;
    Object localObject = null;
    if (n < i)
    {
      Field localField = (Field)paramList.get(n);
      int i1 = -1;
      if ((this.serializer.access != null) && (paramIntArray.get(paramInt + n) == 1))
        i1 = ((FieldAccess)this.serializer.access).getIndex(localField.getName());
      long l3 = UnsafeUtil.unsafe().objectFieldOffset(localField);
      long l4 = l3 + fieldSizeOf(localField.getType());
      if ((!localField.getType().isPrimitive()) && (m != 0))
      {
        m = 0;
        if (k > 1)
        {
          if (Log.TRACE)
            Log.trace("kryo", "Class " + this.serializer.getType().getName() + ". Found a set of consecutive primitive fields. Number of fields = " + k + ". Byte length = " + (l1 - l2) + " Start offset = " + l2 + " endOffset=" + l1);
          UnsafeCacheFields.UnsafeRegionField localUnsafeRegionField2 = new UnsafeCacheFields.UnsafeRegionField(l2, l1 - l2);
          localUnsafeRegionField2.field = localObject;
          paramList1.add(localUnsafeRegionField2);
          label261: paramList1.add(this.serializer.newCachedField(localField, paramList1.size(), i1));
        }
      }
      while (true)
      {
        n++;
        l1 = l4;
        localObject = localField;
        j = i1;
        break;
        if (localObject == null)
          break label261;
        paramList1.add(this.serializer.newCachedField(localObject, paramList1.size(), j));
        break label261;
        if (!localField.getType().isPrimitive())
        {
          paramList1.add(this.serializer.newCachedField(localField, paramList1.size(), i1));
        }
        else if (m == 0)
        {
          m = 1;
          k = 1;
          l2 = l3;
        }
        else
        {
          k++;
        }
      }
    }
    if ((!this.serializer.getUseAsmEnabled()) && (this.serializer.getUseMemRegions()) && (m != 0))
    {
      if (k <= 1)
        break label543;
      if (Log.TRACE)
        Log.trace("kryo", "Class " + this.serializer.getType().getName() + ". Found a set of consecutive primitive fields. Number of fields = " + k + ". Byte length = " + (l1 - l2) + " Start offset = " + l2 + " endOffset=" + l1);
      localUnsafeRegionField1 = new UnsafeCacheFields.UnsafeRegionField(l2, l1 - l2);
      localUnsafeRegionField1.field = localObject;
      paramList1.add(localUnsafeRegionField1);
    }
    label543: 
    while (localObject == null)
    {
      UnsafeCacheFields.UnsafeRegionField localUnsafeRegionField1;
      return;
    }
    paramList1.add(this.serializer.newCachedField(localObject, paramList1.size(), j));
  }

  public long getObjectFieldOffset(Field paramField)
  {
    return UnsafeUtil.unsafe().objectFieldOffset(paramField);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtilImpl
 * JD-Core Version:    0.6.2
 */