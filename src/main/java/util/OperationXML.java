/**
 * 
 */
package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import data.User;

/**
 * @author jokin
 *ֻ�����������ڵ� Ӧ��������ǩ�� �˴���������һ���û���Ϣ�����ݣ��������д����user�����Ķ�����
 */
public class OperationXML {
	
	private static Document document;

	/**
	 * 
	 */
	public OperationXML() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<User> readXML(File dataFile ){
		//����һ��List�ļ��������ŵ��������͵Ķ��� ��Ϊread�ķ��������շ���ֵ
		List<User> userList = new ArrayList();
		
/*	  // ��ȡXML�ļ�����ȡ��document����               ����һ
		SAXReader sa = new SAXReader();
		try {
			document = sa.read(dataFile); //�˴�read()�����ж��ֹ���
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root = document.getRootElement();//��ȡ���ڵ�
		List<Element> oneChildElements = root.elements();//elements() Returns the elements contained in this element.
		//����ÿ����ǩ������ǩ�е�����
		for(int i=0;1<oneChildElements.size();i++){
			Element childElement = oneChildElements.get(i);
			List<Attribute> attributes = childElement.attributes();//��ȡÿ����ǩ�����Լ�
			for(int j=0;j<attributes.size();j++){
			Attribute attribute =attributes.get(j);
			System.out.println( attribute.getName() + ": " +  attribute.getValue());
			}	
		}*/
		
		//��������ʹ��Iterator�������ķ�ʽ������xml
		SAXReader sa = new SAXReader();
		try {
			document = sa.read(dataFile);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ȡ���ڵ�
		Element root = document.getRootElement();
		//ֱ�ӵ�ĳһ���ڵ���
		//List<Element> le=document.selectNodes("/Response/Main/Item");
		//��ȡԪ�ؽڵ�ĵ��������˴���ȡ���Ǹ��ڵ��
		Iterator<?>  iterator  =root.elementIterator();
		//whileѭ����ȡ���ڵ���ÿ�����Ե�ֵ
		while(iterator.hasNext()){//ѭ����õڶ�����ǩ��ֵ
			//����next()������ȡReturns the next element in the iteration.
			Element el= (Element)iterator.next();
			System.out.println(el.getName()+": id="+el.attribute(0).getStringValue());
			Iterator<?> iterator2=el.elementIterator();
			//����һ��User�������ͣ��û���Ŷ�ȡ����XML�е��ļ�����������һ��list������Ϊ�÷����ķ���ֵ
			User user = new User();
			user.setId(el.attribute(0).getStringValue());
			while(iterator2.hasNext()){//ѭ����ȡ����������ǩ��ֵ
				Element datas= (Element) iterator2.next();
				//System.out.println(datas.getName()+"��ֵ�ǣ�"+ datas.getStringValue());
				System.out.println(datas.getName()+"��ֵ�ǣ�"+ datas.getText());
				if("name".equals(datas.getName())){
					user.setName(datas.getText());
				}
				else {
					user.setPassword(datas.getText());
				}
			}
			//�����ɵ�user������뵽list����
			userList.add(user);
			
		}
		
		/*System.out.println(userList.get(0).getPassword());//�����������õĽ���Բ���
		System.out.println(userList.get(1).getPassword());*/
		return userList;
		
	}
	/**
	 * 
	 * @param file   Ҫ��XML�ļ����뵽�ĸ��ļ���
	 * @param document  ��Ҫ�����XML���ݵ�Document����
	 */
	//����һ���ļ��û��������ȡ�ĵ��Ľ��
	public static void writeXML(File file,Document document){
		FileWriter filewriter =null;
		OutputFormat outputFormat = new OutputFormat();//�������ļ����Զ�������ʽ��xmL��ʽ��
		outputFormat.setEncoding("UTF_8");//����������ı����ʽΪUTF_8��ʹ��֧������
		//��������ַ����ļ�
		try {
			 filewriter = new FileWriter(file);
			 XMLWriter xmlWriter = new XMLWriter(filewriter,outputFormat);
			xmlWriter.write(document);
			filewriter.close();//��ȻJava���Զ��ڴ���ջ��ƣ�������������ݿ����ӡ��������ӡ��ļ������ȣ�
			//��close�ǲ��ᱻ���յģ����ڲ���ȷ�Ĵ��롣�����finally������close����Ϊ��ʹ���������⣬��Щ����Ҳ�ܱ�����
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ĵ����ַ���д��XML�ĵ������쳣");
		}finally {
			System.out.print("����Ϣ�����ļ����");
		}
	}

}
