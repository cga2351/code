package android.support.v8.renderscript;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ScriptGroup extends BaseObj
{
  private static final int MIN_API_VERSION = 23;
  private static final String TAG = "ScriptGroup";
  private List<Closure> mClosures;
  IO[] mInputs;
  private List<Input> mInputs2;
  private String mName;
  private ArrayList<Node> mNodes = new ArrayList();
  IO[] mOutputs;
  private Future[] mOutputs2;
  private boolean mUseIncSupp = false;

  ScriptGroup(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  ScriptGroup(RenderScript paramRenderScript, String paramString, List<Closure> paramList, List<Input> paramList1, Future[] paramArrayOfFuture)
  {
    super(0L, paramRenderScript);
    if ((Build.VERSION.SDK_INT < 23) && (paramRenderScript.isUseNative()))
      throw new RSRuntimeException("ScriptGroup2 not supported in this API level");
    this.mName = paramString;
    this.mClosures = paramList;
    this.mInputs2 = paramList1;
    this.mOutputs2 = paramArrayOfFuture;
    long[] arrayOfLong = new long[paramList.size()];
    for (int i = 0; i < arrayOfLong.length; i++)
      arrayOfLong[i] = ((Closure)paramList.get(i)).getID(paramRenderScript);
    setID(paramRenderScript.nScriptGroup2Create(paramString, paramRenderScript.getApplicationContext().getCacheDir().toString(), arrayOfLong));
  }

  @Deprecated
  public void execute()
  {
    if (!this.mUseIncSupp)
      this.mRS.nScriptGroupExecute(getID(this.mRS));
    Iterator localIterator1;
    do
    {
      return;
      for (int i = 0; i < this.mNodes.size(); i++)
      {
        Node localNode2 = (Node)this.mNodes.get(i);
        int i1 = 0;
        if (i1 < localNode2.mOutputs.size())
        {
          ConnectLine localConnectLine3 = (ConnectLine)localNode2.mOutputs.get(i1);
          if (localConnectLine3.mAllocation != null);
          while (true)
          {
            i1++;
            break;
            Allocation localAllocation = Allocation.createTyped(this.mRS, localConnectLine3.mAllocationType, Allocation.MipmapControl.MIPMAP_NONE, 1);
            localConnectLine3.mAllocation = localAllocation;
            for (int i2 = i1 + 1; i2 < localNode2.mOutputs.size(); i2++)
              if (((ConnectLine)localNode2.mOutputs.get(i2)).mFrom == localConnectLine3.mFrom)
                ((ConnectLine)localNode2.mOutputs.get(i2)).mAllocation = localAllocation;
          }
        }
      }
      localIterator1 = this.mNodes.iterator();
    }
    while (!localIterator1.hasNext());
    Node localNode1 = (Node)localIterator1.next();
    Iterator localIterator2 = localNode1.mKernels.iterator();
    label228: Script.KernelID localKernelID;
    Object localObject1;
    label262: ConnectLine localConnectLine2;
    if (localIterator2.hasNext())
    {
      localKernelID = (Script.KernelID)localIterator2.next();
      Iterator localIterator3 = localNode1.mInputs.iterator();
      localObject1 = null;
      if (localIterator3.hasNext())
      {
        localConnectLine2 = (ConnectLine)localIterator3.next();
        if (localConnectLine2.mToK != localKernelID)
          break label511;
      }
    }
    label322: label375: label504: label511: for (Object localObject6 = localConnectLine2.mAllocation; ; localObject6 = localObject1)
    {
      localObject1 = localObject6;
      break label262;
      IO[] arrayOfIO1 = this.mInputs;
      int j = arrayOfIO1.length;
      int k = 0;
      IO localIO2;
      if (k < j)
      {
        localIO2 = arrayOfIO1[k];
        if (localIO2.mKID != localKernelID)
          break label504;
      }
      for (Object localObject5 = localIO2.mAllocation; ; localObject5 = localObject1)
      {
        k++;
        localObject1 = localObject5;
        break label322;
        Iterator localIterator4 = localNode1.mOutputs.iterator();
        Object localObject2 = null;
        ConnectLine localConnectLine1;
        if (localIterator4.hasNext())
        {
          localConnectLine1 = (ConnectLine)localIterator4.next();
          if (localConnectLine1.mFrom != localKernelID)
            break label497;
        }
        for (Object localObject4 = localConnectLine1.mAllocation; ; localObject4 = localObject2)
        {
          localObject2 = localObject4;
          break label375;
          IO[] arrayOfIO2 = this.mOutputs;
          int m = arrayOfIO2.length;
          Object localObject3 = localObject2;
          for (int n = 0; n < m; n++)
          {
            IO localIO1 = arrayOfIO2[n];
            if (localIO1.mKID == localKernelID)
              localObject3 = localIO1.mAllocation;
          }
          localKernelID.mScript.forEach(localKernelID.mSlot, localObject1, (Allocation)localObject3, null);
          break label228;
          break;
        }
      }
    }
  }

  public Object[] execute(Object[] paramArrayOfObject)
  {
    int i = 0;
    if (paramArrayOfObject.length < this.mInputs2.size())
    {
      Log.e("ScriptGroup", toString() + " receives " + paramArrayOfObject.length + " inputs, less than expected " + this.mInputs2.size());
      return null;
    }
    if (paramArrayOfObject.length > this.mInputs2.size())
      Log.i("ScriptGroup", toString() + " receives " + paramArrayOfObject.length + " inputs, more than expected " + this.mInputs2.size());
    for (int j = 0; j < this.mInputs2.size(); j++)
    {
      Object localObject2 = paramArrayOfObject[j];
      if (((localObject2 instanceof Future)) || ((localObject2 instanceof Input)))
      {
        Log.e("ScriptGroup", toString() + ": input " + j + " is a future or unbound value");
        return null;
      }
      ((Input)this.mInputs2.get(j)).set(localObject2);
    }
    this.mRS.nScriptGroup2Execute(getID(this.mRS));
    Object[] arrayOfObject = new Object[this.mOutputs2.length];
    Future[] arrayOfFuture = this.mOutputs2;
    int k = arrayOfFuture.length;
    int n;
    for (int m = 0; i < k; m = n)
    {
      Object localObject1 = arrayOfFuture[i].getValue();
      if ((localObject1 instanceof Input))
        localObject1 = ((Input)localObject1).get();
      n = m + 1;
      arrayOfObject[m] = localObject1;
      i++;
    }
    return arrayOfObject;
  }

  @Deprecated
  public void setInput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    for (int i = 0; i < this.mInputs.length; i++)
      if (this.mInputs[i].mKID == paramKernelID)
      {
        this.mInputs[i].mAllocation = paramAllocation;
        if (!this.mUseIncSupp)
          this.mRS.nScriptGroupSetInput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
    throw new RSIllegalArgumentException("Script not found");
  }

  @Deprecated
  public void setOutput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    for (int i = 0; i < this.mOutputs.length; i++)
      if (this.mOutputs[i].mKID == paramKernelID)
      {
        this.mOutputs[i].mAllocation = paramAllocation;
        if (!this.mUseIncSupp)
          this.mRS.nScriptGroupSetOutput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
    throw new RSIllegalArgumentException("Script not found");
  }

  public static final class Binding
  {
    private final Script.FieldID mField;
    private final Object mValue;

    public Binding(Script.FieldID paramFieldID, Object paramObject)
    {
      this.mField = paramFieldID;
      this.mValue = paramObject;
    }

    public Script.FieldID getField()
    {
      return this.mField;
    }

    public Object getValue()
    {
      return this.mValue;
    }
  }

  @Deprecated
  public static final class Builder
  {
    private int mKernelCount;
    private ArrayList<ScriptGroup.ConnectLine> mLines = new ArrayList();
    private ArrayList<ScriptGroup.Node> mNodes = new ArrayList();
    private RenderScript mRS;
    private boolean mUseIncSupp = false;

    public Builder(RenderScript paramRenderScript)
    {
      this.mRS = paramRenderScript;
    }

    private boolean calcOrder()
    {
      Iterator localIterator1 = this.mNodes.iterator();
      boolean bool1 = true;
      ScriptGroup.Node localNode;
      if (localIterator1.hasNext())
      {
        localNode = (ScriptGroup.Node)localIterator1.next();
        if (localNode.mInputs.size() != 0)
          break label108;
        Iterator localIterator2 = this.mNodes.iterator();
        while (localIterator2.hasNext())
          ((ScriptGroup.Node)localIterator2.next()).mSeen = false;
      }
      label108: for (boolean bool2 = bool1 & calcOrderRecurse(localNode, 1); ; bool2 = bool1)
      {
        bool1 = bool2;
        break;
        Collections.sort(this.mNodes, new Comparator()
        {
          public int compare(ScriptGroup.Node paramAnonymousNode1, ScriptGroup.Node paramAnonymousNode2)
          {
            return paramAnonymousNode1.mOrder - paramAnonymousNode2.mOrder;
          }
        });
        return bool1;
      }
    }

    private boolean calcOrderRecurse(ScriptGroup.Node paramNode, int paramInt)
    {
      paramNode.mSeen = true;
      if (paramNode.mOrder < paramInt)
        paramNode.mOrder = paramInt;
      Iterator localIterator = paramNode.mOutputs.iterator();
      boolean bool = true;
      while (true)
      {
        ScriptGroup.ConnectLine localConnectLine;
        if (localIterator.hasNext())
        {
          localConnectLine = (ScriptGroup.ConnectLine)localIterator.next();
          if (localConnectLine.mToF == null)
            break label85;
        }
        label85: for (ScriptGroup.Node localNode = findNode(localConnectLine.mToF.mScript); localNode.mSeen; localNode = findNode(localConnectLine.mToK.mScript))
        {
          bool = false;
          return bool;
        }
        bool &= calcOrderRecurse(localNode, 1 + paramNode.mOrder);
      }
    }

    private ScriptGroup.Node findNode(Script.KernelID paramKernelID)
    {
      for (int i = 0; i < this.mNodes.size(); i++)
      {
        ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(i);
        for (int j = 0; j < localNode.mKernels.size(); j++)
          if (paramKernelID == localNode.mKernels.get(j))
            return localNode;
      }
      return null;
    }

    private ScriptGroup.Node findNode(Script paramScript)
    {
      for (int i = 0; i < this.mNodes.size(); i++)
        if (paramScript == ((ScriptGroup.Node)this.mNodes.get(i)).mScript)
          return (ScriptGroup.Node)this.mNodes.get(i);
      return null;
    }

    private void mergeDAGs(int paramInt1, int paramInt2)
    {
      for (int i = 0; i < this.mNodes.size(); i++)
        if (((ScriptGroup.Node)this.mNodes.get(i)).dagNumber == paramInt2)
          ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = paramInt1;
    }

    private void validateCycle(ScriptGroup.Node paramNode1, ScriptGroup.Node paramNode2)
    {
      for (int i = 0; i < paramNode1.mOutputs.size(); i++)
      {
        ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)paramNode1.mOutputs.get(i);
        if (localConnectLine.mToK != null)
        {
          ScriptGroup.Node localNode2 = findNode(localConnectLine.mToK.mScript);
          if (localNode2.equals(paramNode2))
            throw new RSInvalidStateException("Loops in group not allowed.");
          validateCycle(localNode2, paramNode2);
        }
        if (localConnectLine.mToF != null)
        {
          ScriptGroup.Node localNode1 = findNode(localConnectLine.mToF.mScript);
          if (localNode1.equals(paramNode2))
            throw new RSInvalidStateException("Loops in group not allowed.");
          validateCycle(localNode1, paramNode2);
        }
      }
    }

    private void validateDAG()
    {
      int i = 0;
      for (int j = 0; j < this.mNodes.size(); j++)
      {
        ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(j);
        if (localNode.mInputs.size() == 0)
        {
          if ((localNode.mOutputs.size() == 0) && (this.mNodes.size() > 1))
            throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
          validateDAGRecurse(localNode, j + 1);
        }
      }
      int k = ((ScriptGroup.Node)this.mNodes.get(0)).dagNumber;
      while (i < this.mNodes.size())
      {
        if (((ScriptGroup.Node)this.mNodes.get(i)).dagNumber != k)
          throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
        i++;
      }
    }

    private void validateDAGRecurse(ScriptGroup.Node paramNode, int paramInt)
    {
      if ((paramNode.dagNumber != 0) && (paramNode.dagNumber != paramInt))
        mergeDAGs(paramNode.dagNumber, paramInt);
      while (true)
      {
        return;
        paramNode.dagNumber = paramInt;
        for (int i = 0; i < paramNode.mOutputs.size(); i++)
        {
          ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)paramNode.mOutputs.get(i);
          if (localConnectLine.mToK != null)
            validateDAGRecurse(findNode(localConnectLine.mToK.mScript), paramInt);
          if (localConnectLine.mToF != null)
            validateDAGRecurse(findNode(localConnectLine.mToF.mScript), paramInt);
        }
      }
    }

    public Builder addConnection(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
    {
      ScriptGroup.Node localNode1 = findNode(paramKernelID);
      if (localNode1 == null)
        throw new RSInvalidStateException("From script not found.");
      ScriptGroup.Node localNode2 = findNode(paramFieldID.mScript);
      if (localNode2 == null)
        throw new RSInvalidStateException("To script not found.");
      ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID);
      this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID));
      localNode1.mOutputs.add(localConnectLine);
      localNode2.mInputs.add(localConnectLine);
      validateCycle(localNode1, localNode1);
      return this;
    }

    public Builder addConnection(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
    {
      ScriptGroup.Node localNode1 = findNode(paramKernelID1);
      if (localNode1 == null)
        throw new RSInvalidStateException("From script not found.");
      ScriptGroup.Node localNode2 = findNode(paramKernelID2);
      if (localNode2 == null)
        throw new RSInvalidStateException("To script not found.");
      ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2);
      this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2));
      localNode1.mOutputs.add(localConnectLine);
      localNode2.mInputs.add(localConnectLine);
      validateCycle(localNode1, localNode1);
      return this;
    }

    public Builder addKernel(Script.KernelID paramKernelID)
    {
      if (this.mLines.size() != 0)
        throw new RSInvalidStateException("Kernels may not be added once connections exist.");
      if (paramKernelID.mScript.isIncSupp())
        this.mUseIncSupp = true;
      if (findNode(paramKernelID) != null)
        return this;
      this.mKernelCount = (1 + this.mKernelCount);
      ScriptGroup.Node localNode = findNode(paramKernelID.mScript);
      if (localNode == null)
      {
        localNode = new ScriptGroup.Node(paramKernelID.mScript);
        this.mNodes.add(localNode);
      }
      localNode.mKernels.add(paramKernelID);
      return this;
    }

    public ScriptGroup create()
    {
      if (this.mNodes.size() == 0)
        throw new RSInvalidStateException("Empty script groups are not allowed");
      for (int i = 0; i < this.mNodes.size(); i++)
        ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = 0;
      validateDAG();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      long[] arrayOfLong1 = new long[this.mKernelCount];
      int j = 0;
      int k = 0;
      while (k < this.mNodes.size())
      {
        ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(k);
        int i2 = 0;
        int i4;
        for (int i3 = j; i2 < localNode.mKernels.size(); i3 = i4)
        {
          Script.KernelID localKernelID = (Script.KernelID)localNode.mKernels.get(i2);
          i4 = i3 + 1;
          arrayOfLong1[i3] = localKernelID.getID(this.mRS);
          int i5 = 0;
          int i6 = 0;
          for (int i7 = 0; i7 < localNode.mInputs.size(); i7++)
            if (((ScriptGroup.ConnectLine)localNode.mInputs.get(i7)).mToK == localKernelID)
              i6 = 1;
          for (int i8 = 0; i8 < localNode.mOutputs.size(); i8++)
            if (((ScriptGroup.ConnectLine)localNode.mOutputs.get(i8)).mFrom == localKernelID)
              i5 = 1;
          if (i6 == 0)
            localArrayList1.add(new ScriptGroup.IO(localKernelID));
          if (i5 == 0)
            localArrayList2.add(new ScriptGroup.IO(localKernelID));
          i2++;
        }
        k++;
        j = i3;
      }
      if (j != this.mKernelCount)
        throw new RSRuntimeException("Count mismatch, should not happen.");
      long l;
      if (!this.mUseIncSupp)
      {
        long[] arrayOfLong2 = new long[this.mLines.size()];
        long[] arrayOfLong3 = new long[this.mLines.size()];
        long[] arrayOfLong4 = new long[this.mLines.size()];
        long[] arrayOfLong5 = new long[this.mLines.size()];
        for (int i1 = 0; i1 < this.mLines.size(); i1++)
        {
          ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)this.mLines.get(i1);
          arrayOfLong2[i1] = localConnectLine.mFrom.getID(this.mRS);
          if (localConnectLine.mToK != null)
            arrayOfLong3[i1] = localConnectLine.mToK.getID(this.mRS);
          if (localConnectLine.mToF != null)
            arrayOfLong4[i1] = localConnectLine.mToF.getID(this.mRS);
          arrayOfLong5[i1] = localConnectLine.mAllocationType.getID(this.mRS);
        }
        l = this.mRS.nScriptGroupCreate(arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, arrayOfLong5);
        if (l == 0L)
          throw new RSRuntimeException("Object creation error, should not happen.");
      }
      else
      {
        calcOrder();
        l = 0L;
      }
      ScriptGroup localScriptGroup = new ScriptGroup(l, this.mRS);
      localScriptGroup.mOutputs = new ScriptGroup.IO[localArrayList2.size()];
      for (int m = 0; m < localArrayList2.size(); m++)
        localScriptGroup.mOutputs[m] = ((ScriptGroup.IO)localArrayList2.get(m));
      localScriptGroup.mInputs = new ScriptGroup.IO[localArrayList1.size()];
      for (int n = 0; n < localArrayList1.size(); n++)
        localScriptGroup.mInputs[n] = ((ScriptGroup.IO)localArrayList1.get(n));
      ScriptGroup.access$002(localScriptGroup, this.mNodes);
      ScriptGroup.access$102(localScriptGroup, this.mUseIncSupp);
      return localScriptGroup;
    }
  }

  public static final class Builder2
  {
    private static final String TAG = "ScriptGroup.Builder2";
    List<ScriptGroup.Closure> mClosures;
    List<ScriptGroup.Input> mInputs;
    RenderScript mRS;

    public Builder2(RenderScript paramRenderScript)
    {
      this.mRS = paramRenderScript;
      this.mClosures = new ArrayList();
      this.mInputs = new ArrayList();
    }

    private ScriptGroup.Closure addInvokeInternal(Script.InvokeID paramInvokeID, Object[] paramArrayOfObject, Map<Script.FieldID, Object> paramMap)
    {
      ScriptGroup.Closure localClosure = new ScriptGroup.Closure(this.mRS, paramInvokeID, paramArrayOfObject, paramMap);
      this.mClosures.add(localClosure);
      return localClosure;
    }

    private ScriptGroup.Closure addKernelInternal(Script.KernelID paramKernelID, Type paramType, Object[] paramArrayOfObject, Map<Script.FieldID, Object> paramMap)
    {
      ScriptGroup.Closure localClosure = new ScriptGroup.Closure(this.mRS, paramKernelID, paramType, paramArrayOfObject, paramMap);
      this.mClosures.add(localClosure);
      return localClosure;
    }

    private boolean seperateArgsAndBindings(Object[] paramArrayOfObject, ArrayList<Object> paramArrayList, Map<Script.FieldID, Object> paramMap)
    {
      int i = 0;
      int j;
      if (i < paramArrayOfObject.length)
        if ((paramArrayOfObject[i] instanceof ScriptGroup.Binding))
          j = i;
      while (true)
      {
        if (j < paramArrayOfObject.length)
        {
          if (!(paramArrayOfObject[j] instanceof ScriptGroup.Binding))
          {
            return false;
            paramArrayList.add(paramArrayOfObject[i]);
            i++;
            break;
          }
          ScriptGroup.Binding localBinding = (ScriptGroup.Binding)paramArrayOfObject[j];
          paramMap.put(localBinding.getField(), localBinding.getValue());
          j++;
          continue;
        }
        return true;
        j = i;
      }
    }

    public ScriptGroup.Input addInput()
    {
      ScriptGroup.Input localInput = new ScriptGroup.Input();
      this.mInputs.add(localInput);
      return localInput;
    }

    public ScriptGroup.Closure addInvoke(Script.InvokeID paramInvokeID, Object[] paramArrayOfObject)
    {
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      if (!seperateArgsAndBindings(paramArrayOfObject, localArrayList, localHashMap))
        return null;
      return addInvokeInternal(paramInvokeID, localArrayList.toArray(), localHashMap);
    }

    public ScriptGroup.Closure addKernel(Script.KernelID paramKernelID, Type paramType, Object[] paramArrayOfObject)
    {
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      if (!seperateArgsAndBindings(paramArrayOfObject, localArrayList, localHashMap))
        return null;
      return addKernelInternal(paramKernelID, paramType, localArrayList.toArray(), localHashMap);
    }

    public ScriptGroup create(String paramString, ScriptGroup.Future[] paramArrayOfFuture)
    {
      if ((paramString == null) || (paramString.isEmpty()) || (paramString.length() > 100) || (!paramString.equals(paramString.replaceAll("[^a-zA-Z0-9-]", "_"))))
        throw new RSIllegalArgumentException("invalid script group name");
      return new ScriptGroup(this.mRS, paramString, this.mClosures, this.mInputs, paramArrayOfFuture);
    }
  }

  public static final class Closure extends BaseObj
  {
    private static final String TAG = "Closure";
    private Object[] mArgs;
    private Map<Script.FieldID, Object> mBindings;
    private FieldPacker mFP;
    private Map<Script.FieldID, ScriptGroup.Future> mGlobalFuture;
    private ScriptGroup.Future mReturnFuture;
    private Allocation mReturnValue;

    Closure(long paramLong, RenderScript paramRenderScript)
    {
      super(paramRenderScript);
    }

    Closure(RenderScript paramRenderScript, Script.InvokeID paramInvokeID, Object[] paramArrayOfObject, Map<Script.FieldID, Object> paramMap)
    {
      super(paramRenderScript);
      if ((Build.VERSION.SDK_INT < 23) && (paramRenderScript.isUseNative()))
        throw new RSRuntimeException("ScriptGroup2 not supported in this API level");
      this.mFP = FieldPacker.createFromArray(paramArrayOfObject);
      this.mArgs = paramArrayOfObject;
      this.mBindings = paramMap;
      this.mGlobalFuture = new HashMap();
      int i = paramMap.size();
      long[] arrayOfLong1 = new long[i];
      long[] arrayOfLong2 = new long[i];
      int[] arrayOfInt = new int[i];
      long[] arrayOfLong3 = new long[i];
      long[] arrayOfLong4 = new long[i];
      int j = 0;
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject = localEntry.getValue();
        Script.FieldID localFieldID = (Script.FieldID)localEntry.getKey();
        arrayOfLong1[j] = localFieldID.getID(paramRenderScript);
        retrieveValueAndDependenceInfo(paramRenderScript, j, localFieldID, localObject, arrayOfLong2, arrayOfInt, arrayOfLong3, arrayOfLong4);
        j++;
      }
      setID(paramRenderScript.nInvokeClosureCreate(paramInvokeID.getID(paramRenderScript), this.mFP.getData(), arrayOfLong1, arrayOfLong2, arrayOfInt));
    }

    Closure(RenderScript paramRenderScript, Script.KernelID paramKernelID, Type paramType, Object[] paramArrayOfObject, Map<Script.FieldID, Object> paramMap)
    {
      super(paramRenderScript);
      if ((Build.VERSION.SDK_INT < 23) && (paramRenderScript.isUseNative()))
        throw new RSRuntimeException("ScriptGroup2 not supported in this API level");
      this.mArgs = paramArrayOfObject;
      this.mReturnValue = Allocation.createTyped(paramRenderScript, paramType);
      this.mBindings = paramMap;
      this.mGlobalFuture = new HashMap();
      int i = paramArrayOfObject.length + paramMap.size();
      long[] arrayOfLong1 = new long[i];
      long[] arrayOfLong2 = new long[i];
      int[] arrayOfInt = new int[i];
      long[] arrayOfLong3 = new long[i];
      long[] arrayOfLong4 = new long[i];
      for (int j = 0; j < paramArrayOfObject.length; j++)
      {
        arrayOfLong1[j] = 0L;
        retrieveValueAndDependenceInfo(paramRenderScript, j, null, paramArrayOfObject[j], arrayOfLong2, arrayOfInt, arrayOfLong3, arrayOfLong4);
      }
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject = localEntry.getValue();
        Script.FieldID localFieldID = (Script.FieldID)localEntry.getKey();
        arrayOfLong1[j] = localFieldID.getID(paramRenderScript);
        retrieveValueAndDependenceInfo(paramRenderScript, j, localFieldID, localObject, arrayOfLong2, arrayOfInt, arrayOfLong3, arrayOfLong4);
        j++;
      }
      setID(paramRenderScript.nClosureCreate(paramKernelID.getID(paramRenderScript), this.mReturnValue.getID(paramRenderScript), arrayOfLong1, arrayOfLong2, arrayOfInt, arrayOfLong3, arrayOfLong4));
    }

    private void retrieveValueAndDependenceInfo(RenderScript paramRenderScript, int paramInt, Script.FieldID paramFieldID, Object paramObject, long[] paramArrayOfLong1, int[] paramArrayOfInt, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
    {
      long l;
      Object localObject1;
      label65: ScriptGroup.Input localInput;
      if ((paramObject instanceof ScriptGroup.Future))
      {
        ScriptGroup.Future localFuture = (ScriptGroup.Future)paramObject;
        Object localObject2 = localFuture.getValue();
        paramArrayOfLong2[paramInt] = localFuture.getClosure().getID(paramRenderScript);
        Script.FieldID localFieldID = localFuture.getFieldID();
        if (localFieldID != null)
        {
          l = localFieldID.getID(paramRenderScript);
          paramArrayOfLong3[paramInt] = l;
          localObject1 = localObject2;
          if (!(localObject1 instanceof ScriptGroup.Input))
            break label140;
          localInput = (ScriptGroup.Input)localObject1;
          if (paramInt >= this.mArgs.length)
            break label130;
          localInput.addReference(this, paramInt);
        }
      }
      while (true)
      {
        paramArrayOfLong1[paramInt] = 0L;
        paramArrayOfInt[paramInt] = 0;
        return;
        l = 0L;
        break;
        paramArrayOfLong2[paramInt] = 0L;
        paramArrayOfLong3[paramInt] = 0L;
        localObject1 = paramObject;
        break label65;
        label130: localInput.addReference(this, paramFieldID);
      }
      label140: ValueAndSize localValueAndSize = new ValueAndSize(paramRenderScript, localObject1);
      paramArrayOfLong1[paramInt] = localValueAndSize.value;
      paramArrayOfInt[paramInt] = localValueAndSize.size;
    }

    public ScriptGroup.Future getGlobal(Script.FieldID paramFieldID)
    {
      Object localObject1 = (ScriptGroup.Future)this.mGlobalFuture.get(paramFieldID);
      if (localObject1 == null)
      {
        Object localObject2 = this.mBindings.get(paramFieldID);
        if ((localObject2 instanceof ScriptGroup.Future))
          localObject2 = ((ScriptGroup.Future)localObject2).getValue();
        ScriptGroup.Future localFuture = new ScriptGroup.Future(this, paramFieldID, localObject2);
        this.mGlobalFuture.put(paramFieldID, localFuture);
        localObject1 = localFuture;
      }
      return localObject1;
    }

    public ScriptGroup.Future getReturn()
    {
      if (this.mReturnFuture == null)
        this.mReturnFuture = new ScriptGroup.Future(this, null, this.mReturnValue);
      return this.mReturnFuture;
    }

    void setArg(int paramInt, Object paramObject)
    {
      if ((paramObject instanceof ScriptGroup.Future))
        paramObject = ((ScriptGroup.Future)paramObject).getValue();
      this.mArgs[paramInt] = paramObject;
      ValueAndSize localValueAndSize = new ValueAndSize(this.mRS, paramObject);
      this.mRS.nClosureSetArg(getID(this.mRS), paramInt, localValueAndSize.value, localValueAndSize.size);
    }

    void setGlobal(Script.FieldID paramFieldID, Object paramObject)
    {
      if ((paramObject instanceof ScriptGroup.Future))
        paramObject = ((ScriptGroup.Future)paramObject).getValue();
      this.mBindings.put(paramFieldID, paramObject);
      ValueAndSize localValueAndSize = new ValueAndSize(this.mRS, paramObject);
      this.mRS.nClosureSetGlobal(getID(this.mRS), paramFieldID.getID(this.mRS), localValueAndSize.value, localValueAndSize.size);
    }

    private static final class ValueAndSize
    {
      public int size;
      public long value;

      public ValueAndSize(RenderScript paramRenderScript, Object paramObject)
      {
        if ((paramObject instanceof Allocation))
        {
          this.value = ((Allocation)paramObject).getID(paramRenderScript);
          this.size = -1;
        }
        do
        {
          return;
          if ((paramObject instanceof Boolean))
          {
            if (((Boolean)paramObject).booleanValue());
            for (long l = 1L; ; l = 0L)
            {
              this.value = l;
              this.size = 4;
              return;
            }
          }
          if ((paramObject instanceof Integer))
          {
            this.value = ((Integer)paramObject).longValue();
            this.size = 4;
            return;
          }
          if ((paramObject instanceof Long))
          {
            this.value = ((Long)paramObject).longValue();
            this.size = 8;
            return;
          }
          if ((paramObject instanceof Float))
          {
            this.value = Float.floatToRawIntBits(((Float)paramObject).floatValue());
            this.size = 4;
            return;
          }
        }
        while (!(paramObject instanceof Double));
        this.value = Double.doubleToRawLongBits(((Double)paramObject).doubleValue());
        this.size = 8;
      }
    }
  }

  static class ConnectLine
  {
    Allocation mAllocation;
    Type mAllocationType;
    Script.KernelID mFrom;
    Script.FieldID mToF;
    Script.KernelID mToK;

    ConnectLine(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
    {
      this.mFrom = paramKernelID;
      this.mToF = paramFieldID;
      this.mAllocationType = paramType;
    }

    ConnectLine(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
    {
      this.mFrom = paramKernelID1;
      this.mToK = paramKernelID2;
      this.mAllocationType = paramType;
    }
  }

  public static final class Future
  {
    ScriptGroup.Closure mClosure;
    Script.FieldID mFieldID;
    Object mValue;

    Future(ScriptGroup.Closure paramClosure, Script.FieldID paramFieldID, Object paramObject)
    {
      this.mClosure = paramClosure;
      this.mFieldID = paramFieldID;
      this.mValue = paramObject;
    }

    ScriptGroup.Closure getClosure()
    {
      return this.mClosure;
    }

    Script.FieldID getFieldID()
    {
      return this.mFieldID;
    }

    Object getValue()
    {
      return this.mValue;
    }
  }

  static class IO
  {
    Allocation mAllocation;
    Script.KernelID mKID;

    IO(Script.KernelID paramKernelID)
    {
      this.mKID = paramKernelID;
    }
  }

  public static final class Input
  {
    List<Pair<ScriptGroup.Closure, Integer>> mArgIndex = new ArrayList();
    List<Pair<ScriptGroup.Closure, Script.FieldID>> mFieldID = new ArrayList();
    Object mValue;

    void addReference(ScriptGroup.Closure paramClosure, int paramInt)
    {
      this.mArgIndex.add(Pair.create(paramClosure, Integer.valueOf(paramInt)));
    }

    void addReference(ScriptGroup.Closure paramClosure, Script.FieldID paramFieldID)
    {
      this.mFieldID.add(Pair.create(paramClosure, paramFieldID));
    }

    Object get()
    {
      return this.mValue;
    }

    void set(Object paramObject)
    {
      this.mValue = paramObject;
      Iterator localIterator1 = this.mArgIndex.iterator();
      while (localIterator1.hasNext())
      {
        Pair localPair2 = (Pair)localIterator1.next();
        ((ScriptGroup.Closure)localPair2.first).setArg(((Integer)localPair2.second).intValue(), paramObject);
      }
      Iterator localIterator2 = this.mFieldID.iterator();
      while (localIterator2.hasNext())
      {
        Pair localPair1 = (Pair)localIterator2.next();
        ((ScriptGroup.Closure)localPair1.first).setGlobal((Script.FieldID)localPair1.second, paramObject);
      }
    }
  }

  static class Node
  {
    int dagNumber;
    ArrayList<ScriptGroup.ConnectLine> mInputs = new ArrayList();
    ArrayList<Script.KernelID> mKernels = new ArrayList();
    Node mNext;
    int mOrder;
    ArrayList<ScriptGroup.ConnectLine> mOutputs = new ArrayList();
    Script mScript;
    boolean mSeen;

    Node(Script paramScript)
    {
      this.mScript = paramScript;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroup
 * JD-Core Version:    0.6.2
 */