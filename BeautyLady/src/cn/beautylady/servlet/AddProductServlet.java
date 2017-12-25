package cn.beautylady.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.beautylady.entity.NewProduct;
import cn.beautylady.entity.Pic;
import cn.beautylady.entity.Product;
import cn.beautylady.service.AddProductService;
import cn.beautylady.service.impl.AddProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/servlet/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		AddProductService service = new AddProductServiceImpl();
		FileItemFactory factory = new DiskFileItemFactory();//创建DiskFileItemFactory工厂
		((DiskFileItemFactory)factory).setSizeThreshold(1024*100);
		ServletFileUpload upload = new ServletFileUpload(factory);//创建上传文件解析器
		upload.setFileSizeMax(1024*1024*100);
		upload.setSizeMax(1024*1024*1024); 
		upload.setProgressListener(new ProgressListener() {//监听文件上传进度
			
			@Override
			public void update(long arg0, long arg1, int arg2) {
				System.out.println("文件大小为："+arg1+"，当前已处理："+arg0);
				
			}
		});
		upload.setHeaderEncoding("UTF-8");//解决上传文件名中文乱码
		//判断是否为表单提交
		if(!ServletFileUpload.isMultipartContent(request)){
			return;
		}
	    try {
	        List<FileItem> items = upload.parseRequest(request);
	        List<Pic> picList = new ArrayList<>();
	    	NewProduct newProduct = new NewProduct();
	    	newProduct.setCreatedBy(items.get(0).getString("UTF-8"));
	    	newProduct.setProductNo(items.get(1).getString("UTF-8"));
	    	newProduct.setProductName(items.get(2).getString("UTF-8"));
	    	newProduct.setCostPrice(Double.parseDouble(items.get(3).getString("UTF-8")));
	    	newProduct.setTagPrice(Double.parseDouble(items.get(4).getString("UTF-8")));
	    	newProduct.setYear(Integer.parseInt(items.get(5).getString("UTF-8")));
	    	newProduct.setQuarter(Integer.parseInt(items.get(6).getString("UTF-8")));
	    	newProduct.setCategoryNo(items.get(7).getString("UTF-8"));
	    	newProduct.setSubclassesNo(items.get(9).getString("UTF-8"));
	    	newProduct.setColorNo1(items.get(11).getString("UTF-8"));
	    	newProduct.setColorNo2(items.get(13).getString("UTF-8"));
	    	newProduct.setSizeNo(items.get(15).getString("UTF-8"));
	    	newProduct.setBandNo(items.get(17).getString("UTF-8"));
	    	newProduct.setThemeNo(items.get(19).getString("UTF-8"));
	    	newProduct.setSeriesNo(items.get(21).getString("UTF-8"));
	    	String productNo = newProduct.getProductNo();
	    	String colorNo = newProduct.getColorNo1();
	    	String userName = "";//创建者
	    	String fileName  = "";//文件名
	    	boolean flag = true;//判断是否上传图片为主页图片
	    	Properties prop = new Properties();
	    	InputStream is = getClass().getClassLoader().getResourceAsStream("savePath.properties");
	    	prop.load(is);
	    	is.close();
	    	String path = prop.getProperty("workspacePath");
	    	File file = new File(path + "\\WebContent\\images\\" +newProduct.getProductNo()+"\\"+ newProduct.getColorNo1());
	    	file.mkdirs();
	    	file.setWritable(true);
	    	for (FileItem item : items) {
				if("userName".equals(item.getFieldName())){
					userName = item.getString();
				}
				if(!item.isFormField()){
					if("mainpic".equals(item.getFieldName())){
						fileName = newProduct.getMainpic() + item.getName().substring(item.getName().lastIndexOf("."));
						File file1 = new File(path + "\\WebContent\\images\\" +fileName);
						newProduct.setMainpic(fileName);
						item.write(file1);
						flag = false;
					}
					if(!flag){
						if("pic1".equals(item.getFieldName())){
							fileName = newProduct.getPic1() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("pic2".equals(item.getFieldName())){
							fileName = newProduct.getPic2() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("pic3".equals(item.getFieldName())){
							fileName = newProduct.getPic3() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("pic4".equals(item.getFieldName())){
							fileName = newProduct.getPic4() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("detailpic1".equals(item.getFieldName())){
							fileName = newProduct.getDetailpic1() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("detailpic2".equals(item.getFieldName())){
							fileName = newProduct.getDetailpic2() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("detailpic3".equals(item.getFieldName())){
							fileName = newProduct.getDetailpic3() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("magnifypic1".equals(item.getFieldName())){
							fileName = newProduct.getMagnifypic1() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("magnifypic2".equals(item.getFieldName())){
							fileName = newProduct.getMagnifypic2() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("colorpic1".equals(item.getFieldName())){
							fileName = newProduct.getColorpic1() + item.getName().substring(item.getName().lastIndexOf("."));
						}else if("colorpic2".equals(item.getFieldName())){
							fileName = newProduct.getColorpic2() + item.getName().substring(item.getName().lastIndexOf("."));
						}
						File file2 = new File(file.getPath()+"\\"+fileName);
						item.write(file2);
						picList.add(new Pic(productNo,colorNo,fileName));//添加图片信息
					}
				}
			}
	    	newProduct.setCreatedBy(userName);//获取创建者姓名
	    	newProduct.setPicList(picList);
	    	NewProduct findProduct = service.findNewProduct(newProduct);
	    	int count = -1;
	    	if(findProduct == null){
	    		count = service.addNewProduct(newProduct);
	    	}else{
	    		count = service.addDiffColorProduct(newProduct);
	    	}
	    	if(count == 3){
	    		out.print("新增成功");
	    	}else{
	    		out.print("新增失败");
	    	}
	    	response.sendRedirect("../backstage/backstage.jsp");
	    }catch(Exception e){
	    	System.out.println("文件上传失败");
	    	e.printStackTrace();
	    }finally{
	    	System.out.println("文件上传成功");
	    }
	    
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
