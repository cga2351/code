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

public class TestAxis2GetId {

	public static void main(String[] args) {
		getRPCServiceClient();
	}

	public static void getRPCServiceClient() {
		RPCServiceClient serviceClient;
		try {
			serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			EndpointReference targetEPR = new EndpointReference("http://192.168.169.155:8000/BMService.asmx?wsdl");
			// EndpointReference targetEPR = new
			// EndpointReference("http://192.168.1.20:8000/BMService.asmx?wsdl");
			options.setTo(targetEPR);

			// 指定sum方法的参数值
			// 指定sum方法返回值的数据类型的Class对象
			Class[] classesBoolean = new Class[]{boolean.class};
			Class[] classesString = new Class[]{String.class};

			ServiceClient sender = new ServiceClient();
			options.setAction("http://tempuri.org/GetDelegateFormId");
			options.setProperty(HTTPConstants.CHUNKED, "false");// 设置不受限制.
			sender.setOptions(options);
			OMFactory fac = OMAbstractFactory.getOMFactory();
			OMNamespace omNs = fac.createOMNamespace("http://tempuri.org/", "");
			OMElement method = fac.createOMElement("GetDelegateFormId", omNs);
			OMElement name1 = fac.createOMElement("clientId", omNs);// 设置入参名称
			name1.setText("10001");// 设置入参值
			OMElement name2 = fac.createOMElement("clientName", omNs);// 设置入参名称
			name2.setText("杏林");// 设置入参值
			method.addChild(name1);
			method.addChild(name2);
			method.build();

			System.out.println("method：" + method.toString());
			OMElement response = sender.sendReceive(method);
			System.out.println("response:" + response);
			OMElement elementReturn = response.getFirstElement();
			System.out.println("cityCode:" + elementReturn.getText());
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
*/