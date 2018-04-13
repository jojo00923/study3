package com.study.servlet;

import java.io.FileInputStream;
import java.io.FileReader;
//520p 사용자가 주소를 입력하면 그 주소값을 받아오는애가 얘야..
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.member.web.MemberEditController;
import com.study.member.web.MemberListController;
import com.study.member.web.MemberViewController;

public class TestController extends HttpServlet {
	/**
	 * 컨트롤러(서블릿) 구현순서 
	 * 1단계. 사용자의 요청을 받음(웹 브라우저의 요청을 전달)
	 * 2단계. 사용자의 요청분석
	 *  3단계. 모델을 사용해서 기능 수행 (하나하나의 컨트롤러) 
	 *  4단계. 결과를 속성에 저장(request.session) 
	 *  5단계. 알맞은 뷰로 포워드
	 */

	// 533p 하고 똑같이 할거야 url, 컨트롤러 정보를 보관할 맵 지성:모든 컨트롤러 핸들러맵에 저장.
	private Map<String, IController> handlerMap = new HashMap<>(); 

	// 입출력프로그래밍 chapter 17

	@Override // init 드라이버 로딩할 때 쓰는거래..서블릿 로딩 서블릿을 초기화하려고 쓰는것.
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile"); // web.xml파일에서 세팅한 init-param에서 파일 configFile 받아옴.
		Properties prop = new Properties(); // 프로퍼티 자바객체 선언
		String configFilePath = getServletContext().getRealPath(configFile); // 루트밑에홈밑에계정밑에 쫒아가겠죠 물리적경로구함 resource 안에
		                                                                     // study_uri.properties의 실제 경로
		try (FileInputStream fis = new FileInputStream(configFilePath)) { // 해당되는파일 인풋스트림으로 읽음
			prop.load(fis); // 파일처리하기위해서 물리적인 절대경로를 끄집어내려고 한다.
		} catch (Exception e) {
			throw new ServletException(e);
		}

		// Iterator 어디에쓰는건지? 키랑 값을 불러올때 쓰는애임. 프로퍼티의 키와 값. 맵이랑 같은 구조니깐 쓸수있나봄.

		Iterator keyIter = prop.keySet().iterator(); // Properties에있는 애를 하나씩 꺼내오려고?
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();//키값가져옴.
			String handlerClassName = prop.getProperty(command); //getProperty는 밸류값을 가져옴

			try {
				// 컨트롤러 생성
				Class<?> handlerClass = Class.forName(handlerClassName); // study_uri.properties의 문자였던 밸류(오른쪽)값을 클래스로 만들어줌
				IController controller = (IController) handlerClass.newInstance();// 그 클래스로 인스턴스 객체를 만들어줌. 객체선언과 같은것(new)
				// 컨트롤러 맵에 저장
				handlerMap.put(command, controller); // 맵에 저장 요청한 정보를...
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.out.println(command + "를 로드하지 못했습니다." + e.getMessage());
			}
		}

	}
	
	@Override
	// 1단계. 사용자의 요청을 받음
	protected void service(HttpServletRequest request, HttpServletResponse response) //오버라이드 써있으니깐 위에 상속받은 HttpServlet의 메서드를 불러온거다. service는 doGet과 doPost를 둘다 받음.
	    throws ServletException, IOException {
		// 모든 페이지에 공통적인 부분 처리
		request.setCharacterEncoding("utf-8");

		// 2단계. 사용자의 요청분석
		// --파라미터: /member.nhn?type=list, /member?type=view
		// --요청 uri: /member.list, /member/view
		String uri = request.getRequestURI();
		// /Study/member/memberList.do uri가 이렇게 되어있다. 535p
		uri = uri.substring(request.getContextPath().length()); // uri가 사용자 요청한거다
		// uri = uri.substring(6) => /Study를 잘라내려고 하는것. request.getContextPath.length하면
		// 구할 수 있음.

		String viewPage = null;
		IController controller = null;

		// 3단계. 모델을 사용해서 기능 수행

		// 4단계. 결과를 속성에 저장(request.session)
		/*
		 * if(uri.equals("/member/memberList.do")) { controller = new
		 * MemberListController(); }else if(uri.equals("/member/memberView.do")) {
		 * controller = new MemberViewController(); }else
		 * if(uri.equals("/member/memberEdit.do")) { controller = new
		 * MemberEditController(); }else { throw new
		 * ServletException("지금은 memberList만.."); }
		 */
		if (handlerMap.containsKey(uri)) { // uri가지고있으면 컨트롤러가 있는것?
			controller = handlerMap.get(uri); // 지성:요청에 맞는 컨트롤러를 가져와서 저장~~ 맵의 키를 달라고 하면 되져 57line에서 저장했던 놈들을 가져온거임.. new를 왜 선언 안해주냐면 이미 위에서 해서!
			if (controller != null) {
				viewPage = controller.process(request, response); // 지성:해당 컨트롤러 작업 실행~~ iprocess 호출하면 문자열이 나오도록 약속함(?) = WEB-INF 안에 있는 jsp경로가 리턴되어서
				                                                  // 받아옴.
				// viewPage가 널이거나, 리다이렉트는 어떻게 처리할지도 if걸아야되는뎅 내일할거임..
		// 5단계. 알맞은 뷰로 포워드
		// 1. 해당 컨트롤러가 직접 출력을 한 경우 (다운로드나 엑셀파일을 직접 서블릿에서 만드는 경우, 이미지를 생성하는 경우...) =>
		// 뷰페이지 내부적으로 null로 리턴시킴.
		// 2. 리다이렉트 한 경우 viewPage가 "redirect: "으로 시작할 경우 지성:페이지만 이동
		if (viewPage != null) {
			System.out.println(uri + "viewPage=" + viewPage);
			if (viewPage.startsWith("redirect:")) {
				response.sendRedirect(request.getContextPath() + viewPage.substring(9)); //request.getContextPath()를 쓰는 이유는 직접적 경로가 아니라 /study로 들어오기때문에 붙여준다? //redirect:빼고하려고 9뺌.
			} else {
				// 해당 뷰페이지로 포워드 지성:request에 데이터 저장 후 이동
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		}
	} else {
		// 컨트롤러가 널인 경우
		throw new ServletException(uri + "의 컨트롤러가 널입니다."); // 아니면 상태코드로 던져도 됨.ㅋ
	}
} else {
	// 요청 uri가 없으므로 404 예외 던짐
	response.sendError(response.SC_NOT_FOUND, "누구셍ㅇㅇㅇㅇ여"); // response에는 200 sc_ok 등이 있음. response.SC_NOT_FOUND 가
	                                                       // 404임.
	                                                       // 404라고 써도 됨.
		}
	}
}
