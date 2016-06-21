package com.example.cga2351.testksoapandroid;

/*
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

public class TestAxis2Creat {

	public static void main(String[] args) {
		getRPCServiceClient();
	}

	public static void getRPCServiceClient() {
		RPCServiceClient serviceClient;
		try {
			serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			// EndpointReference targetEPR = new
			// EndpointReference("http://192.168.1.20:8000/BMService.asmx?wsdl");
			EndpointReference targetEPR = new EndpointReference("http://192.168.169.155:8000/BMService.asmx?wsdl");
			options.setTo(targetEPR);

			// 指定sum方法的参数值
			// 指定sum方法返回值的数据类型的Class对象
			Class[] classesBoolean = new Class[]{boolean.class};
			Class[] classesString = new Class[]{String.class};

			ServiceClient sender = new ServiceClient();
			options.setAction("http://tempuri.org/AddPrescriptionToHomeDataBase");
			options.setProperty(HTTPConstants.CHUNKED, "false");// 设置不受限制.
			sender.setOptions(options);
			OMFactory fac = OMAbstractFactory.getOMFactory();
			OMNamespace omNs = fac.createOMNamespace("http://tempuri.org/", "");
			OMElement method = fac.createOMElement("AddPrescriptionToHomeDataBase", omNs);
			OMElement name = fac.createOMElement("str", omNs);// 设置入参名称
			name.setText("0003412454,文晶,1,55.00,13920067859,2,内服,07脑,073, 0734,7,3,180.0000000000000000,2065.000000000000000,2016-05-18,1000000080,0,111");// 设置入参值
			method.addChild(name);
			method.build();

			System.out.println("method：" + method.toString());
			OMElement response = sender.sendReceive(method);
			System.out.println("response:" + response);
			OMElement elementReturn = response.getFirstElement();
			System.out.println("cityCode:" + elementReturn.getText());
			// 查询委托单
//			Object[] opAddEntryArgs3 = new Object[]{"10000000001"};
//			QName opAddEntry3 = new QName("http://test.admin.zhongyi.xinglin.com", "GetPrescriptionByID");
//			System.out.println(serviceClient.invokeBlocking(opAddEntry3, opAddEntryArgs3, classesString)[0]);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
*/