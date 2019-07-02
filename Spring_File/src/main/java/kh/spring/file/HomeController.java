package kh.spring.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import kh.spring.dto.DTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private HttpSession session ; //session에 저장된 realpath를 꺼내기위해서 사용된다 

	@RequestMapping("/")
	public String index() {
		return "home"; 
	}
	@RequestMapping("upload.do")
	public String uploadProc(HttpServletRequest request) { 
		//name값으로 받을 수는 있지만 자료형을 정하여 받기 애매하므로 request를 통하여 요청 정보를 받아준다 이 request를 받았지만 multipart로 보낸 것이기 때문에 Multipart로 자료형을 바꿔주어야한다
		
		String realPath=session.getServletContext().getRealPath("/");
		//getrealpath= 복사되는 경로 란??
		//서버를 실행하는 동시에 모든 이클립스의 자료들이 복사된다 복사되는 동시에 이클립스의 파일도 realpath로 저장되며 
		//그리하여 클라이언트는 접속할수 있는 홈의 위치를 realpath로 잡아 그곳에 접속하도록 설정한다 
		//그 접속한 공간에 클라이언트도 자신의 파일을 realpath에 올리므로 서버와 클라이언트 서로 파일 공유가 가능하다 
		//복사하는 경로를 d:/a.jpg 라고 설정해두면 그 클라이언트 페이지의  d드라이브 아래에서 파일을 찾기 실행하므로  사용하지 않는다.
		//그러므로 network경로를 설정하여 클라이언트가 파일을 찾아야한다 
		//->그 경로를 realpath(=webhome폴더 /클라이언트가 접속할 수 있는 최고 꼭대기)로 잡아두면 서버의 저장소에 접속된다.  
		
		String resourcePath=session.getServletContext().getRealPath("/resources"); 
		//home인 realpath에 모든 파일을 저장하면 자원들을 관리하기 불편하므로 resources라는 파일을 만들어 저장하도록 한다. 
		//계정별로 관리를 원할 경우 계정별로 파일의 이름을 다르게하여 서로다른 파일을 만들도록 하여 파일을 관리한다. 
		System.out.println(resourcePath);
		int maxSize=10*1024*1024; //10메가 

		try {
			MultipartRequest multi=new MultipartRequest(request,resourcePath,maxSize,"utf-8",new DefaultFileRenamePolicy()); 
			//라이브러리 cos.jar를 사용하여 MultipartRequest를 사용한다  클라이언트가 보내는 multipart형 데이터를 받을 수 없으므로 MultipartRequest를 이용하여 request를 받는다 
			//MultipartRequest가 parsing할 request,realpath 저장위치,사이즈, 인코딩,파일이름이 동일할경우의방법
			//multi 업로드된 파일이므로 이 파일을 
		    //인스턴스가 생성된 순간 서버에 "즉시" 파일이 업로드 된다 
		
//--------------------------------------cos.jar를 이용한 파일 업로드 -------------------------------------------------------------------
			
			/*
//	=> renameTo()는 신뢰할 수 없는 방법이므로 사용하지 않는것이 좋다. while를 계속 돌려서 ture를 return하여 그때 실행하도록 하는 방법을 선택하여도 믿을 수 없다!!
			boolean result=oriFile.renameTo(new File(resourcePath+"/test.png"));
			if(!result) { 
			DataInputStream dis=new DataInputStream(new FileInputStream(oriFile));
			byte[] fileContents =new byte[(int)oriFile.length()]; //parsing 
			dis.readFully(fileContents);
			DataOutputStream dos=new DataOutputStream(new FileOutputStream(new File(resourcePath+"/test.png")));
			dos.write(fileContents);
			dos.flush();
			dis.close();
			dos.close();
			oriFile.delete();}	//원래의 파일 delelte
			//String fileName=session.getAttribute("id")+"_profile.png"; //덮어쓰기로 파일이 업로드 된다 
			//String fielName="id_profile.png";
			//System.out.println(	oriFile.renameTo(new File("id_profile.png")));
			*/
			
			
			
//---------------------------------commons-io라이브러리 파일 사용 ----------------------------------------------------------------
	//		FileUtils.moveFile(oriFile, new File(resourcePath+"/"+System.currentTimeMillis()+"_id_profile.png"));
			// ctrl+x와 같이 잘라내기를 이용한 move를 하여 rename과 동일한 역할을 한다 
			//시간값을 주어 동일한 파일명이 없도록하여 파일을 업로드한다 
				
	
			
//---------------------------FileRenamePolicy() 오버라이딩 사용하기 ------------------------------------------------
		/*	MultipartRequest multi1=new MultipartRequest(request,resourcePath,maxSize,"utf-8",new FileRenamePolicy() {
				@Override
				public File rename(File arg0) {
					// TODO Auto-generated method stub
					return null;
				}
			}); 
			*/
				
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		} 
		return "home"; 
	}
	
	@RequestMapping("upload2.do")
	public String uploadProc(DTO dto)
	{
		System.out.println(dto.getName()); 
		System.out.println(dto.getImage());
		String uploadpath=session.getServletContext().getRealPath("resource");
		System.out.println(uploadpath);
		try {
			dto.getImage().transferTo(new File(uploadpath+"/profile.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "home";
	}
	
}
