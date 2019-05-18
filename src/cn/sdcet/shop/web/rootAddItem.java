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
		 //得到上传文件的保存目录，将上传的文件存放于webroot下，不允许外界直接访问，保证上传文件的安全
		request.setCharacterEncoding("UTF-8");
		String a = "";
		String b = "";
		String c = "";
		int count = 0;
		String message = "";
		String filename =null;
        String savePath = this.getServletContext().getRealPath("/images");
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
		boolean flag=ServletFileUpload.isMultipartContent(request);
		try {
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			//解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8"); 
			List<FileItem> lstForms=upload.parseRequest(request);
			for (FileItem fileItem : lstForms) {
				//判断每一个表单元素是否是普通表单
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
					//得到上传的文件名称，
					filename =fileItem.getName();
					//注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					//获取item中的上传文件的输入流
					InputStream in = fileItem.getInputStream();
					//创建一个文件输出流
					FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);

					//创建一个缓冲区
					byte buffer[] = new byte[1024];
					//判断输入流中的数据是否已经读完的标识
					int len = 0;
					//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while((len=in.read(buffer))>0){
						//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
						out.write(buffer, 0, len);
					}
					//good.setImg(filename);
					//关闭输入流
					in.close();
					//关闭输出流
					out.close();
					//删除处理文件上传时生成的临时文件
					fileItem.delete();
					message = "文件上传成功！";
					System.out.println("上传成功!");
				}
			} 
		}catch (FileUploadException e1) {
			message= "文件上传失败！";
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
				request.setAttribute("message", "商品名已注册！");
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/add.jsp");
				dispatcher.forward(request, response);
			}			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("后台添加商品失败：");
		}
	}
}
