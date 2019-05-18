package cn.sdcet.shop.web;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.sdcet.shop.dao.ItemDao;
import cn.sdcet.shop.dao.jdbc.pinglunDaoJDBCImpl;

import cn.sdcet.shop.dao.jdbc.ItemDaoJDBCImpl;
import cn.sdcet.shop.domain.Item;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class rootAddItem extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������webroot�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
		request.setCharacterEncoding("UTF-8");
		String a = "";
		String b = "";
		String c = "";
		int count = 0;
		String message = "";
		String filename =null;
        String savePath = this.getServletContext().getRealPath("/images");
        File file = new File(savePath);
        //�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ����");
            //����Ŀ¼
            file.mkdir();
        }
		boolean flag=ServletFileUpload.isMultipartContent(request);
		try {
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			//����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8"); 
			List<FileItem> lstForms=upload.parseRequest(request);
			for (FileItem fileItem : lstForms) {
				//�ж�ÿһ����Ԫ���Ƿ�����ͨ��
				if(fileItem.isFormField()){
					if(count == 0){
						a = fileItem.getString();
						a=new String(a.getBytes("ISO-8859-1"),"UTF-8");
						
						
						

						System.out.println("a1="+a);
					}else if(count == 1){
						b = fileItem.getString("UTF-8");
					}else if(count == 2){
						c = fileItem.getString("UTF-8");
					}
					count++;
				}else{
					//�õ��ϴ����ļ����ƣ�
					filename =fileItem.getName();
					//ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
					//�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					//��ȡitem�е��ϴ��ļ���������
					InputStream in = fileItem.getInputStream();
					//����һ���ļ������
					FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);

					//����һ��������
					byte buffer[] = new byte[1024];
					//�ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					//ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
					while((len=in.read(buffer))>0){
						//ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
						out.write(buffer, 0, len);
					}
					//good.setImg(filename);
					//�ر�������
					in.close();
					//�ر������
					out.close();
					//ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					fileItem.delete();
					message = "�ļ��ϴ��ɹ���";
					System.out.println("�ϴ��ɹ�!");
				}
			} 
		}catch (FileUploadException e1) {
			message= "�ļ��ϴ�ʧ�ܣ�";
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String name = a;
		System.out.println("name="+name);
		String price = c;
		int p=Integer.parseInt(price);
		String pref =filename;
		String catalogid=b;
		int catalog = Integer.parseInt(catalogid);
		try {

			ItemDaoJDBCImpl dao =new ItemDaoJDBCImpl();
			boolean check = dao.addcheck(name);
			System.out.println(check);
			if (check == true) {
				Item item = new Item();

				item.setName(name);
				item.setPrice(p);
				item.setPref(pref);
				item.setCatalogid(catalog);

				dao.rootAddDao(item);
				response.sendRedirect("admin/list.jsp");
			}else{
				request.setAttribute("message", "��Ʒ����ע�ᣡ");
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/add.jsp");
				dispatcher.forward(request, response);
			}			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��̨�����Ʒʧ�ܣ�");
		}
	}
}
